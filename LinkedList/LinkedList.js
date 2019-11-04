/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var LinkedList = /** @class */ (function () {
    function LinkedList() {
        /*private*/ this.__size = 0;
        if (this.head === undefined)
            this.head = null;
    }
    LinkedList.prototype.size = function () {
        return this.__size;
    };
    LinkedList.prototype.isEmpty = function () {
        return this.__size === 0;
    };
    LinkedList.prototype.peek = function () {
        if (this.isEmpty())
            throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        return this.head.value;
    };
    LinkedList.prototype.addHead = function (value) {
        this.head = new LinkedList.Node(value, this.head);
        this.__size++;
    };
    LinkedList.prototype.addTail = function (value) {
        var newNode = new LinkedList.Node(value, null);
        var curr = this.head;
        if (this.head == null) {
            this.head = newNode;
        }
        while ((curr.next != null)) {
            {
                curr = curr.next;
            }
        }
        ;
        curr.next = newNode;
    };
    LinkedList.prototype.removeHead = function () {
        if (this.isEmpty())
            throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        var value = this.head.value;
        this.head = this.head.next;
        this.__size--;
        return value;
    };
    LinkedList.prototype.searchList = function (data) {
        var temp = this.head;
        while ((temp != null)) {
            {
                if (temp.value === data)
                    return true;
                temp = temp.next;
            }
        }
        ;
        return false;
    };
    LinkedList.prototype.deleteNode = function (delValue) {
        var temp = this.head;
        if (this.isEmpty())
            return false;
        if (delValue === this.head.value) {
            this.head = this.head.next;
            this.__size--;
            return true;
        }
        while ((temp.next != null)) {
            {
                if (temp.next.value === delValue) {
                    temp.next = temp.next.next;
                    this.__size--;
                    return true;
                }
                temp = temp.next;
            }
        }
        ;
        return false;
    };
    LinkedList.prototype.deleteNodes = function (delValue) {
        var currNode = this.head;
        var nextNode;
        while ((currNode != null && currNode.value === delValue)) {
            {
                this.head = currNode.next;
                currNode = this.head;
            }
        }
        ;
        while ((currNode != null)) {
            {
                nextNode = currNode.next;
                if (nextNode != null && nextNode.value === delValue) {
                    currNode.next = nextNode.next;
                }
                else {
                    currNode = nextNode;
                }
            }
        }
        ;
    };
    LinkedList.prototype.reverseRecurseUtil = function (currentNode, nextNode) {
        var ret;
        if (currentNode == null)
            return null;
        if (currentNode.next == null) {
            currentNode.next = nextNode;
            return currentNode;
        }
        ret = this.reverseRecurseUtil(currentNode.next, currentNode);
        currentNode.next = nextNode;
        return ret;
    };
    LinkedList.prototype.reverseRecurse = function () {
        this.head = this.reverseRecurseUtil(this.head, null);
    };
    LinkedList.prototype.reverse = function () {
        var curr = this.head;
        var prev = null;
        var next = null;
        while ((curr != null)) {
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }
        ;
        this.head = prev;
    };
    LinkedList.prototype.copyListReversed = function () {
        var tempNode = null;
        var tempNode2 = null;
        var curr = this.head;
        while ((curr != null)) {
            {
                tempNode2 = new LinkedList.Node(curr.value, tempNode);
                curr = curr.next;
                tempNode = tempNode2;
            }
        }
        ;
        var ll2 = new LinkedList();
        ll2.head = tempNode;
        return ll2;
    };
    LinkedList.prototype.copyList = function () {
        var headNode = null;
        var tailNode = null;
        var tempNode = null;
        var curr = this.head;
        if (curr == null)
            return null;
        headNode = new LinkedList.Node(curr.value, null);
        tailNode = headNode;
        curr = curr.next;
        while ((curr != null)) {
            {
                tempNode = new LinkedList.Node(curr.value, null);
                tailNode.next = tempNode;
                tailNode = tempNode;
                curr = curr.next;
            }
        }
        ;
        var ll2 = new LinkedList();
        ll2.head = headNode;
        return ll2;
    };
    LinkedList.prototype.compareList$LinkedList = function (ll) {
        return this.compareList$LinkedList_Node$LinkedList_Node(this.head, ll.head);
    };
    LinkedList.prototype.compareList$LinkedList_Node$LinkedList_Node = function (head1, head2) {
        if (head1 == null && head2 == null)
            return true;
        else if ((head1 == null) || (head2 == null) || (head1.value !== head2.value))
            return false;
        else
            return this.compareList$LinkedList_Node$LinkedList_Node(head1.next, head2.next);
    };
    LinkedList.prototype.compareList = function (head1, head2) {
        if (((head1 != null && head1 instanceof LinkedList.Node) || head1 === null) && ((head2 != null && head2 instanceof LinkedList.Node) || head2 === null)) {
            return this.compareList$LinkedList_Node$LinkedList_Node(head1, head2);
        }
        else if (((head1 != null && head1 instanceof LinkedList) || head1 === null) && head2 === undefined) {
            return this.compareList$LinkedList(head1);
        }
        else
            throw new Error('invalid overload');
    };
    LinkedList.prototype.compareList2 = function (ll2) {
        var head1 = this.head;
        var head2 = ll2.head;
        while ((head1 == null && head2 == null)) {
            {
                if (head1.value !== head2.value)
                    return false;
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        ;
        if (head1 == null && head2 == null)
            return true;
        return false;
    };
    LinkedList.prototype.findLength = function () {
        var curr = this.head;
        var count = 0;
        while ((curr != null)) {
            {
                count++;
                curr = curr.next;
            }
        }
        ;
        return count;
    };
    LinkedList.prototype.nthNodeFromBegining = function (index) {
        if (index > this.size() || index < 1)
            return 2147483647;
        var count = 0;
        var curr = this.head;
        while ((curr != null && count < index - 1)) {
            {
                count++;
                curr = curr.next;
            }
        }
        ;
        return curr.value;
    };
    LinkedList.prototype.nthNodeFromEnd = function (index) {
        var size = this.findLength();
        var startIndex;
        if (size !== 0 && size < index) {
            return 2147483647;
        }
        startIndex = size - index + 1;
        return this.nthNodeFromBegining(startIndex);
    };
    LinkedList.prototype.nthNodeFromEnd2 = function (index) {
        var count = 1;
        var forward = this.head;
        var curr = this.head;
        while ((forward != null && count <= index)) {
            {
                count++;
                forward = forward.next;
            }
        }
        ;
        if (forward == null)
            return 2147483647;
        while ((forward != null)) {
            {
                forward = forward.next;
                curr = curr.next;
            }
        }
        ;
        return curr.value;
    };
    LinkedList.prototype.findIntersection = function (lst2) {
        var head2 = lst2.head;
        var l1 = 0;
        var l2 = 0;
        var tempHead = this.head;
        var tempHead2 = head2;
        while ((tempHead != null)) {
            {
                l1++;
                tempHead = tempHead.next;
            }
        }
        ;
        while ((tempHead2 != null)) {
            {
                l2++;
                tempHead2 = tempHead2.next;
            }
        }
        ;
        var diff;
        if (l1 < 12) {
            var temp = this.head;
            this.head = head2;
            head2 = temp;
            diff = l2 - l1;
        }
        else {
            diff = l1 - l2;
        }
        for (; diff > 0; diff--) {
            {
                this.head = this.head.next;
            }
            ;
        }
        while ((this.head !== head2)) {
            {
                this.head = this.head.next;
                head2 = head2.next;
            }
        }
        ;
        return this.head;
    };
    LinkedList.prototype.deleteList = function () {
        this.head = null;
        this.__size = 0;
    };
    LinkedList.prototype.print = function () {
        var temp = this.head;
        while ((temp != null)) {
            {
                console.info(temp.value + " ");
                temp = temp.next;
            }
        }
        ;
    };
    LinkedList.prototype.sortedInsert = function (value) {
        var newNode = new LinkedList.Node(value, null);
        var curr = this.head;
        if (curr == null || curr.value > value) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }
        while ((curr.next != null && curr.next.value < value)) {
            {
                curr = curr.next;
            }
        }
        ;
        newNode.next = curr.next;
        curr.next = newNode;
    };
    LinkedList.prototype.removeDuplicate = function () {
        var curr = this.head;
        while ((curr != null)) {
            {
                if (curr.next != null && curr.value === curr.next.value) {
                    curr.next = curr.next.next;
                }
                else {
                    curr = curr.next;
                }
            }
        }
        ;
    };
    LinkedList.prototype.makeLoop = function () {
        var temp = this.head;
        while ((temp != null)) {
            {
                if (temp.next == null) {
                    temp.next = this.head;
                    return;
                }
                temp = temp.next;
            }
        }
        ;
    };
    LinkedList.prototype.loopDetect = function () {
        var slowPtr;
        var fastPtr;
        slowPtr = fastPtr = this.head;
        while ((fastPtr.next != null && fastPtr.next.next != null)) {
            {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
                if (slowPtr === fastPtr) {
                    console.info("loop found");
                    return true;
                }
            }
        }
        ;
        console.info("loop not found");
        return false;
    };
    LinkedList.prototype.reverseListLoopDetect = function () {
        var tempHead = this.head;
        this.reverse();
        if (tempHead === this.head) {
            this.reverse();
            console.info("loop found");
            return true;
        }
        else {
            this.reverse();
            console.info("loop not found");
            return false;
        }
    };
    LinkedList.prototype.loopTypeDetect = function () {
        var slowPtr;
        var fastPtr;
        slowPtr = fastPtr = this.head;
        while ((fastPtr.next != null && fastPtr.next.next != null)) {
            {
                if (this.head === fastPtr.next || this.head === fastPtr.next.next) {
                    console.info("circular list loop found");
                    return 2;
                }
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
                if (slowPtr === fastPtr) {
                    console.info("loop found");
                    return 1;
                }
            }
        }
        ;
        console.info("loop not found");
        return 0;
    };
    LinkedList.main = function (args) {
        var ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(2);
        var nd = ll.head;
        ll.addHead(3);
        var ll2 = new LinkedList();
        ll2.addHead(1);
        ll2.head.next = nd;
        ll2.addHead(2);
        ll2.addHead(3);
        ll2.print();
        console.info((ll.findIntersection(ll2)).value);
    };
    return LinkedList;
}());
LinkedList["__class"] = "LinkedList";
(function (LinkedList) {
    var Node = /** @class */ (function () {
        function Node(v, n) {
            if (this.value === undefined)
                this.value = 0;
            if (this.next === undefined)
                this.next = null;
            this.value = v;
            this.next = n;
        }
        return Node;
    }());
    LinkedList.Node = Node;
    Node["__class"] = "LinkedList.Node";
})(LinkedList || (LinkedList = {}));
LinkedList.main(null);
