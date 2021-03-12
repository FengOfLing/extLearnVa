package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        System.out.println( reverseBits(245017234) );
        System.out.println( reverseBits(-3) );
    }
    public static int reverseBits(int n) {
        int result = 0;
        if( n > 0 ) {
            for (int i = 32; i > 0; i--) {
                result = (result << 1) + (n % 2);
                n = n >> 1;
            }
        }else if( n < 0){
            n = -n-1;
            for (int i = 31; i > 0 ; i--) {
                result = (result << 1) + ( n % 2 == 0 ? 1 : 0);
                n = n >> 1;
            }
            result = (result << 1) + 1;
        }
        return result;
    }
}

