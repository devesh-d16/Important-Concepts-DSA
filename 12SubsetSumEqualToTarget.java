// Recursion
// TC - O(2^N)
// SC - O(N)
public static boolean subsetSumToK(int n, int k, int arr[]){
    return stk(n - 1, k, arr);
}

public static boolean stk(int idx, int target, int arr[]){
    if(target == 0){
        return true;
    }
    if(idx == 0){
        return (target == arr[idx]);
    }

    boolean pick = stk(idx - 1, target - arr[idx], arr);
    boolean notPick = stk(idx - 1, target, arr);

    return pick || notPick;
}


// Memoization
// TC - O(N * target)
// SC - O(N * target) + O(N)
public static boolean subsetSumToK(int n, int k, int arr[]){
    int dp[][] = new int[n][k + 1];
    for(int num[] : dp){
        Arrays.fill(num, -1);
    }

    return stk(n - 1, k, arr, dp);
}

public static boolean stk(int idx, int target, int arr[], int dp[][]){
    if(target == 0){
        return true;
    }
    if(idx == 0){
        return (target == arr[idx]);
    }
    if(dp[idx][target] != -1){
        return dp[idx][target] == 0 ? false : true;
    }
    
    boolean notPick = stk(idx - 1, target, arr, dp);
    boolean pick = false;
    if(target >= arr[idx]){
        pick = stk(idx - 1, target - arr[idx], arr, dp);
    }

    dp[idx][target] = pick || notPick ? 1 : 0;
    return pick || notPick;
}

// Tabulation
// TC - O(N * target)
// SC - O(N * target)
public static boolean subsetSumToK(int n, int k, int arr[]){
    boolean dp[][] = new boolean[n][k + 1];
    for(int i = 0; i < n; i++){
        dp[i][0] = true;
    }
    if(arr[0] <= k){
        dp[0][arr[0]] = true;
    }

    for(int i = 1; i < n; i++){
        for(int j = 1; j <= k; j++){
            boolean notPick = dp[i - 1][j];
            boolean pick = false;
            if(j >= arr[i]){
                pick = dp[i - 1][j - arr[i]];
            }

            dp[i][j] = notPick || pick;
        }
    }

    return dp[n - 1][k];
}

// Space Optimization
// TC - O(N * target)
// SC - O(target)
public static boolean subsetSumToK(int n, int k, int arr[]){
    boolean prev[] = new boolean[k + 1];
    prev[0] = true;
    
    if(arr[0] <= k){
        prev[arr[0]] = true;
    }

    for(int i = 1; i < n; i++){
        boolean curr[] = new boolean[k + 1];
        for(int j = 1; j <= k; j++){
            boolean notPick = prev[j];
            boolean pick = false;
            if(j >= arr[i]){
                pick = prev[j - arr[i]];
            }

            curr[j] = notPick || pick;
        }
        prev = curr;
    }

    return prev[k];
}
