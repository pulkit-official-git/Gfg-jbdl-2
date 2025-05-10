package evenOdd;

public class Client {
    public static void main(String[] args) {
        PrintEvenOdd evenNo = new PrintEvenOdd(true);
        PrintEvenOdd oddNo = new PrintEvenOdd(false);

        Thread t1 = new Thread(evenNo,"Even-Thread");
        Thread t2 = new Thread(oddNo,"Odd-Thread");
        t1.start();
        t2.start();
    }
}
