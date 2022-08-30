import java.util.ArrayList;

public class 重排链表_143 {
    /*
    输入：head = [1,2,3,4]
    输出：[1,4,2,3]
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = head;
        // 把节点添加到list中
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
