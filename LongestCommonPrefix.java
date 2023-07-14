// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string .

// Input: strs = ["flower","flow","flight"]
// Output: "fl"

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.


    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        for(int i = 0; i < Math.min(first.length(), last.length()); i++){
            if(first.charAt(i) != last.charAt(i)){
                return first.substring(0, i);
            }
        }
        return first;
    }
