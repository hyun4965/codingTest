import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력: 점의 개수
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];

        // 입력: 점의 좌표
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // Shoelace 공식 계산
        double area = 0.0;
        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N; // 마지막 점 다음에는 첫 번째 점으로 돌아감
            area += (x[i] * y[next]) - (y[i] * x[next]);
        }

        area = Math.abs(area) / 2.0;

        // 결과 출력: 소수점 첫째 자리까지 반올림
        System.out.printf("%.1f\n", area);
    }
}
