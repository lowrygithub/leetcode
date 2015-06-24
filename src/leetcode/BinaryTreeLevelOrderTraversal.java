package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Hide Tags Tree Breadth-first Search

 * @author Lowry
 *
 */
public class BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        addToList(root,1);
        return resultList;
    }
    public void addToList(TreeNode node, int level){//DFS
        if(node == null)
            return;
        if(resultList.size()<level)
            resultList.add(new ArrayList<Integer>());
        List<Integer> list = resultList.get(level-1);
        list.add(node.val);
        addToList(node.left, level+1);
        addToList(node.right, level+1);
    }
}
