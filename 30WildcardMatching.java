// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).

// RECURSION
// TC - O(expo)
// SC - O(M + N)
public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();
    return im(m - 1, n - 1, s, p);
}

public boolean im(int idx1, int idx2, String s, String p){
    if(idx1 < 0 && idx2 < 0){
        return true;
    }
    if(idx1 >= 0 && idx2 < 0){
        return false;
    }

    if(idx1 < 0 && idx2 >= 0){
        for(int i = 0; i <= idx2; i++){
            if(p.charAt(i) != '*'){
                return false;
            }
        }
        return true;
    }

    if(s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '?'){
        return im(idx1 - 1, idx2 - 1, s, p);
    }
    if(p.charAt(idx2) == '*'){
        return im(idx1 - 1, idx2, s, p) || im(idx1, idx2 - 1, s, p);
    }
    return false;
}

// MEMOIZATION
// TC - O(M*N)
// SC - O(M*N) + O(M + N)
public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();
    
    boolean dp[][] = new boolean[m + 1][n + 1];

    return im(m, n, s, p, dp);
}

public boolean im(int idx1, int idx2, String s, String p, boolean dp[][]){
    if(idx1 == 0 && idx2 == 0){
        return true;
    }
    if(idx1 > 0 && idx2 == 0){
        return false;
    }

    if(idx1 == 0 && idx2 > 0){
        for(int i = 1; i <= idx2; i++){
            if(p.charAt(i - 1) != '*'){
                return false;
            }
        }
        return true;
    }
    if(dp[idx1][idx2] != false){
        return dp[idx1][idx2];
    }

    if(s.charAt(idx1 - 1) == p.charAt(idx2 - 1) || p.charAt(idx2 - 1) == '?'){
        return dp[idx1][idx2] = im(idx1 - 1, idx2 - 1, s, p, dp);
    }
    if(p.charAt(idx2 - 1) == '*'){
        return dp[idx1][idx2] = im(idx1 - 1, idx2, s, p, dp) || im(idx1, idx2 - 1, s, p, dp);
    }
    return dp[idx1][idx2] = false;
}

// TABULATION
// TC - O(M*N)
// SC - O(M*N)
public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();
    
    boolean dp[][] = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for(int i = 1; i <= m; i++){
        dp[i][0] = false;
    }
    for(int i = 1; i<= n; i++){
        dp[0][i] = isStar(p, i);
    }

    for(int i = 1; i <= m; i++){
        for(int j = 1; j <= n; j++){
            if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                dp[i][j] = dp[i - 1][j - 1];
            }
            else{
                if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
    }
    return dp[m][n];
}

public boolean isStar(String p, int j){
    for(int i = 1; i <= j; i++){
        if(p.charAt(i - 1) != '*'){
            return false;
        }
    }
    return true;
}

// SPACE OPTIMIZATION
// TC - O(M * N)
// SC - O(M)
static boolean isAllStars(String S1, int i) {

  // S1 is taken in 1-based indexing
  for (int j = 1; j <= i; j++) {
    if (S1.charAt(j - 1) != '*')
      return false;
  }
  return true;
}

static boolean wildcardMatching(String S1, String S2) {

  int n = S1.length();
  int m = S2.length();

  boolean prev[] = new boolean[m + 1];
  boolean cur[] = new boolean[m + 1];

  prev[0] = true;

  for (int i = 1; i <= n; i++) {
    cur[0] = isAllStars(S1, i);
    for (int j = 1; j <= m; j++) {

      if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?')
        cur[j] = prev[j - 1];

      else {
        if (S1.charAt(i - 1) == '*')
          cur[j] = prev[j] || cur[j - 1];

        else cur[j] = false;
      }
    }
    prev = (boolean[]) cur.clone();
  }
  return prev[m];
}
