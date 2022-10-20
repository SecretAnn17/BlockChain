package blockchain.chat;

import blockchain.transaction.User;
import blockchain.utils.SignUtil;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageDTO implements Serializable {

    static final long serialVersionUID = 2L;
    private static final AtomicInteger incrementIdentifier = new AtomicInteger(0);
    int id;
    User user;
    String messageText;
    LocalTime timeSent;

    public byte[] getSign() {
        return sign;
    }

    byte[] sign;

    public User getUser() {
        return user;
    }

    public String getMessageText() {
        return messageText;
    }

    public MessageDTO(User user, String messageText) {
        this.id = incrementIdentifier.incrementAndGet();
        this.user = user;
        this.messageText = messageText;
        this.timeSent = LocalTime.now();
        try {
            this.sign = SignUtil.sign(messageText, user.getPathToPrivateKey());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LocalTime getTimeSent() {
        return timeSent;
    }
}
