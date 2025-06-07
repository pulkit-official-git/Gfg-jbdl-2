package producerConsumer;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int maxSize;
    List<Object> items;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>(maxSize);
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
        items.remove(items.size()-1);
    }
}
