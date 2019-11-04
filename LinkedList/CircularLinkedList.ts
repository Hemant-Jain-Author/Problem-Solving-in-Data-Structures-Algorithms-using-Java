/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class CircularLinkedList {
    /*private*/ tail : CircularLinkedList.Node;

    /*private*/ __size : number = 0;

    public size() : number {
        return this.__size;
    }

    public isEmpty() : boolean {
        return this.__size === 0;
    }

    public peek() : number {
        if(this.isEmpty()) throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        return this.tail.next.value;
    }

    public addTail(value : number) {
        let temp : CircularLinkedList.Node = new CircularLinkedList.Node(value, null);
        if(this.isEmpty()) {
            this.tail = temp;
            temp.next = temp;
        } else {
            temp.next = this.tail.next;
            this.tail.next = temp;
            this.tail = temp;
        }
        this.__size++;
    }

    public addHead(value : number) {
        let temp : CircularLinkedList.Node = new CircularLinkedList.Node(value, null);
        if(this.isEmpty()) {
            this.tail = temp;
            temp.next = temp;
        } else {
            temp.next = this.tail.next;
            this.tail.next = temp;
        }
        this.__size++;
    }

    public removeHead() : number {
        if(this.isEmpty()) {
            throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        }
        let value : number = this.tail.next.value;
        if(this.tail === this.tail.next) this.tail = null; else this.tail.next = this.tail.next.next;
        this.__size--;
        return value;
    }

    public removeNode(key : number) : boolean {
        if(this.isEmpty()) {
            return false;
        }
        let prev : CircularLinkedList.Node = this.tail;
        let curr : CircularLinkedList.Node = this.tail.next;
        let head : CircularLinkedList.Node = this.tail.next;
        if(curr.value === key) {
            if(curr === curr.next) this.tail = null; else this.tail.next = this.tail.next.next;
            return true;
        }
        prev = curr;
        curr = curr.next;
        while((curr !== head)) {{
            if(curr.value === key) {
                if(curr === this.tail) this.tail = prev;
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }};
        return false;
    }

    public copyListReversed() : CircularLinkedList {
        let cl : CircularLinkedList = new CircularLinkedList();
        let curr : CircularLinkedList.Node = this.tail.next;
        let head : CircularLinkedList.Node = curr;
        if(curr != null) {
            cl.addHead(curr.value);
            curr = curr.next;
        }
        while((curr !== head)) {{
            cl.addHead(curr.value);
            curr = curr.next;
        }};
        return cl;
    }

    public copyList() : CircularLinkedList {
        let cl : CircularLinkedList = new CircularLinkedList();
        let curr : CircularLinkedList.Node = this.tail.next;
        let head : CircularLinkedList.Node = curr;
        if(curr != null) {
            cl.addTail(curr.value);
            curr = curr.next;
        }
        while((curr !== head)) {{
            cl.addTail(curr.value);
            curr = curr.next;
        }};
        return cl;
    }

    public searchList(data : number) : boolean {
        let temp : CircularLinkedList.Node = this.tail;
        for(let i : number = 0; i < this.__size; i++) {{
            if(temp.value === data) return true;
            temp = temp.next;
        };}
        return false;
    }

    public deleteList() {
        this.tail = null;
        this.__size = 0;
    }

    public print() {
        if(this.isEmpty()) {
            return;
        }
        let temp : CircularLinkedList.Node = this.tail.next;
        while((temp !== this.tail)) {{
            console.info(temp.value + " ");
            temp = temp.next;
        }};
        console.info(temp.value);
    }

    public static main(args : string[]) {
        let ll : CircularLinkedList = new CircularLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
    }

    constructor() {
        if(this.tail===undefined) this.tail = null;
    }
}
CircularLinkedList["__class"] = "CircularLinkedList";


namespace CircularLinkedList {

    export class Node {
        value : number;

        next : CircularLinkedList.Node;

        public constructor(v : number, n : CircularLinkedList.Node) {
            if(this.value===undefined) this.value = 0;
            if(this.next===undefined) this.next = null;
            this.value = v;
            this.next = n;
        }
    }
    Node["__class"] = "CircularLinkedList.Node";

}




CircularLinkedList.main(null);
