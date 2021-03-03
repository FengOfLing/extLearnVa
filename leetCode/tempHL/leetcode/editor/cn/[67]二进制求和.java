//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 568 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        //			解答成功:
        //			执行耗时:3 ms,击败了53.87% 的Java用户
        //			内存消耗:37.3 MB,击败了74.74% 的Java用户
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
}
//leetcode submit region end(Prohibit modification and deletion)
