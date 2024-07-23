package shop.xiaozhicloud.prototype;

public class SheepTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("tom", 1, "red");

        Object sheep1 = sheep.clone();

        System.out.println(sheep);
        System.out.println(sheep1);

    }
}
