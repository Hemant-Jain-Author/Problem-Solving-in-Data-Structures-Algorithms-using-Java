/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var SortingEx = /** @class */ (function () {
    function SortingEx() {
    }
    SortingEx.printArray = function (arr, count) {
        console.info("[");
        for (var i = 0; i < count; i++) {
            {
                console.info(" " + arr[i]);
            }
            ;
        }
        console.info(" ]\n");
    };
    SortingEx.swap = function (arr, x, y) {
        var temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return;
    };
    SortingEx.Partition01 = function (arr, size) {
        var left = 0;
        var right = size - 1;
        var count = 0;
        while ((left < right)) {
            {
                while ((arr[left] === 0)) {
                    left += 1;
                }
                ;
                while ((arr[right] === 1)) {
                    right -= 1;
                }
                ;
                if (left < right) {
                    SortingEx.swap(arr, left, right);
                    count += 1;
                }
            }
        }
        ;
        return count;
    };
    SortingEx.Partition012 = function (arr, size) {
        var left = 0;
        var right = size - 1;
        var i = 0;
        while ((i <= right)) {
            {
                if (arr[i] === 0) {
                    SortingEx.swap(arr, i, left);
                    i += 1;
                    left += 1;
                }
                else if (arr[i] === 2) {
                    SortingEx.swap(arr, i, right);
                    right -= 1;
                }
                else {
                    i += 1;
                }
            }
        }
        ;
    };
    SortingEx.main1 = function (args) {
        var arr = [0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1];
        SortingEx.Partition01(arr, arr.length);
        SortingEx.printArray(arr, arr.length);
        var arr2 = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1];
        SortingEx.Partition012(arr2, arr2.length);
        SortingEx.printArray(arr2, arr2.length);
    };
    SortingEx.RangePartition = function (arr, size, lower, higher) {
        var start = 0;
        var end = size - 1;
        var i = 0;
        while ((i <= end)) {
            {
                if (arr[i] < lower) {
                    SortingEx.swap(arr, i, start);
                    i += 1;
                    start += 1;
                }
                else if (arr[i] > higher) {
                    SortingEx.swap(arr, i, end);
                    end -= 1;
                }
                else {
                    i += 1;
                }
            }
        }
        ;
    };
    SortingEx.main3 = function (args) {
        var arr = [1, 21, 2, 20, 3, 19, 4, 18, 5, 17, 6, 16, 7, 15, 8, 14, 9, 13, 10, 12, 11];
        SortingEx.RangePartition(arr, arr.length, 9, 12);
        SortingEx.printArray(arr, arr.length);
    };
    SortingEx.prototype.minSwaps = function (arr, size, val) {
        var swapCount = 0;
        var first = 0;
        var second = size - 1;
        var temp;
        while ((first < second)) {
            {
                if (arr[first] <= val)
                    first += 1;
                else if (arr[second] > val)
                    second -= 1;
                else {
                    temp = arr[first];
                    arr[first] = arr[second];
                    arr[second] = temp;
                    swapCount += 1;
                }
            }
        }
        ;
        return swapCount;
    };
    SortingEx.seperateEvenAndOdd = function (data, size) {
        var left = 0;
        var right = size - 1;
        while ((left < right)) {
            {
                if (data[left] % 2 === 0)
                    left++;
                else if (data[right] % 2 === 1)
                    right--;
                else {
                    SortingEx.swap(data, left, right);
                    left++;
                    right--;
                }
            }
        }
        ;
    };
    SortingEx.AbsMore = function (value1, value2, ref) {
        return (Math.abs(value1 - ref) > Math.abs(value2 - ref));
    };
    SortingEx.AbsBubbleSort = function (arr, size, ref) {
        for (var i = 0; i < (size - 1); i++) {
            {
                for (var j = 0; j < (size - i - 1); j++) {
                    {
                        if (SortingEx.AbsMore(arr[j], arr[j + 1], ref)) {
                            SortingEx.swap(arr, j, j + 1);
                        }
                    }
                    ;
                }
            }
            ;
        }
    };
    SortingEx.main4 = function (args) {
        var array = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        var ref = 5;
        SortingEx.AbsBubbleSort(array, array.length, ref);
        SortingEx.printArray(array, array.length);
    };
    SortingEx.EqMore = function (value1, value2, A) {
        value1 = A * value1 * value1;
        value2 = A * value2 * value2;
        return value1 > value2;
    };
    SortingEx.ArrayReduction = function (arr, size) {
        /* sort */ (function (l) { l.sort(); })(arr);
        var count = 1;
        var reduction = arr[0];
        for (var i = 0; i < size; i++) {
            {
                if (arr[i] - reduction > 0) {
                    console.info(size - i);
                    reduction = arr[i];
                    count += 1;
                }
            }
            ;
        }
        console.info("Total number of reductions " + count);
    };
    SortingEx.main88 = function (args) {
        var arr = [5, 1, 1, 1, 2, 3, 5];
        SortingEx.ArrayReduction(arr, arr.length);
    };
    SortingEx.SortByOrder = function (arr, size, arr2, size2) {
        var ht = ({});
        var value;
        for (var i = 0; i < size; i++) {
            {
                if ( /* containsKey */(function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i_1 = 0; i_1 < m.entries.length; i_1++)
                    if (m.entries[i_1].key.equals != null && m.entries[i_1].key.equals(k) || m.entries[i_1].key === k) {
                        return true;
                    } return false; })(ht, arr[i])) {
                    value = /* get */ (function (m, k) { if (m.entries == null)
                        m.entries = []; for (var i_2 = 0; i_2 < m.entries.length; i_2++)
                        if (m.entries[i_2].key.equals != null && m.entries[i_2].key.equals(k) || m.entries[i_2].key === k) {
                            return m.entries[i_2].value;
                        } return null; })(ht, arr[i]);
                    /* put */ (function (m, k, v) { if (m.entries == null)
                        m.entries = []; for (var i_3 = 0; i_3 < m.entries.length; i_3++)
                        if (m.entries[i_3].key.equals != null && m.entries[i_3].key.equals(k) || m.entries[i_3].key === k) {
                            m.entries[i_3].value = v;
                            return;
                        } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(ht, arr[i], value + 1);
                }
                else {
                    /* put */ (function (m, k, v) { if (m.entries == null)
                        m.entries = []; for (var i_4 = 0; i_4 < m.entries.length; i_4++)
                        if (m.entries[i_4].key.equals != null && m.entries[i_4].key.equals(k) || m.entries[i_4].key === k) {
                            m.entries[i_4].value = v;
                            return;
                        } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(ht, arr[i], 1);
                }
            }
            ;
        }
        for (var j = 0; j < size2; j++) {
            {
                if ( /* containsKey */(function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i = 0; i < m.entries.length; i++)
                    if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                        return true;
                    } return false; })(ht, arr2[j])) {
                    value = /* get */ (function (m, k) { if (m.entries == null)
                        m.entries = []; for (var i = 0; i < m.entries.length; i++)
                        if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                            return m.entries[i].value;
                        } return null; })(ht, arr2[j]);
                    for (var k = 0; k < value; k++) {
                        {
                            console.info(arr2[j]);
                        }
                        ;
                    }
                    /* remove */ (function (m, k) { if (m.entries == null)
                        m.entries = []; for (var i = 0; i < m.entries.length; i++)
                        if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                            return m.entries.splice(i, 1)[0];
                        } })(ht, arr2[j]);
                }
            }
            ;
        }
        for (var i = 0; i < size; i++) {
            {
                if ( /* containsKey */(function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i_5 = 0; i_5 < m.entries.length; i_5++)
                    if (m.entries[i_5].key.equals != null && m.entries[i_5].key.equals(k) || m.entries[i_5].key === k) {
                        return true;
                    } return false; })(ht, arr[i])) {
                    value = /* get */ (function (m, k) { if (m.entries == null)
                        m.entries = []; for (var i_6 = 0; i_6 < m.entries.length; i_6++)
                        if (m.entries[i_6].key.equals != null && m.entries[i_6].key.equals(k) || m.entries[i_6].key === k) {
                            return m.entries[i_6].value;
                        } return null; })(ht, arr[i]);
                    for (var k = 0; k < value; k++) {
                        {
                            console.info(arr[i]);
                        }
                        ;
                    }
                    /* remove */ (function (m, k) { if (m.entries == null)
                        m.entries = []; for (var i_7 = 0; i_7 < m.entries.length; i_7++)
                        if (m.entries[i_7].key.equals != null && m.entries[i_7].key.equals(k) || m.entries[i_7].key === k) {
                            return m.entries.splice(i_7, 1)[0];
                        } })(ht, arr[i]);
                }
            }
            ;
        }
    };
    SortingEx.main7 = function (args) {
        var arr = [2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8];
        var arr2 = [2, 1, 8, 3];
        SortingEx.SortByOrder(arr, arr.length, arr2, arr2.length);
    };
    SortingEx.merge = function (arr1, size1, arr2, size2) {
        var index = 0;
        while ((index < size1)) {
            {
                if (arr1[index] <= arr2[0]) {
                    index += 1;
                }
                else {
                    arr1[index] ^= arr2[0] ^= arr1[index] ^= arr2[0];
                    index += 1;
                    for (var i = 0; i < (size2 - 1); i++) {
                        {
                            if (arr2[i] < arr2[i + 1])
                                break;
                            arr2[i] ^= arr2[i + 1] ^= arr2[i] ^= arr2[i + 1];
                        }
                        ;
                    }
                }
            }
        }
        ;
    };
    SortingEx.main9 = function (args) {
        var arr1 = [1, 5, 9, 10, 15, 20];
        var arr2 = [2, 3, 8, 13];
        SortingEx.merge(arr1, arr1.length, arr2, arr2.length);
        SortingEx.printArray(arr1, arr1.length);
        SortingEx.printArray(arr2, arr2.length);
    };
    SortingEx.checkReverse = function (arr, size) {
        var start = -1;
        var stop = -1;
        for (var i = 0; i < (size - 1); i++) {
            {
                if (arr[i] > arr[i + 1]) {
                    start = i;
                    break;
                }
            }
            ;
        }
        if (start === -1)
            return true;
        for (var i = start; i < (size - 1); i++) {
            {
                if (arr[i] < arr[i + 1]) {
                    stop = i;
                    break;
                }
            }
            ;
        }
        if (stop === -1)
            return true;
        if (arr[start - 1] > arr[stop] || arr[stop + 1] < arr[start])
            return false;
        for (var i = stop + 1; i < size - 1; i++) {
            {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            ;
        }
        return true;
    };
    SortingEx.min = function (X, Y) {
        if (X < Y) {
            return X;
        }
        return Y;
    };
    SortingEx.UnionIntersectionSorted = function (arr1, size1, arr2, size2) {
        var first = 0;
        var second = 0;
        var unionArr = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size1 + size2);
        var interArr = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(SortingEx.min(size1, size2));
        var uIndex = 0;
        var iIndex = 0;
        while ((first < size1 && second < size2)) {
            {
                if (arr1[first] === arr2[second]) {
                    unionArr[uIndex++] = arr1[first];
                    interArr[iIndex++] = arr1[first];
                    first += 1;
                    second += 1;
                }
                else if (arr1[first] < arr2[second]) {
                    unionArr[uIndex++] = arr1[first];
                    first += 1;
                }
                else {
                    unionArr[uIndex++] = arr2[second];
                    second += 1;
                }
            }
        }
        ;
        while ((first < size1)) {
            {
                unionArr[uIndex++] = arr1[first];
                first += 1;
            }
        }
        ;
        while ((second < size2)) {
            {
                unionArr[uIndex++] = arr2[second];
                second += 1;
            }
        }
        ;
        SortingEx.printArray(unionArr, uIndex);
        SortingEx.printArray(interArr, iIndex);
    };
    SortingEx.UnionIntersectionUnsorted = function (arr1, size1, arr2, size2) {
        /* sort */ (function (l) { l.sort(); })(arr1);
        /* sort */ (function (l) { l.sort(); })(arr2);
        SortingEx.UnionIntersectionSorted(arr1, size1, arr2, size2);
    };
    SortingEx.main = function (args) {
        var arr1 = [1, 11, 2, 3, 14, 5, 6, 8, 9];
        var arr2 = [2, 4, 5, 12, 7, 8, 13, 10];
        SortingEx.UnionIntersectionUnsorted(arr1, arr1.length, arr2, arr2.length);
    };
    return SortingEx;
}());
SortingEx["__class"] = "SortingEx";
SortingEx.main(null);
