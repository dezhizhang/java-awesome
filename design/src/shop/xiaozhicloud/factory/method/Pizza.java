package shop.xiaozhicloud.factory.method;

public abstract class Pizza {
    protected String name;

    public abstract void prepare();

    public void bake() {
        System.out.println(this.name + " bake complete.");
    }

    public void cut() {
        System.out.println(this.name + " cut complete.");
    }

    public void box() {
        System.out.println(this.name + " box complete.");
    }

    public void setName(String name) {
        this.name = name;
    }

}