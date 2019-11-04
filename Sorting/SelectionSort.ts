/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class SelectionSort {
    /*private*/ more(value1 : number, value2 : number) : boolean {
        return value1 > value2;
    }

    public static sort(arr : number[]) {
        let size : number = arr.length;
        let i : number;
        let j : number;
        let max : number;
        let temp : number;
        for(i = 0; i < size - 1; i++) {{
            max = 0;
            for(j = 1; j < size - i; j++) {{
                if(arr[j] > arr[max]) {
                    max = j;
                }
            };}
            temp = arr[size - 1 - i];
            arr[size - 1 - i] = arr[max];
            arr[max] = temp;
        };}
    }

    public static sort2(arr : number[]) {
        let size : number = arr.length;
        let i : number;
        let j : number;
        let min : number;
        let temp : number;
        for(i = 0; i < size - 1; i++) {{
            min = i;
            for(j = i + 1; j < size; j++) {{
                if(arr[j] < arr[min]) {
                    min = j;
                }
            };}
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        };}
    }

    public static main(args : string[]) {
        let array : number[] = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        SelectionSort.sort(array);
        for(let i : number = 0; i < array.length; i++) {{
            console.info(array[i] + " ");
        };}
        console.info();
        let array2 : number[] = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        SelectionSort.sort2(array2);
        for(let i : number = 0; i < array2.length; i++) {{
            console.info(array2[i] + " ");
        };}
    }
}
SelectionSort["__class"] = "SelectionSort";




SelectionSort.main(null);
