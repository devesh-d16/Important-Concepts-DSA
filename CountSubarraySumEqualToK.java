// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
      // we will put 0 as sum too first as to count the middle elemnt subarray too which will be counted from rem
        map.put(0,1);
        for(int i = 0; i < n; i++){
            sum += nums[i];

            // calculate the remaining subarray
            int rem = sum - k;

            //add the number of subarray to be removed
            count += map.getOrDefault(rem,0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
