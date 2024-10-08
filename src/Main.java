import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();

        String[] str =br.readLine().split("");

        for(String s : str) {
            leftStack.push(s);
        }

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch(c) {
                case 'L':
                    if(!leftStack.isEmpty())
                        rightStack.push(leftStack.pop());

                    break;
                case 'D':
                    if(!rightStack.isEmpty())
                        leftStack.push(rightStack.pop());

                    break;
                case 'B':
                    if(!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    leftStack.push(String.valueOf(t));
                    break;
                default:
                    break;
            }
        }
        while(!leftStack.isEmpty())
            rightStack.push(leftStack.pop());

        while(!rightStack.isEmpty())
            bw.write(rightStack.pop());

        bw.flush();
        br.close();
        bw.close();
    }
}
