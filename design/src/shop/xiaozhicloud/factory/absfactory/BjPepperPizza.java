package shop.xiaozhicloud.factory.absfactory;

public class BjPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京胡椒pizza");
        System.out.println("北京胡椒pizza准备原材料");
    }

}
