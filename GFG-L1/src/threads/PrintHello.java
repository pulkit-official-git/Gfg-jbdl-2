package threads;

public class PrintHello implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World " + Thread.currentThread().getName());
    }
}
