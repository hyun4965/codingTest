package silver;

import java.util.*;

public class BJ1063 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력
        String[] input = scanner.nextLine().split(" ");
        String kingPos = input[0];
        String stonePos = input[1];
        int n = Integer.parseInt(input[2]);

        Map<String, int[]> directions = new HashMap<>();
        directions.put("R", new int[]{0, 1});
        directions.put("L", new int[]{0, -1});
        directions.put("B", new int[]{-1, 0});
        directions.put("T", new int[]{1, 0});
        directions.put("RT", new int[]{1, 1});
        directions.put("LT", new int[]{1, -1});
        directions.put("RB", new int[]{-1, 1});
        directions.put("LB", new int[]{-1, -1});

        int kingRow = kingPos.charAt(1) - '1';
        int kingCol = kingPos.charAt(0) - 'A';

        int stoneRow = stonePos.charAt(1) - '1';
        int stoneCol = stonePos.charAt(0) - 'A';

        for (int i = 0; i < n; i++) {
            String move = scanner.nextLine();

            int[] dir = directions.get(move);
            int newKingRow = kingRow + dir[0];
            int newKingCol = kingCol + dir[1];

            // 킹이 이동한 후 좌표가 체스판을 벗어나면 무시
            if (newKingRow < 0 || newKingRow >= 8 || newKingCol < 0 || newKingCol >= 8) {
                continue;
            }

            // 킹의 새 위치가 돌의 위치와 같다면 돌도 이동
            if (newKingRow == stoneRow && newKingCol == stoneCol) {
                int newStoneRow = stoneRow + dir[0];
                int newStoneCol = stoneCol + dir[1];

                // 돌이 체스판을 벗어나면 무시
                if (newStoneRow < 0 || newStoneRow >= 8 || newStoneCol < 0 || newStoneCol >= 8) {
                    continue;
                }

                // 돌 이동
                stoneRow = newStoneRow;
                stoneCol = newStoneCol;
            }

            // 킹 이동
            kingRow = newKingRow;
            kingCol = newKingCol;
        }

        // 결과 출력
        System.out.println((char) ('A' + kingCol) + "" + (kingRow + 1));
        System.out.println((char) ('A' + stoneCol) + "" + (stoneRow + 1));

        scanner.close();
    }
}
