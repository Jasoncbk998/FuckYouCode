import javafx.scene.web.HTMLEditor;

public class 环形链表_141 {
    /**
     * 链表是否成环
     * 先判断链表头结点和下个节点是不是null 如果头和第二个节点是空就一定不是
     * 快慢指针,快指针就是head.next 慢指针就是head
     * 判断快慢节点是否相等,快节点为null 或者快节点的next是null 就一定不成环
     */
    public static boolean hasCycle(ListNode head) {
        // 如果链表只有一个元素那么肯定不是环
        if (head == null || head.next == null) return false;
        // 快慢指针
        ListNode fast = head.next;
        ListNode slow = head;
        // 如果快慢指针相等则必成环
        while (slow != fast) {
            // 快指针的下个节点为null,则必不成环
            if (fast == null || fast.next == null) {
                return false;
            }
            // 比较下一个节点
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
