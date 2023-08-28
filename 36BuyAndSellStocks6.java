// Best Time to Buy and Sell Stock with Transaction Fee

// You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
// Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
// Note:
// You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
// The transaction fee is only charged once for each stock purchase and sale.

// Tabulation
public int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int dp[][] = new int[n + 1][2];

    for(int i = n - 1; i >=0; i--){
        for(int j = 0; j < 2; j++){
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
            dp[i][0] = Math.max(prices[i] - fee + dp[i + 1][1], dp[i + 1][0]);
        }
    }

    return dp[0][1];
}
