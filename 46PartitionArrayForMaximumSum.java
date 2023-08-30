// Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. 
// After partitioning, each subarray has their values changed to become the maximum value of that subarray.
// Return the largest sum of the given array after partitioning. 
// Test cases are generated so that the answer fits in a 32-bit integer.

// Memoization
// TC - O(N * N)
// SC - O(N) + O(N)
public int maxSumAfterPartitioning(int[] arr, int k) {
    int n = arr.length;
    int dp[] = new int[n];
    Arrays.fill(dp, -1);

    return msap(0, arr, k, n, dp);
}

public int msap(int i, int arr[], int k, int n, int dp[]){
    if(i == n){
        return 0;
    }
    if(dp[i] != -1){
        return dp[i];
    }

    int len = 0;
    int maxm = Integer.MIN_VALUE;
    int maxAns = Integer.MIN_VALUE;

    for(int j = i; j < Math.min(i + k, n); j++){
        len++;
        maxm = Math.max(maxm, arr[j]);
        int sum = len * maxm + msap(j + 1, arr, k, n, dp);
        maxAns = Math.max(maxAns, sum);
    }
    return dp[i] = maxAns;
}


// Tabulation
// TC - O(N * N)
// SC - O(N)

public int maxSumAfterPartitioning(int[] arr, int k) {
    int n = arr.length;
    int dp[] = new int[n + 1];
    dp[n] = 0;

    for(int i = n - 1; i >= 0; i--){
        int len = 0;
        int maxm = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for(int j = i; j < Math.min(i + k, n); j++){
            len++;
            maxm = Math.max(maxm, arr[j]);
            int sum = len * maxm + dp[j + 1];
            maxAns = Math.max(maxAns, sum);
        }
        dp[i] = maxAns;
    }
    return dp[0];
}
