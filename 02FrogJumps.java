// FrogJump
// https://www.codingninjas.com/studio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

// Memoization
// TC - O(N)
// SC - O(N) + O(N)
public static int frogJump(int n, int heights[]) {
  int dp[] = new int[n + 1];
  Arrays.fill(dp,-1);
  return fg(n - 1,heights,dp);   
}
public static int fg(int idx, int hgt[], int dp[]){
  if(idx == 0){
      return 0;
  }
  if(dp[idx] != -1){
      return dp[idx];
  }
  int left = fg(idx - 1,hgt,dp) + Math.abs(hgt[idx] - hgt[idx - 1]);
  int right = Integer.MAX_VALUE;
  if(idx > 1){
      right = fg(idx - 2, hgt,dp) + Math.abs(hgt[idx] - hgt[idx - 2]);
  }
  return dp[idx] = Math.min(left, right);
}

// Tabulation
// TC - O(N)
// SC - O(N)
public static int frogJump(int n, int heights[]) {
  int dp[] = new int[n];
  dp[0] = 0;
  for(int i = 1; i < n; i++){
    int left = dp[i - 1] + Math.abs(hgt[i] - hgt[i - 1]);
    int right = Integer.MAX_VALUE;
    if(i > 1){
      right = dp[i - 2] + Math.abs(hgt[i] - hgt[i - 2]);
    }
    dp[i] = Math.min(left, right);
  }
  return dp[n - 1];
}

// Space Optimization
// TC - O(N)
// SC - O(1)
public static int frogJump(int n, int heights[]) {
  int prev1 = 0;
  int prev2 = 0;
  for(int i = 1; i < n; i++){
    int left = prev + Math.abs(hgt[i] - hgt[i - 1]);
    int right = Integer.MAX_VALUE;
    if(i > 1){
      right = prev2 + Math.abs(hgt[i] - hgt[i - 2]);
    }
    int curr = Math.min(left, right);
    prev1 = curr;
    prev2 = prev1;
  }
  return prev1;
}
