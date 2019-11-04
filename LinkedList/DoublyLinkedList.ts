/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class DoublyLinkedList {
    /*private*/ head : DoublyLinkedList.Node;

    /*private*/ tail : DoublyLinkedList.Node;

    /*private*/ __size : number = 0;

    public size() : number {
        return this.__size;
    }

    public isEmpty() : boolean {
        return this.__size === 0;
    }

    public peek() : number {
        if(this.isEmpty()) throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        return this.head.value;
    }

    public addHead(value : number) {
        let newNode : DoublyLinkedList.Node = new DoublyLinkedList.Node(value, null, null);
        if(this.__size === 0) {
            this.tail = this.head = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.__size++;
    }

    public addTail(value : number) {
        let newNode : DoublyLinkedList.Node = new DoublyLinkedList.Node(value, null, null);
        if(this.__size === 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.__size++;
    }

    public removeHead() : number {
        if(this.isEmpty()) throw Object.defineProperty(new Error("EmptyListException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        let value : number = this.head.value;
        this.head = this.head.next;
        if(this.head == null) this.tail = null; else this.head.prev = null;
        this.__size--;
        return value;
    }

    public removeNode(key : number) : boolean {
        let curr : DoublyLinkedList.Node = this.head;
        if(curr == null) return false;
        if(curr.value === key) {
            this.head = this.head.next;
            this.__size--;
            if(this.head != null) this.head.prev = null; else this.tail = null;
            return true;
        }
        while((curr.next != null)) {{
            if(curr.next.value === key) {
                curr.next = curr.next.next;
                if(curr.next == null) this.tail = curr; else curr.next = curr;
                this.__size--;
                return true;
            }
            curr = curr.next;
        }};
        return false;
    }

    public isPresent(key : number) : boolean {
        let temp : DoublyLinkedList.Node = this.head;
        while((temp != null)) {{
            if(temp.value === key) return true;
            temp = temp.next;
        }};
        return false;
    }

    public deleteList() {
        this.head = null;
        this.tail = null;
        this.__size = 0;
    }

    public print() {
        let temp : DoublyLinkedList.Node = this.head;
        while((temp != null)) {{
            console.info(temp.value + " ");
            temp = temp.next;
        }};
    }

    public sortedInsert(value : number) {
        let temp : DoublyLinkedList.Node = new DoublyLinkedList.Node(value);
        let curr : DoublyLinkedList.Node = this.head;
        if(curr == null) {
            this.head = temp;
            this.tail = temp;
        }
        if(this.head.value <= value) {
            temp.next = this.head;
            this.head.prev = temp;
            this.head = temp;
        }
        while((curr.next != null && curr.next.value > value)) {{
            curr = curr.next;
        }};
        if(curr.next == null) {
            this.tail = temp;
            temp.prev = curr;
            curr.next = temp;
        } else {
            temp.next = curr.next;
            temp.prev = curr;
            curr.next = temp;
            temp.next.prev = temp;
        }
    }

    public reverseList() {
        let curr : DoublyLinkedList.Node = this.head;
        let tempNode : DoublyLinkedList.Node;
        while((curr != null)) {{
            tempNode = curr.next;
            curr.next = curr.prev;
            curr.prev = tempNode;
            if(curr.prev == null) {
                this.tail = this.head;
                this.head = curr;
                return;
            }
            curr = curr.prev;
        }};
        return;
    }

    public removeDuplicate() {
        let curr : DoublyLinkedList.Node = this.head;
        let deleteMe : DoublyLinkedList.Node;
        while((curr != null)) {{
            if((curr.next != null) && curr.value === curr.next.value) {
                deleteMe = curr.next;
                curr.next = deleteMe.next;
                curr.next.prev = curr;
                if(deleteMe === this.tail) {
                    this.tail = curr;
                }
            } else {
                curr = curr.next;
            }
        }};
    }

    public copyListReversed() : DoublyLinkedList {
        let dll : DoublyLinkedList = new DoublyLinkedList();
        let curr : DoublyLinkedList.Node = this.head;
        while((curr != null)) {{
            dll.addHead(curr.value);
            curr = curr.next;
        }};
        return dll;
    }

    public copyList() : DoublyLinkedList {
        let dll : DoublyLinkedList = new DoublyLinkedList();
        let curr : DoublyLinkedList.Node = this.head;
        while((curr != null)) {{
            dll.addTail(curr.value);
            curr = curr.next;
        }};
        return dll;
    }

    public static main(args : string[]) {
        let ll : DoublyLinkedList = new DoublyLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.addHead(4);
        ll.addHead(5);
        ll.addHead(6);
        ll.removeHead();
        ll.deleteList();
        ll.print();
        ll.addHead(11);
        ll.addHead(21);
        ll.addHead(31);
        ll.addHead(41);
        ll.addHead(51);
        ll.addHead(61);
        ll.print();
    }

    constructor() {
        if(this.head===undefined) this.head = null;
        if(this.tail===undefined) this.tail = null;
    }
}
DoublyLinkedList["__class"] = "DoublyLinkedList";


namespace DoublyLinkedList {

    export class Node {
        value : number;

        next : DoublyLinkedList.Node;

        prev : DoublyLinkedList.Node;

        public constructor(v? : any, nxt? : any, prv? : any) {
            if(((typeof v === 'number') || v === null) && ((nxt != null && nxt instanceof <any>DoublyLinkedList.Node) || nxt === null) && ((prv != null && prv instanceof <any>DoublyLinkedList.Node) || prv === null)) {
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
                    this.next = null;
                    this.prev = null;
                })();
            } else throw new Error('invalid overload');
        }
    }
    Node["__class"] = "DoublyLinkedList.Node";

}




DoublyLinkedList.main(null);
