package leetcode;

import java.util.HashSet;

public class NumberofIslands {
	public static void main(String[] args){
		char[][] grid = {{'1','1','1'},{'1','1','1'}};
		System.out.println(new NumberofIslands().numIslands(grid));
	}
	public int numIslands(char[][] grid) {
		int count = 0;
		int ver = grid.length;
		if(ver == 0)
			return 0;
		int hor = grid[0].length;
		if(hor==0)
			return 0;
		HashSet<Integer> oneSet = new HashSet<Integer>();
		for(int i= 0;i<ver;i++)
			for(int j=0;j<hor;j++)
				if(grid[i][j]=='1')
					oneSet.add(i*hor+j);
		while(oneSet.isEmpty()==false){
			HashSet<Integer> islandSet = new HashSet<Integer>();
			int one = oneSet.iterator().next();
			islandSet.add(one);
			while(islandSet.isEmpty()==false){
				int islone = islandSet.iterator().next();
				islandSet.remove(islone);
				int i=islone/hor, j=islone%hor;
				if(j-1>=0&&oneSet.contains(islone-1))
					islandSet.add(islone-1);
				if(j+1<hor&&oneSet.contains(islone+1))
					islandSet.add(islone+1);
				if(i-1>=0&&oneSet.contains(islone-hor))
					islandSet.add(islone-hor);
				if(i+1<ver&&oneSet.contains(islone+hor))
					islandSet.add(islone+hor);
				oneSet.remove(islone);
			}
			
			count++;
		}
		return count;
	}
}
