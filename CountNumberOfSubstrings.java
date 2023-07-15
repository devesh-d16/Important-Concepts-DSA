// Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 

// TC - O(N)
// SC - O(1)

    long substrCount (String S, int K){
      // so basically humlog ye krre ki string se upto K distinct elements wale substring count krre 
      // and usse K - 1 tk wale substring ko minus krre so that exact K distinct character wale substrings mil jaye
        return getSub(S, K) - getSub(S, K - 1);
    }
    
    long getSub(String s,int k){
        int n = s.length();
        if(n == 0 || k == 0){
            return 0;
        }
        long num = 0;  // to store the ans
        int back = 0;  // ye make sure krega ki sir K se kam hi elements ho

      // this will store unique character and their counts
        HashMap<Character, Integer> map = new HashMap<>();
      
        for(int i = 0; i < n; i++){
          // phle jo cahracter hai usko store krenge
          // if already hai toh freq increase krenge
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

          // this loop will make sure ki max unique elements k hi ho
          // usse jyda hoga toh remove that element and subtract it from count
            while(map.size() > k){
                map.put(s.charAt(back), map.getOrDefault(s.charAt(back), 0) - 1);
                if(map.get(s.charAt(back)) == 0){
                    map.remove(s.charAt(back));
                }
                back++;
            }
            num += i - back + 1;
        }
        return num;
    }
