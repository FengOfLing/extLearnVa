//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 288 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //			解答成功:
    //			执行耗时:42 ms,击败了13.01% 的Java用户
    //			内存消耗:41.1 MB,击败了32.99% 的Java用户
    public int calculate(String s) {
        Character numX = 'X';
        Stack<Character> operator = new Stack();
        Stack<Integer> nums = new Stack();
        for (int i = 0; i < s.length(); i++) {
            boolean isNum = false;
            int num = 0;
            while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                isNum = true;
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            if(isNum){
                //如果前面是*/运算先计算结果压栈
                if(!operator.isEmpty() && operator.peek() == '*' ){
                    operator.pop();//操作符
                    operator.pop();//数字位
                    num = nums.pop() * num;
                }else if(!operator.isEmpty() && operator.peek() == '/'){
                    operator.pop();//操作符
                    operator.pop();//数字位
                    num = nums.pop() / num ;
                }
                nums.push(num);
                operator.push(numX);
            }
            if( i >= s.length()){
                break;
            }
            if( s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '+' || s.charAt(i) == '-'){
                operator.push(s.charAt(i));
            }
        }
        int sum = 0;
        int rNum = 0;
        while(!operator.isEmpty()){
            if(operator.peek() == numX){
                rNum = nums.pop();
                operator.pop();
                if(operator.isEmpty()){
                    sum += rNum;//第一个数字；
                }
            }else{
                sum += (operator.pop() == '+'? rNum:-rNum );
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
