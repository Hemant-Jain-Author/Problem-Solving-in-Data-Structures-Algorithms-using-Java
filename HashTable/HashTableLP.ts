let EMPTY_VALUE : number = 0;
let FILLED_VALUE : number = 1;
let DELETED_VALUE : number = 2;

class HashTableLP {

    tableSize : number;
    Arr : number[];
    Flag : number[];

    public constructor(tSize : number) {
        if(this.tableSize===undefined) this.tableSize = 0;
        if(this.Arr===undefined) this.Arr = null;
        if(this.Flag===undefined) this.Flag = null;
        this.tableSize = tSize;
        this.Arr = (s => { let a=[]; while(s-->0) a.push(0); return a; })(tSize + 1);
        this.Flag = (s => { let a=[]; while(s-->0) a.push(0); return a; })(tSize + 1);
        for(let i : number = 0; i <= tSize; i++) {{
            this.Flag[i] = EMPTY_VALUE;
        };}
    }

    computeHash(key : number) : number {
        return key % this.tableSize;
    }

    resolverFun(index : number) : number {
        return index;
    }

    resolverFun2(index : number) : number {
        return index * index;
    }

    add(value : number) : boolean {
        let hashValue : number = this.computeHash(value);
        for(let i : number = 0; i < this.tableSize; i++) {{
            if(this.Flag[hashValue] === EMPTY_VALUE || 
                this.Flag[hashValue] === DELETED_VALUE) {
                this.Arr[hashValue] = value;
                this.Flag[hashValue] = FILLED_VALUE;
                return true;
            }
            hashValue += this.resolverFun(i);
            hashValue %= this.tableSize;
        };}
        return false;
    }

    find(value : number) : boolean {
        let hashValue : number = this.computeHash(value);
        for(let i : number = 0; i < this.tableSize; i++) {{
            if(this.Flag[hashValue] === EMPTY_VALUE) {
                return false;
            }
            if(this.Flag[hashValue] === FILLED_VALUE && this.Arr[hashValue] === value) {
                return true;
            }
            hashValue += this.resolverFun(i);
            hashValue %= this.tableSize;
        };}
        return false;
    }

    remove(value : number) : boolean {
        let hashValue : number = this.computeHash(value);
        for(let i : number = 0; i < this.tableSize; i++) {{
            if(this.Flag[hashValue] === EMPTY_VALUE) {
                return false;
            }
            if(this.Flag[hashValue] === FILLED_VALUE && this.Arr[hashValue] === value) {
                this.Flag[hashValue] = DELETED_VALUE;
                return true;
            }
            hashValue += this.resolverFun(i);
            hashValue %= this.tableSize;
        };}
        return false;
    }

    print() {
        for(let i : number = 0; i < this.tableSize; i++) {{
            if(this.Flag[i] === FILLED_VALUE) {
                console.info("Node at index [" + i + " ] :: " + this.Arr[i]);
            }
        };}
    }

    public static main(args : string[]) {
        let ht : HashTableLP = new HashTableLP(1000);
        ht.add(1);
        ht.add(2);
        ht.add(3);
        ht.print();
        console.info(ht.remove(1));
        console.info(ht.remove(4));
        ht.print();
    }
}
HashTableLP["__class"] = "HashTableLP";

HashTableLP.main(null);