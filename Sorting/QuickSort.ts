/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class QuickSort {
    /*private*/ static quickSort(arr : number[], lower : number, upper : number) {
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
                QuickSort.swap(arr, upper, lower);
            }
        }};
        QuickSort.swap(arr, upper, start);
        QuickSort.quickSort(arr, start, upper - 1);
        QuickSort.quickSort(arr, upper + 1, stop);
    }

    public static sort(arr : number[]) {
        let size : number = arr.length;
        QuickSort.quickSort(arr, 0, size - 1);
    }

    /*private*/ static swap(arr : number[], first : number, second : number) {
        let temp : number = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static main(args : string[]) {
        let array : number[] = [3, 4, 2, 1, 6, 5, 7, 8, 1, 1];
        QuickSort.sort(array);
        for(let i : number = 0; i < array.length; i++) {{
            console.info(array[i] + " ");
        };}
    }
}
QuickSort["__class"] = "QuickSort";




QuickSort.main(null);
