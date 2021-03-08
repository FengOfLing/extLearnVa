package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0p"));

    }

    public static boolean isPalindrome(String s) {
        String lowwer = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while( i < j){
            while( i < j && !isValid(lowwer.charAt(i))){
                i++;
            }
            while(i < j && !isValid(lowwer.charAt(j) )){
                j--;
            }
            if( i < j && lowwer.charAt(i) != lowwer.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isValid( char c){
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}

