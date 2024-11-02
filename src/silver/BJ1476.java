package silver;

import java.util.Scanner;

public class BJ1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt(); // 지구를 나타내는 수
        int S = sc.nextInt(); // 태양을 나타내는 수
        int M = sc.nextInt(); // 달을 나타내는 수

        int year = 1; // 우리가 알고 있는 연도, 1부터 시작
        int e = 1, s = 1, m = 1; // 각각의 수를 1로 초기화

        while (true) {
            // E, S, M이 일치하면 해당 연도를 출력하고 종료
            if (e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }

            // 1년이 지날 때마다 연도를 1씩 증가하고 각 수를 범위에 맞게 증가
            year++;
            e = (e % 15) + 1; // 15를 넘으면 1로 초기화
            s = (s % 28) + 1; // 28을 넘으면 1로 초기화
            m = (m % 19) + 1; // 19를 넘으면 1로 초기화
        }
    }
}