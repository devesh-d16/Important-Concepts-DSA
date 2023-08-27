// You are given ‘n’ items with certain ‘profit’ and ‘weight’ and a knapsack with weight capacity ‘w’.
// You need to fill the knapsack with the items in such a way that you get the maximum profit. 
// You are allowed to take one item multiple times.

// Recursion
public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
    return uk(n - 1, w, profit, weight);
}

public static int uk(int idx, int w, int profit[], int weight[]){
    if(idx == 0){
        return ((int)(w/weight[0])) * profit[0];
    }
    int notPick = uk(idx - 1, w, profit, weight);
    int pick = (int)(-1e9);

    if(weight[idx] <= w){
        pick = profit[idx] + uk(idx, w - weight[idx], profit, weight);
    }
    return Math.max(notPick, pick);
}

// Memoization
public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
    int dp[][] = new int[n][w + 1];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }
    return uk(n - 1, w, profit, weight, dp);
}

public static int uk(int idx, int w, int profit[], int weight[], int dp[][]){
    if(idx == 0){
        return ((int)(w/weight[0])) * profit[0];
    }
    if(dp[idx][w] != -1){
        return dp[idx][w];
    }
    int notPick = uk(idx - 1, w, profit, weight, dp);
    int pick = (int)(-1e9);

    if(weight[idx] <= w){
        pick = profit[idx] + uk(idx, w - weight[idx], profit, weight, dp);
    }

    return dp[idx][w] = Math.max(notPick, pick);
}

// Tabulation
public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
    int dp[][] = new int[n][w + 1];
    for(int i = 0; i <= w; i++){
        dp[0][i] = profit[0]*((int)(i/weight[0]));
    }

    for(int i = 1; i < n; i++){
        for(int j = 0; j <= w; j++){
            int notPick = dp[i - 1][j];
            int pick = (int)(-1e9);
            if(weight[i] <= j){
                pick = profit[i] + dp[i][j - weight[i]];
            }

            dp[i][j] = Math.max(notPick, pick);
        }
    }
    return dp[n - 1][w];
}

// Space Optimization
public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
    int curr[] = new int[w + 1];
    for(int i = weight[0]; i <= w; i++){
        curr[i] = profit[0] * ((int)i/weight[0]);
    }

    for(int i = 1; i < n; i++){
        for(int j = 0; j < w + 1; j++){
            int notTake = curr[j];
            int take = (int)-1e9;
            if(weight[i] <= j){
                take = profit[i] + curr[j - weight[i]];
            }
            curr[j] = Math.max(notTake, take);
        }
    }
    return curr[w];
}
