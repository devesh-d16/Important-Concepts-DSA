// You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
// Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.
// Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.

// recursion
// TC - O(2^N)
// SC - O(N)
public int perfectSum(int arr[],int n, int sum) { 
    return ps(n - 1, sum, arr);
}

public int ps(int idx, int sum, int arr[]){
    if(sum == 0){
        return 1;
    }
    if(idx == 0){
        return (arr[idx] == sum) ? 1 : 0;
    }
    
    int notPick = ps(idx - 1, sum, arr);
    int pick = 0;
    if(arr[idx] <= sum){
        pick = ps(idx - 1, sum - arr[idx], arr);
    }
    
    return notPick + pick;
}
// Memoization
// TC - O(N * SUM)
// SC - O(N * SUM) + O(N)
public int perfectSum(int arr[],int n, int sum) {
    int dp[][] = new int[n][sum + 1];
    for(int num[] : dp){
        Arrays.fill(num, -1);
    }
    return ps(n - 1, sum, arr, dp);
}

public int ps(int idx, int sum, int arr[], int dp[][]){
    if(sum == 0){
        return 1;
    }
    if(idx == 0){
        return (arr[idx] == sum) ? 1 : 0;
    }
    if(dp[idx][sum] != -1){
        return dp[idx][sum];
    }
    
    int notPick = ps(idx - 1, sum, arr, dp);
    int pick = 0;
    if(arr[idx] <= sum){
        pick = ps(idx - 1, sum - arr[idx], arr, dp);
    }
    return dp[idx][sum] = notPick + pick;
}

// Tabulation
// TC - O(N * Sum)
// SC - O(N * Sum)
public int perfectSum(int arr[],int n, int sum) {
    int dp[][] = new int[n][sum + 1];
    for(int i = 0; i < n; i++){
        dp[i][0] = 1;
    }
    
    if(arr[0] <= sum){
        dp[0][arr[0]] = 1;
    }
    
    for(int i = 1; i < n; i++){
        for(int j = 1; j <= sum; j++){
            int notPick = dp[i - 1][j];
            int pick = 0;
            if(arr[i] <= j){
                pick = dp[i - 1][j - arr[i]];
            }
            dp[i][j] = notPick + pick;
        }
    }
    return dp[n - 1][sum];
}

// Space Opti
// TC - O(N * Sum)
// SC - O(Sum)
public int perfectSum(int arr[],int n, int sum) {
    int prev[] = new int[sum + 1];
    prev[0] = 1;
    
    if(arr[0] <= sum){
        prev[arr[0]] = 1;
    }
    
    for(int i = 1; i < n; i++){
        int curr[] = new int[sum + 1];
        curr[0] = 1;
        for(int j = 1; j <= sum; j++){
            int notPick = prev[j];
            int pick = 0;
            if(arr[i] <= j){
                pick = prev[j - arr[i]];
            }
            curr[j] = notPick + pick;
        }
        prev = curr;
    }
    return prev[sum];
}
