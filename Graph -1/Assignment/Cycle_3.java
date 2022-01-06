/*
	don't use visited, because we might mark one vertex and later we might not visit that and count++ even if
	that vertex is shared by more cycles.. so better to use the 3 loops

	div by 6 because for every vertex of the cycle we will get the same cycle 2 times... so total 6 times
*/

import java.util.*;
public class Cycle_3 {

// watch hint
public static int solve(boolean[][] graph, int n) {
		int count = 0;
	for (int i = 0; i < n; i++){
		for (int j = 0; j < n; j++){
			if (i != j && graph[i][j])
			{
				for (int k = 0; k < n; k++)
				{
					if (j != k && k != i && graph[j][k])
					    if (graph[i][k]) count += 1;
				}
			}
		}
	}
	return count/6;
    }
}