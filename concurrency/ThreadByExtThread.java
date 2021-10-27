public class ThreadByExtThread {
    public static void main(String[] args) {
        ExtThread extThread = new ExtThread();
        extThread.start();

        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("MainThread: [" + i + "]");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Shutting down the main thread...");
    }
}

class ExtThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("ExtThread: [" + i + "]");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Shutting down the ExtThread...");
    }
}