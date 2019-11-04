/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class MergeSort1 {
    /*private*/ static mergeSrt(arr : number[], tempArray : number[], lowerIndex : number, upperIndex : number) {
        if(lowerIndex >= upperIndex) {
            return;
        }
        let middleIndex : number = ((lowerIndex + upperIndex) / 2|0);
        MergeSort1.mergeSrt(arr, tempArray, lowerIndex, middleIndex);
        MergeSort1.mergeSrt(arr, tempArray, middleIndex + 1, upperIndex);
        let lowerStart : number = lowerIndex;
        let lowerStop : number = middleIndex;
        let upperStart : number = middleIndex + 1;
        let upperStop : number = upperIndex;
        let count : number = lowerIndex;
        while((lowerStart <= lowerStop && upperStart <= upperStop)) {{
            if(arr[lowerStart] < arr[upperStart]) {
                tempArray[count++] = arr[lowerStart++];
            } else {
                tempArray[count++] = arr[upperStart++];
            }
        }};
        while((lowerStart <= lowerStop)) {{
            tempArray[count++] = arr[lowerStart++];
        }};
        while((upperStart <= upperStop)) {{
            tempArray[count++] = arr[upperStart++];
        }};
        for(let i : number = lowerIndex; i <= upperIndex; i++) {{
            arr[i] = tempArray[i];
        };}
    }

    public static sort(arr : number[]) {
        let size : number = arr.length;
        let tempArray : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        MergeSort1.mergeSrt(arr, tempArray, 0, size - 1);
    }

    public static main(args : string[]) {
        let array : number[] = [3, 4, 2, 1, 6, 5, 7, 8, 1, 1];
        MergeSort1.sort(array);
        for(let i : number = 0; i < array.length; i++) {{
            console.info(array[i] + " ");
        };}
    }
}
MergeSort1["__class"] = "MergeSort1";




MergeSort1.main(null);
