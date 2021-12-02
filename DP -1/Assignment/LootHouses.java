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
