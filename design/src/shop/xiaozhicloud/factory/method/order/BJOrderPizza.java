package shop.xiaozhicloud.factory.method.order;

import shop.xiaozhicloud.factory.method.BjCheesePizza;
import shop.xiaozhicloud.factory.method.BjPepperPizza;
import shop.xiaozhicloud.factory.method.Pizza;

public class BJOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BjCheesePizza();

        }else if(orderType.equals("pepper")){
            pizza = new BjPepperPizza();
        }
        return pizza;
    }
}
