import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        
        int n = numbers.length;
        int prodSmall = numbers[0] * numbers[1];        
        int prodLarge = numbers[n - 2] * numbers[n - 1];
        
        return Math.max(prodSmall, prodLarge);
    }
}