package gold;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BJ4386 {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double cost;

        Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.cost, other.cost);
        }
    }

    static int[] parent;

    static int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    static boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            return true;
        }
        return false;
    }

    static double getDistance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 별의 개수

        Point[] stars = new Point[n];
        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            stars[i] = new Point(x, y);
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double cost = getDistance(stars[i], stars[j]);
                edges.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(edges);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        double totalCost = 0.0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                totalCost += edge.cost;
                edgeCount++;
            }

            if (edgeCount == n - 1) {
                break;
            }
        }

        System.out.printf("%.2f\n", totalCost);
    }
}