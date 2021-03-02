//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1405 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int[] count = count(x);
        for (int i = 0; i <= (count.length-1)/2; i++) {
            if(count[i] != count[count.length-1-i]){
                return false;
            }
        }
        return true;
    }
    public int[] count(int x){
        int[] nums = new int[30];
        int i = 0;
        do{
            nums[i++] = x % 10;
            x = x / 10;
        }while( x != 0);//x=0时

        int[] result = new int[i];
        for (int j = 0; j < i; j++) {
            result[j] = nums[j];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
