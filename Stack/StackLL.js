/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var StackLL = /** @class */ (function () {
    function StackLL() {
        /*private*/ this.head = null;
        /*private*/ this.__size = 0;
    }
    StackLL.prototype.size = function () {
        return this.__size;
    };
    StackLL.prototype.isEmpty = function () {
        return this.__size === 0;
    };
    StackLL.prototype.peek = function () {
        if (this.isEmpty()) {
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        }
        return this.head.value;
    };
    StackLL.prototype.push = function (value) {
        this.head = new StackLL.Node(value, this.head);
        this.__size++;
    };
    StackLL.prototype.pop = function () {
        if (this.isEmpty()) {
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        }
        var value = this.head.value;
        this.head = this.head.next;
        this.__size--;
        return value;
    };
    StackLL.prototype.insertAtBottom = function (value) {
        if (this.isEmpty()) {
            this.push(value);
        }
        else {
            var temp = this.pop();
            this.insertAtBottom(value);
            this.push(temp);
        }
    };
    StackLL.prototype.print = function () {
        var temp = this.head;
        while ((temp != null)) {
            {
                console.info(temp.value + " ");
                temp = temp.next;
            }
        }
        ;
    };
    StackLL.main = function (args) {
        var s = new StackLL();
        s.push(1);
        s.push(2);
        s.push(3);
        s.print();
        console.info(s.pop());
        console.info(s.pop());
        s.print();
    };
    return StackLL;
}());
StackLL["__class"] = "StackLL";
(function (StackLL) {
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
    StackLL.Node = Node;
    Node["__class"] = "StackLL.Node";
})(StackLL || (StackLL = {}));
StackLL.main(null);
