package silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //의상수
        int n1 = Integer.parseInt(br.readLine());
        for (int i = 0; i < n1; i++) {
            int n2 = Integer.parseInt(br.readLine());
            Map<String, Integer> clothingMap = new HashMap<>();
            for (int j = 0; j < n2; j++) {
                String input = br.readLine();
                String[] parts = input.split(" ");
                String item = parts[0];
                String category = parts[1];

                clothingMap.put(category, clothingMap.getOrDefault(category, 0) + 1);
            }

            int combinations = 1;
            for (int count : clothingMap.values()) {
                combinations *= (count + 1);
            }
            combinations--;

            System.out.println(combinations);
        }
    }
}