import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        return Arrays.stream(numbers)
                     .map(n -> n * 2)
                     .toArray();
    }
}
