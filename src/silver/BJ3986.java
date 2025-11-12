package silver;

import java.util.Scanner;
import java.util.Stack;

public class BJ3986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //단어의 수
        int count =0; //결과 count

        for(int i=0; i<n; i++) {
            String str = sc.next();
            Stack<Character> stack = new Stack<>();

            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);

                if(stack.isEmpty() || c != stack.peek()) {
                    stack.push(c);
                }else if(stack.peek() == c){
                    stack.pop();
                }
            }
            if(stack.isEmpty()) count++;
        }
        System.out.println(count);
    }
}
