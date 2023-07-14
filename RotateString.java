// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position.
// For example, if s = "abcde", then it will be "bcdea" after one shift.
 
// Input: s = "abcde", goal = "cdeab"
// Output: true

// Input: s = "abcde", goal = "abced"
// Output: false


    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        int i = 0;
        while(i < n){
          // insert the last element to first
            sb.insert(0, sb.charAt(n - 1));
          // calc the length again
            int t = sb.length();
          // now delete the last character
            sb.deleteCharAt(t - 1);
          // check if it is equal to goal
            if(sb.toString().equals(goal)){
                return true;
            }
            i++;
        }
        return false;
    }
