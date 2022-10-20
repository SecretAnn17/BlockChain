package blockchain;

import blockchain.transaction.Users;
import blockchain.transaction.VerifyTransactionMessage;
import blockchain.transaction.TransactionDTO;
import blockchain.utils.CalculationBlockUtil;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.math.BigInteger.ZERO;

class GenerateBlockChain implements Command {

    public static BlockChain createNewBlock() {
        BlockChain newBlock;
        if (!BlockChain.blockChainList.isEmpty()) {
            BlockChain lastBlock = BlockChain.blockChainList.get(BlockChain.blockChainList.size() - 1);
            newBlock = new BlockChain(
                    lastBlock.getHashOfBlock());
        } else {
            newBlock = new BlockChain(ZERO.toString());
        }
        return newBlock;
    }

    public static synchronized void addNewBlockToBlockChain(
            BlockChain newBlock,
            BlockChain lastBlock,
            Map<Long, HashWithMagicNumberDTO> minerAndHash) {

        if (BlockChain.blockChainList.isEmpty()) {
            newBlock = completeNewBlockWithHashAndTransactions(newBlock, null, minerAndHash);
            BlockChain.blockChainList.add(newBlock);
            recalculateZeroNumbers(newBlock);

        } else {
            if (lastBlock.getHashOfBlock().equals(newBlock.hashOfPreviousBlock)) {
                newBlock = completeNewBlockWithHashAndTransactions(newBlock, lastBlock, minerAndHash);
                BlockChain.blockChainList.add(newBlock);
                recalculateZeroNumbers(newBlock);
            }
        }
    }

    private static void recalculateZeroNumbers(BlockChain newBlock) {
        if (newBlock.getTimeToGenerateBlock() < 15) {
            BlockChain.numberOfZeros++; //comment here to avoid zero increasing
            newBlock.setStatusOfNumberOfZeros("N was increased to " + BlockChain.numberOfZeros);
        } else if (newBlock.getTimeToGenerateBlock() >= 15 && newBlock.getTimeToGenerateBlock() < 60) {
            newBlock.setStatusOfNumberOfZeros("N stays the same");
        } else {
            BlockChain.numberOfZeros--; //comment here to avoid zero increasing
            newBlock.setStatusOfNumberOfZeros("N was decreased by " + BlockChain.numberOfZeros);
        }
    }

    @Override
    public Map<Long, HashWithMagicNumberDTO> executeCalculatingOfHash(long threadId, BlockChain newBlock) {
        Map<Long, HashWithMagicNumberDTO> minerAndHash = new HashMap<>();
        minerAndHash.put(threadId, CalculationBlockUtil.hashWithMagicNumberDTO(
                newBlock.getId().toString() +
                        newBlock.getTimestamp() +
                        newBlock.getHashOfPreviousBlock()));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return minerAndHash;
    }

    private static BlockChain completeNewBlockWithHashAndTransactions(
            BlockChain newBlock,
            BlockChain lastBlock,
            Map<Long, HashWithMagicNumberDTO> minerAndHash
    ) {
        HashWithMagicNumberDTO hashDTO = minerAndHash.values().stream().findFirst().get();
        newBlock.setMagicNumber(hashDTO.getMagicNumber());
        newBlock.setHashOfBlock(hashDTO.getHashOfBlock());
        newBlock.setTimeToGenerateBlock(LocalTime.now().getSecond() - hashDTO.getTimeOfCreation().getSecond());
        newBlock.setMinorNumber(minerAndHash.keySet().stream().findFirst().get());
        if (lastBlock != null) {
            newBlock.setTransactionsOfTheBlock(getAllTransactionsDuringCalculatingBlock(
                    newBlock.getTimestamp(),
                    lastBlock.getTimestamp(),
                    newBlock.getId()));
        }
        return newBlock;
    }

    private static List<TransactionDTO> getAllTransactionsDuringCalculatingBlock(
            long timestamp,
            long previousBlockTimestamp,
            long blockId) {
        LocalTime timeOfBlockCreation = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalTime();
        LocalTime previousBlockTimeCreation = Instant.ofEpochMilli(previousBlockTimestamp).atZone(ZoneId.systemDefault()).toLocalTime();
        List<TransactionDTO> blockMessages = Users.blockDataContainer.stream()
                .filter(x ->
                        x.getTimeSent().compareTo(timeOfBlockCreation) < 0 &&
                                x.getTimeSent().compareTo(previousBlockTimeCreation) >= 0 &&
                                VerifyTransactionMessage.verifySignature(
                                        x.getMessage().getBytes(),
                                        x.getSign(),
                                        x.getSender().getPathToPublicKey()
                                )
                )
                .collect(Collectors.toList());
        if (blockMessages.size() > 0 && blockId > 1) {
            return blockMessages;
        } else return null;
    }

}
