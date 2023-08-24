// You are given an array 'arr' containing 'n' non-negative integers.
// Your task is to partition this array into two subsets such that the absolute difference between subset sums is minimum.
// You just need to find the minimum absolute difference considering any valid division of the array elements.

// Tabulation
// TC - O(N * K)
// SC - O(N * K) + O(N)

public static int minSubsetSumDifference(int []arr, int n) {
    
    int sum = 0;
    for(int i = 0; i < n; i++){
        sum += arr[i];
    }

    boolean dp[][] = new boolean[n][sum + 1];
    for(int i = 0; i < n; i++){
        dp[i][0] = true;
    }

    if(arr[0] <= sum){
        dp[0][arr[0]] = true;
    }

    for(int i = 1 ;i < n; i++){
        for(int j = 1; j < sum + 1; j++){
            boolean notPick = dp[i - 1][j];
            boolean pick = false;
            if(arr[i] <= j){
                pick = dp[i - 1][j - arr[i]];
            }

            dp[i][j] = notPick || pick;
        }
    }
    int minm = (int)(1e9);
    for(int i = 0; i <= sum/2; i++){
        if(dp[n - 1][i] == true){
            minm = Math.min(minm, Math.abs((sum - i) - i));
        }
    }
    return minm;
}
