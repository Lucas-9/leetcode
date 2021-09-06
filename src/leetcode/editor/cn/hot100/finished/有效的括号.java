//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串 👍 2608 👎 0


package leetcode.editor.cn.hot100.finished;

import java.util.Deque;
import java.util.LinkedList;
/**
 * @author lucas9
 */
public class 有效的括号 {
    public static void main(String[] args) {
        Solution solution = new 有效的括号().new Solution();
        // DO TEST
        System.out.println(solution.isValid("))"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            /** 用 Deque比 Stack 快很多，因为 Stack 用了 synchronized 修饰 */
            Deque<Character> stack = new LinkedList<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    stack.push(')');
                } else if (chars[i] == '[') {
                    stack.push(']');
                } else if (chars[i] == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || chars[i] != stack.pop()) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
