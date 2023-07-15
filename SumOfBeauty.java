// The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
// For example, the beauty of "abaacc" is 3 - 1 = 2.
// Given a string s, return the sum of beauty of all of its substrings.

// Input: s = "aabcb"
// Output: 5
// Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.

// Input: s = "aabcbaa"
// Output: 17


    public int beautySum(String s) {
        int sum = 0;

        for(int i = 0; i < s.length(); i++){
          // to store frequency of character in each substring
            int freq[] = new int[26];

            for(int j = i; j < s.length(); j++){
                freq[s.charAt(j) - 'a']++;
              // getting beauty and adding it
                int beautSum = getBeauty(freq);
                sum += beautSum;
            }
        }
        return sum;
    }

    public int getBeauty(int freq[]){
        int maxm = Integer.MIN_VALUE;
        int minm = Integer.MAX_VALUE;

        for(int i = 0; i < 26; i++){
            if(freq[i] == 0){
                continue;
            }
            maxm = Math.max(maxm, freq[i]);
            minm = Math.min(minm, freq[i]);
        }
        return maxm - minm;
    }
