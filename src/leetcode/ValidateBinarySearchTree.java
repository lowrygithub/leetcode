package leetcode;
/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
Hide Tags Tree Depth-first Search

 * @author Lowry
 *
 */
public class ValidateBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);//这里用Long是为了包括Integer的最大最小值
    }
    public boolean isValid(TreeNode node, long min, long max){
        if(node == null)
            return true;
        if(node.val<=min || node.val>=max)
            return false;
        return(isValid(node.left,min,node.val) && isValid(node.right,node.val,max));
    }
}
