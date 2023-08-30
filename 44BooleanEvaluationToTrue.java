// You are given an expression 'exp' in the form of a string where operands will be : (TRUE or FALSE), and operators will be : (AND, OR or XOR).
// Now you have to find the number of ways we can parenthesize the expression such that it will evaluate to TRUE.
// As the answer can be very large, return the output modulo 1000000007.

// Recursion
/*
    Time Complexity: O(4 ^ N)
    Space Complexity: O(4 ^ N)

    Where 'N' is the the length of string.
*/

public class Solution {
    public static int mod = 1000000007;

    public static int findWays(String exp, int i, int j, int isTrue) {
        // Corner Cases.
        if (i > j) {
            return 0;
        }

        // If length of expression we need to evaluate is 1.
        if (i == j) {
            if (isTrue == 1) {
                if (exp.charAt(i) == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (exp.charAt(i) == 'F') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        long ans = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            // The number of ways expression left to 'K' will be true.
            long leftTrue = (findWays(exp, i, k - 1, 1)) % mod;

            // The number of ways expression left to 'K' will be false.
            long leftFalse = (findWays(exp, i, k - 1, 0)) % mod;

            // The number of ways expression right to 'K' will be true.
            long rightTrue = (findWays(exp, k + 1, j, 1)) % mod;

            // The number of ways expression right to 'K' will be false.
            long rightFalse = (findWays(exp, k + 1, j, 0)) % mod;

            if (exp.charAt(k) == '|') {
                // T|T=T, T|F=T, F|T=T , F|F=F.
                if (isTrue == 1) {
                    ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                    ans = ans % mod;
                } else {
                    ans += leftFalse * rightFalse;
                    ans = ans % mod;
                }
            }
            else if (exp.charAt(k) == '&') {
                // T&T=T, T&F=F, F&T=F , F|F=F.
                if (isTrue == 1) {
                    ans += leftTrue * rightTrue;
                    ans = ans % mod;

                } else {
                    ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                    ans = ans % mod;
                }
            }
            else {
                // T^T=F, T^F=T, F^T=T , F^F=F.
                if (isTrue == 1) {
                    ans += leftTrue * rightFalse + leftFalse * rightTrue;
                    ans = ans % mod;
                } else {
                    ans += leftTrue * rightTrue + leftFalse * rightFalse;
                    ans = ans % mod;
                }
            }
        }

        return (int)ans;
    }

    public static int evaluateExp(String exp) {
        int n = exp.length();

        // We need to evaluate whole expression for true.
        return findWays(exp, 0, n - 1, 1);
    }
}

// Memoization
/*
    Time Complexity: O(N ^ 3)
    Space Complexity: O(N ^ 2)

    Where 'N' is the the length of string.
*/

public class Solution {
    public static int mod = 1000000007;
    public static long [][][] memo;

    public static int findWays(String exp, int i, int j, int isTrue) {
        // Corner Cases.
        if (i > j) {
            return 0;
        }

        // If length of expression we need to evaluate is 1.
        if (i == j) {
            if (isTrue == 1) {
                if (exp.charAt(i) == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (exp.charAt(i) == 'F') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        if (memo[i][j][isTrue] != -1) {
            return (int)memo[i][j][isTrue];
        }

        long ans = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {

            if (memo[i][k - 1][1] == -1) {
                memo[i][k - 1][1] = (findWays(exp, i, k - 1, 1)) % mod;
            }

            if (memo[i][k - 1][0] == -1) {
                memo[i][k - 1][0] = (findWays(exp, i, k - 1, 0)) % mod;
            }

            if (memo[k + 1][j][1] == -1) {
                memo[k + 1][j][1] = (findWays(exp, k + 1, j, 1)) % mod;
            }

            if (memo[k + 1][j][0] == -1) {
                memo[k + 1][j][0] = (findWays(exp, k + 1, j, 0)) % mod;
            }

            // The number of ways expression left to 'K' will be true.
            long leftTrue = memo[i][k - 1][1];

            // The number of ways expression left to 'K' will be false.
            long leftFalse = memo[i][k - 1][0];

            // The number of ways expression right to 'K' will be true.
            long rightTrue = memo[k + 1][j][1];

            // The number of ways expression right to 'K' will be false.
            long rightFalse = memo[k + 1][j][0];

            if (exp.charAt(k) == '|') {
                // T|T=T, T|F=T, F|T=T , F|F=F. 
                if (isTrue == 1) {
                    ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                    ans = ans % mod;
                } else {
                    ans += leftFalse * rightFalse;
                    ans = ans % mod;
                }
            } 
            else if (exp.charAt(k) == '&') {
                // T&T=T, T&F=F, F&T=F , F|F=F.
                if (isTrue == 1) {
                    ans += leftTrue * rightTrue;
                    ans = ans % mod;

                } else {
                    ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                    ans = ans % mod;
                }
            } 
            else {
                // T^T=F, T^F=T, F^T=T , F^F=F.
                if (isTrue == 1) {
                    ans += leftTrue * rightFalse + leftFalse * rightTrue;
                    ans = ans % mod;
                } else {
                    ans += leftTrue * rightTrue + leftFalse * rightFalse;
                    ans = ans % mod;
                }
            }
        }
        
        memo[i][j][isTrue] = ans;
        return (int)ans;
    }

    public static int evaluateExp(String exp) {
        int n = exp.length();

        // We need to evaluate whole expression for true.
        memo = new long[n][n][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                memo[i][j][0] = -1;
                memo[i][j][1] = -1;
            }
        }
        
        return findWays(exp, 0, n - 1, 1);
    }
}

// Tabulation
/*
    Time Complexity: O(N ^ 3)
    Space Complexity: O(N ^ 2)

    Where 'N' is the the length of string.
*/

public class Solution {
    public static int mod = 1000000007;

    public static int evaluateExp(String exp) {
        int n = exp.length();

        // We need to evaluate whole expression for true.
        long[][][] dp = new long[n][n][2];

        // Filling the diagonal enteries.
        for (int i = 0; i < n; i++) {
            if (exp.charAt(i) == 'T') {
                dp[i][i][1] = 1;
            } else if (exp.charAt(i) == 'F') {
                dp[i][i][0] = 1;
            }
        }

        // Filling the dp array.
        for (int gap = 2; gap < n; gap += 2) {
            for (int j = 0; j + gap < n; j += 2) {
                for (int k = j; k < j + gap; k += 2) {

                    if(exp.charAt(k + 1) == '|') {
                        // T|T=T, T|F=T, F|T=T , F|F=F. 
                        dp[j][j + gap][1] += ((dp[j][k][0] * dp[k + 2][j + gap][1]) + 
                            (dp[j][k][1] * dp[k + 2][j + gap][0]) + 
                            (dp[j][k][1] * dp[k + 2][j + gap][1])) % mod;
                        dp[j][j + gap][1] %= mod;
                        dp[j][j + gap][0] += ((dp[j][k][0] * dp[k + 2][j + gap][0])) % mod;
                        dp[j][j + gap][0] %= mod;
                    }

                    if(exp.charAt(k + 1) == '&') {
                        // T&T=T, T&F=F, F&T=F , F|F=F.
                        dp[j][j + gap][1] += ((dp[j][k][1] * dp[k + 2][j + gap][1])) % mod;
                        dp[j][j + gap][1] %= mod;
                        dp[j][j + gap][0] += ((dp[j][k][0] * dp[k + 2][j + gap][1]) + 
                            (dp[j][k][1] * dp[k + 2][j + gap][0]) + 
                            (dp[j][k][0] * dp[k + 2][j + gap][0])) % mod;
                        dp[j][j + gap][0] %= mod;
                    }

                    if(exp.charAt(k + 1) == '^') {
                        // T^T=F, T^F=T, F^T=T , F^F=F
                        dp[j][j + gap][1] += ((dp[j][k][1] * dp[k + 2][j + gap][0]) + 
                            (dp[j][k][0] * dp[k + 2][j + gap][1])) % mod;
                        dp[j][j + gap][1] %= mod;
                        dp[j][j + gap][0] += ((dp[j][k][0] * dp[k + 2][j + gap][0]) + 
                            (dp[j][k][1] * dp[k + 2][j + gap][1])) % mod;
                        dp[j][j + gap][0] %= mod;
                    }
                }
            }
        }
        
        return (int)dp[0][n - 1][1];
    }
}
