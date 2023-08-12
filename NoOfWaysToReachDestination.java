// You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. 
// The inputs are generated such that you can reach any intersection from any other intersection and 
// that there is at most one road between any two intersections.
// You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means 
// that there is a road between intersections ui and vi that takes timei minutes to travel. 
// You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
// Return the number of ways you can arrive at your destination in the shortest amount of time. 
// Since the answer may be large, return it modulo 109 + 7.

class Solution {

    int Mod = 1000000007;

    public int countPaths(int n, int roads[][]) {
      // make a graph
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = roads.length;
        for(int i = 0; i < m; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        int[] ways = new int[n]; // to store no of ways to reach the particular node
        long[] dist = new long[n]; // to store the minimum distance to reach a particular node
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey().compareTo(b.getKey()));
        dist[0] = 0; 
        pq.offer(new Pair<>(0L, 0));

        ways[0] = 1;

        // ElogV
        while (!pq.isEmpty()) {
            Pair<Long, Integer> pair = pq.poll();
            long weight = pair.getKey(); 
            int node = pair.getValue();

            if (dist[node] < weight) {
                continue;
            }

            for (Pair<Integer, Integer> adjPair : adj.get(node)) {
                int adjNode = adjPair.getKey();
                int adjWeight = adjPair.getValue();

                if (adjWeight + weight < dist[adjNode]) {
                    dist[adjNode] = adjWeight + weight;
                    ways[adjNode] = ways[node];
                    pq.offer(new Pair<>(dist[adjNode], adjNode));
                } else if (adjWeight + weight == dist[adjNode]) {
                    ways[adjNode] = (ways[node] + ways[adjNode]) % Mod;
                }
            }
        }
        return ways[n - 1];
    }
}
