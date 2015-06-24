package leetcode;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
Hide Tags Tree Depth-first Search

 * @author Lowry
 *
 */
public class PathSumII {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        addPath(root,sum,new ArrayList<Integer>());    
        return resultList;
    }
    public void addPath(TreeNode root, int sum, List<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        if(root.left==null&&root.right==null)
            if(root.val==sum)
                resultList.add(list);
        sum-=root.val;
        List<Integer> leftList = new ArrayList<>(list);
        List<Integer> rightList = new ArrayList<>(list);
        addPath(root.left, sum, leftList);
        addPath(root.right, sum, rightList);
    }
}
