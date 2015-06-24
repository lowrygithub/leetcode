package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
Hide Tags Array Backtracking

 * @author Lowry
 *
 */
public class CombinationSum {
	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int si=0 ; si<candidates.length ; si++){
        	List<Integer> list = new ArrayList<Integer>();
            backtrack(candidates, si, target, list);
        }

        return resultList;    
    }
    public void backtrack(int[] candidates, int startIndex, int target, List<Integer> list){
        if(candidates[startIndex]>target)
            return;
        else if(candidates[startIndex] == target){
            list.add(target);
            resultList.add(list);
            return;
        }
        else{
        	list.add(candidates[startIndex]);
            for(int si=startIndex;si<candidates.length;si++){
            	List tempList = new ArrayList(list);
                backtrack(candidates,si,target-candidates[startIndex],tempList);
            }
        }
    }
    public static void main(String[] args){
    	CombinationSum cs = new CombinationSum();
    	int[] candidates = {1,2};
    	int target = 3;
    	cs.combinationSum(candidates, target);
    	System.out.println();
    }
}
