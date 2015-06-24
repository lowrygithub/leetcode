package leetcode;
/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

Hide Tags Tree Depth-first Search

 * @author Lowry
 *
 */
public class ConvertSortedArraytoBinarySearchTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		      }
	public TreeNode sortedArrayToBST(int[] num) {
        int length = num.length;
        int mid = length/2;
        TreeNode root = new TreeNode(num[mid]);
        if(mid == 0)
            root.left = null;
        else{
        	int[] num2 = new int[mid]; 
        	System.arraycopy(num, 0, num2, 0, mid);
            root.left = sortedArrayToBST(num2);
            }
        if(mid == length-1)
            root.right = null;
        else{
        	int[] num3 = new int[length-mid-1];
        	System.arraycopy(num, mid+1, num3, 0, length-mid-1);
        	root.right = sortedArrayToBST(num3);
        }
        return root;
    }
}
