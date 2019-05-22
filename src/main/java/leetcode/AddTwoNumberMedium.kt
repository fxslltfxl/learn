package leetcode

class AddTwoNumberMedium {

    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode? {
        val dummyHead = ListNode(0)
        var p: ListNode? = l1
        var q: ListNode? = l2
        var curr: ListNode? = dummyHead
        var carry = 0
        while (p != null || q != null) {
            val x = p?.`val` ?: 0
            val y = q?.`val` ?: 0
            val sum = carry + x + y
            carry = sum / 10
            curr!!.next = ListNode(sum % 10)
            curr = curr.next
            if (p != null) p = p.next
            if (q != null) q = q.next
        }
        if (carry > 0) {
            curr!!.next = ListNode(carry)
        }
        return dummyHead.next
    }

    inner class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
