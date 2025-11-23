import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String s = String.valueOf(n);
		int[] arr = new int[s.length()];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = n%10;
			n/=10;
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i= arr.length-1; i>=0;i--) {
			sb.append(arr[i]);
		}
		System.out.print(sb.toString());
	}
}