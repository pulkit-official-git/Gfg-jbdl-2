package adderSubtractorMutex;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newCachedThreadPool();
        Lock lock = new ReentrantLock();
        Count count = new Count();
        Adder a = new Adder(count,lock);
        Subtractor s = new Subtractor(count,lock);
        Future<Integer> f1=ex.submit(a);
        Future<Integer> f2=ex.submit(s);
        f1.get();
        f2.get();
        System.out.println(count.value);

    }
}
