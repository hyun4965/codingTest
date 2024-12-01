package bronze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ25629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 홀수와 짝수를 분리
        ArrayList<Integer> oddList = new ArrayList<>();
        ArrayList<Integer> evenList = new ArrayList<>();

        for (int num : arr) {
            if (num % 2 == 1) {
                oddList.add(num);
            } else {
                evenList.add(num);
            }
        }

        Collections.sort(oddList);
        Collections.sort(evenList);

        if (validateSequence(N, oddList, evenList)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean validateSequence(int N, ArrayList<Integer> oddList, ArrayList<Integer> evenList) {
        int oddIndex = 0, evenIndex = 0;

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) { // 홀수 인덱스
                if (oddIndex >= oddList.size()) return false; // 홀수가 부족하면 실패
                oddIndex++; // 다음 홀수로 이동
            } else { // 짝수 인덱스
                if (evenIndex >= evenList.size()) return false; // 짝수가 부족하면 실패
                evenIndex++; // 다음 짝수로 이동
            }
        }

        return true;
    }
}
