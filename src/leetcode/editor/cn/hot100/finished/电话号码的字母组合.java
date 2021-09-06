//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 哈希表 字符串 回溯 👍 1482 👎 0


package leetcode.editor.cn.hot100.finished;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author lucas9
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        Solution solution = new 电话号码的字母组合().new Solution();
        // DO TEST
        System.out.println(solution.letterCombinations(""));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Map<Character, String> map = new HashMap<Character, String>();
        public List<String> ans = new ArrayList<String>();
        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return ans;
            }
            init();
            StringBuilder builder = new StringBuilder();
            dfs(0, digits, builder);
            return ans;
        }

        public void init() {
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
        }

        public void dfs(int index, String digits, StringBuilder builder) {
            if (index >= digits.length()) {
                ans.add(builder.toString());
                return;
            }
            char key = digits.charAt(index);
            String letter = map.get(key);
            for (int i = 0; i < letter.length(); i++) {
                builder.append(letter.charAt(i));
                dfs(index + 1, digits, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
