package blockchain.utils;

import blockchain.BlockChain;
import blockchain.HashWithMagicNumberDTO;

import java.time.LocalTime;
import java.util.regex.Pattern;

import static blockchain.utils.StringUtil.applySha256;

public class CalculationBlockUtil {
    public static Long generateMagicNumber(){
        int min = 1000;
        int max = 9000;
        return (long)(Math.random()*(max-min+1)+min);
    };
    public static HashWithMagicNumberDTO hashWithMagicNumberDTO(String input) {

        HashWithMagicNumberDTO hashWithMagicNumberDTO = new HashWithMagicNumberDTO();
        hashWithMagicNumberDTO.setTimeOfCreation(LocalTime.now());

        long magicNumber = 0;

        Pattern pattern = Pattern.compile("^0{"+ BlockChain.numberOfZeros+"}.*");
        Boolean isHashCodeMatchesThePatter = false;
        String valueOfHashOfBlock = "";

        while (isHashCodeMatchesThePatter != true){
            magicNumber = generateMagicNumber();
            valueOfHashOfBlock = applySha256(input+magicNumber);
            isHashCodeMatchesThePatter = pattern.matcher(valueOfHashOfBlock).matches();
        }

        hashWithMagicNumberDTO.setMagicNumber(magicNumber);
        hashWithMagicNumberDTO.setHashOfBlock(valueOfHashOfBlock);

        return hashWithMagicNumberDTO;
    }
}
