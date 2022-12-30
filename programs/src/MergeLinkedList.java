public class MergeLinkedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // dummy node for referencing new list; avoids NPE too
        ListNode tail = dummy; // pointer that traverse along the input list, starts with dummy

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 == null) { // if remaining data present, just assign to the tail
            tail.next = list2;
        } else {
            tail.next = list1;
        }

        return dummy.next; // return next as dummy was created by us with default value of 0
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

        l1.append(2);
        l1.append(4);

        ListNode l2 = new ListNode(1);

        l2.append(3);
        l2.append(4);
        l2.append(5);

        ListNode l3 = mergeTwoLists(l1, l2);

        while (l3.next != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void append(int data) { //linear time
        if (next == null) {
            next = new ListNode(data);
            return;
        }
        ListNode current = next;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new ListNode(data);
    }
}
