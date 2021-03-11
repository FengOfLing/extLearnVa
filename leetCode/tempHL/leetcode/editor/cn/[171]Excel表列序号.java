//给定一个Excel表格中的列名称，返回其相应的列序号。 
//
// 例如， 
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 示例 1: 
//
// 输入: "A"
//输出: 1
// 
//
// 示例 2: 
//
// 输入: "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 输入: "ZY"
//输出: 701 
//
// 致谢： 
//特别感谢 @ts 添加此问题并创建所有测试用例。 
// Related Topics 数学 
// 👍 208 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //			解答成功:
    //			执行耗时:1 ms,击败了100.00% 的Java用户
    //			内存消耗:38.3 MB,击败了86.89% 的Java用户
    public int titleToNumber(String columnTitle) {
        int num = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            num =  num*26 + ( columnTitle.charAt(i) - 'A' + 1);
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
