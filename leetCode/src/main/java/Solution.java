import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
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
