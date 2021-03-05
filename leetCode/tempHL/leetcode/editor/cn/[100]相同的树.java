//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 
// 👍 573 👎 0


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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //广度优先用队列  深度优先用栈
        Queue<TreeNode> pqueue = new LinkedList<TreeNode>();
        Queue<TreeNode> qqueue = new LinkedList<TreeNode>();
        pqueue.offer( p );
        qqueue.offer( q );
        while( !qqueue.isEmpty() && !pqueue.isEmpty()){
            TreeNode qnode = qqueue.poll();
            TreeNode pnode = pqueue.poll();
            if(qnode != null && pnode != null ) {
                if (pnode.val != qnode.val) {
                    return false;
                }
                pqueue.offer( pnode.left);
                pqueue.offer( pnode.right);
                qqueue.offer( qnode.left);
                qqueue.offer( qnode.right);
            }else if ( qnode == null && pnode == null ){
                continue;
            }else{
                return false;
            }
        }
        return qqueue.isEmpty() && pqueue.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
