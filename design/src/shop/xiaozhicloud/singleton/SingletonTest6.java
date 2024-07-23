package shop.xiaozhicloud.singleton;

public class SingletonTest6 {
    public static void main(String[] args) {
        Singleton6 s1 = Singleton6.getInstance();
        Singleton6 s2 = Singleton6.getInstance();


        System.out.println(s1.hashCode() == s2.hashCode());
    }
}

// 静态内部内完成
class Singleton6{
    private Singleton6() {

    }

    private static class SingletonInstance{
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
