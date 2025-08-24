import java.util.*;

class Solution {
    static class FileEntry {
        String original;   
        String headLower;  
        int number;        
        int index;         
        
        FileEntry(String original, String headLower, int number, int index) {
            this.original = original;
            this.headLower = headLower;
            this.number = number;
            this.index = index;
        }
    }

    public String[] solution(String[] files) {
        int n = files.length;
        FileEntry[] arr = new FileEntry[n];

        for (int i = 0; i < n; i++) {
            arr[i] = parse(files[i], i);
        }

        Arrays.sort(arr, (a, b) -> {
            int c1 = a.headLower.compareTo(b.headLower);
            if (c1 != 0) return c1;

            int c2 = Integer.compare(a.number, b.number);
            if (c2 != 0) return c2;

            return Integer.compare(a.index, b.index);
        });

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) answer[i] = arr[i].original;
        return answer;
    }

    private FileEntry parse(String file, int idx) {
        int len = file.length();
        int i = 0;

        while (i < len && !Character.isDigit(file.charAt(i))) i++;
        String head = file.substring(0, i);
        String headLower = head.toLowerCase();

        int j = i;
        int count = 0;
        while (j < len && Character.isDigit(file.charAt(j)) && count < 5) {
            j++;
            count++;
        }
        String numStr = file.substring(i, j);

        int number = Integer.parseInt(numStr);

        return new FileEntry(file, headLower, number, idx);
    }
}
