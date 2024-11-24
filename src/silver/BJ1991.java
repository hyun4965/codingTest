package silver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ1991 {
    static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BinaryTree tree = new BinaryTree();

        for (int i = 0; i < N; i++) {
            char parent = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);
            tree.addNode(parent, left, right);
        }

        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();

        tree.preorder(tree.nodes.get('A'), pre);
        tree.inorder(tree.nodes.get('A'), in);
        tree.postorder(tree.nodes.get('A'), post);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static class BinaryTree {
        Map<Character, Node> nodes = new HashMap<>();

        void addNode(char parent, char left, char right) {
            Node parentNode = nodes.computeIfAbsent(parent, k -> new Node(parent));
            if (left != '.') {
                parentNode.left = nodes.computeIfAbsent(left, k -> new Node(left));
            }
            if (right != '.') {
                parentNode.right = nodes.computeIfAbsent(right, k -> new Node(right));
            }
        }

        void preorder(Node node, StringBuilder sb) {
            if (node == null) return;
            sb.append(node.data);
            preorder(node.left, sb);
            preorder(node.right, sb);
        }

        void inorder(Node node, StringBuilder sb) {
            if (node == null) return;
            inorder(node.left, sb);
            sb.append(node.data);
            inorder(node.right, sb);
        }

        void postorder(Node node, StringBuilder sb) {
            if (node == null) return;
            postorder(node.left, sb);
            postorder(node.right, sb);
            sb.append(node.data);
        }
    }

}
