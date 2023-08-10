// this algo is not valid for negative edge weights
// as if we have negative edge it will lead the loop to stuck in a infinte loop
// because whenever it traverse back from the same root it's distance will decrease

// using priority queue 
// TC - E(log(E)) 
class Pair{
    int node;
    int distance;
    public Pair(int distance,int node){
        this.node = node;
        this.distance = distance;
    }
}
class Solution{
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        
        int dist[] = new int[V];
        for(int i = 0; i < V; i++){
            dist[i] = (int)(1e9);
        }
        dist[S] = 0;
        
        pq.add(new Pair(0, S));
        
        
        while(pq.size() != 0){
            int node = pq.peek().node;
            int dis = pq.peek().distance;
            pq.remove();
            
            for(int i = 0; i < adj.get(node).size(); i++){
                int edgeWt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                
                if(dis + edgeWt < dist[adjNode]){
                    dist[adjNode] = dis + edgeWt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        
        return dist;
    }
}
