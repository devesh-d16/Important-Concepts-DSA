// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. 
// Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

// Recursion
// TC - 3^N ~ exponential
// SC - O(N)
public int minFallingPathSum(int[][] matrix) {
  int m = matrix.length;
  int n = matrix[0].length;
  int minm = (int)(1e9);
  
  for(int j = 0; j < n; j++){
      minm = Math.min(minm, f(n - 1, j, matrix, m, n));
  }
  return minm;
}

public int f(int i, int j, int matrix[][], int m, int n){
  if(j < 0 || j >= n){
      return (int)(1e9);
  }
  if(i == 0){
      return matrix[i][j];
  }

  int up = matrix[i][j] + f(i - 1, j, matrix, m, n);
  int degR = matrix[i][j] + f(i - 1, j + 1, matrix, m, n);
  int degL = matrix[i][j] + f(i - 1, j - 1, matrix, m, n);

  return Math.min(Math.min(degR, degL), up);
}

// Memoization
// SC - O(N * M)
// TC - O(N * M) + O(N)
public int minFallingPathSum(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int minm = (int)(1e9);
    
    int dp[][] = new int[m][n];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }

    for(int j = 0; j < n; j++){
        minm = Math.min(minm, f(n - 1, j, matrix, m, n, dp));
    }
    return minm;
}

public int f(int i, int j, int matrix[][], int m, int n, int dp[][]){
    if(j < 0 || j >= n){
        return (int)(1e9);
    }
    if(i == 0){
        return matrix[i][j];
    }
    if(dp[i][j] != -1){
        return dp[i][j];
    }

    int up = matrix[i][j] + f(i - 1, j, matrix, m, n, dp);
    int degR = matrix[i][j] + f(i - 1, j + 1, matrix, m, n, dp);
    int degL = matrix[i][j] + f(i - 1, j - 1, matrix, m, n, dp);

    return Math.min(Math.min(degR, degL), up);
}

// Tabulation
// TC - O(N * M) + O(N)
// SC - O(N * N)
public int minFallingPathSum(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    
    int dp[][] = new int[m][n];
    for(int j = 0; j < n; j++){
        dp[0][j] = matrix[0][j];
    }

    for(int i = 1; i < m; i++){
        for(int j = 0; j < n; j++){
            int up = matrix[i][j] + dp[i - 1][j];

            int degR = matrix[i][j];
            if(j + 1 < n){
                degR += dp[i - 1][j + 1];
            }
            else{
                degR += (int)(1e9);
            }

            int degL = matrix[i][j];
            if(j - 1 >= 0){
                degL += dp[i - 1][j - 1];
            }
            else{
                degL += (int)(1e9);
            }

            dp[i][j] = Math.min(up, Math.min(degR,degL));  
        }
    }
  
    int minm = (int)(1e9);
    for(int i = 0; i < n; i++){
        minm = Math.min(minm, dp[m - 1][i]);
    }

    return minm;
}

// TC - O(M * N) + O(N)
// SC - O(N)
public int minFallingPathSum(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    
    int prev[] = new int[n];
    for(int j = 0; j < n; j++){
        prev[j] = matrix[0][j];
    }

    for(int i = 1; i < m; i++){
        int curr[] = new int[n];
        for(int j = 0; j < n; j++){
            int up = matrix[i][j] + prev[j];

            int degR = matrix[i][j];
            if(j + 1 < n){
                degR += prev[j + 1];
            }
            else{
                degR += (int)(1e9);
            }

            int degL = matrix[i][j];
            if(j - 1 >= 0){
                degL += prev[j - 1];
            }
            else{
                degL += (int)(1e9);
            }
            curr[j] = Math.min(up, Math.min(degR,degL));  
        }
        prev = curr;
    }

    int minm = (int)(1e9);
    for(int i = 0; i < n; i++){
        minm = Math.min(minm, prev[i]);
    }

    return minm;
}
