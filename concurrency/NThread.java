public class NThread implements Runnable{
    String name;
    StringBuffer shared;
    Thread t;

    NThread(String name, StringBuffer shared) {
        this.name = name;
        this.shared = shared;
        t = new Thread(this, name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                shared.append(name + ":[" + i + "]\n");
                shared.replace(0, 8, "replaced");
                System.out.println(shared + "\n" + shared.capacity());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }    
    }
    
}
