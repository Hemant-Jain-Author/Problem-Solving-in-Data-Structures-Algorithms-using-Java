/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class TwoStack {
    /*private*/ MAX_SIZE : number = 50;

    top1 : number;

    top2 : number;

    data : number[];

    public constructor() {
        if(this.top1===undefined) this.top1 = 0;
        if(this.top2===undefined) this.top2 = 0;
        if(this.data===undefined) this.data = null;
        this.top1 = -1;
        this.top2 = this.MAX_SIZE;
        this.data = (s => { let a=[]; while(s-->0) a.push(0); return a; })(this.MAX_SIZE);
    }

    public static main(args : string[]) {
        let st : TwoStack = new TwoStack();
        for(let i : number = 0; i < 10; i++) {{
            st.StackPush1(i);
        };}
        for(let j : number = 0; j < 10; j++) {{
            st.StackPush2(j + 10);
        };}
        for(let i : number = 0; i < 10; i++) {{
            console.info("stack one pop value is : " + st.StackPop1());
            console.info("stack two pop value is : " + st.StackPop2());
        };}
    }

    public StackPush1(value : number) {
        if(this.top1 < this.top2 - 1) {
            this.data[++this.top1] = value;
        } else {
            console.info("Stack is Full!");
        }
    }

    public StackPush2(value : number) {
        if(this.top1 < this.top2 - 1) {
            this.data[--this.top2] = value;
        } else {
            console.info("Stack is Full!");
        }
    }

    public StackPop1() : number {
        if(this.top1 >= 0) {
            let value : number = this.data[this.top1--];
            return value;
        } else {
            console.info("Stack Empty!");
        }
        return -999;
    }

    public StackPop2() : number {
        if(this.top2 < this.MAX_SIZE) {
            let value : number = this.data[this.top2++];
            return value;
        } else {
            console.info("Stack Empty!");
        }
        return -999;
    }
}
TwoStack["__class"] = "TwoStack";




TwoStack.main(null);
