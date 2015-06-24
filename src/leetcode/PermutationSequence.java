package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

Hide Tags Backtracking Math

 * @author Lowry
 *
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
        String result="";
        int base=1;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            base*=i;
            list.add(i);
        }
        k--;
        for(int i=n;i>=1;i--){
            base = base/i;
            result+=list.get(k/base);
            list.remove(k/base);
            k=k%base;
        }
        return result;
    }
	public static void main(String[] args){
		PermutationSequence p = new PermutationSequence();
		p.getPermutation(1, 1);
	}
}
