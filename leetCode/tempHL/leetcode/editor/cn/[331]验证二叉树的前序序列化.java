//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。 
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈 
// 👍 195 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //			解答成功:
    //			执行耗时:5 ms,击败了38.91% 的Java用户
    //			内存消耗:37 MB,击败了81.21% 的Java用户
    public boolean isValidSerialization(String preorder) {
        //前序遍历，中左右  遇到null 下一个元素是上一个非空节点的右子节点。
        Character nullChar = '#';
        Stack<Integer> nodeIndex = new Stack();
        boolean isNext = true;
        boolean leftOrRight = true;
        for (int i = 0; i < preorder.length(); i++) {
            if(preorder.charAt(i) == ','){
                isNext = true;
            }else{
                //可能存在两位数，只需要当做一个值就可以了
                if(isNext){
                    if(preorder.charAt(i) == nullChar){
                        //遇到代表空的char,补左或者补右
                        if( leftOrRight ){
                            leftOrRight = false;//如果是左遇空，下一个数据是加在右边
                        }else{
                            //如果是右遇空，返回到上一个节点继续从右放置节点。没有上一个节点表示字符串不正确。
                            if( nodeIndex.isEmpty() ){
                                return false;
                            }
                            leftOrRight = false;
                            nodeIndex.pop();
                        }
                    }else {
                        //如果放置了新的节点。新节点是放在上个节点的右边，先pop上一个节点，然后从左到右放；
                        //新节点如果是放在上一个节点左边，直接标记，从左到右放
                        if( !leftOrRight ){
                            if( nodeIndex.isEmpty() ){
                                return false;
                            }
                            nodeIndex.pop();
                        }
                        nodeIndex.push(i);
                        leftOrRight = true;
                    }
                    isNext = false;
                }
            }
        }
        return nodeIndex.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
