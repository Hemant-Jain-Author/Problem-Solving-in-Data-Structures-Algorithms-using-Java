/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var DoublyCircularLinkedList = /** @class */ (function () {
    function DoublyCircularLinkedList() {
        /*private*/ this.head = null;
        /*private*/ this.tail = null;
        /*private*/ this.__size = 0;
    }
    DoublyCircularLinkedList.prototype.size = function () {
        return this.__size;
    };
    DoublyCircularLinkedList.prototype.isEmpty = function () {
        return this.__size === 0;
    };
    DoublyCircularLinkedList.prototype.peekHead = function () {
        if (this.isEmpty())
            throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        return this.head.value;
    };
    DoublyCircularLinkedList.prototype.addHead = function (value) {
        var newNode = new DoublyCircularLinkedList.Node(value, null, null);
        if (this.__size === 0) {
            this.tail = this.head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        }
        else {
            newNode.next = this.head;
            newNode.prev = this.head.prev;
            this.head.prev = newNode;
            newNode.prev.next = newNode;
            this.head = newNode;
        }
        this.__size++;
    };
    DoublyCircularLinkedList.prototype.addTail = function (value) {
        var newNode = new DoublyCircularLinkedList.Node(value, null, null);
        if (this.__size === 0) {
            this.head = this.tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        }
        else {
            newNode.next = this.tail.next;
            newNode.prev = this.tail;
            this.tail.next = newNode;
            newNode.next.prev = newNode;
            this.tail = newNode;
        }
        this.__size++;
    };
    DoublyCircularLinkedList.prototype.removeHead = function () {
        if (this.__size === 0)
            throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        var value = this.head.value;
        this.__size--;
        if (this.__size === 0) {
            this.head = null;
            this.tail = null;
            return value;
        }
        var next = this.head.next;
        next.prev = this.tail;
        this.tail.next = next;
        this.head = next;
        return value;
    };
    DoublyCircularLinkedList.prototype.removeTail = function () {
        if (this.__size === 0)
            throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        var value = this.tail.value;
        this.__size--;
        if (this.__size === 0) {
            this.head = null;
            this.tail = null;
            return value;
        }
        var prev = this.tail.prev;
        prev.next = this.head;
        this.head.prev = prev;
        this.tail = prev;
        return value;
    };
    DoublyCircularLinkedList.prototype.isPresent = function (key) {
        var temp = this.head;
        if (this.head == null)
            return false;
        do {
            {
                if (temp.value === key)
                    return true;
                temp = temp.next;
            }
        } while ((temp !== this.head));
        return false;
    };
    DoublyCircularLinkedList.prototype.deleteList = function () {
        this.head = null;
        this.tail = null;
        this.__size = 0;
    };
    DoublyCircularLinkedList.prototype.print = function () {
        if (this.isEmpty()) {
            return;
        }
        var temp = this.head;
        while ((temp !== this.tail)) {
            {
                console.info(temp.value + " ");
                temp = temp.next;
            }
        }
        ;
        console.info(temp.value);
    };
    DoublyCircularLinkedList.main = function (args) {
        var ll = new DoublyCircularLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
    };
    return DoublyCircularLinkedList;
}());
DoublyCircularLinkedList["__class"] = "DoublyCircularLinkedList";
(function (DoublyCircularLinkedList) {
    var Node = /** @class */ (function () {
        function Node(v, nxt, prv) {
            var _this = this;
            if (((typeof v === 'number') || v === null) && ((nxt != null && nxt instanceof DoublyCircularLinkedList.Node) || nxt === null) && ((prv != null && prv instanceof DoublyCircularLinkedList.Node) || prv === null)) {
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
                    _this.next = _this;
                    _this.prev = _this;
                })();
            }
            else
                throw new Error('invalid overload');
        }
        return Node;
    }());
    DoublyCircularLinkedList.Node = Node;
    Node["__class"] = "DoublyCircularLinkedList.Node";
})(DoublyCircularLinkedList || (DoublyCircularLinkedList = {}));
DoublyCircularLinkedList.main(null);
