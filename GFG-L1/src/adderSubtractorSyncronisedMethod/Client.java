package adderSubtractorSyncronisedMethod;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newCachedThreadPool();
        Count count = new Count();
        Adder a = new Adder(count);
        Subtractor s = new Subtractor(count);
        Future<Integer> f1=ex.submit(a);
        Future<Integer> f2=ex.submit(s);
        f1.get();
        f2.get();
        System.out.println(count.value);

    }
}
