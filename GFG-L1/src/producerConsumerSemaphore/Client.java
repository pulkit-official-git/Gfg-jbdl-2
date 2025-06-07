package producerConsumerSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Store store = new Store(5);
        Semaphore pS = new Semaphore(5);
        Semaphore cS = new Semaphore(0);
        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 1; i < 7; i++) {
            Producer producer = new Producer(store,pS,cS);
            ex.submit(producer);
        }

        for (int i = 1; i < 12; i++) {
            Consumer consumer = new Consumer(store,pS,cS);
            ex.submit(consumer);
        }
    }
}
