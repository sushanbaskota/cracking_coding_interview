import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    Node right;
    Node left;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

class BFSTree {
    Node root;

    void bfsOrLevelOrderTraversal() {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.print(current.data + " ");

            // this order matters L -> R
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    /**
     * inorder - L N R (ascending order)
     * preorder - N L R
     * postorder -L R N
     */
    void dfsOrPostOrderTraversal() {
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            System.out.print(current.data + " ");

            // this order matters L -> R, usually we go L then R
            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }


    /**
     * print tree for visualization
     *
     * @param node
     * @param depth
     */
    void printTree(Node node, int depth) {
        if (node == null) {
            return;
        }

        printTree(node.right, depth + 1);

        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }

        System.out.println(node.data);

        printTree(node.left, depth + 1);
    }

    public static void main(String[] args) {
        Node node = new Node(15);

        node.left = new Node(12);
        node.left.left = new Node(10);
        node.left.right = new Node(13);

        node.right = new Node(18);
        node.right.left = new Node(16);
        node.right.right = new Node(19);

        BFSTree bfsTree = new BFSTree();

        bfsTree.printTree(node, 2);

        System.out.println();

        bfsTree.root = node;

        bfsTree.bfsOrLevelOrderTraversal();

        System.out.println();

        bfsTree.dfsOrPostOrderTraversal();
    }
}
