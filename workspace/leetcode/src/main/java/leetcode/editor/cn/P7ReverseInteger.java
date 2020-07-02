//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [(-2)^31, 2^(31) − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学


package leetcode.editor.cn;

import org.junit.Assert;

//Java：整数反转
public class P7ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        // TO TEST

        int test = 100086;
        Assert.assertEquals(solution.reverse(test), 680001);

        test = -100086;
        Assert.assertEquals(solution.reverse(test), -680001);


        test = 1534236469;
        Assert.assertEquals(solution.reverse(test), 0);

        test = -1534236469;
        Assert.assertEquals(solution.reverse(test), 0);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {

        /**
         *  利用取模 获取最后一位
         *  利用除10 去除最后一位
         *  这里比较麻烦的是判断溢出的地方：以下利用了反算，反算失败则证明溢出了
         */
        int result = 0;

        while (x != 0) {
            int tmp = x%10;
            int resultTest = result *10 +tmp;

            // 这样不对，不能用乘法，乘法直接溢出了！！！
            if((resultTest - result*10) !=tmp)
                return 0;

            if((resultTest - tmp)/10 !=result)
                return 0;

            result = resultTest;
            x = x/10;
        }

        System.out.println("result="+ result);
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}