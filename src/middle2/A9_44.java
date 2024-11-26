package middle2;

import java.util.ArrayList;

public class A9_44 {
    static int[][] graph = {
            {0, 2, 7, 3, Integer.MAX_VALUE},
            {2, 0, 3, 5, 4},
            {7, 3, 0, 6, 1},
            {3, 5, 6, 0, 9},
            {Integer.MAX_VALUE, 4, 1, 9, 0}
    }; // 그래프 (Integer.MAX_VALUE는 연결 없음)
    static int n = graph.length; // 정점의 개수
    static ArrayList<Integer> bestTour = new ArrayList<>(); // 최적 경로
    static int bestDistance = Integer.MAX_VALUE; // 최적 거리

    public static void main(String[] args) {
        ArrayList<Integer> currentTour = new ArrayList<>();
        currentTour.add(0); // 시작점 (0번 정점, A)
        backtrackTSP(currentTour, 0); // 탐색 시작
        System.out.println("최적 경로: " + bestTour);
        System.out.println("최단 거리: " + bestDistance);
    }

    static void backtrackTSP(ArrayList<Integer> tour, int currentDistance) {
        // 경로가 완성되었고, 마지막 정점이 시작점으로 돌아올 수 있는 경우
        if (tour.size() == n) {
            int lastToStart = graph[tour.get(tour.size() - 1)][tour.get(0)];
            if (lastToStart != Integer.MAX_VALUE) { // 시작점으로 돌아올 수 있는 경우
                int totalDistance = currentDistance + lastToStart;
                if (totalDistance < bestDistance) {
                    bestDistance = totalDistance;
                    bestTour = new ArrayList<>(tour); // 최적 경로 저장
                }
            }
            return;
        }

        // 다음 정점을 시도
        for (int next = 0; next < n; next++) {
            // 조건: 아직 방문하지 않았고, 현재 정점에서 다음 정점으로 가는 간선이 있는 경우
            if (!tour.contains(next) && graph[tour.get(tour.size() - 1)][next] != Integer.MAX_VALUE) {
                // 새로운 경로 생성
                tour.add(next);
                int newDistance = currentDistance + graph[tour.get(tour.size() - 2)][next];

                // 가지치기: 현재 거리 + 추가 거리가 최적 거리보다 작은 경우만 탐색
                if (newDistance < bestDistance) {
                    backtrackTSP(tour, newDistance);
                }

                // 백트래킹: 경로 복구
                tour.remove(tour.size() - 1);
            }
        }
    }
}
