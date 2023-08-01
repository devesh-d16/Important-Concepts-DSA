// Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). 
// Find the number of islands.
// Note: An island is either surrounded by water or boundary of grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., 
// in all 8 directions.
  
// Input:
// grid = {{0,1},{1,0},{1,1},{1,0}}
// Output:
// 1
// Explanation:
// The grid is-
// 0 1
// 1 0
// 1 1
// 1 0
// All lands are connected.

// pair class to store (row and col) of the matrix
public class Pair{
    int first;
    int second;
    public Pair(int first, int second){
      this.first = first;
      this.second = second;
    }
}
    // Function to find the number of islands.
public int numIslands(char[][] grid) {
  int n = grid.length;
  int m = grid[0].length;
  int vis[][] = new int[n][m]; // to mark the visit
        
  int count = 0; // for counting the island
  for(int i = 0; i < n; i++){
    for(int j = 0; j < m; j++){
      // this will traverse all the islands
      if(vis[i][j] == 0 && grid[i][j] == '1'){
        count++;
        bfs(i, j, vis, grid);
      }
    }
  }
  return count;
}
    
    public void bfs(int row, int col, int vis[][], char grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

          // since a cell can have neighbour in 8 direction
          // so we will run two loo from -1 to +1
          // which will cover all the direction
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    int nrow = r + i;
                    int ncol = c + j;
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
