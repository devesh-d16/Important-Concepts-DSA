// You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
// Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Tabulation
public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    int dp[][][] = new int[n + 1][2][k + 1];

    for(int i = 0; i < n + 1; i++){
        for(int j = 0; j < 2; j++){
            dp[i][j][0] = 0;
        }
    }
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < k + 1; j++){
            dp[n][i][j] = 0;
        }
    }
    for(int i = n - 1; i >= 0; i--){
        for(int j = 0; j < 2; j++){
            for(int t = 1; t < k + 1; t++){
                int profit = 0;
                if(j == 1){
                    profit = Math.max(-prices[i] + dp[i + 1][0][t], dp[i + 1][1][t]);
                }
                else{
                    profit = Math.max(prices[i] + dp[i + 1][1][t - 1], dp[i + 1][0][t]);
                }

                dp[i][j][t] = profit;
            }
        }
    }
    return dp[0][1][k];
}

// Space Optimization
public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    int front[][] = new int[2][k + 1];
    int curr[][] = new int[2][k + 1];

    for(int i = 0; i < 2; i++){
        for(int j = 0; j < k + 1; j++){
            front[i][j] = 0;
        }
    }
    for(int i = n - 1; i >= 0; i--){
        for(int j = 0; j < 2; j++){
            for(int t = 1; t < k + 1; t++){
                int profit = 0;
                if(j == 1){
                    profit = Math.max(-prices[i] + front[0][t], front[1][t]);
                }
                else{
                    profit = Math.max(prices[i] + front[1][t - 1], front[0][t]);
                }

                curr[j][t] = profit;
            }
            front = curr;
        }
    }

    return front[1][k];
}
