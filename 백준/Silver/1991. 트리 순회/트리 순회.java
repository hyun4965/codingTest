import java.util.*;

class Node {
    char node;
    Node left, right;
    public Node (char node) {
        this.node = node;
    }
}

class Tree {
    
    StringBuilder sb;
    Node root;
    
    public Tree (char node) {
        root = new Node(node);
    }
    
    public void insert (Node parent, char data, char left_data, char right_data) {
        
        if (parent == null) return;
        
        if (parent.node == data) {
            if (left_data != '.')
                parent.left = new Node(left_data);
            if (right_data != '.')
                parent.right = new Node(right_data);
        }
        else {
            insert(parent.left, data, left_data, right_data);
            insert(parent.right, data, left_data, right_data);
        }
    }
    
    public void resetPrintObj () {
    	sb = new StringBuilder();
    }
    public String print () {
    	return String.valueOf(sb);
    }
    
    
    public void preOrder (Node n) {
        
        if (n == null) return;
        
        sb.append(n.node);
        preOrder(n.left);
        preOrder(n.right);
    }
    
    public void inOrder (Node n) {
        
        if (n == null) return;
        
        inOrder(n.left);
        sb.append(n.node);
        inOrder(n.right);
    }
    
    public void postOrder (Node n) {
        
        if (n == null) return;
        
        postOrder(n.left);
        postOrder(n.right);
        sb.append(n.node);
    }
}

public class Main {
    
    public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        Tree tree = new Tree('A');
        
        for (int i=0; i<N; i++)
            tree.insert(tree.root, sc.next().charAt(0), sc.next().charAt(0), sc.next().charAt(0));
        
        tree.resetPrintObj();
        tree.preOrder(tree.root);
        System.out.println(tree.print());
        
        tree.resetPrintObj();
        tree.inOrder(tree.root);
        System.out.println(tree.print());
        
        tree.resetPrintObj();
        tree.postOrder(tree.root);
        System.out.println(tree.print());
       
        
    }
}