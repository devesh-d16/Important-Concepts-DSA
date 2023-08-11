// You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, 
// where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), 
// and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). 
// You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
// A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
// Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

class Info{
    int distance;
    int row;
    int col;

    public Info(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Info> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int dist[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)1e9;
            }
        }

        dist[0][0] = 0;
        pq.add(new Info(0, 0, 0));

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        // ElogV
        // n * m * 4 * log(n * m)

        while(pq.size() != 0){
            Info it = pq.peek();
            pq.remove();

            int diff = it.distance;
            int row = it.row;
            int col = it.col;

            if(row == n - 1 && col == m - 1){
                return diff;
            }

            for(int i = 0; i < 4; i++){
                int nRow = row + dr[i];
                int nCol = col + dc[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int newEffort = Math.max(Math.abs(heights[nRow][nCol] - heights[row][col]), diff);
                    if(newEffort < dist[nRow][nCol]){
                        dist[nRow][nCol] = newEffort;
                        pq.add(new Info(newEffort, nRow, nCol));
                    }
                }
            }
        }
        return 0;
    }
}
