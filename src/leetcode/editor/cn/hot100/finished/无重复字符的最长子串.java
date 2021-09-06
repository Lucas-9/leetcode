//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口
// 👍 5928 👎 0


package leetcode.editor.cn.hot100.finished;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @author lucas9
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution solution = new 无重复字符的最长子串().new Solution();
        System.out.println(solution.lengthOfLongestSubstring(""));
        // DO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            char[] chars = s.toCharArray();
            Queue<Character> q = new LinkedList<Character>();
            boolean[] vis = new boolean[256];
            int ans = 0;
            for (int i = 0; i < len; i++) {
                if (vis[chars[i]]) {
                    while (!q.peek().equals(chars[i]) && !q.isEmpty()) {
                        vis[q.poll().charValue()] = false;
                    }
                    vis[q.poll().charValue()] = false;
                }
                q.add(chars[i]);
                vis[chars[i]] = true;
                ans = Math.max(ans, q.size());
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
