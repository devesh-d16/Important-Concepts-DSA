
class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
  // TC - m(log(n))
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
      
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);
        int dist[] = new int[n + 1];
        int parent[] = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            dist[i] = (int)1e9;
            parent[i] = i;
        }
        
        dist[1] = 0;
        pq.add(new Pair(0, 1));
        
        while(pq.size() != 0){
            Pair it = pq.peek();
            int node = it.second;
            int dis = it.first;
            pq.remove();
            
            for(Pair i : adj.get(node)){
                int adjNode = i.first;
                int eWt = i.second;
                
                if(dis + eWt < dist[adjNode]){
                    dist[adjNode] = dis + eWt;
                    pq.add(new Pair(dis + eWt, adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        if(dist[n] == (int)(1e9)){
            path.add(-1);
            return path;
        }
        
        int node = n;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        
        return path;
    }
}
