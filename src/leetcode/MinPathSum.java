package leetcode;
/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Hide Tags Array Dynamic Programming

 * @author Lowry
 *
 */
public class MinPathSum {
	public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m==0)
            return 0;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0 && j!=0){
                    grid[i][j] += grid[i][j-1];
                }
                else if(i!=0 && j==0){
                    grid[i][j] += grid[i-1][j];
                }
                else if(i!=0 && j!=0){
                    grid[i][j] += (grid[i-1][j]<grid[i][j-1]?grid[i-1][j]:grid[i][j-1]);
                }
                
            }
        }
        return grid[m-1][n-1];
    }
}
