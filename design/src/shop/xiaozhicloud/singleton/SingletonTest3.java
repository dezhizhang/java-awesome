package shop.xiaozhicloud.singleton;

public class SingletonTest3 {
    public static void main(String[] args) {
        Singleton3 s1 = Singleton3.getInstance();
        Singleton3 s2 = Singleton3.getInstance();

        System.out.println(s1.hashCode() == s2.hashCode());
    }
}


// 懒汉式
class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {

    }
    public static Singleton3 getInstance() {
        if(instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}