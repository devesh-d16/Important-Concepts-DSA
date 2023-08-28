// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. 
// If there are multiple valid strings, return any of them.
// A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

public String shortestCommonSupersequence(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();

    int dp[][] = new int[n + 1][m + 1];

    for(int i = 1; i < n + 1; i++){
        for(int j = 1; j < m + 1; j++){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                dp[i][j] = 1 + dp[i - 1][j - 1];
            }
            else{
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    char str[] = new char[n + m - dp[n][m]];
    for(int i = 0; i < str.length; i++){
        str[i] = '#';
    }
    int k = str.length - 1;
    int i = n;
    int j = m;
    while(i > 0 && j > 0){
        if(str1.charAt(i - 1) == str2.charAt(j - 1)){
            str[k] = str2.charAt(j - 1);
            j--;
            i--;
        }
        else if(dp[i][j - 1] > dp[i - 1][j]){
            str[k] = str2.charAt(j - 1);
            j--;
        }
        else{
            str[k] = str1.charAt(i - 1);
            i--;
        }
        k--;
    }

    while(j > 0){
        str[k] = str2.charAt(j - 1);
        j--;
        k--;
    }

    while(i > 0){
        str[k] = str1.charAt(i - 1);
        i--;
        k--;
    }

    String st = new String(str);
    return st;
}
