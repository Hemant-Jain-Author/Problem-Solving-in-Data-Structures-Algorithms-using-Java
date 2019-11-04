/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var Searching = /** @class */ (function () {
    function Searching() {
    }
    Searching.linearSearchUnsorted = function (arr, size, value) {
        for (var i = 0; i < size; i++) {
            {
                if (value === arr[i]) {
                    return true;
                }
            }
            ;
        }
        return false;
    };
    Searching.linearSearchSorted = function (arr, size, value) {
        for (var i = 0; i < size; i++) {
            {
                if (value === arr[i]) {
                    return true;
                }
                else if (value < arr[i]) {
                    return false;
                }
            }
            ;
        }
        return false;
    };
    Searching.Binarysearch = function (arr, size, value) {
        var low = 0;
        var high = size - 1;
        var mid;
        while ((low <= high)) {
            {
                mid = ((low + high) / 2 | 0);
                if (arr[mid] === value) {
                    return true;
                }
                else if (arr[mid] < value) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        ;
        return false;
    };
    Searching.BinarySearchRec = function (arr, size, value) {
        var low = 0;
        var high = size - 1;
        return Searching.BinarySearchRecUtil(arr, low, high, value);
    };
    Searching.BinarySearchRecUtil = function (arr, low, high, value) {
        if (low > high) {
            return false;
        }
        var mid = ((low + high) / 2 | 0);
        if (arr[mid] === value) {
            return true;
        }
        else if (arr[mid] < value) {
            return Searching.BinarySearchRecUtil(arr, mid + 1, high, value);
        }
        else {
            return Searching.BinarySearchRecUtil(arr, low, mid - 1, value);
        }
    };
    Searching.BinarySearch = function (arr, start, end, key, isInc) {
        var mid;
        if (end < start) {
            return -1;
        }
        mid = ((start + end) / 2 | 0);
        if (key === arr[mid]) {
            return mid;
        }
        if (isInc !== false && key < arr[mid] || isInc === false && key > arr[mid]) {
            return Searching.BinarySearch(arr, start, mid - 1, key, isInc);
        }
        else {
            return Searching.BinarySearch(arr, mid + 1, end, key, isInc);
        }
    };
    Searching.main1 = function (args) {
        var first = [1, 3, 5, 7, 9, 25, 30];
        console.info(Searching.linearSearchUnsorted(first, 7, 8));
        console.info(Searching.linearSearchSorted(first, 7, 8));
        console.info(Searching.Binarysearch(first, 7, 8));
        console.info(Searching.BinarySearchRec(first, 7, 8));
        console.info(Searching.linearSearchUnsorted(first, 7, 25));
        console.info(Searching.linearSearchSorted(first, 7, 25));
        console.info(Searching.Binarysearch(first, 7, 25));
        console.info(Searching.BinarySearchRec(first, 7, 25));
    };
    Searching.swap = function (arr, first, second) {
        var temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    };
    Searching.FirstRepeated = function (arr, size) {
        for (var i = 0; i < size; i++) {
            {
                for (var j = i + 1; j < size; j++) {
                    {
                        if (arr[i] === arr[j]) {
                            return arr[i];
                        }
                    }
                    ;
                }
            }
            ;
        }
        return 0;
    };
    Searching.main2 = function (args) {
        var first = [34, 56, 77, 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 34, 20, 30];
        console.info(Searching.FirstRepeated(first, first.length));
    };
    Searching.printRepeating = function (arr, size) {
        console.info(" \nRepeating elements are ");
        for (var i = 0; i < size; i++) {
            {
                for (var j = i + 1; j < size; j++) {
                    {
                        if (arr[i] === arr[j]) {
                            console.info(" " + arr[i]);
                        }
                    }
                    ;
                }
            }
            ;
        }
    };
    Searching.printRepeating2 = function (arr, size) {
        /* sort */ (function (l) { l.sort(); })(arr);
        console.info(" \nRepeating elements are ");
        for (var i = 1; i < size; i++) {
            {
                if (arr[i] === arr[i - 1]) {
                    console.info(" " + arr[i]);
                }
            }
            ;
        }
    };
    Searching.printRepeating3 = function (arr, size) {
        var hs = ([]);
        console.info(" \nRepeating elements are ");
        for (var i = 0; i < size; i++) {
            {
                if ( /* contains */(hs.indexOf((arr[i])) >= 0)) {
                    console.info(" " + arr[i]);
                }
                else {
                    /* add */ (function (s, e) { if (s.indexOf(e) == -1) {
                        s.push(e);
                        return true;
                    }
                    else {
                        return false;
                    } })(hs, arr[i]);
                }
            }
            ;
        }
    };
    Searching.printRepeating4 = function (arr, size, range) {
        var count = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(range);
        var i;
        for (i = 0; i < size; i++) {
            {
                count[i] = 0;
            }
            ;
        }
        console.info(" \nRepeating elements are ");
        for (i = 0; i < size; i++) {
            {
                if (count[arr[i]] === 1) {
                    console.info(" " + arr[i]);
                }
                else {
                    count[arr[i]]++;
                }
            }
            ;
        }
    };
    Searching.main3 = function (args) {
        var first = [1, 3, 5, 3, 9, 1, 30];
        Searching.printRepeating(first, first.length);
        Searching.printRepeating2(first, first.length);
        Searching.printRepeating3(first, first.length);
        Searching.printRepeating4(first, first.length, 50);
    };
    Searching.removeDuplicates = function (array, size) {
        var j = 0;
        /* sort */ (function (l) { l.sort(); })(array);
        for (var i = 1; i < size; i++) {
            {
                if (array[i] !== array[j]) {
                    j++;
                    array[j] = array[i];
                }
            }
            ;
        }
        var ret = array.slice(0, j + 1);
        return ret;
    };
    Searching.main4 = function (args) {
        var first = [1, 3, 5, 3, 9, 1, 30];
        var ret = Searching.removeDuplicates(first, first.length);
        for (var i = 0; i < ret.length; i++) {
            {
                console.info(ret[i] + " ");
            }
            ;
        }
    };
    Searching.findMissingNumber = function (arr, size) {
        var i;
        var j;
        var found = 0;
        for (i = 1; i <= size; i++) {
            {
                found = 0;
                for (j = 0; j < size; j++) {
                    {
                        if (arr[j] === i) {
                            found = 1;
                            break;
                        }
                    }
                    ;
                }
                if (found === 0) {
                    return i;
                }
            }
            ;
        }
        return 2147483647;
    };
    Searching.findMissingNumber2 = function (arr, size, range) {
        var i;
        var xorSum = 0;
        for (i = 1; i <= range; i++) {
            {
                xorSum ^= i;
            }
            ;
        }
        for (i = 0; i < size; i++) {
            {
                xorSum ^= arr[i];
            }
            ;
        }
        return xorSum;
    };
    Searching.findMissingNumber3 = function (arr, size, upperRange) {
        var st = ([]);
        var i = 0;
        while ((i < size)) {
            {
                /* add */ (function (s, e) { if (s.indexOf(e) == -1) {
                    s.push(e);
                    return true;
                }
                else {
                    return false;
                } })(st, arr[i]);
                i += 1;
            }
        }
        ;
        i = 1;
        while ((i <= upperRange)) {
            {
                if ( /* contains */(st.indexOf((i)) >= 0) === false)
                    return i;
                i += 1;
            }
        }
        ;
        console.info("NoNumberMissing");
        return -1;
    };
    Searching.main5 = function (args) {
        var first = [1, 3, 5, 4, 6, 8, 7];
        console.info(Searching.findMissingNumber(first, first.length));
        console.info(Searching.findMissingNumber2(first, first.length, 8));
        console.info(Searching.findMissingNumber3(first, first.length, 8));
    };
    Searching.MissingValues = function (arr, size) {
        /* sort */ (function (l) { l.sort(); })(arr);
        var value = arr[0];
        var i = 0;
        while ((i < size)) {
            {
                if (value === arr[i]) {
                    value += 1;
                    i += 1;
                }
                else {
                    console.info(value);
                    value += 1;
                }
            }
        }
        ;
    };
    Searching.MissingValues2 = function (arr, size) {
        var ht = ([]);
        var minVal = 999999;
        var maxVal = -999999;
        for (var i = 0; i < size; i++) {
            {
                /* add */ (function (s, e) { if (s.indexOf(e) == -1) {
                    s.push(e);
                    return true;
                }
                else {
                    return false;
                } })(ht, arr[i]);
                if (minVal > arr[i])
                    minVal = arr[i];
                if (maxVal < arr[i])
                    maxVal = arr[i];
            }
            ;
        }
        for (var i = minVal; i < maxVal + 1; i++) {
            {
                if ( /* contains */(ht.indexOf((i)) >= 0) === false) {
                    console.info(i);
                }
            }
            ;
        }
    };
    Searching.main6 = function (args) {
        var arr = [1, 9, 2, 8, 3, 7, 4, 6];
        var size = arr.length;
        Searching.MissingValues(arr, size);
        Searching.MissingValues2(arr, size);
    };
    Searching.OddCount = function (arr, size) {
        var ctr = ({});
        var count = 0;
        for (var i = 0; i < size; i++) {
            {
                if ( /* containsKey */(function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i_1 = 0; i_1 < m.entries.length; i_1++)
                    if (m.entries[i_1].key.equals != null && m.entries[i_1].key.equals(k) || m.entries[i_1].key === k) {
                        return true;
                    } return false; })(ctr, arr[i])) /* put */
                    (function (m, k, v) { if (m.entries == null)
                        m.entries = []; for (var i_2 = 0; i_2 < m.entries.length; i_2++)
                        if (m.entries[i_2].key.equals != null && m.entries[i_2].key.equals(k) || m.entries[i_2].key === k) {
                            m.entries[i_2].value = v;
                            return;
                        } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(ctr, arr[i], /* get */ (function (m, k) { if (m.entries == null)
                        m.entries = []; for (var i_3 = 0; i_3 < m.entries.length; i_3++)
                        if (m.entries[i_3].key.equals != null && m.entries[i_3].key.equals(k) || m.entries[i_3].key === k) {
                            return m.entries[i_3].value;
                        } return null; })(ctr, arr[i]) + 1);
                else /* put */
                    (function (m, k, v) { if (m.entries == null)
                        m.entries = []; for (var i_4 = 0; i_4 < m.entries.length; i_4++)
                        if (m.entries[i_4].key.equals != null && m.entries[i_4].key.equals(k) || m.entries[i_4].key === k) {
                            m.entries[i_4].value = v;
                            return;
                        } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(ctr, arr[i], 1);
            }
            ;
        }
        for (var i = 0; i < size; i++) {
            {
                if ( /* containsKey */(function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i_5 = 0; i_5 < m.entries.length; i_5++)
                    if (m.entries[i_5].key.equals != null && m.entries[i_5].key.equals(k) || m.entries[i_5].key === k) {
                        return true;
                    } return false; })(ctr, arr[i]) && ( /* get */(function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i_6 = 0; i_6 < m.entries.length; i_6++)
                    if (m.entries[i_6].key.equals != null && m.entries[i_6].key.equals(k) || m.entries[i_6].key === k) {
                        return m.entries[i_6].value;
                    } return null; })(ctr, arr[i]) % 2 === 1)) {
                    console.info(arr[i]);
                    count++;
                    /* remove */ (function (m, k) { if (m.entries == null)
                        m.entries = []; for (var i_7 = 0; i_7 < m.entries.length; i_7++)
                        if (m.entries[i_7].key.equals != null && m.entries[i_7].key.equals(k) || m.entries[i_7].key === k) {
                            return m.entries.splice(i_7, 1)[0];
                        } })(ctr, arr[i]);
                }
            }
            ;
        }
        console.info("Odd count is :: " + count);
    };
    Searching.OddCount2 = function (arr, size) {
        var xorSum = 0;
        var first = 0;
        var second = 0;
        var setBit;
        for (var i = 0; i < size; i++) {
            xorSum = xorSum ^ arr[i];
        }
        setBit = xorSum & ~(xorSum - 1);
        for (var i = 0; i < size; i++) {
            {
                if ((arr[i] & setBit) !== 0)
                    first ^= arr[i];
                else
                    second ^= arr[i];
            }
            ;
        }
        console.info(first + second);
    };
    Searching.SumDistinct = function (arr, size) {
        var sum = 0;
        /* sort */ (function (l) { l.sort(); })(arr);
        for (var i = 0; i < (size - 1); i++) {
            {
                if (arr[i] !== arr[i + 1])
                    sum += arr[i];
            }
            ;
        }
        sum += arr[size - 1];
        console.info(sum);
    };
    Searching.minAbsSumPair = function (arr, size) {
        var l;
        var r;
        var minSum;
        var sum;
        var minFirst;
        var minSecond;
        if (size < 2) {
            console.info("Invalid Input");
            return;
        }
        minFirst = 0;
        minSecond = 1;
        minSum = Math.abs(arr[0] + arr[1]);
        for (l = 0; l < size - 1; l++) {
            {
                for (r = l + 1; r < size; r++) {
                    {
                        sum = Math.abs(arr[l] + arr[r]);
                        if (sum < minSum) {
                            minSum = sum;
                            minFirst = l;
                            minSecond = r;
                        }
                    }
                    ;
                }
            }
            ;
        }
        console.info(" Minimum sum elements are : " + arr[minFirst] + " , " + arr[minSecond]);
    };
    Searching.minAbsSumPair2 = function (arr, size) {
        var l;
        var r;
        var minSum;
        var sum;
        var minFirst;
        var minSecond;
        if (size < 2) {
            console.info("Invalid Input");
            return;
        }
        /* sort */ (function (l) { l.sort(); })(arr);
        minFirst = 0;
        minSecond = size - 1;
        minSum = Math.abs(arr[minFirst] + arr[minSecond]);
        for (l = 0, r = size - 1; l < r;) {
            {
                sum = (arr[l] + arr[r]);
                if (Math.abs(sum) < minSum) {
                    minSum = Math.abs(sum);
                    minFirst = l;
                    minSecond = r;
                }
                if (sum < 0) {
                    l++;
                }
                else if (sum > 0) {
                    r--;
                }
                else {
                    break;
                }
            }
            ;
        }
        console.info(" Minimum sum pair : " + arr[minFirst] + " , " + arr[minSecond]);
    };
    Searching.main7 = function (str) {
        var first = [1, 5, -10, 3, 2, -6, 8, 9, 6];
        Searching.minAbsSumPair2(first, first.length);
        Searching.minAbsSumPair(first, first.length);
    };
    Searching.FindPair = function (arr, size, value) {
        for (var i = 0; i < size; i++) {
            {
                for (var j = i + 1; j < size; j++) {
                    {
                        if ((arr[i] + arr[j]) === value) {
                            console.info("The pair is : " + arr[i] + "," + arr[j]);
                            return true;
                        }
                    }
                    ;
                }
            }
            ;
        }
        return false;
    };
    Searching.FindPair2 = function (arr, size, value) {
        var first = 0;
        var second = size - 1;
        var curr;
        /* sort */ (function (l) { l.sort(); })(arr);
        while ((first < second)) {
            {
                curr = arr[first] + arr[second];
                if (curr === value) {
                    console.info("The pair is " + arr[first] + "," + arr[second]);
                    return true;
                }
                else if (curr < value) {
                    first++;
                }
                else {
                    second--;
                }
            }
        }
        ;
        return false;
    };
    Searching.FindPair3 = function (arr, size, value) {
        var hs = ([]);
        for (var i = 0; i < size; i++) {
            {
                if ( /* contains */(hs.indexOf((value - arr[i])) >= 0)) {
                    console.info("The pair is : " + arr[i] + " , " + (value - arr[i]));
                    return true;
                }
                /* add */ (function (s, e) { if (s.indexOf(e) == -1) {
                    s.push(e);
                    return true;
                }
                else {
                    return false;
                } })(hs, arr[i]);
            }
            ;
        }
        return false;
    };
    Searching.main8 = function (args) {
        var first = [1, 5, 4, 3, 2, 7, 8, 9, 6];
        console.info(Searching.FindPair(first, first.length, 8));
        console.info(Searching.FindPair2(first, first.length, 8));
        console.info(Searching.FindPair3(first, first.length, 8));
    };
    Searching.FindDifference = function (arr, size, value) {
        for (var i = 0; i < size; i++) {
            {
                for (var j = i + 1; j < size; j++) {
                    {
                        if (Math.abs(arr[i] - arr[j]) === value) {
                            console.info("The pair is:: " + arr[i] + " & " + arr[j]);
                            return true;
                        }
                    }
                    ;
                }
            }
            ;
        }
        return false;
    };
    Searching.FindDifference2 = function (arr, size, value) {
        var first = 0;
        var second = 0;
        var diff;
        /* sort */ (function (l) { l.sort(); })(arr);
        while ((first < size && second < size)) {
            {
                diff = Math.abs(arr[first] - arr[second]);
                if (diff === value) {
                    console.info("The pair is::" + arr[first] + " & " + arr[second]);
                    return true;
                }
                else if (diff > value)
                    first += 1;
                else
                    second += 1;
            }
        }
        ;
        return false;
    };
    Searching.findMinDiff = function (arr, size) {
        /* sort */ (function (l) { l.sort(); })(arr);
        var diff = 9999999;
        for (var i = 0; i < (size - 1); i++) {
            {
                if ((arr[i + 1] - arr[i]) < diff)
                    diff = arr[i + 1] - arr[i];
            }
            ;
        }
        return diff;
    };
    Searching.MinDiffPair = function (arr1, size1, arr2, size2) {
        var minDiff = 9999999;
        var first = 0;
        var second = 0;
        var out1 = 0;
        var out2 = 0;
        var diff;
        /* sort */ (function (l) { l.sort(); })(arr1);
        /* sort */ (function (l) { l.sort(); })(arr2);
        while ((first < size1 && second < size2)) {
            {
                diff = Math.abs(arr1[first] - arr2[second]);
                if (minDiff > diff) {
                    minDiff = diff;
                    out1 = arr1[first];
                    out2 = arr2[second];
                }
                if (arr1[first] < arr2[second])
                    first += 1;
                else
                    second += 1;
            }
        }
        ;
        console.info("The pair is :: " + out1 + out2);
        console.info("Minimum difference is :: " + minDiff);
        return minDiff;
    };
    Searching.main88 = function (args) {
        var first = [1, 5, 4, 3, 2, 7, 8, 9, 6];
        console.info(Searching.FindDifference(first, first.length, 6));
        console.info(Searching.FindDifference2(first, first.length, 6));
        console.info(Searching.findMinDiff(first, first.length));
        console.info(Searching.MinDiffPair(first, first.length, first, first.length));
    };
    Searching.ClosestPair = function (arr, size, value) {
        var diff = 999999;
        var first = -1;
        var second = -1;
        var curr;
        for (var i = 0; i < size; i++) {
            {
                for (var j = i + 1; j < size; j++) {
                    {
                        curr = Math.abs(value - (arr[i] + arr[j]));
                        if (curr < diff) {
                            diff = curr;
                            first = arr[i];
                            second = arr[j];
                        }
                    }
                    ;
                }
            }
            ;
        }
        console.info("closest pair is ::" + first + second);
    };
    Searching.ClosestPair2 = function (arr, size, value) {
        var first = 0;
        var second = 0;
        var start = 0;
        var stop = size - 1;
        var diff;
        var curr;
        /* sort */ (function (l) { l.sort(); })(arr);
        diff = 9999999;
        {
            while ((start < stop)) {
                {
                    curr = (value - (arr[start] + arr[stop]));
                    if (Math.abs(curr) < diff) {
                        diff = Math.abs(curr);
                        first = arr[start];
                        second = arr[stop];
                    }
                    if (curr === 0) {
                        break;
                    }
                    else if (curr > 0) {
                        start += 1;
                    }
                    else {
                        stop -= 1;
                    }
                }
            }
            ;
        }
        ;
        console.info("closest pair is :: " + first + second);
    };
    Searching.main99 = function (args) {
        var first = [1, 5, 4, 3, 2, 7, 8, 9, 6];
        Searching.ClosestPair(first, first.length, 6);
        Searching.ClosestPair2(first, first.length, 6);
    };
    Searching.SumPairRestArray = function (arr, size) {
        var total;
        var low;
        var high;
        var curr;
        var value;
        /* sort */ (function (l) { l.sort(); })(arr);
        total = 0;
        for (var i = 0; i < size; i++) {
            total += arr[i];
        }
        value = (total / 2 | 0);
        low = 0;
        high = size - 1;
        while ((low < high)) {
            {
                curr = arr[low] + arr[high];
                if (curr === value) {
                    console.info("Pair is :: " + arr[low] + arr[high]);
                    return true;
                }
                else if (curr < value)
                    low += 1;
                else
                    high -= 1;
            }
        }
        ;
        return false;
    };
    Searching.ZeroSumTriplets = function (arr, size) {
        for (var i = 0; i < (size - 2); i++) {
            {
                for (var j = i + 1; j < (size - 1); j++) {
                    {
                        for (var k = j + 1; k < size; k++) {
                            {
                                if (arr[i] + arr[j] + arr[k] === 0)
                                    console.info("Triplet :: " + arr[i] + arr[j] + arr[k]);
                            }
                            ;
                        }
                    }
                    ;
                }
            }
            ;
        }
    };
    Searching.ZeroSumTriplets2 = function (arr, size) {
        var start;
        var stop;
        /* sort */ (function (l) { l.sort(); })(arr);
        for (var i = 0; i < (size - 2); i++) {
            {
                start = i + 1;
                stop = size - 1;
                while ((start < stop)) {
                    {
                        if (arr[i] + arr[start] + arr[stop] === 0) {
                            console.info("Triplet :: " + arr[i] + arr[start] + arr[stop]);
                            start += 1;
                            stop -= 1;
                        }
                        else if (arr[i] + arr[start] + arr[stop] > 0)
                            stop -= 1;
                        else
                            start += 1;
                    }
                }
                ;
            }
            ;
        }
    };
    Searching.findTriplet = function (arr, size, value) {
        for (var i = 0; i < (size - 2); i++) {
            for (var j = i + 1; j < (size - 1); j++) {
                for (var k = j + 1; k < size; k++) {
                    {
                        if ((arr[i] + arr[j] + arr[k]) === value)
                            console.info("Triplet :: " + arr[i] + arr[j] + arr[k]);
                    }
                    ;
                }
                ;
            }
            ;
        }
    };
    Searching.findTriplet2 = function (arr, size, value) {
        var start;
        var stop;
        /* sort */ (function (l) { l.sort(); })(arr);
        for (var i = 0; i < size - 2; i++) {
            {
                start = i + 1;
                stop = size - 1;
                while ((start < stop)) {
                    {
                        if (arr[i] + arr[start] + arr[stop] === value) {
                            console.info("Triplet ::" + arr[i] + arr[start] + arr[stop]);
                            start += 1;
                            stop -= 1;
                        }
                        else if (arr[i] + arr[start] + arr[stop] > value)
                            stop -= 1;
                        else
                            start += 1;
                    }
                }
                ;
            }
            ;
        }
    };
    Searching.ABCTriplet = function (arr, size) {
        var start;
        var stop;
        /* sort */ (function (l) { l.sort(); })(arr);
        for (var i = 0; i < (size - 2); i++) {
            {
                start = i + 1;
                stop = size - 1;
                while ((start < stop)) {
                    {
                        if (arr[i] === arr[start] + arr[stop]) {
                            console.info("Triplet ::%d, %d, %d" + arr[i] + arr[start] + arr[stop]);
                            start += 1;
                            stop -= 1;
                        }
                        else if (arr[i] > arr[start] + arr[stop])
                            stop -= 1;
                        else
                            start += 1;
                    }
                }
                ;
            }
            ;
        }
    };
    Searching.SmallerThenTripletCount = function (arr, size, value) {
        var start;
        var stop;
        var count = 0;
        /* sort */ (function (l) { l.sort(); })(arr);
        for (var i = 0; i < (size - 2); i++) {
            {
                start = i + 1;
                stop = size - 1;
                while ((start < stop)) {
                    {
                        if (arr[i] + arr[start] + arr[stop] >= value)
                            stop -= 1;
                        else {
                            count += stop - start;
                            start += 1;
                        }
                    }
                }
                ;
            }
            ;
        }
        console.info(count);
    };
    Searching.APTriplets = function (arr, size) {
        var i;
        var j;
        var k;
        for (i = 1; i < size - 1; i++) {
            {
                j = i - 1;
                k = i + 1;
                while ((j >= 0 && k < size)) {
                    {
                        if (arr[j] + arr[k] === 2 * arr[i]) {
                            console.info("Triplet ::" + arr[j] + arr[i] + arr[k]);
                            k += 1;
                            j -= 1;
                        }
                        else if (arr[j] + arr[k] < 2 * arr[i])
                            k += 1;
                        else
                            j -= 1;
                    }
                }
                ;
            }
            ;
        }
    };
    Searching.GPTriplets = function (arr, size) {
        var i;
        var j;
        var k;
        for (i = 1; i < size - 1; i++) {
            {
                j = i - 1;
                k = i + 1;
                while ((j >= 0 && k < size)) {
                    {
                        if (arr[j] * arr[k] === arr[i] * arr[i]) {
                            console.info("Triplet is :: " + arr[j] + arr[i] + arr[k]);
                            k += 1;
                            j -= 1;
                        }
                        else if (arr[j] + arr[k] < 2 * arr[i])
                            k += 1;
                        else
                            j -= 1;
                    }
                }
                ;
            }
            ;
        }
    };
    Searching.numberOfTriangles = function (arr, size) {
        var i;
        var j;
        var k;
        var count = 0;
        for (i = 0; i < (size - 2); i++) {
            {
                for (j = i + 1; j < (size - 1); j++) {
                    {
                        for (k = j + 1; k < size; k++) {
                            {
                                if (arr[i] + arr[j] > arr[k])
                                    count += 1;
                            }
                            ;
                        }
                    }
                    ;
                }
            }
            ;
        }
        return count;
    };
    Searching.numberOfTriangles2 = function (arr, size) {
        var i;
        var j;
        var k;
        var count = 0;
        /* sort */ (function (l) { l.sort(); })(arr);
        for (i = 0; i < (size - 2); i++) {
            {
                k = i + 2;
                for (j = i + 1; j < (size - 1); j++) {
                    {
                        while ((k < size && arr[i] + arr[j] > arr[k])) {
                            k += 1;
                        }
                        ;
                        count += k - j - 1;
                    }
                    ;
                }
            }
            ;
        }
        return count;
    };
    Searching.getMax = function (arr, size) {
        var max = arr[0];
        var count = 1;
        var maxCount = 1;
        for (var i = 0; i < size; i++) {
            {
                count = 1;
                for (var j = i + 1; j < size; j++) {
                    {
                        if (arr[i] === arr[j]) {
                            count++;
                        }
                    }
                    ;
                }
                if (count > maxCount) {
                    max = arr[i];
                    maxCount = count;
                }
            }
            ;
        }
        return max;
    };
    Searching.getMax2 = function (arr, size) {
        var max = arr[0];
        var maxCount = 1;
        var curr = arr[0];
        var currCount = 1;
        /* sort */ (function (l) { l.sort(); })(arr);
        for (var i = 1; i < size; i++) {
            {
                if (arr[i] === arr[i - 1]) {
                    currCount++;
                }
                else {
                    currCount = 1;
                    curr = arr[i];
                }
                if (currCount > maxCount) {
                    maxCount = currCount;
                    max = curr;
                }
            }
            ;
        }
        return max;
    };
    Searching.getMax3 = function (arr, size, range) {
        var max = arr[0];
        var maxCount = 1;
        var count = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(range);
        for (var i = 0; i < size; i++) {
            {
                count[arr[i]]++;
                if (count[arr[i]] > maxCount) {
                    maxCount = count[arr[i]];
                    max = arr[i];
                }
            }
            ;
        }
        return max;
    };
    Searching.main9 = function (args) {
        var first = [1, 30, 5, 13, 9, 31, 5];
        console.info(Searching.getMax(first, first.length));
        console.info(Searching.getMax2(first, first.length));
        console.info(Searching.getMax3(first, first.length, 50));
    };
    Searching.getMajority = function (arr, size) {
        var max = 0;
        var count = 0;
        var maxCount = 0;
        for (var i = 0; i < size; i++) {
            {
                for (var j = i + 1; j < size; j++) {
                    {
                        if (arr[i] === arr[j]) {
                            count++;
                        }
                    }
                    ;
                }
                if (count > maxCount) {
                    max = arr[i];
                    maxCount = count;
                }
            }
            ;
        }
        if (maxCount > (size / 2 | 0)) {
            return max;
        }
        else {
            return 0;
        }
    };
    Searching.getMajority2 = function (arr, size) {
        var majIndex = (size / 2 | 0);
        var count = 1;
        var candidate;
        /* sort */ (function (l) { l.sort(); })(arr);
        candidate = arr[majIndex];
        count = 0;
        for (var i = 0; i < size; i++) {
            {
                if (arr[i] === candidate) {
                    count++;
                }
            }
            ;
        }
        if (count > (size / 2 | 0)) {
            return arr[majIndex];
        }
        else {
            return -2147483648;
        }
    };
    Searching.getMajority3 = function (arr, size) {
        var majIndex = 0;
        var count = 1;
        var i;
        var candidate;
        for (i = 1; i < size; i++) {
            {
                if (arr[majIndex] === arr[i]) {
                    count++;
                }
                else {
                    count--;
                }
                if (count === 0) {
                    majIndex = i;
                    count = 1;
                }
            }
            ;
        }
        candidate = arr[majIndex];
        count = 0;
        for (i = 0; i < size; i++) {
            {
                if (arr[i] === candidate) {
                    count++;
                }
            }
            ;
        }
        if (count > (size / 2 | 0)) {
            return arr[majIndex];
        }
        else {
            return 0;
        }
    };
    Searching.main10 = function (args) {
        var first = [1, 5, 5, 13, 5, 31, 5];
        console.info(Searching.getMajority(first, first.length));
        console.info(Searching.getMajority2(first, first.length));
        console.info(Searching.getMajority3(first, first.length));
    };
    Searching.getMedian = function (arr, size) {
        /* sort */ (function (l) { l.sort(); })(arr);
        return arr[(size / 2 | 0)];
    };
    Searching.SearchBotinicArrayMax = function (arr, size) {
        var start = 0;
        var end = size - 1;
        var mid = ((start + end) / 2 | 0);
        var maximaFound = 0;
        if (size < 3) {
            console.info("error");
            return 0;
        }
        while ((start <= end)) {
            {
                mid = ((start + end) / 2 | 0);
                if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                    maximaFound = 1;
                    break;
                }
                else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                    start = mid + 1;
                }
                else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                    end = mid - 1;
                }
                else {
                    break;
                }
            }
        }
        ;
        if (maximaFound === 0) {
            console.info("error");
            return 0;
        }
        return arr[mid];
    };
    Searching.SearchBitonicArray = function (arr, size, key) {
        var max = Searching.FindMaxBitonicArray(arr, size);
        var k = Searching.BinarySearch(arr, 0, max, key, true);
        if (k !== -1) {
            return k;
        }
        else {
            return Searching.BinarySearch(arr, max + 1, size - 1, key, false);
        }
    };
    Searching.FindMaxBitonicArray = function (arr, size) {
        var start = 0;
        var end = size - 1;
        var mid;
        if (size < 3) {
            console.info("error");
            return -1;
        }
        while ((start <= end)) {
            {
                mid = ((start + end) / 2 | 0);
                if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                    return mid;
                }
                else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                    start = mid + 1;
                }
                else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                    end = mid - 1;
                }
                else {
                    break;
                }
            }
        }
        ;
        console.info("error");
        return -1;
    };
    Searching.main11 = function (args) {
        var first = [1, 5, 10, 13, 20, 30, 8, 7, 6];
        console.info(Searching.SearchBotinicArrayMax(first, first.length));
        console.info(Searching.SearchBitonicArray(first, first.length, 7));
    };
    Searching.findKeyCount = function (arr, size, key) {
        var count = 0;
        for (var i = 0; i < size; i++) {
            {
                if (arr[i] === key) {
                    count++;
                }
            }
            ;
        }
        return count;
    };
    Searching.findKeyCount2 = function (arr, size, key) {
        var firstIndex;
        var lastIndex;
        firstIndex = Searching.findFirstIndex(arr, 0, size - 1, key);
        lastIndex = Searching.findLastIndex(arr, 0, size - 1, key);
        return (lastIndex - firstIndex + 1);
    };
    Searching.FirstIndex = function (arr, size, low, high, value) {
        var mid = 0;
        if (high >= low)
            mid = ((low + high) / 2 | 0);
        if ((mid === 0 || arr[mid - 1] < value) && (arr[mid] === value))
            return mid;
        else if (arr[mid] < value)
            return Searching.FirstIndex(arr, size, mid + 1, high, value);
        else
            return Searching.FirstIndex(arr, size, low, mid - 1, value);
    };
    Searching.isMajority = function (arr, size) {
        var majority = arr[(size / 2 | 0)];
        var i = Searching.FirstIndex(arr, size, 0, size - 1, majority);
        if (((i + (size / 2 | 0)) <= (size - 1)) && arr[i + (size / 2 | 0)] === majority)
            return true;
        else
            return false;
    };
    Searching.findFirstIndex = function (arr, start, end, key) {
        var mid;
        if (end < start) {
            return -1;
        }
        mid = ((start + end) / 2 | 0);
        if (key === arr[mid] && (mid === start || arr[mid - 1] !== key)) {
            return mid;
        }
        if (key <= arr[mid]) {
            return Searching.findFirstIndex(arr, start, mid - 1, key);
        }
        else {
            return Searching.findFirstIndex(arr, mid + 1, end, key);
        }
    };
    Searching.findLastIndex = function (arr, start, end, key) {
        if (end < start) {
            return -1;
        }
        var mid = ((start + end) / 2 | 0);
        if (key === arr[mid] && (mid === end || arr[mid + 1] !== key)) {
            return mid;
        }
        if (key < arr[mid]) {
            return Searching.findLastIndex(arr, start, mid - 1, key);
        }
        else {
            return Searching.findLastIndex(arr, mid + 1, end, key);
        }
    };
    Searching.main12 = function (args) {
        var first = [1, 5, 10, 13, 20, 30, 8, 7, 6];
        console.info(Searching.findKeyCount(first, first.length, 6));
        console.info(Searching.findKeyCount2(first, first.length, 6));
    };
    Searching.maxProfit = function (stocks, size) {
        var buy = 0;
        var sell = 0;
        var curMin = 0;
        var currProfit = 0;
        var maxProfit = 0;
        for (var i = 0; i < size; i++) {
            {
                if (stocks[i] < stocks[curMin]) {
                    curMin = i;
                }
                currProfit = stocks[i] - stocks[curMin];
                if (currProfit > maxProfit) {
                    buy = curMin;
                    sell = i;
                    maxProfit = currProfit;
                }
            }
            ;
        }
        console.info("Purchase day is- " + buy + " at price " + stocks[buy]);
        console.info("Sell day is- " + sell + " at price " + stocks[sell]);
        return maxProfit;
    };
    Searching.main133 = function (args) {
        var first = [10, 150, 6, 67, 61, 16, 86, 6, 67, 78, 150, 3, 28, 143];
        console.info(Searching.maxProfit(first, first.length));
    };
    Searching.findMedian = function (arrFirst, sizeFirst, arrSecond, sizeSecond) {
        var medianIndex = (((sizeFirst + sizeSecond) + (sizeFirst + sizeSecond) % 2) / 2 | 0);
        var i = 0;
        var j = 0;
        var count = 0;
        while ((count < medianIndex - 1)) {
            {
                if (i < sizeFirst - 1 && arrFirst[i] < arrSecond[j]) {
                    i++;
                }
                else {
                    j++;
                }
                count++;
            }
        }
        ;
        if (arrFirst[i] < arrSecond[j]) {
            return arrFirst[i];
        }
        else {
            return arrSecond[j];
        }
    };
    Searching.main13 = function (args) {
        var first = [1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30];
        var second = [1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30];
        console.info(Searching.findMedian(first, first.length, second, second.length));
    };
    Searching.BinarySearch01 = function (arr, size) {
        if (size === 1 && arr[0] === 1) {
            return 0;
        }
        return Searching.BinarySearch01Util(arr, 0, size - 1);
    };
    Searching.BinarySearch01Util = function (arr, start, end) {
        if (end < start) {
            return -1;
        }
        var mid = ((start + end) / 2 | 0);
        if (1 === arr[mid] && 0 === arr[mid - 1]) {
            return mid;
        }
        if (0 === arr[mid]) {
            return Searching.BinarySearch01Util(arr, mid + 1, end);
        }
        else {
            return Searching.BinarySearch01Util(arr, start, mid - 1);
        }
    };
    Searching.main14 = function (args) {
        var first = [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1];
        console.info(Searching.BinarySearch01(first, first.length));
    };
    Searching.RotationMaxUtil = function (arr, start, end) {
        if (end <= start) {
            return arr[start];
        }
        var mid = ((start + end) / 2 | 0);
        if (arr[mid] > arr[mid + 1])
            return arr[mid];
        if (arr[start] <= arr[mid])
            return Searching.RotationMaxUtil(arr, mid + 1, end);
        else
            return Searching.RotationMaxUtil(arr, start, mid - 1);
    };
    Searching.RotationMax = function (arr, size) {
        return Searching.RotationMaxUtil(arr, 0, size - 1);
    };
    Searching.FindRotationMaxUtil = function (arr, start, end) {
        if (end <= start)
            return start;
        var mid = ((start + end) / 2 | 0);
        if (arr[mid] > arr[mid + 1])
            return mid;
        if (arr[start] <= arr[mid])
            return Searching.FindRotationMaxUtil(arr, mid + 1, end);
        else
            return Searching.FindRotationMaxUtil(arr, start, mid - 1);
    };
    Searching.FindRotationMax = function (arr, size) {
        return Searching.FindRotationMaxUtil(arr, 0, size - 1);
    };
    Searching.CountRotation = function (arr, size) {
        var maxIndex = Searching.FindRotationMaxUtil(arr, 0, size - 1);
        return (maxIndex + 1) % size;
    };
    Searching.BinarySearchRotateArrayUtil = function (arr, start, end, key) {
        if (end < start) {
            return -1;
        }
        var mid = ((start + end) / 2 | 0);
        if (key === arr[mid]) {
            return mid;
        }
        if (arr[mid] > arr[start]) {
            if (arr[start] <= key && key < arr[mid]) {
                return Searching.BinarySearchRotateArrayUtil(arr, start, mid - 1, key);
            }
            else {
                return Searching.BinarySearchRotateArrayUtil(arr, mid + 1, end, key);
            }
        }
        else {
            if (arr[mid] < key && key <= arr[end]) {
                return Searching.BinarySearchRotateArrayUtil(arr, mid + 1, end, key);
            }
            else {
                return Searching.BinarySearchRotateArrayUtil(arr, start, mid - 1, key);
            }
        }
    };
    Searching.BinarySearchRotateArray = function (arr, size, key) {
        return Searching.BinarySearchRotateArrayUtil(arr, 0, size - 1, key);
    };
    Searching.main555 = function (args) {
        var first = [34, 56, 77, 1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30];
        console.info(Searching.BinarySearchRotateArray(first, first.length, 20));
        console.info(Searching.CountRotation(first, first.length));
        console.info(first[Searching.FindRotationMax(first, first.length)]);
    };
    Searching.minAbsDiffAdjCircular = function (arr, size) {
        var diff = 9999999;
        if (size < 2)
            return -1;
        for (var i = 0; i < size; i++) {
            diff = Math.min(diff, Math.abs(arr[i] - arr[(i + 1) % size]));
        }
        return diff;
    };
    Searching.main666 = function (str) {
        var arr = [5, 29, 18, 51, 11];
        console.info(Searching.minAbsDiffAdjCircular(arr, arr.length));
    };
    Searching.swapch = function (arr, first, second) {
        var temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    };
    Searching.transformArrayAB1 = function (arr, size) {
        var N = (size / 2 | 0);
        var i;
        var j;
        for (i = 1; i < N; i++) {
            {
                for (j = 0; j < i; j++) {
                    {
                        Searching.swapch(arr, N - i + 2 * j, N - i + 2 * j + 1);
                    }
                    ;
                }
            }
            ;
        }
    };
    Searching.main16 = function (args) {
        var str = ("aaaabbbb").split('');
        Searching.transformArrayAB1(str, str.length);
        console.info(str);
    };
    Searching.checkPermutation = function (array1, size1, array2, size2) {
        if (size1 !== size2) {
            return false;
        }
        /* sort */ (function (l) { l.sort(); })(array1);
        /* sort */ (function (l) { l.sort(); })(array2);
        for (var i = 0; i < size1; i++) {
            {
                if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(array1[i]) != (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(array2[i])) {
                    return false;
                }
            }
            ;
        }
        return true;
    };
    Searching.main17 = function (args) {
        var str1 = ("aaaabbbb").split('');
        var str2 = ("bbaaaabb").split('');
        console.info(Searching.checkPermutation(str1, str1.length, str2, str2.length));
    };
    Searching.FindElementIn2DArray = function (arr, r, c, value) {
        var row = 0;
        var column = c - 1;
        while ((row < r && column >= 0)) {
            {
                if (arr[row][column] === value) {
                    return true;
                }
                else if (arr[row][column] > value) {
                    column--;
                }
                else {
                    row++;
                }
            }
        }
        ;
        return false;
    };
    Searching.isAP = function (arr, size) {
        if (size <= 1)
            return true;
        /* sort */ (function (l) { l.sort(); })(arr);
        var diff = arr[1] - arr[0];
        for (var i = 2; i < size; i++) {
            {
                if (arr[i] - arr[i - 1] !== diff)
                    return false;
            }
            ;
        }
        return true;
    };
    Searching.isAP2 = function (arr, size) {
        var first = 9999999;
        var second = 9999999;
        var value;
        var hs = ([]);
        for (var i = 0; i < size; i++) {
            {
                if (arr[i] < first) {
                    second = first;
                    first = arr[i];
                }
                else if (arr[i] < second)
                    second = arr[i];
            }
            ;
        }
        var diff = second - first;
        for (var i = 0; i < size; i++) {
            {
                if ( /* contains */(hs.indexOf((arr[i])) >= 0))
                    return false;
                /* add */ (function (s, e) { if (s.indexOf(e) == -1) {
                    s.push(e);
                    return true;
                }
                else {
                    return false;
                } })(hs, arr[i]);
            }
            ;
        }
        for (var i = 0; i < size; i++) {
            {
                value = first + i * diff;
                if (!(hs.indexOf((value)) >= 0))
                    return false;
            }
            ;
        }
        return true;
    };
    Searching.isAP3 = function (arr, size) {
        var first = 9999999;
        var second = 9999999;
        var count = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        var index = -1;
        for (var i = 0; i < size; i++) {
            {
                if (arr[i] < first) {
                    second = first;
                    first = arr[i];
                }
                else if (arr[i] < second)
                    second = arr[i];
            }
            ;
        }
        var diff = second - first;
        for (var i = 0; i < size; i++) {
            index = ((arr[i] - first) / diff | 0);
        }
        if (index > size - 1 || count[index] !== 0)
            return false;
        count[index] = 1;
        for (var i = 0; i < size; i++) {
            if (count[i] !== 1)
                return false;
            ;
        }
        return true;
    };
    Searching.findBalancedPoint = function (arr, size) {
        var first = 0;
        var second = 0;
        for (var i = 1; i < size; i++) {
            second += arr[i];
        }
        for (var i = 0; i < size; i++) {
            {
                if (first === second) {
                    console.info(i);
                    return i;
                }
                if (i < size - 1)
                    first += arr[i];
                second -= arr[i + 1];
            }
            ;
        }
        return -1;
    };
    Searching.main18 = function (args) {
        var arr = [-7, 1, 5, 2, -4, 3, 0];
        console.info(Searching.findBalancedPoint(arr, arr.length));
    };
    Searching.findFloor = function (arr, size, value) {
        var start = 0;
        var stop = size - 1;
        var mid;
        while ((start <= stop)) {
            {
                mid = ((start + stop) / 2 | 0);
                if (arr[mid] === value || (arr[mid] < value && (mid === size - 1 || arr[mid + 1] > value)))
                    return mid;
                else if (arr[mid] < value)
                    start = mid + 1;
                else
                    stop = mid - 1;
            }
        }
        ;
        return -1;
    };
    Searching.findCeil = function (arr, size, value) {
        var start = 0;
        var stop = size - 1;
        var mid;
        while ((start <= stop)) {
            {
                mid = ((start + stop) / 2 | 0);
                if (arr[mid] === value || (arr[mid] > value && (mid === 0 || arr[mid - 1] < value)))
                    return mid;
                else if (arr[mid] < value)
                    start = mid + 1;
                else
                    stop = mid - 1;
            }
        }
        ;
        return -1;
    };
    Searching.ClosestNumber = function (arr, size, num) {
        var start = 0;
        var stop = size - 1;
        var output = -1;
        var minDist = 9999;
        var mid;
        while ((start <= stop)) {
            {
                mid = ((start + stop) / 2 | 0);
                if (minDist > Math.abs(arr[mid] - num)) {
                    minDist = Math.abs(arr[mid] - num);
                    output = arr[mid];
                }
                if (arr[mid] === num)
                    break;
                else if (arr[mid] > num)
                    stop = mid - 1;
                else
                    start = mid + 1;
            }
        }
        ;
        return output;
    };
    Searching.DuplicateKDistance = function (arr, size, k) {
        var hm = ({});
        for (var i = 0; i < size; i++) {
            {
                if ( /* containsKey */(function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i_8 = 0; i_8 < m.entries.length; i_8++)
                    if (m.entries[i_8].key.equals != null && m.entries[i_8].key.equals(k) || m.entries[i_8].key === k) {
                        return true;
                    } return false; })(hm, arr[i]) && i - /* get */ (function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i_9 = 0; i_9 < m.entries.length; i_9++)
                    if (m.entries[i_9].key.equals != null && m.entries[i_9].key.equals(k) || m.entries[i_9].key === k) {
                        return m.entries[i_9].value;
                    } return null; })(hm, arr[i]) <= k) {
                    console.info("Value:" + arr[i] + " Index: " + /* get */ (function (m, k) { if (m.entries == null)
                        m.entries = []; for (var i_10 = 0; i_10 < m.entries.length; i_10++)
                        if (m.entries[i_10].key.equals != null && m.entries[i_10].key.equals(k) || m.entries[i_10].key === k) {
                            return m.entries[i_10].value;
                        } return null; })(hm, arr[i]) + " & " + i);
                    return true;
                }
                else /* put */
                    (function (m, k, v) { if (m.entries == null)
                        m.entries = []; for (var i_11 = 0; i_11 < m.entries.length; i_11++)
                        if (m.entries[i_11].key.equals != null && m.entries[i_11].key.equals(k) || m.entries[i_11].key === k) {
                            m.entries[i_11].value = v;
                            return;
                        } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(hm, arr[i], i);
            }
            ;
        }
        return false;
    };
    Searching.main66 = function (args) {
        var arr = [1, 2, 3, 1, 4, 5];
        Searching.DuplicateKDistance(arr, arr.length, 3);
    };
    Searching.frequencyCounts = function (arr, size) {
        var index;
        for (var i = 0; i < size; i++) {
            {
                while ((arr[i] > 0)) {
                    {
                        index = arr[i] - 1;
                        if (arr[index] > 0) {
                            arr[i] = arr[index];
                            arr[index] = -1;
                        }
                        else {
                            arr[index] -= 1;
                            arr[i] = 0;
                        }
                    }
                }
                ;
            }
            ;
        }
        for (var i = 0; i < size; i++) {
            console.info((i + 1) + Math.abs(arr[i]));
        }
    };
    Searching.KLargestElements = function (arrIn, size, k) {
        var arr = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        for (var i = 0; i < size; i++) {
            arr[i] = arrIn[i];
        }
        /* sort */ (function (l) { l.sort(); })(arr);
        for (var i = 0; i < size; i++) {
            {
                if (arrIn[i] >= arr[size - k]) {
                    console.info(arrIn[i]);
                    return arrIn[i];
                }
            }
            ;
        }
        return -1;
    };
    Searching.QuickSelectUtil = function (arr, lower, upper, k) {
        if (upper <= lower)
            return;
        var pivot = arr[lower];
        var start = lower;
        var stop = upper;
        while ((lower < upper)) {
            {
                while ((arr[lower] <= pivot)) {
                    {
                        lower++;
                    }
                }
                ;
                while ((arr[upper] > pivot)) {
                    {
                        upper--;
                    }
                }
                ;
                if (lower < upper) {
                    Searching.swap(arr, upper, lower);
                }
            }
        }
        ;
        Searching.swap(arr, upper, start);
        if (k < upper)
            Searching.QuickSelectUtil(arr, start, upper - 1, k);
        if (k > upper)
            Searching.QuickSelectUtil(arr, upper + 1, stop, k);
    };
    Searching.KLargestElements2 = function (arrIn, size, k) {
        var arr = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        for (var i = 0; i < size; i++) {
            arr[i] = arrIn[i];
        }
        Searching.QuickSelectUtil(arr, 0, size - 1, size - k);
        for (var i = 0; i < size; i++) {
            {
                if (arrIn[i] >= arr[size - k]) {
                    console.info(arrIn[i]);
                    return arrIn[i];
                }
            }
            ;
        }
        return -1;
    };
    Searching.FixPoint = function (arr, size) {
        for (var i = 0; i < size; i++) {
            {
                if (arr[i] === i)
                    return i;
            }
            ;
        }
        return -1;
    };
    Searching.FixPoint2 = function (arr, size) {
        var low = 0;
        var high = size - 1;
        var mid;
        while ((low <= high)) {
            {
                mid = ((low + high) / 2 | 0);
                if (arr[mid] === mid)
                    return mid;
                else if (arr[mid] < mid)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        ;
        return -1;
    };
    Searching.subArraySums = function (arr, size, value) {
        var first = 0;
        var second = 0;
        var sum = arr[first];
        while ((second < size && first < size)) {
            {
                if (sum === value)
                    console.info(first + second);
                if (sum < value) {
                    second += 1;
                    if (second < size)
                        sum += arr[second];
                }
                else {
                    sum -= arr[first];
                    first += 1;
                }
            }
        }
        ;
        return sum;
    };
    Searching.MaxConSub = function (arr, size) {
        var currMax = 0;
        var maximum = 0;
        for (var i = 0; i < size; i++) {
            {
                currMax = Math.max(arr[i], currMax + arr[i]);
                if (currMax < 0)
                    currMax = 0;
                if (maximum < currMax)
                    maximum = currMax;
            }
            ;
        }
        console.info(maximum);
        return maximum;
    };
    Searching.MaxConSubArr = function (A, sizeA, B, sizeB) {
        var currMax = 0;
        var maximum = 0;
        var hs = ([]);
        for (var i = 0; i < sizeB; i++) { /* add */
            (function (s, e) { if (s.indexOf(e) == -1) {
                s.push(e);
                return true;
            }
            else {
                return false;
            } })(hs, B[i]);
        }
        for (var i = 0; i < sizeA; i++) {
            if ( /* contains */(hs.indexOf((A[i])) >= 0))
                currMax = 0;
            else
                currMax = Math.max(A[i], currMax + A[i]);
            ;
        }
        if (currMax < 0)
            currMax = 0;
        if (maximum < currMax)
            maximum = currMax;
        console.info(maximum);
        return maximum;
    };
    Searching.MaxConSubArr2 = function (A, sizeA, B, sizeB) {
        /* sort */ (function (l) { l.sort(); })(B);
        var currMax = 0;
        var maximum = 0;
        for (var i = 0; i < sizeA; i++) {
            {
                if (Searching.Binarysearch(B, sizeB, A[i]))
                    currMax = 0;
                else {
                    currMax = Math.max(A[i], currMax + A[i]);
                    if (currMax < 0)
                        currMax = 0;
                    if (maximum < currMax)
                        maximum = currMax;
                }
            }
            ;
        }
        console.info(maximum);
        return maximum;
    };
    Searching.RainWater = function (arr, size) {
        var leftHigh = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        var rightHigh = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        var max = arr[0];
        leftHigh[0] = arr[0];
        for (var i = 1; i < size; i++) {
            {
                if (max < arr[i])
                    max = arr[i];
                leftHigh[i] = max;
            }
            ;
        }
        max = arr[size - 1];
        rightHigh[size - 1] = arr[size - 1];
        for (var i = (size - 2); i >= 0; i--) {
            {
                if (max < arr[i])
                    max = arr[i];
                rightHigh[i] = max;
            }
            ;
        }
        var water = 0;
        for (var i = 0; i < size; i++) {
            water += Math.min(leftHigh[i], rightHigh[i]) - arr[i];
        }
        console.info("Water : " + water);
        return water;
    };
    Searching.RainWater2 = function (arr, size) {
        var water = 0;
        var leftMax = 0;
        var rightMax = 0;
        var left = 0;
        var right = size - 1;
        while ((left <= right)) {
            {
                if (arr[left] < arr[right]) {
                    if (arr[left] > leftMax)
                        leftMax = arr[left];
                    else
                        water += leftMax - arr[left];
                    left += 1;
                }
                else {
                    if (arr[right] > rightMax)
                        rightMax = arr[right];
                    else
                        water += rightMax - arr[right];
                    right -= 1;
                }
            }
        }
        ;
        console.info("Water : " + water);
        return water;
    };
    Searching.seperateEvenAndOdd = function (arr, size) {
        var left = 0;
        var right = size - 1;
        while ((left < right)) {
            {
                if (arr[left] % 2 === 0) {
                    left++;
                }
                else if (arr[right] % 2 === 1) {
                    right--;
                }
                else {
                    Searching.swap(arr, left, right);
                    left++;
                    right--;
                }
            }
        }
        ;
    };
    Searching.main = function (args) {
        var first = [1, 5, 6, 6, 6, 6, 6, 6, 7, 8, 10, 13, 20, 30];
        Searching.seperateEvenAndOdd(first, first.length);
        for (var index8208 = 0; index8208 < first.length; index8208++) {
            var val = first[index8208];
            {
                console.info(val + " ");
            }
        }
    };
    return Searching;
}());
Searching["__class"] = "Searching";
Searching.main(null);
