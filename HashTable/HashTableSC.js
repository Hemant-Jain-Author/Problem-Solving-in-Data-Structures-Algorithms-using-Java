/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var HashTableSC = /** @class */ (function () {
    function HashTableSC() {
        if (this.tableSize === undefined)
            this.tableSize = 0;
        if (this.listArray === undefined)
            this.listArray = null;
        this.tableSize = 512;
        this.listArray = (function (s) { var a = []; while (s-- > 0)
            a.push(null); return a; })(this.tableSize);
        for (var i = 0; i < this.tableSize; i++) {
            {
                this.listArray[i] = null;
            }
            ;
        }
    }
    HashTableSC.prototype.computeHash = function (key) {
        var hashValue = key;
        return hashValue % this.tableSize;
    };
    HashTableSC.prototype.add = function (value) {
        var index = this.computeHash(value);
        this.listArray[index] = new HashTableSC.Node(this, value, this.listArray[index]);
    };
    HashTableSC.prototype.remove = function (value) {
        var index = this.computeHash(value);
        var nextNode;
        var head = this.listArray[index];
        if (head != null && head.value === value) {
            this.listArray[index] = head.next;
            return true;
        }
        while ((head != null)) {
            {
                nextNode = head.next;
                if (nextNode != null && nextNode.value === value) {
                    head.next = nextNode.next;
                    return true;
                }
                else {
                    head = nextNode;
                }
            }
        }
        ;
        return false;
    };
    HashTableSC.prototype.print = function () {
        for (var i = 0; i < this.tableSize; i++) {
            {
                console.info("printing for index value :: " + i + "List of value printing :: ");
                var head = this.listArray[i];
                while ((head != null)) {
                    {
                        console.info(head.value);
                        head = head.next;
                    }
                }
                ;
            }
            ;
        }
    };
    HashTableSC.prototype.find = function (value) {
        var index = this.computeHash(value);
        var head = this.listArray[index];
        while ((head != null)) {
            {
                if (head.value === value) {
                    return true;
                }
                head = head.next;
            }
        }
        ;
        return false;
    };
    HashTableSC.main = function (args) {
        var ht = new HashTableSC();
        for (var i = 100; i < 110; i++) {
            {
                ht.add(i);
            }
            ;
        }
        console.info("search 100 :: " + ht.find(100));
        console.info("remove 100 :: " + ht.remove(100));
        console.info("search 100 :: " + ht.find(100));
        console.info("remove 100 :: " + ht.remove(100));
    };
    return HashTableSC;
}());
HashTableSC["__class"] = "HashTableSC";
(function (HashTableSC) {
    var Node = /** @class */ (function () {
        function Node(__parent, v, n) {
            this.__parent = __parent;
            if (this.value === undefined)
                this.value = 0;
            if (this.next === undefined)
                this.next = null;
            this.value = v;
            this.next = n;
        }
        return Node;
    }());
    HashTableSC.Node = Node;
    Node["__class"] = "HashTableSC.Node";
})(HashTableSC || (HashTableSC = {}));
HashTableSC.main(null);
