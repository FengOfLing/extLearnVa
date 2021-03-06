//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 465 👎 0


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
    //			执行耗时:8 ms,击败了49.80% 的Java用户
    //			内存消耗:59.1 MB,击败了48.26% 的Java用户
    public int minDepth(TreeNode root) {
        if( root == null){
            return 0;
        }
        if(root.right == null && root.left == null){
            return 1;
        }
        int right = minDepth(root.right);
        int left = minDepth(root.left);
        //空子节点，长度算做Integer.MAX
        return Math.min(right == 0 ? Integer.MAX_VALUE : right, left == 0 ? Integer.MAX_VALUE : left) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
