public class JoinThread {
    public static void main(String[] args) {
        NewThread nt1 = new NewThread("ONE");
        NewThread nt2 = new NewThread("TWO");
        NewThread nt3 = new NewThread("THREE");

        nt1.t.start();
        nt2.t.start();
        nt3.t.start();

        try {
            nt1.t.join();
            nt2.t.join();
            nt3.t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Main thread shutting down...");
    }
}
