public class _21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);

        return temp;


    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        node1.add(2);
        node1.add(4);
        node1.add(6);
        ListNode node2 = new ListNode(-1);
        node2.add(1);
        node2.add(3);
        node2.add(5);
        ListNode node = mergeTwoLists(node2.next, node1.next);
        node.print();
    }
}