//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


package leetcode.editor.cn;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

//Java：两数之和
public class P1TwoSum{
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        // TO TEST


        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] ints = solution.twoSum(nums, target);

        Assert.assertArrayEquals(ints, new int[]{0, 1});

        nums = new int[]{2,3,-5,99,0,12};
        target = 3;
        ints = solution.twoSum(nums, target);
        Assert.assertArrayEquals(ints, new int[]{1, 4});

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        /**
         *  一种方法是循环处理两次，
         *  时间复杂度 O(1) , 空间复杂度 O(n)
         */
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        int toFindNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            toFindNum = target - current;
            if(map.containsKey(toFindNum)){
                int index = map.get(toFindNum);
                return new int[]{index, i};
            }
            map.put(current, i);
        }
        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}