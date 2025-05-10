package executors;

import threads.PrintNumber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(10);
//        ExecutorService ex = Executors.newCachedThreadPool();
        for(int i=1;i<=100;i++){
            PrintNumber printNumber = new PrintNumber(i);
            ex.submit(printNumber);
//        }
//        byte x=6;
//        int y=2;
//        while(x++>5){
//            System.out.println(x);
        }
    }
}
