// You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

// You have two robots that can collect cherries for you:

// Robot #1 is located at the top-left corner (0, 0), and
// Robot #2 is located at the top-right corner (0, cols - 1).
// Return the maximum number of cherries collection using both robots by following the rules below:

// From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
// When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
// When both robots stay in the same cell, only one takes the cherries.
// Both robots cannot move outside of the grid at any moment.
// Both robots should reach the bottom row in grid.

// Recursion
// TC - exponential
// SC - O(N)
public int cherryPickup(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    return cp(0, 0, m - 1, n, m, grid);
}

public int cp(int i, int j1, int j2, int n, int m, int grid[][]){
    if(j1 < 0 || j2 < 0 || j1 >= m || j2 >= m){
        return (int)(-1e9);
    }

    if(i == n - 1){
        if(j1 == j2){
            return grid[i][j2];
        }
        else{
            return (grid[i][j1] + grid[i][j2]);
        }
    }

    int maxm = (int)(-1e9);
    for(int dj1 = -1; dj1 <= 1; dj1++){
        for(int dj2 = -1; dj2 <= 1; dj2++){
            int value = 0;
            if(j1 == j2){
                value = grid[i][j1];
            }
            else{
                value = grid[i][j1] + grid[i][j2];
            }
            value += cp(i + 1, j1 + dj1, j2 + dj2, n, m, grid);
            maxm = Math.max(maxm, value);
        }
    }
    return maxm;
}

// Memoization
// TC - O(N * M * M) * 9
// SC - O(N * m * m) + O(N)
public int cherryPickup(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int dp[][][] = new int[n][m][m];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
          for(int k = 0; k < m; k++){
              dp[i][j][k] = -1;
          }
       }
    }
    return cp(0, 0, m - 1, n, m, grid, dp);
}

public int cp(int i, int j1, int j2, int n, int m, int grid[][], int dp[][][]){
    if(j1 < 0 || j2 < 0 || j1 >= m || j2 >= m){
        return (int)(-1e9);
    }

    if(i == n - 1){
        if(j1 == j2){
            return grid[i][j2];
        }
        else{
            return (grid[i][j1] + grid[i][j2]);
        }
    }

    if(dp[i][j1][j2] != -1){
        return dp[i][j1][j2];
    }

    int maxm = (int)(-1e9);
    for(int dj1 = -1; dj1 <= 1; dj1++){
        for(int dj2 = -1; dj2 <= 1; dj2++){
            int value = 0;
            if(j1 == j2){
                value = grid[i][j1];
            }
            else{
                value = grid[i][j1] + grid[i][j2];
            }
            value += cp(i + 1, j1 + dj1, j2 + dj2, n, m, grid, dp);
            maxm = Math.max(maxm, value);
        }
    }
    return dp[i][j1][j2] = maxm;
}
