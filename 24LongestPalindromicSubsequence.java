// Given a string s, find the longest palindromic subsequence's length in s.
// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

public int longestPalindromeSubseq(String s1) {
    String s2 = reverse(s1);
    int n = s1.length();
    int m = s2.length();
    int prev[] = new int[m + 1];

    for(int j = 0; j < m + 1; j++){
        prev[j] = 0;
    }

    for(int i = 1; i < n + 1; i++){
        int curr[] = new int[m  + 1];
        for(int j = 1; j < m + 1; j++){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                curr[j] = 1 + prev[j - 1];
            }
            else{
                curr[j] = Math.max(prev[j], curr[j - 1]);
            }
        }
        prev = curr;
    }

    return prev[m];
}

public String reverse(String s){
    int n = s.length();
    String sr = "";
    for(int i = n - 1; i >= 0; i--){
        sr += s.charAt(i);
    }

    return sr;
}
