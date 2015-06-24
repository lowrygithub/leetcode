package leetcode;

import java.util.HashSet;

public class SurroundedRegions {
	public void solve(char[][] board) {
		int ver = board.length;
		if(ver == 0)
			return ;
		int hor = board[0].length;
		if(hor==0)
			return ;
		HashSet<Integer> oneSet = new HashSet<Integer>();
		for(int i= 0;i<ver;i++)
			for(int j=0;j<hor;j++)
				if(board[i][j]=='O')
					oneSet.add(i*hor+j);
		while(oneSet.isEmpty()==false){
			HashSet<Integer> islandSet = new HashSet<Integer>();
			HashSet<Integer> islandOneSet = new HashSet<Integer>();
			int one = oneSet.iterator().next();
			islandSet.add(one);
			boolean isRegion = true;
			while(islandSet.isEmpty()==false){
				int islone = islandSet.iterator().next();
				islandSet.remove(islone);
				islandOneSet.add(islone);
				int i=islone/hor, j=islone%hor;
				if(i==0||i==ver-1||j==0||j==hor-1){
				    isRegion = false;
				}
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
			if(isRegion == true){
			    for(int o:islandOneSet){
			        int i=o/hor, j=o%hor;
			        board[i][j] = 'X';
			    }
			}
		}

    }
}
