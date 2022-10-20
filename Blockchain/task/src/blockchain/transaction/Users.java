package blockchain.transaction;

import blockchain.transaction.TransactionDTO;
import blockchain.transaction.User;

import java.util.*;
import java.util.stream.Collectors;

public class Users {
    static List<String> names = Arrays.asList("Tom", "John", "Bob", "Kate");
    public static List<TransactionDTO> blockDataContainer = new ArrayList<>();

    public static List<User> getUsers() {
        return names.stream().map(n -> User.createUserWithKeys(n)).collect(Collectors.toList());
    }
}
