import java.util.*;

class Solution {
    
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = isRoomSafe(places[i]);
        }
        return answer;
    }

    private int isRoomSafe(String[] room) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (room[r].charAt(c) == 'P') {
                    if (!isPersonSafe(r, c, room)) {
                        return 0;
                    }
                }
            }
        }
        return 1; 
    }

    private boolean isPersonSafe(int startR, int startC, String[] room) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC, 0});
        
        boolean[][] visited = new boolean[5][5];
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            if (dist >= 2) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                char cell = room[nr].charAt(nc);

                if (cell == 'P') {
                    return false; 
                } else if (cell == 'O') {
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return true; 
    }
}