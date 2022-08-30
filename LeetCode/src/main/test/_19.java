public class _19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode len = head;
        int length = 0;
        while (len != null) {
            ++length;
            len = len.next;
        }
        ListNode temp = head;
        for (int i = 0; i < length - n - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.add(5);
        node.add(4);
        node.add(3);
        node.add(2);
        node.add(1);
        ListNode node1 = removeNthFromEnd(node.next, 1);
        ListNode next = node1.next;
//        node1.print();
    }

}
