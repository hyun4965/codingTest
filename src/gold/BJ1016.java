package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1016 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size = (int) (max - min + 1);
        boolean[] removed = new boolean[size];

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = ((min + square - 1) / square) * square;

            for (long v = start; v <= max; v += square) {
                removed[(int) (v - min)] = true;
            }
        }

        int count = 0;
        for (boolean isRemoved : removed) {
            if (!isRemoved) {
                count++;
            }
        }

        System.out.print(count);
    }
}

