package bronze;

import java.util.Scanner;

public class FourNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 네 개의 숫자 입력 받기
        String A = sc.next();
        String B = sc.next();
        String C = sc.next();
        String D = sc.next();

        // A와 B를 붙인 수, C와 D를 붙인 수를 각각 문자열로 처리한 후, 숫자로 변환
        long num1 = Long.parseLong(A + B);
        long num2 = Long.parseLong(C + D);

        // 두 수의 합을 출력
        System.out.println(num1 + num2);
    }
}
