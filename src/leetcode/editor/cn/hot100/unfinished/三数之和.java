//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -10⁵ <= nums[i] <= 10⁵
//
// Related Topics 数组 双指针 排序 👍 3693 👎 0


package leetcode.editor.cn.hot100.unfinished;

import java.util.*;
/**
 * @author lucas9
 */
public class 三数之和 {
    public static void main(String[] args) {
       Solution solution = new 三数之和().new Solution();
        // DO TEST
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
