public class StackUsingLinkedList {
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek()); // 3

        stack.pop();

        System.out.println(stack.peek()); // 2

        stack.push(4);

        System.out.println(stack.peek()); // 4
    }

    private Node head;

    public StackUsingLinkedList() {
        this.head = null;
    }

    public void prepend(int value) {
        Node newHead = new Node(value);

        newHead.next = head; //update the next pointer of new head to point the current head
        head = newHead; // update the head pointer to point to the new node
    }

    public void deleteFromTop() {
        if (isEmpty()) {
            return;
        }
        
        head = head.next;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        Node current = head; // this is required inorder to maintain the root node to be marked as
        // head node, otherwise head node will point to the last inserted item

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void pop() {
        if (isEmpty()) return;

        if (head.next == null) { // if single element
            head = null;
            return;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
