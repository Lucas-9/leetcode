//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树 👍 683 👎 0


package leetcode.editor.cn.hot100.finished;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lucas9
 * @Date 2021-09-21 15:22:44
 */
public class 二叉树的后序遍历 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的后序遍历().new Solution();
        // DO TEST
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> ans = new ArrayList<>();
            dfs(ans, root);
            return ans;
        }
        public void dfs(List<Integer> ans, TreeNode root) {
            if (null != root) {
                dfs(ans, root.left);
                dfs(ans, root.right);
                ans.add(root.val);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
