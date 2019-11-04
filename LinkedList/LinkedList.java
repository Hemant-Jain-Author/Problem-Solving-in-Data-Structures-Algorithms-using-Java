public class LinkedList {
    private static class Node {
        private int value;
        private Node next;

        public Node(int v, Node n) {
            value = v;
            next = n;
        }
    }

    private Node head;
    private int size = 0;

    // Other Methods.
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Other Methods.

    public int peek() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("EmptyListException");
        return head.value;
    }

    public void addHead(int value) {
        head = new Node(value, head);
        size++;
    }

    public void addTail(int value) {
        Node newNode = new Node(value, null);
        Node curr = head;

        if (head == null) {
            head = newNode;
        }

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public int removeHead() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("EmptyListException");
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public boolean searchList(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public boolean deleteNode(int delValue) {
        Node temp = head;

        if (isEmpty())
            return false;

        if (delValue == head.value) {
            head = head.next;
            size--;
            return true;
        }

        while (temp.next != null) {
            if (temp.next.value == delValue) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void deleteNodes(int delValue) {
        Node currNode = head;
        Node nextNode;

        while (currNode != null && currNode.value == delValue)/* first node */
        {
            head = currNode.next;
            currNode = head;
        }

        while (currNode != null) {
            nextNode = currNode.next;
            if (nextNode != null && nextNode.value == delValue) {
                currNode.next = nextNode.next;
            } else {
                currNode = nextNode;
            }
        }
    }

    public Node reverseRecurseUtil(Node currentNode, Node nextNode) {
        Node ret;
        if (currentNode == null)
            return null;
        if (currentNode.next == null) {
            currentNode.next = nextNode;
            return currentNode;
        }

        ret = reverseRecurseUtil(currentNode.next, currentNode);
        currentNode.next = nextNode;
        return ret;
    }

    public void reverseRecurse() {
        head = reverseRecurseUtil(head, null);
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public LinkedList copyListReversed() {
        Node tempNode = null;
        Node tempNode2 = null;
        Node curr = head;
        while (curr != null) {
            tempNode2 = new Node(curr.value, tempNode);
            curr = curr.next;
            tempNode = tempNode2;
        }
        LinkedList ll2 = new LinkedList();
        ll2.head = tempNode;
        return ll2;
    }

    public LinkedList copyList() {
        Node headNode = null;
        Node tailNode = null;
        Node tempNode = null;
        Node curr = head;

        if (curr == null)
            return null;

        headNode = new Node(curr.value, null);
        tailNode = headNode;
        curr = curr.next;

        while (curr != null) {
            tempNode = new Node(curr.value, null);
            tailNode.next = tempNode;
            tailNode = tempNode;
            curr = curr.next;
        }
        LinkedList ll2 = new LinkedList();
        ll2.head = headNode;
        return ll2;
    }

    public boolean compareList(LinkedList ll) {
        return compareList(head, ll.head);
    }

    public boolean compareList(Node head1, Node head2) {
        if (head1 == null && head2 == null)
            return true;
        else if ((head1 == null) || (head2 == null) || (head1.value != head2.value))
            return false;
        else
            return compareList(head1.next, head2.next);
    }

public boolean compareList2(LinkedList ll2) {
    Node head1 = head;
    Node head2 = ll2.head;

    while (head1 == null && head2 == null) {
        if (head1.value != head2.value)
            return false;
        head1 = head1.next;
        head2 = head2.next;
    }

    if (head1 == null && head2 == null)
        return true;
    return false;
}

    public int findLength() {
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public int nthNodeFromBegining(int index) {
        if (index > size() || index < 1)
            return Integer.MAX_VALUE;
        int count = 0;
        Node curr = head;
        while (curr != null && count < index - 1) {
            count++;
            curr = curr.next;
        }
        return curr.value;
    }

    public int nthNodeFromEnd(int index) {
        int size = findLength();
        int startIndex;
        if (size != 0 && size < index) {
            return Integer.MAX_VALUE;
        }
        startIndex = size - index + 1;
        return nthNodeFromBegining(startIndex);
    }

    public int nthNodeFromEnd2(int index) {
        int count = 1;
        Node forward = head;
        Node curr = head;
        while (forward != null && count <= index) {
            count++;
            forward = forward.next;
        }

        if (forward == null)
            return Integer.MAX_VALUE;

        while (forward != null) {
            forward = forward.next;
            curr = curr.next;
        }
        return curr.value;
    }

    public Node findIntersection(LinkedList lst2) {
        Node head2 = lst2.head;
        int l1 = 0;
        int l2 = 0;
        Node tempHead = this.head;
        Node tempHead2 = head2;
        while (tempHead != null) {
            l1++;
            tempHead = tempHead.next;
        }
        while (tempHead2 != null) {
            l2++;
            tempHead2 = tempHead2.next;
        }

        int diff;
        if (l1 < 12) {
            Node temp = head;
            head = head2;
            head2 = temp;
            diff = l2 - l1;
        } else {
            diff = l1 - l2;
        }

        for (; diff > 0; diff--) {
            head = head.next;
        }
        while (head != head2) {
            head = head.next;
            head2 = head2.next;
        }
        return head;
    }

    public void deleteList() {
        head = null;
        size = 0;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void sortedInsert(int value) {
        Node newNode = new Node(value, null);
        Node curr = head;

        if (curr == null || curr.value > value) {
            newNode.next = head;
            head = newNode;
            return;
        }
        while (curr.next != null && curr.next.value < value) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void removeDuplicate() {
        Node curr = head;
        while (curr != null) {
            if (curr.next != null && curr.value == curr.next.value) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    public void makeLoop() {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                temp.next = head;
                return;
            }
            temp = temp.next;
        }
    }

    public boolean loopDetect() {
        Node slowPtr;
        Node fastPtr;
        slowPtr = fastPtr = head;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                System.out.println("loop found");
                return true;
            }
        }
        System.out.println("loop not found");
        return false;
    }

    public boolean reverseListLoopDetect() {
        Node tempHead = head;
        reverse();
        if (tempHead == head) {
            reverse();
            System.out.println("loop found");
            return true;
        } else {
            reverse();
            System.out.println("loop not found");
            return false;
        }
    }

    public int loopTypeDetect() {
        Node slowPtr;
        Node fastPtr;
        slowPtr = fastPtr = head;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            if (head == fastPtr.next || head == fastPtr.next.next) {
                System.out.println("circular list loop found");
                return 2;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                System.out.println("loop found");

                return 1;
            }
        }
        System.out.println("loop not found");
        return 0;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(2);
        Node nd = ll.head;
        ll.addHead(3);
        LinkedList ll2 = new LinkedList();
        ll2.addHead(1);
        ll2.head.next = nd;
        ll2.addHead(2);
        ll2.addHead(3);
        ll2.print();

        System.out.println((ll.findIntersection(ll2)).value);
        /*
         * LinkedList l2 = ll.copyList(); l2.print(); LinkedList l3 =
         * ll.CopyListReversed(); l3.print()
         * 
         * System.out.println(ll.nthNodeFromBegining(2));
         * System.out.println(ll.nthNodeFromEnd(2));
         * System.out.println(ll.nthNodeFromEnd2(2));
         */
    }
}