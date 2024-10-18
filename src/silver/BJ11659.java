package silver;

import java.util.Scanner;

public class BJ11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n입력
        int m = sc.nextInt(); //m 입력
        int[] n_arr = new int[n+1]; //n arr 생성
        n_arr[0] = 0;
        //arr 입력받기
//        for(int i=1;i<=n;i++){
//            n_arr[i] = sc.nextInt();
//        }
        //누적 합으로 배열 다시 생성.
        for(int i = 0; i < n; i++){
            n_arr[i+1] = n_arr[i] + sc.nextInt();
        }
        //연산
        for(int i=0;i<m;i++){
//            int count =0;
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(n_arr[end]-n_arr[start-1]);
//            for(int j=start;j<=end;j++){
//                count += n_arr[j];
//            }
//            System.out.println(count);
        }
    }
}
