//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 344 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        String lowwer = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while( i < j){
            while( i < j && !isValid(lowwer.charAt(i))){
                i++;
            }
            while(i < j && !isValid(lowwer.charAt(j) )){
                j--;
            }
            if( i < j && lowwer.charAt(i) != lowwer.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isValid( char c){
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
