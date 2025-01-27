package gold;

import java.util.*;

public class BJ2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //학생수
        int M = sc.nextInt(); //비교횟수

        //그래프 및 진입 차수 초기화
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 입력 받기
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph.get(A).add(B); //A -> B 그래프
            inDegree[B]++; // B의 진입 차수 증가
        }

        // 위상 정렬을 위한 큐
        Queue<Integer> queue = new LinkedList<>();

        // 진입 차수가 0인 노드를 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 결과를 저장할 리스트
        List<Integer> result = new ArrayList<>();

        // 위상 정렬 수행
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int next : graph.get(current)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int student : result) {
            System.out.print(student + " ");
        }
    }
}
