package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //센서의 갯수
        int k = Integer.parseInt(br.readLine()); //집중국의 개수

        if(k>=n){
            System.out.println(0);
            return;
        }

        //센서 좌표 입력
        int[] center = new int[n];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            center[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(center);

        int[] diff = new int[n - 1];
        for(int i = 0; i < n - 1; i++){
            diff[i] = center[i+1] - center[i];
        }

        Arrays.sort(diff);

        // 4. 가장 짧은 N-K개의 거리 합 계산 (가장 긴 K-1개를 제외)
        long result = 0;
        for(int i = 0; i < n - k; i++){
            result += diff[i];
        }

        System.out.println(result);
    }
}
