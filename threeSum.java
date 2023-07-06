// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

// TC - O(N*N)
// SC - O(3*K)

public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // sorting the array so that we can use two pointer
        Arrays.sort(nums);
        int n = nums.length;

        // in this approach we will fix one element and apply the 2Sum using two pointers on the next element
        for(int i = 0; i < n - 2; i++){
          // nums[i] != nums[i - 1] => 
          // this will eliminate the duplicate first element of triplet
          // like why will you choose the same element again and try to find the solution
          // it will be poora worthless na
            if(i == 0 || nums[i] != nums[i - 1]){
                int left = i + 1;
                int right = n - 1;
                int sum = 0 - nums[i];

                while(left < right){
                  
                    if(nums[left] + nums[right] == sum){
                        List<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.add(nums[left]);
                        a.add(nums[right]);

                        ans.add(a);

                      // this is done to eliminate duplicate triplet like above
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }

                        left++;
                        right--;
                    }
                  
                    else if(nums[left] + nums[right] < sum){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
