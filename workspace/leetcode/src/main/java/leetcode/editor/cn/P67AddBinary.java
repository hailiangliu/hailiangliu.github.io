//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串


package leetcode.editor.cn;

import org.junit.Assert;

//Java：二进制求和
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        // TO TEST
        Assert.assertTrue("100".equals(solution.addBinary("11", "1")));
        Assert.assertTrue("10101".equals(solution.addBinary("1010", "1011")));
        Assert.assertTrue("11110".equals(solution.addBinary("1111", "1111")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *  这里一定要注意 char表示int 值得转换方法!!! 不是直接char强转！（强转转换的结果是ascii码，完全不是预期）
     */
    class Solution {
        public String addBinary(String a, String b) {

            char[] aChar = a.toCharArray();
            char[] bChar = b.toCharArray();


            int maxLength = aChar.length > bChar.length ? aChar.length : bChar.length;

            char[] result = new char[maxLength];

            int pop = 0;

            int aIdx = aChar.length - 1;
            int bIdx = bChar.length - 1;

            int resultIndex = result.length - 1;
            while (aIdx >= 0 || bIdx >= 0) {
                int tmp = pop;
                if (aIdx >= 0) {
                    tmp = tmp + (aChar[aIdx] - '0');
                    aIdx--;

                }
                if (bIdx >= 0) {
                    tmp = tmp + (bChar[bIdx] - '0');
                    bIdx--;
                }
                if (tmp >= 2) {
                    pop = 1;
                    tmp = tmp % 2;
                } else {
                    pop = 0;
                }
                result[resultIndex--] = (char) (tmp + '0');
            }
            if (pop == 1) {
                char[] popResult = new char[result.length + 1];
                popResult[0] = '1';
                System.arraycopy(result, 0, popResult, 1, result.length);
                result = popResult;
            }

            StringBuffer sb = new StringBuffer();
            for (char c : result) {
                sb.append(c);
            }
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}