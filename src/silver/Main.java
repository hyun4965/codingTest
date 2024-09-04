package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count =1;
        int N = Integer.parseInt(br.readLine());

        for(int i=2;i*i<=N;i++){
            count++;
        }
        System.out.println(count);
    }
}
