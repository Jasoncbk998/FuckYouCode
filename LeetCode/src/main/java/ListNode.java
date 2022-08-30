
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        System.out.print(this.val + "\t");
        if (this.next != null) {
            this.next.print();
        }
    }

    public void add(int newdata) {
        ListNode newNode = new ListNode(newdata);
        if (this.next == null) {
            this.next = newNode;
        } else {
            this.next.add(newdata);
        }
    }
}
