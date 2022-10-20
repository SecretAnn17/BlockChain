public class Main {
    public static void main(String[] args) {
        Thread thread1 = new WorkerThread("worker-1");
        Thread thread2 = new WorkerThread("worker-2");

        thread1.start();
        thread2.start();

        // create instances and start threads here
    }
}

// Don't change the code below
class WorkerThread extends Thread {
    private static final int NUMBER_OF_LINES = 3;

    public WorkerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (!name.startsWith("worker-")) {
            return;
        }

        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            System.out.println("do something...");
        }
    }
}