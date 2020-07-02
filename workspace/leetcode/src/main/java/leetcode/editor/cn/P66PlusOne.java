//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组


package leetcode.editor.cn;

import org.junit.Assert;

//Java：加一
public class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
        // TO TEST
        Assert.assertArrayEquals(new int[]{1, 2, 5}, solution.plusOne(new int[]{1, 2, 4}));
        Assert.assertArrayEquals(new int[]{1}, solution.plusOne(new int[]{0}));
        Assert.assertArrayEquals(new int[]{1, 0, 0}, solution.plusOne(new int[]{9, 9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] = ++digits[i];

                if (digits[i] <= 9) {
                    return digits;
                }
                digits[i] = digits[i] % 10;

            }
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;

        }

        private int plusOneByIndex(int[] digits, int i) {

            return plusOneByIndex(digits, i);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}