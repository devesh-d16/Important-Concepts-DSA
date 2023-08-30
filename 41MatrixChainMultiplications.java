// Given a chain of matrices A1, A2, A3,.....An. Your task is to find out the minimum cost to multiply these matrices. 
// The cost of matrix multiplication is defined as the number of scalar multiplications. 
// A Chain of matrices A1, A2, A3,.....An is represented by a sequence of numbers in an array ‘arr’ 
// where the dimension of 1st matrix is equal to arr[0] * arr[1] , 2nd matrix is arr[1] * arr[2], and so on.
// For example:
// For arr[ ] = { 10, 20, 30, 40}, matrix A1 = [10 * 20], A2 = [20 * 30], A3 = [30 * 40]
// Scalar multiplication of matrix with dimension 10 * 20 is equal to 200.

// Recursion
// TC - (exponential)
// SC - O(N)
public static int matrixMultiplication(int[] arr , int N) {
  return f(1, N - 1, arr);
}

public static int f(int i, int j, int arr[]){
  if(i == j){
    return 0;
  }

  int minm = (int)(1e9);
  for(int k = i; k < j; k++){
    int steps = arr[i - 1] * arr[k] * arr[j] + f(i, k, arr) + f(k + 1, j, arr);
    if(steps < minm){
      minm = steps;
    }
  }
  return minm;
}

// Memoization
// TC -  O(n * n)
// SC - O(n * n) + O(n)
public static int matrixMultiplication(int[] arr , int N) {
  int dp[][] = new int[N][N];
  for(int num[] : dp){
    Arrays.fill(num, -1);
  }

  return f(1, N - 1, arr, dp);
}

public static int f(int i, int j, int arr[], int dp[][]){
  if(i == j){
    return 0;
  }
  if(dp[i][j] != -1){
    return dp[i][j];
  }

  int minm = (int)(1e9);
  for(int k = i; k < j; k++){
    int steps = arr[i - 1] * arr[k] * arr[j] + f(i, k, arr, dp) + f(k + 1, j, arr, dp);
    if(steps < minm){
      minm = steps;
    }
  }
  return dp[i][j] = minm;
}

// Tabulation
// TC - O(N * N)
// SC - O(N * N)
public static int matrixMultiplication(int[] arr , int N) {
  int dp[][] = new int[N][N];
  for(int i = 0; i < N; i++){
    dp[i][i] = 0;
  }

  for(int i = N - 1; i >= 1; i--){
    for(int j = i + 1; j < N; j++){
      int minm = (int)(1e9);
      for(int k = i; k < j; k++){
        int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
        if(steps < minm){
          minm = steps;
        }
      }
      dp[i][j] = minm;
    }
  }
  return dp[1][N - 1];
}
