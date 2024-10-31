package gold;

import java.util.*;

public class BJ7662 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); // 최솟값 큐
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder()); // 최댓값 큐
        /*
            D or I와 정수 n
            I n은 정수 n을 Q에 삽입하는 연산
            D 1 최대값 삭제
            D -1 최솟값 삭제
            Queue 비어있으면 D연산무시.

            output : 남은 값중 최대와 최소. 두값을 하나의 줄, 하나의 공백
                    Q가 비어있다면 EMPTY출력
         */
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>(); // TreeMap 사용

            for (int j = 0; j < num; j++) {
                char c = sc.next().charAt(0);
                int number = sc.nextInt();
                if (c == 'I') { // 삽입 연산
                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else if (c == 'D') { // 삭제 연산
                    if (map.isEmpty()) {
                        continue;
                    }
                    if (number == 1) { // 최댓값 삭제
                        int max = map.lastKey();
                        if (map.get(max) == 1) {
                            map.remove(max);
                        } else {
                            map.put(max, map.get(max) - 1);
                        }
                    } else if (number == -1) { // 최솟값 삭제
                        int min = map.firstKey();
                        if (map.get(min) == 1) {
                            map.remove(min);
                        } else {
                            map.put(min, map.get(min) - 1);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey()); // 최대값과 최소값 출력
            }
        }
    }
}
