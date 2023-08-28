// Given two strings s and t, return the number of distinct subsequences of s which equals t.
// The test cases are generated so that the answer fits on a 32-bit signed integer.

// Recursion
// TC - O(expo)
// SC - O(M + N)
public int numDistinct(String s, String t) {
    int m = s.length();
    int n = t.length();

    return nd(m - 1, n - 1, s, t);
}

public int nd(int idx1, int idx2, String s, String t){
    if(idx2 < 0){
        return 1;
    }
    if(idx1 < 0){
        return 0;
    }

    if(s.charAt(idx1) == t.charAt(idx2)){
        return (nd(idx1 - 1, idx2 - 1, s, t) + nd(idx1 - 1, idx2, s, t));
    }
    else{
        return nd(idx1 - 1, idx2, s, t);
    }
}

// Memoization
// TC - O(M * N)
// SC - O(M * N) + O(M + N)
public int numDistinct(String s, String t) {
    int n = s.length();
    int m = t.length();

    int dp[][] = new int[n + 1][m + 1];
    for(int row[] : dp){
        Arrays.fill(row, -1);
    }
    return dS(n, m, s, t, dp);
}

public int dS(int idx1, int idx2, String s, String t, int dp[][]){
    if(idx2 == 0){
        return 1;
    }
    if(idx1 == 0){
        return 0;
    }
    if(dp[idx1][idx2] != -1){
        return dp[idx1][idx2];
    }

    if(s.charAt(idx1 - 1) == t.charAt(idx2 - 1)){
        return dp[idx1][idx2] = (dS(idx1 - 1, idx2 - 1, s, t, dp) + dS(idx1 - 1, idx2, s, t, dp));
    }
    else{
        return dp[idx1][idx2] = (dS(idx1 - 1, idx2, s, t, dp));
    }
}

// Tabulation
// TC - O(M * N) 
// SC - O(M * N)
public int numDistinct(String s, String t) {
    int n = s.length();
    int m = t.length();

    int dp[][] = new int[n + 1][m + 1];
    for(int i = 0; i <= n; i++){
        dp[i][0] = 1;
    }
    for(int i = 1; i <= m; i++){
        dp[0][i] = 0;
    }

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            if(s.charAt(i - 1) == t.charAt(j - 1)){
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
            else{
               dp[i][j] = dp[i - 1][j];
            }
        }
    }
    return dp[n][m];
}

// Space Optimization
public int numDistinct(String s, String t) {
    int n = s.length();
    int m = t.length();
  
    int prev[] = new int[m + 1];
    for(int i = 0; i <= n; i++){
        prev[0] = 1;
    }
    for(int i = 1; i <= m; i++){
        prev[i] = 0;
    }
  
    for(int i = 1; i <= n; i++){
        int curr[] = new int[m + 1];
        curr[0] = 1;
        for(int j = 1; j <= m; j++){
            if(s.charAt(i - 1) == t.charAt(j - 1)){
                curr[j] = prev[j - 1] + prev[j];
            }
            else{
               curr[j] = prev[j];
            }
        }
        prev = curr;
    }
    return prev[m];
}

// Space Optimization
public int numDistinct(String s, String t) {
    int n = s.length();
    int m = t.length();

    int prev[] = new int[m + 1];
    for(int i = 0; i <= n; i++){
        prev[0] = 1;
    }
    for(int i = 1; i <= m; i++){
        prev[i] = 0;
    }

    for(int i = 1; i <= n; i++){
        for(int j = m; j >= 1; j--){
            if(s.charAt(i - 1) == t.charAt(j - 1)){
                prev[j] = prev[j - 1] + prev[j];
            }
            else{
               prev[j] = prev[j];
            }
        }
    }
    return prev[m];
}

// Space Optimization
public int numDistinct(String s, String t) {
    int n = s.length();
    int m = t.length();

    int prev[] = new int[m + 1];
    prev[0] = 1;
    for(int i = 1; i <= m; i++){
        prev[i] = 0;
    }

    for(int i = 1; i <= n; i++){
        for(int j = m; j >= 1; j--){
            if(s.charAt(i - 1) == t.charAt(j - 1)){
                prev[j] = prev[j - 1] + prev[j];
            }
        }
    }
    return prev[m];
}
