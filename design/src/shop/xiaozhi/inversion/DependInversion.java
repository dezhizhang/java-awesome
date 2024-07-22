package shop.xiaozhi.inversion;

public class DependInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());

        // 微信
        person.receive(new WeiXin());
    }
}

interface  IReceiver{
    public String getInfo();
}

class Email implements IReceiver{
    @Override
    public String getInfo() {
        return "电子邮箱信息：1541609448@qq.com";
    }
}

class WeiXin implements IReceiver{
    public String getInfo() {
        return "微信信息：15992478448";
    }
}

class Person {
    public void receive(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }
}




