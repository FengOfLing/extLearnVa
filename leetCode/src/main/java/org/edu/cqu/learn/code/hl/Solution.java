package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println( longestCommonPrefix(new String[]{"dog","racecar","car"})); //58
        System.out.println( longestCommonPrefix(new String[]{"flower","flow","flight"})); //58
    }
    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        found:
        for ( ; i < strs[0].length() ; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if( i >= strs[j].length() || strs[j].charAt(i) != c ){
                    break found;
                }
            }
        }
        return i == 0 ? "" : strs[0].substring(0,i);
    }
}

