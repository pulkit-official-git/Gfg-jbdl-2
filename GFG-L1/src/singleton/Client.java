package singleton;

public class Client {
    public static void main(String[] args) {
        RedisCache rc = RedisCache.getInstance();
        System.out.println(rc);
        Temp temp = new Temp();
        temp.show();
    }
}
