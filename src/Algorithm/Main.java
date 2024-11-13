package Algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
    }

    public static boolean solution(String s) {
        boolean answer = true;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }else if (c == ')') {
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            answer = false;
        }else{
            answer = true;
        }

        return answer;
    }
}


