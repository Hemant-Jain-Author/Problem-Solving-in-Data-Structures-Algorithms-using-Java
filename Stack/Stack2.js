/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var Stack2 = /** @class */ (function () {
    function Stack2(size) {
        var _this = this;
        /*private*/ this.__top = -1;
        if (((typeof size === 'number') || size === null)) {
            var __args = arguments;
            if (this.data === undefined)
                this.data = null;
            if (this.minCapacity === undefined)
                this.minCapacity = 0;
            if (this.capacity === undefined)
                this.capacity = 0;
            this.__top = -1;
            if (this.data === undefined)
                this.data = null;
            if (this.minCapacity === undefined)
                this.minCapacity = 0;
            if (this.capacity === undefined)
                this.capacity = 0;
            (function () {
                _this.data = (function (s) { var a = []; while (s-- > 0)
                    a.push(0); return a; })(size);
                _this.capacity = _this.minCapacity = size;
            })();
        }
        else if (size === undefined) {
            var __args = arguments;
            {
                var __args_1 = arguments;
                var size_1 = 1000;
                if (this.data === undefined)
                    this.data = null;
                if (this.minCapacity === undefined)
                    this.minCapacity = 0;
                if (this.capacity === undefined)
                    this.capacity = 0;
                this.__top = -1;
                if (this.data === undefined)
                    this.data = null;
                if (this.minCapacity === undefined)
                    this.minCapacity = 0;
                if (this.capacity === undefined)
                    this.capacity = 0;
                (function () {
                    _this.data = (function (s) { var a = []; while (s-- > 0)
                        a.push(0); return a; })(size_1);
                    _this.capacity = _this.minCapacity = size_1;
                })();
            }
        }
        else
            throw new Error('invalid overload');
    }
    Stack2.prototype.size = function () {
        return (this.__top + 1);
    };
    Stack2.prototype.isEmpty = function () {
        return (this.__top === -1);
    };
    Stack2.prototype.push = function (value) {
        if (this.size() === this.capacity) {
            console.info("size dubbelled");
            var newData = (function (s) { var a = []; while (s-- > 0)
                a.push(0); return a; })(this.capacity * 2);
            /* arraycopy */ (function (srcPts, srcOff, dstPts, dstOff, size) { if (srcPts !== dstPts || dstOff >= srcOff + size) {
                while (--size >= 0)
                    dstPts[dstOff++] = srcPts[srcOff++];
            }
            else {
                var tmp = srcPts.slice(srcOff, srcOff + size);
                for (var i = 0; i < size; i++)
                    dstPts[dstOff++] = tmp[i];
            } })(this.data, 0, newData, 0, this.capacity);
            this.data = newData;
            this.capacity = this.capacity * 2;
        }
        this.__top++;
        this.data[this.__top] = value;
    };
    Stack2.prototype.top = function () {
        if (this.isEmpty()) {
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        }
        return this.data[this.__top];
    };
    Stack2.prototype.pop = function () {
        if (this.isEmpty()) {
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        }
        var topVal = this.data[this.__top];
        this.__top--;
        if (this.size() === (this.capacity / 2 | 0) && this.capacity > this.minCapacity) {
            console.info("size halfed");
            this.capacity = (this.capacity / 2 | 0);
            var newData = (function (s) { var a = []; while (s-- > 0)
                a.push(0); return a; })(this.capacity);
            /* arraycopy */ (function (srcPts, srcOff, dstPts, dstOff, size) { if (srcPts !== dstPts || dstOff >= srcOff + size) {
                while (--size >= 0)
                    dstPts[dstOff++] = srcPts[srcOff++];
            }
            else {
                var tmp = srcPts.slice(srcOff, srcOff + size);
                for (var i = 0; i < size; i++)
                    dstPts[dstOff++] = tmp[i];
            } })(this.data, 0, newData, 0, this.capacity);
            this.data = newData;
        }
        return topVal;
    };
    Stack2.prototype.print = function () {
        for (var i = this.__top; i > -1; i--) {
            {
                console.info(" " + this.data[i]);
            }
            ;
        }
    };
    Stack2.main = function (args) {
        var s = new Stack2(10);
        for (var i = 1; i <= 100; i++) {
            {
                s.push(i);
            }
            ;
        }
        for (var i = 1; i <= 100; i++) {
            {
                s.pop();
            }
            ;
        }
        s.print();
    };
    return Stack2;
}());
Stack2["__class"] = "Stack2";
Stack2.main(null);
