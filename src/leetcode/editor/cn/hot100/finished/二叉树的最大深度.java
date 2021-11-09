//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 960 👎 0


package leetcode.editor.cn.hot100.finished;
/**
 * @author lucas9
 * @Date 2021-09-08 15:21:49
 */
public class 二叉树的最大深度 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的最大深度().new Solution();
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
        int ans = 0;
        public int maxDepth(TreeNode root) {
            int deep = 0;
            dfs(root, deep);
            return ans;
        }
        public void dfs(TreeNode root, int deep) {
            if (null == root) {
                return;
            }
            deep++;
            ans = Math.max(ans, deep);
            dfs(root.left, deep);
            dfs(root.right, deep);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
