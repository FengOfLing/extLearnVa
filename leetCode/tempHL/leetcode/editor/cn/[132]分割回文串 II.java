//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 动态规划 
// 👍 327 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCut(String s) {
        //动态规划 计算i-j是否是回文字符串
        int n = s.length();
        boolean[][] flag = new boolean[n][n];
        for (int i = 0; i < flag.length; i++) {
            Arrays.fill(flag[i],true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                flag[i][j] = s.charAt(i) == s.charAt(j) && flag[i+1][j-1];
            }
        }

        //动态规划，计算最小回文串个数
        int[] minCout = new int[n];
        Arrays.fill(minCout, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if(flag[0][i]) minCout[i] = 0;
            else {
                for (int j = 0; j < i; j++) {
                    if(flag[j+1][i]) minCout[i] = Math.min(minCout[i],minCout[j] + 1);
                }
            }
        }
        return minCout[n - 1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
