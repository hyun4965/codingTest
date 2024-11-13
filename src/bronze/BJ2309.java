package bronze;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;

        // 아홉 난쟁이 키 입력과 총합 계산
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        // 두 난쟁이 찾기
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    // 두 난쟁이를 0으로 설정하여 제외
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);
                    for (int k = 2; k < 9; k++) { //arr이 0이후꺼부터.
                        System.out.println(arr[k]);
                    }
                    return;
                }
            }
        }
    }
}
