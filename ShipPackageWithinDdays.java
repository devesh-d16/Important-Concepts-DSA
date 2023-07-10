// A conveyor belt has packages that must be shipped from one port to another within days days.
// The ith package on the conveyor belt has a weight of weights[i]. 
// Each day, we load the ship with packages on the conveyor belt (in the order given by weights). 
// We may not load more weight than the maximum weight capacity of the ship.
// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.


// TC - O(N * log(totSum - max(weight[i))))
// SC - O(1)


    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int totWeight = 0;
        int maxWeight = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            totWeight += weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }

      // we will start the loop from max weight till the total weight 
        int left = maxWeight;
        int right = totWeight;

        while(left <= right){
            int mid = (left + right)/2;
          // calculate the no of days required when the maximum load that can be shipped 
          // in 1 day == mid
            int d = daysReq(weights, mid);

            if(d <= days){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return left;
    }

    public int daysReq(int weight[], int mid){
        int day = 1;
        int sum = 0;
        int n = weight.length;

        for(int i = 0; i < n; i++){
            if(weight[i] + sum > mid){
                sum = weight[i];
                day++;
            }
            else{
                sum += weight[i];
            }
        }
        return day;
    }
