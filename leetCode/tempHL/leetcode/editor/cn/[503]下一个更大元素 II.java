//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 303 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    解答成功:
//    执行耗时:11 ms,击败了64.53% 的Java用户
//    内存消耗:40 MB,击败了78.75% 的Java用户
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();
        int start = 0;
        int firstOfStack = 0 , firstOfStackIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            //从栈中一直吐出，一直到栈空或者栈顶的数字大于nums[i];
            while( !stack.isEmpty() && stack.peek() < nums[i] ){
                stack.pop();
                result[stackIndex.pop()] =  nums[i];
            }
            if( stack.isEmpty()){
                firstOfStack = nums[i];
                firstOfStackIndex = i;
            }
            stack.push( nums[i]);
            stackIndex.push( i );
        }
        //剩下的栈中就是 从打大到小存入的值,（栈底就是最大的值）
        for (int i = 0; i < nums.length && !stack.isEmpty() ; i++) {
            if( stack.peek() == firstOfStack){
                break;
            }
            while( !stack.isEmpty() && stack.peek() < nums[i] ){
                stack.pop();
                result[stackIndex.pop()] =  nums[i];
            }

        }
        while(!stackIndex.isEmpty()){
            result[stackIndex.pop()] = -1;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
