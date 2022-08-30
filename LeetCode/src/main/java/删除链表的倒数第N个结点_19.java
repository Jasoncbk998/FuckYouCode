

public class 删除链表的倒数第N个结点_19 {
    /**
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 基本思路
     * 先求出链表的长度
     * 然后推算出删除倒数第N个节点的: 条件范围公式 i < length - n + 1
     * 找到该节点 进行 next=next.next 删除节点
     * 然后dummy.next 返回即可
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        // 获得长度
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        ListNode cur = dummy;
        // length=5 n=2
        // 倒数第二个就是正数第四
        // 从第一个节点开始
        for (int i = 0; i < length - n ; ++i) {
            //寻找到需要删除节点的前一个节点
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static void main(String[] args) {
        删除链表的倒数第N个结点_19 temp = new 删除链表的倒数第N个结点_19();
        ListNode node = new ListNode(0);
        node.add(5);
//        node.add(4);
//        node.add(3);
//        node.add(2);
//        node.add(1);
        ListNode node1 = temp.removeNthFromEnd(node.next, 1);
//        node1.print();
    }
}