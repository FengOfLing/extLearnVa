package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println( isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#") );
        System.out.println( isValidSerialization("1,#") );
        System.out.println( isValidSerialization("9,#,#,1") );
    }
    public static boolean isValidSerialization(String preorder) {
        //前序遍历，中左右  遇到null 下一个元素是上一个非空节点的右子节点。
        Character nullChar = '#';
        Stack<Integer> nodeIndex = new Stack();
        boolean isNext = true;
        boolean leftOrRight = true;
        for (int i = 0; i < preorder.length(); i++) {
            if(preorder.charAt(i) == ','){
                isNext = true;
            }else{
                //可能存在两位数，只需要当做一个值就可以了
                if(isNext){
                    if(preorder.charAt(i) == nullChar){
                        //遇到代表空的char,补左或者补右
                        if( leftOrRight ){
                            leftOrRight = false;//如果是左遇空，下一个数据是加在右边
                        }else{
                            //如果是右遇空，返回到上一个节点继续从右放置节点。没有上一个节点表示字符串不正确。
                            if( nodeIndex.isEmpty() ){
                                return false;
                            }
                            leftOrRight = false;
                            nodeIndex.pop();
                        }
                    }else {
                        //如果放置了新的节点。新节点是放在上个节点的右边，先pop上一个节点，然后从左到右放；
                        //新节点如果是放在上一个节点左边，直接标记，从左到右放
                        if( !leftOrRight ){
                            if( nodeIndex.isEmpty() ){
                                return false;
                            }
                            nodeIndex.pop();
                        }
                        nodeIndex.push(i);
                        leftOrRight = true;
                    }
                    isNext = false;
                }
            }
        }
        return nodeIndex.isEmpty();
    }

}

