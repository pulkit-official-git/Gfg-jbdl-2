package producerConsumerSemaphore;

import java.util.Set;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    Store store;
    Semaphore pS;
    Semaphore cS;

    public Consumer(Store store, Semaphore pS, Semaphore cS) {
        this.store = store;
        this.pS = pS;
        this.cS = cS;
    }

    @Override
    public void run() {
        while (true) {
            try {
                cS.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (store.items.size() > 0) {
                    store.removeItem();
            }
            pS.release();
        }

    }
}
