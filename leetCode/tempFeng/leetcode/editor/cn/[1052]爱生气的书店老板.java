//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。 
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。 
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。 
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。 
// 
//
// 示例： 
//
// 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= X <= customers.length == grumpy.length <= 20000 
// 0 <= customers[i] <= 1000 
// 0 <= grumpy[i] <= 1 
// 
// Related Topics 数组 Sliding Window 
// 👍 100 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 思路是什么，就是先去从第一分钟开始憋气
    // 然后计算 1 + x 分钟，算出结果并记录
    // 然后计算 2 + x 分钟，计算出结果
    // 直到，length - x - lenght ，计算出结果，并比较最大值
    // 有没有什么其他办法
    //

    // 我事先将所有的顾客数量全部记录下来
    // 然后，我该怎么从这个数组中去找到最大的值的和呢
    // 只能从第一个数据，开始一个一个的遍历

    // customers 是每分钟的客人数数组
    // grumpy 是主人是否生气
//    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
//        int result = 0;
//        int tempResult = 0;
//        int nextRes = 0;
//        for ( int i = 0; i < X; i++ ) {
//            tempResult += customers[i];
//        }
//        for ( int i = X; i < customers.length; i++ ) {
//            if ( 0 == grumpy[i] ) {
//                tempResult += customers[i];
//            }
//        }
//        if ( result < tempResult ) {
//            result = tempResult;
//        }
//        nextRes = tempResult;
//        // 算出来了之后，我们再根据这个值，去一次一次的计算后面的值
//        for ( int j = 1; j <= customers.length - X; j ++ ) {
//            if ( 1 == grumpy[j - 1] ) {
//                nextRes -= customers[j - 1];
//            }
//            if ( 1 == grumpy[j + X - 1] ) {
//                nextRes += customers[j + X - 1];
//            }
//            if ( result < nextRes ) {
//                result = nextRes;
//            }
//        }
//        return result;
//    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //假使没有技能 那么客户的满意度是固定的，计算最佳使用技能时间，就是连续的X个由生气变为不生气带来的额外的满意度最多的时候；
        //计算出每分钟内，假如在技能使用内，会带来的额外满意度，在计算数组中连续X 满意度相加最大的情况。(已经满意，那么额外满意度为0)

        //计算稳定满意度 -> 计算额外满意度权重数组  -> 计算数组连续X和最大值 + 稳定满意度
        int steadyCount = 0,maxExtraCount = 0;
        int[] extraCount = new int[customers.length];
        for (int i = 0; i < customers.length; i++) {
            steadyCount += (grumpy[i] == 0 ? customers[i] : 0 );
            extraCount[i] = customers[i] * grumpy[i];
        }
        for (int i = 0; i <= customers.length-X; i++) {
            maxExtraCount = Math.max( maxExtraCount,arraySum(extraCount,i,X));
        }
        return steadyCount + maxExtraCount;
    }

    public int arraySum( int[] array, int start, int length){
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += array[start+i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
