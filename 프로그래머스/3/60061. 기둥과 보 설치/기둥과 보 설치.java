import java.util.*;

class Solution {

    private boolean[][] pillars; 
    private boolean[][] beams;   
    private int size;

    public int[][] solution(int n, int[][] build_frame) {
        this.size = n;

        pillars = new boolean[n + 2][n + 2];
        beams = new boolean[n + 2][n + 2];

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2]; 
            int b = frame[3]; 

            if (b == 1) { 
                if (a == 0) { 
                    if (canInstallPillar(x, y)) {
                        pillars[x][y] = true;
                    }
                } else {
                    if (canInstallBeam(x, y)) {
                        beams[x][y] = true;
                    }
                }
            } else {
                if (a == 0) { 
                    pillars[x][y] = false; 
                    if (!isAllValid()) {
                        pillars[x][y] = true; 
                    }
                } else { 
                    beams[x][y] = false; 
                    if (!isAllValid()) {
                        beams[x][y] = true; 
                    }
                }
            }
        }

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillars[i][j]) {
                    result.add(new int[]{i, j, 0});
                }
                if (beams[i][j]) {
                    result.add(new int[]{i, j, 1});
                }
            }
        }
        
        return result.toArray(new int[0][]);
    }
    
        private boolean canInstallPillar(int x, int y) {
        if (y == 0) return true;
        if (y > 0 && pillars[x][y - 1]) return true;
        if ((x > 0 && beams[x - 1][y]) || beams[x][y]) return true;
        
        return false;
    }

    private boolean canInstallBeam(int x, int y) {
        if ((y > 0 && pillars[x][y - 1]) || (y > 0 && pillars[x + 1][y - 1])) return true;
        if (x > 0 && beams[x - 1][y] && beams[x + 1][y]) return true;
        
        return false;
    }
    private boolean isAllValid() {
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (pillars[i][j] && !canInstallPillar(i, j)) {
                    return false;
                }
                if (beams[i][j] && !canInstallBeam(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

}