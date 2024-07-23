package shop.xiaozhicloud.factory.absfactory.order;

import shop.xiaozhicloud.factory.absfactory.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
  AbsFactory factory;


  public OrderPizza(AbsFactory factory) {
      setFactory(factory);
  }

  private void setFactory(AbsFactory factory) {
      Pizza pizza = null;
      String orderType = "";
      this.factory = factory;

      do {
          orderType = getType();
          pizza = factory.createPizza(orderType);

          if(pizza != null) {
              pizza.prepare();
              pizza.bake();
              pizza.cut();
              pizza.box();
          }else{
              System.out.println("订购失败");
              break;
          }
      }while (true);
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
