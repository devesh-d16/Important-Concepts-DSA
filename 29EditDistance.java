// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
// You have the following three operations permitted on a word/:
// Insert a character
// Delete a character
// Replace a character

// RECURSION
public int minDistance(String w1, String w2) {
    int m = w1.length();
    int n = w2.length();

    return md(m - 1, n - 1, w1, w2);
}

public int md(int idx1, int idx2, String w1, String w2){
    if(idx1 < 0){
        return idx2 + 1;
    }
    if(idx2 < 0){
        return idx1 + 1;
    }

    if(w1.charAt(idx1) == w2.charAt(idx2)){
        return (0 + md(idx1 - 1, idx2 - 1, w1, w2));
    }
    else{
        int insert = 1 + md(idx1, idx2 - 1, w1, w2);
        int remove = 1 + md(idx1 - 1, idx2, w1, w2);
        int replace = 1 + md(idx1 - 1, idx2 - 1, w1, w2);

        return Math.min(replace, Math.min(insert, remove));
    }
}

// MEMOIZATION
public int minDistance(String w1, String w2) {
    int m = w1.length();
    int n = w2.length();
    int dp[][] = new int[m + 1][n + 1];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }

    return md(m, n, w1, w2, dp);
}

public int md(int idx1, int idx2, String w1, String w2, int dp[][]){
    if(idx1 == 0){
        return idx2;
    }
    if(idx2 == 0){
        return idx1;
    }

    if(dp[idx1][idx2] != -1){
        return dp[idx1][idx2];
    }

    if(w1.charAt(idx1 - 1) == w2.charAt(idx2 - 1)){
        return dp[idx1][idx2] = (0 + md(idx1 - 1, idx2 - 1, w1, w2, dp));
    }
    else{
        int insert = 1 + md(idx1, idx2 - 1, w1, w2, dp);
        int remove = 1 + md(idx1 - 1, idx2, w1, w2, dp);
        int replace = 1 + md(idx1 - 1, idx2 - 1, w1, w2, dp);

        return dp[idx1][idx2] = Math.min(replace, Math.min(insert, remove));
    }
}
// TABULATION
public int minDistance(String w1, String w2) {
    int m = w1.length();
    int n = w2.length();
    int dp[][] = new int[m + 1][n + 1];

    for(int i = 0; i <= m; i++){
        dp[i][0] = i;
    }
    for(int i = 0; i <= n; i++){
        dp[0][i] = i;
    }

    for(int i = 1; i <= m; i++){
        for(int j = 1; j <= n; j++){
            if(w1.charAt(i - 1) == w2.charAt(j - 1)){
                dp[i][j] = 0 + dp[i - 1][j - 1];
            }
            else{
                int insert = 1 + dp[i][j - 1];
                int remove = 1 + dp[i - 1][j];
                int replace = 1 + dp[i - 1][j - 1];

                dp[i][j] = Math.min(replace, Math.min(insert, remove));
            }
        }
    }
    return dp[m][n];
}

// SPACE OPTIMIZATION
public int minDistance(String w1, String w2) {
    int m = w1.length();
    int n = w2.length();
    int prev[] = new int[n + 1];

    for(int i = 0; i <= m; i++){
        prev[0] = i;
    }
    for(int i = 0; i <= n; i++){
        prev[i] = i;
    }

    for(int i = 1; i <= m; i++){
        int curr[] = new int[n + 1];
        curr[0] = i;
        for(int j = 1; j <= n; j++){
            if(w1.charAt(i - 1) == w2.charAt(j - 1)){
                curr[j] = 0 + prev[j - 1];
            }
            else{
                int insert = 1 + curr[j - 1];
                int remove = 1 + prev[j];
                int replace = 1 + prev[j - 1];

                curr[j] = Math.min(replace, Math.min(insert, remove));
            }
        }
        prev = curr;
    }

    return prev[n];
}
