package shop.xiaozhicloud.factory.method.order;

import shop.xiaozhicloud.factory.method.BjCheesePizza;
import shop.xiaozhicloud.factory.method.BjPepperPizza;
import shop.xiaozhicloud.factory.method.Pizza;

public class BJOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String pizzaName) {
        Pizza pizza = null;
        if(pizzaName.equals("cheese")){
            pizza = new BjCheesePizza();
        }else if(pizzaName.equals("pepper")){
            pizza = new BjPepperPizza();
        }
        return pizza;
    }
}
