//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 按 严格递增 顺序排列 
// 
// Related Topics 树 深度优先搜索 
// 👍 710 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //			解答成功:
    //			执行耗时:0 ms,击败了100.00% 的Java用户
    //			内存消耗:38 MB,击败了86.75% 的Java用户
    //有序数组可以很快捷的直接转平衡二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return getNode(nums, 0, nums.length-1);
    }

    public TreeNode getNode(int[] nums ,int start, int end){
        if( start > end ){
            return null;
        }
        if( start == end ){
            return new TreeNode(nums[start]);
        }
        int middle = (start + end)/2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = getNode(nums,start,middle-1);
        node.right = getNode(nums, middle+1,end);
        return node;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
