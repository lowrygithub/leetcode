package leetcode;

public class DistinctSubsequences {
	/**
	 * O(n^2) space O(n^2) time
	 * @param S
	 * @param T
	 * @return
	 */
	public int numDistinct(String S, String T) {
		int s = S.length(), t = T.length();
		int[][] resultMat = new int[t + 1][s + 1];
		for (int i = 0; i < s + 1; i++)
			resultMat[0][i] = 1;
		for (int i = 1; i < s + 1; i++) {
			for (int j = 1; j < t + 1; j++) {
				resultMat[j][i] = resultMat[j][i - 1]
						+ (T.charAt(j - 1) == S.charAt(i - 1) ? resultMat[j - 1][i - 1]
								: 0);
			}
		}
		return resultMat[t][s];
	}
	
	/**
	 * O(n) space O(n^2) time
	 * @param args
	 */
	/*public int numDistinct(String S, String T) {
        int s=S.length(), t=T.length();
        if(s<t)
            return 0;
        int[] resultVec = new int[t+1];
        resultVec[0] = 1;
        for(int i = 1;i < s+1 ; i++){
            for(int j = t;j >0;j--){
                resultVec[j]=resultVec[j]+(T.charAt(j-1)==S.charAt(i-1)?resultVec[j-1]:0);
            }
        }
        return resultVec[t];
    }
*/
	public static void main(String[] args) {
		DistinctSubsequences d = new DistinctSubsequences();
		String S = "";
		String T = "a";
		System.out.println(d.numDistinct(S, T));
	}
}
