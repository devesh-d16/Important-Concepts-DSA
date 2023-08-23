// Recursion
// TC - O(2^(m * n))
// SC - O(m + n)
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1){
        return 0;
    }
    return f(m - 1, n - 1, obstacleGrid);
}

public int f(int i, int j, int grid[][]){
    if(i == 0 && j == 0){
        return 1;
    }
    if(i < 0 || j < 0){
        return 0;
    }
    if(grid[i][j] == 1){
        return 0;
    }

    int up = f(i - 1, j, grid);
    int left = f(i, j - 1, grid);

    return up + left;
}


// Memoization
// TC - O(m * n)
// SC - O(m + n) + O(m + n)
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1){
        return 0;
    }
    int dp[][] = new int[m][n];
    for(int arr[]: dp){
        Arrays.fill(arr, -1);
    }
    return f(m - 1, n - 1, obstacleGrid, dp);
}

public int f(int i, int j, int grid[][], int dp[][]){
    if(i == 0 && j == 0){
        return 1;
    }
    if(i < 0 || j < 0){
        return 0;
    }
    if(grid[i][j] == 1){
        return 0;
    }
    if(dp[i][j] != -1){
        return dp[i][j];
    }

    int up = f(i - 1, j, grid, dp);
    int left = f(i, j - 1, grid, dp);

    return dp[i][j] = up + left;
}

// Tabulation
// TC - O(m * n)
// SC - O(m + n)
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1){
        return 0;
    }
    int dp[][] = new int[m][n];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(i == 0 && j == 0){
                dp[i][j] = 1;
            }
            else if(obstacleGrid[i][j] == 1){
                dp[i][j] = 0;
            }
            else{
                int up = 0;
                int down = 0;
                if(i > 0){
                    up = dp[i - 1][j];
                }
                if(j > 0){
                    down = dp[i][j - 1];
                }
                dp[i][j] = up + down;
            }
        }
    }
    return dp[m - 1][n - 1];
}

// Space Optimisation
// TC - O(M * N)
// SC - O(N)
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1){
        return 0;
    }
    int prev[] = new int[n];
    for(int i = 0; i < m; i++){
        int curr[] = new int[n];
        for(int j = 0; j < n; j++){
            if(i == 0 && j == 0){
                curr[j] = 1;
            }
            else if(obstacleGrid[i][j] == 1){
                curr[j] = 0;
            }
            else{
                int up = 0;
                int down = 0;
                if(i > 0){
                    up = prev[j];
                }
                if(j > 0){
                    down = curr[j - 1];
                }
                curr[j] = up + down;
            }
        }
        prev = curr;
    }
    return prev[n - 1]%mod;
}
