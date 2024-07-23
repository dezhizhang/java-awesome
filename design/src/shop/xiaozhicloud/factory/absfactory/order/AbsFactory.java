package shop.xiaozhicloud.factory.absfactory.order;

import shop.xiaozhicloud.factory.absfactory.Pizza;

public interface AbsFactory {
    public Pizza createPizza(String orderType);
}
