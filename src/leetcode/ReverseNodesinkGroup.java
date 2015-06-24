package leetcode;
/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Hide Tags Linked List

 * @author Lowry
 *
 */
public class ReverseNodesinkGroup {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int length=0;
        while(node!=null){
            node=node.next;
            length++;
        }
        if(length == 1||length == 0||k==1)
            return head;
        ListNode pre, cur, post, prehead = null, returnNode=head;
        for(int i=0;i<length/k;i++){
            pre = head;
            cur = pre.next;
            for(int j=0;j<k-1;j++){
                post = cur.next;
                cur.next = pre;
                pre = cur;
                cur = post;
            }
            if(i==0)
                returnNode = pre;
            if(i!=0){
            	prehead.next=pre;
            }
            prehead = head;
            head.next = cur;
            head = cur;
        }
        return returnNode;
    }
	public static void main(String[] args){
		ReverseNodesinkGroup r = new ReverseNodesinkGroup();
		ListNode n1 = r.new ListNode(1);
		ListNode n2 = r.new ListNode(2);
		ListNode n3 = r.new ListNode(3);
		ListNode n4 = r.new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		r.reverseKGroup(n1, 2);
	}
}
