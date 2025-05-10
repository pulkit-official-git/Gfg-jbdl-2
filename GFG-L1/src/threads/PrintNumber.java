package threads;

public class PrintNumber implements Runnable {

    Integer noToPrint;
    public PrintNumber(Integer noToPrint) {
        this.noToPrint = noToPrint;
    }
    @Override
    public void run() {
        System.out.println(noToPrint + "Thread name" + Thread.currentThread().getName());
    }

}
