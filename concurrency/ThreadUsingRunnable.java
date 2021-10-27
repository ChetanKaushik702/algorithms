class NewThread implements Runnable {
    String name;
    Thread t;

    public NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
    }


    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(name + ": [" + i + "]");
                Thread.sleep(500);
            }
            
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        finally {
            System.out.println("Shutting down the new thread...");
        }
    }
    
}

public class ThreadUsingRunnable {

    public static void main(String[] args) {
        NewThread newThread = new NewThread("Demo");
        newThread.t.start();

        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i + " + " + i + " = " + (i << 1));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Shutting down the main thread...");
    }
}