package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2437 {
    // 각 무게 추는 1개만 사용 가능하다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr =new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + 1 < arr[i]) {
                break;
            }
            sum += arr[i];
        }

        System.out.println(sum + 1);
    }
}
