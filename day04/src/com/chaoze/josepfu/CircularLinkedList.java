package com.chaoze.josepfu;

/**
 * @Author: Leon
 * @Date: 2022/10/18/下午 04:09
 * @Description:
 */
public class CircularLinkedList {
    //先创建一个first节点没有编号
    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < 0) {
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i < 6; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(boy);//形成环
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                curBoy = curBoy.getNext();
                curBoy.setNext(first);
            }

        }
    }

    public void listAll() {
        Boy temp = first;
        int key = 0;
        while (temp != null && key != 1) {
            System.out.println(temp);
            temp = temp.getNext();
            if (temp == first) {
                key++;
            }
        }
    }
    public void count(int key,int totalNums,int m) {//
        if (key <= 0 || key > totalNums || m < 0) {
            System.out.println("输入有误 请重新输入");
            return;
        }
        Boy help = first.getNext();//help 节点与一个 cur节点挨着
        while (help.getNext() != first) {
            help = help.getNext();
        }
        Boy cur = help.getNext();
        while (--key >= 1) {
            help = help.getNext();
            cur = cur.getNext();
            first = cur;
        }
        System.out.println(help+""+cur+"到这正确");
        while(cur.getNext()!=cur){
            for(int i = 0;i<m;i++){
                cur = cur.getNext();
                help = help.getNext();
                help.setNext(cur.getNext());
            }
            System.out.println("Boy"+cur+"out");
            cur = cur.getNext();
        }
        //System.out.println("fucking fucked");
        System.out.println(cur);

    }
}
