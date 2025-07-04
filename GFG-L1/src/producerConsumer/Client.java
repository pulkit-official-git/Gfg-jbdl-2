package producerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Store store = new Store(5);
        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 1; i < 8; i++) {
            Producer producer = new Producer(store);
            ex.submit(producer);
        }

        for (int i = 1; i < 8; i++) {
            Consumer consumer = new Consumer(store);
            ex.submit(consumer);
        }
    }
}
