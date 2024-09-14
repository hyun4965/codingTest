package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N>=0 && N<=20) {
            long fact = 1;
            for (int i = 1; i <= N; i++) {
                fact *= i;
            }
            System.out.println(fact);
        }
    }
}
