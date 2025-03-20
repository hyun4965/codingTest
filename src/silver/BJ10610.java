package silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next(); // 입력받은 숫자 문자열

        List<Integer> digits = new ArrayList<>();
        int sum = 0;
        boolean hasZero = false;

        for (char c : N.toCharArray()) {
            int num = c - '0';
            digits.add(num);
            sum += num;
            if (num == 0) {
                hasZero = true;
            }
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        digits.sort(Collections.reverseOrder());
        StringBuilder result = new StringBuilder();
        for (int num : digits) {
            result.append(num);
        }

        System.out.println(result);
    }
}
