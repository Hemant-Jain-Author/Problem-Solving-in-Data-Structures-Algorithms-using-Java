var Heap = /** @class */ (function () {
    function Heap(array, isMin) {
        var _this = this;
        if (((array != null && array instanceof Array && (array.length == 0 || array[0] == null || (typeof array[0] === 'number'))) || array === null) && ((typeof isMin === 'boolean') || isMin === null)) {
            var __args = arguments;
            if (this.size === undefined)
                this.size = 0;
            if (this.arr === undefined)
                this.arr = null;
            if (this.__isMinHeap === undefined)
                this.__isMinHeap = false;
            if (this.size === undefined)
                this.size = 0;
            if (this.arr === undefined)
                this.arr = null;
            if (this.__isMinHeap === undefined)
                this.__isMinHeap = false;
            (function () {
                _this.size = array.length;
                _this.arr = array;
                _this.__isMinHeap = isMin;
                for (var i = ((_this.size / 2 | 0)); i >= 0; i--) {
                    {
                        _this.proclateDown(i);
                    }
                    ;
                }
            })();
        }
        else if (((typeof array === 'boolean') || array === null) && isMin === undefined) {
            var __args = arguments;
            var isMin_1 = __args[0];
            if (this.size === undefined)
                this.size = 0;
            if (this.arr === undefined)
                this.arr = null;
            if (this.__isMinHeap === undefined)
                this.__isMinHeap = false;
            if (this.size === undefined)
                this.size = 0;
            if (this.arr === undefined)
                this.arr = null;
            if (this.__isMinHeap === undefined)
                this.__isMinHeap = false;
            (function () {
                _this.arr = (function (s) { var a = []; while (s-- > 0)
                    a.push(0); return a; })(Heap.CAPACITY);
                _this.size = 0;
                _this.__isMinHeap = isMin_1;
            })();
        }
        else
            throw new Error('invalid overload');
    }
    Heap.prototype.compare = function (arr, first, second) {
        if (this.__isMinHeap)
            return (arr[first] - arr[second]) > 0;
        else
            return (arr[first] - arr[second]) < 0;
    };
    /*private*/ Heap.prototype.proclateDown = function (parent) {
        var lChild = 2 * parent + 1;
        var rChild = lChild + 1;
        var child = -1;
        var temp;
        if (lChild < this.size) {
            child = lChild;
        }
        if (rChild < this.size && this.compare(this.arr, lChild, rChild)) {
            child = rChild;
        }
        if (child !== -1 && this.compare(this.arr, parent, child)) {
            temp = this.arr[parent];
            this.arr[parent] = this.arr[child];
            this.arr[child] = temp;
            this.proclateDown(child);
        }
    };
    /*private*/ Heap.prototype.proclateUp = function (child) {
        var parent = ((child - 1) / 2 | 0);
        var temp;
        if (parent < 0) {
            return;
        }
        if (this.compare(this.arr, parent, child)) {
            temp = this.arr[child];
            this.arr[child] = this.arr[parent];
            this.arr[parent] = temp;
            this.proclateUp(parent);
        }
    };
    Heap.prototype.add = function (value) {
        if (this.size === this.arr.length) {
            this.doubleSize();
        }
        this.arr[this.size++] = value;
        this.proclateUp(this.size - 1);
    };
    /*private*/ Heap.prototype.doubleSize = function () {
        var old = this.arr;
        this.arr = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(this.arr.length * 2);
        /* arraycopy */ (function (srcPts, srcOff, dstPts, dstOff, size) { if (srcPts !== dstPts || dstOff >= srcOff + size) {
            while (--size >= 0)
                dstPts[dstOff++] = srcPts[srcOff++];
        }
        else {
            var tmp = srcPts.slice(srcOff, srcOff + size);
            for (var i = 0; i < size; i++)
                dstPts[dstOff++] = tmp[i];
        } })(old, 0, this.arr, 0, this.size);
    };
    Heap.prototype.remove = function () {
        if (this.isEmpty()) {
            throw Object.defineProperty(new Error(), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        }
        var value = this.arr[0];
        this.arr[0] = this.arr[this.size - 1];
        this.size--;
        this.proclateDown(0);
        return value;
    };
    Heap.prototype.print = function () {
        //for(let i : number = 0; i < this.size; i++) {{
        console.info(this.arr); //[i] + " ");
        //};}
    };
    Heap.prototype.isEmpty = function () {
        return (this.size === 0);
    };
    Heap.prototype.length = function () {
        return this.size;
    };
    Heap.prototype.peek = function () {
        if (this.isEmpty()) {
            throw Object.defineProperty(new Error(), '__classes', { configurable: true, value: ['java.lang.Throwable', 'java.lang.IllegalStateException', 'java.lang.Object', 'java.lang.RuntimeException', 'java.lang.Exception'] });
        }
        return this.arr[0];
    };
    Heap.heapSort = function (array, inc) {
        var hp = new Heap(array, !inc);
        for (var i = 0; i < array.length; i++) {
            {
                array[array.length - i - 1] = hp.remove();
            }
            ;
        }
    };
    Heap.main = function (args) {
        var a = [1, 9, 6, 7, 8, 0, 2, 4, 5, 3];
        var hp = new Heap(a, true);
        hp.add(-1);
        hp.add(100);
        hp.print();
        console.info();
        while ((!hp.isEmpty())) {
            console.info(hp.remove() + " ");
        }
        ;
        console.info();
        var a2 = [1, 9, 6, 7, 8, 0, 2, 4, 5, 3];
        Heap.heapSort(a2, true);
        //for(let i : number = 0; i < a2.length; i++) {{
        console.info(a2); //[i] + " ");
        //};}
        console.info();
        var a3 = [1, 9, 6, 7, 8, 0, 2, 4, 5, 3];
        Heap.heapSort(a3, false);
        //for(let i : number = 0; i < a3.length; i++) {{
        console.info(a3); //[i] + " ");
        //};}
    };
    Heap.prototype.isMinHeap = function (arr, size) {
        for (var i = 0; i <= ((size - 2) / 2 | 0); i++) {
            {
                if (2 * i + 1 < size) {
                    if (arr[i] > arr[2 * i + 1]) {
                        return false;
                    }
                }
                if (2 * i + 2 < size) {
                    if (arr[i] > arr[2 * i + 2]) {
                        return false;
                    }
                }
            }
            ;
        }
        return true;
    };
    Heap.prototype.isMaxHeap = function (arr, size) {
        for (var i = 0; i <= ((size - 2) / 2 | 0); i++) {
            {
                if (2 * i + 1 < size) {
                    if (arr[i] < arr[2 * i + 1]) {
                        return false;
                    }
                }
                if (2 * i + 2 < size) {
                    if (arr[i] < arr[2 * i + 2])
                        return false;
                }
            }
            ;
        }
        return true;
    };
    Heap.CAPACITY = 32;
    return Heap;
}());
Heap["__class"] = "Heap";
Heap.main(null);
