// Given a string s, return the longest 
// palindromic substring in s.

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"


    public String longestPalindrome(String s) {
      // to store the answer
        String max = "";
        for(int i = 0; i < s.length(); i++){
          // if palindromic string is odd
            String s1 = extend(s, i, i);
          // if palindromic string is even
            String s2 = extend(s, i, i + 1);

            if(s1.length() > max.length()){
                max = s1;
            }
            if(s2.length() > max.length()){
                max = s2;
            }
        }
        return max;
    }

    public String extend(String s, int i, int j){
        for(; i >= 0 && j < s.length(); i--, j++){
            if(s.charAt(i) != s.charAt(j)){
                break;
            }
        }
        return s.substring(i + 1, j);
    }
