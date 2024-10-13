package silver;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BJ1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 수
        int testCaseCount = sc.nextInt();

        for (int t = 0; t < testCaseCount; t++) {
            // 문서의 개수 N과 몇 번째 문서인지 M
            int N = sc.nextInt();
            int M = sc.nextInt();
            Deque<int[]> queue = new ArrayDeque<>();

            // 문서의 중요도를 입력받아 큐에 저장
            for (int i = 0; i < N; i++) {
                int priority = sc.nextInt();
                queue.offer(new int[]{i, priority}); // {문서 인덱스, 중요도}
            }

            int printOrder = 0; // 인쇄 순서
            while (!queue.isEmpty()) {
                int[] currentDoc = queue.poll(); // 큐의 앞 문서 꺼내기
                boolean hasHigherPriority = false;

                // 현재 문서보다 더 중요한 문서가 있는지 확인
                for (int[] doc : queue) {
                    if (doc[1] > currentDoc[1]) {
                        hasHigherPriority = true; // 더 중요한 문서가 있음
                        break;
                    }
                }

                if (hasHigherPriority) {
                    // 더 중요한 문서가 있으면 큐의 뒤로 보냄
                    queue.offer(currentDoc);
                } else {
                    // 문서 인쇄
                    printOrder++;
                    // 인쇄한 문서가 M번 문서인지 확인
                    if (currentDoc[0] == M) {
                        System.out.println(printOrder); // M번 문서의 인쇄 순서 출력
                        break;
                    }
                }
            }
        }
    }
}
