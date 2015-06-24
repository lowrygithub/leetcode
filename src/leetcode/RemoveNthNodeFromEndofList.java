package leetcode;
/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

Hide Tags Linked List Two Pointers

 * @author Lowry
 *
 */
public class RemoveNthNodeFromEndofList {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		 }
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left=head,right=head;
        for(int i=0;i<n;i++)
            right = right.next;
        if(right == null)
            head = head.next;
        else{
            while(right.next!=null){
                left = left.next;
                right = right.next;
            }
            left.next = left.next.next;
        }
        return head;
        
    }
}
