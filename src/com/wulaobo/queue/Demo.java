package com.wulaobo.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo {

    public static void main(String[] args) {
        String expression = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        System.out.println("中缀List:"+getInfixList(expression));
        System.out.println("后缀List:"+toSuffixList(getInfixList(expression)));


    }

    //将中缀表达式转为后缀表达式
    public static List<String> toSuffixList(List<String> ls) {
        //1.初始化栈
        //运算符栈
        Stack<String> s1 = new Stack<>();
        //中间结果List
        List<String> s2 =new ArrayList<>();
        //2.遍历中缀表达式
        for (String item:ls) {
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")) {
                s1.push(item);
            }else if(item.equals(")")) {
                while (s1.size()>0&&!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                //弹出左括号
                s1.pop();
            }else{
                //此时,item为操作符
                if(s1.empty()||s1.peek().equals("(")) {
                    s1.push(item);
                }else if(Operation.getPriority(item)>Operation.getPriority(s1.peek())){
                    s1.push(item);
                }else{
                    while (!s1.isEmpty()&&Operation.getPriority(item)<=Operation.getPriority(s1.peek())){
                        s2.add(s1.pop());
                    }
                    s1.push(item);
                }
            }
        }

        while (!s1.isEmpty()){
            s2.add(s1.pop());
        }

        return s2;
    }


    public static List<String> getInfixList(String expression) {
        String[] stringArr = expression.split(" ");
        List<String> list = new ArrayList<>();
        for (String str:stringArr) {
            list.add(str);
        }

        return list;
    }


}

//比较运算符的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getPriority(String str) {
        int result = 0;
        switch (str) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("输入的运算符不合法");
                break;
        }
        return result;
    }

}

