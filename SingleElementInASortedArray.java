// You are given a sorted array consisting of only integers where every element appears exactly twice, 
// except for one element which appears exactly once.
// Return the single element that appears only once.
// Your solution must run in O(log n) time and O(1) space.

// TC - O(logn)
// SC - O(1)
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
      // if length is 1
        if(n == 1){
            return nums[0];
        }
      // if first element is single
        if(nums[0] != nums[1]){
            return nums[0];
        }
      // if last element is single
        if(nums[n - 1] != nums[n - 2]){
            return nums[n - 1];
        }
        
        int left = 1;
        int right = n - 2;

      
        while(left <= right){
            int mid = (left + right)/2;

          // if phle ka and baad ka element alg ho toh mid element return krna hai 
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }

          // if curr index odd hai and prev index element = curr index element 
          // or curr index even hai and curr index element = next index element 
          // toh iska mtlb phle jitne bi element hai sbke pair hai 
          // which means single element right half me hai
            if((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])){
                left = mid + 1;
            }
          // single element left half me hai
            else{
                right = mid - 1;
            }
        }

        return -1;
    }
