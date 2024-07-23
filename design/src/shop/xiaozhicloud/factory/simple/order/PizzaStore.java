package shop.xiaozhicloud.factory.simple.order;

import shop.xiaozhicloud.factory.simple.SimpleFactory;

public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new SimpleFactory());
    }
}
