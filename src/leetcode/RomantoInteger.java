package leetcode;

import java.util.HashMap;

public class RomantoInteger {
	public int romanToInt(String s) {
        HashMap<String,Integer> map = new HashMap<String,Integer>(){{
			put("I",1);
			put("V",5);
			put("X",10);
			put("L",50);
			put("C",100);
			put("D",500);
			put("M",1000);
		}};
        int sum=0;
        int i;
        for(i=0;i<s.length()-1;i++){
            int pre = map.get(s.charAt(i));
            int next = map.get(s.charAt(i+1));
            if(pre>=next)
                sum+=pre;
            else
                sum-=pre;
        }
        sum+=map.get(s.charAt(i));
        return sum;
    }
}
