/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class StackLL {
    /*private*/ head : StackLL.Node = null;

    /*private*/ __size : number = 0;

    public size() : number {
        return this.__size;
    }

    public isEmpty() : boolean {
        return this.__size === 0;
    }

    public peek() : number {
        if(this.isEmpty()) {
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        }
        return this.head.value;
    }

    public push(value : number) {
        this.head = new StackLL.Node(value, this.head);
        this.__size++;
    }

    public pop() : number {
        if(this.isEmpty()) {
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        }
        let value : number = this.head.value;
        this.head = this.head.next;
        this.__size--;
        return value;
    }

    public insertAtBottom(value : number) {
        if(this.isEmpty()) {
            this.push(value);
        } else {
            let temp : number = this.pop();
            this.insertAtBottom(value);
            this.push(temp);
        }
    }

    public print() {
        let temp : StackLL.Node = this.head;
        while((temp != null)) {{
            console.info(temp.value + " ");
            temp = temp.next;
        }};
    }

    public static main(args : string[]) {
        let s : StackLL = new StackLL();
        s.push(1);
        s.push(2);
        s.push(3);
        s.print();
        console.info(s.pop());
        console.info(s.pop());
        s.print();
    }
}
StackLL["__class"] = "StackLL";


namespace StackLL {

    export class Node {
        value : number;

        next : StackLL.Node;

        public constructor(v : number, n : StackLL.Node) {
            if(this.value===undefined) this.value = 0;
            if(this.next===undefined) this.next = null;
            this.value = v;
            this.next = n;
        }
    }
    Node["__class"] = "StackLL.Node";

}




StackLL.main(null);
