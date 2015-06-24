package leetcode;
/**
 * Sort a linked list using insertion sort.

Hide Tags Linked List Sort

 * @author Lowry
 *
 */
public class InsertionSortList {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	public ListNode insertionSortList(ListNode head) {
        if(head == null||head.next == null)
            return head;
        ListNode node = head.next;
        head.next=null;
        while(node!=null){
            ListNode preInsertNode = null;
            ListNode insertNode = head;
            ListNode tempNode = node.next;
            while(insertNode!=null){
                if(node.val<insertNode.val){
                    if(preInsertNode == null){
                        node.next = insertNode;
                        head = node;
                    }
                    else{
                        node.next = insertNode;
                        preInsertNode.next = node;
                    }
                    break;
                }
                preInsertNode = insertNode;
                insertNode = insertNode.next;
            }
            if(insertNode == null){
                preInsertNode.next = node;
                node.next = null;
            }
            node = tempNode;
        }
        return head;
    }
}
