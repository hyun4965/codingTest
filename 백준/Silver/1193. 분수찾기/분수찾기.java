import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int cross_count = 1; 
		
		while (true) {
			if (X <= cross_count) {
				
				if (cross_count % 2 == 1) {
					System.out.print((cross_count - (X - 1)) + "/" + X);
				}else {
					System.out.print(X + "/" + (cross_count - (X - 1)));
				}
				break;
			} else {
				X -= cross_count;
				cross_count++;
			}
		}
	}
}