package silver;

import java.util.Scanner;

public class BJ9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //테스트수 입력
        int[] pado = new int[101]; //n이 1까지므로.

        pado[1] = 1;
        pado[2] = 1;
        pado[3] = 1;

        for(int i=4; i<101; i++){
            pado[i] = pado[i-2] + pado[i-3];
        }

        for(int i=0; i<T; i++) {
            int N = sc.nextInt();
            System.out.println(pado[N]);
        }
        sc.close();
    }
}
