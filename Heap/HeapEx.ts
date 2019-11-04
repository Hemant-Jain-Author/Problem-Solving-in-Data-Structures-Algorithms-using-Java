class HeapEx {
    public static demo(args : string[]) {
        let pq : java.util.PriorityQueue<number> = <any>(new java.util.PriorityQueue<number>());
        let arr : number[] = [1, 2, 10, 8, 7, 3, 4, 6, 5, 9];
        for(let index8207=0; index8207 < arr.length; index8207++) {
            let i = arr[index8207];
            {
                pq.add(i);
            }
        }
        console.info("Printing Priority Queue Heap : " + pq);
        console.info("Dequeue elements of Priority Queue ::");
        while((pq.isEmpty() === false)) {{
            console.info(" " + pq.remove());
        }};
    }

    public static KthSmallest(arr : number[], size : number, k : number) : number {
        /* sort */((l) => {l.sort(); })(arr);
        return arr[k - 1];
    }

    public static KthSmallest2(arr : number[], size : number, k : number) : number {
        let i : number = 0;
        let value : number = 0;
        let pq : java.util.PriorityQueue<number> = <any>(new java.util.PriorityQueue<number>());
        for(i = 0; i < size; i++) {{
            pq.add(arr[i]);
        };}
        while((i < size && i < k)) {{
            value = pq.remove();
            i += 1;
        }};
        return value;
    }

    public static isMinHeap(arr : number[], size : number) : boolean {
        let lchild : number;
        let rchild : number;
        for(let parent : number = 0; parent < ((size / 2|0) + 1); parent++) {{
            lchild = parent * 2 + 1;
            rchild = parent * 2 + 2;
            if(((lchild < size) && (arr[parent] > arr[lchild])) || ((rchild < size) && (arr[parent] > arr[rchild]))) return false;
        };}
        return true;
    }

    public static isMaxHeap(arr : number[], size : number) : boolean {
        let lchild : number;
        let rchild : number;
        for(let parent : number = 0; parent < ((size / 2|0) + 1); parent++) {{
            lchild = parent * 2 + 1;
            rchild = lchild + 1;
            if(((lchild < size) && (arr[parent] < arr[lchild])) || ((rchild < size) && (arr[parent] < arr[rchild]))) return false;
        };}
        return true;
    }

    public static main2(args : string[]) {
        let arr : number[] = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("Kth Smallest :: " + HeapEx.KthSmallest(arr, arr.length, 3));
        let arr2 : number[] = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("Kth Smallest :: " + HeapEx.KthSmallest2(arr2, arr2.length, 3));
        let arr3 : number[] = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("isMaxHeap :: " + HeapEx.isMaxHeap(arr3, arr3.length));
        let arr4 : number[] = [8, 7, 6, 5, 7, 5, 2, 1];
        /* sort */((l) => {l.sort(); })(arr4);
        console.info("isMinHeap :: " + HeapEx.isMinHeap(arr4, arr4.length));
    }

    public static KSmallestProduct(arr : number[], size : number, k : number) : number {
        /* sort */((l) => {l.sort(); })(arr);
        let product : number = 1;
        for(let i : number = 0; i < k; i++) {product *= arr[i];}
        return product;
    }

    public static swap(arr : number[], i : number, j : number) {
        let temp : number = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static QuickSelectUtil(arr : number[], lower : number, upper : number, k : number) {
        if(upper <= lower) return;
        let pivot : number = arr[lower];
        let start : number = lower;
        let stop : number = upper;
        while((lower < upper)) {{
            while((lower < upper && arr[lower] <= pivot)) {{
                lower++;
            }};
            while((lower <= upper && arr[upper] > pivot)) {{
                upper--;
            }};
            if(lower < upper) {
                HeapEx.swap(arr, upper, lower);
            }
        }};
        HeapEx.swap(arr, upper, start);
        if(k < upper) HeapEx.QuickSelectUtil(arr, start, upper - 1, k);
        if(k > upper) HeapEx.QuickSelectUtil(arr, upper + 1, stop, k);
    }

    public static KSmallestProduct3(arr : number[], size : number, k : number) : number {
        HeapEx.QuickSelectUtil(arr, 0, size - 1, k);
        let product : number = 1;
        for(let i : number = 0; i < k; i++) {product *= arr[i];}
        return product;
    }

    public static KSmallestProduct2(arr : number[], size : number, k : number) : number {
        let pq : java.util.PriorityQueue<number> = <any>(new java.util.PriorityQueue<number>());
        let i : number = 0;
        let product : number = 1;
        for(i = 0; i < size; i++) {{
            pq.add(arr[i]);
        };}
        while((i < size && i < k)) {{
            product *= pq.remove();
            i += 1;
        }};
        return product;
    }

    public static main3(args : string[]) {
        let arr : number[] = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("Kth Smallest product:: " + HeapEx.KSmallestProduct(arr, 8, 3));
        let arr2 : number[] = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("Kth Smallest product:: " + HeapEx.KSmallestProduct2(arr2, 8, 3));
        let arr3 : number[] = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("Kth Smallest product:: " + HeapEx.KSmallestProduct3(arr3, 8, 3));
    }

    public static PrintLargerHalf(arr : number[], size : number) {
        /* sort */((l) => {l.sort(); })(arr);
        for(let i : number = (size / 2|0); i < size; i++) {console.info(arr[i]);}
        console.info();
    }

    public static PrintLargerHalf2(arr : number[], size : number) {
        let product : number = 1;
        let pq : java.util.PriorityQueue<number> = <any>(new java.util.PriorityQueue<number>());
        for(let i : number = 0; i < size; i++) {{
            pq.add(arr[i]);
        };}
        for(let i : number = 0; i < (size / 2|0); i++) {pq.remove();}
        console.info(pq);
    }

    public static PrintLargerHalf3(arr : number[], size : number) {
        HeapEx.QuickSelectUtil(arr, 0, size - 1, (size / 2|0));
        for(let i : number = (size / 2|0); i < size; i++) {console.info(arr[i]);}
        console.info();
    }

    public static main4(args : string[]) {
        let arr : number[] = [8, 7, 6, 5, 7, 5, 2, 1];
        HeapEx.PrintLargerHalf(arr, 8);
        let arr2 : number[] = [8, 7, 6, 5, 7, 5, 2, 1];
        HeapEx.PrintLargerHalf2(arr2, 8);
        let arr3 : number[] = [8, 7, 6, 5, 7, 5, 2, 1];
        HeapEx.PrintLargerHalf3(arr3, 8);
    }

    public static sortK(arr : number[], size : number, k : number) {
        let pq : java.util.PriorityQueue<number> = <any>(new java.util.PriorityQueue<number>());
        let i : number = 0;
        for(i = 0; i < size; i++) {{
            pq.add(arr[i]);
        };}
        let output : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        let index : number = 0;
        for(i = k; i < size; i++) {{
            output[index++] = pq.remove();
            pq.add(arr[i]);
        };}
        while((pq.size() > 0)) {output[index++] = pq.remove()};
        for(i = k; i < size; i++) {{
            arr[i] = output[i];
        };}
        console.info(output);
    }

    public static main5(args : string[]) {
        let k : number = 3;
        let arr : number[] = [1, 5, 4, 10, 50, 9];
        let size : number = arr.length;
        HeapEx.sortK(arr, size, k);
    }

    public static ChotaBhim(cups : number[], size : number) : number {
        let time : number = 60;
        /* sort */((l) => {l.sort(); })(cups);
        let total : number = 0;
        let index : number;
        let temp : number;
        while((time > 0)) {{
            total += cups[0];
            cups[0] = (<number>Math.ceil(cups[0] / 2.0)|0);
            index = 0;
            temp = cups[0];
            while((index < size - 1 && temp < cups[index + 1])) {{
                cups[index] = cups[index + 1];
                index += 1;
            }};
            cups[index] = temp;
            time -= 1;
        }};
        console.info("Total %d " + total);
        return total;
    }

    public static ChotaBhim2(cups : number[], size : number) : number {
        let time : number = 60;
        /* sort */((l) => {l.sort(); })(cups);
        let total : number = 0;
        let i : number;
        let temp : number;
        while((time > 0)) {{
            total += cups[0];
            cups[0] = (<number>Math.ceil(cups[0] / 2.0)|0);
            i = 0;
            while((i < size - 1)) {{
                if(cups[i] > cups[i + 1]) break;
                temp = cups[i];
                cups[i] = cups[i + 1];
                cups[i + 1] = temp;
                i += 1;
            }};
            time -= 1;
        }};
        console.info("Total : " + total);
        return total;
    }

    public static ChotaBhim3(cups : number[], size : number) : number {
        let time : number = 60;
        let pq : java.util.PriorityQueue<number> = <any>(new java.util.PriorityQueue<number>());
        let i : number = 0;
        for(i = 0; i < size; i++) {{
            pq.add(cups[i]);
        };}
        let total : number = 0;
        let value : number;
        while((time > 0)) {{
            value = pq.remove();
            total += value;
            value = (<number>Math.ceil(value / 2.0)|0);
            pq.add(value);
            time -= 1;
        }};
        console.info("Total : " + total);
        return total;
    }

    public static JoinRopes(ropes : number[], size : number) : number {
        /* sort */((l) => {l.sort(); })(ropes);
        console.info(ropes);
        let total : number = 0;
        let value : number = 0;
        let temp : number;
        let index : number;
        let length : number = size;
        while((length >= 2)) {{
            value = ropes[length - 1] + ropes[length - 2];
            total += value;
            index = length - 2;
            while((index > 0 && ropes[index - 1] < value)) {{
                ropes[index] = ropes[index - 1];
                index -= 1;
            }};
            ropes[index] = value;
            length--;
        }};
        console.info("Total : " + total);
        return total;
    }

    public static JoinRopes2(ropes : number[], size : number) : number {
        let pq : java.util.PriorityQueue<number> = <any>(new java.util.PriorityQueue<number>());
        let i : number = 0;
        for(i = 0; i < size; i++) {{
            pq.add(ropes[i]);
        };}
        let total : number = 0;
        let value : number = 0;
        while((pq.size() > 1)) {{
            value = pq.remove();
            value += pq.remove();
            pq.add(value);
            total += value;
        }};
        console.info("Total : %d " + total);
        return total;
    }

    public static main6(args : string[]) {
        let cups : number[] = [2, 1, 7, 4, 2];
        HeapEx.ChotaBhim(cups, cups.length);
        let cups2 : number[] = [2, 1, 7, 4, 2];
        HeapEx.ChotaBhim2(cups2, cups.length);
        let cups3 : number[] = [2, 1, 7, 4, 2];
        HeapEx.ChotaBhim3(cups3, cups.length);
        let ropes : number[] = [2, 1, 7, 4, 2];
        HeapEx.JoinRopes(ropes, ropes.length);
        let rope2 : number[] = [2, 1, 7, 4, 2];
        HeapEx.JoinRopes2(rope2, rope2.length);
    }

    public static kthLargestStream(k : number) {
        let pq : java.util.PriorityQueue<number> = <any>(new java.util.PriorityQueue<number>());
        let size : number = 0;
        let data : number = 0;
        while((true)) {{
            console.info("Enter data: ");
            if(size < k - 1) pq.add(data); else {
                if(size === k - 1) pq.add(data); else if(pq.peek() < data) {
                    pq.add(data);
                    pq.remove();
                }
                console.info("Kth larges element is :: " + pq.peek());
            }
            size += 1;
        }};
    }

    public static main(args : string[]) {
        HeapEx.kthLargestStream(3);
    }
}
HeapEx["__class"] = "HeapEx";




HeapEx.main(null);
