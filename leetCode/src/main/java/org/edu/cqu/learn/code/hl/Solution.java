package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println( romanToInt("LVIII")); //58
        System.out.println( romanToInt("IX")); //9
        System.out.println( romanToInt("MCMXCIV")); //1994
    }
    public static int romanToInt(String s) {
        int result = 0;
        int currentVal = -1;

        //由右向左遍历，如果左边的始终比当前的val表示的值小，那就减 ，大就加
        for (int i = s.length()-1; i >= 0; i--) {
            int val = getVal(s.charAt(i));
            if(val >= currentVal){
                result += val;
                currentVal = val;
            }else{
                result -= val;
            }
        }
        return result;
    }
    public static int getVal( char c){
        if( c == 'I') return 1;
        if( c == 'V') return 5;
        if( c == 'X') return 10;
        if( c == 'L') return 50;
        if( c == 'C') return 100;
        if( c == 'D') return 500;
        if( c == 'M') return 1000;
        return 0;
    }
}

