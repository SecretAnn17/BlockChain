package blockchain.transaction;

import static blockchain.transaction.Users.blockDataContainer;
import static java.lang.String.format;

public class GenerateTransaction {

    final static String TRANSACTION_MESSAGE_FORMAT = "%s sent %d VC to %s";

    public static void createNewTransaction(User sender, User recipient, int coinsAmount) {
        if (sender.getAccount() >= coinsAmount) {
            sender.decreaseUserAccount(coinsAmount);
            recipient.increaseUserAccount(coinsAmount);
            String transactionMessage = format(TRANSACTION_MESSAGE_FORMAT, sender.getUserName(), coinsAmount, recipient.getUserName());
            blockDataContainer.add(new TransactionDTO(sender, transactionMessage));
        }
    }
}
