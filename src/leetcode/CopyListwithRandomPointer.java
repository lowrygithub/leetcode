package leetcode;

import java.util.HashMap;

public class CopyListwithRandomPointer {

	class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		  };
	public RandomListNode copyRandomList(RandomListNode head) {
    	HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
    	if(head == null){
    	    return null;
    	}
    RandomListNode copyHead = new RandomListNode(head.label);
    RandomListNode node = head;
    RandomListNode copyNode = copyHead;
    map.put(copyNode, node);
    node=node.next;
    while(node!=null){
    	RandomListNode newNode = new RandomListNode(node.label);
    	copyNode.next = newNode;
    	map.put(newNode, node);
    	node = node.next;
    	copyNode = newNode;
    }
    copyNode.next = null;
    
    node = head;
    copyNode = copyHead;
    while(node!=null){
    	copyNode.random = map.get(node.random);
    	node=node.next;
    	copyNode = copyNode.next;
    }
    
    
    return copyHead;
    }
	public static void main(String[] args) {
		CopyListwithRandomPointer cp = new CopyListwithRandomPointer();
		RandomListNode node1 = cp.new RandomListNode(-1);
		RandomListNode node2 = cp.new RandomListNode(-2);
		RandomListNode node3 = cp.new RandomListNode(-3);
		node1.next=node2;
		node2.next = node3;
		node1.random=node1;
		node2.random=node1;
		node3.random=node2;
		
		RandomListNode node = cp.copyRandomList(node1);
		System.out.println();
	}

}
