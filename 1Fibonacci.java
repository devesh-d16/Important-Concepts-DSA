// Find Nth Fibonacci Number

// Recursion
public static int fibnc(int n){
  if(n <= 1){
    return n;
  }
  return fibnc(n - 1) + fibnc(n - 2);
}

// Memoization
// TC - O(N)
// SC - O(N) + o(N)
int dp[] = new int[n + 1];
for(int i = 0; i < n; i++){
  dp[i] = -1;
}

public static int fibnc(int n, int dp[]){
  if(n <= 1){
    return n;
  }

  if(dp[n] != -1){
    return dp[n];
  }

  return dp[n] = fibnc(n - 1, dp) + fibnc(n - 2, dp);
}

// Tabulation
// TC - O(N)
// SC - O(N) + O(N)
int dp[] = new int[n + 1];
dp[0] = 0;
dp[1] = 1;
for(int i = 2; i < n; i++){
  dp[i] = dp[i - 1] + dp[i - 2];
}

return dp[n];

// Space Optimization
// TC - O(N)
// SC - O(1)
int prev2 = 0;
int prev = 1;

for(int i = 2; i < n; i++){
  int curr = prev + prev2;
  prev2 = prev;
  prev = curr;
}

return prev;

