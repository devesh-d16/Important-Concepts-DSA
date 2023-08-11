
class Info{
    int first; // distance
    int second; // row
    int third; // col

    public Info(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
      // unreachable 
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1){
            return -1;
        }
        if(n == 1 && grid[0][0] == 0){
            return 1;
        }

        int dist[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = (int)1e9;
            }
        }
        dist[0][0] = 0;
        
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(1, 0, 0));
// dijkshtra algo
        while(!q.isEmpty()){
            Info in = q.peek();
            q.remove();

            int dis = in.first;
            int row = in.second;
            int col = in.third;

            int[][] directions = {{-1,-1}, {0,-1}, {1,-1},{1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}};

            for(int i = 0; i < 8; i++){
                int nRow = row + directions[i][0];
                int nCol = col + directions[i][1];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && grid[nRow][nCol] == 0 && dis + 1 < dist[nRow][nCol]){
                    dist[nRow][nCol] = 1 + dis;
                    if(nRow == n - 1 && nCol == n - 1){
                        return dis + 1;
                    }
                    q.add(new Info(1 + dis, nRow, nCol));
                }
            }
        }

        return -1;
    }
}
