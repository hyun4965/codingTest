package platinum;

import java.io.*;
import java.util.*;

public class BJ14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 번째 줄: 수열 크기 N
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] indices = new int[N]; // 각 원소가 LIS에서 위치한 인덱스 저장
        int[] prev = new int[N];    // 이전 원소를 추적해 LIS 복구
        Arrays.fill(prev, -1); //prev 채워넣기

        // LIS 계산 (O(N log N))
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int pos = Collections.binarySearch(list, num); // 이진 탐색
            System.out.println("pos = " + pos);

            if (pos < 0) {
                pos = -(pos + 1); // 삽입 위치 계산
            }
            System.out.println("pos2 = " + pos);

            // LIS 갱신
            if (pos < list.size()) {
                list.set(pos, num); // 기존 값 대체
            } else {
                list.add(num);      // 새로운 값 추가
            }
            indices[i] = pos; // 현재 숫자가 LIS에서 위치한 인덱스 저장

            // 이전 원소 추적
            if (pos > 0) {
                prev[i] = Arrays.binarySearch(indices, pos - 1);
            }
        }

        // LIS 길이
        int lisLength = list.size();
        sb.append(lisLength).append("\n");

        // LIS 복구 역순으로 함
        int[] result = new int[lisLength];
        int j = lisLength - 1; // LIS의 마지막 인덱스

        for (int i = N - 1; i >= 0; i--) {
            if (indices[i] == j) { // 현재 원소가 LIS의 j번째 위치에 해당
                result[j] = arr[i]; // 해당 위치에 값을 저장
                j--; // 다음 위치로 이동
                if (j < 0) {
                    break; // LIS 추적이 끝나면 종료
                }
            }
        }

        for (int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}