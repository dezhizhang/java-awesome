package shop.xiaozhicloud.singleton;

public class SingletonTest2 {
    public static void main(String[] args) {
        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton3 = Singleton2.getInstance();
        System.out.println(singleton2.hashCode() == singleton3.hashCode());
    }
}


class Singleton2 {
    private static Singleton2 instance;
    // 1. 构造器私有化，外部不能new
    private Singleton2() {

    }

    // 2. 本类内部创建对像实例
    static {
        instance = new Singleton2();
    }

    // 3. 提供一个公有的静态方法，返回实例对像
    public static Singleton2 getInstance() {
        return instance;
    }


}