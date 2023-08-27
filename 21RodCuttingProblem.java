// Given a rod of length ‘N’ units. 
// The rod can be cut into different sizes and each size has a cost associated with it. 
// Determine the maximum cost obtained by cutting the rod and selling its pieces

// Recursion 
public static int cutRod(int price[], int n) {
  return cr(n - 1, n, price);
}

public static int cr(int idx, int n, int price[]){
  if(idx == 0){
    return n * price[idx];
  }

  int notTake = cr(idx - 1, n, price);
  int take = (int)(-1e9);
  if(idx + 1 <= n){
    take = price[idx] + cr(idx, n - (idx + 1), price);
  }

  return Math.max(notTake, take);
}

// Memoization
public static int cutRod(int price[], int n) {
  int dp[][] = new int[n][n + 1];
  for(int arr[] : dp){
    Arrays.fill(arr, -1);
  }

  return cr(n - 1, n, price, dp);
}

public static int cr(int idx, int n, int price[], int dp[][]){
  if(idx == 0){
    return n * price[idx];
  }
  if(dp[idx][n] != -1){
    return dp[idx][n];
  }

  int notTake = cr(idx - 1, n, price, dp);
  int take = (int)(-1e9);
  if(idx + 1 <= n){
    take = price[idx] + cr(idx, n - (idx + 1), price, dp);
  }

  return dp[idx][n] = Math.max(notTake, take);
}

// Tabulation
public static int cutRod(int price[], int n) {

  int dp[][] = new int[n][n + 1];
  for(int i = 0; i <= n; i++){
    dp[0][i] = i*price[0];
  }

  for(int i = 1; i < n; i++){
    for(int j = 0; j <= n; j++){
      int notTake = 0 + dp[i - 1][j];
      int take = (int)(-1e9);
      if(1 + i <= j){
        take = price[i] + dp[i][j - (1 + i)];
      }

      dp[i][j] = Math.max(take, notTake);
    }
  }

  return dp[n - 1][n];
}
