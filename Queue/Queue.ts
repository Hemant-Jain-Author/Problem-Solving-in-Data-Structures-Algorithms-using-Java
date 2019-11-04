/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class Queue {
    /*private*/ __size : number;

    /*private*/ capacity : number = 100;

    /*private*/ data : number[];

    front : number = 0;

    back : number = 0;

    public constructor() {
        if(this.__size===undefined) this.__size = 0;
        if(this.data===undefined) this.data = null;
        this.__size = 0;
        this.data = (s => { let a=[]; while(s-->0) a.push(0); return a; })(100);
    }

    public add(value : number) : boolean {
        if(this.__size >= this.capacity) {
            console.info("Queue is full.");
            return false;
        } else {
            this.__size++;
            this.data[this.back] = value;
            this.back = (++this.back) % (this.capacity - 1);
        }
        return true;
    }

    public remove() : number {
        let value : number;
        if(this.__size <= 0) {
            console.info("Queue is empty.");
            return -999;
        } else {
            this.__size--;
            value = this.data[this.front];
            this.front = (++this.front) % (this.capacity - 1);
        }
        return value;
    }

    isEmpty() : boolean {
        return this.__size === 0;
    }

    size() : number {
        return this.__size;
    }

    public static main(args : string[]) {
        let que : Queue = new Queue();
        for(let i : number = 0; i < 20; i++) {{
            que.add(i);
        };}
        for(let i : number = 0; i < 22; i++) {{
            console.info(que.remove());
        };}
    }
}
Queue["__class"] = "Queue";




Queue.main(null);
