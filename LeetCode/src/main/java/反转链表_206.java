
public class 反转链表_206 {
    /**
     * 基本思路
     * 创建一个空节点,用于接受反转的链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode node = null;
        ListNode curr = head;
        // 1,2,3,4,5
        while (curr != null) {
            // 2,3,4,5
            ListNode next = curr.next;
            // 1
            curr.next = node;
            // 1,null
            node = curr;
            // 2,3,4,5
            curr = next;
        }
        return node;
    }
}
