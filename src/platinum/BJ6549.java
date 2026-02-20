package platinum;

import java.io.*;

public class BJ6549 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        while (true) {
            long nL = fs.nextLong();
            if (nL == Long.MIN_VALUE) {
                break;
            }
            int n = (int) nL;
            if (n == 0) {
                break;
            }

            long[] h = new long[n + 1];
            for (int i = 0; i < n; i++) {
                h[i] = fs.nextLong();
            }
            h[n] = 0;

            int[] stack = new int[n + 1];
            int top = -1;

            long best = 0;

            for (int i = 0; i <= n; i++) {
                while (top >= 0 && h[stack[top]] > h[i]) {
                    long height = h[stack[top--]];
                    int leftLessIdx = (top >= 0) ? stack[top] : -1;
                    long width = i - leftLessIdx - 1L;
                    long area = height * width;
                    if (area > best) {
                        best = area;
                    }
                }
                stack[++top] = i;
            }

            sb.append(best).append("\n");

        }

        System.out.print(sb.toString());
    }

    static final class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) {
                    return Long.MIN_VALUE;
                }
            } while (c <= ' ');

            long sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
}
