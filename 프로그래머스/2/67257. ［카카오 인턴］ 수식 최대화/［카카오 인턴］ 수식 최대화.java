import java.util.*;

class Solution {
    char[][] priorities = {
        {'+', '-', '*'}, {'+', '*', '-'},
        {'-', '+', '*'}, {'-', '*', '+'},
        {'*', '+', '-'}, {'*', '-', '+'}
    };

    public long solution(String expression) {
        long answer = 0;
        
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        
        String numStr = "";
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                numStr += c;
            } else {
                numbers.add(Long.parseLong(numStr));
                numStr = "";
                operators.add(c);
            }
        }
        numbers.add(Long.parseLong(numStr));

        for (char[] priority : priorities) {
            List<Long> currentNumbers = new ArrayList<>(numbers);
            List<Character> currentOperators = new ArrayList<>(operators);
            
            for (char op : priority) {
                for (int i = 0; i < currentOperators.size(); i++) {
                    if (currentOperators.get(i) == op) {
                        long num1 = currentNumbers.get(i);
                        long num2 = currentNumbers.get(i + 1);
                        long result = calculate(num1, num2, op);
                        
                        currentNumbers.remove(i + 1);
                        currentNumbers.set(i, result);
                        currentOperators.remove(i);
                        
                        i--; 
                    }
                }
            }
            
            long finalResult = Math.abs(currentNumbers.get(0));
            answer = Math.max(answer, finalResult);
        }
        
        return answer;
    }

    private long calculate(long num1, long num2, char op) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else { // op == '*'
            return num1 * num2;
        }
    }
}