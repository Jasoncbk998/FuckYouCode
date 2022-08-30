public class _206 {
    public ListNode rev(ListNode head) {
        ListNode node = null;
        ListNode temp = head;
        // 5,4,3,2,1
        while (temp != null) {
            // 4,3,2,1
            ListNode next = temp.next;
            // 5,null
            next.next = node;
            // 5,null
            node = next;
            temp = next;
        }
        return node;
    }
}
