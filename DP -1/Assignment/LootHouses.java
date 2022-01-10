/*

A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive 
houses. Find the maximum amount of money he can loot.

Output format :
Print the the maximum money that can be looted.
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
6
5 5 10 100 10 5
Sample Output 1 :
110
Sample Input 2 :
6
10 2 30 20 3 50
Sample Output 2 :
90
Explanation of Sample Output 2 :
Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot, and all the 
other possible combinations would result in less than 90.

*/

package Assignment;

public class LootHouses {

    //Iterative DP

    /*
        case 1 : include the i-th house + max of i-2th house and backwards
        case 2 : exclude the i-th house rather start from i-1th house and backwards
    */
    public static int maxMoneyLooted(int[] houses) {
		int dp[] = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        for(int i=2; i<dp.length; i++) dp[i] = Math.max(dp[i]+dp[i-2], dp[i-1]);
        return dp[dp.length -1];
	}

    public static int maxMoneyLootedReconly(int[] houses) {
		return helper(houses, 0));
	}
    private static int helper(int[] houses, int start){
        if(start >= houses.length) return 0;
        return Math.max(houses[start] + helper(houses, start+2), helper(houses, start+1));
    }
}
