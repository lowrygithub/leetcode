package leetcode;
/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

Hide Tags Backtracking String

 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        gnrt("", n, n);
        return result;
    }
    public void gnrt(String src, int leftPNumLeft, int rightPNumLeft){
        if(leftPNumLeft==0&&rightPNumLeft==0)
            result.add(src);
        if(leftPNumLeft>0)
            gnrt(src+"(", leftPNumLeft-1, rightPNumLeft);
        if(leftPNumLeft<rightPNumLeft)
            gnrt(src+")", leftPNumLeft, rightPNumLeft-1);
    }
}
