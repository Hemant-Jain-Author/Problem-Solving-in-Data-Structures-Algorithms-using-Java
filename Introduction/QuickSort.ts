class QuickSort {
    /*private*/ arr : number[];

    public constructor(array : number[]) {
        if(this.arr===undefined) this.arr = null;
        this.arr = array;
    }

    /*private*/ swap(arr : number[], first : number, second : number) {
        let temp : number = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    /*private*/ quickSortUtil(arr : number[], lower : number, upper : number) {
        if(upper <= lower) return;
        let pivot : number = arr[lower];
        let start : number = lower;
        let stop : number = upper;
        while((lower < upper)) {{
            while((arr[lower] <= pivot && lower < upper)) {{
                lower++;
            }};
            while((arr[upper] > pivot && lower <= upper)) {{
                upper--;
            }};
            if(lower < upper) {
                this.swap(arr, upper, lower);
            }
        }};
        this.swap(arr, upper, start);
        this.quickSortUtil(arr, start, upper - 1);
        this.quickSortUtil(arr, upper + 1, stop);
    }

    public sort() {
        let size : number = this.arr.length;
        this.quickSortUtil(this.arr, 0, size - 1);
    }

    public static main(args : string[]) {
        let array : number[] = [3, 4, 2, 1, 6, 5, 7, 8, 1, 1];
        let m : QuickSort = new QuickSort(array);
        m.sort();
        for(let i : number = 0; i < array.length; i++) {{
            console.info(array[i] + " ");
        };}
    }
}
QuickSort["__class"] = "QuickSort";




QuickSort.main(null);
