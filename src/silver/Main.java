package silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        StringBuilder sb= new StringBuilder();

        int count=0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if(i==0 && !Objects.equals(s, "ENTER")){
                return;
            }
            sb.append(s);
            set.add(s);
            if (!set.contains(sb.toString())) {
                count+=1;
            }
        }
        System.out.println(count);
    }
}