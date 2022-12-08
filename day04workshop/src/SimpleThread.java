package src;

public class SimpleThread extends Thread {
    
    @Override
    public void run() {
        System.out.println("Thread started execution + " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // wait for some time
        System.out.println("Thread stopped execution + " + Thread.currentThread().getName());
    }

}
