package leetcode;
/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * @author Lowry
 *
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num=1;
        int rowStart = 0;
        int rowEnd = n;
        int colStart = 0;
        int colEnd = n;
        int state = 0;
        while(num!=n*n+1){
            switch(state){
                case(0):
                    for(int i=colStart;i<colEnd;i++)
                        result[rowStart][i]=num++;
                    rowStart++;
                    break;
                case(1):
                    for(int i=rowStart;i<rowEnd;i++)
                        result[i][colEnd-1]=num++;
                    colEnd--;
                    break;
                case(2):
                    for(int i=colEnd-1;i>=colStart;i--)
                        result[rowEnd-1][i]=num++;
                    rowEnd--;
                    break;
                case(3):
                    for(int i=rowEnd-1;i>=rowStart;i--)
                        result[i][colStart]=num++;
                    colStart++;
                    break;
            }
            state=(state+1)%4;
        }
        return result;
    }
}
