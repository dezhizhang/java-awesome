package shop.xiaozhicloud.singleton;

public class SingletonTest4 {
    public static void main(String[] args) {
        Singleton4 s1 = Singleton4.getInstance();
        Singleton4 s2 = Singleton4.getInstance();

        System.out.println(s1 == s2);
    }
}


class Singleton4{
    private static Singleton4 instance;

    private Singleton4() {

    }

    public static synchronized Singleton4 getInstance() {
        if(instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}

