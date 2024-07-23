package shop.xiaozhicloud.factory.method.order;

import shop.xiaozhicloud.factory.method.LDCheesePizza;
import shop.xiaozhicloud.factory.method.LDPepperPizza;
import shop.xiaozhicloud.factory.method.Pizza;

public class LDOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String pizzaName) {
        Pizza pizza = null;
        if(pizzaName.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if(pizzaName.equals("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
