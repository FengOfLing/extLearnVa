package org.edu.cqu.learn.code.day6.feng;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    // 我以为是开心消消乐，结果人家只是两个字符重复的
    public static String removeDuplicates(String S) {
        Stack<Character> characterStack = new Stack<>();
        char[] chars = S.toCharArray();
        for (char aChar : chars) {
            // 如果栈顶元素和下一个要写入的元素不相同，则写入栈顶
            if ( characterStack.isEmpty() ) {
                characterStack.push(aChar);
            } else {
                Character top = characterStack.peek();
                if (top.equals(aChar)) {
                    top = characterStack.pop();
                } else {
                    characterStack.push(aChar);
                }
            }

        }
        char[] res = new char[characterStack.size()];
        int index = res.length - 1;
        while ( !characterStack.isEmpty() ) {
            res[index] = characterStack.pop();
            index --;
        }
        return new String(res);
    }
}