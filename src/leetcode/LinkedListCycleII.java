package leetcode;
/**Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
*/
public class LinkedListCycleII {
	  class ListNode {
	      int val;
	      ListNode next;
	     ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	  public ListNode detectCycle(ListNode head) {
	        ListNode n1=head,n2=head;
	        while(n2!=null){
	            n1=n1.next;
	            n2=n2.next;
	            if(n2!=null)
	                n2=n2.next;
	            if(n1==n2)
	                break;
	        }
	        if(n2==null)
	            return null;
	        n1=head;
	        while(n1!=n2){
	            n1=n1.next;
	            n2=n2.next;
	        }
	        return n2;
	    }
}
