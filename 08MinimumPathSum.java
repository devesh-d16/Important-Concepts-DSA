// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
// which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.

// Recursion
// TC - O(2^(n * m))
//  SC - O(n + m)

public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    if(m == 1 && n == 1){
        return grid[0][0];
    }

    return mps(m - 1, n - 1, grid);
}

public int mps(int i, int j, int grid[][]){
    if(i == 0 && j == 0){
        return grid[i][j];
    }
    if(i < 0 || j < 0){
        return (int)1e9;
    }

    int up =  grid[i][j] + mps(i - 1, j, grid);
    int left = grid[i][j] + mps(i, j - 1, grid);

    return Math.min(up , left);
}

// Memoization
// TC - O((n * m))
//  SC - O(n + m) + O(m + n)
public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    if(m == 1 && n == 1){
        return grid[0][0];
    }
    int dp[][] = new int[m + 1][n + 1];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }
    return mps(m - 1, n - 1, grid, dp);
}

public int mps(int i, int j, int grid[][], int dp[][]){
    if(i == 0 && j == 0){
        return grid[i][j];
    }
    if(i < 0 || j < 0){
        return (int)1e9;
    }
    if(dp[i][j] != -1){
        return dp[i][j];
    }

    int up =  grid[i][j] + mps(i - 1, j, grid, dp);
    int left = grid[i][j] + mps(i, j - 1, grid, dp);

    return dp[i][j] = Math.min(up , left);
}

// Tabulation
// TC - O((n * m))
// SC - O(m + n)
public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    if(m == 1 && n == 1){
        return grid[0][0];
    }
    int dp[][] = new int[m + 1][n + 1];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(i == 0 && j == 0){
                dp[i][j] = grid[i][j];
            }
            else{
                int up = grid[i][j];
                int left = grid[i][j];
                if(i > 0){
                    up += dp[i - 1][j];
                }
                else{
                    up += (int)1e9;
                }
                if(j > 0){
                    left += dp[i][j - 1];
                }
                else{
                    left += (int)1e9;
                }
                dp[i][j] = Math.min(up, left);
            }
        }
    }
    return dp[m - 1][n - 1];
}

// Space Optimization
// TC - O((n * m))
// SC - O(n)
public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    if(m == 1 && n == 1){
        return grid[0][0];
    }
    int prev[] = new int[n + 1];
    for(int i = 0; i < m; i++){
        int curr[] = new int[n + 1];
        for(int j = 0; j < n; j++){
            if(i == 0 && j == 0){
                curr[j] = grid[i][j];
            }
            else{
                int up = grid[i][j];
                int left = grid[i][j];
                if(i > 0){
                    up += prev[j];
                }
                else{
                    up += (int)1e9;
                }
                if(j > 0){
                    left += curr[j - 1];
                }
                else{
                    left += (int)1e9;
                }
                curr[j] = Math.min(up, left);
            }
        }
        prev = curr;
    }
    return prev[n - 1];
}
