//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1271 👎 0


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
    //			内存消耗:36.5 MB,击败了61.95% 的Java用户
    public boolean isSymmetric(TreeNode root) {
        //检查两个子树是否相同（左节点，比右节点）
        if( root == null ){
            return true;
        }
        return isSame(root.left, root.right);

    }
    public boolean isSame(TreeNode left, TreeNode right){
        if( right == null && left == null){
            return true;
        }
        if( left == null || right == null ){
            return false;
        }
        if( left.val != right.val){
            return false;
        }
        return isSame(left.right,right.left) && isSame(left.left, right.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
