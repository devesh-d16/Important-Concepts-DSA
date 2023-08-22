// Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. 
// (Running, Fighting Practice or Learning New Moves). 
// Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. 
// Can you help Ninja find out the maximum merit points Ninja can earn?
// You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. 
// Your task is to calculate the maximum number of merit points that Ninja can earn.
// For Example
// If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.

// Recursion
// TC - 
// SC - O(N)
public static int ninjaTraining(int n, int points[][]) {
    return nt(n - 1, 3, points);
}

public static int nt(int idx, int last, int points[][]){
    if(idx == 0){
        int maxm = 0;
        for(int i = 0; i < 3; i++){
            if(i != last){
                maxm = Math.max(maxm, points[idx][i]);
            }
        }
        return maxm;
    }

    int maxm = 0;
    for(int i = 0; i < 3; i++){
        if(i != last){
            int pts = points[idx][i] + nt(idx - 1, i, points);
            maxm = Math.max(maxm, pts);
        }
    }

    return maxm;
}

// Memoization
// TC - O((N * 4) * 3)
// SC - O(N) + O(N * 4)
public static int ninjaTraining(int n, int points[][]) {
    int dp[][] = new int[n][4];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }
    return nt(n - 1, 3, points, dp);
}

public static int nt(int idx, int last, int points[][], int dp[][]){
    if(idx == 0){
        int maxm = 0;
        for(int i = 0; i < 3; i++){
            if(i != last){
                maxm = Math.max(maxm, points[idx][i]);
            }
        }
        return maxm;
    }

    if(dp[idx][last] != -1){
        return dp[idx][last];
    }

    int maxm = 0;
    for(int i = 0; i < 3; i++){
        if(i != last){
            int pts = points[idx][i] + nt(idx - 1, i, points, dp);
            maxm = Math.max(maxm, pts);
        }
    }
  
    return dp[idx][last] = maxm;
}

// Tabulation
// TC - O((N * 4) * 3)
// SC - O(N * 4)
public static int ninjaTraining(int n, int points[][]) {
    int dp[][] = new int[n][4];
    dp[0][0] = Math.max(points[0][1], points[0][2]);
    dp[0][1] = Math.max(points[0][0], points[0][2]);
    dp[0][2] = Math.max(points[0][0], points[0][1]);
    dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

    for(int day = 1; day < n; day++){
        for(int last = 0; last < 4; last++){
            dp[day][last] = 0;
            for(int task = 0; task < 3; task++){
                if(task != last){
                    int pts = points[day][task] + dp[day - 1][task];
                    dp[day][last] = Math.max(dp[day][last], pts);
                }
            }
        }
    }

    return dp[n - 1][3];
}

// Space Optimization
// TC - O((N * 4) * 3)
// SC - O(4)

public static int ninjaTraining(int n, int points[][]) {
    int prev[] = new int[4];
    prev[0] = Math.max(points[0][1], points[0][2]);
    prev[1] = Math.max(points[0][0], points[0][2]);
    prev[2] = Math.max(points[0][0], points[0][1]);
    prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

    for(int day = 1; day < n; day++){
        int curr[] = new int[4];
        for(int last = 0; last < 4; last++){
            curr[last] = 0;
            for(int task = 0; task < 3; task++){
                if(task != last){
                    int pts = points[day][task] + prev[task];
                    curr[last] = Math.max(curr[last], pts);
                }
            }
        }
        prev = curr;
    }

    return prev[3];
}
