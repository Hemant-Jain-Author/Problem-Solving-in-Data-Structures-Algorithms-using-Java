/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var Queue = /** @class */ (function () {
    function Queue() {
        /*private*/ this.capacity = 100;
        this.front = 0;
        this.back = 0;
        if (this.__size === undefined)
            this.__size = 0;
        if (this.data === undefined)
            this.data = null;
        this.__size = 0;
        this.data = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(100);
    }
    Queue.prototype.add = function (value) {
        if (this.__size >= this.capacity) {
            console.info("Queue is full.");
            return false;
        }
        else {
            this.__size++;
            this.data[this.back] = value;
            this.back = (++this.back) % (this.capacity - 1);
        }
        return true;
    };
    Queue.prototype.remove = function () {
        var value;
        if (this.__size <= 0) {
            console.info("Queue is empty.");
            return -999;
        }
        else {
            this.__size--;
            value = this.data[this.front];
            this.front = (++this.front) % (this.capacity - 1);
        }
        return value;
    };
    Queue.prototype.isEmpty = function () {
        return this.__size === 0;
    };
    Queue.prototype.size = function () {
        return this.__size;
    };
    Queue.main = function (args) {
        var que = new Queue();
        for (var i = 0; i < 20; i++) {
            {
                que.add(i);
            }
            ;
        }
        for (var i = 0; i < 22; i++) {
            {
                console.info(que.remove());
            }
            ;
        }
    };
    return Queue;
}());
Queue["__class"] = "Queue";
Queue.main(null);
