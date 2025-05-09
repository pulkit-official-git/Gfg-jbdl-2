package generics;

public class Pair <V,S> {
    V first;
    S second;

    public void setV(V v){
        this.first = v;
    }

    public static <V> void does(V v){

    }

    public <V> void doingSomething(V v){

    }

    public <T> void doSomething(T t){

    }

}
