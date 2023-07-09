// You are given an integer array bloomDay, an integer m and an integer k.
// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

// TC - O(N*log(max[arr[i]] - min[arr[i]] + 1))
// SC - O(1)
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
      // if jitne flowers hai usse jyda chiyee bouquet bnane ke liye
      // return -1
        long v = (long)m * k;
        if(v > n){
            return -1;
        }

        int maxm = Integer.MIN_VALUE;
        int minm = Integer.MAX_VALUE;

      // to find the min => first flower khilne me kitna din
      // to find the max => last flower khilne me kitna din
        for(int i = 0; i < n; i++){
            maxm = Math.max(bloomDay[i],maxm);
            minm = Math.min(bloomDay[i],minm);
        }

        int left = minm;
        int right = maxm;

        while(left <= right){
            int mid = (left + right)/2;
// we will find mid => agar mid days tk saare bouquet bn gye toh left part/kam din me bn skte kya aisa check krenge
          // ni toh usse jyda din me bn rhe toh kitne kam din me bn jaye usko check krenge
            if(rD(bloomDay,m,k,mid)){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean rD(int blmDay[], int m, int k, int days){
        int n = blmDay.length;
        int flowers = 0;
        int count = 0;

        // count the number of bouquets
        for(int i = 0; i < n; i++){
            if(blmDay[i] <= days){
                count++;
            }
            else{
              // agar koi flower abi nhi grow hua hai toh usse phle jiyne bi flower ug gye hai
              // unse kitne bouquet bne vo count krenge
              // and count ko zero krdenge
                flowers += (count/k);
                count = 0;
            }
        }
        flowers += (count / k);
        return flowers >= m;
    }
