/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var DoublyLinkedList = /** @class */ (function () {
    function DoublyLinkedList() {
        /*private*/ this.__size = 0;
        if (this.head === undefined)
            this.head = null;
        if (this.tail === undefined)
            this.tail = null;
    }
    DoublyLinkedList.prototype.size = function () {
        return this.__size;
    };
    DoublyLinkedList.prototype.isEmpty = function () {
        return this.__size === 0;
    };
    DoublyLinkedList.prototype.peek = function () {
        if (this.isEmpty())
            throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        return this.head.value;
    };
    DoublyLinkedList.prototype.addHead = function (value) {
        var newNode = new DoublyLinkedList.Node(value, null, null);
        if (this.__size === 0) {
            this.tail = this.head = newNode;
        }
        else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.__size++;
    };
    DoublyLinkedList.prototype.addTail = function (value) {
        var newNode = new DoublyLinkedList.Node(value, null, null);
        if (this.__size === 0) {
            this.head = this.tail = newNode;
        }
        else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.__size++;
    };
    DoublyLinkedList.prototype.removeHead = function () {
        if (this.isEmpty())
            throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        var value = this.head.value;
        this.head = this.head.next;
        if (this.head == null)
            this.tail = null;
        else
            this.head.prev = null;
        this.__size--;
        return value;
    };
    DoublyLinkedList.prototype.removeNode = function (key) {
        var curr = this.head;
        if (curr == null)
            return false;
        if (curr.value === key) {
            this.head = this.head.next;
            this.__size--;
            if (this.head != null)
                this.head.prev = null;
            else
                this.tail = null;
            return true;
        }
        while ((curr.next != null)) {
            {
                if (curr.next.value === key) {
                    curr.next = curr.next.next;
                    if (curr.next == null)
                        this.tail = curr;
                    else
                        curr.next = curr;
                    this.__size--;
                    return true;
                }
                curr = curr.next;
            }
        }
        ;
        return false;
    };
    DoublyLinkedList.prototype.isPresent = function (key) {
        var temp = this.head;
        while ((temp != null)) {
            {
                if (temp.value === key)
                    return true;
                temp = temp.next;
            }
        }
        ;
        return false;
    };
    DoublyLinkedList.prototype.deleteList = function () {
        this.head = null;
        this.tail = null;
        this.__size = 0;
    };
    DoublyLinkedList.prototype.print = function () {
        var temp = this.head;
        while ((temp != null)) {
            {
                console.info(temp.value + " ");
                temp = temp.next;
            }
        }
        ;
    };
    DoublyLinkedList.prototype.sortedInsert = function (value) {
        var temp = new DoublyLinkedList.Node(value);
        var curr = this.head;
        if (curr == null) {
            this.head = temp;
            this.tail = temp;
        }
        if (this.head.value <= value) {
            temp.next = this.head;
            this.head.prev = temp;
            this.head = temp;
        }
        while ((curr.next != null && curr.next.value > value)) {
            {
                curr = curr.next;
            }
        }
        ;
        if (curr.next == null) {
            this.tail = temp;
            temp.prev = curr;
            curr.next = temp;
        }
        else {
            temp.next = curr.next;
            temp.prev = curr;
            curr.next = temp;
            temp.next.prev = temp;
        }
    };
    DoublyLinkedList.prototype.reverseList = function () {
        var curr = this.head;
        var tempNode;
        while ((curr != null)) {
            {
                tempNode = curr.next;
                curr.next = curr.prev;
                curr.prev = tempNode;
                if (curr.prev == null) {
                    this.tail = this.head;
                    this.head = curr;
                    return;
                }
                curr = curr.prev;
            }
        }
        ;
        return;
    };
    DoublyLinkedList.prototype.removeDuplicate = function () {
        var curr = this.head;
        var deleteMe;
        while ((curr != null)) {
            {
                if ((curr.next != null) && curr.value === curr.next.value) {
                    deleteMe = curr.next;
                    curr.next = deleteMe.next;
                    curr.next.prev = curr;
                    if (deleteMe === this.tail) {
                        this.tail = curr;
                    }
                }
                else {
                    curr = curr.next;
                }
            }
        }
        ;
    };
    DoublyLinkedList.prototype.copyListReversed = function () {
        var dll = new DoublyLinkedList();
        var curr = this.head;
        while ((curr != null)) {
            {
                dll.addHead(curr.value);
                curr = curr.next;
            }
        }
        ;
        return dll;
    };
    DoublyLinkedList.prototype.copyList = function () {
        var dll = new DoublyLinkedList();
        var curr = this.head;
        while ((curr != null)) {
            {
                dll.addTail(curr.value);
                curr = curr.next;
            }
        }
        ;
        return dll;
    };
    DoublyLinkedList.main = function (args) {
        var ll = new DoublyLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.addHead(4);
        ll.addHead(5);
        ll.addHead(6);
        ll.removeHead();
        ll.deleteList();
        ll.print();
        ll.addHead(11);
        ll.addHead(21);
        ll.addHead(31);
        ll.addHead(41);
        ll.addHead(51);
        ll.addHead(61);
        ll.print();
    };
    return DoublyLinkedList;
}());
DoublyLinkedList["__class"] = "DoublyLinkedList";
(function (DoublyLinkedList) {
    var Node = /** @class */ (function () {
        function Node(v, nxt, prv) {
            var _this = this;
            if (((typeof v === 'number') || v === null) && ((nxt != null && nxt instanceof DoublyLinkedList.Node) || nxt === null) && ((prv != null && prv instanceof DoublyLinkedList.Node) || prv === null)) {
                var __args = arguments;
                if (this.value === undefined)
                    this.value = 0;
                if (this.next === undefined)
                    this.next = null;
                if (this.prev === undefined)
                    this.prev = null;
                if (this.value === undefined)
                    this.value = 0;
                if (this.next === undefined)
                    this.next = null;
                if (this.prev === undefined)
                    this.prev = null;
                (function () {
                    _this.value = v;
                    _this.next = nxt;
                    _this.prev = prv;
                })();
            }
            else if (((typeof v === 'number') || v === null) && nxt === undefined && prv === undefined) {
                var __args = arguments;
                if (this.value === undefined)
                    this.value = 0;
                if (this.next === undefined)
                    this.next = null;
                if (this.prev === undefined)
                    this.prev = null;
                if (this.value === undefined)
                    this.value = 0;
                if (this.next === undefined)
                    this.next = null;
                if (this.prev === undefined)
                    this.prev = null;
                (function () {
                    _this.value = v;
                    _this.next = null;
                    _this.prev = null;
                })();
            }
            else
                throw new Error('invalid overload');
        }
        return Node;
    }());
    DoublyLinkedList.Node = Node;
    Node["__class"] = "DoublyLinkedList.Node";
})(DoublyLinkedList || (DoublyLinkedList = {}));
DoublyLinkedList.main(null);
