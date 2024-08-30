package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCardGame2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력받기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // 숫자 카드 배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // M 입력받기
        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];

        // 찾을 숫자 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        // 출력 최적화를 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 이진 탐색을 통한 숫자 카드 개수 찾기
        for (int i = 0; i < M; i++) {
            int key = arr2[i];

            // lowerBound 찾기
            int left = 0;
            int right = N;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int lowerBound = left;

            // upperBound 찾기
            left = 0;
            right = N;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] <= key) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int upperBound = left;

            // 숫자의 개수는 upperBound - lowerBound
            int count = upperBound - lowerBound;

            // StringBuilder에 결과 추가
            sb.append(count).append(" ");
        }

        // 최종 출력
        System.out.println(sb.toString().trim());
    }
}
