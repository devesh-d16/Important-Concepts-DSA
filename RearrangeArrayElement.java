// You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
// You should rearrange the elements of nums such that the modified array follows the given conditions:
// Every consecutive pair of integers have opposite signs.
// For all integers with the same sign, the order in which they were present in nums is preserved.
// The rearranged array begins with a positive integer.
// Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int j = 0;
        int k = 0;
        int pos[] = new int[n/2];
        int neg[] = new int[n/2];
        for(int i = 0;i < n; i++){
            if(nums[i] > 0){
                pos[j++] = nums[i];
            }else{
                neg[k++] = nums[i];
            }
        }
        j = 0;
        k = 0;
        for(int i = 0; i <  n; i++){
            if(i%2 == 0){
                nums[i] = pos[j++];
            }
            else{
                nums[i] = neg[k++];
            }
        }

        return nums;
    }

// TC - O(N)
// SC - O(N)

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int pos = 0;
        int neg = 1;

        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                ans[neg] = nums[i];
                neg = neg + 2;
            }
            else{
                ans[pos] = nums[i];
                pos += 2;
            }
        }

        return ans;
    }
