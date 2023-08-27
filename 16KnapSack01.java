// A thief is robbing a store and can carry a maximal weight of W into his knapsack. 
// There are N items and the ith item weighs wi and is of value vi. Considering the constraints of the maximum weight that a knapsack can carry, 
// you have to find and return the maximum value that a thief can generate by stealing items.

// Recursion
// TC - O(2^N)
// SC - O(N)
public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    return ks(n - 1, maxWeight, weight, value);
}

public static int ks(int idx, int maxWt, int weight[], int value[]){

    if(idx == 0){
        if(weight[idx] <= maxWt){
            return value[idx];
        }
        else{
            return 0;
        }
    }

    int notPick =  + ks(idx - 1, maxWt, weight, value);
    int pick = Integer.MIN_VALUE;
    if(weight[idx] <= maxWt){
        pick = value[idx] + ks(idx - 1, maxWt - weight[idx], weight, value);
    }

    return Math.max(notPick, pick);
}

// Memoization
// TC - O(N * MaxWt)
// SC - O(N * MaxWt) + O(MaxWt)
public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    int dp[][] = new int[n][maxWeight + 1];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }
    return ks(n - 1, maxWeight, weight, value, dp);
}

public static int ks(int idx, int maxWt, int weight[], int value[], int dp[][]){

    if(idx == 0){
        if(weight[idx] <= maxWt){
            return value[idx];
        }
        else{
            return 0;
        }
    }
    if(dp[idx][maxWt] != -1){
        return dp[idx][maxWt];
    }
    int notPick =  + ks(idx - 1, maxWt, weight, value, dp);
    int pick = Integer.MIN_VALUE;
    if(weight[idx] <= maxWt){
        pick = value[idx] + ks(idx - 1, maxWt - weight[idx], weight, value, dp);
    }

    return dp[idx][maxWt] = Math.max(notPick, pick);
}

// Tabulation
// TC - O(N * MaxWt)
// SC - O(N * MaxWt)
public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    int dp[][] = new int[n][maxWeight + 1];
    for(int i = weight[0]; i <= maxWeight; i++){
        dp[0][i] = value[0];
    }

    for(int i = 1; i < n; i++) {
        for(int j = 0; j <= maxWeight; j++){
            int notPick = 0 + dp[i - 1][j];
            int pick = Integer.MIN_VALUE;
            if(weight[i] <= j){
                pick = value[i] + dp[i - 1][j - weight[i]];
            }
            dp[i][j] = Math.max(notPick, pick);
        } 
    }

    return dp[n - 1][maxWeight];
}

// Space Optimization
// TC - O(N * MaxWt)
// SC - O(N * MaxWt)
public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    int prev[] = new int[maxWeight + 1];
    for(int i = weight[0]; i <= maxWeight; i++){
        prev[i] = value[0];
    }

    for(int i = 1; i < n; i++) {
        for(int j = maxWeight; j >= 0; j--){
            int notPick = 0 + prev[j];
            int pick = Integer.MIN_VALUE;
            if(weight[i] <= j){
                pick = value[i] + prev[j - weight[i]];
            }
            prev[j] = Math.max(notPick, pick);
        } 
    }

    return prev[maxWeight];
}
