package com.chaoze.test;

import com.chaoze.calculate.Calculate;

import java.util.Stack;

/**
 * @Author: Leon
 * @Date: 2022/10/19/下午 07:42
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

        Calculate calculate = new Calculate();
        System.out.println(calculate.compare('+', '*'));
        System.out.println(calculate.clt(1.0,2.0,'/'));
        Stack test = new Stack();
        test.push(1);
        test.push(2);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(calculate.isNum('+'));
    }
}
