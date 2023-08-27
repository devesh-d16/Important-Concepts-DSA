// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
// A subsequence of a string is a new string generated from the original string with some characters (can be none)
// deleted without changing the relative order of the remaining characters.
// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

// Recursion
public int longestCommonSubsequence(String s, String t) {
    int m = s.length();
    int n = t.length();

    return lcs(m - 1, n - 1, s, t);
}

public int lcs(int idx1, int idx2, String s1, String s2){
    if(idx1 < 0 || idx2 < 0){
        return 0;
    }

    if(s1.charAt(idx1) == s2.charAt(idx2)){
        return (1 + lcs(idx1 - 1, idx2 - 1, s1, s2));
    }
    else{
        return (0 + Math.max(lcs(idx1 - 1, idx2, s1, s2), lcs(idx1, idx2 - 1, s1, s2)));
    }
}

// Memoization
public int longestCommonSubsequence(String s, String t) {
    int m = s.length();
    int n = t.length();
    int dp[][] = new int[m][n];
    for(int row[] : dp){
        Arrays.fill(row, -1);
    }

    return lcs(m - 1, n - 1, s, t, dp);
}

public int lcs(int idx1, int idx2, String s1, String s2, int dp[][]){
    if(idx1 < 0 || idx2 < 0){
        return 0;
    }
    if(dp[idx1][idx2] != -1){
        return dp[idx1][idx2];
    }

    if(s1.charAt(idx1) == s2.charAt(idx2)){
        return dp[idx1][idx2] = (1 + lcs(idx1 - 1, idx2 - 1, s1, s2, dp));
    }
    else{
        return dp[idx1][idx2] = (0 + Math.max(lcs(idx1 - 1, idx2, s1, s2, dp), lcs(idx1, idx2 - 1, s1, s2, dp)));
    }
}
    
// Tabulation
public int longestCommonSubsequence(String s, String t) {
    int m = s.length();
    int n = t.length();
    int dp[][] = new int[m + 1][n + 1];

    for(int i = 0; i <= m; i++){
        dp[i][0] = 0;
    }
    for(int i = 0; i <= n; i++){
        dp[0][i] = 0;
    }

    for(int i = 1; i <= m; i++){
        for(int j = 1; j <= n; j++){
            if(s.charAt(i - 1) == t.charAt(j - 1)){
                dp[i][j] = 1 + dp[i - 1][j - 1];
            }
            else{
                dp[i][j] = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[m][n];
}

// To print the subsequence
int len = dp[m][n];
StringBuilder sb = new StringBuilder("");

int i = m;
int j = n;
while(i > 0 && j > 0){
    if(s.charAt(i - 1) == t.charAt(j - 1)){
        sb.append(s.charAt(i - 1));
        i--;
        j--;
    }
    else if(dp[i - 1][j] > dp[i][j - 1]){
        i--;
    }
    else{
        j--;
    }
}
Collection.reverse(sb);
System.out.println(sb);

// Space Optimization
public int longestCommonSubsequence(String s, String t) {
    int m = s.length();
    int n = t.length();

    int prev[] = new int[n + 1];
    for(int i = 0; i <= n; i++){
        prev[i] = 0;
    }

    for(int i = 1; i <= m; i++){
        int curr[] = new int[n + 1];
        for(int j = 1; j <= n; j++){
            if(s.charAt(i - 1) == t.charAt(j - 1)){
                curr[j] = 1 + prev[j - 1];
            }
            else{
                curr[j] = 0 + Math.max(prev[j], curr[j - 1]);
            }
        }
        prev = curr;
    }
    return prev[n];
}

