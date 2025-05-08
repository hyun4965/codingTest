package bronze;

import java.util.Scanner;

public class BJ1032 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비

        String[] files = new String[n];
        for (int i = 0; i < n; i++) {
            files[i] = scanner.nextLine();
        }

        int length = files[0].length();
        StringBuilder pattern = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char currentChar = files[0].charAt(i);
            boolean allMatch = true;

            for (int j = 1; j < n; j++) {
                if (files[j].charAt(i) != currentChar) {
                    allMatch = false;
                    break;
                }
            }

            if (allMatch) {
                pattern.append(currentChar);
            } else {
                pattern.append('?');
            }
        }

        System.out.println(pattern.toString());
    }
}
