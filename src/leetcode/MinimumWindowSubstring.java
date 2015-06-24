package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {
	public static void main(String[] args){
		System.out.println(new MinimumWindowSubstring().minWindow("123","133"));
	}
	public String minWindow(String s, String t) {
        int minW_i=0, minW_j=s.length()+1;
        int i=0, j=0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        HashMap<Character, Integer> targetMap = new HashMap<Character, Integer>();
        for(char ch: tChars){
        	if(!targetMap.containsKey(ch)){
        		targetMap.put(ch, 1);
        	}
        	else
        		targetMap.put(ch, targetMap.get(ch)+1);
        }
        HashMap<Character, Integer> windowMap = new HashMap<Character, Integer>();
        int count = 0;
        int expectedCount= tChars.length;
        while(j<sChars.length+1){
            
            if(count==expectedCount){
       
                if((j-i)<(minW_j-minW_i)){
                    minW_i = i;
                    minW_j = j;
                }
                if(targetMap.keySet().contains(sChars[i])){
                	int tempCount = windowMap.get(sChars[i])-1;
                	windowMap.put(sChars[i], tempCount);
                	if(tempCount<targetMap.get(sChars[i])){
                		count--;
                	}
                }
                i++;                
            }
            else{
                if(j==sChars.length)
                    break;
                if(targetMap.keySet().contains(sChars[j])){
                	int tempCount = 1;
                	if(windowMap.containsKey(sChars[j])){
                		tempCount = windowMap.get(sChars[j])+1;
                	}
                	windowMap.put(sChars[j],tempCount);
                	if(tempCount<=targetMap.get(sChars[j]))
                		count++;
                 }
                j++;
            }
        }
        minW_j %=(s.length()+1);
        return s.substring(minW_i, minW_j);
        
    }
}
