package leetcode;
/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0

Hide Tags Array Binary Search

 * @author Lowry
 *
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        int head=0, end=A.length, mid;
        while(head != end){
            mid=(head+end)/2;
            if(A[mid]>=target)
                end = mid;
            else
                head = mid+1;
        }
        return head;
        
    }
}
