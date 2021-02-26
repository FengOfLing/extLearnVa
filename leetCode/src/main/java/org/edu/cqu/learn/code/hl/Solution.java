package org.edu.cqu.learn.code.hl;

import java.util.*;

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
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
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
        //2.谜面可能重复 ，再用个map存储谜面的结果,不同的前缀，有不同的结果
        HashMap<String,Integer> mapInt = new HashMap<>();
        HashMap<Integer,HashMap<Character,Integer>> mapCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int[] wordsNum = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsNum[i] = countPuzzles(words[i]);
        }
        for (int i = 0; i < puzzles.length; i++) {
            int puzzle = countPuzzles(puzzles[i]);
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

    public static int countPuzzles( String puzzles){
        int res = 0;
        for (int i = 0; i < puzzles.length(); i++) {
            res = res | ( 1 << (puzzles.charAt(i) - 'a') );
        }
        return res;
    }

    /**
     * puzzle[0,1,0,1,1...] 那么 word必须是[0,*,0,*,*...], 并且word中first指定的位必须为1
     */
    public static boolean exsist(int puzzle , int word, char first){
        if (((word >>> (first - 'a') ) & 1) != 1){
            return false;
        }
        return ((~puzzle) & word) == 0;
    }
}

