package shop.xiaozhicloud.factory.method.order;

import shop.xiaozhicloud.factory.method.LDCheesePizza;
import shop.xiaozhicloud.factory.method.LDPepperPizza;
import shop.xiaozhicloud.factory.method.Pizza;

public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        }else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
