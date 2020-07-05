//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


package leetcode.editor.cn;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode result = solution.mergeTwoLists(l1, l2);
        StringBuffer sb = new StringBuffer();
        while (result.next != null) {
            sb.append(result.val + ",");
            result = result.next;
        }
        System.out.println(sb.toString());

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode l1Last = null;
            while (l1.next != null) {

                while (l2.next != null) {

                    if (l2.val >= l1.val) {
                        if (l1Last != null) {
                            l1Last.next = l2;
                        }
                        ListNode tmp = l2.next;
                        l2.next = l1;
                        l2 = tmp;
                    } else {
                        l2 = l2.next;
                    }
                }

                l1 = l1.next;
            }
            return l1;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}