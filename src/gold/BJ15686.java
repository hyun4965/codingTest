package gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ15686 {
    static int N, M;
    static int[][] city;
    static List<int[]> houses = new ArrayList<>(); //집
    static List<int[]> chickens = new ArrayList<>(); //치킨집
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt(); // 남길 치킨집 개수
        city = new int[N][N];

        // 도시 정보 입력 및 집, 치킨집 위치 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                city[i][j] = sc.nextInt();
                if (city[i][j] == 1) houses.add(new int[]{i, j});
                if (city[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }

        // 조합을 통해 치킨집 선택
        selectChickens(new ArrayList<>(), 0, 0);
        System.out.println(minDistance);
    }

    // 치킨집 조합 선택
    static void selectChickens(List<int[]> selected, int start, int count) {
        if (count == M) {
            // 선택된 치킨집으로 도시의 치킨 거리 계산
            minDistance = Math.min(minDistance, calculateCityDistance(selected));
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            selectChickens(selected, i + 1, count + 1);
            selected.remove(selected.size() - 1);
        }
    }

    // 도시의 치킨 거리 계산
    static int calculateCityDistance(List<int[]> selected) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int hx = house[0], hy = house[1];
            int minHouseDistance = Integer.MAX_VALUE;

            // 현재 선택된 치킨집들 중 가장 가까운 거리 찾기
            for (int[] chicken : selected) {
                int cx = chicken[0], cy = chicken[1];
                int distance = Math.abs(hx - cx) + Math.abs(hy - cy);
                minHouseDistance = Math.min(minHouseDistance, distance);
            }

            totalDistance += minHouseDistance;
        }

        return totalDistance;
    }
}
