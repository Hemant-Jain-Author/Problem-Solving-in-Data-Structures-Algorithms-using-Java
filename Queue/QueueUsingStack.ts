/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class QueueUsingStack {
    /*private*/ stk1 : Array<number>;

    /*private*/ stk2 : Array<number>;

    public constructor() {
        if(this.stk1===undefined) this.stk1 = null;
        if(this.stk2===undefined) this.stk2 = null;
        this.stk1 = <any>([]);
        this.stk2 = <any>([]);
    }

    add(value : number) {
        /* push */(this.stk1.push(value)>0);
    }

    remove() : number {
        let value : number;
        if(/* isEmpty */(this.stk2.length == 0) === false) {
            return /* pop */this.stk2.pop();
        }
        while((/* isEmpty */(this.stk1.length == 0) === false)) {{
            value = /* pop */this.stk1.pop();
            /* push */(this.stk2.push(value)>0);
        }};
        return /* pop */this.stk2.pop();
    }

    public static main(args : string[]) {
        let que : QueueUsingStack = new QueueUsingStack();
        que.add(1);
        que.add(11);
        que.add(111);
        console.info(que.remove());
        console.info(que.remove());
    }
}
QueueUsingStack["__class"] = "QueueUsingStack";




QueueUsingStack.main(null);
