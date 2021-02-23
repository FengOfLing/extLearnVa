//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3712 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        boolean needAvrage = totalLength%2 == 0;
        int[] middle = new int[]{0,0};
        int i = 0, j = 0;
        found:
        for (; i < nums1.length ; i++) {
            //nums2的下一位小于nums1的下一位 j++
            if( j < nums2.length && nums1[i] > nums2[j]) {
                for (; j < nums2.length; j++) {
                    if( nums1[i] <= nums2[j]){
                        break;
                    }else{
                        middle[1] = middle[0];
                        middle[0] = nums2[j];
                        if( i + j == totalLength/2){
                            break found;
                        }
                    }
                }
                i--;//i会在for里面+1，提前减1
            }else{
                middle[1] = middle[0];
                middle[0] = nums1[i];
                if( i + j == totalLength/2){
                    break found;
                }
            }
        }

        //nums1提前循环结束 还未找到中位,继续循环nums2
        if( i == nums1.length){
            i--;
        }
        for( ; i+j <totalLength/2; j++){
            middle[1] = middle[0];
            middle[0] = nums2[j];
        }
        if( needAvrage){
            return ( (double) middle[0] + (double) middle[1]) / 2;
        }else{
            return (double) middle[0];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
