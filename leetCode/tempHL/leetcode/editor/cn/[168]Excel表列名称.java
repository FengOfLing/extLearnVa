//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 
// 👍 321 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //			解答成功:
    //			执行耗时:0 ms,击败了100.00% 的Java用户
    //			内存消耗:35.4 MB,击败了86.38% 的Java用户
    public String convertToTitle(int columnNumber) {
        //26进制
        StringBuilder str = new StringBuilder();
        while( columnNumber != 0){
            str.append( (char) ((columnNumber-1) % 26  + 'A') );
            columnNumber = (columnNumber - 1) / 26;
        }
        return str.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
