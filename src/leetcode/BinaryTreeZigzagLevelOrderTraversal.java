package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * @author Lowry
 *##方法1：用DFS解决BFS的问题，真是叼！！
 *##方法2：BFS（）队列
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(root, resultList, 0);
        return resultList;
    }
    public void dfs(TreeNode node, List<List<Integer>> res, int level){
        if(node == null)
            return;
        if(res.size()==level){
            List<Integer> list = new LinkedList<Integer>();
            res.add(list);
        }
        List<Integer> levelList = res.get(level);
        if(level%2==0)
            levelList.add(node.val);
        else
            levelList.add(0, node.val);
        dfs(node.left, res, level+1);
        dfs(node.right, res, level+1);
    }
}
