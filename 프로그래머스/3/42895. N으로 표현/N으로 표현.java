import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        int repeated = 0;

        for (int count = 1; count <= 8; count++) {
            repeated = repeated * 10 + N;
            dp.get(count).add(repeated);

            for (int left = 1; left < count; left++) {
                int right = count - left;

                for (int a : dp.get(left)) {
                    for (int b : dp.get(right)) {
                        dp.get(count).add(a + b);
                        dp.get(count).add(a - b);
                        dp.get(count).add(a * b);

                        if (b != 0) {
                            dp.get(count).add(a / b);
                        }
                    }
                }
            }

            if (dp.get(count).contains(number)) {
                return count;
            }
        }

        return -1;
    }
}