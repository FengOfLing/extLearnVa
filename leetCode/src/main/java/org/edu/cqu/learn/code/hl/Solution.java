package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = mergeTwoLists(node,node2 ); //1 1 2 3 4 4
        System.out.println("OVER");
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if( l2 == null ){
            return l1;
        }
        if( l1 == null ){
            return l2;
        }
        if(l1.val > l2.val ){
            return mergeTwoLists(l2,l1);
        }
        ListNode another ;
        ListNode current ;
        if(l1.next == null || l1.next.val > l2.val ){
            current = l2;
            another = l1.next;
            l1.next = current;
        }else{
            current = l1.next;
            another = l2;
            l1.next = current;
        }
        mergeTwoLists(current,another);
        return l1;
    }
}

