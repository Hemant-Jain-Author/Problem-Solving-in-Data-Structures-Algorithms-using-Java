var Introduction = /** @class */ (function () {
    function Introduction() {
    }
    Introduction.printArray = function (arr, count) {
        console.info("[");
        for (var i = 0; i < count; i++) {
            {
                console.info(" " + arr[i]);
            }
            ;
        }
        console.info(" ]\n");
    };
    Introduction.swap = function (arr, x, y) {
        var temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return;
    };
    Introduction.SumArray = function (arr) {
        var size = arr.length;
        var total = 0;
        for (var index = 0; index < size; index++) {
            {
                total = total + arr[index];
            }
            ;
        }
        return total;
    };
    Introduction.main0 = function (args) {
        var arr = [1, 2, 3, 4, 5, 6, 7, 8, 9];
        console.info("Sum of values in array:" + Introduction.SumArray(arr));
    };
    Introduction.prototype.function2 = function () {
        console.info("fun2 line 1");
    };
    Introduction.prototype.function1 = function () {
        console.info("fun1 line 1");
        this.function2();
        console.info("fun1 line 2");
    };
    Introduction.prototype.main2 = function () {
        console.info("main line 1");
        this.function1();
        console.info("main line 2");
    };
    Introduction.SequentialSearch = function (arr, size, value) {
        for (var i = 0; i < size; i++) {
            {
                if (value === arr[i]) {
                    {
                        return i;
                    }
                    ;
                }
            }
            ;
        }
        return -1;
    };
    Introduction.BinarySearch = function (arr, size, value) {
        var mid;
        var low = 0;
        var high = size - 1;
        while ((low <= high)) {
            {
                mid = low + ((high - low) / 2 | 0);
                if (arr[mid] === value) {
                    return mid;
                }
                else {
                    if (arr[mid] < value) {
                        low = mid + 1;
                    }
                    else {
                        high = mid - 1;
                    }
                }
            }
        }
        ;
        return -1;
    };
    Introduction.main3 = function (args) {
        var arr = [1, 2, 3, 4, 5, 6, 7, 8, 9];
        console.info("Sum of values in array:" + Introduction.SequentialSearch(arr, arr.length, 7));
        console.info("Sum of values in array:" + Introduction.BinarySearch(arr, arr.length, 7));
    };
    Introduction.rotateArray = function (a, n, k) {
        Introduction.reverseArray(a, 0, k - 1);
        Introduction.reverseArray(a, k, n - 1);
        Introduction.reverseArray(a, 0, n - 1);
    };
    Introduction.reverseArray = function (a, start, end) {
        for (var i = start, j = end; i < j; i++, j--) {
            {
                var temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            ;
        }
    };
    Introduction.reverseArray2 = function (a) {
        var start = 0;
        var end = a.length - 1;
        for (var i = start, j = end; i < j; i++, j--) {
            {
                var temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            ;
        }
    };
    Introduction.main4 = function (args) {
        var arr = [1, 2, 3, 4, 5, 6];
        Introduction.rotateArray(arr, arr.length, 2);
        Introduction.printArray(arr, arr.length);
    };
    Introduction.maxSubArraySum = function (a, size) {
        var maxSoFar = 0;
        var maxEndingHere = 0;
        for (var i = 0; i < size; i++) {
            {
                maxEndingHere = maxEndingHere + a[i];
                if (maxEndingHere < 0) {
                    maxEndingHere = 0;
                }
                if (maxSoFar < maxEndingHere) {
                    maxSoFar = maxEndingHere;
                }
            }
            ;
        }
        return maxSoFar;
    };
    Introduction.main5 = function (args) {
        var arr = [1, -2, 3, 4, -4, 6, -4, 3, 2];
        console.info("Max sub array sum :" + Introduction.maxSubArraySum(arr, 9));
    };
    Introduction.WaveArray2 = function (arr) {
        var size = arr.length;
        for (var i = 1; i < size; i += 2) {
            {
                if ((i - 1) >= 0 && arr[i] > arr[i - 1]) {
                    Introduction.swap(arr, i, i - 1);
                }
                if ((i + 1) < size && arr[i] > arr[i + 1]) {
                    Introduction.swap(arr, i, i + 1);
                }
            }
            ;
        }
    };
    Introduction.WaveArray = function (arr) {
        var size = arr.length;
        /* sort */ (function (l) { l.sort(); })(arr);
        Introduction.printArray(arr, arr.length);
        for (var i = 0; i < size - 1; i += 2) {
            {
                Introduction.swap(arr, i, i + 1);
            }
            ;
        }
    };
    Introduction.main6 = function (args) {
        var arr = [8, 1, 2, 3, 4, 5, 6, 4, 2];
        Introduction.printArray(arr, arr.length);
        Introduction.WaveArray(arr);
        Introduction.printArray(arr, arr.length);
        var arr2 = [8, 1, 2, 3, 4, 5, 6, 4, 2];
        Introduction.WaveArray2(arr2);
        Introduction.printArray(arr2, arr2.length);
    };
    Introduction.indexArray = function (arr, size) {
        for (var i = 0; i < size; i++) {
            {
                var curr = i;
                var value = -1;
                while ((arr[curr] !== -1 && arr[curr] !== curr)) {
                    {
                        var temp = arr[curr];
                        arr[curr] = value;
                        value = curr = temp;
                    }
                }
                ;
                if (value !== -1) {
                    arr[curr] = value;
                }
            }
            ;
        }
    };
    Introduction.indexArray2 = function (arr, size) {
        var temp;
        for (var i = 0; i < size; i++) {
            {
                while ((arr[i] !== -1 && arr[i] !== i)) {
                    {
                        temp = arr[i];
                        arr[i] = arr[temp];
                        arr[temp] = temp;
                    }
                }
                ;
            }
            ;
        }
    };
    Introduction.main7 = function (args) {
        var arr = [8, -1, 6, 1, 9, 3, 2, 7, 4, -1];
        var size = arr.length;
        Introduction.indexArray2(arr, size);
        Introduction.printArray(arr, size);
        var arr2 = [8, -1, 6, 1, 9, 3, 2, 7, 4, -1];
        size = arr2.length;
        Introduction.indexArray(arr2, size);
        Introduction.printArray(arr2, size);
    };
    Introduction.Sort1toN = function (arr, size) {
        var curr;
        var value;
        var next;
        for (var i = 0; i < size; i++) {
            {
                curr = i;
                value = -1;
                while ((curr >= 0 && curr < size && arr[curr] !== curr + 1)) {
                    {
                        next = arr[curr];
                        arr[curr] = value;
                        value = next;
                        curr = next - 1;
                    }
                }
                ;
            }
            ;
        }
    };
    Introduction.Sort1toN2 = function (arr, size) {
        var temp;
        for (var i = 0; i < size; i++) {
            {
                while ((arr[i] !== i + 1 && arr[i] > 1)) {
                    {
                        temp = arr[i];
                        arr[i] = arr[temp - 1];
                        arr[temp - 1] = temp;
                    }
                }
                ;
            }
            ;
        }
    };
    Introduction.main8 = function (args) {
        var arr = [8, 5, 6, 1, 9, 3, 2, 7, 4, 10];
        var size = arr.length;
        Introduction.Sort1toN2(arr, size);
        Introduction.printArray(arr, size);
        var arr2 = [8, 5, 6, 1, 9, 3, 2, 7, 4, 10];
        size = arr2.length;
        Introduction.Sort1toN(arr2, size);
        Introduction.printArray(arr2, size);
    };
    Introduction.SmallestPositiveMissingNumber = function (arr, size) {
        var found;
        for (var i = 1; i < size + 1; i++) {
            {
                found = 0;
                for (var j = 0; j < size; j++) {
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
        return -1;
    };
    Introduction.SmallestPositiveMissingNumber2 = function (arr, size) {
        var hs = ({});
        for (var i = 0; i < size; i++) {
            {
                /* put */ (function (m, k, v) { if (m.entries == null)
                    m.entries = []; for (var i_1 = 0; i_1 < m.entries.length; i_1++)
                    if (m.entries[i_1].key.equals != null && m.entries[i_1].key.equals(k) || m.entries[i_1].key === k) {
                        m.entries[i_1].value = v;
                        return;
                    } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(hs, arr[i], 1);
            }
            ;
        }
        for (var i = 1; i < size + 1; i++) {
            {
                if ( /* containsKey */(function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i_2 = 0; i_2 < m.entries.length; i_2++)
                    if (m.entries[i_2].key.equals != null && m.entries[i_2].key.equals(k) || m.entries[i_2].key === k) {
                        return true;
                    } return false; })(hs, i) === false) {
                    return i;
                }
            }
            ;
        }
        return -1;
    };
    Introduction.SmallestPositiveMissingNumber3 = function (arr, size) {
        var aux = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        /* fill */ (function (a, v) { for (var i = 0; i < a.length; i++)
            a[i] = v; })(aux, -1);
        for (var i = 0; i < size; i++) {
            {
                if (arr[i] > 0 && arr[i] <= size) {
                    aux[arr[i] - 1] = arr[i];
                }
            }
            ;
        }
        for (var i = 0; i < size; i++) {
            {
                if (aux[i] !== i + 1) {
                    return i + 1;
                }
            }
            ;
        }
        return -1;
    };
    Introduction.SmallestPositiveMissingNumber4 = function (arr, size) {
        var temp;
        for (var i = 0; i < size; i++) {
            {
                while ((arr[i] !== i + 1 && arr[i] > 0 && arr[i] <= size)) {
                    {
                        temp = arr[i];
                        arr[i] = arr[temp - 1];
                        arr[temp - 1] = temp;
                    }
                }
                ;
            }
            ;
        }
        for (var i = 0; i < size; i++) {
            {
                if (arr[i] !== i + 1) {
                    return i + 1;
                }
            }
            ;
        }
        return -1;
    };
    Introduction.main9 = function (args) {
        var arr = [8, 5, 6, 1, 9, 11, 2, 7, 4, 10];
        var size = arr.length;
        console.info("Max sub array sum :" + Introduction.SmallestPositiveMissingNumber(arr, size));
        console.info("Max sub array sum :" + Introduction.SmallestPositiveMissingNumber2(arr, size));
        console.info("Max sub array sum :" + Introduction.SmallestPositiveMissingNumber3(arr, size));
        console.info("Max sub array sum :" + Introduction.SmallestPositiveMissingNumber4(arr, size));
    };
    Introduction.MaxMinArr = function (arr, size) {
        var aux = arr.slice(0, size);
        var start = 0;
        var stop = size - 1;
        for (var i = 0; i < size; i++) {
            {
                if (i % 2 === 0) {
                    arr[i] = aux[stop];
                    stop -= 1;
                }
                else {
                    arr[i] = aux[start];
                    start += 1;
                }
            }
            ;
        }
    };
    Introduction.ReverseArr = function (arr, start, stop) {
        while ((start < stop)) {
            {
                Introduction.swap(arr, start, stop);
                start += 1;
                stop -= 1;
            }
        }
        ;
    };
    Introduction.MaxMinArr2 = function (arr, size) {
        for (var i = 0; i < (size - 1); i++) {
            {
                Introduction.ReverseArr(arr, i, size - 1);
            }
            ;
        }
    };
    Introduction.main10 = function (args) {
        var arr = [1, 2, 3, 4, 5, 6, 7];
        var size = arr.length;
        Introduction.MaxMinArr(arr, size);
        Introduction.printArray(arr, size);
        var arr2 = [1, 2, 3, 4, 5, 6, 7];
        var size2 = arr.length;
        Introduction.MaxMinArr2(arr2, size2);
        Introduction.printArray(arr2, size2);
    };
    Introduction.maxCircularSum = function (arr, size) {
        var sumAll = 0;
        var currVal = 0;
        var maxVal;
        for (var i = 0; i < size; i++) {
            {
                sumAll += arr[i];
                currVal += (i * arr[i]);
            }
            ;
        }
        maxVal = currVal;
        for (var i = 1; i < size; i++) {
            {
                currVal = (currVal + sumAll) - (size * arr[size - i]);
                if (currVal > maxVal) {
                    maxVal = currVal;
                }
            }
            ;
        }
        return maxVal;
    };
    Introduction.main11 = function (args) {
        var arr = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1];
        console.info("MaxCirculrSm: " + Introduction.maxCircularSum(arr, arr.length));
    };
    Introduction.ArrayIndexMaxDiff = function (arr, size) {
        var maxDiff = -1;
        var j;
        for (var i = 0; i < size; i++) {
            {
                j = size - 1;
                while ((j > i)) {
                    {
                        if (arr[j] > arr[i]) {
                            maxDiff = Math.max(maxDiff, j - i);
                            break;
                        }
                        j -= 1;
                    }
                }
                ;
            }
            ;
        }
        return maxDiff;
    };
    Introduction.ArrayIndexMaxDiff2 = function (arr, size) {
        var leftMin = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        var rightMax = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        leftMin[0] = arr[0];
        var i;
        var j;
        var maxDiff;
        for (i = 1; i < size; i++) {
            {
                if (leftMin[i - 1] < arr[i]) {
                    leftMin[i] = leftMin[i - 1];
                }
                else {
                    leftMin[i] = arr[i];
                }
            }
            ;
        }
        rightMax[size - 1] = arr[size - 1];
        for (i = size - 2; i >= 0; i--) {
            {
                if (rightMax[i + 1] > arr[i]) {
                    rightMax[i] = rightMax[i + 1];
                }
                else {
                    rightMax[i] = arr[i];
                }
            }
            ;
        }
        i = 0;
        j = 0;
        maxDiff = -1;
        while ((j < size && i < size)) {
            {
                if (leftMin[i] < rightMax[j]) {
                    maxDiff = Math.max(maxDiff, j - i);
                    j = j + 1;
                }
                else {
                    i = i + 1;
                }
            }
        }
        ;
        return maxDiff;
    };
    Introduction.main = function (args) {
        var arr = [33, 9, 10, 3, 2, 60, 30, 33, 1];
        console.info("ArrayIndexMaxDiff : " + Introduction.ArrayIndexMaxDiff(arr, arr.length));
        console.info("ArrayIndexMaxDiff : " + Introduction.ArrayIndexMaxDiff2(arr, arr.length));
    };
    Introduction.maxPathSum = function (arr1, size1, arr2, size2) {
        var i = 0;
        var j = 0;
        var result = 0;
        var sum1 = 0;
        var sum2 = 0;
        while ((i < size1 && j < size2)) {
            {
                if (arr1[i] < arr2[j]) {
                    sum1 += arr1[i];
                    i += 1;
                }
                else if (arr1[i] > arr2[j]) {
                    sum2 += arr2[j];
                    j += 1;
                }
                else {
                    result += Math.max(sum1, sum2);
                    result = result + arr1[i];
                    sum1 = 0;
                    sum2 = 0;
                    i += 1;
                    j += 1;
                }
            }
        }
        ;
        while ((i < size1)) {
            {
                sum1 += arr1[i];
                i += 1;
            }
        }
        ;
        while ((j < size2)) {
            {
                sum2 += arr2[j];
                j += 1;
            }
        }
        ;
        result += Math.max(sum1, sum2);
        return result;
    };
    Introduction.main13 = function (args) {
        var arr1 = [12, 13, 18, 20, 22, 26, 70];
        var arr2 = [11, 15, 18, 19, 20, 26, 30, 31];
        console.info("Max Path Sum :: " + Introduction.maxPathSum(arr1, arr1.length, arr2, arr2.length));
    };
    Introduction.prototype.factorial = function (i) {
        if (i <= 1) {
            return 1;
        }
        return i * this.factorial(i - 1);
    };
    Introduction.prototype.printInt1 = function (number) {
        var digit = String.fromCharCode((number % 10 + '0'.charCodeAt(0)));
        number = (number / 10 | 0);
        if (number !== 0) {
            this.printInt1(number);
        }
        console.info("%c" + digit);
    };
    Introduction.prototype.printInt = function (number) {
        var conversion = "0123456789ABCDEF";
        var base = 16;
        var digit = String.fromCharCode((number % base));
        number = (number / base | 0);
        if (number !== 0) {
            this.printInt(number);
        }
        console.info(conversion.charAt((digit).charCodeAt(0)));
    };
    Introduction.towerOfHanoi = function (num, src, dst, temp) {
        if (num < 1) {
            return;
        }
        Introduction.towerOfHanoi(num - 1, src, temp, dst);
        console.info("Move " + num + " disk  from peg " + src + " to peg " + dst);
        Introduction.towerOfHanoi(num - 1, temp, dst, src);
    };
    Introduction.main14 = function (args) {
        var num = 4;
        console.info("The sequence of moves involved in the Tower of Hanoi are :\n");
        Introduction.towerOfHanoi(num, 'A', 'C', 'B');
    };
    Introduction.GCD = function (m, n) {
        if (m < n) {
            return (Introduction.GCD(n, m));
        }
        if (m % n === 0) {
            return (n);
        }
        return (Introduction.GCD(n, m % n));
    };
    Introduction.fibonacci = function (n) {
        if (n <= 1) {
            return n;
        }
        return Introduction.fibonacci(n - 1) + Introduction.fibonacci(n - 2);
    };
    Introduction.permutation = function (arr, i, length) {
        if (length === i) {
            Introduction.printArray(arr, length);
            return;
        }
        var j = i;
        for (j = i; j < length; j++) {
            {
                Introduction.swap(arr, i, j);
                Introduction.permutation(arr, i + 1, length);
                Introduction.swap(arr, i, j);
            }
            ;
        }
        return;
    };
    Introduction.main15 = function (args) {
        var arr = [0, 0, 0, 0, 0];
        for (var i = 0; i < 5; i++) {
            {
                arr[i] = i;
            }
            ;
        }
        Introduction.permutation(arr, 0, 5);
    };
    Introduction.BinarySearchRecursive = function (arr, low, high, value) {
        if (low > high)
            return -1;
        var mid = ((low + high) / 2 | 0);
        if (arr[mid] === value) {
            return mid;
        }
        else if (arr[mid] < value) {
            return Introduction.BinarySearchRecursive(arr, mid + 1, high, value);
        }
        else {
            return Introduction.BinarySearchRecursive(arr, low, mid - 1, value);
        }
    };
    Introduction.main16 = function (args) {
        var arr = [1, 2, 3, 4, 5, 6, 7, 8, 9];
        console.info(Introduction.BinarySearchRecursive(arr, 0, arr.length - 1, 6));
        console.info(Introduction.BinarySearchRecursive(arr, 0, arr.length - 1, 16));
    };
    return Introduction;
}());
Introduction["__class"] = "Introduction";
Introduction.main(null);
