package evenOdd;

public class PrintEvenOdd implements Runnable{
    boolean isEven;

    public PrintEvenOdd(boolean isEven) {
        this.isEven = isEven;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            if(isEven && i % 2 == 0) {
                System.out.println(i + " Thread name: " + Thread.currentThread().getName());
            }else{
                System.out.println(i + " Thread name: " + Thread.currentThread().getName());
            }
//            } else if (!isEven && i%2!=0) {
//                System.out.println(i + " Thread name: " + Thread.currentThread().getName());
//            }
        }
    }
}
