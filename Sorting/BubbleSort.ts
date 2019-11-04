/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class BubbleSort {
    /*private*/ static less(value1 : number, value2 : number) : boolean {
        return value1 < value2;
    }

    /*private*/ static more(value1 : number, value2 : number) : boolean {
        return value1 > value2;
    }

    public static sort(arr : number[]) {
        let size : number = arr.length;
        let i : number;
        let j : number;
        let temp : number;
        for(i = 0; i < (size - 1); i++) {{
            for(j = 0; j < size - i - 1; j++) {{
                if(BubbleSort.more(arr[j], arr[j + 1])) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            };}
        };}
    }

    public static sort2(arr : number[]) {
        let size : number = arr.length;
        let i : number;
        let j : number;
        let temp : number;
        let swapped : number = 1;
        for(i = 0; i < (size - 1) && swapped === 1; i++) {{
            swapped = 0;
            for(j = 0; j < size - i - 1; j++) {{
                if(BubbleSort.more(arr[j], arr[j + 1])) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = 1;
                }
            };}
        };}
    }

    public static main(args : string[]) {
        let array : number[] = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        BubbleSort.sort(array);
        for(let i : number = 0; i < array.length; i++) {{
            console.info(array[i] + " ");
        };}
        console.info();
        let array2 : number[] = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        BubbleSort.sort2(array2);
        for(let i : number = 0; i < array2.length; i++) {{
            console.info(array2[i] + " ");
        };}
    }
}
BubbleSort["__class"] = "BubbleSort";




BubbleSort.main(null);
