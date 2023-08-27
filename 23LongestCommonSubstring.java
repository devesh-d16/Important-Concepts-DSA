// You are given two strings, 'str1' and 'str2'. You have to find the length of the longest common substring.
// A substring is a continuous segment of a string. For example, "bcd" is a substring of "abcd", while "acd" or "cda" are not.

// Tabulation
static int lcs(String s1, String s2){
    
    int n = s1.length();
    int m = s2.length();
    
    int[][] dp=new int[n+1][m+1];
    int ans = 0;
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                int val = 1 + dp[i-1][j-1];
                dp[i][j] = val;
                ans = Math.max(ans,val);
            }
            else{
                dp[i][j] = 0;
            }
        }
    }
    return ans;
}

// Space Optimization
public static int lcs(String str1, String str2) {
  int n = str1.length();
  int m = str2.length();

  int prev[] = new int[m + 1];

  for(int j = 0; j < m + 1; j++){
    prev[j] = 0;
  }

  int ans = 0;
  for(int i = 1; i < n + 1; i++){
    int curr[] = new int[m + 1];
    for(int j = 1; j < m + 1; j++){
      if(str1.charAt(i - 1) == str2.charAt(j - 1)){
        curr[j] = 1 + prev[j - 1];
        ans = Math.max(ans,curr[j]);
      }else{
        curr[j] = 0;
      }
    }
    prev = curr;
  }
  return ans;
}
