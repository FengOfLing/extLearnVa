//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 399 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //			解答成功:
    //			执行耗时:36 ms,击败了18.20% 的Java用户
    //			内存消耗:39.8 MB,击败了36.45% 的Java用户
    public int calculate(String s) {
        // todo 需要整理一下
        char X = 'X';//X代表数字位
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> operator = new Stack<>();//只存 '+''-''(' 'X'
        for (int i = 0; i < s.length(); i++) {
            //数字位如数字栈
            if(isNum(s.charAt(i))){
                int num = 0, count = 0;
                while(isNum(s.charAt(i))){
                    num = (num * 10 + (s.charAt(i++) - '0'));
                    if(i >= s.length()){
                        break;
                    }
                }
                i--;
                nums.push(num);
                operator.push(X);
            }else{
                //计算括号内容 结果押入栈
                if( s.charAt(i) ==')'){
                    int cal = 0;
                    int rnum = 0;
                    while( operator.peek() != '('){
                        if(operator.peek() == X){
                            rnum = nums.pop();
                            operator.pop();
                            if( operator.peek() == '('){
                                cal += rnum;
                            }
                        }else {
                            cal += operator.peek() == '+' ? rnum:-rnum;
                            operator.pop();
                        }
                    }
                    operator.pop();
                    operator.push(X);
                    nums.push(cal);
                }else if(s.charAt(i) =='+' || s.charAt(i) =='-' || s.charAt(i) =='(') {
                    operator.push(s.charAt(i));
                }
            }
        }
        int result = 0;
        int rnum = 0;
        //操作栈里面应该只剩 +-X,计算结果即可
        while( !operator.isEmpty()){
            if(operator.peek() == X){
                rnum = nums.pop();
                operator.pop();
                if( operator.isEmpty()){
                    result += rnum;
                }
            }else{
                result += operator.peek() == '+' ? rnum:-rnum;
                operator.pop();
            }

        }
        return result;
    }
    public boolean isNum(Character c){
        return c >= '0' && c <= '9';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
