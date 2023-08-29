// You are given an array of words where each word consists of lowercase English letters.
// wordA is a predecessor of wordB if and 
// only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
// For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
// A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on.
// A single word is trivially a word chain with k == 1.
// Return the length of the longest possible word chain with words chosen from the given list of words.

public int longestStrChain(String[] words) {
    int n = words.length;
    Arrays.sort(words, Comparator.comparingInt(String::length));
    int maxm = 1;
    int dp[] = new int[n];
    Arrays.fill(dp, 1);

    for(int i = 0; i < n; i++){
        for(int j = 0; j < i; j++){
            if(checkPossible(words[i], words[j]) && 1 + dp[j] > dp[i]){
                dp[i] = 1 + dp[j];
            }
        }
        if(dp[i] > maxm){
            maxm = dp[i];
        }
    }
    return maxm;
}

public boolean checkPossible(String s1, String s2){
    if(s1.length() != s2.length() + 1){
        return false;
    }

    int i = 0;
    int j = 0;

    while(i < s1.length()){
        if(j < s2.length() && s1.charAt(i) == s2.charAt(j)){
            i++;
            j++;
        }
        else{
            i++;
        }
    }
    if(i == s1.length() && j == s2.length()){
        return true;
    }
    return false;
}
