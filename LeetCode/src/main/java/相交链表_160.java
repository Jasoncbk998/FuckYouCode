import java.util.HashSet;
import java.util.Set;

public class 相交链表_160 {
    // 双指针

    /**
     * 基本思路
     *
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        // 当pA!=pB时会一直while循环,相等则返回pA节点
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        //相等
        return pA;
    }
}
