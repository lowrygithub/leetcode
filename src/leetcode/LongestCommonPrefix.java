package leetcode;
/**
 * Write a function to find the longest common prefix string amongst an array of strings.

Hide Tags String

 * @author Lowry
 *
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        String resultStr = "";
        if(strs.length==0)
            return "";
        for(int j=1;;j++){
            if(strs[0].length()<j)
                break;
            char c = strs[0].charAt(j-1);
            int i;
            for(i=1;i<strs.length;i++){
                if(strs[i].length()<j || strs[i].charAt(j-1)!=c)
                    break;
            }
            if(i==strs.length)
                resultStr += c;
            else
                break;
        }
        return resultStr;
    }
}
