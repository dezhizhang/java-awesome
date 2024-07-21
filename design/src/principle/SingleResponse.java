package principle;

public class SingleResponse {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("小汔车");
    }
}

class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行");
    }
}
