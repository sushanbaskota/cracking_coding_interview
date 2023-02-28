public class MyBinarySearchTree {
    private class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }

        public String toString() {
            return "L -> " + left + " R -> " + right + " Data -> " + data;
        }
    }

    private Node root;

    /**
     * Insert
     *
     * @param value
     */
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value <= current.data) {
            current.left = insertRecursive(current.left, value);
        } else {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    /**
     * Search
     *
     * @param value
     * @return
     */
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (current.data == value) {
            return true;
        } else if (value < current.data) {
            return searchRecursive(current.left, value);
        }

        return searchRecursive(current.right, value);
    }

    /**
     * In order Traversal: Left -> Root -> Right [prints in ascending order]
     */
    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
    }

    private void inOrderTraversalRecursive(Node current) {
        if (current != null) {
            inOrderTraversalRecursive(current.left);
            System.out.print(" " + current.data);
            inOrderTraversalRecursive(current.right);
        }
    }

    /**
     * Pre Order Traversal: Root -> Left -> Right
     */
    public void preOrderTraversal() {
        preOrderTraversalRecursive(root);
    }

    private void preOrderTraversalRecursive(Node current) {
        if (current != null) {
            System.out.print(" " + current.data);
            preOrderTraversalRecursive(current.left);
            preOrderTraversalRecursive(current.right);
        }
    }

    /**
     * Post Order Traversal: Left -> Right -> Root
     */
    public void postOrderTraversal() {
        postOrderTraversalRecursive(root);
    }

    private void postOrderTraversalRecursive(Node current) {
        if (current != null) {
            postOrderTraversalRecursive(current.left);
            postOrderTraversalRecursive(current.right);
            System.out.print(" " + current.data);
        }
    }

    private int closestValue(int target) {
        return closestInOrder(root, target, root.data);
    }

    private int closestInOrder(Node current, int target, int closest) {
        if (current != null) {
            closestInOrder(current.left, target, closest);
            if (current.data == target) {
                return closest;
            }
            closestInOrder(current.right, target, closest);
        }

        return closest;
    }

    public String toString() {
        return "Root -> " + root;
    }

    public static void main(String[] args) {
        MyBinarySearchTree bt = new MyBinarySearchTree();

        bt.insert(6);
        bt.insert(4);
        bt.insert(8);
        bt.insert(3);
        bt.insert(5);
        bt.insert(7);
        bt.insert(9);

        System.out.println(bt.closestValue(10));

//        System.out.println(bt.search(5));
//        System.out.println(bt.search(1));
//
//        bt.inOrderTraversal();
//        System.out.println();
//
//        bt.preOrderTraversal();
//        System.out.println();
//
//        bt.postOrderTraversal();
    }
}
