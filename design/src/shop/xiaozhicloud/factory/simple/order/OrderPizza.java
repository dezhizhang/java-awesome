package shop.xiaozhicloud.factory.simple.order;

import shop.xiaozhicloud.factory.simple.Pizza;
import shop.xiaozhicloud.factory.simple.SimpleFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class OrderPizza {

    // 定义一个简单工厂对像
    Pizza pizza = null;
    SimpleFactory simpleFactory;


    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory) {
        String orderType = "";

        this.simpleFactory = simpleFactory;

        do {
            orderType = getType();
            System.out.println(orderType);
            pizza = this.simpleFactory.createPizza(orderType);
            if(pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购失败");
            }

        }while(true);
    }

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