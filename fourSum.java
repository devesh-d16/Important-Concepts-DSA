
// TC - O(N^3)
// SC - O(1)

// same as 3sum but in this we will fix two elements and 
// then apply two pointers

public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){

          // to avoid duplicate
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            for(int j = i + 1; j < n; j++){
          // to avoid duplicate
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                int p = j + 1;
                int q = n - 1;

                while(p < q){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[p];
                    sum += nums[q];

                    if(sum == target){
                        List<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[p]);
                        a.add(nums[q]);
                        ans.add(a);
                        p++;
                        q--;

                        while(p < q && nums[p] == nums[p - 1]){
                            p++;
                        }
                        while(p < q && nums[q] == nums[q + 1]){
                            q--;
                        }
                    }
                    else if(sum < target){
                        p++;
                    }
                    else {
                        q--;
                    }
                }
            }
        }
        return ans;
    }
