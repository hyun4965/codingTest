package gold;

import java.util.*;

public class BJ2263 {
    static int n;
    static int[] inorder;
    static int[] postorder;
    static int[] position;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        inorder = new int[n + 1];
        postorder = new int[n + 1];
        position = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            inorder[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            postorder[i] = sc.nextInt();
        }

        // inorder에서 각 값의 인덱스 저장
        for (int i = 1; i <= n; i++) {
            position[inorder[i]] = i;
        }

        preorder(1, n, 1, n);
        System.out.println(sb);
    }


    static void preorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int root = postorder[postEnd];
        sb.append(root).append(" ");

        int rootIndex = position[root];
        int leftSize = rootIndex - inStart;

        preorder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);

        preorder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}
