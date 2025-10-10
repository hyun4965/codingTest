import java.util.*;

class Node {
    public int value; 
    public int x;
    public int y;
    public Node right;
    public Node left;

    public Node(int value, int x, int y, Node right, Node left) {
        this.value = value;
        this.x = x;
        this.y = y;
        this.right = right;
        this.left = left;
    }
}

class Solution {

    int[][] result; 
    int index = 0;  

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if (a.y == b.y) {
                    return a.x - b.x;
                }
                return b.y - a.y;               
            }
        });

        Node root = nodes[0];
        for (int i = 1; i < n; i++) {
            makeTree(root, nodes[i]);
        }

        result = new int[2][n];

        index = 0;
        preorder(root);

        index = 0;
        postorder(root);

        return result;
    }

    public void makeTree(Node parent, Node child) {
        if (child.x > parent.x) { 
            if (parent.right == null) {
                parent.right = child;
            } else {
                makeTree(parent.right, child);
            }
        } else { 
            if (parent.left == null) {
                parent.left = child;
            } else {
                makeTree(parent.left, child);
            }
        }
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        result[0][index++] = root.value;
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        result[1][index++] = root.value;
    }
}
