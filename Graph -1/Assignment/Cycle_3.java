/*

Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges, then count the distinct 
3-cycles in the graph. A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected by an edge.
Input Format :
The first line of input contains two space separated integers, that denotes the value of N and M.
Each of the following M lines contain two integers, that denote the vertices which have an undirected 
edge between them. Let us denote the two vertices with the symbol u and v. 
Output Format :
Print the count the number of 3-cycles in the given graph
Constraints :
0 <= N <= 100
0 <= M <= (N*(N-1))/2
0 <= u <= N - 1
0 <= v <= N - 1
Time Limit: 1 sec
Sample Input 1:
3 3
0 1
1 2
2 0
Sample Output 1:
1
*/

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