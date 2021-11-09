//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针 👍 1554 👎 0


package leetcode.editor.cn.hot100.finished;

/**
 * @author lucas9
 * @Date 2021-09-10 15:41:51
 */
public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        Solution solution = new 删除链表的倒数第N个结点().new Solution();
        // DO TEST
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode = solution.removeNthFromEnd(listNode1, 2);
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode temp = new ListNode(0, head);
            ListNode slow = temp, fast = head;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (null != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return temp.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
