// Given two sorted arrays nums1 and nums2 of size m and n respectively, 
// return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).

// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// TC - O(log(m + n)
// SC - O(1)


    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
      // binary search to happen in the smaller array
        if(m > n){
            return findMedianSortedArrays(arr2, arr1);
        }
      
        int low = 0;
        int high = m;
      // median position ==> if even then the first element of the median
      // if even => then the median element
        int medianPosition = ((m + n) + 1)/2;

      // in this basically humlog array 1 ko divide krenge and jo left ke element hai unko ek group me rkhenge and right ke alg group me
      // the jo second array hai usme se median position se phle aane wale elements ko lenge left me ...otherwise right me lenge
      // we will get to know if the group we have divided is correct or not...only when like na left part of array 1 <= right part of array 2
      // and also left part of array 2 <= right part of array 1 
      // if both the conditions satisfied we will take the max of left part and min of right part and find the median
        while(low <= high){
            int c1 = (low + high)/2;
            int c2 = medianPosition - c1;

            int l1 = (c1 == 0) ? Integer.MIN_VALUE : arr1[c1 - 1];
            int l2 = (c2 == 0) ? Integer.MIN_VALUE : arr2[c2 - 1];
            int r1 = (c1 == m) ? Integer.MAX_VALUE : arr1[c1];
            int r2 = (c2 == n) ? Integer.MAX_VALUE : arr2[c2];

            if(l1 <= r2 && l2 <= r1){
                if((m + n)%2 != 0){
                    return Math.max(l1, l2);
                }
                else{
                    return (Math.min(r1,r2) + Math.max(l1, l2))/2.0;
                }
            }
            else if(l1 > r2){
                high = c1 - 1;
            }
            else{
                low = c1 + 1;
            }
        }
        return 0.0;
    }
