// Given a string s. In one step you can insert any character at any index of the string.
// Return the minimum number of steps to make s palindrome.
// A Palindrome String is one that reads the same backward as well as forward.

public int minInsertions(String s1) {
    String s2 = new StringBuilder(s1).reverse().toString();

    int n = s1.length();
    int m = s2.length();

    int prev[] = new int[m + 1];

    for(int i = 1; i < n + 1; i++){
        int curr[] = new int[m + 1];
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

    int len = n - prev[m]; // length of string that needs a partner to become a palindrome
    return len;
}
