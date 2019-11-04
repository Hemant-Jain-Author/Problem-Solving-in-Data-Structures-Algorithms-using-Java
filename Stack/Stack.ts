/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class Stack {
    /*private*/ capacity : number = 1000;

    /*private*/ data : number[];

    /*private*/ __top : number = -1;

    public constructor(size? : any) {
        if(((typeof size === 'number') || size === null)) {
            let __args = arguments;
            if(this.data===undefined) this.data = null;
            this.capacity = 1000;
            this.__top = -1;
            if(this.data===undefined) this.data = null;
            (() => {
                this.data = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
                this.capacity = size;
            })();
        } else if(size === undefined) {
            let __args = arguments;
            if(this.data===undefined) this.data = null;
            this.capacity = 1000;
            this.__top = -1;
            if(this.data===undefined) this.data = null;
            (() => {
                this.data = (s => { let a=[]; while(s-->0) a.push(0); return a; })(this.capacity);
            })();
        } else throw new Error('invalid overload');
    }

    public size() : number {
        return (this.__top + 1);
    }

    public isEmpty() : boolean {
        return (this.__top === -1);
    }

    public push(value : number) {
        if(this.size() === this.data.length) {
            throw Object.defineProperty(new Error("StackOvarflowException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        }
        this.__top++;
        this.data[this.__top] = value;
    }

    public top() : number {
        if(this.isEmpty()) {
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        }
        return this.data[this.__top];
    }

    public pop() : number {
        if(this.isEmpty()) {
            throw Object.defineProperty(new Error("StackEmptyException"), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        }
        let topVal : number = this.data[this.__top];
        this.__top--;
        return topVal;
    }

    public print() {
        for(let i : number = this.__top; i > -1; i--) {{
            console.info(this.data[i] + " ");
        };}
        console.info("");
    }

    public static main(args : string[]) {
        let s : Stack = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.print();
        console.info(s.pop());
        console.info(s.pop());
        s.print();
    }
}
Stack["__class"] = "Stack";

Stack.main(null);