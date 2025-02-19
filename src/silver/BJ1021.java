package silver;

import java.util.*;

public class BJ1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 큐의 크기
        int M = sc.nextInt();  // 뽑아내려는 숫자의 개수

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }

        int totalOperations = 0;

        for (int target : targets) {
            int index = deque.indexOf(target);
            int leftMoves = index; // 왼쪽으로 이동
            int rightMoves = deque.size() - index; // 오른쪽으로 이동

            if (leftMoves <= rightMoves) {
                // 왼쪽 이동이 더 적은 경우
                for (int i = 0; i < leftMoves; i++) {
                    deque.addLast(deque.removeFirst());
                }
                totalOperations += leftMoves;
            } else {
                // 오른쪽 이동이 더 적은 경우
                for (int i = 0; i < rightMoves; i++) {
                    deque.addFirst(deque.removeLast());
                }
                totalOperations += rightMoves;
            }

            deque.removeFirst();
        }

        System.out.println(totalOperations);
    }
}