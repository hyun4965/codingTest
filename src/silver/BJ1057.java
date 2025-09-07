package silver;

import java.util.Scanner;

public class BJ1057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //참가자 수
        int a = sc.nextInt(); //김지민 번호
        int b = sc.nextInt(); //성한수 번호

        int round = 0;

        while( a != b){
            a = (a+1)/2 ;
            b = (b+1)/2;
            round++;
        }
        System.out.println(round);

    }
}
