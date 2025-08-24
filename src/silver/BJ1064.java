package silver;

import java.io.*;
import java.util.*;

public class BJ1064 {
    static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }

    static double dist(Point p, Point q) {
        long dx = p.x - q.x;
        long dy = p.y - q.y;
        return Math.hypot(dx, dy);
    }

    static boolean collinear(Point a, Point b, Point c) {
        // 면적의 2배(외적) == 0 이면 일직선
        long x1 = b.x - a.x, y1 = b.y - a.y;
        long x2 = c.x - a.x, y2 = c.y - a.y;
        long cross = x1 * y2 - y1 * x2;
        return cross == 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point A = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point B = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point C = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        if (collinear(A, B, C)) {
            System.out.println("-1.0");
            return;
        }

        double AB = dist(A, B);
        double AC = dist(A, C);
        double BC = dist(B, C);

        double p1 = 2.0 * (AB + AC); // A를 공통 정점으로
        double p2 = 2.0 * (AB + BC); // B를 공통 정점으로
        double p3 = 2.0 * (AC + BC); // C를 공통 정점으로

        double maxP = Math.max(p1, Math.max(p2, p3));
        double minP = Math.min(p1, Math.min(p2, p3));

        double ans = maxP - minP;
        // 문제는 절대/상대 오차 1e-9 허용이므로 기본 출력으로 충분
        System.out.println(ans);
    }
}
