package leetcode;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int minLen = len+1;
        int sum=0,i=0,j=0;
        while(j<len+1){
            if(sum<s){
            	if(j==len)
            		break;
                sum+=nums[j++];
            }
            else{
                if((j-i)<minLen){
                    minLen = j-i;
                }
                sum-=nums[i++];
            }
        }
        
        return minLen%(len+1);
    }
    public static void main(String[] args){
    	int s = 11;
    	int[] nums = {1,2,3,4,5};
    	System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(s,nums));
    }
}