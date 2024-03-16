public class MyLinkedList {
    Node head;

    void append(int data) { //linear time
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
    }

    public void prepend(int data) { // O(1) time
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null) return;
        if (data == head.data) { // if data equals head, need to handle explicitly
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (data == current.next.data) {
                current.next = current.next.next;
                return;
            }
            current = current.next; // else keep on walking
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("no data");
            return;
        }
        Node current = head;
        System.out.println(current.data);

        while (current.next != null) {
            current = current.next;
            System.out.println(current.data);
        }
    }

    public void print_recursively() {
        Node current = head;
        print_rec(current);
    }

    private void print_rec(Node current) {
        if (current == null) {
            return;
        }

        System.out.println(current.data);

        if (current.next == null) {
            return;
        }

        print_rec(current.next);
    }

    public int findNthNodeFromEnd(int n) {
        if (head == null) {
            return -1;
        }

        int count = 1;

        Node current = head;

        while (current.next != null) {
            current = current.next;
            count++;
        }

        System.out.println(count);

        int searchNodeIndex = count - n; // 5 - 4 = 1

        if (searchNodeIndex > 0) {

        }

        return -1;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.append(4);
        list.append(5);
        list.append(2);
        list.append(3);
        list.append(8);

        System.out.println(list.findNthNodeFromEnd(4));

//        list.print_recursively();
//
//        list.deleteWithValue(4);
//        list.prepend(9);
//
//        System.out.println("after delete");
//
//        list.print();
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
