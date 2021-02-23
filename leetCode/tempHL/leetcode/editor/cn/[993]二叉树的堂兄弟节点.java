//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 120 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *  *     int val;
 *  *     TreeNode left;
 *  *     TreeNode right;
 *  *     TreeNode() {}
 *  *     TreeNode(int val) { this.val = val; }
 *  *     TreeNode(int val, TreeNode left, TreeNode right) {
 *  *         this.val = val;
 *  *         this.left = left;
 *  *         this.right = right;
 *  *     }
 *  * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        //广度优先用队列  深度优先用栈
        Queue<TreeNode> queue = new LinkedList();
        TreeNode firstCousin = null;//同层的第一个兄弟节点，用来比对是否是下一层节点的开始
        boolean isFoundFirst = true;
        int currentDeep = 0, deepOfXY = -1;

        //是否是同一层级节点判断了，还需要判断是否是同一个父亲
        TreeNode parentOfX = null, parentOfY = null;
        if( root != null){
            queue.add(root);
            firstCousin = root;
        }
        while( !queue.isEmpty()){
            TreeNode current = queue.poll();
            if(  firstCousin == current ){
                currentDeep++;
                isFoundFirst = false;//标记 表示需要找下一层开始的节点了
            }
            if( current.val == x || current.val == y ){
                if(deepOfXY == -1){
                    deepOfXY = currentDeep;
                }else{
                    return deepOfXY == currentDeep && parentOfX != parentOfY;
                }
            }
            if (current.left != null)
            {
                if(!isFoundFirst){
                    isFoundFirst = true;
                    firstCousin = current.left;
                }
                queue.offer(current.left);
                parentOfX = current.left.val == x ? current : parentOfX;
                parentOfY = current.left.val == y ? current : parentOfY;
            }

            if (current.right != null)
            {
                if(!isFoundFirst){
                    isFoundFirst = true;
                    firstCousin = current.right;
                }
                queue.offer(current.right);
                parentOfX = current.right.val == x ? current : parentOfX;
                parentOfY = current.right.val == y ? current : parentOfY;
            }
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
