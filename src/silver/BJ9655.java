package silver;

import java.io.*;

public class BJ9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //상근 승 :SK  창영 : CY
        if(N%2==1) {
            System.out.println("SK");
        }else {
            System.out.println("CY");
        }
    }
}
