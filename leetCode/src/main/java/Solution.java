import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        int matrix[][]  = { {1,2}, {2,2}};
        System.out.println(isToeplitzMatrix(new int[][]{{1,2},{2,2}}));
    }


    public static boolean isToeplitzMatrix(int[][] matrix) {
        //取第一排数据的时候，可以用一个一维数组表示下一排的数据要求 [X,1,3,4]
        // X值可以取-1,-1值不在数组中存在，表示下一排对应位置是任意数字都能正确匹配
        int x = -1;
        int[] compare = new int[matrix[0].length];
        Arrays.setAll(compare,index->x);
        for (int i = 0; i < matrix.length; i++) {
            int[] compareTo = matrix[i];

            for (int j = compare.length -1; j >= 0; j--) {
                //填充 compare
                if( j + 1 < compare.length){
                    compare[j+1] = compareTo[j];
                }
                //比较 倒叙便于重复使用compare数组
                if(compare[j] == x){
                    continue;
                }
                if( compare[j] != compareTo[j]){
                    return false; //直接返回
                }
            }
            compare[0] = x;//第一位永远是随意匹配
        }
        return true;
    }

    public static int lengthOfLongestSubstring(String s) {
        //���������ߵ��α�left/right,ͬʱ��ͷ��ʼ ���ζ�rightֱ���ҵ��ظ��ַ����õ�һ�����ȣ�left�Ƶ����ظ����ַ�λ�ã���ѭ���ƶ�right���õ�һϵ�г��ȣ�ȡ�����ֵ���ɡ�
        //ʹ��set���жϵ�ǰleft-rightλ�ã�������Щ�ַ������Կ��ٵ��ж��Ƿ��ظ���
        int left = 0, right = 0;
        int result = 0;
        HashSet<Character> charSet = new HashSet<>();
        while ( right < s.length() ){
            if( charSet.contains( s.charAt(right))){
                //���㱾�εĽ��
                result = Math.max(result , right-left);
                //�ƶ�left�α�
                for ( ;s.charAt(right) != s.charAt(left); left++){
                    charSet.remove(s.charAt(left));
                }
                left++;//ָ���µ����
            }else{
                charSet.add(s.charAt(right));
            }
            right++;
        }
        //��β��û���ظ��������Ƿ����
        result = Math.max(result , right-left);
        return result;

    }
}
