// You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
// If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, 
// then treat it as if there is a balloon with a 1 painted on it.
// Return the maximum coins you can collect by bursting the balloons wisely.

// Recursion
public int maxCoins(int[] nums) {
    int n = nums.length;
    int temp[] = new int[n + 2];
    int c = temp.length;
    temp[0] = 1;
    temp[c - 1] = 1;
    for(int i = 0; i < n; i++){
        temp[i + 1] = nums[i];
    }

    return mc(1, c - 2, temp);
}

public int mc(int i, int j, int nums[]){
    if(i > j){
        return 0;
    }

    int maxm = Integer.MIN_VALUE;
    for(int k = i; k <= j; k++){
        int cost = nums[i - 1] * nums[k] * nums[j + 1] + mc(i, k - 1, nums) + mc(k + 1, j, nums);
        maxm = Math.max(maxm, cost);
    }
    return maxm;
}

// Memoization
public int maxCoins(int[] nums) {
    int n = nums.length;
    int temp[] = new int[n + 2];
    int c = temp.length;
    temp[0] = 1;
    temp[c - 1] = 1;
    for(int i = 0; i < n; i++){
        temp[i + 1] = nums[i];
    }

    int dp[][] = new int[c + 1][c + 1];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }
    return mc(1, c - 2, temp, dp);
}

public int mc(int i, int j, int nums[], int dp[][]){
    if(i > j){
        return 0;
    }
    if(dp[i][j] != -1){
        return dp[i][j];
    }

    int maxm = Integer.MIN_VALUE;
    for(int k = i; k <= j; k++){
        int cost = nums[i - 1] * nums[k] * nums[j + 1] + mc(i, k - 1, nums, dp) + mc(k + 1, j, nums, dp);
        maxm = Math.max(maxm, cost);
    }
    return dp[i][j] = maxm;
}

// Tabulation
public int maxCoins(int[] nums) {
    int n = nums.length;
    int temp[] = new int[n + 2];
    int c = temp.length;
    temp[0] = 1;
    temp[c - 1] = 1;
    for(int i = 0; i < n; i++){
        temp[i + 1] = nums[i];
    }

    int dp[][] = new int[c + 1][c + 1];
    for(int i = c - 2; i >= 1; i--){
        for(int j = i; j <= c - 2; j++){
            int maxm = Integer.MIN_VALUE;
            for(int k = i; k <= j; k++){
                int cost = temp[i - 1] * temp[k] * temp[j + 1] + dp[i][k - 1] + dp[k + 1][j];
                maxm = Math.max(maxm, cost);
            }
            dp[i][j] = maxm;
        }
    }
    return dp[1][c - 2];
}
