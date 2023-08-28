// Best Time to Buy and Sell Stock with Cooldown

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete as many transactions as you like 
// (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
// After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Tabulation
public int maxProfit(int[] prices) {
    int n = prices.length;
    int dp[][] = new int[n + 2][2];

    for(int i = n - 1; i >= 0; i--){
        dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);            
        dp[i][0] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
    }
    return dp[0][1];
}

// Space Optimization
public int maxProfit(int[] prices) {
    int n = prices.length;

    int front2[] = new int[2];
    int front1[] = new int[2];
    for(int i = n - 1; i >= 0; i--){
        int curr[] = new int[2];
        curr[1] = Math.max(-prices[i] + front1[0], front1[1]);            
        curr[0] = Math.max(prices[i] + front2[1], front1[0]);

        front2 = front1;
        front1 = curr;
    }
    return front1[1];
}
