package leetcode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        int carry = 0;
        ListNode node1 = l1, node2 = l2, curr = head;
        while (node1 != null || node2 != null) {
            int x = node1 == null ? 0 : node1.val;
            int y = node2 == null ? 0 : node2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (node1 != null) node1 = node1.next;
            if (node2 != null) node2 = node2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return null;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
