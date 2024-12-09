package bronze;

import java.util.Scanner;

public class BJ1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long fixedCost = sc.nextLong(); // 고정 비용 A
        long variableCost = sc.nextLong(); // 가변 비용 B
        long price = sc.nextLong(); // 판매 가격 C

        if (price <= variableCost) {
            // 판매 가격이 가변 비용보다 작거나 같으면 손익분기점 없음
            System.out.println(-1);
        } else {
            // 손익분기점 = 고정비용 / (판매가격 - 가변비용) + 1
            long breakEvenPoint = fixedCost / (price - variableCost) + 1;
            System.out.println(breakEvenPoint);
        }
    }
}
