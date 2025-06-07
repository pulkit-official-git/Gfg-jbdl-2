package adderSubtractorSyncronisedMethod;

import java.util.concurrent.Callable;

public class Adder implements Callable<Integer> {
    Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        for(int i=1;i<=10000;i++){
            count.incrementByX(i);
        }
        return count.value;
    }
}
