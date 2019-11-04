/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class Trie {
    static CharCount : number = 26;

    root : Trie.Node = null;

    public constructor() {
        this.root = new Trie.Node(this, ' ');
    }

    add$java_lang_String(str : string) : Trie.Node {
        if(str == null) {
            return this.root;
        }
        return this.add$Trie_Node$java_lang_String$int(this.root, str.toLowerCase(), 0);
    }

    public add$Trie_Node$java_lang_String$int(curr : Trie.Node, str : string, index : number) : Trie.Node {
        if(curr == null) {
            curr = new Trie.Node(this, str.charAt(index - 1));
        }
        if(str.length === index) {
            curr.isLastChar = true;
        } else {
            curr.child[(c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(str.charAt(index)) - 'a'.charCodeAt(0)] = this.add$Trie_Node$java_lang_String$int(curr.child[(c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(str.charAt(index)) - 'a'.charCodeAt(0)], str, index + 1);
        }
        return curr;
    }

    public add(curr? : any, str? : any, index? : any) : any {
        if(((curr != null && curr instanceof <any>Trie.Node) || curr === null) && ((typeof str === 'string') || str === null) && ((typeof index === 'number') || index === null)) {
            return <any>this.add$Trie_Node$java_lang_String$int(curr, str, index);
        } else if(((typeof curr === 'string') || curr === null) && str === undefined && index === undefined) {
            return <any>this.add$java_lang_String(curr);
        } else throw new Error('invalid overload');
    }

    remove$java_lang_String(str : string) {
        if(str == null) {
            return;
        }
        str = str.toLowerCase();
        this.remove$Trie_Node$java_lang_String$int(this.root, str, 0);
    }

    public remove$Trie_Node$java_lang_String$int(curr : Trie.Node, str : string, index : number) {
        if(curr == null) {
            return;
        }
        if(str.length === index) {
            if(curr.isLastChar) {
                curr.isLastChar = false;
            }
            return;
        }
        this.remove$Trie_Node$java_lang_String$int(curr.child[(c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(str.charAt(index)) - 'a'.charCodeAt(0)], str, index + 1);
    }

    public remove(curr? : any, str? : any, index? : any) : any {
        if(((curr != null && curr instanceof <any>Trie.Node) || curr === null) && ((typeof str === 'string') || str === null) && ((typeof index === 'number') || index === null)) {
            return <any>this.remove$Trie_Node$java_lang_String$int(curr, str, index);
        } else if(((typeof curr === 'string') || curr === null) && str === undefined && index === undefined) {
            return <any>this.remove$java_lang_String(curr);
        } else throw new Error('invalid overload');
    }

    find$java_lang_String(str : string) : boolean {
        if(str == null) {
            return false;
        }
        str = str.toLowerCase();
        return this.find$Trie_Node$java_lang_String$int(this.root, str, 0);
    }

    public find$Trie_Node$java_lang_String$int(curr : Trie.Node, str : string, index : number) : boolean {
        if(curr == null) {
            return false;
        }
        if(str.length === index) {
            return curr.isLastChar;
        }
        return this.find$Trie_Node$java_lang_String$int(curr.child[(c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(str.charAt(index)) - 'a'.charCodeAt(0)], str, index + 1);
    }

    public find(curr? : any, str? : any, index? : any) : any {
        if(((curr != null && curr instanceof <any>Trie.Node) || curr === null) && ((typeof str === 'string') || str === null) && ((typeof index === 'number') || index === null)) {
            return <any>this.find$Trie_Node$java_lang_String$int(curr, str, index);
        } else if(((typeof curr === 'string') || curr === null) && str === undefined && index === undefined) {
            return <any>this.find$java_lang_String(curr);
        } else throw new Error('invalid overload');
    }

    public static main(args : string[]) {
        let t : Trie = new Trie();
        let a : string = "hemant";
        let b : string = "heman";
        let c : string = "hemantjain";
        let d : string = "jain";
        t.add$java_lang_String(a);
        t.add$java_lang_String(d);
        console.info(t.find$java_lang_String(a));
        t.remove$java_lang_String(a);
        t.remove$java_lang_String(d);
        console.info(t.find$java_lang_String(a));
        console.info(t.find$java_lang_String(c));
        console.info(t.find$java_lang_String(d));
    }
}
Trie["__class"] = "Trie";


namespace Trie {

    export class Node {
        public __parent: any;
        isLastChar : boolean;

        child : Trie.Node[];

        public constructor(__parent: any, c : string) {
            this.__parent = __parent;
            if(this.isLastChar===undefined) this.isLastChar = false;
            if(this.child===undefined) this.child = null;
            this.child = (s => { let a=[]; while(s-->0) a.push(null); return a; })(Trie.CharCount);
            for(let i : number = 0; i < Trie.CharCount; i++) {{
                this.child[i] = null;
            };}
            this.isLastChar = false;
        }
    }
    Node["__class"] = "Trie.Node";

}




Trie.main(null);
