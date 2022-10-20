import java.util.Scanner;

class Client {

    public static void main(String[] args) {

        Controller controller = new Controller();
        TV tv = new TV();

        int[] channelList = new int[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            channelList[i] = scanner.nextInt();
        }

        Command turnOnTV = new TurnOnCommand(tv);
        turnOnTV.execute();
        /* write your code here */

        Command changeChannel;
        for (int i = 0; i < 3; i++) {
            changeChannel = new ChangeChannelCommand(new Channel(tv, channelList[i]));
            changeChannel.execute();
        }

        Command turnOffTV = new TurnOffCommand(tv);
        turnOffTV.execute();
        /* write your code here */
    }
}

class TV {

    Channel channel;

    void turnOn() {
        System.out.println("Turning on the TV");
        setChannel(new Channel(this, 0));
    }

    void turnOff() {
        System.out.println("Turning off the TV");
        /* write your code here */
    }

    void setChannel(Channel channel) {
        this.channel = channel;
    }
}

class Channel {
    private TV tv;
    private int channelNumber;

    Channel(TV tv, int channelNumber) {
        this.tv = tv;
        this.channelNumber = channelNumber;
        /* write your code here */
    }

    void changeChannel() {
        tv.setChannel(this);
        System.out.println("Channel was changed to " + channelNumber);
    }
}

interface Command {
    void execute();
    /* write your code here */
}

class TurnOnCommand implements Command {
    /* write your code here */
    TV tv;
    TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
        /* write your code here */
    }
}

class TurnOffCommand implements Command {
    /* write your code here */
    TV tv;
    TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
        /* write your code here */
    }
}

class ChangeChannelCommand implements Command {

    private Channel channel;

    ChangeChannelCommand(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void execute() {
        channel.changeChannel();
    }
    /* write your code here */
}

class Controller {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void executeCommand() {
        /* write your code here */
    }
}