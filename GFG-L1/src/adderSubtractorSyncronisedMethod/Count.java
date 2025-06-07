package adderSubtractorSyncronisedMethod;

public class Count {
    Integer value=0;

    public synchronized void incrementByX(int x){
        value+=x;
    }
    public synchronized void decrementByX(int x){
        value-=x;
    }
}
