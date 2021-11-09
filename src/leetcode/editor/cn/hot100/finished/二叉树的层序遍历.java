//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索 二叉树 👍 997 👎 0


package leetcode.editor.cn.hot100.finished;

import java.util.*;

/**
 * @author lucas9
 * @Date 2021-09-08 15:21:59
 */
public class 二叉树的层序遍历 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的层序遍历().new Solution();
        // DO TEST
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode.left = treeNode9;
        treeNode.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        System.out.println(solution.levelOrder(treeNode));

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (null == root) {
                return ans;
            }
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty() ) {
                ArrayList<Integer> temp = new ArrayList<>();
                int size = q.size();
                while (size > 0) {
                    TreeNode poll = q.poll();
                    temp.add(poll.val);
                    if (null != poll.left) {
                        q.add(poll.left);
                    }
                    if (null != poll.right) {
                        q.add(poll.right);
                    }
                    size--;
                }
                ans.add(temp);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
