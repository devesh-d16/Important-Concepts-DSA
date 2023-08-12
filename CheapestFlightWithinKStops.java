// There are n cities connected by some number of flights. 
// You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that 
// there is a flight from city fromi to city toi with cost pricei.
// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. 
// If there is no such route, return -1.

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Info{
    int first;
    int second;
    int third;

    public Info(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for(int i = 0; i < m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Info> q = new LinkedList<>();
        // (steps, (node, distance))

        q.add(new Info(0, src, 0));

        int dist[] = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = (int)1e9;
        }
        dist[src] = 0;

        while(!q.isEmpty()){
            Info it = q.peek();
            q.remove();

            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if(stops > k){
                continue;
            }

            for(Pair p : adj.get(node)){
                int adjNode = p.first;
                int eWt = p.second;

                if(cost + eWt < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + eWt;
                    q.add(new Info(stops + 1, adjNode, cost + eWt));
                }
            }
        }

        if(dist[dst] == (int)1e9){
            return -1;
        }
        return dist[dst];
    }
}
