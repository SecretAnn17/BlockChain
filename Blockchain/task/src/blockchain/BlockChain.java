package blockchain;

import blockchain.transaction.Users;
import blockchain.transaction.TransactionDTO;
import blockchain.transaction.User;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class BlockChain implements Serializable {

    static final long serialVersionUID = 1L;

    private static final AtomicLong incrementIdentifier = new AtomicLong(0);
    Long id;
    Long timestamp;
    Long magicNumber;
    String hashOfPreviousBlock;
    String hashOfBlock;
    int timeToGenerateBlock;
    String statusOfNumberOfZeros;
    List<TransactionDTO> transactionsOfTheBlock;
    long minorNumber;
    static volatile List<BlockChain> blockChainList = new LinkedList<>();
    public static volatile int numberOfZeros = 0;
    static List<User> users = Users.getUsers();

    public void setTransactionsOfTheBlock(List<TransactionDTO> transactionsOfTheBlock) {
        this.transactionsOfTheBlock = transactionsOfTheBlock;
    }

    public BlockChain(String hashOfPreviousBlock) {
        this.id = incrementIdentifier.incrementAndGet();;
        this.timestamp = new Date().getTime();
        this.hashOfPreviousBlock = hashOfPreviousBlock;
    }
    public long getMinorNumber() {
        return minorNumber;
    }

    public void setMinorNumber(Long minorNumber) {
        this.minorNumber = minorNumber;
    }
    public String getStatusOfNumberOfZeros() {
        return statusOfNumberOfZeros;
    }

    public void setStatusOfNumberOfZeros(String statusOfNumberOfZeros) {
        this.statusOfNumberOfZeros = statusOfNumberOfZeros;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    public Long getMagicNumber() {
        return magicNumber;
    }

    public String getHashOfPreviousBlock() {
        return hashOfPreviousBlock;
    }

    public void setHashOfPreviousBlock(String hashOfPreviousBlock) {
        this.hashOfPreviousBlock = hashOfPreviousBlock;
    }

    public String getHashOfBlock() {
        return hashOfBlock;
    }

    public void setHashOfBlock(String hashOfBlock) {
        this.hashOfBlock = hashOfBlock;
    }

    public void setMagicNumber(Long magicNumber) {
        this.magicNumber = magicNumber;
    }

    public int getTimeToGenerateBlock() {
        return timeToGenerateBlock;
    }

    public void setTimeToGenerateBlock(int timeToGenerateBlock) {
        this.timeToGenerateBlock = timeToGenerateBlock;
    }

    public static List<BlockChain> getBlockChainList() {
        return blockChainList;
    }

    public static void setBlockChainList(List<BlockChain> blockChainList) {
        BlockChain.blockChainList = blockChainList;
    }

    private User getUserByName(String name) {
        return users.stream().filter(user -> user.getUserName().equals(name)).findFirst().get();
    }

    public static Boolean validate(){
        for(int i = 0; i < blockChainList.size() - 1; i++) {
            if(!blockChainList.get(i+1).getHashOfPreviousBlock().equals(blockChainList.get(i).getHashOfBlock())){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String messages = transactionsOfTheBlock !=null? transactionsOfTheBlock.stream()
                .map(n -> n.getMessage())
                .collect(Collectors.joining("\n")):"no message";
        return "Block:" + '\n' +
                "Created by miner" + getMinorNumber() + '\n' +
                "miner" + getMinorNumber() + " gets 100 VC" + '\n' +
                "Id: "+ getId() + '\n' +
                "Timestamp: " + getTimestamp() + '\n' +
                "Magic number: " + getMagicNumber() + '\n' +
                "Hash of the previous block: " + '\n' +
                getHashOfPreviousBlock() + '\n' +
                "Hash of the block: " + '\n' +
                getHashOfBlock() + '\n' +
                "Block data: " + '\n' +
                messages + '\n' +
                "Block was generating for " + getTimeToGenerateBlock() +  " seconds" + '\n' +
                getStatusOfNumberOfZeros() + '\n';
    }
}
