/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
package leetcode;
class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxSum;
    }
    public int findMaxPath(TreeNode node){
        int leftMaxPath = Integer.MIN_VALUE;
        int rightMaxPath = Integer.MIN_VALUE;
        int sum = node.val;
        int singleSum = node.val;
        if(node.left!=null){
            leftMaxPath = findMaxPath(node.left);
        }
        if(node.right!=null){
            rightMaxPath = findMaxPath(node.right);
        }
        if(leftMaxPath>0)
            sum+=leftMaxPath;
        if(rightMaxPath>0)
            sum+=rightMaxPath;
        if(sum>maxSum)
            maxSum = sum;
        int bigger = leftMaxPath>rightMaxPath?leftMaxPath:rightMaxPath;
        if(bigger>0)
            singleSum+=bigger;
        return singleSum;
        
    }

}
