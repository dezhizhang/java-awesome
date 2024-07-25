package shop.xiaozhi.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        // 先定义波兰表达式
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);

        int res = calculate(list);
        System.out.println(res);

    }

    // 将一个波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        // 将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();

        Collections.addAll(list, split);
        return list;
    }

    // 完成对逆波兰表达式的运算
    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<String>();
        for (String item : list) {
            //正则表过式来取数
            if (item.matches("\\d")) {
                stack.push(item);
            } else {
                // pop出两个数并运入再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());

                int result = 0;

                if (item.equals("+")) {
                    result = num1 + num2;
                } else if (item.equals("-")) {
                    result = num1 - num2;
                } else if (item.equals("*")) {
                    result = num1 * num2;
                } else if (item.equals("/")) {
                    result = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(result + "");

            }
        }
        return Integer.parseInt(stack.pop());
    }
}
