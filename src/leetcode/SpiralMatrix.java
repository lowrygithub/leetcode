
package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

Hide Tags Array

 * @author Lowry
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> resultList = new ArrayList<Integer>();
		int rowStart = 0;
		int rowEnd = matrix.length;
		if (rowEnd == 0)
			return resultList;
		int colStart = 0;
		int colEnd = matrix[0].length;

		int state = 0;
		while (rowStart!=rowEnd&&colStart!=colEnd) {
			switch (state) {
			case (0):
				for(int i=colStart;i<colEnd;i++)
					resultList.add(matrix[rowStart][i]);
				rowStart++;
				break;
			case (1):
				for(int i=rowStart;i<rowEnd;i++)
					resultList.add(matrix[i][colEnd-1]);
				colEnd--;
				break;
			case (2):
				for(int i=colEnd-1;i>=colStart;i--)
					resultList.add(matrix[rowEnd-1][i]);
				rowEnd--;
				break;
			case (3):
				for(int i=rowEnd-1;i>=rowStart;i--)
					resultList.add(matrix[i][colStart]);
				colStart++;
				break;

			}
			state = (state+1)%4;
		}
		return resultList;
	}
}
