// You are given a string num, representing a large integer. 
// Return the largest-valued odd integer (as a string) that is a non-empty substring of num, 
// or an empty string "" if no odd integer exists.
// A substring is a contiguous sequence of characters within a string.

// TC = O(n)
// SC - O(n)

    public String largestOddNumber(String num) {
      // we will start from last and check if it's odd or not
      // if it's odd then we will return the substring from 0 index
        for(int i = num.length() - 1; i >= 0; i--){
            if(num.charAt(i)%2 != 0){
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
