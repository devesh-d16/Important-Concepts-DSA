// Given a triangle array, return the minimum path sum from top to bottom.
// For each step, you may move to an adjacent number of the row below.
// More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

// Recursion
// TC - O(2^(1 + 2 + 3 + ... n))
// SC - O(n)
public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    return mt(0, 0, triangle, n);
}

public int mt(int i, int j, List<List<Integer>> triangle, int n){
    if(i == n - 1){
        return triangle.get(i).get(j);
    }

    int d = triangle.get(i).get(j) + mt(i + 1, j, triangle, n);
    int dg = triangle.get(i).get(j) + mt(i + 1, j + 1, triangle, n);

    return Math.min(d, dg);
}

// Memoization
// TC - O(n * n)
// SC - O(n * n) + O(n) 
public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int dp[][] = new int[n][n];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }
    return mt(0, 0, triangle, n, dp);
}

public int mt(int i, int j, List<List<Integer>> triangle, int n, int dp[][]){
    if(i == n - 1){
        return triangle.get(i).get(j);
    }
    if(dp[i][j] != -1){
        return dp[i][j];
    }

    int d = triangle.get(i).get(j) + mt(i + 1, j, triangle, n, dp);
    int dg = triangle.get(i).get(j) + mt(i + 1, j + 1, triangle, n, dp);

    return dp[i][j] = Math.min(d, dg);
}

// Tabulation
// TC - O(n * n)
// SC - O(n * n)
public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int dp[][] = new int[n][n];
    for(int i = 0; i < n; i++){
        dp[n - 1][i] = triangle.get(n - 1).get(i);
    }

    for(int i = n - 2; i >= 0; i--){
        for(int j = i; j >= 0; j--){
            int d = triangle.get(i).get(j) + dp[i + 1][j];
            int dg = triangle.get(i).get(j) + dp[i + 1][j + 1];

            dp[i][j] = Math.min(d, dg);
        }
    }

    return dp[0][0];
}

// Space Optimization
// TC - O(n * n)
// SC - O(n)
public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int front[] = new int[n];
    for(int i = 0; i < n; i++){
        front[i] = triangle.get(n - 1).get(i);
    }

    for(int i = n - 2; i >= 0; i--){
        int curr[] = new int[n];
        for(int j = i; j >= 0; j--){
            int d = triangle.get(i).get(j) + front[j];
            int dg = triangle.get(i).get(j) + front[j + 1];

            curr[j] = Math.min(d, dg);
        }
        front = curr;
    }
    return front[0];
}
