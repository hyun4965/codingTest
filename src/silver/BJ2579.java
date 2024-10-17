package silver;

import java.util.Scanner;

public class BJ2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] stairs = new int[301];
        int[] score = new int[301];
        //입력
        for(int i=1;i<=n;i++){
            stairs[i]=sc.nextInt();
        }
        score[1] = stairs[1];
        if (n >= 2) {
            score[2] = stairs[1] + stairs[2];
        }
        if (n >= 3) {
            score[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
        }

        for(int i=4;i<=n;i++){
            score[i] = Math.max(score[i - 2] + stairs[i], score[i - 3] + stairs[i - 1] + stairs[i]);
        }
        System.out.println(score[n]);
    }
}
