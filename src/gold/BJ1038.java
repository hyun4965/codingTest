package gold;

import java.util.*;
import java.io.*;

public class BJ1038 {
    static List<Long> list = new ArrayList<>();
    static int N;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        //~9까지 빠르게 처리
        if(N <= 10) {
            System.out.print(N);
            return;
        } else if (N >= 1023) {
            System.out.print(-1);
            return;//max 1023이므로 그 위론 불가능
        }

        for(int i = 0; i < 10; i++) {
            DFS(i);
        }

        Collections.sort(list);
        System.out.print(list.get(N));
    }

    private static void DFS(long num) {
        list.add(num);
        long value = num % 10;
        if(value == 0) {
            return;
        }

        for(long i = value -1; i>=0; i--) {
            long newValue = num * 10 + i;
            DFS(newValue);
        }
    }
}