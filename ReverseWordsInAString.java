// Given an input string s, reverse the order of the words.
// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
// Return a string of the words in reverse order concatenated by a single space.
// Note that s may contain leading or trailing spaces or multiple spaces between two words. 
// The returned string should only have a single space separating the words. Do not include any extra spaces.

// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.

// Input: s = "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


    public String reverseWords(String s) {
      // to store the reverse string
        StringBuilder sb = new StringBuilder("");

        for(int i = 0, j = 0; i < s.length(); i++){
          // jbtk space aayega tbtk pointer ko increase krna hai
            if(j < s.length() && s.charAt(j) == ' '){
                while(j < s.length() && s.charAt(j) == ' '){
                    j++;
                    i = j - 1;
                }
            }
            else if(j < s.length()){
                while(j < s.length() && s.charAt(j) != ' '){
                    j++;
                }
              // insert the word at last
                sb.insert(0, s.substring(i,j) + " ");
                i = j;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
