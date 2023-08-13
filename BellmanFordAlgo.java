// here we will relax the edge V - 1 times sequentially
// to detect the negative cycle we will relax the edge once more and if the dist array changes then there is negative cycle
// and we will return -1

class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int dist[] = new int[V];
        for(int i = 0; i < V; i++){
            dist[i] = (int)1e8;
        }
        dist[S] = 0;
        
        // V x E
        for(int i = 0; i < V - 1; i++){
            for(ArrayList<Integer> it : edges){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        // to detect negative cycle
        for(ArrayList<Integer> it : edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        
        return dist;
    }
}
