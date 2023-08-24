// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

// Recursion
// TC - O(2^N)
// SC - O(N)
public boolean canPartition(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for(int i = 0; i < n; i++){
        sum += nums[i];
    }
    if(sum % 2 != 0){
        return false;
    }
    sum = sum/2;

    return cp(n - 1, sum, nums);
}

public boolean cp(int idx, int target, int[] nums){
    if(idx == 0){
        return (nums[idx] == target);
    }
    if(target == 0){
        return true;
    }
    
    boolean notPick = cp(idx - 1, target, nums);
    boolean pick = false;
    if(target >= nums[idx]){
        pick = cp(idx - 1, target - nums[idx], nums);
    }

    return notPick || pick;
}

// Memoization
// TC - O(N * sum/2)
// SC - O(N * sum/2) + O(target)
public boolean canPartition(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for(int i = 0; i < n; i++){
        sum += nums[i];
    }
    if(sum % 2 != 0){
        return false;
    }
    sum = sum/2;
    int dp[][] = new int[n][sum + 1];
    for(int i = 0; i < n; i++){
        for(int j = 0; j < sum + 1; j++){
            dp[i][j] = -1;
        }
    }

    return cp(n - 1, sum, nums, dp);
}

public boolean cp(int idx, int target, int[] nums, int dp[][]){
    if(idx == 0){
        return (nums[idx] == target);
    }
    if(target == 0){
        return true;
    }
    if(dp[idx][target] != -1){
        return dp[idx][target] == 1 ? true : false; 
    }
    boolean notPick = cp(idx - 1, target, nums, dp);
    boolean pick = false;
    if(target >= nums[idx]){
        pick = cp(idx - 1, target - nums[idx], nums, dp);
    }

    dp[idx][target] = notPick || pick ? 1 : 0;

    return notPick || pick;
}

// Tabulation
// TC - O(N * sum/2)
// SC - O(N * sum/2)
public boolean canPartition(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for(int i = 0; i < n; i++){
        sum += nums[i];
    }
    if(sum % 2 != 0){
        return false;
    }
    sum = sum/2;
    boolean dp[][] = new boolean[n][sum + 1];
    for(int i = 0; i < n; i++){
        dp[i][0] = true;
    }
    if(nums[0] <= sum){
        dp[0][nums[0]] = true;
    }

    for(int i = 1; i < n; i++){
        for(int j = 1; j <= sum; j++){
            boolean notPick = dp[i - 1][j];
            boolean pick = false;
            if(j >= nums[i]){
                pick = dp[i - 1][j - nums[i]];
            }

            dp[i][j] = pick || notPick;
        }
    }
    return dp[n - 1][sum];
}

// Space Optimization
// TC - O(N * sum/2)
// SC - O(sum)
public boolean canPartition(int[] nums) {
    int n = nums.length;
    
    int sum = 0;
    for(int i = 0; i < n; i++){
        sum += nums[i];
    }
    if(sum % 2 != 0){
        return false;
    }
    sum = sum/2;
    
    boolean prev[] = new boolean[sum + 1];
    prev[0] = true;
    if(nums[0] <= sum){
        prev[nums[0]] = true;
    }

    for(int i = 1; i < n; i++){
        boolean curr[] = new boolean[sum + 1];
        curr[0] = true;
        for(int j = 1; j <= sum; j++){
            boolean notPick = prev[j];
            boolean pick = false;
            if(j >= nums[i]){
                pick = prev[j - nums[i]];
            }

            curr[j] = pick || notPick;
        }
        prev = curr;
    }
    return prev[sum];
}
