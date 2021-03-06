//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 617 👎 0


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
    //			执行耗时:1 ms,击败了99.96% 的Java用户
    //			内存消耗:38.5 MB,击败了62.28% 的Java用户
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) == -1 ? false : true;
    }
     public int getDepth( TreeNode root){
        if( root == null ){
            return 0;
        }
        int rightDepth = getDepth(root.right);
        if(rightDepth == -1){
            return -1;
        }

        int leftDepth = getDepth(root.left);
        if(leftDepth == -1){
            return -1;
        }

        if( Math.abs(rightDepth - leftDepth) > 1){
            return -1;
        }
        return Math.max(rightDepth,leftDepth) + 1;

     }
}
//leetcode submit region end(Prohibit modification and deletion)
