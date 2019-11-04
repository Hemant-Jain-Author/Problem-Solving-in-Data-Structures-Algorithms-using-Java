/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class QuickSelect {
    public static quickSelect(arr : number[], lower : number, upper : number, k : number) {
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
                QuickSelect.swap(arr, upper, lower);
            }
        }};
        QuickSelect.swap(arr, upper, start);
        if(k < upper) QuickSelect.quickSelect(arr, start, upper - 1, k);
        if(k > upper) QuickSelect.quickSelect(arr, upper + 1, stop, k);
    }

    public static swap(arr : number[], first : number, second : number) {
        let temp : number = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static get(arr : number[], k : number) : number {
        QuickSelect.quickSelect(arr, 0, arr.length - 1, k);
        return arr[4];
    }

    public static main(args : string[]) {
        let array : number[] = [3, 4, 2, 1, 6, 5, 7, 8, 10, 9];
        console.info("value at index 5 is : " + QuickSelect.get(array, 5));
    }
}
QuickSelect["__class"] = "QuickSelect";




QuickSelect.main(null);
