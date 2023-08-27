// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
// You may assume that you have an infinite number of each kind of coin.

// Recursion
// TC - greater than O(2^N) ~ Exponential
// SC - O(amount)
public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int ans = cc(n - 1, coins, amount);
    if(ans == (int)(1e9)){
        return -1;
    }
    return ans;
}

public int cc(int idx, int coins[], int amount){

    if(idx == 0){
        if(amount % coins[idx] == 0){
            return amount/coins[idx];
        }
        else{
            return (int)(1e9);
        }
    }

    int notPick = 0 + cc(idx - 1, coins, amount);
    int pick = (int)(1e9);
    if(coins[idx] <= amount){
        pick = 1 + cc(idx, coins, amount - coins[idx]);
    }

    return Math.min(pick, notPick);
}

// Memoization
// TC - O(N * target)
// SC - O(N * target) + O(target)
public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int dp[][] = new int[n][amount + 1];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }

    int ans = cc(n - 1, coins, amount, dp);
    if(ans == (int)(1e9)){
        return -1;
    }
    return ans;
}

public int cc(int idx, int coins[], int amount, int dp[][]){

    if(idx == 0){
        if(amount % coins[idx] == 0){
            return amount/coins[idx];
        }
        else{
            return (int)(1e9);
        }
    }

    if(dp[idx][amount] != -1){
        return dp[idx][amount];
    }

    int notPick = 0 + cc(idx - 1, coins, amount, dp);
    int pick = (int)(1e9);
    if(coins[idx] <= amount){
        pick = 1 + cc(idx, coins, amount - coins[idx], dp);
    }

    return dp[idx][amount] = Math.min(pick, notPick);
}

// Tabulation
// TC - O(N * target)
// SC - O(N * target)
public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int dp[][] = new int[n][amount + 1];

    for(int i = 0; i <= amount; i++){
        if(i % coins[0] == 0){
            dp[0][i] = i/coins[0];
        }
        else{
            dp[0][i] = (int)(1e9);
        }
    }

    for(int i = 1; i < n; i++){
        for(int j = 0; j <= amount; j++){
            int notTake = 0 + dp[i - 1][j];
            int take = (int)(1e9);
            if(coins[i] <= j){
                take = 1 + dp[i][j - coins[i]];
            }
            dp[i][j] = Math.min(take, notTake);
        }
    }

    int ans = dp[n - 1][amount];
    if(ans == (int)(1e9)){
        return -1;
    }
    return ans;
}
