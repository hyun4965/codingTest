package bronze;


import java.util.Scanner;

public class BJ8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 수 입력
        int n = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리

        // 각 테스트 케이스에 대해 점수 계산
        for (int i = 0; i < n; i++) {
            String result = sc.nextLine();  // 각 테스트 케이스의 문자열 입력
            int score = 0;  // 총 점수
            int go = 0;  // 연속된 O의 개수

            // 문자열 순회
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == 'O') {
                    go++;  // O가 나오면 연속된 O 개수 증가
                    score += go;  // 그만큼 점수를 누적
                } else {
                    go = 0;  // X가 나오면 연속된 O 개수 초기화
                }
            }

            // 각 테스트 케이스의 점수를 출력
            System.out.println(score);
        }

        sc.close();
    }
}
