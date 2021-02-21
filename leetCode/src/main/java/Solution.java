import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
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
