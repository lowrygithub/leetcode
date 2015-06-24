package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Tags Tree Stack

 * @author Lowry
 *
 */
public class BinarySearchTreeIterator {

	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	List<Integer> BSTList;
    int index=0;
    int length;
    public BinarySearchTreeIterator(TreeNode root) {
        BSTList = new ArrayList<Integer>();
        initList(root);
        length = BSTList.size();
    }
    public void initList(TreeNode node){
        if(node == null)
            return;
        initList(node.left);
        BSTList.add(node.val);
        initList(node.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(index==length)
            return false;
        else
            return true;
    }

    /** @return the next smallest number */
    public int next() {
        return BSTList.get(this.index++);
    }
    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */

}
