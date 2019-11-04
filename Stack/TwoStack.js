/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var TwoStack = /** @class */ (function () {
    function TwoStack() {
        /*private*/ this.MAX_SIZE = 50;
        if (this.top1 === undefined)
            this.top1 = 0;
        if (this.top2 === undefined)
            this.top2 = 0;
        if (this.data === undefined)
            this.data = null;
        this.top1 = -1;
        this.top2 = this.MAX_SIZE;
        this.data = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(this.MAX_SIZE);
    }
    TwoStack.main = function (args) {
        var st = new TwoStack();
        for (var i = 0; i < 10; i++) {
            {
                st.StackPush1(i);
            }
            ;
        }
        for (var j = 0; j < 10; j++) {
            {
                st.StackPush2(j + 10);
            }
            ;
        }
        for (var i = 0; i < 10; i++) {
            {
                console.info("stack one pop value is : " + st.StackPop1());
                console.info("stack two pop value is : " + st.StackPop2());
            }
            ;
        }
    };
    TwoStack.prototype.StackPush1 = function (value) {
        if (this.top1 < this.top2 - 1) {
            this.data[++this.top1] = value;
        }
        else {
            console.info("Stack is Full!");
        }
    };
    TwoStack.prototype.StackPush2 = function (value) {
        if (this.top1 < this.top2 - 1) {
            this.data[--this.top2] = value;
        }
        else {
            console.info("Stack is Full!");
        }
    };
    TwoStack.prototype.StackPop1 = function () {
        if (this.top1 >= 0) {
            var value = this.data[this.top1--];
            return value;
        }
        else {
            console.info("Stack Empty!");
        }
        return -999;
    };
    TwoStack.prototype.StackPop2 = function () {
        if (this.top2 < this.MAX_SIZE) {
            var value = this.data[this.top2++];
            return value;
        }
        else {
            console.info("Stack Empty!");
        }
        return -999;
    };
    return TwoStack;
}());
TwoStack["__class"] = "TwoStack";
TwoStack.main(null);
