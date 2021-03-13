package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        System.out.println( isHappy(19) );
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // 返回 True
        myHashSet.contains(3); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // 返回 True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // 返回 False ，（已移除）
    }
    public static boolean isHappy(int n){
        Map<Integer,Integer> map = new HashMap<>();
        while( n != 1 && map.get(n) == null){
            map.put(n,1);
            n = getNextNum( n );
        }
        return n == 1;
    }

    public static int getNextNum(int num ) {
        int sum = 0;
        while( num != 0){
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}

