package silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N 입력 받기
        int K = sc.nextInt(); //K 입력 받기

        if (N < K) { //양의 정수 K(≤ N)
            System.out.println("다시 입력하세요");
            N=sc.nextInt();
            K=sc.nextInt();
        }

        List<Integer> people = new ArrayList<>();//N번까지 사람 리스트에 입력.
        // 1번부터 N번까지 사람들 리스트에 추가
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int index = 0; // 제거할 사람의 인덱스

        while (people.size() > 0) {
            // 현재 인덱스에서 K-1만큼 이동, 그 사람을 제거
            index = (index + K - 1) % people.size();
            result.add(people.remove(index));
        }

        // 요세푸스 순열 출력
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
