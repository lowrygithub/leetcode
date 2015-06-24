package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static void main(String[] args){
		System.out.println(new PalindromePartitioning().partition("ababa"));
		System.out.println(new PalindromePartitioning().judge(""));
	}
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<List<String>>();
        if(s.length()==1){
        	List<String> list = new ArrayList<String>();
        	list.add(s);
        	ans.add(list);
        }
        else{
        	if(judge(s)){
            	List<String> list = new ArrayList<String>();
            	list.add(s);
            	ans.add(list);
            }
        	for(int i=1;i<s.length();i++){
        		String pre = s.substring(0, i);
        		String post = s.substring(i);
        		if(judge(pre)){
        			List<List<String>> postAns = partition(post);
        			for(List<String> list:postAns){
        				list.add(0, pre);
        				ans.add(list);
        			}
        		}
        	}
        }
        return ans;
    }
    public boolean judge(String s){
    	for(int i=0;i<s.length()/2;i++){
    		if(s.charAt(i)!=s.charAt(s.length()-i-1))
    			return false;
    	}
    	return true;
    }
}
