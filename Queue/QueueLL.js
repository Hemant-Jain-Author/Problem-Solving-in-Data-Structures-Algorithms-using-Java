/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var QueueLL = /** @class */ (function () {
    function QueueLL() {
        /*private*/ this.tail = null;
        /*private*/ this.__size = 0;
    }
    QueueLL.prototype.size = function () {
        return this.__size;
    };
    QueueLL.prototype.isEmpty = function () {
        return this.__size === 0;
    };
    QueueLL.prototype.peek = function () {
        if (this.isEmpty())
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        var value;
        if (this.tail === this.tail.next)
            value = this.tail.value;
        else
            value = this.tail.next.value;
        return value;
    };
    QueueLL.prototype.add = function (value) {
        var temp = new QueueLL.Node(value, null);
        if (this.tail == null) {
            this.tail = temp;
            this.tail.next = this.tail;
        }
        else {
            temp.next = this.tail.next;
            this.tail.next = temp;
            this.tail = temp;
        }
        this.__size++;
    };
    QueueLL.prototype.remove = function () {
        if (this.isEmpty())
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        var value = 0;
        if (this.tail === this.tail.next) {
            value = this.tail.value;
            this.tail = null;
        }
        else {
            value = this.tail.next.value;
            this.tail.next = this.tail.next.next;
        }
        this.__size--;
        return value;
    };
    QueueLL.main = function (args) {
        var q = new QueueLL();
        q.add(1);
        q.add(2);
        q.add(3);
        for (var i = 0; i < 3; i++) {
            console.info(q.remove());
        }
    };
    return QueueLL;
}());
QueueLL["__class"] = "QueueLL";
(function (QueueLL) {
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
    QueueLL.Node = Node;
    Node["__class"] = "QueueLL.Node";
})(QueueLL || (QueueLL = {}));
QueueLL.main(null);
