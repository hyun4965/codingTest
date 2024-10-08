package bronze;

import java.util.Scanner;

public class BJ2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        //숫자 입력받기.
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }
        // 순서대로 올라가면 ascending
        // 순서대로 내림차순이면 descending
        // 두개가 해당이 되지 않는다면 mixed
        // ascending, descending 여부를 체크할 플래그
        boolean isAscending = true;
        boolean isDescending = true;

        // 배열의 연속된 원소들 간 비교
        for (int i = 0; i < 7; i++) {
            if (arr[i] < arr[i + 1]) {
                isDescending = false;  // 내림차순이 아니면 false로 설정
            } else if (arr[i] > arr[i + 1]) {
                isAscending = false;  // 오름차순이 아니면 false로 설정
            }
        }

        // 결과 출력
        if (isAscending) {
            System.out.println("ascending");
        } else if (isDescending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
