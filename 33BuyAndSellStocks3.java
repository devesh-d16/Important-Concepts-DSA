// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete at most two transactions.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Recursion
// TC - O(2^N)
// SC - O(N)
public int maxProfit(int[] prices) {
    int n = prices.length;

    return mp(0, 1, 2, prices, n);
}
public int mp(int idx, int buy, int limit, int prices[], int n){
    if(idx == n){
        return 0;
    }
    if(limit == 0){
        return 0;
    }

    int profit = 0;
    if(buy == 1){
        profit = Math.max(-prices[idx] + mp(idx + 1, 0, limit, prices, n), 0 + mp(idx + 1, 1, limit, prices, n));
    }
    else{
        profit = Math.max(prices[idx] + mp(idx + 1, 1, limit - 1, prices, n), 0 + mp(idx + 1, 0, limit, prices, n));
    }
    return profit;
}

// Memoization
// TC - O(N*2*2)
// SC - O(N*2*2) + O(N)
public int maxProfit(int[] prices) {
    int n = prices.length;
    int dp[][][] = new int[n + 1][2][3];
    for(int arr[][] : dp){
        for(int a[] : arr){
            Arrays.fill(a, -1);
        }
    }

    return mp(0, 1, 2, prices, n, dp);
}

public int mp(int idx, int buy, int limit, int prices[], int n, int dp[][][]){
    if(idx == n){
        return 0;
    }
    if(limit == 0){
        return 0;
    }
    if(dp[idx][buy][limit] != -1){
        return dp[idx][buy][limit];
    }

    int profit = 0;
    if(buy == 1){
        profit = Math.max(-prices[idx] + mp(idx + 1, 0, limit, prices, n, dp), 0 + mp(idx + 1, 1, limit, prices, n, dp));
    }
    else{
        profit = Math.max(prices[idx] + mp(idx + 1, 1, limit - 1, prices, n, dp), 0 + mp(idx + 1, 0, limit, prices, n, dp));
    }

    return dp[idx][buy][limit] = profit;
}

// Tabulation
// TC - O(N*2*2)
// SC - O(N*2*2)
public int maxProfit(int[] prices) {
    int n = prices.length;
    int dp[][][] = new int[n + 1][2][3];
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 3; j++){
            dp[n][i][j] = 0;
        }
    }
    for(int i = 0; i <= n; i++){
        for(int j = 0; j < 2; j++){
            dp[i][j][0] = 0;
        }
    }

    for(int i = n - 1; i >= 0; i--){
        for(int j = 0; j < 2; j++){
            for(int k = 1; k < 3; k++){
                int profit = 0;
                if(j == 1){
                    profit = Math.max(-prices[i] + dp[i + 1][0][k], dp[i + 1][1][k]);
                }
                else{
                    profit = Math.max(prices[i] + dp[i + 1][1][k - 1], dp[i + 1][0][k]);
                }

                dp[i][j][k] = profit;
            }
        }
    }
    return dp[0][1][2];
}

// Space Optimization
public int maxProfit(int[] prices) {
    int n = prices.length;
    int next[][] = new int[2][3];
    int curr[][] = new int[2][3];

    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 3; j++){
            next[i][j] = 0;
        }
    }
    for(int i = n - 1; i >= 0; i--){
        for(int j = 0; j < 2; j++){
            for(int k = 1; k < 3; k++){
                int profit = 0;
                if(j == 1){
                    profit = Math.max(-prices[i] + next[0][k], next[1][k]);
                }
                else{
                    profit = Math.max(prices[i] + next[1][k - 1], next[0][k]);
                }

                curr[j][k] = profit;
            }
            next = curr;
        }
    }
    return next[1][2];
}
