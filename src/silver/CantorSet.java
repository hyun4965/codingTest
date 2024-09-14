package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CantorSet {
    private static void generateCantorSet(char[] array, int start, int end, int depth) {
        if (depth == 0) return;

        int third = (end - start + 1) / 3;
        int middleStart = start + third;
        int middleEnd = middleStart + third - 1;

        for (int i = middleStart; i <= middleEnd; i++) {
            array[i] = ' ';
        }

        // Recursively process the left and right thirds
        generateCantorSet(array, start, middleStart - 1, depth - 1);
        generateCantorSet(array, middleEnd + 1, end, depth - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputs = new ArrayList<>();
        String line;

        // Read all input lines
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            inputs.add(Integer.parseInt(line.trim()));
        }

        for (int N : inputs) {
            if (N < 0 || N > 12) continue; // Skip invalid inputs

            int length = (int) Math.pow(3, N);
            char[] array = new char[length];
            for (int i = 0; i < length; i++) {
                array[i] = '-';
            }

            generateCantorSet(array, 0, length - 1, N);

            // Output the result
            System.out.println(new String(array));
        }
    }
}
