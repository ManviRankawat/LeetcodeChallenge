class Solution {
    
    public int[] findRedundantConnection(int[][] edges) {
        int[] arr = new int[2];
        final DSU dsu = new DSU(edges.length);

        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            if (dsu.connected(edge[0], edge[1])){
                return edge;
            }
            dsu.union(edge[0],edge[1]);
        }
        return arr;
    }
}

public class DSU {
            private int[] parent;
            private int[] rank;

            public DSU(int n) {
                parent = new int[n+1];
                rank = new int[n+1];
                for (int i = 0; i < n; i++) {
                    parent[i] = i; // Initially, every element is its own parent
                    rank[i] = 0;   // Initial rank is 0
                }
            }

            // Find with Path Compression
            public int find(int i) {
                if (parent[i] == i) {
                    return i;
                }
                // Recursively find the root and make it the parent of i
                return parent[i] = find(parent[i]);
            }

            // Union by Rank
            public void union(int i, int j) {
                int rootI = find(i);
                int rootJ = find(j);

                if (rootI != rootJ) {
                    // Attach smaller rank tree under root of higher rank tree
                    if (rank[rootI] < rank[rootJ]) {
                        parent[rootI] = rootJ;
                    } else if (rank[rootI] > rank[rootJ]) {
                        parent[rootJ] = rootI;
                    } else {
                        parent[rootI] = rootJ;
                        rank[rootJ]++;
                    }
                }
            }

            // Check if two elements are in the same set
            public boolean connected(int i, int j) {
                return find(i) == find(j);
            }
        }