package singleton;

public class RedisCache {

    String url;
    String userName;
    String password;
    Integer portNo;

    private RedisCache(String url, String userName, String password, Integer portNo) {
        this.url = url;
        this.userName = userName;
        this.password = password;
        this.portNo = portNo;
    }
//    private static RedisCache instance = new RedisCache("url","userName","password",null);  //eager loading auto thread safe
    private static RedisCache instance = null;
    public static RedisCache getInstance(){
        if(instance == null){
            synchronized (RedisCache.class){
                if(instance == null){
                    instance = new RedisCache("url","userName","password",null);
                }
            }
        }
        return instance;
    }


}
