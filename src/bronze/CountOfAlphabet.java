package bronze;

import java.util.Scanner;

public class CountOfAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr =new int[26];
        for (int i=0; i<26;i++){
            arr[i]=-1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (arr[c - 'a'] == -1) {
                    arr[c - 'a'] = i;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
