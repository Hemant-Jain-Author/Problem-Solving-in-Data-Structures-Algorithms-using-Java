/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class QueueLL {
    /*private*/ tail : QueueLL.Node = null;

    /*private*/ __size : number = 0;

    public size() : number {
        return this.__size;
    }

    public isEmpty() : boolean {
        return this.__size === 0;
    }

    public peek() : number {
        if(this.isEmpty()) throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        let value : number;
        if(this.tail === this.tail.next) value = this.tail.value; else value = this.tail.next.value;
        return value;
    }

    public add(value : number) {
        let temp : QueueLL.Node = new QueueLL.Node(value, null);
        if(this.tail == null) {
            this.tail = temp;
            this.tail.next = this.tail;
        } else {
            temp.next = this.tail.next;
            this.tail.next = temp;
            this.tail = temp;
        }
        this.__size++;
    }

    public remove() : number {
        if(this.isEmpty()) throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        let value : number = 0;
        if(this.tail === this.tail.next) {
            value = this.tail.value;
            this.tail = null;
        } else {
            value = this.tail.next.value;
            this.tail.next = this.tail.next.next;
        }
        this.__size--;
        return value;
    }

    public static main(args : string[]) {
        let q : QueueLL = new QueueLL();
        q.add(1);
        q.add(2);
        q.add(3);
        for(let i : number = 0; i < 3; i++) {console.info(q.remove());}
    }
}
QueueLL["__class"] = "QueueLL";


namespace QueueLL {

    export class Node {
        value : number;

        next : QueueLL.Node;

        public constructor(v : number, n : QueueLL.Node) {
            if(this.value===undefined) this.value = 0;
            if(this.next===undefined) this.next = null;
            this.value = v;
            this.next = n;
        }
    }
    Node["__class"] = "QueueLL.Node";

}




QueueLL.main(null);
