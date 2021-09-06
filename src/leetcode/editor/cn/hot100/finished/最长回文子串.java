//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划 👍 4026 👎 0


package leetcode.editor.cn.hot100.finished;
/**
 * @author lucas9
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        Solution solution = new 最长回文子串().new Solution();
        // DO TEST
        System.out.println(solution.longestPalindrome("abcba"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            char[] str = s.toCharArray();
            char[] chars = new char[(str.length << 1) + 3];
            int[] p = new int[(str.length << 1) + 3];
            int ind = 0;
            chars[ind++] = '^';
            for (int i = 0; i < str.length; i++) {
                chars[ind++] = '#';
                chars[ind++] = str[i];
            }
            chars[ind++] = '#';
            chars[ind] = '$';
            int mid = 0,mx = 0,c = 0,r = 0;
            p[0] = 0;
            for (int i = 1; i < ind; i++) {
                /**
                 * (mid << 1) - i 是找 i 关于 mid 的对应点，假设对应点为 j 则：j = mid - (i - mid) = 2mid - i
                 * 又 j 和 i 关于 mid 对称，所以有 p[i] = Math.min(p[j],mx - i) 当且仅当 mx > i，
                 * 取较小值： i + p[j] 可能超出 mx，这时超出的那一部分是不具有参考价值的
                 * 取较小值： mx - i 中有一部分不在 p[j] 范围内，没有参考价值
                 */
                p[i] = mx > i ? Math.min(p[(mid << 1) - i],mx - i) : 1;
                while (chars[i + p[i]] == chars[i - p[i]]) {
                    p[i]++;
                }
                if (p[i] + i > mx) {
                    mx = p[i] + i;
                    mid = i;
                }
                if (p[i] > r) {
                    r = p[i];
                    c = i;
                }
            }
            int start = (c - r) / 2,end = start + r - 1;
            return s.substring(start, end);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
