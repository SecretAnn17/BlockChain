package blockchain.transaction;

import blockchain.utils.SignUtil;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionDTO implements Serializable {

    static final long serialVersionUID = 3L;
    private static final AtomicInteger incrementIdentifier = new AtomicInteger(0);
    int id;
    User sender;
    String message;
    LocalTime timeSent;

    public byte[] getSign() {
        return sign;
    }

    byte[] sign;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeSent(LocalTime timeSent) {
        this.timeSent = timeSent;
    }

    public void setSign(byte[] sign) {
        this.sign = sign;
    }

    public TransactionDTO(User sender, String message) {
        this.id = incrementIdentifier.incrementAndGet();
        this.timeSent = LocalTime.now();
        this.sender = sender;
        this.message = message;
        try {
            this.sign = SignUtil.sign(message, sender.getPathToPrivateKey());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LocalTime getTimeSent() {
        return timeSent;
    }
}
