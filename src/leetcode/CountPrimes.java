/**
 * Description:

Count the number of prime numbers less than a non-negative number, n.
 */
package leetcode;

public class CountPrimes {
	public int countPrimes(int n) {
        int[] arr = new int[n];
        for(int i=2;i<Math.pow(n,0.5);i++){
            if(arr[i]==0){
                for(int j=i*i;j<n;j+=i){
                    arr[j]=1;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(arr[i]==0)
                count++;
        }
        return count;
    }
}
