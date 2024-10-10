package bronze;

import java.util.*;

public class BJ1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String number = sc.next();
            if (number.equals("0")) {
                break;
            }
            StringBuilder sb = new StringBuilder(number);
            sb.reverse();
            String reversed = sb.toString();
            if (number.equals(reversed)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
