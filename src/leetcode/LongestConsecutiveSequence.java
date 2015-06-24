package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

Hide Tags Array

 * @author Lowry
 *
 */
public class LongestConsecutiveSequence {

	public LongestConsecutiveSequence() {
	}

	/**
	 * solution1:TreeSet
	 */
	public int longestConsecutive(int[] num) {
        Set<Integer> set = new TreeSet<Integer>();
        for(int i=0;i<num.length;i++)
            set.add(num[i]);
        int max=1;
        int count = 1;
        Iterator<Integer> iter= set.iterator();
        int n = iter.next();
        while(iter.hasNext()){
            int nextN = iter.next();
            if(n+1!=nextN){
                if(count>max)
                    max = count;
                count=1;
            }
            else
                count++;
            n=nextN;
        }
        if(count>max)
            max=count;
        return max;
    }
	/**
	 * solution2:HashMap-ask your neighbor(better solution£¡)
	 * @param num
	 * @return
	 */
	public int longestConsecutive2(int[] num) {
        int max=0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i:num){
            if(!map.containsKey(i)){
                int left = 0;
                int right = 0;
                if(map.containsKey(i-1))
                    left = map.get(i-1);
                if(map.containsKey(i+1))
                    right = map.get(i+1);
                int value = left+right+1;
                map.put(i,value);
                map.put(i-left,value);
                map.put(i+right,value);
                max=max>value?max:value;
            }
        }
        return max;
    }
}
