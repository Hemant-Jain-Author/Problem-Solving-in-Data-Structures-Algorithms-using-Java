class Introduction {
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

    public static SumArray(arr : number[]) : number {
        let size : number = arr.length;
        let total : number = 0;
        for(let index : number = 0; index < size; index++) {{
            total = total + arr[index];
        };}
        return total;
    }

    public static main0(args : string[]) {
        let arr : number[] = [1, 2, 3, 4, 5, 6, 7, 8, 9];
        console.info("Sum of values in array:" + Introduction.SumArray(arr));
    }

    public function2() {
        console.info("fun2 line 1");
    }

    public function1() {
        console.info("fun1 line 1");
        this.function2();
        console.info("fun1 line 2");
    }

    public main2() {
        console.info("main line 1");
        this.function1();
        console.info("main line 2");
    }

    public static SequentialSearch(arr : number[], size : number, value : number) : number {
        for(let i : number = 0; i < size; i++) {{
            if(value === arr[i]) {
                {
                    return i;
                };
            }
        };}
        return -1;
    }

    public static BinarySearch(arr : number[], size : number, value : number) : number {
        let mid : number;
        let low : number = 0;
        let high : number = size - 1;
        while((low <= high)) {{
            mid = low + ((high - low) / 2|0);
            if(arr[mid] === value) {
                return mid;
            } else {
                if(arr[mid] < value) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }};
        return -1;
    }

    public static main3(args : string[]) {
        let arr : number[] = [1, 2, 3, 4, 5, 6, 7, 8, 9];
        console.info("Sum of values in array:" + Introduction.SequentialSearch(arr, arr.length, 7));
        console.info("Sum of values in array:" + Introduction.BinarySearch(arr, arr.length, 7));
    }

    public static rotateArray(a : number[], n : number, k : number) {
        Introduction.reverseArray(a, 0, k - 1);
        Introduction.reverseArray(a, k, n - 1);
        Introduction.reverseArray(a, 0, n - 1);
    }

    public static reverseArray(a : number[], start : number, end : number) {
        for(let i : number = start, j : number = end; i < j; i++, j--) {{
            let temp : number = a[i];
            a[i] = a[j];
            a[j] = temp;
        };}
    }

    public static reverseArray2(a : number[]) {
        let start : number = 0;
        let end : number = a.length - 1;
        for(let i : number = start, j : number = end; i < j; i++, j--) {{
            let temp : number = a[i];
            a[i] = a[j];
            a[j] = temp;
        };}
    }

    public static main4(args : string[]) {
        let arr : number[] = [1, 2, 3, 4, 5, 6];
        Introduction.rotateArray(arr, arr.length, 2);
        Introduction.printArray(arr, arr.length);
    }

    public static maxSubArraySum(a : number[], size : number) : number {
        let maxSoFar : number = 0;
        let maxEndingHere : number = 0;
        for(let i : number = 0; i < size; i++) {{
            maxEndingHere = maxEndingHere + a[i];
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        };}
        return maxSoFar;
    }

    public static main5(args : string[]) {
        let arr : number[] = [1, -2, 3, 4, -4, 6, -4, 3, 2];
        console.info("Max sub array sum :" + Introduction.maxSubArraySum(arr, 9));
    }

    public static WaveArray2(arr : number[]) {
        let size : number = arr.length;
        for(let i : number = 1; i < size; i += 2) {{
            if((i - 1) >= 0 && arr[i] > arr[i - 1]) {
                Introduction.swap(arr, i, i - 1);
            }
            if((i + 1) < size && arr[i] > arr[i + 1]) {
                Introduction.swap(arr, i, i + 1);
            }
        };}
    }

    public static WaveArray(arr : number[]) {
        let size : number = arr.length;
        /* sort */((l) => {l.sort(); })(arr);
        Introduction.printArray(arr, arr.length);
        for(let i : number = 0; i < size - 1; i += 2) {{
            Introduction.swap(arr, i, i + 1);
        };}
    }

    public static main6(args : string[]) {
        let arr : number[] = [8, 1, 2, 3, 4, 5, 6, 4, 2];
        Introduction.printArray(arr, arr.length);
        Introduction.WaveArray(arr);
        Introduction.printArray(arr, arr.length);
        let arr2 : number[] = [8, 1, 2, 3, 4, 5, 6, 4, 2];
        Introduction.WaveArray2(arr2);
        Introduction.printArray(arr2, arr2.length);
    }

    public static indexArray(arr : number[], size : number) {
        for(let i : number = 0; i < size; i++) {{
            let curr : number = i;
            let value : number = -1;
            while((arr[curr] !== -1 && arr[curr] !== curr)) {{
                let temp : number = arr[curr];
                arr[curr] = value;
                value = curr = temp;
            }};
            if(value !== -1) {
                arr[curr] = value;
            }
        };}
    }

    public static indexArray2(arr : number[], size : number) {
        let temp : number;
        for(let i : number = 0; i < size; i++) {{
            while((arr[i] !== -1 && arr[i] !== i)) {{
                temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }};
        };}
    }

    public static main7(args : string[]) {
        let arr : number[] = [8, -1, 6, 1, 9, 3, 2, 7, 4, -1];
        let size : number = arr.length;
        Introduction.indexArray2(arr, size);
        Introduction.printArray(arr, size);
        let arr2 : number[] = [8, -1, 6, 1, 9, 3, 2, 7, 4, -1];
        size = arr2.length;
        Introduction.indexArray(arr2, size);
        Introduction.printArray(arr2, size);
    }

    public static Sort1toN(arr : number[], size : number) {
        let curr : number;
        let value : number;
        let next : number;
        for(let i : number = 0; i < size; i++) {{
            curr = i;
            value = -1;
            while((curr >= 0 && curr < size && arr[curr] !== curr + 1)) {{
                next = arr[curr];
                arr[curr] = value;
                value = next;
                curr = next - 1;
            }};
        };}
    }

    public static Sort1toN2(arr : number[], size : number) {
        let temp : number;
        for(let i : number = 0; i < size; i++) {{
            while((arr[i] !== i + 1 && arr[i] > 1)) {{
                temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }};
        };}
    }

    public static main8(args : string[]) {
        let arr : number[] = [8, 5, 6, 1, 9, 3, 2, 7, 4, 10];
        let size : number = arr.length;
        Introduction.Sort1toN2(arr, size);
        Introduction.printArray(arr, size);
        let arr2 : number[] = [8, 5, 6, 1, 9, 3, 2, 7, 4, 10];
        size = arr2.length;
        Introduction.Sort1toN(arr2, size);
        Introduction.printArray(arr2, size);
    }

    public static SmallestPositiveMissingNumber(arr : number[], size : number) : number {
        let found : number;
        for(let i : number = 1; i < size + 1; i++) {{
            found = 0;
            for(let j : number = 0; j < size; j++) {{
                if(arr[j] === i) {
                    found = 1;
                    break;
                }
            };}
            if(found === 0) {
                return i;
            }
        };}
        return -1;
    }

    public static SmallestPositiveMissingNumber2(arr : number[], size : number) : number {
        let hs : any = <any>({});
        for(let i : number = 0; i < size; i++) {{
            /* put */((m,k,v) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { m.entries[i].value=v; return; } m.entries.push({key:k,value:v,getKey: function() { return this.key }, getValue: function() { return this.value }}); })(<any>hs, arr[i], 1);
        };}
        for(let i : number = 1; i < size + 1; i++) {{
            if(/* containsKey */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return true; } return false; })(<any>hs, i) === false) {
                return i;
            }
        };}
        return -1;
    }

    public static SmallestPositiveMissingNumber3(arr : number[], size : number) : number {
        let aux : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        /* fill */((a, v) => { for(let i=0;i<a.length;i++) a[i]=v; })(aux, -1);
        for(let i : number = 0; i < size; i++) {{
            if(arr[i] > 0 && arr[i] <= size) {
                aux[arr[i] - 1] = arr[i];
            }
        };}
        for(let i : number = 0; i < size; i++) {{
            if(aux[i] !== i + 1) {
                return i + 1;
            }
        };}
        return -1;
    }

    public static SmallestPositiveMissingNumber4(arr : number[], size : number) : number {
        let temp : number;
        for(let i : number = 0; i < size; i++) {{
            while((arr[i] !== i + 1 && arr[i] > 0 && arr[i] <= size)) {{
                temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }};
        };}
        for(let i : number = 0; i < size; i++) {{
            if(arr[i] !== i + 1) {
                return i + 1;
            }
        };}
        return -1;
    }

    public static main9(args : string[]) {
        let arr : number[] = [8, 5, 6, 1, 9, 11, 2, 7, 4, 10];
        let size : number = arr.length;
        console.info("Max sub array sum :" + Introduction.SmallestPositiveMissingNumber(arr, size));
        console.info("Max sub array sum :" + Introduction.SmallestPositiveMissingNumber2(arr, size));
        console.info("Max sub array sum :" + Introduction.SmallestPositiveMissingNumber3(arr, size));
        console.info("Max sub array sum :" + Introduction.SmallestPositiveMissingNumber4(arr, size));
    }

    public static MaxMinArr(arr : number[], size : number) {
        let aux : number[] = /* copyOf */arr.slice(0,size);
        let start : number = 0;
        let stop : number = size - 1;
        for(let i : number = 0; i < size; i++) {{
            if(i % 2 === 0) {
                arr[i] = aux[stop];
                stop -= 1;
            } else {
                arr[i] = aux[start];
                start += 1;
            }
        };}
    }

    public static ReverseArr(arr : number[], start : number, stop : number) {
        while((start < stop)) {{
            Introduction.swap(arr, start, stop);
            start += 1;
            stop -= 1;
        }};
    }

    public static MaxMinArr2(arr : number[], size : number) {
        for(let i : number = 0; i < (size - 1); i++) {{
            Introduction.ReverseArr(arr, i, size - 1);
        };}
    }

    public static main10(args : string[]) {
        let arr : number[] = [1, 2, 3, 4, 5, 6, 7];
        let size : number = arr.length;
        Introduction.MaxMinArr(arr, size);
        Introduction.printArray(arr, size);
        let arr2 : number[] = [1, 2, 3, 4, 5, 6, 7];
        let size2 : number = arr.length;
        Introduction.MaxMinArr2(arr2, size2);
        Introduction.printArray(arr2, size2);
    }

    public static maxCircularSum(arr : number[], size : number) : number {
        let sumAll : number = 0;
        let currVal : number = 0;
        let maxVal : number;
        for(let i : number = 0; i < size; i++) {{
            sumAll += arr[i];
            currVal += (i * arr[i]);
        };}
        maxVal = currVal;
        for(let i : number = 1; i < size; i++) {{
            currVal = (currVal + sumAll) - (size * arr[size - i]);
            if(currVal > maxVal) {
                maxVal = currVal;
            }
        };}
        return maxVal;
    }

    public static main11(args : string[]) {
        let arr : number[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1];
        console.info("MaxCirculrSm: " + Introduction.maxCircularSum(arr, arr.length));
    }

    public static ArrayIndexMaxDiff(arr : number[], size : number) : number {
        let maxDiff : number = -1;
        let j : number;
        for(let i : number = 0; i < size; i++) {{
            j = size - 1;
            while((j > i)) {{
                if(arr[j] > arr[i]) {
                    maxDiff = Math.max(maxDiff, j - i);
                    break;
                }
                j -= 1;
            }};
        };}
        return maxDiff;
    }

    public static ArrayIndexMaxDiff2(arr : number[], size : number) : number {
        let leftMin : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        let rightMax : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        leftMin[0] = arr[0];
        let i : number;
        let j : number;
        let maxDiff : number;
        for(i = 1; i < size; i++) {{
            if(leftMin[i - 1] < arr[i]) {
                leftMin[i] = leftMin[i - 1];
            } else {
                leftMin[i] = arr[i];
            }
        };}
        rightMax[size - 1] = arr[size - 1];
        for(i = size - 2; i >= 0; i--) {{
            if(rightMax[i + 1] > arr[i]) {
                rightMax[i] = rightMax[i + 1];
            } else {
                rightMax[i] = arr[i];
            }
        };}
        i = 0;
        j = 0;
        maxDiff = -1;
        while((j < size && i < size)) {{
            if(leftMin[i] < rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else {
                i = i + 1;
            }
        }};
        return maxDiff;
    }

    public static main(args : string[]) {
        let arr : number[] = [33, 9, 10, 3, 2, 60, 30, 33, 1];
        console.info("ArrayIndexMaxDiff : " + Introduction.ArrayIndexMaxDiff(arr, arr.length));
        console.info("ArrayIndexMaxDiff : " + Introduction.ArrayIndexMaxDiff2(arr, arr.length));
    }

    public static maxPathSum(arr1 : number[], size1 : number, arr2 : number[], size2 : number) : number {
        let i : number = 0;
        let j : number = 0;
        let result : number = 0;
        let sum1 : number = 0;
        let sum2 : number = 0;
        while((i < size1 && j < size2)) {{
            if(arr1[i] < arr2[j]) {
                sum1 += arr1[i];
                i += 1;
            } else if(arr1[i] > arr2[j]) {
                sum2 += arr2[j];
                j += 1;
            } else {
                result += Math.max(sum1, sum2);
                result = result + arr1[i];
                sum1 = 0;
                sum2 = 0;
                i += 1;
                j += 1;
            }
        }};
        while((i < size1)) {{
            sum1 += arr1[i];
            i += 1;
        }};
        while((j < size2)) {{
            sum2 += arr2[j];
            j += 1;
        }};
        result += Math.max(sum1, sum2);
        return result;
    }

    public static main13(args : string[]) {
        let arr1 : number[] = [12, 13, 18, 20, 22, 26, 70];
        let arr2 : number[] = [11, 15, 18, 19, 20, 26, 30, 31];
        console.info("Max Path Sum :: " + Introduction.maxPathSum(arr1, arr1.length, arr2, arr2.length));
    }

    public factorial(i : number) : number {
        if(i <= 1) {
            return 1;
        }
        return i * this.factorial(i - 1);
    }

    public printInt1(number : number) {
        let digit : string = String.fromCharCode((number % 10 + '0'.charCodeAt(0)));
        number = (number / 10|0);
        if(number !== 0) {
            this.printInt1(number);
        }
        console.info("%c" + digit);
    }

    public printInt(number : number) {
        let conversion : string = "0123456789ABCDEF";
        let base : number = 16;
        let digit : string = String.fromCharCode((number % base));
        number = (number / base|0);
        if(number !== 0) {
            this.printInt(number);
        }
        console.info(conversion.charAt((digit).charCodeAt(0)));
    }

    public static towerOfHanoi(num : number, src : string, dst : string, temp : string) {
        if(num < 1) {
            return;
        }
        Introduction.towerOfHanoi(num - 1, src, temp, dst);
        console.info("Move " + num + " disk  from peg " + src + " to peg " + dst);
        Introduction.towerOfHanoi(num - 1, temp, dst, src);
    }

    public static main14(args : string[]) {
        let num : number = 4;
        console.info("The sequence of moves involved in the Tower of Hanoi are :\n");
        Introduction.towerOfHanoi(num, 'A', 'C', 'B');
    }

    public static GCD(m : number, n : number) : number {
        if(m < n) {
            return (Introduction.GCD(n, m));
        }
        if(m % n === 0) {
            return (n);
        }
        return (Introduction.GCD(n, m % n));
    }

    public static fibonacci(n : number) : number {
        if(n <= 1) {
            return n;
        }
        return Introduction.fibonacci(n - 1) + Introduction.fibonacci(n - 2);
    }

    public static permutation(arr : number[], i : number, length : number) {
        if(length === i) {
            Introduction.printArray(arr, length);
            return;
        }
        let j : number = i;
        for(j = i; j < length; j++) {{
            Introduction.swap(arr, i, j);
            Introduction.permutation(arr, i + 1, length);
            Introduction.swap(arr, i, j);
        };}
        return;
    }

    public static main15(args : string[]) {
        let arr : number[] = [0, 0, 0, 0, 0];
        for(let i : number = 0; i < 5; i++) {{
            arr[i] = i;
        };}
        Introduction.permutation(arr, 0, 5);
    }

    public static BinarySearchRecursive(arr : number[], low : number, high : number, value : number) : number {
        if(low > high) return -1;
        let mid : number = ((low + high) / 2|0);
        if(arr[mid] === value) {
            return mid;
        } else if(arr[mid] < value) {
            return Introduction.BinarySearchRecursive(arr, mid + 1, high, value);
        } else {
            return Introduction.BinarySearchRecursive(arr, low, mid - 1, value);
        }
    }

    public static main16(args : string[]) {
        let arr : number[] = [1, 2, 3, 4, 5, 6, 7, 8, 9];
        console.info(Introduction.BinarySearchRecursive(arr, 0, arr.length - 1, 6));
        console.info(Introduction.BinarySearchRecursive(arr, 0, arr.length - 1, 16));
    }
}
Introduction["__class"] = "Introduction";

Introduction.main(null);