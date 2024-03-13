package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class 反转链表_206 {


    public ListNode reverseList_1(ListNode head) {
        ListNode node = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = node;
            node = curr;
            curr = next;
        }
        return node;
    }

    public ListNode reverseList(ListNode head) {
        ListNode  node=null;
//        1,2,3,4,5
        ListNode curr=head;
        while (curr!=null){
//            2,3,4,5
//            3,4,5
            ListNode next = curr.next;
//            2,1,null
            curr.next=node;
//            2,1,null
            node=curr;
//           3,4,5
            curr=next;
        }
        return node;
    }


    public static void main(String[] args) {
        反转链表_206 test = new 反转链表_206();
        ListNode listNode = new ListNode(1);
        listNode.add(2);
        listNode.add(3);
        listNode.add(4);
        listNode.add(5);
        listNode.print();

        ListNode listNode1 = test.reverseList(listNode);
        listNode1.print();
    }
}
