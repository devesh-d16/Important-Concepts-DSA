// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
// If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.

// TC - O(n)
// SC - O(1)
// brute force

    public int minEatingSpeed(int[] piles, int h) {
        int maxm = findMax(piles);
        
        for(int i = 1; i <= maxm; i++){
            int rT = calcTotHrs(piles,i);
          // we will check from 1 to maxElement 
          // when the rT is less than the given hours we will return it
            if(rT <= h){
                return i;
            }
        }
        return maxm;
    }

// This function will find the maximum element of
// the array
    public int findMax(int piles[]){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; i++){
            max = Math.max(max,piles[i]);
        }
        return max;
    }

// this function will find the total hours which will be needed
// if the number of bananas that can be eaten in an hour = "hourly"
    public int calcTotHrs(int piles[], int hourly){
        int totH = 0;
        int n = piles.length;

        for(int i = 0; i < n; i++){
            totH += Math.ceil((double)(piles[i])/(double)(hourly));
        }
        return totH;
    }

// TC - O(n*log(max[piles]))
// SC - O(1)
// Binary Search

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        if(n == h){
            return piles[n - 1]; 
        }

        int left = 1;
        int right = piles[n - 1];

        while(left <= right){
            int mid = (left + right)/2;

            int totalHours = rT(piles, n, mid);
            if(totalHours <= h){
                right = mid - 1;
            } 
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public int rT(int piles[], int n, int hourly){
        int totH = 0;

        for(int i = 0; i < n; i++){
            totH += Math.ceil((double)piles[i]/(double)hourly);
        }

        return totH;
    }
