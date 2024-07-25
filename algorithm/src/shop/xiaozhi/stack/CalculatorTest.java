package shop.xiaozhi.stack;

public class CalculatorTest {
    public static void main(String[] args) {
        String expression = "120+0*6-2";

        // 创建两个栈，数栈和符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        // 定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = ""; // 用于拼接多位数
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            // 如果是运算符
            if (operStack.isOper(ch)) {
                // 判断当前符号栈是否为空
                if (!operStack.isEmpty()) {
                    // 如果符号栈有操作符，就进行比较，如果当前操作符的优先级小于或等于栈中的操作符，就需要从栈中pop出两个数
                    // 在从符号栈中pop出一个符号进行运算，将得到结果入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();

                        oper = operStack.pop();

                        res = numStack.cal(num1, num2, oper);

                        // 把运算符的结果入数据
                        numStack.push(res);
                        // 将当前操作符入符号栈
                        operStack.push(ch);
                    } else {
                        // 如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    // 如果为空就直接入符号栈
                    operStack.push(ch);
                }
            } else {
                // 如果是数则直接入数栈

//                numStack.push(ch - 48);
                //1当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2在处理数，需要向expression的表过式的index 后再看一位，如果是数就扫描，如果是符号才入栈
                //3需要定一个变量字符串用于拼接
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    // 判断一个字符是不是数字，如果是数字就继续扫描，
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        // 如果后一位是运算符，则入
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        // 当表过式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号并运行
        while (true) {
            // 如果符号栈为空，则计算得到结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();

            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res); // 入栈
        }

        System.out.printf("表达式%s=%d", expression, numStack.pop());

    }
}


class ArrayStack2 {
    private int maxSize; // 栈的大小
    private int[] stack; // 存放数据
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 返回栈顶的值,不是真正的pop
    public int peek() {
        return stack[top];
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈
    public int pop() {
        // 判断栈是不为空
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 显示栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    // 数字越大则优先级就越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    // 判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
