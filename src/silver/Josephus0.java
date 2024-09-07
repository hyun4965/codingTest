package silver;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Josephus0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // 1부터 N까지의 사람들을 리스트에 추가
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = 0;  // 리스트에서 사람을 제거할 인덱스

        while (!list.isEmpty()) {
            // K번째 사람을 제거해야 하므로 인덱스를 K-1만큼 이동
            index = (index + K - 1) % list.size();
            // 해당 인덱스의 사람을 제거하고 결과에 추가
            result.add(list.remove(index));
        }

        // 결과를 요세푸스 순열 형식으로 출력
        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i) + ", ");
            }
        }
        System.out.println(">");
    }
}

