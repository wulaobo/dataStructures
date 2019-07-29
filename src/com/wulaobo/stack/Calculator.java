package com.wulaobo.stack;

//利用栈来实现一个简单的计算器
public class Calculator {

    public static void main(String[] args) {
        String expression = "19+6*6-50+5/5-6";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        String keepNum = "";
        //开始压栈
        while (true) {
            if(index>=expression.length()) {
                break;
            }
            int subExpr = expression.substring(index,index+1).charAt(0);
            //如果截取的字符是运算符
            if(isOper(subExpr)) {
                //判断符号栈是否为空
                if(operStack.isEmpty()) {
                    operStack.push(subExpr);
                }else{
                    //如果截取字符的优先级小于等于符号栈栈顶元素的优先级
                    if(getPriority(subExpr)<=getPriority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(subExpr);
                    }else {
                        operStack.push(subExpr);
                    }

                }
            }else{
                //截取的字符是数字,直接压入数栈
                if(index+1==expression.length()){
                    keepNum = keepNum + (subExpr-48);
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    int nextChar = expression.substring(index+1,index+2).charAt(0);
                    if(isOper(nextChar)) {
                        keepNum = keepNum + (subExpr-48);
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }else {
                        keepNum = keepNum + (subExpr-48);
                    }
                }


            }
            index++;
        }

        //开始遍历栈
        while (true) {
            if(operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("表达式%s=%d",expression,res);

    }

    //判断是否是运算符
    public static boolean isOper(int oper) {
        return oper=='+'||oper=='-'||oper=='*'||oper=='/';
    }

    //计算
    public static int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num2-num1;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
            default:
                break;
        }

        return res;
    }

    //判断运算符的优先级
    public static int getPriority(int oper){
        int res = 0;
        if(oper=='*'||oper=='/') {
            res = 1;
        }else if(oper=='+'||oper=='-') {
            res = 0;
        }else{
            res = -1;
        }
        return res;
    }


}

//用数组来实现栈
class ArrayStack2 {
    private int maxSize;//设置栈的大小
    private int[] stack;  //用来存放数据
    private int top = -1;  //栈顶

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断是否栈满
    public boolean isFull() {
        return top == maxSize-1;
    }

    //判断是否栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //压栈
    public void push(int data) {
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = data;
    }

    //弹栈
    public int pop() {
        if(isEmpty())
            throw new RuntimeException("栈空");

        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空");
            return;
        }

        for(int i = top;i>-1;i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }


    }

    //获取栈顶元素的值
    public int peek() {
        return stack[top];
    }



}

