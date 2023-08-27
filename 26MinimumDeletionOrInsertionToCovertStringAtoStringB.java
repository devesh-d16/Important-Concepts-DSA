// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
// In one step, you can delete exactly one character in either string.

public int minDistance(String w1, String w2) {
    int m = w1.length();
    int n = w2.length();

    int prev[] = new int[n + 1];

    for(int i = 1; i <= m; i++){
        int curr[] = new int[n + 1];
        for(int j = 1; j <= n; j++){
            if(w1.charAt(i - 1) == w2.charAt(j - 1)){
                curr[j] = 1 + prev[j - 1];
            }
            else{
                curr[j] = 0 + Math.max(prev[j], curr[j - 1]);
            }
        }
        prev = curr;
    }

    int len = m + n - 2*prev[n];
    return len;
}
