package LeetCodeChallenge.JUNE2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC684 {
    //    Using disjoint sets and union time 0(n) space O(n)
    int[] parent;

    int findNode(int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    void union(int i, int j) {
        int iRoot = findNode(i);
        int jRoot = findNode(j);
        if (iRoot != jRoot) {
            parent[jRoot] = iRoot;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
        for (int edge[] : edges) {
            if (findNode(edge[0]) == findNode(edge[1])) return edge;
            union(edge[0], edge[1]);
        }
        return null;
    }

    //    Using dfs to find if visited or not time 0(n^2) space O(n)
    public int[] findRedundantConnectionDfs(int[][] edges) {
        int n = edges.length;
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int edge[] : edges) {
            if (dfsHelper(new HashSet<>(), map, edge[0], edge[1])) return edge;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return null;
    }

    public boolean dfsHelper(Set<Integer> visited, HashMap<Integer, Set<Integer>> map, int src, int target) {
        if (src == target) return true;
        visited.add(src);
        for (int node : map.get(src)) {
            if (!visited.contains(node)) {
                if (dfsHelper(visited, map, node, target)) return true;
            }
        }
        return false;
    }


}
