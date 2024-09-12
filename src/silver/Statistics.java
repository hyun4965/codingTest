package silver;
import java.util.*;

public class Statistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];

            // 빈도 계산
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
        }

        // 배열 정렬
        Arrays.sort(arr);

        // 산술 평균 계산 (소수 첫째 자리에서 반올림)
        double mean = (double) sum / N;
        System.out.println(Math.round(mean));

        // 중앙값 계산
        System.out.println(arr[N / 2]);

        // 최빈값 계산 (여러 개일 경우 두 번째로 작은 값 출력)
        int maxFreq = 0;
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int value = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                modes.clear();
                modes.add(value);
            } else if (freq == maxFreq) {
                modes.add(value);
            }
        }

        // 최빈값 중 두 번째로 작은 값 선택
        Collections.sort(modes);
        if (modes.size() > 1) {
            System.out.println(modes.get(1));  // 두 번째로 작은 최빈값
        } else {
            System.out.println(modes.get(0));  // 최빈값이 하나일 경우
        }

        // 범위 계산
        System.out.println(arr[N - 1] - arr[0]);
    }
}

//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Statistics {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] arr = new int[N];
//        int sum = 0;
//        Map<Integer, Integer> frequency = new HashMap<>();
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = sc.nextInt();
//            sum += arr[i];
//
//            // 빈도 계산위한 값 입력
//            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
//        }
//
//        // 배열 정렬
//        Arrays.sort(arr);
//
//        // 산술 평균 계산 (소수 첫째 자리에서 반올림)
//        double mean = (double) sum / N;
//        System.out.println(Math.round(mean));
//
//        // 중앙값 계산
//        System.out.println(arr[N / 2]);
//
//
//        int maxFreq = 0;
//        int mode = arr[0];
//        boolean second = false;
//        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
//            int value = entry.getKey();
//            int freq = entry.getValue();
//
//            if (freq > maxFreq) {
//                maxFreq = freq;
//                mode = value;
//                second = false;
//            } else if (freq == maxFreq && !second) {
//                mode = value;
//                second = true; // 최빈값 중 두 번째로 작은 값
//            }
//        }
//        System.out.println(mode);
//
//        // 범위 계산
//        System.out.println(arr[N - 1] - arr[0]);
//    }
//}
