package bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ10757 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] numbers = input.split(" ");

        // A와 B를 BigInteger로 변환
        BigInteger A = new BigInteger(numbers[0]);
        BigInteger B = new BigInteger(numbers[1]);

        // A + B 계산
        BigInteger result = A.add(B);

        // 결과 출력
        System.out.println(result);
    }
}
