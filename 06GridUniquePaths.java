// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
// The robot can only move either down or right at any point in time.
// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
// The test cases are generated so that the answer will be less than or equal to 2 * 109.

// Recursion
// TC - O(2^ (m * n))
// SC - O(m + n)

public int uniquePaths(int m, int n) {
    return f(m - 1, n - 1);
}

public int f(int i, int j){
    if(i == 0 && j == 0){
        return 1;
    }
    if(i < 0 || j < 0){
        return 0;
    }

    int up = f(i - 1, j);
    int left = f(i, j - 1);

    return up + left;
}

// Memoization
// TC - O(m * n)
// SC - O(m + n) + O(m + n)
public int uniquePaths(int m, int n) {
    int dp[][] = new int[m + 1][n + 1];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }
    return f(m - 1, n - 1, dp);
}

public int f(int i, int j, int dp[][]){
    if(i == 0 && j == 0){
        return 1;
    }
    if(i < 0 || j < 0){
        return 0;
    }
    if(dp[i][j] != -1){
        return dp[i][j];
    }

    int up = f(i - 1, j, dp);
    int left = f(i, j - 1, dp);

    return dp[i][j] = up + left;
}

// Tabulation
// TC - O(m * n)
// SC - O(m + n)
public int uniquePaths(int m, int n) {
  int dp[][] = new int[m][n];
  
  for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
          if(i == 0 && j == 0){
              dp[i][j] = 1;
          }
          else{
              int up = 0;
              int left = 0;
              if(i > 0){
                  up = dp[i - 1][j];
              }
              if(j > 0){
                  left = dp[i][j - 1];
              }
              dp[i][j] = up + left;
          }
      }
  }
  
  return dp[m - 1][n - 1];
}

// Space Optimization
// TC - O(m * n)
// SC - O(n)
public int uniquePaths(int m, int n) {
    int prev[] = new int[n];

    for(int i = 0; i < m; i++){
        int curr[] = new int[n];
        for(int j = 0; j < n; j++){
            if(i == 0 && j == 0){
                curr[j] = 1;
            }
            else{
                int up = 0;
                int left = 0;
                if(i > 0){
                    up = prev[j];
                }
                if(j > 0){
                    left = curr[j - 1];
                }
                curr[j] = up + left;
            }
        }
        prev = curr;
    }

    return prev[n - 1];
}
