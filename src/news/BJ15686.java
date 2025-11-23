package news;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ15686 {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] city;
    static List<Point> houseList = new ArrayList<>();
    static List<Point> chickenList = new ArrayList<>();
    static boolean[] open;
    static int minCityChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        city = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                city[i][j] = sc.nextInt();
                if (city[i][j] == 1) {
                    houseList.add(new Point(i, j));
                } else if (city[i][j] == 2) {
                    chickenList.add(new Point(i, j));
                }
            }
        }

        open = new boolean[chickenList.size()];
        dfs(0, 0);

        System.out.println(minCityChickenDistance);
    }

    static void dfs(int start, int count) {
        if (count == m) {
            calculateDistance();
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            open[i] = true;
            dfs(i + 1, count + 1);
            open[i] = false;
        }
    }

    static void calculateDistance() {
        int totalDistance = 0;

        for (Point h : houseList) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < chickenList.size(); i++) {
                if (open[i]) {
                    Point c = chickenList.get(i);
                    int dist = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);

                    min = Math.min(min, dist);
                }
            }
            totalDistance += min;
        }

        minCityChickenDistance = Math.min(minCityChickenDistance, totalDistance);
    }
}