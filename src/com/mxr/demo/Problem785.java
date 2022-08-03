package com.mxr.demo;

import java.util.*;

public class Problem785 {
    private static class Edge {
        public final int p0;
        public final int p1;

        public Edge(int p0, int p1) {
            this.p0 = p0;
            this.p1 = p1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return (p0 == edge.p0 && p1 == edge.p1) || (p0 == edge.p1 && p1 == edge.p0);
        }

        @Override
        public int hashCode() {
            return Objects.hash(p0, p1);
        }
    }

    public boolean isBipartite(int[][] graph) {
        List<Edge> edges = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                Edge edge = new Edge(i, graph[i][j]);
                if (!edges.contains(edge)) {
                    edges.add(edge);
                }
            }
            cnt += graph[i].length == 0 ? 0 : 1;
        }
        return isBipartite(edges, 0, new HashSet<>(), new HashSet<>(), cnt);
    }

    private boolean isBipartite(List<Edge> edges, int from, Set<Integer> setA, Set<Integer> setB, int cnt) {
        if (from == edges.size()) {
            return (setA.size() + setB.size()) == cnt;
        }
        int p1 = edges.get(from).p0;
        int p2 = edges.get(from).p1;
        if (setA.contains(p1) && setA.contains(p2)) {
            return false;
        } else if (setB.contains(p1) && setB.contains(p2)) {
            return false;
        } else if (setA.contains(p1)) {
            setB.add(p2);
            boolean result = isBipartite(edges, from + 1, setA, setB, cnt);
            if (result) {
                return true;
            } else {
                setB.remove(p2);
                return false;
            }
        } else if (setA.contains(p2)) {
            setB.add(p1);
            boolean result = isBipartite(edges, from + 1, setA, setB, cnt);
            if (result) {
                return true;
            } else {
                setB.remove(p1);
                return false;
            }
        } else if (setB.contains(p1)) {
            setA.add(p2);
            boolean result = isBipartite(edges, from + 1, setA, setB, cnt);
            if (result) {
                return true;
            } else {
                setA.remove(p2);
                return false;
            }
        } else if (setB.contains(p2)) {
            setA.add(p1);
            boolean result = isBipartite(edges, from + 1, setA, setB, cnt);
            if (result) {
                return true;
            } else {
                setA.remove(p1);
                return false;
            }
        }
        setA.add(p1);
        setB.add(p2);
        if (isBipartite(edges, from + 1, setA, setB, cnt)) {
            return true;
        }
        setA.remove(p1);
        setB.remove(p2);

        setA.add(p2);
        setB.add(p1);
        if (isBipartite(edges, from + 1, setA, setB, cnt)) {
            return true;
        }
        setA.remove(p2);
        setB.remove(p1);
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {4},
                {},
                {4},
                {4},
                {0, 2, 3}
        };
        System.out.println((new Problem785()).isBipartite(graph));
    }
}
