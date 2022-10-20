package blockchain;

import blockchain.transaction.GenerateTransaction;
import blockchain.transaction.User;
import blockchain.utils.SerializationUtils;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        Command generateBlockChain = new GenerateBlockChain();

        executor.submit(() -> {
            while (!executor.isShutdown()) {
                User sender = BlockChain.users
                        .stream().filter(user -> user.getAccount() > 0)
                        .collect(Collectors.toList())
                        .get(getRandomNumber(0, BlockChain.users.size()));
                User recipient = BlockChain.users.stream()
                        .filter(user ->
                                !user.getUserName().equals(sender.getUserName()))
                        .collect(Collectors.toList())
                        .get(getRandomNumber(0, BlockChain.users.size() - 1));
                GenerateTransaction
                        .createNewTransaction(sender, recipient, getRandomNumber(1, sender.getAccount()));
                try {
                    Thread.sleep(10 );
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        List<BlockChain> blocks = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> {
            blocks.add(i, GenerateBlockChain.createNewBlock());
            final Object lock = new Object();

            AtomicBoolean isCalculated = new AtomicBoolean(false);
            Callable<String> callableTask = () -> {
                addUserIfNotExist("miner" + Thread.currentThread().getId());
                var minerAndHash = generateBlockChain.executeCalculatingOfHash(Thread.currentThread().getId(), blocks.get(i));
                synchronized (lock) {
                    if (!isCalculated.get()) {
                        var newBlock = blocks.get(i);
                        var lastBlock = i > 0 ? blocks.get(i - 1) : null;

                        GenerateBlockChain.addNewBlockToBlockChain(
                                newBlock,
                                lastBlock,
                                minerAndHash);
                        isCalculated.set(true);
                    }
                }
                return null;
            };

            List<Callable<String>> callableTasks = new ArrayList<>();
            IntStream.range(0,4).forEach(task -> callableTasks.add(callableTask));
            try {
                executor.invokeAny(callableTasks);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        shutDownThread(executor);

        File blockChainStorageFile = new File("BlockChain.txt");
        blockChainStorageFile.delete();
        blockChainStorageFile.createNewFile();

        SerializationUtils.serialize(BlockChain.blockChainList, blockChainStorageFile);

        List<BlockChain> blockChains = (List<BlockChain>) SerializationUtils.deserialize(blockChainStorageFile);
        blockChains.stream().forEach(blockChain ->
                System.out.println(blockChain.toString()));
    }

    private static void shutDownThread(ExecutorService executorService) throws InterruptedException {
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        }
    }

    private static void addUserIfNotExist(String name) {
        if (BlockChain.users.stream().filter(user -> user.getUserName().equals(name)).findFirst().isEmpty()) {
            BlockChain.users.add(User.createUserWithKeys(name));
        }
    }

    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}













