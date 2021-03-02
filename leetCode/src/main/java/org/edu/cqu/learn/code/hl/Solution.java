package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(-123)); //-321
        System.out.println(reverse(1534236469)); //0
        System.out.println(reverse(1463847412)); //2147483641
    }
    public static int reverse(int x) {
        int result = 0;
        while (x != 0){
            int a = x % 10;
            if( x > 0 && (Integer.MAX_VALUE - a ) / 10 < result) return 0;
            if( x < 0 && (Integer.MIN_VALUE - a ) / 10 > result) return 0;
            result = result * 10 + a;
            x = x/10;
        }
        return result;
    }

}

