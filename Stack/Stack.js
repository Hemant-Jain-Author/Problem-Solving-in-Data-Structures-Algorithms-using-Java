/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var Stack = /** @class */ (function () {
    function Stack(size) {
        var _this = this;
        /*private*/ this.capacity = 1000;
        /*private*/ this.__top = -1;
        if (((typeof size === 'number') || size === null)) {
            var __args = arguments;
            if (this.data === undefined)
                this.data = null;
            this.capacity = 1000;
            this.__top = -1;
            if (this.data === undefined)
                this.data = null;
            (function () {
                _this.data = (function (s) { var a = []; while (s-- > 0)
                    a.push(0); return a; })(size);
                _this.capacity = size;
            })();
        }
        else if (size === undefined) {
            var __args = arguments;
            if (this.data === undefined)
                this.data = null;
            this.capacity = 1000;
            this.__top = -1;
            if (this.data === undefined)
                this.data = null;
            (function () {
                _this.data = (function (s) { var a = []; while (s-- > 0)
                    a.push(0); return a; })(_this.capacity);
            })();
        }
        else
            throw new Error('invalid overload');
    }
    Stack.prototype.size = function () {
        return (this.__top + 1);
    };
    Stack.prototype.isEmpty = function () {
        return (this.__top === -1);
    };
    Stack.prototype.push = function (value) {
        if (this.size() === this.data.length) {
            throw Object.defineProperty(new Error("StackOvarflowException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        }
        this.__top++;
        this.data[this.__top] = value;
    };
    Stack.prototype.top = function () {
        if (this.isEmpty()) {
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        }
        return this.data[this.__top];
    };
    Stack.prototype.pop = function () {
        if (this.isEmpty()) {
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        }
        var topVal = this.data[this.__top];
        this.__top--;
        return topVal;
    };
    Stack.prototype.print = function () {
        for (var i = this.__top; i > -1; i--) {
            {
                console.info(this.data[i] + " ");
            }
            ;
        }
        console.info("");
    };
    Stack.main = function (args) {
        var s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.print();
        console.info(s.pop());
        console.info(s.pop());
        s.print();
    };
    return Stack;
}());
Stack["__class"] = "Stack";
Stack.main(null);
