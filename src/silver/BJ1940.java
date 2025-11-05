package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        int answer=0;
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        for(int i=0; i<m; i++){
            for(int j=i+1; j<n; j++){
                if(num[j] + num[i] == m){
                    answer++;
                }
            }
        }
        //아래처럼 투포인터도 가능.
//        int answer = 0;
//        int start = 0; // 시작 포인터 (인덱스)
//        int end = n - 1; // 끝 포인터 (인덱스)
//
//        // 2. 투 포인터 탐색 (O(N))
//        while (start < end) {
//            int sum = num[start] + num[end];
//
//            if (sum == m) {
//                // Case 1: 합이 M과 같다
//                answer++;
//                start++; // 다음 재료 탐색
//                end--;   // 다음 재료 탐색
//            } else if (sum < m) {
//                // Case 2: 합이 M보다 작다
//                start++; // 합을 키우기 위해 start 포인터를 오른쪽으로 이동
//            } else {
//                // Case 3: 합이 M보다 크다
//                end--; // 합을 줄이기 위해 end 포인터를 왼쪽으로 이동
//            }
//        }
        System.out.println(answer);
    }
}