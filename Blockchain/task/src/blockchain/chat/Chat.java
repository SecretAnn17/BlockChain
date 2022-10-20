package blockchain.chat;

import blockchain.transaction.User;

import java.util.Random;

public class Chat {
    String name;

    public Chat(String name) {
        User.createUserWithKeys(name);
    }

    public static MessageDTO createMessage(User user) {
        return new MessageDTO(user, randomMessage());
    }
    private static String randomMessage() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
