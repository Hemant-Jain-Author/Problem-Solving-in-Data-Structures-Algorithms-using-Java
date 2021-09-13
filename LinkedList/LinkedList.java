import java.util.HashSet;

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
    
    public boolean search(int data) {
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
    
    public boolean deleteNodes(int delValue) {
        Node currNode = head;
        Node nextNode;
        boolean found = false;
        while (currNode != null && currNode.value == delValue) {  /* first node */
            head = currNode.next;
            currNode = head;
            found = true;
        }
    
        while (currNode != null) {
            nextNode = currNode.next;
            if (nextNode != null && nextNode.value == delValue) {
                currNode.next = nextNode.next;
                found = true;
            } else {
                currNode = nextNode;
            }
        }
        return found;
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
    
        while (head1 != null && head2 != null) {
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
    
    public int nthNodeFromBeginning(int index) {
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
        return nthNodeFromBeginning(startIndex);
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
        tempHead = this.head;
        tempHead2 = head2;
        if (l1 < l2) {
            Node temp = tempHead;
            tempHead = tempHead2;
            tempHead2 = temp;
            diff = l2 - l1;
        } else {
            diff = l1 - l2;
        }
    
        for (; diff > 0; diff--) {
            tempHead = tempHead.next;
        }
        while (tempHead != tempHead2) {
            tempHead = tempHead.next;
            tempHead2 = tempHead2.next;
        }
        return tempHead;
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
        System.out.println("");
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

    public void bubbleSort() {
        Node curr, end = null;
        int temp;
    
        if (head == null || head.next == null) {
            return;
        }
        
        boolean flag = true;
        while(flag) {
            flag = false;
            curr = head;
            while (curr.next != end) {
                if(curr.value > curr.next.value) {
                    flag = true;
                    temp = curr.value;
                    curr.value = curr.next.value;
                    curr.next.value = temp;
                }
                curr = curr.next;
            }
            end = curr;
        }
    }

    public void selectionSort() {
        Node curr, end = null, maxNode;
        int temp, max;
    
        if (head == null || head.next == null) {
            return;
        }
        
        while(head != end) {
            curr = head;
            max = curr.value;
            maxNode = curr;
            while (curr.next != end) {
                if(max < curr.next.value) {
                    maxNode = curr.next;
                    max = curr.next.value;
                }
                curr = curr.next;
            }
            end = curr;
            if(curr.value < max) {
                temp = curr.value;
                curr.value = max;
                maxNode.value = temp;
            }
        }
    }

    public void insertionSort() {
        Node curr, stop;
        int temp;
    
        if (head == null || head.next == null) {
            return;
        }
        
        stop = head.next;
        while(stop != null) {
            curr = head;
            while (curr != stop) {
                if(curr.value > stop.value) {
                    temp = curr.value;
                    curr.value = stop.value;
                    stop.value = temp;
                }
                curr = curr.next;
            }
            stop = stop.next;
        }
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
        Node curr = head;
        HashSet<Node> hs = new HashSet<Node>();
        while (curr != null) {
            if(hs.contains(curr)){
                System.out.println("loop found");
                return true;
            }
            hs.add(curr);
            curr = curr.next;
        }
        System.out.println("loop not found");
        return false;
    }

    public boolean loopDetect2() {
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
    
    public Node loopPointDetect() {
        Node slowPtr;
        Node fastPtr;
        slowPtr = fastPtr = head;
    
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return slowPtr;
            }
        }
        return null;
    }
    
    public void removeLoop() {
        Node loopPoint = loopPointDetect();
        if (loopPoint == null)
            return;
    
        Node firstPtr = head;
        if (loopPoint == head) {
            while (firstPtr.next != head)
                firstPtr = firstPtr.next;
            firstPtr.next = null;
            return;
        }
    
        Node secondPtr = loopPoint;
        while (firstPtr.next != secondPtr.next) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }
        secondPtr.next = null;
    }

    public static void main1() {
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
        System.out.println("Size : " + ll.size());
        System.out.println("Size : " + ll.findLength());
        System.out.println("Is empty : " + ll.isEmpty());
        ll.addTail(4);
        ll.print();
    }
    
    /*
    3 2 1 
    Size : 3
    Size : 3
    Is empty : false
    3 2 1 4 
    */
    
    public static void main2() {
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
        System.out.println("search : " + ll.search(2));
        ll.removeHead();
        ll.print();
    }
    
    /*
    3 2 1 
    search : true
    2 1 
    */ 
    
    public static void main3() {
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(1);
        ll.addHead(3);
        ll.print();
        System.out.println("deleteNode : " + ll.deleteNode(2));
        ll.print();
        System.out.println("deleteNodes : " + ll.deleteNodes(1));
        ll.print();
    }
    
    /*
    3 1 2 1 2 1 
    deleteNode : true
    3 1 1 2 1 
    deleteNodes : true
    3 2 
    */
    
    public static void main4() {
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
    
        ll.reverse();
        ll.print();
    
        ll.reverseRecurse();;
        ll.print();
    
        LinkedList l2 = ll.copyList(); 
        l2.print();
        LinkedList l3 = ll.copyListReversed(); 
        l3.print();
    }
    
    /*
    3 2 1 
    1 2 3 
    3 2 1 
    3 2 1 
    1 2 3 
    */
    
    public static void main5() {
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
    
        LinkedList l2 = ll.copyList(); 
        l2.print(); 
        LinkedList l3 = ll.copyListReversed(); 
        l3.print();
        System.out.println("compareList : " + ll.compareList(l2));
        System.out.println("compareList : " + ll.compareList2(l2));
        System.out.println("compareList : " + ll.compareList(l3));
        System.out.println("compareList : " + ll.compareList2(l3));
    }
    
    /*
    3 2 1 
    3 2 1 
    1 2 3 
    compareList : true
    compareList : true
    compareList : false
    compareList : false
    */
    
    public static void main6() {
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
        System.out.println(ll.nthNodeFromBeginning(2));
        System.out.println(ll.nthNodeFromEnd(2));
        System.out.println(ll.nthNodeFromEnd2(2));
    }
    
    /*
    3 2 1 
    2
    2
    2
    */
    
    public static void main7() {
        LinkedList ll = new LinkedList();
        ll.sortedInsert(1);
        ll.sortedInsert(2);
        ll.sortedInsert(3);
        ll.print();
        ll.sortedInsert(1);
        ll.sortedInsert(2);
        ll.sortedInsert(3);
        ll.print();
        ll.removeDuplicate();;
        ll.print();
    }
    
    /*
    1 2 3 
    1 1 2 2 3 3 
    1 2 3
    */
    
    public static void main8() {
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
        ll.makeLoop();
        ll.loopDetect();
        ll.loopDetect2();
        ll.loopTypeDetect();
        ll.removeLoop();
        ll.loopDetect2();
    }
    
    /*
    3 2 1 
    loop found
    circular list loop found
    loop not found
    */
    
    public static void main9() {
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(2);
        LinkedList ll2 = new LinkedList();
        ll2.addHead(3);
        ll2.head.next = ll.head;
        ll.addHead(4);
        ll2.addHead(5);
        ll.print();
        ll2.print();
        Node nd = ll.findIntersection(ll2);
        if( nd != null)
            System.out.println("Intersection:: " + nd.value);  
    }
    
    /*
    4 2 1 
    5 3 2 1 
    Intersection:: 2
    */
 
    public static void main10() {
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(10);
        ll.addHead(9);
        ll.addHead(7);
        ll.addHead(2);
        ll.addHead(3);
        ll.addHead(5);
        ll.addHead(4);
        ll.addHead(6);
        ll.addHead(8);
        ll.print();
//        ll.bubbleSort();
//ll.selectionSort();
ll.insertionSort();
        ll.print();
    }

    public static void main(String[] args) {
/*        main1();
        main2();
        main3();
        main4();
        main5();
        main6();
        main7();
        */ 
        main8(); 
      /*  main9();
        main10();*/
    }
}