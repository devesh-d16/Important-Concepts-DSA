// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return the minimum cuts needed for a palindrome partitioning of s.

// recursion
public int minCut(String s) {
    int n = s.length();
    if(n == 1){
        return 0;
    }

    return f(0, n, s) - 1;
}

public int f(int i, int n, String str){
    if(i == n){
        return 0;
    }

    int minCost = Integer.MAX_VALUE;
    for(int j = i; j < n; j++){
        if(isPalindrome(i, j, str)){
            int cost = 1 + f(j + 1, n, str);
            minCost = Math.min(cost, minCost);
        }
    }

    return minCost;
}

public boolean isPalindrome(int i, int j, String s){
    while(i < j){
        if(s.charAt(i) != s.charAt(j)){
            return false;
        }
        i++;
        j--;
    }
    return true;
}

// memoization
// TC - O(N*N)
// SC - O(N) + O(N)
public int minCut(String s) {
    int n = s.length();
    if(n == 1){
        return 0;
    }
    int dp[] = new int[n];
    Arrays.fill(dp, -1);
    return f(0, n, s, dp) - 1;
}

public int f(int i, int n, String str, int dp[]){
    if(i == n){
        return 0;
    }
    if(dp[i] != -1){
        return dp[i];
    }

    int minCost = Integer.MAX_VALUE;
    for(int j = i; j < n; j++){
        if(isPalindrome(i, j, str)){
            int cost = 1 + f(j + 1, n, str, dp);
            minCost = Math.min(cost, minCost);
        }
    }

    return dp[i] = minCost;
}

public boolean isPalindrome(int i, int j, String s){
    while(i < j){
        if(s.charAt(i) != s.charAt(j)){
            return false;
        }
        i++;
        j--;
    }
    return true;
}

// Tabulation
// TC - O(N*N)
// SC - O(N)
public int minCut(String s) {
    int n = s.length();
    if(n == 1){
        return 0;
    }
    int dp[] = new int[n + 1];
    dp[n] = 0;

    for(int i = n - 1; i >= 0; i--){
        int minCost = Integer.MAX_VALUE;
        for(int j = i; j < n; j++){
            if(isPalindrome(i, j, s)){
                int cost = 1 + dp[j + 1];
                minCost = Math.min(cost, minCost);
            }
        }
        dp[i] = minCost;
    }

    return dp[0] - 1;
}

public boolean isPalindrome(int i, int j, String s){
    while(i < j){
        if(s.charAt(i) != s.charAt(j)){
            return false;
        }
        i++;
        j--;
    }
    return true;
}
