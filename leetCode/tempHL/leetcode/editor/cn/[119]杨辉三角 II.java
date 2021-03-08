//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 270 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex+1];
        Arrays.fill(result,0);
        result[0] = 1;
        int pre = 0;
        for (int i = 1; i <= rowIndex; i++) {
            pre = 1;
            for (int j = 1; j < i + 1; j++) {
                int temp = result[j];
                result[j] = pre + result[j];
                pre = temp;
            }
        }
        return Arrays.asList(result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
