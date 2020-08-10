//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


package leetcode.editor.cn;

import org.junit.Assert;

//Java：回文数
public class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        // TO TEST

        Assert.assertFalse(solution.isPalindrome(123));
        Assert.assertTrue(solution.isPalindrome(121));
        Assert.assertFalse(solution.isPalindrome(1234));
        Assert.assertTrue(solution.isPalindrome(1221));

        Assert.assertFalse(solution.isPalindrome(0123));
        Assert.assertFalse(solution.isPalindrome(-123));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 数学计算
         */
        public boolean isPalindrome(int x) {

            // 翻转一半数字
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }
            int result = 0;
            while (x > result) {
                result = result * 10 + x % 10;
                x = x / 10;
            }
            return result == x || result / 10 == x;
        }

        /** 转字符串, 两头取 注意索引越界 **/
//        public boolean isPalindrome(int x) {
//            System.out.println("input:" + x);
//            char[] cs = String.valueOf(x).toCharArray();
//            for (int i = 0; i < cs.length / 2; i++) {
//                char current = cs[i];
//                char last = cs[cs.length - i -1];p盘
//                if (current != last) {
//                    return false;
//                }
//            }
//            return true;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}