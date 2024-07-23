package shop.xiaozhicloud.factory.simple;

public class SimpleFactory {
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        }
        return  pizza;
    }
}


