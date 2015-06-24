package leetcode;
/**Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/
public class LinkedListCycle {
	  class ListNode {
	      int val;
	      ListNode next;
	     ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	public boolean hasCycle(ListNode head) {
        ListNode n1=head,n2=head;
        while(n2!=null){
            n1 = n1.next;
            n2 = n2.next;
            if(n2== null)
            	return false;
            n2=n2.next;
            if(n1==n2)
            	return true;
        }
        return false;
    }
}
