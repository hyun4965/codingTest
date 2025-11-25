package news;

import java.util.HashMap;
import java.util.Scanner;

public class BJ10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int target = sc.nextInt();
            sb.append(map.getOrDefault(target, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}