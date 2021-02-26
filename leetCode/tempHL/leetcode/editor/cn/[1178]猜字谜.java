//外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。 
//
// 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底： 
//
// 
// 单词 word 中包含谜面 puzzle 的第一个字母。 
// 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。 
// 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"
//（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。 
// 
//
// 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜
//底的单词数目。 
//
// 
//
// 示例： 
//
// 输入：
//words = ["aaaa","asas","able","ability","actt","actor","access"], 
//puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
//输出：[1,1,3,2,4,0]
//解释：
//1 个单词可以作为 "aboveyz" 的谜底 : "aaaa" 
//1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
//3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
//2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
//4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
//没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10^5 
// 4 <= words[i].length <= 50 
// 1 <= puzzles.length <= 10^4 
// puzzles[i].length == 7 
// words[i][j], puzzles[i][j] 都是小写英文字母。 
// 每个 puzzles[i] 所包含的字符都不重复。 
// 
// Related Topics 位运算 哈希表 
// 👍 78 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        //需要注意的是 words 和 puzzles数组可能特别长，一定要考虑效率，不能一个个字符比对
        //关键在于谜面的长度固定且都是小写英文26个 有个用位01表示各个是否存在的方式，使用位运算可以简便算出是否存在该字母
        //如果 puzzle[0,1,0,1,1...] 那么 word必须是[0,*,0,*,*...]
        //        a b result    !a !a&b
        //        0 0 true      1	0
        //        0 1 false     1	1
        //        1 0 true      0	0
        //        1 1 true      0	0
        //那么 !puzzle&word 每一位都是0表示验证通过表示word满足每个字母都在puzzle中存在
        //与（&）、非（~）、或（|）、异或（^）
        //1.全部使用位计算后还是超时了，字符这么多重复的，使用map存储string对应的位int，减少计算
        //2.谜面可能重复 ，再用个map(map)存储谜面的结果,不同的前缀，有不同的结果
        //3.还是计算超时了 需要减少exsist的调用次数 ...晚点再想办法
        HashMap<String,Integer> mapInt = new HashMap<>();
        HashMap<Integer,HashMap<Character,Integer>> mapCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int[] wordsNum = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsNum[i] = countPuzzles(mapInt,words[i]);
        }
        for (int i = 0; i < puzzles.length; i++) {
            int puzzle = countPuzzles(mapInt,puzzles[i]);
            if( mapCount.get(puzzle) != null && mapCount.get(puzzle).get(puzzles[i].charAt(0)) != null){
                result.add(mapCount.get(puzzle).get( puzzles[i].charAt(0) ) );
                continue;
            }
            int count = 0;
            for (int j = 0; j < wordsNum.length; j++) {
                if( exsist(puzzle, wordsNum[j], puzzles[i].charAt(0))){
                    count++;
                }
            }
            if(mapCount.get(puzzle) == null){
                mapCount.put(puzzle,new HashMap<Character, Integer>());
            }
            mapCount.get(puzzle).put(puzzles[i].charAt(0),count);
            result.add(count);
        }
        return result;
    }

    public int countPuzzles(  HashMap<String,Integer> mapInt, String puzzles){
        if(mapInt.get(puzzles) != null){
            return mapInt.get(puzzles);
        }
        int res = 0;
        for (int i = 0; i < puzzles.length(); i++) {
            res = res | ( 1 << (puzzles.charAt(i) - 'a') );
        }
        mapInt.put(puzzles,res);
        return res;
    }

    /**
     * puzzle[0,1,0,1,1...] 那么 word必须是[0,*,0,*,*...], 并且word中first指定的位必须为1
     */
    public boolean exsist(int puzzle , int word, char first){
        if (((word >>> (first - 'a') ) & 1) != 1){
            return false;
        }
        return ((~puzzle) & word) == 0;
    }
    public boolean exsist(int word,char first){
        return ((word >>> (first - 'a') ) & 1) == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
