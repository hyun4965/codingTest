package bronze;

import java.util.Scanner;

public class BJ2490 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            int countZero = 0;

            for (int j = 0; j < 4; j++) {
                int input = scanner.nextInt();
                if (input == 0) {
                    countZero++;
                }
            }

            switch (countZero) {
                case 1:
                    System.out.println("A"); // 도
                    break;
                case 2:
                    System.out.println("B"); // 개
                    break;
                case 3:
                    System.out.println("C"); // 걸
                    break;
                case 4:
                    System.out.println("D"); // 윷
                    break;
                case 0:
                    System.out.println("E"); // 모
                    break;
            }
        }

        scanner.close();
    }
}