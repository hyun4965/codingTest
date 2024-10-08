package bronze;

import java.util.Scanner;

//Count Sort를 사용하여 풀었다.
public class BJ2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //A,B,C를 차례대로 입력받는다
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        //counting 할 수 있는 배열 생성
        int[] arr = new int[10];
        for (int i = 0; i <= 9; i++) {
            arr[i] = 0;
        }

        //곱을 num에 저장
        int num = A * B * C;

        //해당되는 값 하나씩 입력
        while (num > 0) {
            int temp = num % 10;
            arr[temp]++;
            num = num / 10;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }

    }
}
