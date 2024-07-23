package shop.xiaozhicloud.singleton;

public class SingletonTest7 {
    public static void main(String[] args) {
        Singleton7 s1 =Singleton7.INSTANCE;
        Singleton7 s2 =Singleton7.INSTANCE;


        System.out.println(s1.hashCode() == s2.hashCode());
    }
}

enum Singleton7{
    INSTANCE;
    public void sayOk() {
        System.out.println("sayOk");
    }
}