import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        long factorial = 1;
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i;
        }
        
        int[] answer = new int[n];
        dfs(n, k - 1, numbers, factorial, answer, 0);
        
        return answer;
    }
    
    // 재귀 함수
    private void dfs(int n, long k, List<Integer> numbers, long factorial, int[] answer, int depth) {
        if (n == 0) return;
        
        long unit = factorial / n;
        
        int index = (int) (k / unit);
        
        answer[depth] = numbers.get(index);
        numbers.remove(index);
        
        dfs(n - 1, k % unit, numbers, unit, answer, depth + 1);
    }
}