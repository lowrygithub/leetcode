package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
Hide Tags Array Backtracking

 * @author Lowry
 *
 */
public class CombinationSumII {

    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int si=0 ; si<candidates.length ; si++){
        	List<Integer> list = new ArrayList<Integer>();
            backtrack(candidates, si, target, list);
        }
        Set<List<Integer>> s = new HashSet<>(resultList);
        
        return new ArrayList(s);    
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
            for(int si=startIndex+1;si<candidates.length;si++){
            	List tempList = new ArrayList(list);
                backtrack(candidates,si,target-candidates[startIndex],tempList);
            }
        }
    }
    public static void main(String[] args){
    	CombinationSumII cs = new CombinationSumII();
    	int[] candidates = {1,1};
    	int target = 2;
    	cs.combinationSum2(candidates, target);
    	System.out.println();
    }
}
