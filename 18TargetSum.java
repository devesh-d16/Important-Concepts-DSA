// You are given an integer array nums and an integer target.
// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

// Recursion
// TC - O(2^N)
// SC - O(Target)
public int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    int sum = 0;
    for(int i = 0; i < n; i++){
        sum += nums[i];
    }

    if((sum - target) < 0 || ((sum - target) % 2) == 1){
        return 0;
    }
    int t = (sum - target)/2;

    return ft(n - 1, t, nums);
}


private int ft(int idx, int target, int nums[]){
    if(idx == 0){
        if(target == 0 && nums[0] == 0){
            return 2;
        }
        if(target == 0 || target == nums[0]){
            return 1;
        }
        return 0;
    }

    int notPick = ft(idx - 1, target, nums);
    int pick = 0;
    if(nums[idx] <= target){
        pick = ft(idx - 1, target - nums[idx], nums);
    }

    return pick + notPick;
}

// Memoization
// TC - O(N * Target)
// SC - O(N * Target) + O(Target)
public int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    int sum = 0;
    for(int i = 0; i < n; i++){
        sum += nums[i];
    }

    if((sum - target) < 0 || ((sum - target) % 2) == 1){
        return 0;
    }
    int t = (sum - target)/2;
    int dp[][] = new int[n][t + 1];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }

    return ft(n - 1, t, nums, dp);
}


private int ft(int idx, int target, int nums[], int dp[][]){
    if(idx == 0){
        if(target == 0 && nums[0] == 0){
            return 2;
        }
        if(target == 0 || target == nums[0]){
            return 1;
        }
        return 0;
    }
    if(dp[idx][target] != -1){
        return dp[idx][target];
    }

    int notPick = ft(idx - 1, target, nums, dp);
    int pick = 0;
    if(nums[idx] <= target){
        pick = ft(idx - 1, target - nums[idx], nums, dp);
    }

    return dp[idx][target] = pick + notPick;
}

// Space Optimization
// TC - O(N * Target)
// SC - O(N * Target)
public int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    int sum = 0;
    for(int i = 0; i < n; i++){
        sum += nums[i];
    }

    if((sum - target) < 0 || ((sum - target) % 2) == 1){
        return 0;
    }
    int t = (sum - target)/2;
    int dp[][] = new int[n][t + 1];

    if(nums[0] == 0){
        dp[0][0] = 2;
    }
    else{
        dp[0][0] = 1;
    }

    if(nums[0] != 0 && nums[0] <= t){
        dp[0][nums[0]] = 1;
    }

    for(int i = 1; i < n; i++){
        for(int j = 0; j <= t; j++){
            int notPick = dp[i - 1][j];
            int pick = 0;
            if(nums[i] <= j){
                pick = dp[i - 1][j - nums[i]];
            }

            dp[i][j] = pick + notPick;
        }
    }
    return dp[n - 1][t];
}

// Tabulation
// TC - O(N * Target)
// SC - O(Target)
public int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    int sum = 0;
    for(int i = 0; i < n; i++){
        sum += nums[i];
    }

    if((sum - target) < 0 || ((sum - target) % 2) == 1){
        return 0;
    }
    int t = (sum - target)/2;
    int prev[] = new int[t + 1];

    if(nums[0] == 0){
        prev[0] = 2;
    }
    else{
        prev[0] = 1;
    }

    if(nums[0] != 0 && nums[0] <= t){
        prev[nums[0]] = 1;
    }

    for(int i = 1; i < n; i++){
        int curr[] = new int[t + 1];
        for(int j = 0; j <= t; j++){
            int notPick = prev[j];
            int pick = 0;
            if(nums[i] <= j){
                pick = prev[j - nums[i]];
            }

            curr[j] = pick + notPick;
        }
        prev = curr;
    }
    return prev[t];
}
