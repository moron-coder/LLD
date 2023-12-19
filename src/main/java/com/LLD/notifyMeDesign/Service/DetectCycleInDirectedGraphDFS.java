package com.LLD.notifyMeDesign.Service;

import java.util.ArrayList;

public class DetectCycleInDirectedGraphDFS {
    public static void main(String[] args) {

    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];

        for (int i = 0; i < V; ++i) {
            boolean ans = dfs(i, adj, visited, path);
            if (ans) return ans;
        }
        return false;
    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] path) {
        visited[node] = true;
        path[node] = true;

        ArrayList<Integer> neighbour = adj.get(node);
        for (int i = 0; i < neighbour.size(); ++i) {
            if (!visited[neighbour.get(i)]) {
                boolean ans = dfs(neighbour.get(i), adj, visited, path);
                if (ans) return ans;
                //path[neighbour.get(i)] = false;
            } else {
                if (path[neighbour.get(i)])
                    return true;
            }

        }
        path[node] = false;
        return false;
    }
}