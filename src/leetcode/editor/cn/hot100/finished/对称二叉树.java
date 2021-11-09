//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1519 👎 0


package leetcode.editor.cn.hot100.finished;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lucas
 * @Date 2021-09-06 10:10:40
 */
public class 对称二叉树 {
    public static void main(String[] args) {
        Solution solution = new 对称二叉树().new Solution();
        // DO TEST [1,2,2,3,4,4,3]
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = null;
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = null;
        TreeNode t7 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(solution.check(t1));
    }
    public static class TreeNode {
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
        public boolean isSymmetric(TreeNode root) {
            return check(root);
        }
        public boolean check(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode t1 = root, t2 = root;
            q.offer(t1);
            q.offer(t2);
            while (!q.isEmpty()) {
                t1 = q.poll();
                t2 = q.poll();
                if (null == t1 && null == t2) {
                    continue;
                }
                if (null == t1 || null == t2 || t1.val != t2.val) {
                    return false;
                }
                q.offer(t1.left);
                q.offer(t2.right);
                q.offer(t1.right);
                q.offer(t2.left);
            }
            return true;
        }
        public boolean check(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
