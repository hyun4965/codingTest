package news;

import java.util.Scanner;

public class BJ8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];
        for(int i=0; i<t; i++){
            String str = sc.next();
            int stream = 1;
            int result = 0;
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c == 'O'){
                    result += stream;
                    stream++;
                }else if(c == 'X'){
                    stream = 1;
                }
            }
            arr[i] =result;
        }
        for(int i=0; i<t; i++){
            System.out.println(arr[i]);
        }
    }
}
