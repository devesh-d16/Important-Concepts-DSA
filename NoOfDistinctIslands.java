// Given a boolean 2D matrix grid of size n * m. 
// You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. 
// Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).
  
// Input:
// grid[][] = {{1, 1, 0, 1, 1},
//             {1, 0, 0, 0, 0},
//             {0, 0, 0, 0, 1},
//             {1, 1, 0, 1, 1}}
// Output:
// 3
// Explanation:
// grid[][] = {{1, 1, 0, 1, 1}, 
//             {1, 0, 0, 0, 0}, 
//             {0, 0, 0, 0, 1}, 
//             {1, 1, 0, 1, 1}}
// Same colored islands are equal.
// We have 4 islands, but 2 of them
// are equal, So we have 3 distinct islands.

  public class Pair{
        int first;
        int second;
        
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    public int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int vis[][] = new int[m][n];
        HashSet<ArrayList<String>> st = new HashSet<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> ans = new ArrayList<>();
                    dfs(i, j, vis, grid, ans, i, j);
                    st.add(ans);
                }
            }
        }
        
        return st.size();
    }
    
    public void dfs(int row, int col, int vis[][], int grid[][], ArrayList<String> ans, int row0, int col0){
        vis[row][col] = 1;
        ans.add(toString(row - row0, col - col0));
        
        int m = grid.length;
        int n = grid[0].length;
        
        int di[] = {-1, 0, +1, 0};
        int dj[] = {0, -1, 0, +1};
        
        for(int i = 0; i < 4; i++){
            int nrow = row + di[i];
            int ncol = col + dj[i];
            
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, vis, grid, ans, row0, col0);
            }
        }
    }
    
    public String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
