public class LinkedList {
    static class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }

        Node next;
    }

    static Node head;
    static Node temp;

    static void insertBack(int value) {
        Node n = new Node(value);
        if (head == null) head = n;
        else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    static void insertFront(int value) {
        Node n = new Node(value);
        temp = head;
        head = n;
        head.next = temp;
    }

    static void insertMiddleAfter(int value, int k) {
        Node n = new Node(value);
        temp = head;
        while (temp.value != k) {
            temp = temp.next;
        }
        Node temp1 = temp.next;
        n.next = temp1;
        temp.next = n;
    }

    static void insertMiddleBefore(int value, int k) {
        Node n = new Node(value);
        temp = head;
        while (temp.next.value != k) {
            temp = temp.next;
        }

        Node temp1 = temp.next;
        temp.next = n;
        n.next = temp1;
    }


    static void reversePrinting(Node temp) { /*Printing the array in reverse but not making any changes to the array using recursive method*/
        if (temp != null) {
            reversePrinting(temp.next);
            System.out.println(temp.value);
        }
    }

    public static void reverseLink() { /*changing the array Reversing a linked List*/
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }


    public static void main(String args[]) {
        for (int i = 0; i < 4; i++) {
            insertBack(i);
        }
        for (int i = -1; i > -4; i--) {
            insertFront(i);
        }

        reverseLink();
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }


    }
}
