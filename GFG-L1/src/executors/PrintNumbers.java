package executors;

public class PrintNumbers implements Runnable {
    Integer noToPrint;
    public PrintNumbers(Integer noToPrint) {
        this.noToPrint = noToPrint;
    }
    @Override
    public void run() {

//        if(noToPrint==80){
//            System.out.println("hi");
//        }
        System.out.println(noToPrint+ " Thread name: " + Thread.currentThread().getName());
    }
}
