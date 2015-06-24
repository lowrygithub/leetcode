package leetcode;
/**
 * Reverse a singly linked list.`
 * @author Lowry
 *
 */
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	      }
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head, cur = head.next, next;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }
}
