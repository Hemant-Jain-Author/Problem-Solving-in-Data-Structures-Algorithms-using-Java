class Heap {
    static CAPACITY : number = 32;

    /*private*/ size : number;

    /*private*/ arr : number[];

    __isMinHeap : boolean;

    public constructor(array? : any, isMin? : any) {
        if(((array != null && array instanceof <any>Array && (array.length==0 || array[0] == null ||(typeof array[0] === 'number'))) || array === null) && ((typeof isMin === 'boolean') || isMin === null)) {
            let __args = arguments;
            if(this.size===undefined) this.size = 0;
            if(this.arr===undefined) this.arr = null;
            if(this.__isMinHeap===undefined) this.__isMinHeap = false;
            if(this.size===undefined) this.size = 0;
            if(this.arr===undefined) this.arr = null;
            if(this.__isMinHeap===undefined) this.__isMinHeap = false;
            (() => {
                this.size = array.length;
                this.arr = array;
                this.__isMinHeap = isMin;
                for(let i : number = ((this.size / 2|0)); i >= 0; i--) {{
                    this.proclateDown(i);
                };}
            })();
        } else if(((typeof array === 'boolean') || array === null) && isMin === undefined) {
            let __args = arguments;
            let isMin : any = __args[0];
            if(this.size===undefined) this.size = 0;
            if(this.arr===undefined) this.arr = null;
            if(this.__isMinHeap===undefined) this.__isMinHeap = false;
            if(this.size===undefined) this.size = 0;
            if(this.arr===undefined) this.arr = null;
            if(this.__isMinHeap===undefined) this.__isMinHeap = false;
            (() => {
                this.arr = (s => { let a=[]; while(s-->0) a.push(0); return a; })(Heap.CAPACITY);
                this.size = 0;
                this.__isMinHeap = isMin;
            })();
        } else throw new Error('invalid overload');
    }

    compare(arr : number[], first : number, second : number) : boolean {
        if(this.__isMinHeap) return (arr[first] - arr[second]) > 0; else return (arr[first] - arr[second]) < 0;
    }

    /*private*/ proclateDown(parent : number) {
        let lChild : number = 2 * parent + 1;
        let rChild : number = lChild + 1;
        let child : number = -1;
        let temp : number;
        if(lChild < this.size) {
            child = lChild;
        }
        if(rChild < this.size && this.compare(this.arr, lChild, rChild)) {
            child = rChild;
        }
        if(child !== -1 && this.compare(this.arr, parent, child)) {
            temp = this.arr[parent];
            this.arr[parent] = this.arr[child];
            this.arr[child] = temp;
            this.proclateDown(child);
        }
    }

    /*private*/ proclateUp(child : number) {
        let parent : number = ((child - 1) / 2|0);
        let temp : number;
        if(parent < 0) {
            return;
        }
        if(this.compare(this.arr, parent, child)) {
            temp = this.arr[child];
            this.arr[child] = this.arr[parent];
            this.arr[parent] = temp;
            this.proclateUp(parent);
        }
    }

    public add(value : number) {
        if(this.size === this.arr.length) {
            this.doubleSize();
        }
        this.arr[this.size++] = value;
        this.proclateUp(this.size - 1);
    }

    /*private*/ doubleSize() {
        let old : number[] = this.arr;
        this.arr = (s => { let a=[]; while(s-->0) a.push(0); return a; })(this.arr.length * 2);
        /* arraycopy */((srcPts, srcOff, dstPts, dstOff, size) => { if(srcPts !== dstPts || dstOff >= srcOff + size) { while (--size >= 0) dstPts[dstOff++] = srcPts[srcOff++];} else { let tmp = srcPts.slice(srcOff, srcOff + size); for (let i = 0; i < size; i++) dstPts[dstOff++] = tmp[i]; }})(old, 0, this.arr, 0, this.size);
    }

    public remove() : number {
        if(this.isEmpty()) {
            throw Object.defineProperty(new Error(), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        }
        let value : number = this.arr[0];
        this.arr[0] = this.arr[this.size - 1];
        this.size--;
        this.proclateDown(0);
        return value;
    }

    public print() {
        //for(let i : number = 0; i < this.size; i++) {{
            console.info(this.arr);//[i] + " ");
        //};}
    }

    public isEmpty() : boolean {
        return (this.size === 0);
    }

    public length() : number {
        return this.size;
    }

    public peek() : number {
        if(this.isEmpty()) {
            throw Object.defineProperty(new Error(), '__classes', { configurable: true, value: ['java.lang.Throwable','java.lang.IllegalStateException','java.lang.Object','java.lang.RuntimeException','java.lang.Exception'] });
        }
        return this.arr[0];
    }

    public static heapSort(array : number[], inc : boolean) {
        let hp : Heap = new Heap(array, !inc);
        for(let i : number = 0; i < array.length; i++) {{
            array[array.length - i - 1] = hp.remove();
        };}
    }

    public static main(args : string[]) {
        let a : number[] = [1, 9, 6, 7, 8, 0, 2, 4, 5, 3];
        let hp : Heap = new Heap(a, true);
        hp.add(-1);
        hp.add(100);
        hp.print();
        console.info();
        while((!hp.isEmpty())) {
            console.info(hp.remove() + " ");
        };
        console.info();
        let a2 : number[] = [1, 9, 6, 7, 8, 0, 2, 4, 5, 3];
        Heap.heapSort(a2, true);
        //for(let i : number = 0; i < a2.length; i++) {{
            console.info(a2);//[i] + " ");
        //};}
        console.info();
        let a3 : number[] = [1, 9, 6, 7, 8, 0, 2, 4, 5, 3];
        Heap.heapSort(a3, false);
        //for(let i : number = 0; i < a3.length; i++) {{
            console.info(a3);//[i] + " ");
        //};}
    }

    isMinHeap(arr : number[], size : number) : boolean {
        for(let i : number = 0; i <= ((size - 2) / 2|0); i++) {{
            if(2 * i + 1 < size) {
                if(arr[i] > arr[2 * i + 1]) {
                    return false;
                }
            }
            if(2 * i + 2 < size) {
                if(arr[i] > arr[2 * i + 2]) {
                    return false;
                }
            }
        };}
        return true;
    }

    isMaxHeap(arr : number[], size : number) : boolean {
        for(let i : number = 0; i <= ((size - 2) / 2|0); i++) {{
            if(2 * i + 1 < size) {
                if(arr[i] < arr[2 * i + 1]) {
                    return false;
                }
            }
            if(2 * i + 2 < size) {
                if(arr[i] < arr[2 * i + 2]) return false;
            }
        };}
        return true;
    }
}
Heap["__class"] = "Heap";

Heap.main(null);