class Solution {
    public long solution(String numbers) {
        String[] eng = {
            "zero","one","two","three","four",
            "five","six","seven","eight","nine"
        };
        
        for (int i = 0; i < eng.length; i++) {
            numbers = numbers.replaceAll(eng[i], String.valueOf(i));
        }
        
        return Long.parseLong(numbers);
    }
}
