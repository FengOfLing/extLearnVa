package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(hasCycle(new ListNode(1,new ListNode(2))));
//        System.out.println( calculate("(1+(4+5+2)-3)+(6+8) ") );
        System.out.println( calculate("2147483647 ") );
        System.out.println(Integer.MAX_VALUE);
    }

    public static int calculate(String s) {
        char X = 'X';//X代表数字位
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> operator = new Stack<>();//只存 '+''-''(' 'X'
        for (int i = 0; i < s.length(); i++) {
            //数字位如数字栈
            if(isNum(s.charAt(i))){
                int num = 0, count = 0;
                while(isNum(s.charAt(i))){
                    num = (num * 10 + (s.charAt(i++) - '0'));
                    if(i >= s.length()){
                        break;
                    }
                }
                i--;
                nums.push(num);
                operator.push(X);
            }else{
                //计算括号内容 结果押入栈
                if( s.charAt(i) ==')'){
                    int cal = 0;
                    int rnum = 0;
                    while( operator.peek() != '('){
                        if(operator.peek() == X){
                            rnum = nums.pop();
                            operator.pop();
                            if( operator.peek() == '('){
                                cal += rnum;
                            }
                        }else {
                            cal += operator.peek() == '+' ? rnum:-rnum;
                            operator.pop();
                        }
                    }
                    operator.pop();
                    operator.push(X);
                    nums.push(cal);
                }else if(s.charAt(i) =='+' || s.charAt(i) =='-' || s.charAt(i) =='(') {
                    operator.push(s.charAt(i));
                }
            }
        }
        int result = 0;
        int rnum = 0;
        //操作栈里面应该只剩 +-X,计算结果即可
        while( !operator.isEmpty()){
            if(operator.peek() == X){
                rnum = nums.pop();
                operator.pop();
                if( operator.isEmpty()){
                    result += rnum;
                }
            }else{
                result += operator.peek() == '+' ? rnum:-rnum;
                operator.pop();
            }

        }
        return result;
    }
    public static boolean isNum(Character c){
        return c >= '0' && c <= '9';
    }

    public static boolean hasCycle(ListNode head) {
        //链表成环的判断是  在链表中有两个节点指向同一个节点。 一步两步走：一个指针步长1，一个指针步长2，如果2能反追到1表示成环；
        if( head == null ) return false;
        ListNode node1 = head;
        ListNode node2 = head;
        while( node2 != null && node2.next != null){
            node1 = node1.next;
            node2 = node2.next.next;
            if(node1 == node2){
                return true;
            }
        }
        return false;
    }

}

