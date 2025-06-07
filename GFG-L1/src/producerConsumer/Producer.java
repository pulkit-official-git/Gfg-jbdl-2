package producerConsumer;

public class Producer implements Runnable {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {

        while(true){
            synchronized (store) {

                if (store.items.size() < store.getMaxSize()) {
                    store.addItem();
                }
            }
        }

    }
}
