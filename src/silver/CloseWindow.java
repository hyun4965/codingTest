package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CloseWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        boolean[] isPrime = new boolean[n + 1]; // 창문 상태를 나타내는 배열, n+1 크기로 초기화

        //전체 1로 초기화 . 이때 1은 true로, 0은 false로 할 것임.
        for (int i = 1; i <= n; i++) {
            isPrime[i] = false;
        }

        //i * i번째 0 -> 1 / 1 -> 0 변경
        for (int i = 1; i * i <= n; i++) {
            isPrime[i * i] = !isPrime[i * i];
        }

        // 열려 있는 창문의 수를 계산
        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(1+ " ");
            }else{
                System.out.print(0+ " ");
            }
        }
        System.out.println();
        System.out.println(count);
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int count =1;
//        int N = Integer.parseInt(br.readLine());
//
//        for(int i=2;i*i<=N;i++){
//            count++;
//        }
//        System.out.println(count);
//
//    }
//}
