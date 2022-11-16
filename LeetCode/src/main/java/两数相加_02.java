
public class 两数相加_02 {
    /**
     * 依次取出每个节点的next.val
     * 分别取出进位和余数,作为和节点的值和下一个节点的进位值
     * 然后每个节点next
     * 循环条件是  (p1 != null || p2 != null || carry > 0)
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 复制一份对象,内存地址是一样的
        ListNode p1 = l1, p2 = l2;
        // 初始化节点,-1是节点,最后返还进行 dummy.next
        ListNode node = new ListNode(-1);
        // 不断向临时节点.next中追加节点
        ListNode temp = node;
        int carry = 0, newVal = 0;
        // 任意一个条件符合就要进入循环
        while (p1 != null || p2 != null || carry > 0) {
            newVal = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
            // 进位,得到十位数
            carry = newVal / 10;
            // 取余,18%10=8 得到个位数
            newVal = newVal % 10;
            temp.next = new ListNode(newVal);
            // 链表.next
            p1 = (p1 == null) ? null : p1.next;
            p2 = (p2 == null) ? null : p2.next;
            //添加节点
            temp = temp.next;
        }
        //进行返回
        return node.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.add(1);
        listNode.add(2);
        listNode.add(3);
        ListNode listNode2 = new ListNode(0);
        listNode2.add(1);
        listNode2.add(2);
        listNode2.add(3);
        ListNode listNode1 = addTwoNumbers(listNode, listNode2);
        listNode1.print();
    }
}
