// An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
// You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
// To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
// plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
// Return the modified image after performing the flood fill.

    public class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int vis[][] = new int[m][n];
        int c = image[sr][sc];
      // four directions
        int di[] = {-1, 0 , 0, 1};
        int dj[] = {0, -1, 1, 0};

        bfs(sr, sc, c, image, vis, color, di, dj);
        return image;
    }
    public void bfs(int sr, int sc, int co, int[][] image, int vis[][], int color, int di[], int dj[]){
        Queue<Pair> q = new LinkedList<>();
        vis[sr][sc] = 1;
        image[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;

        q.add(new Pair(sr, sc));

        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.poll();

            for(int i = 0; i < 4; i++){
                int nrow = r + di[i];
                int ncol = c + dj[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol]== co && vis[nrow][ncol] == 0 && image[nrow][ncol] != color){
                    vis[nrow][ncol] = 1;
                    image[nrow][ncol] = color;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
