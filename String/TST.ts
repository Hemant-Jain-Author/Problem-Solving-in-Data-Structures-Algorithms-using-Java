/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class TST {
    root : TST.Node;

    public add$java_lang_String(word : string) {
        this.root = this.add$TST_Node$java_lang_String$int(this.root, word, 0);
    }

    public add$TST_Node$java_lang_String$int(curr : TST.Node, word : string, wordIndex : number) : TST.Node {
        if(curr == null) curr = new TST.Node(this, word.charAt(wordIndex));
        if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(word.charAt(wordIndex)) < (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(curr.data)) curr.left = this.add$TST_Node$java_lang_String$int(curr.left, word, wordIndex); else if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(word.charAt(wordIndex)) > (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(curr.data)) curr.right = this.add$TST_Node$java_lang_String$int(curr.right, word, wordIndex); else {
            if(wordIndex < word.length - 1) curr.equal = this.add$TST_Node$java_lang_String$int(curr.equal, word, wordIndex + 1); else curr.isLastChar = true;
        }
        return curr;
    }

    public add(curr? : any, word? : any, wordIndex? : any) : any {
        if(((curr != null && curr instanceof <any>TST.Node) || curr === null) && ((typeof word === 'string') || word === null) && ((typeof wordIndex === 'number') || wordIndex === null)) {
            return <any>this.add$TST_Node$java_lang_String$int(curr, word, wordIndex);
        } else if(((typeof curr === 'string') || curr === null) && word === undefined && wordIndex === undefined) {
            return <any>this.add$java_lang_String(curr);
        } else throw new Error('invalid overload');
    }

    public find$TST_Node$java_lang_String$int(curr : TST.Node, word : string, wordIndex : number) : boolean {
        if(curr == null) return false;
        if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(word.charAt(wordIndex)) < (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(curr.data)) return this.find$TST_Node$java_lang_String$int(curr.left, word, wordIndex); else if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(word.charAt(wordIndex)) > (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(curr.data)) return this.find$TST_Node$java_lang_String$int(curr.right, word, wordIndex); else {
            if(wordIndex === word.length - 1) return curr.isLastChar;
            return this.find$TST_Node$java_lang_String$int(curr.equal, word, wordIndex + 1);
        }
    }

    public find(curr? : any, word? : any, wordIndex? : any) : any {
        if(((curr != null && curr instanceof <any>TST.Node) || curr === null) && ((typeof word === 'string') || word === null) && ((typeof wordIndex === 'number') || wordIndex === null)) {
            return <any>this.find$TST_Node$java_lang_String$int(curr, word, wordIndex);
        } else if(((typeof curr === 'string') || curr === null) && word === undefined && wordIndex === undefined) {
            return <any>this.find$java_lang_String(curr);
        } else throw new Error('invalid overload');
    }

    public find$java_lang_String(word : string) : boolean {
        let ret : boolean = this.find$TST_Node$java_lang_String$int(this.root, word, 0);
        console.info(word + " :: ");
        if(ret) console.info(" Found "); else console.info("Not Found ");
        return ret;
    }

    public static main(args : string[]) {
        let tt : TST = new TST();
        tt.add$java_lang_String("banana");
        tt.add$java_lang_String("apple");
        tt.add$java_lang_String("mango");
        console.info("\nSearch results for apple, banana, grapes and mango :");
        tt.find$java_lang_String("apple");
        tt.find$java_lang_String("banana");
        tt.find$java_lang_String("mango");
        tt.find$java_lang_String("grapes");
    }

    constructor() {
        if(this.root===undefined) this.root = null;
    }
}
TST["__class"] = "TST";


namespace TST {

    export class Node {
        public __parent: any;
        data : string;

        isLastChar : boolean;

        left : TST.Node;

        equal : TST.Node;

        right : TST.Node;

        constructor(__parent: any, d : string) {
            this.__parent = __parent;
            if(this.data===undefined) this.data = null;
            if(this.isLastChar===undefined) this.isLastChar = false;
            if(this.left===undefined) this.left = null;
            if(this.equal===undefined) this.equal = null;
            if(this.right===undefined) this.right = null;
            this.data = d;
            this.isLastChar = false;
            this.left = this.equal = this.right = null;
        }
    }
    Node["__class"] = "TST.Node";

}




TST.main(null);
