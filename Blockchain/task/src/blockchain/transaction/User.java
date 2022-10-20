package blockchain.transaction;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class User implements Serializable {
    String userName;
    String pathToPrivateKey;
    String pathToPublicKey;

    int account = 100;

    public User(String userName, String pathToPrivateKey, String pathToPublicKey) {
        this.userName = userName;
        this.pathToPrivateKey = pathToPrivateKey;
        this.pathToPublicKey = pathToPublicKey;
    }

    public static User createUserWithKeys(String name) {
        GenerateKeys gk;
        String pathToPublicKey = "KeyPair/" + name + ".publicKey";
        String pathToPrivateKey = "KeyPair/" + name + ".privateKey";
        try {
            gk = new GenerateKeys(1024);
            gk.createKeys();
            gk.writeToFile(pathToPublicKey, gk.getPublicKey().getEncoded());
            gk.writeToFile(pathToPrivateKey, gk.getPrivateKey().getEncoded());
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new User(name, pathToPrivateKey, pathToPublicKey);
    }

    public void increaseUserAccount(int coins){
        this.setAccount(this.getAccount()+coins);
    }

    public void decreaseUserAccount(int coins){
        this.setAccount(this.getAccount()-coins);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPathToPrivateKey() {
        return pathToPrivateKey;
    }

    public void setPathToPrivateKey(String pathToPrivateKey) {
        this.pathToPrivateKey = pathToPrivateKey;
    }

    public String getPathToPublicKey() {
        return pathToPublicKey;
    }

    public void setPathToPublicKey(String pathToPublicKey) {
        this.pathToPublicKey = pathToPublicKey;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
