// Given a string s, partition s such that every substring of the partition is a 
// palindrome. Return all possible palindrome partitioning of s.

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]


public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> a = new ArrayList<>();
        palPart(0, s, ans, a);
        return ans;
    }

    public void palPart(int idx, String s, List<List<String>> ans, List<String> a){
      // we have to store the array when we have traversed the whole string
        if(idx == s.length()){
            ans.add(new ArrayList<>(a));
            return;
        }

        for(int i = idx; i < s.length(); i++){
            if(isPali(s, idx, i)){
                a.add(s.substring(idx, i + 1));
                palPart(i + 1, s, ans, a);
                a.remove(a.size() - 1);
            }
        }
    }

    public boolean isPali(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
