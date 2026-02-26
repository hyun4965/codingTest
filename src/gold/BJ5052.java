package gold;

import java.util.*;

public class BJ5052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] arr = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }

            Arrays.sort(arr);

            boolean isValid = true;

            for (int i = 0; i < n - 1; i++) {
                if (arr[i + 1].startsWith(arr[i])) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}