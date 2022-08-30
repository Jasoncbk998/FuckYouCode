import java.util.ArrayList;

public class _143 {
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next=list.get(j);
            i++;
            if(i==j){
                break;
            }
            list.get(j).next=list.get(i);
            j--;
        }
        list.get(i).next=null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);
        reorderList(node.next);
        node.print();

    }
}
