package gold;

import java.util.*;

public class BJ1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수열의 크기

        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int ones = 0; // 1의 개수
        int zeroCount = 0; // 0의 개수

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num > 1) {
                positives.add(num);
            } else if (num == 1) {
                ones++;
            } else if (num == 0) {
                zeroCount++;
            } else {
                negatives.add(num);
            }
        }

        // 양수는 큰 값끼리 묶어야 최대 합이 나옴
        positives.sort(Collections.reverseOrder());
        // 음수는 작은 값끼리 묶어야 최대 합이 나옴
        negatives.sort(Comparator.naturalOrder());

        int sum = 0;

        for (int i = 0; i < positives.size(); i += 2) {
            if (i + 1 < positives.size()) {
                sum += positives.get(i) * positives.get(i + 1);
            } else {
                sum += positives.get(i);
            }
        }

        for (int i = 0; i < negatives.size(); i += 2) {
            if (i + 1 < negatives.size()) {
                sum += negatives.get(i) * negatives.get(i + 1);
            } else if (zeroCount == 0) {
                sum += negatives.get(i);
            }
        }

        sum += ones;

        System.out.println(sum);
    }
}