package silver;

import java.util.Scanner;

public class BJ1004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수

        while (T-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int n = sc.nextInt(); // 행성계 개수
            int count = 0;

            for (int i = 0; i < n; i++) {
                int cx = sc.nextInt();
                int cy = sc.nextInt();
                int r = sc.nextInt();

                boolean startInside = isInside(x1, y1, cx, cy, r);
                boolean endInside = isInside(x2, y2, cx, cy, r);

                // 하나만 포함되어 있다면 진입 또는 이탈이 필요함
                if (startInside ^ endInside) {
                    count++;
                }
            }

            System.out.println(count);
        }
        sc.close();
    }

    // 점 (x, y)가 원 (cx, cy, r) 안에 있는지 여부
    private static boolean isInside(int x, int y, int cx, int cy, int r) {
        int dx = x - cx;
        int dy = y - cy;
        return dx * dx + dy * dy < r * r;
    }
}
