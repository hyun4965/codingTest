import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char c = line.charAt(0);

            if (c == 'p') { 
                if (line.charAt(1) == 'u') { 
                    int space = line.indexOf(' ');
                    int x = Integer.parseInt(line.substring(space + 1));

                    if (line.charAt(5) == 'f') {
                        dq.addFirst(x);
                    } else { 
                        dq.addLast(x);
                    }
                } else { 
                    if (line.charAt(4) == 'f') { 
                        sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append('\n');
                    } else { 
                        sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append('\n');
                    }
                }
            } else if (c == 's') { 
                sb.append(dq.size()).append('\n');
            } else if (c == 'e') { 
                sb.append(dq.isEmpty() ? 1 : 0).append('\n');
            } else if (c == 'f') { 
                sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
            } else {
                sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
