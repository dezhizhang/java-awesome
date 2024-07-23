package shop.xiaozhicloud.factory.absfactory.order;

import shop.xiaozhicloud.factory.absfactory.Pizza;
import shop.xiaozhicloud.factory.absfactory.BjCheesePizza;
import shop.xiaozhicloud.factory.absfactory.BjPepperPizza;

public class BJFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {

        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BjCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new BjPepperPizza();
        }

        return pizza;
    }
}
