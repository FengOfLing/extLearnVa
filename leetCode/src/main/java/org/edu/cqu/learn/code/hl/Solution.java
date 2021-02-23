package org.edu.cqu.learn.code.hl;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3,null,node5);
        TreeNode node2 = new TreeNode(2,null,node4);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println( isCousins( node1,4,5));
    }
    public static boolean isCousins(TreeNode root, int x, int y) {
        //广度优先用队列  深度优先用栈
        Queue<TreeNode> queue = new LinkedList();
        TreeNode firstCousin = null;//同层的第一个兄弟节点，用来比对是否是下一层节点的开始
        boolean isFoundFirst = true;
        int currentDeep = 0, deepOfXY = -1;
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
                    return deepOfXY == currentDeep;
                }
            }
            if (current.left != null)
            {
                if(!isFoundFirst){
                    isFoundFirst = true;
                    firstCousin = current.left;
                }
                queue.offer(current.left);
            }

            if (current.right != null)
            {
                if(!isFoundFirst){
                    isFoundFirst = true;
                    firstCousin = current.right;
                }
                queue.offer(current.right);
            }
        }
        return false;

    }

}

