/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var CircularLinkedList = /** @class */ (function () {
    function CircularLinkedList() {
        /*private*/ this.__size = 0;
        if (this.tail === undefined)
            this.tail = null;
    }
    CircularLinkedList.prototype.size = function () {
        return this.__size;
    };
    CircularLinkedList.prototype.isEmpty = function () {
        return this.__size === 0;
    };
    CircularLinkedList.prototype.peek = function () {
        if (this.isEmpty())
            throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        return this.tail.next.value;
    };
    CircularLinkedList.prototype.addTail = function (value) {
        var temp = new CircularLinkedList.Node(value, null);
        if (this.isEmpty()) {
            this.tail = temp;
            temp.next = temp;
        }
        else {
            temp.next = this.tail.next;
            this.tail.next = temp;
            this.tail = temp;
        }
        this.__size++;
    };
    CircularLinkedList.prototype.addHead = function (value) {
        var temp = new CircularLinkedList.Node(value, null);
        if (this.isEmpty()) {
            this.tail = temp;
            temp.next = temp;
        }
        else {
            temp.next = this.tail.next;
            this.tail.next = temp;
        }
        this.__size++;
    };
    CircularLinkedList.prototype.removeHead = function () {
        if (this.isEmpty()) {
            throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        }
        var value = this.tail.next.value;
        if (this.tail === this.tail.next)
            this.tail = null;
        else
            this.tail.next = this.tail.next.next;
        this.__size--;
        return value;
    };
    CircularLinkedList.prototype.removeNode = function (key) {
        if (this.isEmpty()) {
            return false;
        }
        var prev = this.tail;
        var curr = this.tail.next;
        var head = this.tail.next;
        if (curr.value === key) {
            if (curr === curr.next)
                this.tail = null;
            else
                this.tail.next = this.tail.next.next;
            return true;
        }
        prev = curr;
        curr = curr.next;
        while ((curr !== head)) {
            {
                if (curr.value === key) {
                    if (curr === this.tail)
                        this.tail = prev;
                    prev.next = curr.next;
                    return true;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        ;
        return false;
    };
    CircularLinkedList.prototype.copyListReversed = function () {
        var cl = new CircularLinkedList();
        var curr = this.tail.next;
        var head = curr;
        if (curr != null) {
            cl.addHead(curr.value);
            curr = curr.next;
        }
        while ((curr !== head)) {
            {
                cl.addHead(curr.value);
                curr = curr.next;
            }
        }
        ;
        return cl;
    };
    CircularLinkedList.prototype.copyList = function () {
        var cl = new CircularLinkedList();
        var curr = this.tail.next;
        var head = curr;
        if (curr != null) {
            cl.addTail(curr.value);
            curr = curr.next;
        }
        while ((curr !== head)) {
            {
                cl.addTail(curr.value);
                curr = curr.next;
            }
        }
        ;
        return cl;
    };
    CircularLinkedList.prototype.searchList = function (data) {
        var temp = this.tail;
        for (var i = 0; i < this.__size; i++) {
            {
                if (temp.value === data)
                    return true;
                temp = temp.next;
            }
            ;
        }
        return false;
    };
    CircularLinkedList.prototype.deleteList = function () {
        this.tail = null;
        this.__size = 0;
    };
    CircularLinkedList.prototype.print = function () {
        if (this.isEmpty()) {
            return;
        }
        var temp = this.tail.next;
        while ((temp !== this.tail)) {
            {
                console.info(temp.value + " ");
                temp = temp.next;
            }
        }
        ;
        console.info(temp.value);
    };
    CircularLinkedList.main = function (args) {
        var ll = new CircularLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
    };
    return CircularLinkedList;
}());
CircularLinkedList["__class"] = "CircularLinkedList";
(function (CircularLinkedList) {
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
    CircularLinkedList.Node = Node;
    Node["__class"] = "CircularLinkedList.Node";
})(CircularLinkedList || (CircularLinkedList = {}));
CircularLinkedList.main(null);
