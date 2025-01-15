package gold;

import java.io.*;
import java.util.*;

public class BJ12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        //값 입력
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>(); //증가부분 수열 저장

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i]; // 현재 숫자
            //마지막 값보다 크거나 or 비어있을 경우 단순 추가
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num); // LIS에 새로운 요소 추가
            } else {
                // 이진 탐색으로 현재 num이 들어갈 위치를 찾음
                int index = Collections.binarySearch(list, num);
                if (index < 0) {
                    index = -(index + 1); // 삽입 위치 계산
                }
                list.set(index, num); // 해당 위치의 값을 num으로 대체
            }
        }


        System.out.println(list.size());
    }
}
