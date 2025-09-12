class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int leftRow = 3, leftCol = 0;
        int rightRow = 3, rightCol = 2;

        for (int num : numbers) {
            int r, c; 

            if (num == 1 || num == 4 || num == 7) {
                r = (num - 1) / 3; c = 0;
                sb.append('L');
                leftRow = r; leftCol = c;
            } else if (num == 3 || num == 6 || num == 9) {
                r = (num - 1) / 3; c = 2;
                sb.append('R');
                rightRow = r; rightCol = c;
            } else {
                if (num == 0) { r = 3; c = 1; }
                else { r = (num - 2) / 3; c = 1; }

                int leftDist  = Math.abs(leftRow - r) + Math.abs(leftCol - c);
                int rightDist = Math.abs(rightRow - r) + Math.abs(rightCol - c);

                if (leftDist < rightDist) {
                    sb.append('L');
                    leftRow = r; leftCol = c;
                } else if (rightDist < leftDist) {
                    sb.append('R');
                    rightRow = r; rightCol = c;
                } else {
                    if ("right".equals(hand)) {
                        sb.append('R');
                        rightRow = r; rightCol = c;
                    } else {
                        sb.append('L');
                        leftRow = r; leftCol = c;
                    }
                }
            }
        }

        return sb.toString();
    }
}
