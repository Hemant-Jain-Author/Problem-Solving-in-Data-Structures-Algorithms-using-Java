/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class Stack2 {
    /*private*/ data : number[];

    /*private*/ __top : number = -1;

    /*private*/ minCapacity : number;

    /*private*/ capacity : number;

    public constructor(size? : any) {
        if(((typeof size === 'number') || size === null)) {
            let __args = arguments;
            if(this.data===undefined) this.data = null;
            if(this.minCapacity===undefined) this.minCapacity = 0;
            if(this.capacity===undefined) this.capacity = 0;
            this.__top = -1;
            if(this.data===undefined) this.data = null;
            if(this.minCapacity===undefined) this.minCapacity = 0;
            if(this.capacity===undefined) this.capacity = 0;
            (() => {
                this.data = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
                this.capacity = this.minCapacity = size;
            })();
        } else if(size === undefined) {
            let __args = arguments;
            {
                let __args = arguments;
                let size : any = 1000;
                if(this.data===undefined) this.data = null;
                if(this.minCapacity===undefined) this.minCapacity = 0;
                if(this.capacity===undefined) this.capacity = 0;
                this.__top = -1;
                if(this.data===undefined) this.data = null;
                if(this.minCapacity===undefined) this.minCapacity = 0;
                if(this.capacity===undefined) this.capacity = 0;
                (() => {
                    this.data = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
                    this.capacity = this.minCapacity = size;
                })();
            }
        } else throw new Error('invalid overload');
    }

    public size() : number {
        return (this.__top + 1);
    }

    public isEmpty() : boolean {
        return (this.__top === -1);
    }

    public push(value : number) {
        if(this.size() === this.capacity) {
            console.info("size dubbelled");
            let newData : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(this.capacity * 2);
            /* arraycopy */((srcPts, srcOff, dstPts, dstOff, size) => { if(srcPts !== dstPts || dstOff >= srcOff + size) { while (--size >= 0) dstPts[dstOff++] = srcPts[srcOff++];} else { let tmp = srcPts.slice(srcOff, srcOff + size); for (let i = 0; i < size; i++) dstPts[dstOff++] = tmp[i]; }})(this.data, 0, newData, 0, this.capacity);
            this.data = newData;
            this.capacity = this.capacity * 2;
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
        if(this.size() === (this.capacity / 2|0) && this.capacity > this.minCapacity) {
            console.info("size halfed");
            this.capacity = (this.capacity / 2|0);
            let newData : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(this.capacity);
            /* arraycopy */((srcPts, srcOff, dstPts, dstOff, size) => { if(srcPts !== dstPts || dstOff >= srcOff + size) { while (--size >= 0) dstPts[dstOff++] = srcPts[srcOff++];} else { let tmp = srcPts.slice(srcOff, srcOff + size); for (let i = 0; i < size; i++) dstPts[dstOff++] = tmp[i]; }})(this.data, 0, newData, 0, this.capacity);
            this.data = newData;
        }
        return topVal;
    }

    public print() {
        for(let i : number = this.__top; i > -1; i--) {{
            console.info(" " + this.data[i]);
        };}
    }

    public static main(args : string[]) {
        let s : Stack2 = new Stack2(10);
        for(let i : number = 1; i <= 100; i++) {{
            s.push(i);
        };}
        for(let i : number = 1; i <= 100; i++) {{
            s.pop();
        };}
        s.print();
    }
}
Stack2["__class"] = "Stack2";




Stack2.main(null);
