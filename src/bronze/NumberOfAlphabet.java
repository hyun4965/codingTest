package bronze;

import java.util.Scanner;

public class NumberOfAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr =new int[26];
        for (int i=0; i<26;i++){
            arr[i]=0;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                arr[c-'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
