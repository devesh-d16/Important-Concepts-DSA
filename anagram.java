// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
// typically using all the original letters exactly once.

// Input: s = "anagram", t = "nagaram"
// Output: true

// Input: s = "rat", t = "car"
// Output: false

    public boolean isAnagram(String s, String t) {
        int map[] = new int[26];

        int l1 = s.length();
        int l2 = t.length();

        if(l1 != l2){
            return false;
        }

        for(char c : s.toCharArray()){
            map[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            map[c - 'a']--;
        }

        for(int i : map){
            if(i != 0){
                return false;
            }
        }
        return true;
    }

// another
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for(int i : map.values()){
            if(i != 0){
                return false;
            }
        }

        return true;
    }

// another
    public boolean isAnagram(String s, String t) {
        char[] chrS = s.toCharArray();
        char[] chrT = t.toCharArray();

        Arrays.sort(chrS); 
        Arrays.sort(chrT);

        return Arrays.equals(chrS, chrT); 
    }
