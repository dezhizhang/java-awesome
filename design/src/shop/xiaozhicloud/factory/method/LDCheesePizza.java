package shop.xiaozhicloud.factory.method;

public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦奶酪pizza");
        System.out.println("伦敦奶酪准备原材料pizza");
    }
}
