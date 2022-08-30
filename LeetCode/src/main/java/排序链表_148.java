import java.util.Arrays;

public class 排序链表_148 {
    /**
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * 基本思路
     * 第一次while 计算出链表有n个节点,然后在创建长度为n的数组
     * 然后 第二次while 按照链表顺序去存储在对应的位置的数组上存储  ints[序号]=value值
     * 针对数组进行排序
     * 然后排序后的数组写入链表
     */
    public ListNode sortList(ListNode head) {
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
        int i = 0;
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


}
