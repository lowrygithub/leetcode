package leetcode;

public class FindMinInRotatedSortedArray {
	public int findMin(int[] num) {
        int len = num.length;
        if(len==1)
        	return num[0];
        if(len==2)
        	return num[0]<num[1]?num[0]:num[1];
        int flag=(num[0]-num[len/2])*(num[len/2]-num[len-1]);
        if(flag > 0)
        	return num[0]<num[len-1]?num[0]:num[len-1];
        if(num[len-1]-num[0]>0)
        	for(int i=1;i<len;i++){
        		if(num[i]>num[i-1])
        			return num[i-1];
        	}
        else
        	for(int i=1;i<len;i++){
        		if(num[i]<num[i-1])
        			return num[i];
        	}
        return 0;
    }
}
