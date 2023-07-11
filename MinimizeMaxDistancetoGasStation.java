// We have an horizontal number line. O
// n that number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], 
// where N = size of the stations array. Now, we add K more gas stations so that D,
// the maximum distance between adjacent gas stations, is minimized. 
// We have to find the smallest possible value of D. Find the answer exactly to 2 decimal places.

    public static double findSmallestMaxDist(int stations[],int K) {
        int n = stations.length;
        int count;
        double left = 0;
        double right = stations[n - 1] - stations[0];

      
        while(left + 1e-6 < right){
            double mid = (left + right)/2;
          // we will count li kitne gas staions ke bich me "mid" se jyda distance hai 
            count = 0;
            for(int i = 0; i < n - 1; i++){
                count += Math.ceil((stations[i + 1] - stations[i])/mid) - 1;
            }
          // if count => K (stations need to be installed) se jyda hua toh 
          // we will find bigger difference wale stations so that ki jo max dist ho uske bich insert kre and max dist kam hojaye
            if(count > K){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return right;
    }
