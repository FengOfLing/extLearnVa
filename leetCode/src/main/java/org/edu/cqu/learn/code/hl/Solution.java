package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }

    public List<List<String>> partition(String s) {
        return getSubHuiWen(s,0,s.length()-1);
    }

    public List<List<String>> getSubHuiWen(String s,int start, int end){
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> stringList = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            stringList.add( String.valueOf(s.charAt(i)));
        }
        result.add(stringList);

        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end ; j++) {
                if( isHuiWen(s, i, j)){
                    List<List<String>> subResult = getSubHuiWen(s,j,end);
                    for (int k = 0; k < subResult.size(); k++) {
                        List<String> list = new ArrayList<String>();
                        for (int l = start; l < i ; l++) {
                            list.add( String.valueOf(s.charAt(l)));
                        }
                        list.add( s.substring(i,j+1));
                        list.addAll( subResult.get(k));
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    public boolean isHuiWen(String s, int start, int end){
        while( start < end ){
            if( s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;

        }
    }

}

