// Recursion
// TC - O(2^N)
// SC - O(N)
public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
  int n = nums.size();
  return mnas(n - 1, nums);
}

public static int mnas(int idx, ArrayList<Integer> nums){
  if(idx == 0){
    return nums.get(idx);
  }
  if(idx < 0){
    return 0;
  }
  int pick = nums.get(idx) + mnas(idx - 2, nums);
  int notPick = 0 + mnas(idx - 1, nums);

  return Math.max(pick, notPick);
}

// Memoization
// TC - O(N)
// SC - O(N) + O(N)
public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
  int n = nums.size();
  int dp[] = new int[n];
  Arrays.fill(dp, -1);
  return mnas(n - 1, nums, dp);
}

public static int mnas(int idx, ArrayList<Integer> nums, int dp[]){
  if(idx == 0){
    return nums.get(idx);
  }
  if(idx < 0){
    return 0;
  }
  if(dp[idx] != -1){
    return dp[idx];
  }

  int pick = nums.get(idx) + mnas(idx - 2, nums, dp);
  int notPick = 0 + mnas(idx  -1, nums, dp);

  return dp[idx] = Math.max(pick, notPick);
}

// Tabulation
// TC - O(N)
// SC - O(N)

public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
  int n = nums.size();
  int dp[] = new int[n];
  
  // Base Case
  dp[0] = nums.get(0);
  int neg = 0;
  
  for(int i = 1; i < n; i++){
    int pick = nums.get(i);
    if(i > 1){
      pick += dp[i - 2];
    }
    int notPick = 0 + dp[i - 1];

    dp[i] = Math.max(pick, notPick);
  }

  return dp[n - 1];
}

// Space Optimization
// TC - O(N)
// SC - O(1)

public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
  int n = nums.size();

  int prev1 = nums.get(0);
  int prev2 = 0;
  
  for(int i = 1; i < n; i++){
    int pick = nums.get(i);
    if(i > 1){
      pick += prev2;
    }
    int notPick = 0 + prev1;

    int curr = Math.max(pick, notPick);
    prev2 = prev1;
    prev1 = curr;
  }
  return prev1;
}
