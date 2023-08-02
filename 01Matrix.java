
// Given an m x n binary matrix mat, 
// return the distance of the nearest 0 for each cell.
// The distance between two adjacent cells is 1.

  public class Pair{
        int first;
        int second;
        int third;

        public Pair(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int ans[][] = new int[m][n];
        boolean vis[][] = new boolean[m][n];
      
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
                else{
                    vis[i][j] = false;
                }
            }
        }

        int di[] = {-1, 0, +1, 0};
        int dj[] = {0, +1, 0, -1};

        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            int steps = q.peek().third;
            q.remove();

            ans[r][c] = steps;

            for(int i = 0; i < 4; i++){
                int nrow = r + di[i];
                int ncol = c + dj[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == false){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol, steps + 1));
                } 
            }
        }
        return ans; 
    }
