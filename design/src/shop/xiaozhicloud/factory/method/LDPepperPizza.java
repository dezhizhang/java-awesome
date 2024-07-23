package shop.xiaozhicloud.factory.method;

public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的胡椒pizza");
        System.out.println("伦敦的胡椒pizza准备原材料");
    }
}
