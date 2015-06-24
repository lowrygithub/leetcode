package leetcode;
/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Credits:
Special thanks to @amrsaqr for adding this problem and creating all test cases.

Hide Tags Tree Depth-first Search Breadth-first Search

 */
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        if(root == null)
            return resultList;
        List<Integer> leftList = rightSideView(root.left);
        List<Integer> rightList = rightSideView(root.right);
        resultList = rightList;
        if(leftList.size()>rightList.size()){
            for(int i=rightList.size();i<leftList.size();i++){
                resultList.add(leftList.get(i));
            }
        }
        resultList.add(0, root.val);
        return resultList;
        
    }
}
