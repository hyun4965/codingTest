import java.util.*;

class Solution {
    private static final int LIMIT = 10000000;

    public List<Integer> solution(long begin, long end) {
        List<Integer> board = new ArrayList<>();
        for (long x = begin; x <= end; x++) {
            if (x == 1) { 
                board.add(0); 
                continue; 
            }
            board.add((int) block(x));
        }
        return board;
    }

    private long block(long x) {
        long best = 1; 
        long root = (long) Math.sqrt(x);

        for (long d = 2; d <= root; d++) {
            if (x % d != 0) {
                continue;
            }

            long partner = x / d;

            if (partner <= LIMIT) {
                return partner;
            }

            if (d <= LIMIT) best = d;
        }
        return best;
    }
}
