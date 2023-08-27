// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
// You may assume that you have an infinite number of each kind of coin.
// The answer is guaranteed to fit into a signed 32-bit integer.

// Recursion
public int change(int amount, int[] coins) {
    int n = coins.length;
    return c(n - 1, amount, coins);
}

public int c(int idx, int amount, int coins[]){
    if(amount == 0){
        return 1;
    }
    if(idx == 0){
        if(amount % coins[0] == 0){
            return 1;
        }
        else{
            return 0;
        }
    }

    int notTake = c(idx - 1, amount, coins);
    int take = 0;

    if(coins[idx] <= amount){
        take = c(idx, amount - coins[idx], coins);
    }
    return take + notTake;
}

// Memoization
public int change(int amount, int[] coins) {
    int n = coins.length;
    int dp[][] = new int[n][amount + 1];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }
    return c(n - 1, amount, coins, dp);
}

public int c(int idx, int amount, int coins[], int dp[][]){
    if(amount == 0){
        return 1;
    }
    if(idx == 0){
        if(amount % coins[0] == 0){
            return 1;
        }
        else{
            return 0;
        }
    }
    if(dp[idx][amount] != -1){
        return dp[idx][amount];
    }

    int notTake = c(idx - 1, amount, coins, dp);
    int take = 0;

    if(coins[idx] <= amount){
        take = c(idx, amount - coins[idx], coins, dp);
    }

    return dp[idx][amount] = take + notTake;
}

// Tabulation
public int change(int amount, int[] coins) {
    int n = coins.length;
    int dp[][] = new int[n][amount + 1];

    for(int i = 0; i <= amount; i++){
        if(i % coins[0] == 0){
            dp[0][i] = 1;
        }
    }
    for(int i = 1; i < n; i++){
        for(int j = 0; j <= amount; j++){
            int notTake = dp[i - 1][j];
            int take = 0;
            if(coins[i] <= j){
                take = dp[i][j - coins[i]];
            }

            dp[i][j] = notTake + take;
        }
    }

    return dp[n - 1][amount];
}

// Space Optimization
public int change(int amount, int[] coins) {
    int n = coins.length;
    int prev[] = new int[amount + 1];

    for(int i = 0; i <= amount; i++){
        if(i % coins[0] == 0){
            prev[i] = 1;
        }
    }
    for(int i = 1; i < n; i++){
        int curr[] = new int[amount + 1];
        for(int j = 0; j <= amount; j++){
            int notTake = prev[j];
            int take = 0;
            if(coins[i] <= j){
                take = curr[j - coins[i]];
            }

            curr[j] = notTake + take;
        }
        prev = curr;
    }

    return prev[amount];
}
