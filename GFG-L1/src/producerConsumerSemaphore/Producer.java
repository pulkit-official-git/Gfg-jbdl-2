package producerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    Store store;
    Semaphore pS;
    Semaphore cS;

    public Producer(Store store, Semaphore pS, Semaphore cS) {
        this.store = store;
        this.pS = pS;
        this.cS = cS;
    }

    @Override
    public void run() {

        while(true){
            try {
                pS.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (store.items.size() < store.getMaxSize()) {
                    store.addItem();
            }
            cS.release();
        }

    }
}
