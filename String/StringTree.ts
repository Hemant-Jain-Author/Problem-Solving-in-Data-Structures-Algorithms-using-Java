/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class StringTree {
    root : StringTree.Node = null;

    public print$() {
        this.print$StringTree_Node(this.root);
    }

    public print$StringTree_Node(curr : StringTree.Node) {
        if(curr != null) {
            console.info(" value is ::" + curr.value);
            console.info(" count is :: " + curr.count);
            this.print$StringTree_Node(curr.lChild);
            this.print$StringTree_Node(curr.rChild);
        }
    }

    public print(curr? : any) : any {
        if(((curr != null && curr instanceof <any>StringTree.Node) || curr === null)) {
            return <any>this.print$StringTree_Node(curr);
        } else if(curr === undefined) {
            return <any>this.print$();
        } else throw new Error('invalid overload');
    }

    public add$java_lang_String(value : string) {
        this.root = this.add$java_lang_String$StringTree_Node(value, this.root);
    }

    public add$java_lang_String$StringTree_Node(value : string, curr : StringTree.Node) : StringTree.Node {
        if(curr == null) {
            curr = new StringTree.Node(this);
            curr.value = value;
            curr.lChild = curr.rChild = null;
            curr.count = 1;
        } else {
            let compare : number = /* compareTo */curr.value.localeCompare(value);
            if(compare === 0) curr.count++; else if(compare === 1) curr.lChild = this.add$java_lang_String$StringTree_Node(value, curr.lChild); else curr.rChild = this.add$java_lang_String$StringTree_Node(value, curr.rChild);
        }
        return curr;
    }

    public add(value? : any, curr? : any) : any {
        if(((typeof value === 'string') || value === null) && ((curr != null && curr instanceof <any>StringTree.Node) || curr === null)) {
            return <any>this.add$java_lang_String$StringTree_Node(value, curr);
        } else if(((typeof value === 'string') || value === null) && curr === undefined) {
            return <any>this.add$java_lang_String(value);
        } else throw new Error('invalid overload');
    }

    find$java_lang_String(value : string) : boolean {
        let ret : boolean = this.find$StringTree_Node$java_lang_String(this.root, value);
        console.info("Find " + value + " Return " + ret);
        return ret;
    }

    public find$StringTree_Node$java_lang_String(curr : StringTree.Node, value : string) : boolean {
        if(curr == null) return false;
        let compare : number = /* compareTo */curr.value.localeCompare(value);
        if(compare === 0) return true; else {
            if(compare === 1) return this.find$StringTree_Node$java_lang_String(curr.lChild, value); else return this.find$StringTree_Node$java_lang_String(curr.rChild, value);
        }
    }

    public find(curr? : any, value? : any) : any {
        if(((curr != null && curr instanceof <any>StringTree.Node) || curr === null) && ((typeof value === 'string') || value === null)) {
            return <any>this.find$StringTree_Node$java_lang_String(curr, value);
        } else if(((typeof curr === 'string') || curr === null) && value === undefined) {
            return <any>this.find$java_lang_String(curr);
        } else throw new Error('invalid overload');
    }

    frequency$java_lang_String(value : string) : number {
        return this.frequency$StringTree_Node$java_lang_String(this.root, value);
    }

    public frequency$StringTree_Node$java_lang_String(curr : StringTree.Node, value : string) : number {
        if(curr == null) return 0;
        let compare : number = /* compareTo */curr.value.localeCompare(value);
        if(compare === 0) return curr.count; else {
            if(compare > 0) return this.frequency$StringTree_Node$java_lang_String(curr.lChild, value); else return this.frequency$StringTree_Node$java_lang_String(curr.rChild, value);
        }
    }

    public frequency(curr? : any, value? : any) : any {
        if(((curr != null && curr instanceof <any>StringTree.Node) || curr === null) && ((typeof value === 'string') || value === null)) {
            return <any>this.frequency$StringTree_Node$java_lang_String(curr, value);
        } else if(((typeof curr === 'string') || curr === null) && value === undefined) {
            return <any>this.frequency$java_lang_String(curr);
        } else throw new Error('invalid overload');
    }

    freeTree() {
        this.root = null;
    }

    public static main(args : string[]) {
        let tt : StringTree = new StringTree();
        tt.add$java_lang_String("banana");
        tt.add$java_lang_String("apple");
        tt.add$java_lang_String("mango");
        tt.add$java_lang_String("banana");
        tt.add$java_lang_String("apple");
        tt.add$java_lang_String("mango");
        console.info("\nSearch results for apple, banana, grapes and mango :\n");
        tt.find$java_lang_String("apple");
        tt.find$java_lang_String("banana");
        tt.find$java_lang_String("banan");
        tt.find$java_lang_String("applkhjkhkj");
        tt.find$java_lang_String("grapes");
        tt.find$java_lang_String("mango");
        tt.print();
        console.info("frequency returned :: " + tt.frequency$java_lang_String("apple"));
        console.info("frequency returned :: " + tt.frequency$java_lang_String("banana"));
        console.info("frequency returned :: " + tt.frequency$java_lang_String("mango"));
        console.info("frequency returned :: " + tt.frequency$java_lang_String("hemant"));
    }
}
StringTree["__class"] = "StringTree";


namespace StringTree {

    export class Node {
        public __parent: any;
        value : string;

        count : number;

        lChild : StringTree.Node;

        rChild : StringTree.Node;

        constructor(__parent: any) {
            this.__parent = __parent;
            if(this.value===undefined) this.value = null;
            if(this.count===undefined) this.count = 0;
            if(this.lChild===undefined) this.lChild = null;
            if(this.rChild===undefined) this.rChild = null;
        }
    }
    Node["__class"] = "StringTree.Node";

}




StringTree.main(null);
