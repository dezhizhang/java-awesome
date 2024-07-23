package shop.xiaozhicloud.factory.absfactory.order;

public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
