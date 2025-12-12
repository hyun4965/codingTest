import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            sorted[i] = x;
        }

        // 정렬
        Arrays.sort(sorted);

        // 값 -> 압축된 좌표(순위)를 저장할 맵
        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 0;
        for (int i = 0; i < N; i++) {
            int value = sorted[i];
            // 아직 이 값이 맵에 없으면 순위 부여
            if (!map.containsKey(value)) {
                map.put(value, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i]));
            if (i < N - 1) sb.append(' ');
        }

        System.out.println(sb.toString());
    }
}
