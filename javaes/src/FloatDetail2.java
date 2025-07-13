public class FloatDetail2 {
    public static void main(String[] args) {
        double num1 = 2.7;
        double num2 = 8.1 / 3;


        // 当我们对运行结果是小数的结果进行相等比较，要小心
        System.out.println("num1:" + num1);
        System.out.println("num2:" + num2);

        if (Math.abs(num1 - num2) < 0.00001) {
            System.out.println("相等");
        } else {
            System.out.println("不相等");
        }

//        System.out.println(Math.abs(num1 - num2));
    }
}
