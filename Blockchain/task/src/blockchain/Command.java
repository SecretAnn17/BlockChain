package blockchain;

import java.util.List;
import java.util.Map;

interface Command {
    Map<Long, HashWithMagicNumberDTO> executeCalculatingOfHash(long threadId, BlockChain blockChain);
}
