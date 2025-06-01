package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5639 {

    static class Node{
        int value;
        Node left,right;

        Node(int value){
            this.value = value;
        }
        void insert(int newValue) {
            if (newValue < this.value) {
                if (this.left == null) {
                    this.left = new Node(newValue);
                } else {
                    this.left.insert(newValue);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(newValue);
                } else {
                    this.right.insert(newValue);
                }
            }
        }

        void postOrder() {
            if (this.left != null) {
                this.left.postOrder();
            }
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.println(this.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        Node root = null;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int num = Integer.parseInt(input);
            if (root == null) {
                root = new Node(num);
            } else {
                root.insert(num);
            }
        }

        if (root != null) {
            root.postOrder();
        }
    }
}
