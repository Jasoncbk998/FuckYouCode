public class 删除排序链表中的重复元素2_82 {
    /**
     * 有序链表
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        ListNode cur = temp;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int x = cur.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return temp;
    }
}
