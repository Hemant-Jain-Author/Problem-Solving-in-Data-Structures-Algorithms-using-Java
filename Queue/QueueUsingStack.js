/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var QueueUsingStack = /** @class */ (function () {
    function QueueUsingStack() {
        if (this.stk1 === undefined)
            this.stk1 = null;
        if (this.stk2 === undefined)
            this.stk2 = null;
        this.stk1 = ([]);
        this.stk2 = ([]);
    }
    QueueUsingStack.prototype.add = function (value) {
        /* push */ (this.stk1.push(value) > 0);
    };
    QueueUsingStack.prototype.remove = function () {
        var value;
        if ( /* isEmpty */(this.stk2.length == 0) === false) {
            return /* pop */ this.stk2.pop();
        }
        while (( /* isEmpty */(this.stk1.length == 0) === false)) {
            {
                value = /* pop */ this.stk1.pop();
                /* push */ (this.stk2.push(value) > 0);
            }
        }
        ;
        return /* pop */ this.stk2.pop();
    };
    QueueUsingStack.main = function (args) {
        var que = new QueueUsingStack();
        que.add(1);
        que.add(11);
        que.add(111);
        console.info(que.remove());
        console.info(que.remove());
    };
    return QueueUsingStack;
}());
QueueUsingStack["__class"] = "QueueUsingStack";
QueueUsingStack.main(null);
