// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.


// TC - O(N*logN)
// SC - O(1)

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || nums == null){
            return 0;
        }

      // sort the array
        Arrays.sort(nums);
        int ans = 1; // initially consecutive element count should be 1
        int prev = nums[0]; 
        int cur = 1;

        for(int i = 1; i < nums.length; i++){
          // agar hume difference 1 milega toh count ++ krenge 
            if(nums[i] == prev + 1){
                cur++;
            }
         // this is to pass the duplicate element 
         // as well as agar current element is not consecutive toh streak tod dena hai and back to 1 kr dena hai 
            else if(nums[i] != prev){
                cur = 1;
            }

            prev = nums[i];
            ans = Math.max(ans,cur);
        }
        return ans;
    }


// TC - O(n)
// SC - O(n)

    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();
      // we will put all elements in a set which will remove duplicate
        for(int i: nums){
            set.add(i);
        }

      
        int lStreak = 0;

        for(int m: nums){

          // ye if statement ka use hai like -- we are finding the FIRST element jahan se sequence start hua hai
            if(!set.contains(m - 1)){
              // first element milgya the current streak maintain krenge initialise krke 1 se
                int curr = m;
                int cStreak = 1;
              
              // jabtk diffrence elements jiske element se diffrence 1 rhega we will run the loop and check krenge
                while(set.contains(curr + 1)){
                    curr += 1; // next consecutive element me chle gye
                    cStreak += 1;
                }
              // max streak store krne ke liye
                lStreak = Math.max(lStreak,cStreak);
            }
        }

        return lStreak;
    }
