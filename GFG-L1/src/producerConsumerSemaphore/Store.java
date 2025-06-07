package producerConsumerSemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    private int maxSize;
//    List<Object> items;   /// not thread safe
    ConcurrentLinkedDeque<Object> items;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ConcurrentLinkedDeque<>();
    }
    public int getMaxSize() {
        return maxSize;
    }
    public void addItem(){
        System.out.println("Producer producing "+items.size()+" items");
        items.add(new Object());
    }

    public void removeItem(){
        System.out.println("Consumer consuming "+items.size()+" items");
        items.remove();
    }
}
