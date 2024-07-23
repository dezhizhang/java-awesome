package shop.xiaozhicloud.factory.method.order;

import shop.xiaozhicloud.factory.method.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract  public class OrderPizza {

    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            // 抽像方法由工厂子类实现
            pizza = createPizza(orderType);

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

        } while (true);
    }
    // 定义一个抽像方法 createPizza 让各个工厂子类自已实现
    abstract Pizza createPizza(String orderType);

    public String getType() {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            return in.readLine();
        }catch (IOException e) {
            System.out.println(e);
            return "";
        }
    }
}
