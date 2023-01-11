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

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.append(4);
        list.append(5);
        list.append(2);
        list.append(3);
        list.append(8);

        list.print();

        list.deleteWithValue(4);
        list.prepend(9);

        System.out.println("after delete");

        list.print();
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
