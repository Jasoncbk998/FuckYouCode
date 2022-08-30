public class 合并两个有序链表_21 {
    /**
     * 基本思路
     * 创建一个新节点,合并后的节点依次添加到这个节点上
     * 创建一个临时节点,操作临时节点
     * 两个节点不等于null,进行比较大小
     * 让一个节点为null时,说明有一个节点循环结束,直接把另一个节点直接添加就行
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 两个链表合并到一起,也就是返回一个新的链表,然后不断的next进去新的节点
        // 比对l1和l2的val大小,进行节点next
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            // 节点
            prev = prev.next;
        }
        // 因为结束while是其中一个链表是null 所以另一个链表不为null 所以需要整体next过去
        prev.next = (l1 == null) ? l2 : l1;
        return preHead.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.add(2);
        l1.add(4);
        l1.add(6);
        ListNode l2 = new ListNode(1);
        l2.add(3);
        l2.add(5);
        l2.add(7);
        ListNode listNode = mergeTwoLists(l1, l2);
        listNode.print();
    }
}
