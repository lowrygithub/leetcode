package leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
        int length = A.length;
        if(length == 1)
            return A[0];
        int[] resultArray = new int[length];
        resultArray[0] = A[0];
        int rightBoundMax = A[0];
        for(int i = 1; i<length; i++){
            resultArray[i] = Math.max(resultArray[i-1],rightBoundMax+A[i]);
            if(0>rightBoundMax)
                rightBoundMax = A[i];
        }
        return resultArray[length-1];
    }
	public static void main(String[] args){
		MaximumSubarray m =new MaximumSubarray();
		
		int[] A = {-2,1};
		m.maxSubArray(A );
	}
}
