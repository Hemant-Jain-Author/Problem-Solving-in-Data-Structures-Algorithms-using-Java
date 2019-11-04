/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class DoublyCircularLinkedList {
    /*private*/ head : DoublyCircularLinkedList.Node = null;

    /*private*/ tail : DoublyCircularLinkedList.Node = null;

    /*private*/ __size : number = 0;

    public size() : number {
        return this.__size;
    }

    public isEmpty() : boolean {
        return this.__size === 0;
    }

    public peekHead() : number {
        if(this.isEmpty()) throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        return this.head.value;
    }

    public addHead(value : number) {
        let newNode : DoublyCircularLinkedList.Node = new DoublyCircularLinkedList.Node(value, null, null);
        if(this.__size === 0) {
            this.tail = this.head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = this.head;
            newNode.prev = this.head.prev;
            this.head.prev = newNode;
            newNode.prev.next = newNode;
            this.head = newNode;
        }
        this.__size++;
    }

    public addTail(value : number) {
        let newNode : DoublyCircularLinkedList.Node = new DoublyCircularLinkedList.Node(value, null, null);
        if(this.__size === 0) {
            this.head = this.tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = this.tail.next;
            newNode.prev = this.tail;
            this.tail.next = newNode;
            newNode.next.prev = newNode;
            this.tail = newNode;
        }
        this.__size++;
    }

    public removeHead() : number {
        if(this.__size === 0) throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        let value : number = this.head.value;
        this.__size--;
        if(this.__size === 0) {
            this.head = null;
            this.tail = null;
            return value;
        }
        let next : DoublyCircularLinkedList.Node = this.head.next;
        next.prev = this.tail;
        this.tail.next = next;
        this.head = next;
        return value;
    }

    public removeTail() : number {
        if(this.__size === 0) throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        let value : number = this.tail.value;
        this.__size--;
        if(this.__size === 0) {
            this.head = null;
            this.tail = null;
            return value;
        }
        let prev : DoublyCircularLinkedList.Node = this.tail.prev;
        prev.next = this.head;
        this.head.prev = prev;
        this.tail = prev;
        return value;
    }

    public isPresent(key : number) : boolean {
        let temp : DoublyCircularLinkedList.Node = this.head;
        if(this.head == null) return false;
        do {{
            if(temp.value === key) return true;
            temp = temp.next;
        }} while((temp !== this.head));
        return false;
    }

    public deleteList() {
        this.head = null;
        this.tail = null;
        this.__size = 0;
    }

    public print() {
        if(this.isEmpty()) {
            return;
        }
        let temp : DoublyCircularLinkedList.Node = this.head;
        while((temp !== this.tail)) {{
            console.info(temp.value + " ");
            temp = temp.next;
        }};
        console.info(temp.value);
    }

    public static main(args : string[]) {
        let ll : DoublyCircularLinkedList = new DoublyCircularLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
    }
}
DoublyCircularLinkedList["__class"] = "DoublyCircularLinkedList";


namespace DoublyCircularLinkedList {

    export class Node {
        value : number;

        next : DoublyCircularLinkedList.Node;

        prev : DoublyCircularLinkedList.Node;

        public constructor(v? : any, nxt? : any, prv? : any) {
            if(((typeof v === 'number') || v === null) && ((nxt != null && nxt instanceof <any>DoublyCircularLinkedList.Node) || nxt === null) && ((prv != null && prv instanceof <any>DoublyCircularLinkedList.Node) || prv === null)) {
                let __args = arguments;
                if(this.value===undefined) this.value = 0;
                if(this.next===undefined) this.next = null;
                if(this.prev===undefined) this.prev = null;
                if(this.value===undefined) this.value = 0;
                if(this.next===undefined) this.next = null;
                if(this.prev===undefined) this.prev = null;
                (() => {
                    this.value = v;
                    this.next = nxt;
                    this.prev = prv;
                })();
            } else if(((typeof v === 'number') || v === null) && nxt === undefined && prv === undefined) {
                let __args = arguments;
                if(this.value===undefined) this.value = 0;
                if(this.next===undefined) this.next = null;
                if(this.prev===undefined) this.prev = null;
                if(this.value===undefined) this.value = 0;
                if(this.next===undefined) this.next = null;
                if(this.prev===undefined) this.prev = null;
                (() => {
                    this.value = v;
                    this.next = this;
                    this.prev = this;
                })();
            } else throw new Error('invalid overload');
        }
    }
    Node["__class"] = "DoublyCircularLinkedList.Node";

}




DoublyCircularLinkedList.main(null);
