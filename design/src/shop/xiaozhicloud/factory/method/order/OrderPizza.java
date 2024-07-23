package shop.xiaozhicloud.factory.method.order;

import shop.xiaozhicloud.factory.method.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class OrderPizza {
   abstract Pizza createPizza(String pizzaName);

   public OrderPizza() {
       Pizza pizza = null;
       String pizzaName = null;

       do{
           pizzaName = getType();
           pizza = createPizza(pizzaName);
           pizza.prepare();
           pizza.bake();
           pizza.cut();
           pizza.box();

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
