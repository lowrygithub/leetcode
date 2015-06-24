package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Word Break II Total Accepted: 33136 Total Submissions: 188942 My Submissions Question Solution 
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

Hide Tags Dynamic Programming Backtracking
Have you met this question in a real interview? Yes  No
Discuss


 * @author Lowry
 *
 */
public class WordBreakII {
	publi
	public List<String> wordBreak(String s, Set<String> wordDict) {
		int len = s.length();
		List[] resultArray = new ArrayList[len+1];
		List<String> l = new ArrayList<String>();
		l.add("");
		resultArray[0] = l;
		for(int i=1;i<len+1;i++){
			List<String> newList = new ArrayList<String>();
			for(int j=0;j<i;j++){
				List<String> list = resultArray[j];
				
				if(list.isEmpty()==false&&wordDict.contains(s.substring(j, i))){
					for(String str:list){
						if(str.equals(""))
							newList.add(s.substring(j, i));
						else
							newList.add(str+" "+s.substring(j, i));
					}
				}
			}
			resultArray[i]=newList;
		}
		return resultArray[len];
		 
	}

}