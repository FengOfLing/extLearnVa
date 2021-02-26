package org.edu.cqu.learn.code.day5.feng;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> result = new LinkedList<>();
        // 对于每一个谜面
        for ( String temp : puzzles ) {
            // 现在去判断谜底
            int res = 0;
            for ( String word : words ) {
                // word 是否包含 temp 的第一个字符
                boolean firstFlag = false;
                // word 中的所有字符，是否全部在 temp 中
                boolean allContent = true;
                char[] chars = word.toCharArray();
                for ( char index : chars ) {
                    if ( index == temp.charAt(0) ) {
                        firstFlag = true;
                        continue;
                    }

                    if ( !temp.contains(index + "") ) {
                        allContent = false;
                        break;
                    }
                }
                if ( firstFlag && allContent ) {
                    res ++;
                }
            }
            result.add(res);
        }
        return result;
    }
}
