//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 
// 👍 528 👎 0


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
    //			执行耗时:2 ms,击败了12.83% 的Java用户
    //			内存消耗:38.2 MB,击败了89.46% 的Java用户
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //深度优先搜索用栈 stack，
        //入栈的元素值都计算为到根节点的和
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return false;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.val == targetSum){
                if(node.right == null && node.left == null){
                    return true;
                }
            }
            if( node.right != null){
                node.right.val = node.right.val + node.val;
                stack.push(node.right);
            }
            if( node.left != null){
                node.left.val = node.left.val + node.val;
                stack.push(node.left);
            }

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
