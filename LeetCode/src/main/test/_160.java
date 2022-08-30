public class _160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 任意一个链表是null 就不会相交
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? b : a.next;
            b = (b == null) ? a : b.next;
        }
        return a;

    }
}
