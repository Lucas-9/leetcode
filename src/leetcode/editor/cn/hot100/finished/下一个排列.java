//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//
// 示例 3：
//
//
//输入：nums = [1,1,5]
//输出：[1,5,1]
//
//
// 示例 4：
//
//
//输入：nums = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics 数组 双指针 👍 1316 👎 0


package leetcode.editor.cn.hot100.finished;

/**
 * @author lucas9
 * @Date 2021-09-10 15:41:43
 */
public class 下一个排列 {
    public static void main(String[] args) {
        Solution solution = new 下一个排列().new Solution();
        // DO TEST
        int[] nums = {1,3,5};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int x = n - 1;
            while (x > 0 && nums[x] <= nums[x - 1]) {
                x--;
            }
            if (x != 0) {
                int y = n - 1;
                while (nums[y] <= nums[x - 1]) {
                    y--;
                }
                swap(nums, x - 1, y);
            }
            reverse(nums, x, n - 1);
        }
        public void swap(int[] nums, int x, int y) {
            int t = nums[x];
            nums[x] = nums[y];
            nums[y] = t;
        }
        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
