/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class HashTableSC {
    /*private*/ tableSize : number;

    listArray : HashTableSC.Node[];

    public constructor() {
        if(this.tableSize===undefined) this.tableSize = 0;
        if(this.listArray===undefined) this.listArray = null;
        this.tableSize = 512;
        this.listArray = (s => { let a=[]; while(s-->0) a.push(null); return a; })(this.tableSize);
        for(let i : number = 0; i < this.tableSize; i++) {{
            this.listArray[i] = null;
        };}
    }

    computeHash(key : number) : number {
        let hashValue : number = key;
        return hashValue % this.tableSize;
    }

    public add(value : number) {
        let index : number = this.computeHash(value);
        this.listArray[index] = new HashTableSC.Node(this, value, this.listArray[index]);
    }

    public remove(value : number) : boolean {
        let index : number = this.computeHash(value);
        let nextNode : HashTableSC.Node;
        let head : HashTableSC.Node = this.listArray[index];
        if(head != null && head.value === value) {
            this.listArray[index] = head.next;
            return true;
        }
        while((head != null)) {{
            nextNode = head.next;
            if(nextNode != null && nextNode.value === value) {
                head.next = nextNode.next;
                return true;
            } else {
                head = nextNode;
            }
        }};
        return false;
    }

    public print() {
        for(let i : number = 0; i < this.tableSize; i++) {{
            console.info("printing for index value :: " + i + "List of value printing :: ");
            let head : HashTableSC.Node = this.listArray[i];
            while((head != null)) {{
                console.info(head.value);
                head = head.next;
            }};
        };}
    }

    public find(value : number) : boolean {
        let index : number = this.computeHash(value);
        let head : HashTableSC.Node = this.listArray[index];
        while((head != null)) {{
            if(head.value === value) {
                return true;
            }
            head = head.next;
        }};
        return false;
    }

    public static main(args : string[]) {
        let ht : HashTableSC = new HashTableSC();
        for(let i : number = 100; i < 110; i++) {{
            ht.add(i);
        };}
        console.info("search 100 :: " + ht.find(100));
        console.info("remove 100 :: " + ht.remove(100));
        console.info("search 100 :: " + ht.find(100));
        console.info("remove 100 :: " + ht.remove(100));
    }
}
HashTableSC["__class"] = "HashTableSC";


namespace HashTableSC {

    export class Node {
        public __parent: any;
        value : number;

        next : HashTableSC.Node;

        public constructor(__parent: any, v : number, n : HashTableSC.Node) {
            this.__parent = __parent;
            if(this.value===undefined) this.value = 0;
            if(this.next===undefined) this.next = null;
            this.value = v;
            this.next = n;
        }
    }
    Node["__class"] = "HashTableSC.Node";

}




HashTableSC.main(null);
