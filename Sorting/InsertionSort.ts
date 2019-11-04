/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class InsertionSort {
    /*private*/ static more(value1 : number, value2 : number) : boolean {
        return value1 > value2;
    }

    public static sort(arr : number[]) {
        let size : number = arr.length;
        let temp : number;
        let j : number;
        for(let i : number = 1; i < size; i++) {{
            temp = arr[i];
            for(j = i; j > 0 && InsertionSort.more(arr[j - 1], temp); j--) {{
                arr[j] = arr[j - 1];
            };}
            arr[j] = temp;
        };}
    }

    public static main(args : string[]) {
        let array : number[] = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        InsertionSort.sort(array);
        for(let i : number = 0; i < array.length; i++) {{
            console.info(array[i] + " ");
        };}
    }
}
InsertionSort["__class"] = "InsertionSort";




InsertionSort.main(null);
