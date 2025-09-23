class Solution {
    public int[] solution(String[] wallpaper) {
        int h = wallpaper.length;
        int w = wallpaper[0].length();


        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxRow = -1;
        int maxCol = -1;

        for (int i = 0; i < h; i++) {
            String row = wallpaper[i];
            for (int j = 0; j < w; j++) {
                if (row.charAt(j) == '#') {
                    if (i < minRow) {
                        minRow = i;
                    }
                    if (j < minCol) {
                        minCol = j;
                    }
                    if (i > maxRow) {
                        maxRow = i;
                    }
                    if (j > maxCol) {
                        maxCol = j;
                    }
                }
            }
        }


        return new int[] { minRow, minCol, maxRow + 1, maxCol + 1 };
    }
}