package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(strStr("hello","ll"));//2
//        System.out.println(strStr("a","a"));//0
//        System.out.println(addBinary("100","110010"));//1110110
//        System.out.println(addBinary("101111","10"));//110001
        System.out.println( ((Double) Math.sqrt( 0)).intValue());
    }

    public static String addBinary(String a, String b) {
        int alen = a.length(), blen = b.length();
        int minlen = Math.min(alen,blen);
        int maxlen = Math.max(alen,blen);
        boolean[] reverse = new boolean[maxlen];
        boolean over = false;
        for (int i = 0  ; i < minlen ; i++) {
            if( over ){
                if( a.charAt(alen-i-1) == '1' || b.charAt(blen-i-1) == '1'){
                    over = true;
                    reverse[i]  = ( a.charAt(alen-i-1) == '1' && b.charAt(blen-i-1) == '1');
                }else{
                    over = false;
                    reverse[i] = true;
                }
            }else{
                if(a.charAt(alen-i-1) == '1' && b.charAt(blen-i-1) == '1'){
                    over = true;
                    reverse[i] = false;
                }else{
                    over = false;
                    reverse[i] = (a.charAt(alen-i-1) == '1' || b.charAt(blen-i-1) == '1');
                }
            }
        }
        String longer = alen > blen ? a : b;
        for (int i = 0; i < maxlen - minlen; i++) {
            boolean isOne = longer.charAt(maxlen-minlen-1-i) == '1';
            reverse[minlen+i] = (!over || !isOne) && ( over || isOne);
            over = over && isOne;
        }
        StringBuilder result = new StringBuilder( over ? "1" : "");
        for (int i = reverse.length -1 ; i >= 0 ; i--) {
            result.append( reverse[i] ? '1' : '0');
        }
        return result.toString();
    }

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String result = "1";
        for (int i = 2; i <= n ; i++) {
            result = countAndSayNext(result);
        }
        return result;
    }

    public String countAndSayNext(String current){
        char c = current.charAt(0);
        int count = 1;
        String result = "";
        for (int i = 1; i < current.length(); i++) {
            if(current.charAt(i) == c){
                count ++;
            }else{
                result += String.valueOf(count) + c;
                c = current.charAt(i);
                count = 1;
            }
        }
        //加上最后的字符
        return result + String.valueOf(count) + c;
    }

    public static int strStr(String haystack, String needle) {
        if( "".equals(needle) ) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}

