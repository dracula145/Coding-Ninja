/*

Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate 
turns. Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower. 
The person to make the last move wins the game. Can you find out who wins the game?

Output format :
Prints the name of the winner, either 'Whis' or 'Beerus' (Without the quotes).
Constraints :
1 <= N <= 10 ^ 6
2 <= X <= Y<= 50

Time Limit: 1 sec
Sample Input 1 :
4 2 3
Sample Output 1 :
Whis
Sample Input 2 :
10 2 4
Sample Output 2 :
Beerus

*/

public class CoinTower {
    public static String findWinner(int n, int x, int y) {
		int dp[] = new int[n+1];
        for(int i=0; i<dp.length; i++) dp[i] = -1;
        return helper(n, x, y, 0); // 0 => even => Beerus
	}
    private static String helper(int n, int x, int y, int player){
        if(n==1 && player%2==0) return "Beerus";
        if(n==1 && player%2!=0) return "Whis";

        int next_move = 0;
        if(Math.max(x, y) < n) next_move = Math.max(x, y);
        else if(x < n) next_move = x;
        else if(y < n) next_move = y;
        else next_move = 1;

        return helper(n-next_move, x, y, player+1);
    }

    public static String findWinnerIDP(int n, int x, int y) {
		int dp[] = new int[n+1];
        
        // 0 -> whis wins because Beerus starts the game and 1-> Beerus wins
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2 ; i<dp.length; i++){

            //Beerus wins if dp[i-1] or dp[i-x] or dp[i-y] is 0, i.e, Whis wins when the number of coins is (i-1), (i-x) or (i-y)
            //If none of them are 0, then Beerus cannot win => This means Whis wins for i number of coins

            if(dp[i-1] == 0) dp[i] = 1;
            else if(i-x >= 0 && dp[i-x]==0) dp[i] = 1;
            else if(i-y >= 0 && dp[i-y]==0) dp[i] = 1;
            else dp[i] = 0;
        }
            if(dp[n] == 1) return "Beerus";
            else return "Whis";
	}
}
