package leetcode;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
        int size = A.length;
        for(int i=0;i<size;i++){
            int num = A[i];
            while(num>0&&num<=size&&num!=i+1){
            	if(num==A[num-1])
            		break;
                A[i] = A[num-1];
                A[num-1] = num;
                num=A[i];
            }
        }
        for(int i=0;i<size;i++){
            if(i+1!=A[i])
                return i+1;
        }
        return size+1;
    }
	public static void main(String[] args){
		int[] a={3,4,-1,1};
		FirstMissingPositive fmp = new FirstMissingPositive();
		int b= fmp.firstMissingPositive(a);
		System.out.println(b);
	}
}
