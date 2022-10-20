package com.chaoze.josepfu;

/**
 * @Author: Leon
 * @Date: 2022/10/18/下午 04:06
 * @Description:
 */
public class Josepfu {


    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addBoy(9);
        cll.listAll();
        cll.count(1,5,2);
    }
}
