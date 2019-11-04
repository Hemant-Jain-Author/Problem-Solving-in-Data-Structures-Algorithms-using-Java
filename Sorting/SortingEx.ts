/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class SortingEx {
    public static printArray(arr : number[], count : number) {
        console.info("[");
        for(let i : number = 0; i < count; i++) {{
            console.info(" " + arr[i]);
        };}
        console.info(" ]\n");
    }

    public static swap(arr : number[], x : number, y : number) {
        let temp : number = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return;
    }

    public static Partition01(arr : number[], size : number) : number {
        let left : number = 0;
        let right : number = size - 1;
        let count : number = 0;
        while((left < right)) {{
            while((arr[left] === 0)) {left += 1};
            while((arr[right] === 1)) {right -= 1};
            if(left < right) {
                SortingEx.swap(arr, left, right);
                count += 1;
            }
        }};
        return count;
    }

    public static Partition012(arr : number[], size : number) {
        let left : number = 0;
        let right : number = size - 1;
        let i : number = 0;
        while((i <= right)) {{
            if(arr[i] === 0) {
                SortingEx.swap(arr, i, left);
                i += 1;
                left += 1;
            } else if(arr[i] === 2) {
                SortingEx.swap(arr, i, right);
                right -= 1;
            } else {
                i += 1;
            }
        }};
    }

    public static main1(args : string[]) {
        let arr : number[] = [0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1];
        SortingEx.Partition01(arr, arr.length);
        SortingEx.printArray(arr, arr.length);
        let arr2 : number[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1];
        SortingEx.Partition012(arr2, arr2.length);
        SortingEx.printArray(arr2, arr2.length);
    }

    public static RangePartition(arr : number[], size : number, lower : number, higher : number) {
        let start : number = 0;
        let end : number = size - 1;
        let i : number = 0;
        while((i <= end)) {{
            if(arr[i] < lower) {
                SortingEx.swap(arr, i, start);
                i += 1;
                start += 1;
            } else if(arr[i] > higher) {
                SortingEx.swap(arr, i, end);
                end -= 1;
            } else {
                i += 1;
            }
        }};
    }

    public static main3(args : string[]) {
        let arr : number[] = [1, 21, 2, 20, 3, 19, 4, 18, 5, 17, 6, 16, 7, 15, 8, 14, 9, 13, 10, 12, 11];
        SortingEx.RangePartition(arr, arr.length, 9, 12);
        SortingEx.printArray(arr, arr.length);
    }

    minSwaps(arr : number[], size : number, val : number) : number {
        let swapCount : number = 0;
        let first : number = 0;
        let second : number = size - 1;
        let temp : number;
        while((first < second)) {{
            if(arr[first] <= val) first += 1; else if(arr[second] > val) second -= 1; else {
                temp = arr[first];
                arr[first] = arr[second];
                arr[second] = temp;
                swapCount += 1;
            }
        }};
        return swapCount;
    }

    public static seperateEvenAndOdd(data : number[], size : number) {
        let left : number = 0;
        let right : number = size - 1;
        while((left < right)) {{
            if(data[left] % 2 === 0) left++; else if(data[right] % 2 === 1) right--; else {
                SortingEx.swap(data, left, right);
                left++;
                right--;
            }
        }};
    }

    public static AbsMore(value1 : number, value2 : number, ref : number) : boolean {
        return (Math.abs(value1 - ref) > Math.abs(value2 - ref));
    }

    public static AbsBubbleSort(arr : number[], size : number, ref : number) {
        for(let i : number = 0; i < (size - 1); i++) {{
            for(let j : number = 0; j < (size - i - 1); j++) {{
                if(SortingEx.AbsMore(arr[j], arr[j + 1], ref)) {
                    SortingEx.swap(arr, j, j + 1);
                }
            };}
        };}
    }

    public static main4(args : string[]) {
        let array : number[] = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        let ref : number = 5;
        SortingEx.AbsBubbleSort(array, array.length, ref);
        SortingEx.printArray(array, array.length);
    }

    public static EqMore(value1 : number, value2 : number, A : number) : boolean {
        value1 = A * value1 * value1;
        value2 = A * value2 * value2;
        return value1 > value2;
    }

    public static ArrayReduction(arr : number[], size : number) {
        /* sort */((l) => {l.sort(); })(arr);
        let count : number = 1;
        let reduction : number = arr[0];
        for(let i : number = 0; i < size; i++) {{
            if(arr[i] - reduction > 0) {
                console.info(size - i);
                reduction = arr[i];
                count += 1;
            }
        };}
        console.info("Total number of reductions " + count);
    }

    public static main88(args : string[]) {
        let arr : number[] = [5, 1, 1, 1, 2, 3, 5];
        SortingEx.ArrayReduction(arr, arr.length);
    }

    public static SortByOrder(arr : number[], size : number, arr2 : number[], size2 : number) {
        let ht : any = <any>({});
        let value : number;
        for(let i : number = 0; i < size; i++) {{
            if(/* containsKey */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return true; } return false; })(<any>ht, arr[i])) {
                value = /* get */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries[i].value; } return null; })(<any>ht, arr[i]);
                /* put */((m,k,v) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { m.entries[i].value=v; return; } m.entries.push({key:k,value:v,getKey: function() { return this.key }, getValue: function() { return this.value }}); })(<any>ht, arr[i], value + 1);
            } else {
                /* put */((m,k,v) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { m.entries[i].value=v; return; } m.entries.push({key:k,value:v,getKey: function() { return this.key }, getValue: function() { return this.value }}); })(<any>ht, arr[i], 1);
            }
        };}
        for(let j : number = 0; j < size2; j++) {{
            if(/* containsKey */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return true; } return false; })(<any>ht, arr2[j])) {
                value = /* get */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries[i].value; } return null; })(<any>ht, arr2[j]);
                for(let k : number = 0; k < value; k++) {{
                    console.info(arr2[j]);
                };}
                /* remove */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries.splice(i,1)[0]; } })(<any>ht, arr2[j]);
            }
        };}
        for(let i : number = 0; i < size; i++) {{
            if(/* containsKey */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return true; } return false; })(<any>ht, arr[i])) {
                value = /* get */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries[i].value; } return null; })(<any>ht, arr[i]);
                for(let k : number = 0; k < value; k++) {{
                    console.info(arr[i]);
                };}
                /* remove */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries.splice(i,1)[0]; } })(<any>ht, arr[i]);
            }
        };}
    }

    public static main7(args : string[]) {
        let arr : number[] = [2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8];
        let arr2 : number[] = [2, 1, 8, 3];
        SortingEx.SortByOrder(arr, arr.length, arr2, arr2.length);
    }

    public static merge(arr1 : number[], size1 : number, arr2 : number[], size2 : number) {
        let index : number = 0;
        while((index < size1)) {{
            if(arr1[index] <= arr2[0]) {
                index += 1;
            } else {
                arr1[index] ^= arr2[0] ^= arr1[index] ^= arr2[0];
                index += 1;
                for(let i : number = 0; i < (size2 - 1); i++) {{
                    if(arr2[i] < arr2[i + 1]) break;
                    arr2[i] ^= arr2[i + 1] ^= arr2[i] ^= arr2[i + 1];
                };}
            }
        }};
    }

    public static main9(args : string[]) {
        let arr1 : number[] = [1, 5, 9, 10, 15, 20];
        let arr2 : number[] = [2, 3, 8, 13];
        SortingEx.merge(arr1, arr1.length, arr2, arr2.length);
        SortingEx.printArray(arr1, arr1.length);
        SortingEx.printArray(arr2, arr2.length);
    }

    public static checkReverse(arr : number[], size : number) : boolean {
        let start : number = -1;
        let stop : number = -1;
        for(let i : number = 0; i < (size - 1); i++) {{
            if(arr[i] > arr[i + 1]) {
                start = i;
                break;
            }
        };}
        if(start === -1) return true;
        for(let i : number = start; i < (size - 1); i++) {{
            if(arr[i] < arr[i + 1]) {
                stop = i;
                break;
            }
        };}
        if(stop === -1) return true;
        if(arr[start - 1] > arr[stop] || arr[stop + 1] < arr[start]) return false;
        for(let i : number = stop + 1; i < size - 1; i++) {{
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        };}
        return true;
    }

    public static min(X : number, Y : number) : number {
        if(X < Y) {
            return X;
        }
        return Y;
    }

    public static UnionIntersectionSorted(arr1 : number[], size1 : number, arr2 : number[], size2 : number) {
        let first : number = 0;
        let second : number = 0;
        let unionArr : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size1 + size2);
        let interArr : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(SortingEx.min(size1, size2));
        let uIndex : number = 0;
        let iIndex : number = 0;
        while((first < size1 && second < size2)) {{
            if(arr1[first] === arr2[second]) {
                unionArr[uIndex++] = arr1[first];
                interArr[iIndex++] = arr1[first];
                first += 1;
                second += 1;
            } else if(arr1[first] < arr2[second]) {
                unionArr[uIndex++] = arr1[first];
                first += 1;
            } else {
                unionArr[uIndex++] = arr2[second];
                second += 1;
            }
        }};
        while((first < size1)) {{
            unionArr[uIndex++] = arr1[first];
            first += 1;
        }};
        while((second < size2)) {{
            unionArr[uIndex++] = arr2[second];
            second += 1;
        }};
        SortingEx.printArray(unionArr, uIndex);
        SortingEx.printArray(interArr, iIndex);
    }

    public static UnionIntersectionUnsorted(arr1 : number[], size1 : number, arr2 : number[], size2 : number) {
        /* sort */((l) => {l.sort(); })(arr1);
        /* sort */((l) => {l.sort(); })(arr2);
        SortingEx.UnionIntersectionSorted(arr1, size1, arr2, size2);
    }

    public static main(args : string[]) {
        let arr1 : number[] = [1, 11, 2, 3, 14, 5, 6, 8, 9];
        let arr2 : number[] = [2, 4, 5, 12, 7, 8, 13, 10];
        SortingEx.UnionIntersectionUnsorted(arr1, arr1.length, arr2, arr2.length);
    }
}
SortingEx["__class"] = "SortingEx";




SortingEx.main(null);
