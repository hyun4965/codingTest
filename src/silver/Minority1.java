package silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minority1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // M 이상
        int n = Integer.parseInt(st.nextToken()); // N 이하

        boolean[] isPrime = new boolean[n + 1]; // n+1 크기로 배열 생성
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true; // 처음엔 모든 수를 소수로 간주
        }

        // 에라토스테네스의 체 알고리즘 적용
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false; // 소수가 아닌 수들을 false로 설정
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) { // M 이상 N 이하의 소수 출력
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}