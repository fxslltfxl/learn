package leetcode.middle;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2021/11/5
 **/


//Given the head of a linked list, remove the nth node from the end of the list
//and return its head.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//
//
// Example 2:
//
//
//Input: head = [1], n = 1
//Output: []
//
//
// Example 3:
//
//
//Input: head = [1,2], n = 1
//Output: [1]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
//
//
// Follow up: Could you do this in one pass?
// Related Topics Linked List Two Pointers
// 👍 7399 👎 375


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
//leetcode submit region end(Prohibit modification and deletion)


public class Number19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = reversalList(head);
        ListNode pre = null;
        ListNode target = tail;
        ListNode next = target.next;
        int i = 1;
        while (i++ != n) {
            pre = target;
            target = next;
            next = next.next;
        }
        if (pre != null) {
            target.next = null;
            pre.next = next;
            return reversalList(tail);
        } else {
            target = null;
            return reversalList(next);
        }
    }


    public ListNode reversalList(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        ListNode q = p.next;
        if (q == null) return head;
        head.next = null;
        ListNode l = q.next;
        if (l == null) {
            q.next = p;
            return q;
        }
        while (l != null) {
            q.next = p;
            p = q;
            q = l;
            l = l.next;
        }
        q.next = p;
        return q;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
//写字楼里写字间，写字间里程序员；  
//程序人员写程序，又拿程序换酒钱。  
//酒醒只在网上坐，酒醉还来网下眠；  
//酒醉酒醒日复日，网上网下年复年。  
//但愿老死电脑间，不愿鞠躬老板前；  
//奔驰宝马贵者趣，公交自行程序员。  
//别人笑我忒疯癫，我笑自己命太贱；  
//不见满街漂亮妹，哪个归得程序员？ 