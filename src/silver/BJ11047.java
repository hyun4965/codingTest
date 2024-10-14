package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BJ11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //동전종류 갯수 입력
        int N = sc.nextInt();
        //금액 입력
        int K = sc.nextInt();
        //동전 type 입력
        int[] arr= new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        //정렬
        Arrays.sort(arr);
        //결과
        int result = 0;
        //역순으로 나누기
        for(int j=arr.length-1; j>=0; j--) {
            if(K/arr[j] !=0){
                result += K/arr[j];
                K%=arr[j];

            }
        }
        //결과 출력
        System.out.println(result);
    }
}
