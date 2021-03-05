package org.edu.cqu.learn.code.hl;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(3); // queue is: [1, 2, 3] (leftmost is front of the queue)
        myQueue.push(4); // queue is: [1, 2, 3, 4] (leftmost is front of the queue)
        myQueue.pop(); // return 1, queue is [2]
        myQueue.push(5); // return 1, queue is [2]
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.empty(); // return false
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if( envelopes.length == 0) return 0;
        //enable[i][j]的值表示i是否可以套住j
        boolean[][] enable = new boolean[envelopes.length][envelopes.length];
        int[] enablecount = new int[envelopes.length];
        int maxcount = 0;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    enable[i][j] = true;
                    maxcount = Math.max(maxcount,++enablecount[i] );
                }
                if(envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]){
                    enable[j][i] = true;
                    maxcount = Math.max(maxcount,++enablecount[j] );
                }
            }
        }
        //从只能套一个倒着推算
        int[] max = new int[envelopes.length];
        for (int i = 0; i < enablecount.length; i++) {
            if( enablecount[i] >= 1){
                max[i] = 1;
            }
        }
        boolean[] caled = new boolean[enablecount.length] ;//标记是否已被计算，提早结束循环避免超时
        for (int i = 1;  i < maxcount; i++) {
            for (int j = 0; j < enablecount.length; j++) {
                if( !caled[j] && enablecount[j]  == i ){
                    sumup(max,enable,j,caled);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < max.length; i++) {
            result = Math.max( result, max[i] );
        }
        return result + 1;
    }

    public static void sumup(int[] max, boolean[][] enable,int j,boolean[] caled){
        //如果j的位置谁都不能套，退出递归
        for (int i = 0; i < enable.length; i++) {
            if( enable[i][j]){
                if( max[i] < max[j] + 1){
                    caled[i] = true;
                    max[i] = max[j] + 1;
                    // 更新i位置能套的最多信封，并且层次计算 能包含i信封的信封的个数
                    sumup(max,enable,i,caled);
                }
            }
        }
    }

}

