package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LetterCombinationsofaPhoneNumber {
	public static List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<String>();
        resultList.add("");
        String[] charMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i=0;i<digits.length();i++){
        	String chars=charMap[digits.charAt(i)-'0'];
        	List<String> tempList = new ArrayList<String>();
//        	tempList.addAll(resultList);
        	for(String result:resultList){
        		for(int j=0;j<chars.length();j++){
        			tempList.add(result+chars.charAt(j));
        		}
        	}
        	resultList=tempList;
        }
        if(resultList.isEmpty())
            resultList.add("");
        return resultList;
    }
	public static void main(String[] args){
		List<String> result = letterCombinations("234");
		for(String s :result)
			System.out.println(s);
	}
}
