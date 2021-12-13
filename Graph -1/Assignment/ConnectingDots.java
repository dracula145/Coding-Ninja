import java.util.*;

public class ConnectingDots {

    private void initialize(boolean[][] visited, int n, int m){
	for (int i = 0;i < n;i++)
	{
		for (int j = 0;j < m;j++) visited[i][j] = false;
	}
}

private boolean dfs(String[] board, char col, int pi, int pj, int i, int j, int n, int m, boolean[][] visited)
{


	boolean d1 = i + 1 < n && !(i + 1 == pi && j == pj) && visited[i + 1][j];
	boolean d2 = j + 1 < m && !(i == pi && j + 1 == pj) && visited[i][j + 1];
	boolean d3 = i - 1 >= 0 && !(i - 1 == pi && j == pj) && visited[i - 1][j];
	boolean d4 = j - 1 >= 0 && !(i == pi && j - 1 == pj) && visited[i][j - 1];

	if (d1 || d2 || d3 || d4)
	{
		return true;
	}

	boolean ans = false;
	visited[i][j] = true;
	if (i + 1 < n && board[i + 1].charAt(j) == col && !visited[i + 1][j])
	{
		ans = ans || dfs(board, col, i, j, i + 1, j, n, m, visited);
	}

	if (j + 1 < m && board[i].charAt(j+1) == col && !visited[i][j + 1])
	{
		ans = ans || dfs(board, col, i, j, i, j + 1, n, m, visited);
	}

	if (i - 1 >= 0 && board[i - 1].charAt(j) == col && !visited[i - 1][j])
	{
		ans = ans || dfs(board, col, i, j, i - 1, j, n, m, visited);
	}

	if (j - 1 >= 0 && board[i].charAt(j-1) == col && !visited[i][j - 1])
	{
		ans = ans || dfs(board, col, i, j, i, j - 1, n, m, visited);
	}

	return ans;
}

public int solve(String[] board, int n, int m)
{
	
	boolean[][] visited = new boolean[n][m];
	
	initialize(visited, n, m);
	for (int i = 0;i < n;i++)
	{
		for (int j = 0;j < m;j++)
		{
			boolean ans = false;
			if (!visited[i][j])
			{
				char color = board[i].charAt(j);
				ans = dfs(board, color, i, j, i, j, n, m, visited);
				initialize(visited, n, m);
				//cout<<"======"<<endl;
				//cout<<endl;
				//cout<<ans<<endl;
				if (ans)
				{
					return 1;
				}
			}
		}
	}
	return 0;
}
	
	
}