//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 605 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //			解答成功:
    //			执行耗时:32 ms,击败了5.17% 的Java用户
    //			内存消耗:66.8 MB,击败了5.00% 的Java用户
    public List<List<String>> partition(String s) {
        return getSubHuiWen(s,0,s.length()-1);
    }

    public List<List<String>> getSubHuiWen(String s,int start, int end){
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> stringList = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            stringList.add( String.valueOf(s.charAt(i)));
        }
        result.add(stringList);

        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end ; j++) {
                if( isHuiWen(s, i, j)){
                    List<List<String>> subResult = getSubHuiWen(s,j+1,end);
                    for (int k = 0; k < subResult.size(); k++) {
                        List<String> list = new ArrayList<String>();
                        for (int l = start; l < i ; l++) {
                            list.add( String.valueOf(s.charAt(l)));
                        }
                        list.add( s.substring(i,j+1));
                        list.addAll( subResult.get(k));
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }


    public boolean isHuiWen(String s, int start, int end){
        while( start < end ){
            if( s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;

        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
