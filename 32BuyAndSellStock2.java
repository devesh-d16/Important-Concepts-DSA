// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. 
// However, you can buy it then immediately sell it on the same day.
// Find and return the maximum profit you can achieve.

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 7
// Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
// Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
// Total profit is 4 + 3 = 7.

// Recursion
// TC - O(2^N)
// SC - O(N)
public int maxProfit(int[] prices) {
    int n = prices.length;

    return mp(0, 1, prices, n);
}

public int mp(int idx, int buy, int prices[], int n){
    if(idx == n){
        return 0;
    }

    int profit = 0;
    if(buy == 1){
        profit = Math.max(-prices[idx] + mp(idx + 1, 0, prices, n), 0 + mp(idx + 1, 1, prices, n));
    }
    else{
        profit = Math.max(prices[idx] + mp(idx + 1, 1, prices, n), 0 + mp(idx + 1, 0, prices, n));
    }

    return profit;
}

// Memoization
// TC - O(N*2)
// SC - O(N*2) + O(N)
public int maxProfit(int[] prices) {
    int n = prices.length;
    int dp[][] = new int[n][2];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }

    return mp(0, 1, prices, n, dp);
}

public int mp(int idx, int buy, int prices[], int n, int dp[][]){
    if(idx == n){
        return 0;
    }
    if(dp[idx][buy] != -1){
        return dp[idx][buy];
    }

    int profit = 0;
    if(buy == 1){
        profit = Math.max(-prices[idx] + mp(idx + 1, 0, prices, n, dp), 0 + mp(idx + 1, 1, prices, n, dp));
    }
    else{
        profit = Math.max(prices[idx] + mp(idx + 1, 1, prices, n, dp), 0 + mp(idx + 1, 0, prices, n, dp));
    }

    return dp[idx][buy] = profit;
}

// Tabulation
// TC - O(N * 2)
// SC - O(N * 2)
public int maxProfit(int[] prices) {
    int n = prices.length;
    int dp[][] = new int[n + 1][2];
    dp[n][0] = 0;
    dp[n][1] = 0;

    for(int i = n - 1; i >= 0; i--){
        for(int j = 0; j <= 1; j++){
            int profit = 0;
            if(j == 1){
                profit = Math.max(-prices[i] + dp[i + 1][0], 0 + dp[i + 1][1]);
            }
            else{
                profit = Math.max(prices[i] + dp[i + 1][1], 0 + dp[i + 1][0]);
            }
            dp[i][j] = profit;
        }
    }
    return dp[0][1];
}

// Tabulation
// TC - O(N * 2)
// SC - O(1)
public int maxProfit(int[] prices) {
    int n = prices.length;
    int ahead[] = new int[2];
    ahead[0] = 0;
    ahead[1] = 0;

    for(int i = n - 1; i >= 0; i--){
        int curr[] = new int[2];
        for(int j = 0; j <= 1; j++){
            int profit = 0;
            if(j == 1){
                profit = Math.max(-prices[i] + ahead[0], 0 + ahead[1]);
            }
            else{
                profit = Math.max(prices[i] + ahead[1], 0 + ahead[0]);
            }
            curr[j] = profit;
        }
        ahead = curr;
    }
    return ahead[1];
}

// here you can use two variables
public int maxProfit(int[] prices) {
    int n = prices.length;
    int currBuy, currNotBuy;
    int frontBuy,frontNotBuy;
    frontBuy = 0;
    frontNotBuy = 0;

    for(int i = n - 1; i >= 0; i--){

        currBuy = Math.max(-prices[i] + frontNotBuy, frontBuy);
        currNotBuy = Math.max(prices[i] + frontBuy, frontNotBuy);
        
        frontBuy = currBuy;
        frontNotBuy = currNotBuy;
    }

    return frontBuy;
}
