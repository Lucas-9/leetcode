//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学 👍 6726 👎 0


package leetcode.editor.cn.hot100.finished;
/**
 * @author lucas9
 * @Date 2021-09-08 17:39:21
 */
public class 两数相加 {
    public static void main(String[] args) {
        Solution solution = new 两数相加().new Solution();
        // DO TEST
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        ListNode sum = solution.addTwoNumbers(l1, l4);
        while (null != sum) {
            System.out.print(sum.val);
            sum = sum.next;
        }
        System.out.println();
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ListNode{");
            sb.append("val=").append(val);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode sum = null, head = null;
            int excess = 0;
            while (null != l1 || null != l2) {
                int temp = excess;
                if (null != l1) {
                    temp += l1.val;
                    l1 = l1.next;
                }
                if (null != l2) {
                    temp += l2.val;
                    l2 = l2.next;
                }
                if (null == head) {
                    head = sum = new ListNode(temp % 10);
                } else {
                    sum.next = new ListNode(temp % 10);
                    sum = sum.next;
                }
                excess = temp / 10;
            }
            if (0 != excess) {
                sum.next = new ListNode(excess);
            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
