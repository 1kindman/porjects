package com.chaoze.josepfu;

/**
 * @Author: Leon
 * @Date: 2022/10/18/下午 04:06
 * @Description:
 */
public class Boy {
    private int id;
    private Boy next;

    public Boy(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
