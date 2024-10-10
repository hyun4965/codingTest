package bronze;

import java.util.Scanner;

public class BJ15829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String str = sc.next();

        // 해시 함수에 사용될 상수
        int r = 31;
        int M = 1234567891;

        long hashValue = 0;
        long pow = 1; // r^i 값을 계산하기 위한 변수

        // 문자열의 각 문자에 대해 해시 값을 계산
        for (int i = 0; i < L; i++) {
            int charValue = str.charAt(i) - 'a' + 1;
            hashValue = (hashValue + (charValue * pow) % M) % M;
            pow = (pow * r) % M;
        }
        System.out.println(hashValue);
    }
}
