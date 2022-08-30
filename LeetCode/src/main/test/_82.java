public class _82 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        ListNode cur = temp;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int x = cur.val;
                while (cur .next!= null && cur.next.val == x) {
                    cur.next=cur.next.next;
                }
            }else {
                cur=cur.next;
            }
        }
        return temp;


    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(3);
        node.add(4);
        node.add(4);
        node.add(5);
        deleteDuplicates(node.next).print();
        System.out.println("");
    }
}
