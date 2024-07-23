package shop.xiaozhicloud.singleton;

public class SingletonTest5 {
    public static void main(String[] args) {
        Singleton5 s1 = Singleton5.getInstance();
        Singleton5 s2 = Singleton5.getInstance();

        System.out.println(s1 == s2);
    }
}

// 双重检查
class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {}

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if(instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
