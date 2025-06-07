package adderSubtractorSyncronisedKeyword;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Integer> {
    Count count;

    public Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        synchronized (count) {
            for(int i=1;i<=10000;i++){
                count.value-=i;
            }
        }

        return count.value;
    }
}
