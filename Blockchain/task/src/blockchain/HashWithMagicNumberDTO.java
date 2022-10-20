package blockchain;

import java.time.LocalTime;

public class HashWithMagicNumberDTO {
    Long magicNumber;
    int timeTaken;
    String hashOfBlock;
    String statusOfNumberOfZeros;
    LocalTime timeOfCreation;

    public LocalTime getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(LocalTime timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public String getStatusOfNumberOfZeros() {
        return statusOfNumberOfZeros;
    }

    public void setStatusOfNumberOfZeros(String statusOfNumberOfZeros) {
        this.statusOfNumberOfZeros = statusOfNumberOfZeros;
    }

    public void setMagicNumber(Long magicNumber) {
        this.magicNumber = magicNumber;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }

    public void setHashOfBlock(String hashOfBlock) {
        this.hashOfBlock = hashOfBlock;
    }

    public Long getMagicNumber() {
        return magicNumber;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public String getHashOfBlock() {
        return hashOfBlock;
    }
}
