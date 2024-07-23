package shop.xiaozhicloud.principle;

public class SingleResponse {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("小汔车");
        vehicle.runAir("飞机");
        vehicle.runWater("轮船");
    }
}

class Vehicle {
   public void run(String vehicleName) {
       System.out.println(vehicleName + "在公路上运行...");
   }

   public void runAir(String vehicleName) {
       System.out.println(vehicleName + "在天空飞行...");
   }

   public void runWater(String vehicleName) {
       System.out.println(vehicleName + "在水中运行");
   }

}
