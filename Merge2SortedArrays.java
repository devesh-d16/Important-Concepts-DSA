// merge two soted arrays without any extra space

// TC - O(n + m) + O(n + m)
//  SC - O(n + m)
// Brute force

public void merge(int[] nums1, int m, int[] nums2, int n) {

  // we have created an array of size m + n 
  // here we will compare the elements of two array and merge them accordingly in the third array
  int ans[] = new int[m + n];
  int i = 0, j = 0,k = 0;
  while(i < m && j < n){
    if(nums1[i] <= nums2[j]){
      ans[k] = nums1[i];
      i++;
      k++;
    }
    else{
      ans[k] = nums2[j];
      j++;
      k++;
    }
  }

  while(i < m){
      ans[k++] = nums1[i++];
  }
  while(j < n){
      ans[k++] = nums2[j++];
  }


  for(int t = 0; t < m + n; t++){
      nums1[t] = ans[t];
  }
}


// Optimal Approach
// TC -  O(min(n, m)) + O(n*logn) + O(m*logm)
// SC - O(1)


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;

        while(left >= 0 && right < n){
            if(nums1[left] > nums2[right]){
              // swap
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }

        Arrays.sort(nums1,0,m);
        Arrays.sort(nums2);

        for(int i = 0; i < n; i++){
            nums1[i + m] = nums2[i];
        }

    }
