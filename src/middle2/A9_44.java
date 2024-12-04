package middle2;

import java.util.ArrayList;
import java.util.List;

public class A9_44 {
    static int n; // 노드 수
    static int[][] distance; // 거리 행렬
    static List<Integer> bestSolution; // 최적 경로
    static int bestDistance = Integer.MAX_VALUE; // 최적 거리

    public static void main(String[] args) {
        // 그래프 초기화 (예제)
        n = 4;
        distance = new int[][]{
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        // 초기 경로 및 최적해 초기화
        List<Integer> tour = new ArrayList<>();
        tour.add(0); // 시작점은 0번 노드
        bestSolution = new ArrayList<>();

        // BacktrackTSP 호출
        BacktrackTSP(tour, 0);

        // 결과 출력
        System.out.println("최적 경로: " + bestSolution);
        System.out.println("최소 거리: " + bestDistance);
    }

    static void BacktrackTSP(List<Integer> tour, int currentDistance) {
        // 1. 경로가 완전한 경우
        if (tour.size() == n) {
            // 마지막 노드에서 시작 노드로 돌아오는 거리 추가
            int finalDistance = currentDistance + distance[tour.get(tour.size() - 1)][tour.get(0)];
            if (finalDistance < bestDistance) {
                bestDistance = finalDistance;
                bestSolution = new ArrayList<>(tour);
            }
            return;
        }

        // 2. 확장 가능한 노드 탐색
        for (int v = 0; v < n; v++) {
            // 확장 조건: 아직 방문하지 않은 노드
            if (!tour.contains(v)) {
                int newDistance = currentDistance + distance[tour.get(tour.size() - 1)][v];

                // 가지치기: 현재 경로가 최적해보다 나으면 중단
                if (newDistance < bestDistance) {
                    tour.add(v); // 새로운 노드를 경로에 추가
                    BacktrackTSP(tour, newDistance); // 재귀 호출
                    tour.remove(tour.size() - 1); // 탐색 후 노드 제거 (백트래킹)
                }
            }
        }
    }
}
