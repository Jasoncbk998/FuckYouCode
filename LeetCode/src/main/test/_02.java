public class _02 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        int carry = 0, newVal = 0;
        while (p1 != null || p2 != null || carry > 0) {
            newVal = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
            carry = newVal / 10;
            newVal = newVal % 10;
            temp.next = new ListNode(newVal);
            p1 = (p1 == null) ? null : p1.next;
            p2 = (p2 == null) ? null : p2.next;
            temp = temp.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);
        p1.add(1);
        p1.add(2);
        p1.add(3);
        p2.add(1);
        p2.add(2);
        p2.add(3);
        addTwoNumbers(p1.next, p2.next).print();


    }
}
