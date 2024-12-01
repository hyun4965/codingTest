package bronze;

import java.util.Scanner;
import java.math.BigInteger;

public class BJ4328 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 입력 받기
            String input = sc.nextLine().trim();
            if (input.equals("0")) break; // 종료 조건

            String[] parts = input.split(" ");
            int base = Integer.parseInt(parts[0]); // b
            String p = parts[1]; // p
            String m = parts[2]; // m

            // p와 m을 b진법에서 10진법으로 변환
            BigInteger numP = new BigInteger(p, base);
            BigInteger numM = new BigInteger(m, base);

            // 나머지 계산
            BigInteger remainder = numP.mod(numM);

            // 결과를 b진법으로 변환 후 출력
            System.out.println(remainder.toString(base).toUpperCase());
        }

        sc.close();
    }
}
