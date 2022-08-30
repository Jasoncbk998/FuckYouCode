import java.util.Arrays;

public class _148 {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        // 节点数量
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int[] ints = new int[n];
        // 遍历链表 to int[]
        temp = head;
        int i=0;
        while (temp != null) {
            // 因为数组是0开始计位
            ints[i] = temp.val;
            i++;
            temp = temp.next;
        }
        Arrays.sort(ints);
        temp = head;
        for (int j = 0; j < n; j++) {
            temp.val = ints[j];
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.add(5);
        node.add(4);
        node.add(3);
        node.add(2);
        node.add(1);
        sortList(node.next).print();
    }
}
