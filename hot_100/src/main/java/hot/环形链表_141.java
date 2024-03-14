package hot;


import javax.sound.midi.Soundbank;
import java.util.HashSet;
import java.util.Set;

public class 环形链表_141 {


    public boolean hasCycle(ListNode head) {
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
            // 快慢指针永远间隔一个节点
            // 慢指针在n节点
            slow = slow.next;
            // 快指针就在n+2节点
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 利用hashset添加元素,天然去重的原理,判断是否成环
     * @param head
     * @return
     */
    public boolean hasCycle_2(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        环形链表_141 test = new 环形链表_141();
        ListNode listNode = new ListNode(1);
        listNode.add(2);
        listNode.add(3);
        listNode.add(4);
        listNode.add(5);
        listNode.print();

        boolean listNode1 = test.hasCycle(listNode);
        System.out.println(listNode1);
    }
}
