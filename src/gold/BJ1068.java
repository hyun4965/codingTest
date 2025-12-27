package gold;

import java.util.Scanner;

import java.util.*;

public class BJ1068 {
    static int deleteNode;
    static List<Integer>[] tree;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = -1;

        for (int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        deleteNode = sc.nextInt();

        if (deleteNode == root) {
            System.out.println(0);
            return;
        }

        dfs(root);
        System.out.println(count);
    }

    static void dfs(int node) {
        boolean isLeaf = true;

        for (int child : tree[node]) {
            if (child != deleteNode) {
                isLeaf = false;
                dfs(child);
            }
        }

        if (isLeaf) {
            count++;
        }
    }
}