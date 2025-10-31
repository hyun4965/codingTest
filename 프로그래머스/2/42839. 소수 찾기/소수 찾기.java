import java.util.*;

class Solution {
    
    Set<Integer> uniqueNumbers = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        
        String[] digits = numbers.split("");
        
        boolean[] visited = new boolean[digits.length];

        dfs("", digits, visited);

        for (int num : uniqueNumbers) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }

    public void dfs(String currentNum, String[] digits, boolean[] visited) {
    
        for (int i = 0; i < digits.length; i++) {
            if (!visited[i]) {
                String newNumStr = currentNum + digits[i];
                int newNum = Integer.parseInt(newNumStr);
                
                uniqueNumbers.add(newNum);
                visited[i] = true;
                dfs(newNumStr, digits, visited);
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}