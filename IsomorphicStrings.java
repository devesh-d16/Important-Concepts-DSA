// Given two strings s and t, determine if they are isomorphic.
// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters. 
// No two characters may map to the same character, but a character may map to itself.

// Input: s = "egg", t = "add"
// Output: true

// Input: s = "foo", t = "bar"
// Output: false

// Input: s = "paper", t = "title"
// Output: true

    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m){
            return false;
        }

        int map1[] = new int[200];
        int map2[] = new int[200];

      // toh scene aisa hai ki humlog ek ek character lenge dono string ka
      // and map array me uske address ka count ko increase krte jayenge
      // and if count alg hua kbi toh false return krenge
        for(int i = 0; i < s.length(); i++){
            if(map1[s.charAt(i)] != map2[t.charAt(i)]){
                return false;
            }

            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }
