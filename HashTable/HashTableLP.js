var EMPTY_VALUE = 0;
var FILLED_VALUE = 1;
var DELETED_VALUE = 2;
var HashTableLP = /** @class */ (function () {
    function HashTableLP(tSize) {
        if (this.tableSize === undefined)
            this.tableSize = 0;
        if (this.Arr === undefined)
            this.Arr = null;
        if (this.Flag === undefined)
            this.Flag = null;
        this.tableSize = tSize;
        this.Arr = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(tSize + 1);
        this.Flag = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(tSize + 1);
        for (var i = 0; i <= tSize; i++) {
            {
                this.Flag[i] = EMPTY_VALUE;
            }
            ;
        }
    }
    HashTableLP.prototype.computeHash = function (key) {
        return key % this.tableSize;
    };
    HashTableLP.prototype.resolverFun = function (index) {
        return index;
    };
    HashTableLP.prototype.resolverFun2 = function (index) {
        return index * index;
    };
    HashTableLP.prototype.add = function (value) {
        var hashValue = this.computeHash(value);
        for (var i = 0; i < this.tableSize; i++) {
            {
                if (this.Flag[hashValue] === EMPTY_VALUE ||
                    this.Flag[hashValue] === DELETED_VALUE) {
                    this.Arr[hashValue] = value;
                    this.Flag[hashValue] = FILLED_VALUE;
                    return true;
                }
                hashValue += this.resolverFun(i);
                hashValue %= this.tableSize;
            }
            ;
        }
        return false;
    };
    HashTableLP.prototype.find = function (value) {
        var hashValue = this.computeHash(value);
        for (var i = 0; i < this.tableSize; i++) {
            {
                if (this.Flag[hashValue] === EMPTY_VALUE) {
                    return false;
                }
                if (this.Flag[hashValue] === FILLED_VALUE && this.Arr[hashValue] === value) {
                    return true;
                }
                hashValue += this.resolverFun(i);
                hashValue %= this.tableSize;
            }
            ;
        }
        return false;
    };
    HashTableLP.prototype.remove = function (value) {
        var hashValue = this.computeHash(value);
        for (var i = 0; i < this.tableSize; i++) {
            {
                if (this.Flag[hashValue] === EMPTY_VALUE) {
                    return false;
                }
                if (this.Flag[hashValue] === FILLED_VALUE && this.Arr[hashValue] === value) {
                    this.Flag[hashValue] = DELETED_VALUE;
                    return true;
                }
                hashValue += this.resolverFun(i);
                hashValue %= this.tableSize;
            }
            ;
        }
        return false;
    };
    HashTableLP.prototype.print = function () {
        for (var i = 0; i < this.tableSize; i++) {
            {
                if (this.Flag[i] === FILLED_VALUE) {
                    console.info("Node at index [" + i + " ] :: " + this.Arr[i]);
                }
            }
            ;
        }
    };
    HashTableLP.main = function (args) {
        var ht = new HashTableLP(1000);
        ht.add(1);
        ht.add(2);
        ht.add(3);
        ht.print();
        console.info(ht.remove(1));
        console.info(ht.remove(4));
        ht.print();
    };
    return HashTableLP;
}());
HashTableLP["__class"] = "HashTableLP";
HashTableLP.main(null);
