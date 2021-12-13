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