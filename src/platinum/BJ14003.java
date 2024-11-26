package platinum;

import java.io.*;
import java.util.*;

public class BJ14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 처리
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 계산
        int[] indices = new int[N]; // 각 원소가 LIS에서 위치한 인덱스 저장
        int[] prev = new int[N];    // LIS 복구를 위한 이전 원소 추적
        Arrays.fill(prev, -1); // prev 초기화
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int pos = Collections.binarySearch(list, num); // 이진 탐색
            if (pos < 0) pos = -(pos + 1); // 삽입 위치 계산

            // LIS 갱신
            if (pos < list.size()) {
                list.set(pos, num);
            } else {
                list.add(num);
            }
            indices[i] = pos; // 현재 숫자가 LIS에서 위치한 인덱스 저장

            // 이전 원소 추적
            if (pos > 0) {
                prev[i] = Arrays.binarySearch(indices, pos - 1); // 이전 원소 위치 저장
            }
        }

        // LIS 길이
        int lisLength = list.size();
        sb.append(lisLength).append("\n");

        // LIS 복구
        int[] result = new int[lisLength];
        int j = lisLength - 1;

        for (int i = N - 1; i >= 0; i--) {
            if (indices[i] == j) { // 현재 원소가 LIS의 j번째 위치에 해당
                result[j] = arr[i];
                j--;
                if (j < 0) break; // LIS 복원이 완료되면 종료
            }
        }

        // 결과 출력
        for (int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
