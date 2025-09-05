import java.util.*;

class Solution {
    public int[] solution(int n) {
        int total = n * (n + 1) / 2;   // 채워야 할 개수
        int[] answer = new int[total];

        int dir = 0;
        int r = -1, c = 0;     
        int val = 1;

        Deque<Integer> seg = new ArrayDeque<>();
        for (int len = n; len >= 1; len--) seg.addLast(len);

        while (!seg.isEmpty()) {
            int len = seg.pollFirst();
            for (int step = 0; step < len; step++) {
                if (dir == 0) {        
                    r++;
                } else if (dir == 1) { 
                    c++;
                } else {             
                    r--;
                    c--;
                }
                // (r, c) -> 펼친 인덱스: r행 시작 오프셋은 삼각수 r*(r1)/2
                int idx = r * (r + 1) / 2 + c;
                answer[idx] = val++;
            }
            dir = (dir + 1) % 3; 
        }
        return answer;
    }
}
