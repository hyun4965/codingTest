class Solution {
    public int solution(String my_string) {
        int sum = 0;
        StringBuilder number = new StringBuilder();

        for (char c : my_string.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c); 
            } else {
                if (number.length() > 0) {
                    sum += Integer.parseInt(number.toString());
                    number.setLength(0);
                }
            }
        }

        if (number.length() > 0) {
            sum += Integer.parseInt(number.toString());
        }

        return sum;
    }
}
