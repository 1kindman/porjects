package com.chaoze.calculate;

import java.util.Stack;

/**
 * @Author: Leon
 * @Date: 2022/10/18/下午 08:05
 * @Description:用栈操作去完成计算 定义一个数栈 一个符号栈
 */
public class Calculate {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        Stack<Double> nums = new Stack<>();
        Stack<Character> chars = new Stack<>();
        String formula = "700.5+7*5+2/2*10=";//3+2*6-2";//
        int len = formula.length();
        System.out.println(len);
        double lastNum;//栈里面的上一个数
        double count = 0;
        double decimal = 1;//确定小数部分

        //小数部分的标志位 等于1说明后面的是小数了
        double pointKey = 0;
        for (int i = 0; i < len; i++) {
            char charAt = formula.charAt(i);
            if (calculate.isNum(charAt)&&pointKey==0) {
                count = count * 10 + (charAt - '0');
            } else if (charAt == '=') {
                nums.push(count);
                break;
            } else if (charAt == '.') {//小数部分的计算
                System.out.println("标志位pointKey打开");
                pointKey=1;
                decimal *= 10;
            } else if (pointKey==1&& calculate.isNum(charAt)) {
                System.out.println("当前的带小数部分的值为"+(charAt - '0') / decimal);
                count+=(charAt - '0') / decimal;
            } else {//如果这不是数字了 count =0;
                pointKey=0;
                nums.push(count);
                //判断是不是栈里面还没有东西
                //如果没有则直接压栈 70+7*5+2/2*10
                if (chars.isEmpty()) {
                    chars.push(charAt);
                } else {
                    //比较当前的符号优先级与栈里面的优先级
                    if (calculate.compare(chars.peek(), charAt)) {
                        double sum = calculate.clt(nums.pop(), nums.pop(), chars.pop());
                        nums.push(sum);
                        chars.push(charAt);
                    } else {
                        chars.push(charAt);
                    }
                }
                count = 0;

                //point = 1;
            }
        }
        double wu = 0;
        while (!(nums.isEmpty())) {
            double t2 = nums.pop();
            double t1 = nums.pop();
            wu += calculate.clt(t1, t2, chars.pop());

        }
        System.out.println(wu);
    }

    /**
     * @return boolean
     * @Description: 比较运算符的等级 如果返回真 那么就是应该计算栈里的数了
     * @author Leon
     * @date 221018 下午 08:14
     */
    public boolean compare(char c1, char c2) {//c1 是上一个
        char add = 1, sub = 1, mul = 2, div = 2;
        if (c1 == 0) {//如果c1=0 直接计算 说明前面没有数字
            return true;
        }
        switch (c1) {
            case '+':
                c1 = add;
                break;
            case '-':
                c1 = sub;
                break;
            case '*':
                c1 = mul;
                break;
            case '/':
                c1 = div;
                break;
        }
        switch (c2) {
            case '+':
                c2 = add;
                break;
            case '-':
                c2 = sub;
                break;
            case '*':
                c2 = mul;
                break;
            case '/':
                c2 = div;
                break;
        }
        if (c1 >= c2) {//- * 1 - 2 =-1
            return true;
        } else return false;
    }

    public boolean isNum(char c1) {
        if (c1 >= '0' && c1 <= '9') {
            return true;
        }
        return false;
    }

    public double clt(double d1, double d2, char c) {
        if (c == '+') {
            return d1 + d2;
        } else if (c == '-') {
            return d1 - d2;
        } else if (c == '*') {
            return d1 * d2;
        } else return d1 / d2;
        // return 0.0;
    }
}
