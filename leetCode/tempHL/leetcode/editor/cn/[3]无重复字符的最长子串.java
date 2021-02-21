//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4983 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //由左右两边的游标left/right,同时从头开始 先游动right直到找到重复字符，得到一个长度，left移到被重复的字符位置，再循环移动right，得到一系列长度，取到最大值即可。
        //使用set来判断当前left-right位置，含有哪些字符，可以快速的判断是否重复。
        int left = 0, right = 0;
        int result = 0;
        HashSet<Character> charSet = new HashSet<>();
        while ( right < s.length() ){
            if( charSet.contains( s.charAt(right))){
                //计算本次的结果
                result = Math.max(result , right-left);
                //移动left游标
                for ( ;s.charAt(right) != s.charAt(left); left++){
                    charSet.remove(s.charAt(left));
                }
                left++;//指到新的起点
            }else{
                charSet.add(s.charAt(right));
            }
            right++;
        }
        //结尾都没有重复，计算是否是最长
        result = Math.max(result , right-left);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
