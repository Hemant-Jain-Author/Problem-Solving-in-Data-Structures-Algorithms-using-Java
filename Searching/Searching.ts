/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class Searching {
    public static linearSearchUnsorted(arr : number[], size : number, value : number) : boolean {
        for(let i : number = 0; i < size; i++) {{
            if(value === arr[i]) {
                return true;
            }
        };}
        return false;
    }

    public static linearSearchSorted(arr : number[], size : number, value : number) : boolean {
        for(let i : number = 0; i < size; i++) {{
            if(value === arr[i]) {
                return true;
            } else if(value < arr[i]) {
                return false;
            }
        };}
        return false;
    }

    public static Binarysearch(arr : number[], size : number, value : number) : boolean {
        let low : number = 0;
        let high : number = size - 1;
        let mid : number;
        while((low <= high)) {{
            mid = ((low + high) / 2|0);
            if(arr[mid] === value) {
                return true;
            } else if(arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }};
        return false;
    }

    public static BinarySearchRec(arr : number[], size : number, value : number) : boolean {
        let low : number = 0;
        let high : number = size - 1;
        return Searching.BinarySearchRecUtil(arr, low, high, value);
    }

    public static BinarySearchRecUtil(arr : number[], low : number, high : number, value : number) : boolean {
        if(low > high) {
            return false;
        }
        let mid : number = ((low + high) / 2|0);
        if(arr[mid] === value) {
            return true;
        } else if(arr[mid] < value) {
            return Searching.BinarySearchRecUtil(arr, mid + 1, high, value);
        } else {
            return Searching.BinarySearchRecUtil(arr, low, mid - 1, value);
        }
    }

    public static BinarySearch(arr : number[], start : number, end : number, key : number, isInc : boolean) : number {
        let mid : number;
        if(end < start) {
            return -1;
        }
        mid = ((start + end) / 2|0);
        if(key === arr[mid]) {
            return mid;
        }
        if(isInc !== false && key < arr[mid] || isInc === false && key > arr[mid]) {
            return Searching.BinarySearch(arr, start, mid - 1, key, isInc);
        } else {
            return Searching.BinarySearch(arr, mid + 1, end, key, isInc);
        }
    }

    public static main1(args : string[]) {
        let first : number[] = [1, 3, 5, 7, 9, 25, 30];
        console.info(Searching.linearSearchUnsorted(first, 7, 8));
        console.info(Searching.linearSearchSorted(first, 7, 8));
        console.info(Searching.Binarysearch(first, 7, 8));
        console.info(Searching.BinarySearchRec(first, 7, 8));
        console.info(Searching.linearSearchUnsorted(first, 7, 25));
        console.info(Searching.linearSearchSorted(first, 7, 25));
        console.info(Searching.Binarysearch(first, 7, 25));
        console.info(Searching.BinarySearchRec(first, 7, 25));
    }

    public static swap(arr : number[], first : number, second : number) {
        let temp : number = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static FirstRepeated(arr : number[], size : number) : number {
        for(let i : number = 0; i < size; i++) {{
            for(let j : number = i + 1; j < size; j++) {{
                if(arr[i] === arr[j]) {
                    return arr[i];
                }
            };}
        };}
        return 0;
    }

    public static main2(args : string[]) {
        let first : number[] = [34, 56, 77, 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 34, 20, 30];
        console.info(Searching.FirstRepeated(first, first.length));
    }

    public static printRepeating(arr : number[], size : number) {
        console.info(" \nRepeating elements are ");
        for(let i : number = 0; i < size; i++) {{
            for(let j : number = i + 1; j < size; j++) {{
                if(arr[i] === arr[j]) {
                    console.info(" " + arr[i]);
                }
            };}
        };}
    }

    public static printRepeating2(arr : number[], size : number) {
        /* sort */((l) => {l.sort(); })(arr);
        console.info(" \nRepeating elements are ");
        for(let i : number = 1; i < size; i++) {{
            if(arr[i] === arr[i - 1]) {
                console.info(" " + arr[i]);
            }
        };}
    }

    public static printRepeating3(arr : number[], size : number) {
        let hs : Array<number> = <any>([]);
        console.info(" \nRepeating elements are ");
        for(let i : number = 0; i < size; i++) {{
            if(/* contains */(hs.indexOf(<any>(arr[i])) >= 0)) {
                console.info(" " + arr[i]);
            } else {
                /* add */((s, e) => { if(s.indexOf(e)==-1) { s.push(e); return true; } else { return false; } })(hs, arr[i]);
            }
        };}
    }

    public static printRepeating4(arr : number[], size : number, range : number) {
        let count : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(range);
        let i : number;
        for(i = 0; i < size; i++) {{
            count[i] = 0;
        };}
        console.info(" \nRepeating elements are ");
        for(i = 0; i < size; i++) {{
            if(count[arr[i]] === 1) {
                console.info(" " + arr[i]);
            } else {
                count[arr[i]]++;
            }
        };}
    }

    public static main3(args : string[]) {
        let first : number[] = [1, 3, 5, 3, 9, 1, 30];
        Searching.printRepeating(first, first.length);
        Searching.printRepeating2(first, first.length);
        Searching.printRepeating3(first, first.length);
        Searching.printRepeating4(first, first.length, 50);
    }

    public static removeDuplicates(array : number[], size : number) : number[] {
        let j : number = 0;
        /* sort */((l) => {l.sort(); })(array);
        for(let i : number = 1; i < size; i++) {{
            if(array[i] !== array[j]) {
                j++;
                array[j] = array[i];
            }
        };}
        let ret : number[] = /* copyOf */array.slice(0,j + 1);
        return ret;
    }

    public static main4(args : string[]) {
        let first : number[] = [1, 3, 5, 3, 9, 1, 30];
        let ret : number[] = Searching.removeDuplicates(first, first.length);
        for(let i : number = 0; i < ret.length; i++) {{
            console.info(ret[i] + " ");
        };}
    }

    public static findMissingNumber(arr : number[], size : number) : number {
        let i : number;
        let j : number;
        let found : number = 0;
        for(i = 1; i <= size; i++) {{
            found = 0;
            for(j = 0; j < size; j++) {{
                if(arr[j] === i) {
                    found = 1;
                    break;
                }
            };}
            if(found === 0) {
                return i;
            }
        };}
        return 2147483647;
    }

    public static findMissingNumber2(arr : number[], size : number, range : number) : number {
        let i : number;
        let xorSum : number = 0;
        for(i = 1; i <= range; i++) {{
            xorSum ^= i;
        };}
        for(i = 0; i < size; i++) {{
            xorSum ^= arr[i];
        };}
        return xorSum;
    }

    public static findMissingNumber3(arr : number[], size : number, upperRange : number) : number {
        let st : Array<number> = <any>([]);
        let i : number = 0;
        while((i < size)) {{
            /* add */((s, e) => { if(s.indexOf(e)==-1) { s.push(e); return true; } else { return false; } })(st, arr[i]);
            i += 1;
        }};
        i = 1;
        while((i <= upperRange)) {{
            if(/* contains */(st.indexOf(<any>(i)) >= 0) === false) return i;
            i += 1;
        }};
        console.info("NoNumberMissing");
        return -1;
    }

    public static main5(args : string[]) {
        let first : number[] = [1, 3, 5, 4, 6, 8, 7];
        console.info(Searching.findMissingNumber(first, first.length));
        console.info(Searching.findMissingNumber2(first, first.length, 8));
        console.info(Searching.findMissingNumber3(first, first.length, 8));
    }

    public static MissingValues(arr : number[], size : number) {
        /* sort */((l) => {l.sort(); })(arr);
        let value : number = arr[0];
        let i : number = 0;
        while((i < size)) {{
            if(value === arr[i]) {
                value += 1;
                i += 1;
            } else {
                console.info(value);
                value += 1;
            }
        }};
    }

    public static MissingValues2(arr : number[], size : number) {
        let ht : Array<number> = <any>([]);
        let minVal : number = 999999;
        let maxVal : number = -999999;
        for(let i : number = 0; i < size; i++) {{
            /* add */((s, e) => { if(s.indexOf(e)==-1) { s.push(e); return true; } else { return false; } })(ht, arr[i]);
            if(minVal > arr[i]) minVal = arr[i];
            if(maxVal < arr[i]) maxVal = arr[i];
        };}
        for(let i : number = minVal; i < maxVal + 1; i++) {{
            if(/* contains */(ht.indexOf(<any>(i)) >= 0) === false) {
                console.info(i);
            }
        };}
    }

    public static main6(args : string[]) {
        let arr : number[] = [1, 9, 2, 8, 3, 7, 4, 6];
        let size : number = arr.length;
        Searching.MissingValues(arr, size);
        Searching.MissingValues2(arr, size);
    }

    public static OddCount(arr : number[], size : number) {
        let ctr : any = <any>({});
        let count : number = 0;
        for(let i : number = 0; i < size; i++) {{
            if(/* containsKey */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return true; } return false; })(<any>ctr, arr[i])) /* put */((m,k,v) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { m.entries[i].value=v; return; } m.entries.push({key:k,value:v,getKey: function() { return this.key }, getValue: function() { return this.value }}); })(<any>ctr, arr[i], /* get */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries[i].value; } return null; })(<any>ctr, arr[i]) + 1); else /* put */((m,k,v) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { m.entries[i].value=v; return; } m.entries.push({key:k,value:v,getKey: function() { return this.key }, getValue: function() { return this.value }}); })(<any>ctr, arr[i], 1);
        };}
        for(let i : number = 0; i < size; i++) {{
            if(/* containsKey */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return true; } return false; })(<any>ctr, arr[i]) && (/* get */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries[i].value; } return null; })(<any>ctr, arr[i]) % 2 === 1)) {
                console.info(arr[i]);
                count++;
                /* remove */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries.splice(i,1)[0]; } })(<any>ctr, arr[i]);
            }
        };}
        console.info("Odd count is :: " + count);
    }

    public static OddCount2(arr : number[], size : number) {
        let xorSum : number = 0;
        let first : number = 0;
        let second : number = 0;
        let setBit : number;
        for(let i : number = 0; i < size; i++) {xorSum = xorSum ^ arr[i];}
        setBit = xorSum & ~(xorSum - 1);
        for(let i : number = 0; i < size; i++) {{
            if((arr[i] & setBit) !== 0) first ^= arr[i]; else second ^= arr[i];
        };}
        console.info(first + second);
    }

    public static SumDistinct(arr : number[], size : number) {
        let sum : number = 0;
        /* sort */((l) => {l.sort(); })(arr);
        for(let i : number = 0; i < (size - 1); i++) {{
            if(arr[i] !== arr[i + 1]) sum += arr[i];
        };}
        sum += arr[size - 1];
        console.info(sum);
    }

    public static minAbsSumPair(arr : number[], size : number) {
        let l : number;
        let r : number;
        let minSum : number;
        let sum : number;
        let minFirst : number;
        let minSecond : number;
        if(size < 2) {
            console.info("Invalid Input");
            return;
        }
        minFirst = 0;
        minSecond = 1;
        minSum = Math.abs(arr[0] + arr[1]);
        for(l = 0; l < size - 1; l++) {{
            for(r = l + 1; r < size; r++) {{
                sum = Math.abs(arr[l] + arr[r]);
                if(sum < minSum) {
                    minSum = sum;
                    minFirst = l;
                    minSecond = r;
                }
            };}
        };}
        console.info(" Minimum sum elements are : " + arr[minFirst] + " , " + arr[minSecond]);
    }

    public static minAbsSumPair2(arr : number[], size : number) {
        let l : number;
        let r : number;
        let minSum : number;
        let sum : number;
        let minFirst : number;
        let minSecond : number;
        if(size < 2) {
            console.info("Invalid Input");
            return;
        }
        /* sort */((l) => {l.sort(); })(arr);
        minFirst = 0;
        minSecond = size - 1;
        minSum = Math.abs(arr[minFirst] + arr[minSecond]);
        for(l = 0, r = size - 1; l < r; ) {{
            sum = (arr[l] + arr[r]);
            if(Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                minFirst = l;
                minSecond = r;
            }
            if(sum < 0) {
                l++;
            } else if(sum > 0) {
                r--;
            } else {
                break;
            }
        };}
        console.info(" Minimum sum pair : " + arr[minFirst] + " , " + arr[minSecond]);
    }

    public static main7(str : string[]) {
        let first : number[] = [1, 5, -10, 3, 2, -6, 8, 9, 6];
        Searching.minAbsSumPair2(first, first.length);
        Searching.minAbsSumPair(first, first.length);
    }

    public static FindPair(arr : number[], size : number, value : number) : boolean {
        for(let i : number = 0; i < size; i++) {{
            for(let j : number = i + 1; j < size; j++) {{
                if((arr[i] + arr[j]) === value) {
                    console.info("The pair is : " + arr[i] + "," + arr[j]);
                    return true;
                }
            };}
        };}
        return false;
    }

    public static FindPair2(arr : number[], size : number, value : number) : boolean {
        let first : number = 0;
        let second : number = size - 1;
        let curr : number;
        /* sort */((l) => {l.sort(); })(arr);
        while((first < second)) {{
            curr = arr[first] + arr[second];
            if(curr === value) {
                console.info("The pair is " + arr[first] + "," + arr[second]);
                return true;
            } else if(curr < value) {
                first++;
            } else {
                second--;
            }
        }};
        return false;
    }

    public static FindPair3(arr : number[], size : number, value : number) : boolean {
        let hs : Array<number> = <any>([]);
        for(let i : number = 0; i < size; i++) {{
            if(/* contains */(hs.indexOf(<any>(value - arr[i])) >= 0)) {
                console.info("The pair is : " + arr[i] + " , " + (value - arr[i]));
                return true;
            }
            /* add */((s, e) => { if(s.indexOf(e)==-1) { s.push(e); return true; } else { return false; } })(hs, arr[i]);
        };}
        return false;
    }

    public static main8(args : string[]) {
        let first : number[] = [1, 5, 4, 3, 2, 7, 8, 9, 6];
        console.info(Searching.FindPair(first, first.length, 8));
        console.info(Searching.FindPair2(first, first.length, 8));
        console.info(Searching.FindPair3(first, first.length, 8));
    }

    public static FindDifference(arr : number[], size : number, value : number) : boolean {
        for(let i : number = 0; i < size; i++) {{
            for(let j : number = i + 1; j < size; j++) {{
                if(Math.abs(arr[i] - arr[j]) === value) {
                    console.info("The pair is:: " + arr[i] + " & " + arr[j]);
                    return true;
                }
            };}
        };}
        return false;
    }

    public static FindDifference2(arr : number[], size : number, value : number) : boolean {
        let first : number = 0;
        let second : number = 0;
        let diff : number;
        /* sort */((l) => {l.sort(); })(arr);
        while((first < size && second < size)) {{
            diff = Math.abs(arr[first] - arr[second]);
            if(diff === value) {
                console.info("The pair is::" + arr[first] + " & " + arr[second]);
                return true;
            } else if(diff > value) first += 1; else second += 1;
        }};
        return false;
    }

    public static findMinDiff(arr : number[], size : number) : number {
        /* sort */((l) => {l.sort(); })(arr);
        let diff : number = 9999999;
        for(let i : number = 0; i < (size - 1); i++) {{
            if((arr[i + 1] - arr[i]) < diff) diff = arr[i + 1] - arr[i];
        };}
        return diff;
    }

    public static MinDiffPair(arr1 : number[], size1 : number, arr2 : number[], size2 : number) : number {
        let minDiff : number = 9999999;
        let first : number = 0;
        let second : number = 0;
        let out1 : number = 0;
        let out2 : number = 0;
        let diff : number;
        /* sort */((l) => {l.sort(); })(arr1);
        /* sort */((l) => {l.sort(); })(arr2);
        while((first < size1 && second < size2)) {{
            diff = Math.abs(arr1[first] - arr2[second]);
            if(minDiff > diff) {
                minDiff = diff;
                out1 = arr1[first];
                out2 = arr2[second];
            }
            if(arr1[first] < arr2[second]) first += 1; else second += 1;
        }};
        console.info("The pair is :: " + out1 + out2);
        console.info("Minimum difference is :: " + minDiff);
        return minDiff;
    }

    public static main88(args : string[]) {
        let first : number[] = [1, 5, 4, 3, 2, 7, 8, 9, 6];
        console.info(Searching.FindDifference(first, first.length, 6));
        console.info(Searching.FindDifference2(first, first.length, 6));
        console.info(Searching.findMinDiff(first, first.length));
        console.info(Searching.MinDiffPair(first, first.length, first, first.length));
    }

    public static ClosestPair(arr : number[], size : number, value : number) {
        let diff : number = 999999;
        let first : number = -1;
        let second : number = -1;
        let curr : number;
        for(let i : number = 0; i < size; i++) {{
            for(let j : number = i + 1; j < size; j++) {{
                curr = Math.abs(value - (arr[i] + arr[j]));
                if(curr < diff) {
                    diff = curr;
                    first = arr[i];
                    second = arr[j];
                }
            };}
        };}
        console.info("closest pair is ::" + first + second);
    }

    public static ClosestPair2(arr : number[], size : number, value : number) {
        let first : number = 0;
        let second : number = 0;
        let start : number = 0;
        let stop : number = size - 1;
        let diff : number;
        let curr : number;
        /* sort */((l) => {l.sort(); })(arr);
        diff = 9999999;
        {
            while((start < stop)) {{
                curr = (value - (arr[start] + arr[stop]));
                if(Math.abs(curr) < diff) {
                    diff = Math.abs(curr);
                    first = arr[start];
                    second = arr[stop];
                }
                if(curr === 0) {
                    break;
                } else if(curr > 0) {
                    start += 1;
                } else {
                    stop -= 1;
                }
            }};
        };
        console.info("closest pair is :: " + first + second);
    }

    public static main99(args : string[]) {
        let first : number[] = [1, 5, 4, 3, 2, 7, 8, 9, 6];
        Searching.ClosestPair(first, first.length, 6);
        Searching.ClosestPair2(first, first.length, 6);
    }

    public static SumPairRestArray(arr : number[], size : number) : boolean {
        let total : number;
        let low : number;
        let high : number;
        let curr : number;
        let value : number;
        /* sort */((l) => {l.sort(); })(arr);
        total = 0;
        for(let i : number = 0; i < size; i++) {total += arr[i];}
        value = (total / 2|0);
        low = 0;
        high = size - 1;
        while((low < high)) {{
            curr = arr[low] + arr[high];
            if(curr === value) {
                console.info("Pair is :: " + arr[low] + arr[high]);
                return true;
            } else if(curr < value) low += 1; else high -= 1;
        }};
        return false;
    }

    public static ZeroSumTriplets(arr : number[], size : number) {
        for(let i : number = 0; i < (size - 2); i++) {{
            for(let j : number = i + 1; j < (size - 1); j++) {{
                for(let k : number = j + 1; k < size; k++) {{
                    if(arr[i] + arr[j] + arr[k] === 0) console.info("Triplet :: " + arr[i] + arr[j] + arr[k]);
                };}
            };}
        };}
    }

    public static ZeroSumTriplets2(arr : number[], size : number) {
        let start : number;
        let stop : number;
        /* sort */((l) => {l.sort(); })(arr);
        for(let i : number = 0; i < (size - 2); i++) {{
            start = i + 1;
            stop = size - 1;
            while((start < stop)) {{
                if(arr[i] + arr[start] + arr[stop] === 0) {
                    console.info("Triplet :: " + arr[i] + arr[start] + arr[stop]);
                    start += 1;
                    stop -= 1;
                } else if(arr[i] + arr[start] + arr[stop] > 0) stop -= 1; else start += 1;
            }};
        };}
    }

    public static findTriplet(arr : number[], size : number, value : number) {
        for(let i : number = 0; i < (size - 2); i++) {for(let j : number = i + 1; j < (size - 1); j++) {for(let k : number = j + 1; k < size; k++) {{
            if((arr[i] + arr[j] + arr[k]) === value) console.info("Triplet :: " + arr[i] + arr[j] + arr[k]);
        };};};}
    }

    public static findTriplet2(arr : number[], size : number, value : number) {
        let start : number;
        let stop : number;
        /* sort */((l) => {l.sort(); })(arr);
        for(let i : number = 0; i < size - 2; i++) {{
            start = i + 1;
            stop = size - 1;
            while((start < stop)) {{
                if(arr[i] + arr[start] + arr[stop] === value) {
                    console.info("Triplet ::" + arr[i] + arr[start] + arr[stop]);
                    start += 1;
                    stop -= 1;
                } else if(arr[i] + arr[start] + arr[stop] > value) stop -= 1; else start += 1;
            }};
        };}
    }

    public static ABCTriplet(arr : number[], size : number) {
        let start : number;
        let stop : number;
        /* sort */((l) => {l.sort(); })(arr);
        for(let i : number = 0; i < (size - 2); i++) {{
            start = i + 1;
            stop = size - 1;
            while((start < stop)) {{
                if(arr[i] === arr[start] + arr[stop]) {
                    console.info("Triplet ::%d, %d, %d" + arr[i] + arr[start] + arr[stop]);
                    start += 1;
                    stop -= 1;
                } else if(arr[i] > arr[start] + arr[stop]) stop -= 1; else start += 1;
            }};
        };}
    }

    public static SmallerThenTripletCount(arr : number[], size : number, value : number) {
        let start : number;
        let stop : number;
        let count : number = 0;
        /* sort */((l) => {l.sort(); })(arr);
        for(let i : number = 0; i < (size - 2); i++) {{
            start = i + 1;
            stop = size - 1;
            while((start < stop)) {{
                if(arr[i] + arr[start] + arr[stop] >= value) stop -= 1; else {
                    count += stop - start;
                    start += 1;
                }
            }};
        };}
        console.info(count);
    }

    public static APTriplets(arr : number[], size : number) {
        let i : number;
        let j : number;
        let k : number;
        for(i = 1; i < size - 1; i++) {{
            j = i - 1;
            k = i + 1;
            while((j >= 0 && k < size)) {{
                if(arr[j] + arr[k] === 2 * arr[i]) {
                    console.info("Triplet ::" + arr[j] + arr[i] + arr[k]);
                    k += 1;
                    j -= 1;
                } else if(arr[j] + arr[k] < 2 * arr[i]) k += 1; else j -= 1;
            }};
        };}
    }

    public static GPTriplets(arr : number[], size : number) {
        let i : number;
        let j : number;
        let k : number;
        for(i = 1; i < size - 1; i++) {{
            j = i - 1;
            k = i + 1;
            while((j >= 0 && k < size)) {{
                if(arr[j] * arr[k] === arr[i] * arr[i]) {
                    console.info("Triplet is :: " + arr[j] + arr[i] + arr[k]);
                    k += 1;
                    j -= 1;
                } else if(arr[j] + arr[k] < 2 * arr[i]) k += 1; else j -= 1;
            }};
        };}
    }

    public static numberOfTriangles(arr : number[], size : number) : number {
        let i : number;
        let j : number;
        let k : number;
        let count : number = 0;
        for(i = 0; i < (size - 2); i++) {{
            for(j = i + 1; j < (size - 1); j++) {{
                for(k = j + 1; k < size; k++) {{
                    if(arr[i] + arr[j] > arr[k]) count += 1;
                };}
            };}
        };}
        return count;
    }

    public static numberOfTriangles2(arr : number[], size : number) : number {
        let i : number;
        let j : number;
        let k : number;
        let count : number = 0;
        /* sort */((l) => {l.sort(); })(arr);
        for(i = 0; i < (size - 2); i++) {{
            k = i + 2;
            for(j = i + 1; j < (size - 1); j++) {{
                while((k < size && arr[i] + arr[j] > arr[k])) {k += 1};
                count += k - j - 1;
            };}
        };}
        return count;
    }

    public static getMax(arr : number[], size : number) : number {
        let max : number = arr[0];
        let count : number = 1;
        let maxCount : number = 1;
        for(let i : number = 0; i < size; i++) {{
            count = 1;
            for(let j : number = i + 1; j < size; j++) {{
                if(arr[i] === arr[j]) {
                    count++;
                }
            };}
            if(count > maxCount) {
                max = arr[i];
                maxCount = count;
            }
        };}
        return max;
    }

    public static getMax2(arr : number[], size : number) : number {
        let max : number = arr[0];
        let maxCount : number = 1;
        let curr : number = arr[0];
        let currCount : number = 1;
        /* sort */((l) => {l.sort(); })(arr);
        for(let i : number = 1; i < size; i++) {{
            if(arr[i] === arr[i - 1]) {
                currCount++;
            } else {
                currCount = 1;
                curr = arr[i];
            }
            if(currCount > maxCount) {
                maxCount = currCount;
                max = curr;
            }
        };}
        return max;
    }

    public static getMax3(arr : number[], size : number, range : number) : number {
        let max : number = arr[0];
        let maxCount : number = 1;
        let count : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(range);
        for(let i : number = 0; i < size; i++) {{
            count[arr[i]]++;
            if(count[arr[i]] > maxCount) {
                maxCount = count[arr[i]];
                max = arr[i];
            }
        };}
        return max;
    }

    public static main9(args : string[]) {
        let first : number[] = [1, 30, 5, 13, 9, 31, 5];
        console.info(Searching.getMax(first, first.length));
        console.info(Searching.getMax2(first, first.length));
        console.info(Searching.getMax3(first, first.length, 50));
    }

    public static getMajority(arr : number[], size : number) : number {
        let max : number = 0;
        let count : number = 0;
        let maxCount : number = 0;
        for(let i : number = 0; i < size; i++) {{
            for(let j : number = i + 1; j < size; j++) {{
                if(arr[i] === arr[j]) {
                    count++;
                }
            };}
            if(count > maxCount) {
                max = arr[i];
                maxCount = count;
            }
        };}
        if(maxCount > (size / 2|0)) {
            return max;
        } else {
            return 0;
        }
    }

    public static getMajority2(arr : number[], size : number) : number {
        let majIndex : number = (size / 2|0);
        let count : number = 1;
        let candidate : number;
        /* sort */((l) => {l.sort(); })(arr);
        candidate = arr[majIndex];
        count = 0;
        for(let i : number = 0; i < size; i++) {{
            if(arr[i] === candidate) {
                count++;
            }
        };}
        if(count > (size / 2|0)) {
            return arr[majIndex];
        } else {
            return -2147483648;
        }
    }

    public static getMajority3(arr : number[], size : number) : number {
        let majIndex : number = 0;
        let count : number = 1;
        let i : number;
        let candidate : number;
        for(i = 1; i < size; i++) {{
            if(arr[majIndex] === arr[i]) {
                count++;
            } else {
                count--;
            }
            if(count === 0) {
                majIndex = i;
                count = 1;
            }
        };}
        candidate = arr[majIndex];
        count = 0;
        for(i = 0; i < size; i++) {{
            if(arr[i] === candidate) {
                count++;
            }
        };}
        if(count > (size / 2|0)) {
            return arr[majIndex];
        } else {
            return 0;
        }
    }

    public static main10(args : string[]) {
        let first : number[] = [1, 5, 5, 13, 5, 31, 5];
        console.info(Searching.getMajority(first, first.length));
        console.info(Searching.getMajority2(first, first.length));
        console.info(Searching.getMajority3(first, first.length));
    }

    public static getMedian(arr : number[], size : number) : number {
        /* sort */((l) => {l.sort(); })(arr);
        return arr[(size / 2|0)];
    }

    public static SearchBotinicArrayMax(arr : number[], size : number) : number {
        let start : number = 0;
        let end : number = size - 1;
        let mid : number = ((start + end) / 2|0);
        let maximaFound : number = 0;
        if(size < 3) {
            console.info("error");
            return 0;
        }
        while((start <= end)) {{
            mid = ((start + end) / 2|0);
            if(arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                maximaFound = 1;
                break;
            } else if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else if(arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                end = mid - 1;
            } else {
                break;
            }
        }};
        if(maximaFound === 0) {
            console.info("error");
            return 0;
        }
        return arr[mid];
    }

    public static SearchBitonicArray(arr : number[], size : number, key : number) : number {
        let max : number = Searching.FindMaxBitonicArray(arr, size);
        let k : number = Searching.BinarySearch(arr, 0, max, key, true);
        if(k !== -1) {
            return k;
        } else {
            return Searching.BinarySearch(arr, max + 1, size - 1, key, false);
        }
    }

    public static FindMaxBitonicArray(arr : number[], size : number) : number {
        let start : number = 0;
        let end : number = size - 1;
        let mid : number;
        if(size < 3) {
            console.info("error");
            return -1;
        }
        while((start <= end)) {{
            mid = ((start + end) / 2|0);
            if(arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                return mid;
            } else if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else if(arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                end = mid - 1;
            } else {
                break;
            }
        }};
        console.info("error");
        return -1;
    }

    public static main11(args : string[]) {
        let first : number[] = [1, 5, 10, 13, 20, 30, 8, 7, 6];
        console.info(Searching.SearchBotinicArrayMax(first, first.length));
        console.info(Searching.SearchBitonicArray(first, first.length, 7));
    }

    public static findKeyCount(arr : number[], size : number, key : number) : number {
        let count : number = 0;
        for(let i : number = 0; i < size; i++) {{
            if(arr[i] === key) {
                count++;
            }
        };}
        return count;
    }

    public static findKeyCount2(arr : number[], size : number, key : number) : number {
        let firstIndex : number;
        let lastIndex : number;
        firstIndex = Searching.findFirstIndex(arr, 0, size - 1, key);
        lastIndex = Searching.findLastIndex(arr, 0, size - 1, key);
        return (lastIndex - firstIndex + 1);
    }

    public static FirstIndex(arr : number[], size : number, low : number, high : number, value : number) : number {
        let mid : number = 0;
        if(high >= low) mid = ((low + high) / 2|0);
        if((mid === 0 || arr[mid - 1] < value) && (arr[mid] === value)) return mid; else if(arr[mid] < value) return Searching.FirstIndex(arr, size, mid + 1, high, value); else return Searching.FirstIndex(arr, size, low, mid - 1, value);
    }

    public static isMajority(arr : number[], size : number) : boolean {
        let majority : number = arr[(size / 2|0)];
        let i : number = Searching.FirstIndex(arr, size, 0, size - 1, majority);
        if(((i + (size / 2|0)) <= (size - 1)) && arr[i + (size / 2|0)] === majority) return true; else return false;
    }

    public static findFirstIndex(arr : number[], start : number, end : number, key : number) : number {
        let mid : number;
        if(end < start) {
            return -1;
        }
        mid = ((start + end) / 2|0);
        if(key === arr[mid] && (mid === start || arr[mid - 1] !== key)) {
            return mid;
        }
        if(key <= arr[mid]) {
            return Searching.findFirstIndex(arr, start, mid - 1, key);
        } else {
            return Searching.findFirstIndex(arr, mid + 1, end, key);
        }
    }

    public static findLastIndex(arr : number[], start : number, end : number, key : number) : number {
        if(end < start) {
            return -1;
        }
        let mid : number = ((start + end) / 2|0);
        if(key === arr[mid] && (mid === end || arr[mid + 1] !== key)) {
            return mid;
        }
        if(key < arr[mid]) {
            return Searching.findLastIndex(arr, start, mid - 1, key);
        } else {
            return Searching.findLastIndex(arr, mid + 1, end, key);
        }
    }

    public static main12(args : string[]) {
        let first : number[] = [1, 5, 10, 13, 20, 30, 8, 7, 6];
        console.info(Searching.findKeyCount(first, first.length, 6));
        console.info(Searching.findKeyCount2(first, first.length, 6));
    }

    public static maxProfit(stocks : number[], size : number) : number {
        let buy : number = 0;
        let sell : number = 0;
        let curMin : number = 0;
        let currProfit : number = 0;
        let maxProfit : number = 0;
        for(let i : number = 0; i < size; i++) {{
            if(stocks[i] < stocks[curMin]) {
                curMin = i;
            }
            currProfit = stocks[i] - stocks[curMin];
            if(currProfit > maxProfit) {
                buy = curMin;
                sell = i;
                maxProfit = currProfit;
            }
        };}
        console.info("Purchase day is- " + buy + " at price " + stocks[buy]);
        console.info("Sell day is- " + sell + " at price " + stocks[sell]);
        return maxProfit;
    }

    public static main133(args : string[]) {
        let first : number[] = [10, 150, 6, 67, 61, 16, 86, 6, 67, 78, 150, 3, 28, 143];
        console.info(Searching.maxProfit(first, first.length));
    }

    public static findMedian(arrFirst : number[], sizeFirst : number, arrSecond : number[], sizeSecond : number) : number {
        let medianIndex : number = (((sizeFirst + sizeSecond) + (sizeFirst + sizeSecond) % 2) / 2|0);
        let i : number = 0;
        let j : number = 0;
        let count : number = 0;
        while((count < medianIndex - 1)) {{
            if(i < sizeFirst - 1 && arrFirst[i] < arrSecond[j]) {
                i++;
            } else {
                j++;
            }
            count++;
        }};
        if(arrFirst[i] < arrSecond[j]) {
            return arrFirst[i];
        } else {
            return arrSecond[j];
        }
    }

    public static main13(args : string[]) {
        let first : number[] = [1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30];
        let second : number[] = [1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30];
        console.info(Searching.findMedian(first, first.length, second, second.length));
    }

    public static BinarySearch01(arr : number[], size : number) : number {
        if(size === 1 && arr[0] === 1) {
            return 0;
        }
        return Searching.BinarySearch01Util(arr, 0, size - 1);
    }

    public static BinarySearch01Util(arr : number[], start : number, end : number) : number {
        if(end < start) {
            return -1;
        }
        let mid : number = ((start + end) / 2|0);
        if(1 === arr[mid] && 0 === arr[mid - 1]) {
            return mid;
        }
        if(0 === arr[mid]) {
            return Searching.BinarySearch01Util(arr, mid + 1, end);
        } else {
            return Searching.BinarySearch01Util(arr, start, mid - 1);
        }
    }

    public static main14(args : string[]) {
        let first : number[] = [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1];
        console.info(Searching.BinarySearch01(first, first.length));
    }

    public static RotationMaxUtil(arr : number[], start : number, end : number) : number {
        if(end <= start) {
            return arr[start];
        }
        let mid : number = ((start + end) / 2|0);
        if(arr[mid] > arr[mid + 1]) return arr[mid];
        if(arr[start] <= arr[mid]) return Searching.RotationMaxUtil(arr, mid + 1, end); else return Searching.RotationMaxUtil(arr, start, mid - 1);
    }

    public static RotationMax(arr : number[], size : number) : number {
        return Searching.RotationMaxUtil(arr, 0, size - 1);
    }

    public static FindRotationMaxUtil(arr : number[], start : number, end : number) : number {
        if(end <= start) return start;
        let mid : number = ((start + end) / 2|0);
        if(arr[mid] > arr[mid + 1]) return mid;
        if(arr[start] <= arr[mid]) return Searching.FindRotationMaxUtil(arr, mid + 1, end); else return Searching.FindRotationMaxUtil(arr, start, mid - 1);
    }

    public static FindRotationMax(arr : number[], size : number) : number {
        return Searching.FindRotationMaxUtil(arr, 0, size - 1);
    }

    public static CountRotation(arr : number[], size : number) : number {
        let maxIndex : number = Searching.FindRotationMaxUtil(arr, 0, size - 1);
        return (maxIndex + 1) % size;
    }

    public static BinarySearchRotateArrayUtil(arr : number[], start : number, end : number, key : number) : number {
        if(end < start) {
            return -1;
        }
        let mid : number = ((start + end) / 2|0);
        if(key === arr[mid]) {
            return mid;
        }
        if(arr[mid] > arr[start]) {
            if(arr[start] <= key && key < arr[mid]) {
                return Searching.BinarySearchRotateArrayUtil(arr, start, mid - 1, key);
            } else {
                return Searching.BinarySearchRotateArrayUtil(arr, mid + 1, end, key);
            }
        } else {
            if(arr[mid] < key && key <= arr[end]) {
                return Searching.BinarySearchRotateArrayUtil(arr, mid + 1, end, key);
            } else {
                return Searching.BinarySearchRotateArrayUtil(arr, start, mid - 1, key);
            }
        }
    }

    public static BinarySearchRotateArray(arr : number[], size : number, key : number) : number {
        return Searching.BinarySearchRotateArrayUtil(arr, 0, size - 1, key);
    }

    public static main555(args : string[]) {
        let first : number[] = [34, 56, 77, 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30];
        console.info(Searching.BinarySearchRotateArray(first, first.length, 20));
        console.info(Searching.CountRotation(first, first.length));
        console.info(first[Searching.FindRotationMax(first, first.length)]);
    }

    public static minAbsDiffAdjCircular(arr : number[], size : number) : number {
        let diff : number = 9999999;
        if(size < 2) return -1;
        for(let i : number = 0; i < size; i++) {diff = Math.min(diff, Math.abs(arr[i] - arr[(i + 1) % size]));}
        return diff;
    }

    public static main666(str : string[]) {
        let arr : number[] = [5, 29, 18, 51, 11];
        console.info(Searching.minAbsDiffAdjCircular(arr, arr.length));
    }

    public static swapch(arr : string[], first : number, second : number) {
        let temp : string = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static transformArrayAB1(arr : string[], size : number) {
        let N : number = (size / 2|0);
        let i : number;
        let j : number;
        for(i = 1; i < N; i++) {{
            for(j = 0; j < i; j++) {{
                Searching.swapch(arr, N - i + 2 * j, N - i + 2 * j + 1);
            };}
        };}
    }

    public static main16(args : string[]) {
        let str : string[] = /* toCharArray */("aaaabbbb").split('');
        Searching.transformArrayAB1(str, str.length);
        console.info(str);
    }

    public static checkPermutation(array1 : string[], size1 : number, array2 : string[], size2 : number) : boolean {
        if(size1 !== size2) {
            return false;
        }
        /* sort */((l) => {l.sort(); })(array1);
        /* sort */((l) => {l.sort(); })(array2);
        for(let i : number = 0; i < size1; i++) {{
            if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(array1[i]) != (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(array2[i])) {
                return false;
            }
        };}
        return true;
    }

    public static main17(args : string[]) {
        let str1 : string[] = /* toCharArray */("aaaabbbb").split('');
        let str2 : string[] = /* toCharArray */("bbaaaabb").split('');
        console.info(Searching.checkPermutation(str1, str1.length, str2, str2.length));
    }

    public static FindElementIn2DArray(arr : number[][], r : number, c : number, value : number) : boolean {
        let row : number = 0;
        let column : number = c - 1;
        while((row < r && column >= 0)) {{
            if(arr[row][column] === value) {
                return true;
            } else if(arr[row][column] > value) {
                column--;
            } else {
                row++;
            }
        }};
        return false;
    }

    public static isAP(arr : number[], size : number) : boolean {
        if(size <= 1) return true;
        /* sort */((l) => {l.sort(); })(arr);
        let diff : number = arr[1] - arr[0];
        for(let i : number = 2; i < size; i++) {{
            if(arr[i] - arr[i - 1] !== diff) return false;
        };}
        return true;
    }

    public static isAP2(arr : number[], size : number) : boolean {
        let first : number = 9999999;
        let second : number = 9999999;
        let value : number;
        let hs : Array<number> = <any>([]);
        for(let i : number = 0; i < size; i++) {{
            if(arr[i] < first) {
                second = first;
                first = arr[i];
            } else if(arr[i] < second) second = arr[i];
        };}
        let diff : number = second - first;
        for(let i : number = 0; i < size; i++) {{
            if(/* contains */(hs.indexOf(<any>(arr[i])) >= 0)) return false;
            /* add */((s, e) => { if(s.indexOf(e)==-1) { s.push(e); return true; } else { return false; } })(hs, arr[i]);
        };}
        for(let i : number = 0; i < size; i++) {{
            value = first + i * diff;
            if(!/* contains */(hs.indexOf(<any>(value)) >= 0)) return false;
        };}
        return true;
    }

    public static isAP3(arr : number[], size : number) : boolean {
        let first : number = 9999999;
        let second : number = 9999999;
        let count : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        let index : number = -1;
        for(let i : number = 0; i < size; i++) {{
            if(arr[i] < first) {
                second = first;
                first = arr[i];
            } else if(arr[i] < second) second = arr[i];
        };}
        let diff : number = second - first;
        for(let i : number = 0; i < size; i++) {index = ((arr[i] - first) / diff|0);}
        if(index > size - 1 || count[index] !== 0) return false;
        count[index] = 1;
        for(let i : number = 0; i < size; i++) {if(count[i] !== 1) return false;;}
        return true;
    }

    public static findBalancedPoint(arr : number[], size : number) : number {
        let first : number = 0;
        let second : number = 0;
        for(let i : number = 1; i < size; i++) {second += arr[i];}
        for(let i : number = 0; i < size; i++) {{
            if(first === second) {
                console.info(i);
                return i;
            }
            if(i < size - 1) first += arr[i];
            second -= arr[i + 1];
        };}
        return -1;
    }

    public static main18(args : string[]) {
        let arr : number[] = [-7, 1, 5, 2, -4, 3, 0];
        console.info(Searching.findBalancedPoint(arr, arr.length));
    }

    public static findFloor(arr : number[], size : number, value : number) : number {
        let start : number = 0;
        let stop : number = size - 1;
        let mid : number;
        while((start <= stop)) {{
            mid = ((start + stop) / 2|0);
            if(arr[mid] === value || (arr[mid] < value && (mid === size - 1 || arr[mid + 1] > value))) return mid; else if(arr[mid] < value) start = mid + 1; else stop = mid - 1;
        }};
        return -1;
    }

    public static findCeil(arr : number[], size : number, value : number) : number {
        let start : number = 0;
        let stop : number = size - 1;
        let mid : number;
        while((start <= stop)) {{
            mid = ((start + stop) / 2|0);
            if(arr[mid] === value || (arr[mid] > value && (mid === 0 || arr[mid - 1] < value))) return mid; else if(arr[mid] < value) start = mid + 1; else stop = mid - 1;
        }};
        return -1;
    }

    public static ClosestNumber(arr : number[], size : number, num : number) : number {
        let start : number = 0;
        let stop : number = size - 1;
        let output : number = -1;
        let minDist : number = 9999;
        let mid : number;
        while((start <= stop)) {{
            mid = ((start + stop) / 2|0);
            if(minDist > Math.abs(arr[mid] - num)) {
                minDist = Math.abs(arr[mid] - num);
                output = arr[mid];
            }
            if(arr[mid] === num) break; else if(arr[mid] > num) stop = mid - 1; else start = mid + 1;
        }};
        return output;
    }

    public static DuplicateKDistance(arr : number[], size : number, k : number) : boolean {
        let hm : any = <any>({});
        for(let i : number = 0; i < size; i++) {{
            if(/* containsKey */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return true; } return false; })(<any>hm, arr[i]) && i - /* get */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries[i].value; } return null; })(<any>hm, arr[i]) <= k) {
                console.info("Value:" + arr[i] + " Index: " + /* get */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries[i].value; } return null; })(<any>hm, arr[i]) + " & " + i);
                return true;
            } else /* put */((m,k,v) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { m.entries[i].value=v; return; } m.entries.push({key:k,value:v,getKey: function() { return this.key }, getValue: function() { return this.value }}); })(<any>hm, arr[i], i);
        };}
        return false;
    }

    public static main66(args : string[]) {
        let arr : number[] = [1, 2, 3, 1, 4, 5];
        Searching.DuplicateKDistance(arr, arr.length, 3);
    }

    public static frequencyCounts(arr : number[], size : number) {
        let index : number;
        for(let i : number = 0; i < size; i++) {{
            while((arr[i] > 0)) {{
                index = arr[i] - 1;
                if(arr[index] > 0) {
                    arr[i] = arr[index];
                    arr[index] = -1;
                } else {
                    arr[index] -= 1;
                    arr[i] = 0;
                }
            }};
        };}
        for(let i : number = 0; i < size; i++) {console.info((i + 1) + Math.abs(arr[i]));}
    }

    public static KLargestElements(arrIn : number[], size : number, k : number) : number {
        let arr : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        for(let i : number = 0; i < size; i++) {arr[i] = arrIn[i];}
        /* sort */((l) => {l.sort(); })(arr);
        for(let i : number = 0; i < size; i++) {{
            if(arrIn[i] >= arr[size - k]) {
                console.info(arrIn[i]);
                return arrIn[i];
            }
        };}
        return -1;
    }

    public static QuickSelectUtil(arr : number[], lower : number, upper : number, k : number) {
        if(upper <= lower) return;
        let pivot : number = arr[lower];
        let start : number = lower;
        let stop : number = upper;
        while((lower < upper)) {{
            while((arr[lower] <= pivot)) {{
                lower++;
            }};
            while((arr[upper] > pivot)) {{
                upper--;
            }};
            if(lower < upper) {
                Searching.swap(arr, upper, lower);
            }
        }};
        Searching.swap(arr, upper, start);
        if(k < upper) Searching.QuickSelectUtil(arr, start, upper - 1, k);
        if(k > upper) Searching.QuickSelectUtil(arr, upper + 1, stop, k);
    }

    public static KLargestElements2(arrIn : number[], size : number, k : number) : number {
        let arr : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        for(let i : number = 0; i < size; i++) {arr[i] = arrIn[i];}
        Searching.QuickSelectUtil(arr, 0, size - 1, size - k);
        for(let i : number = 0; i < size; i++) {{
            if(arrIn[i] >= arr[size - k]) {
                console.info(arrIn[i]);
                return arrIn[i];
            }
        };}
        return -1;
    }

    public static FixPoint(arr : number[], size : number) : number {
        for(let i : number = 0; i < size; i++) {{
            if(arr[i] === i) return i;
        };}
        return -1;
    }

    public static FixPoint2(arr : number[], size : number) : number {
        let low : number = 0;
        let high : number = size - 1;
        let mid : number;
        while((low <= high)) {{
            mid = ((low + high) / 2|0);
            if(arr[mid] === mid) return mid; else if(arr[mid] < mid) low = mid + 1; else high = mid - 1;
        }};
        return -1;
    }

    public static subArraySums(arr : number[], size : number, value : number) : number {
        let first : number = 0;
        let second : number = 0;
        let sum : number = arr[first];
        while((second < size && first < size)) {{
            if(sum === value) console.info(first + second);
            if(sum < value) {
                second += 1;
                if(second < size) sum += arr[second];
            } else {
                sum -= arr[first];
                first += 1;
            }
        }};
        return sum;
    }

    public static MaxConSub(arr : number[], size : number) : number {
        let currMax : number = 0;
        let maximum : number = 0;
        for(let i : number = 0; i < size; i++) {{
            currMax = Math.max(arr[i], currMax + arr[i]);
            if(currMax < 0) currMax = 0;
            if(maximum < currMax) maximum = currMax;
        };}
        console.info(maximum);
        return maximum;
    }

    public static MaxConSubArr(A : number[], sizeA : number, B : number[], sizeB : number) : number {
        let currMax : number = 0;
        let maximum : number = 0;
        let hs : Array<number> = <any>([]);
        for(let i : number = 0; i < sizeB; i++) {/* add */((s, e) => { if(s.indexOf(e)==-1) { s.push(e); return true; } else { return false; } })(hs, B[i]);}
        for(let i : number = 0; i < sizeA; i++) {if(/* contains */(hs.indexOf(<any>(A[i])) >= 0)) currMax = 0; else currMax = Math.max(A[i], currMax + A[i]);;}
        if(currMax < 0) currMax = 0;
        if(maximum < currMax) maximum = currMax;
        console.info(maximum);
        return maximum;
    }

    public static MaxConSubArr2(A : number[], sizeA : number, B : number[], sizeB : number) : number {
        /* sort */((l) => {l.sort(); })(B);
        let currMax : number = 0;
        let maximum : number = 0;
        for(let i : number = 0; i < sizeA; i++) {{
            if(Searching.Binarysearch(B, sizeB, A[i])) currMax = 0; else {
                currMax = Math.max(A[i], currMax + A[i]);
                if(currMax < 0) currMax = 0;
                if(maximum < currMax) maximum = currMax;
            }
        };}
        console.info(maximum);
        return maximum;
    }

    public static RainWater(arr : number[], size : number) : number {
        let leftHigh : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        let rightHigh : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        let max : number = arr[0];
        leftHigh[0] = arr[0];
        for(let i : number = 1; i < size; i++) {{
            if(max < arr[i]) max = arr[i];
            leftHigh[i] = max;
        };}
        max = arr[size - 1];
        rightHigh[size - 1] = arr[size - 1];
        for(let i : number = (size - 2); i >= 0; i--) {{
            if(max < arr[i]) max = arr[i];
            rightHigh[i] = max;
        };}
        let water : number = 0;
        for(let i : number = 0; i < size; i++) {water += Math.min(leftHigh[i], rightHigh[i]) - arr[i];}
        console.info("Water : " + water);
        return water;
    }

    public static RainWater2(arr : number[], size : number) : number {
        let water : number = 0;
        let leftMax : number = 0;
        let rightMax : number = 0;
        let left : number = 0;
        let right : number = size - 1;
        while((left <= right)) {{
            if(arr[left] < arr[right]) {
                if(arr[left] > leftMax) leftMax = arr[left]; else water += leftMax - arr[left];
                left += 1;
            } else {
                if(arr[right] > rightMax) rightMax = arr[right]; else water += rightMax - arr[right];
                right -= 1;
            }
        }};
        console.info("Water : " + water);
        return water;
    }

    public static seperateEvenAndOdd(arr : number[], size : number) {
        let left : number = 0;
        let right : number = size - 1;
        while((left < right)) {{
            if(arr[left] % 2 === 0) {
                left++;
            } else if(arr[right] % 2 === 1) {
                right--;
            } else {
                Searching.swap(arr, left, right);
                left++;
                right--;
            }
        }};
    }

    public static main(args : string[]) {
        let first : number[] = [1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30];
        Searching.seperateEvenAndOdd(first, first.length);
        for(let index8208=0; index8208 < first.length; index8208++) {
            let val = first[index8208];
            {
                console.info(val + " ");
            }
        }
    }
}
Searching["__class"] = "Searching";




Searching.main(null);
