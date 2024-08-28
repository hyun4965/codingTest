package silver;

import java.util.Scanner;

public class ArrayString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //N,M입력받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        //각 배열에 String 값 입력받기
        String[] arr1 = new String[N];
        String[] arr2 = new String[M];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.next();
        }
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.next();
        }

        int count = 0;

        //동등성 비교 연산자를 통해 비교
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr1[i].equals(arr2[j])) {
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
}
