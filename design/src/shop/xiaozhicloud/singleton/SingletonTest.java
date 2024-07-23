package shop.xiaozhicloud.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
        System.out.println(s1.hashCode() == s2.hashCode());
    }
}


//饿汉式(静态变量)
class Singleton {
    //  1. 构造器私有化，外部不能new
    private Singleton() {

    };
    // 2. 本类内部创建实例
    private final static Singleton instance = new Singleton();
    // 3. 提供一个公有的静态方法，返回实例对像
    public static Singleton getInstance() {
        return instance;
    }
}

