package silver;

import java.util.Scanner;

public class BJ16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        int count = 1;
        while (B > A) {
            if (B % 10 == 1) {
                B /= 10;
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                System.out.println(-1);
                return;
            }
            count++;
        }
        if(A==B){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }
}
