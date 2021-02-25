//行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符（重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。例如，用此方法压缩字符串 "
//aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。因此压缩后的字符串变为 "a2bc3" 。 
//
// 注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。 
//
// 给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。 
//
// 请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "aaabcccd", k = 2
//输出：4
//解释：在不删除任何内容的情况下，压缩后的字符串是 "a3bc3d" ，长度为 6 。最优的方案是删除 'b' 和 'd'，这样一来，压缩后的字符串为 "a3
//c3" ，长度是 4 。 
//
// 示例 2： 
//
// 输入：s = "aabbaa", k = 2
//输出：2
//解释：如果删去两个 'b' 字符，那么压缩后的字符串是长度为 2 的 "a4" 。
// 
//
// 示例 3： 
//
// 输入：s = "aaaaaaaaaaa", k = 0
//输出：3
//解释：由于 k 等于 0 ，不能删去任何字符。压缩后的字符串是 "a11" ，长度为 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// 0 <= k <= s.length 
// s 仅包含小写英文字母 
// 
// Related Topics 字符串 动态规划 
// 👍 51 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        //同一个位置删除小于K个字符后编码字符长度一定是 大于等于 删除K个字符后编码字符的长度，所有使用删除定K个字符计算即可
        //先计算不删减的字符串压缩后的长度，然后循环计算altCount[i]+...+altCount[i+n] <= k 最大的长度差值（PS两位数也一位数有差别）
        ArrayList<Integer> altCount = new ArrayList<>();

        int index = 0;
        altCount.add(1);
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)){
                altCount.set(index, altCount.get(index)+1 );
            }else{
                altCount.add( 1) ;
                index++;
            }
        }
        int maxDiff = 0;
        for (int i = 0; i < altCount.size(); i++) {
            int diff = 0,counts = 0, j = 0;
            for (j = i; j < altCount.size() && counts + altCount.get(j) <= k  ; j++) {
                counts += altCount.get(j);
                diff += (( altCount.get(j) == 1 ? 0:1 ) +  (altCount.get(j) > 10 ? 2 : 1 ));
            }
            //如果前后的字符相同 优先考虑前后合并带来的diff
//            if()
            //如果不能合并，而且还有剩余的可减少的字符，计算能不能额外减少前后字符的个数使得两位数变一位数
            if( k - counts > 0){
                int diffCount = k - counts;
                if( i != 0 && altCount.get(i-1) >= 10 && altCount.get(i-1) - diffCount < 10){
                    diff ++;
                    diffCount -= (altCount.get(i-1)-9);//最少减少altCount[i-1]-9个
                }
                if( j != altCount.size() && altCount.get(j) >= 10 && altCount.get(j) - diffCount < 10){
                    diff++;
                }
            }
            maxDiff = Math.max(maxDiff,diff);
        }
        return maxDiff;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
