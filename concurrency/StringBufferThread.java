public class StringBufferThread{
    public static void main(String[] args) {
        StringBuffer shared = new StringBuffer();
        NThread nthread = new NThread("One", shared);
        NThread nthread2 = new NThread("Two", shared);

        nthread.t.start();
        nthread2.t.start();

        try {
            nthread.t.join();
            nthread2.t.join();
            for (int i = 0; i < 5; i++) {
                shared.append("Main:[" + i + "]\n");
                System.out.println(shared + "\n" + shared.capacity());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }    
    }
}
