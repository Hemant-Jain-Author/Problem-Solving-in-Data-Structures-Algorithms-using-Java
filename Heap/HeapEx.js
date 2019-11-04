var HeapEx = /** @class */ (function () {
    function HeapEx() {
    }
    HeapEx.demo = function (args) {
        var pq = (new java.util.PriorityQueue());
        var arr = [1, 2, 10, 8, 7, 3, 4, 6, 5, 9];
        for (var index8207 = 0; index8207 < arr.length; index8207++) {
            var i = arr[index8207];
            {
                pq.add(i);
            }
        }
        console.info("Printing Priority Queue Heap : " + pq);
        console.info("Dequeue elements of Priority Queue ::");
        while ((pq.isEmpty() === false)) {
            {
                console.info(" " + pq.remove());
            }
        }
        ;
    };
    HeapEx.KthSmallest = function (arr, size, k) {
        /* sort */ (function (l) { l.sort(); })(arr);
        return arr[k - 1];
    };
    HeapEx.KthSmallest2 = function (arr, size, k) {
        var i = 0;
        var value = 0;
        var pq = (new java.util.PriorityQueue());
        for (i = 0; i < size; i++) {
            {
                pq.add(arr[i]);
            }
            ;
        }
        while ((i < size && i < k)) {
            {
                value = pq.remove();
                i += 1;
            }
        }
        ;
        return value;
    };
    HeapEx.isMinHeap = function (arr, size) {
        var lchild;
        var rchild;
        for (var parent_1 = 0; parent_1 < ((size / 2 | 0) + 1); parent_1++) {
            {
                lchild = parent_1 * 2 + 1;
                rchild = parent_1 * 2 + 2;
                if (((lchild < size) && (arr[parent_1] > arr[lchild])) || ((rchild < size) && (arr[parent_1] > arr[rchild])))
                    return false;
            }
            ;
        }
        return true;
    };
    HeapEx.isMaxHeap = function (arr, size) {
        var lchild;
        var rchild;
        for (var parent_2 = 0; parent_2 < ((size / 2 | 0) + 1); parent_2++) {
            {
                lchild = parent_2 * 2 + 1;
                rchild = lchild + 1;
                if (((lchild < size) && (arr[parent_2] < arr[lchild])) || ((rchild < size) && (arr[parent_2] < arr[rchild])))
                    return false;
            }
            ;
        }
        return true;
    };
    HeapEx.main2 = function (args) {
        var arr = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("Kth Smallest :: " + HeapEx.KthSmallest(arr, arr.length, 3));
        var arr2 = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("Kth Smallest :: " + HeapEx.KthSmallest2(arr2, arr2.length, 3));
        var arr3 = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("isMaxHeap :: " + HeapEx.isMaxHeap(arr3, arr3.length));
        var arr4 = [8, 7, 6, 5, 7, 5, 2, 1];
        /* sort */ (function (l) { l.sort(); })(arr4);
        console.info("isMinHeap :: " + HeapEx.isMinHeap(arr4, arr4.length));
    };
    HeapEx.KSmallestProduct = function (arr, size, k) {
        /* sort */ (function (l) { l.sort(); })(arr);
        var product = 1;
        for (var i = 0; i < k; i++) {
            product *= arr[i];
        }
        return product;
    };
    HeapEx.swap = function (arr, i, j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    };
    HeapEx.QuickSelectUtil = function (arr, lower, upper, k) {
        if (upper <= lower)
            return;
        var pivot = arr[lower];
        var start = lower;
        var stop = upper;
        while ((lower < upper)) {
            {
                while ((lower < upper && arr[lower] <= pivot)) {
                    {
                        lower++;
                    }
                }
                ;
                while ((lower <= upper && arr[upper] > pivot)) {
                    {
                        upper--;
                    }
                }
                ;
                if (lower < upper) {
                    HeapEx.swap(arr, upper, lower);
                }
            }
        }
        ;
        HeapEx.swap(arr, upper, start);
        if (k < upper)
            HeapEx.QuickSelectUtil(arr, start, upper - 1, k);
        if (k > upper)
            HeapEx.QuickSelectUtil(arr, upper + 1, stop, k);
    };
    HeapEx.KSmallestProduct3 = function (arr, size, k) {
        HeapEx.QuickSelectUtil(arr, 0, size - 1, k);
        var product = 1;
        for (var i = 0; i < k; i++) {
            product *= arr[i];
        }
        return product;
    };
    HeapEx.KSmallestProduct2 = function (arr, size, k) {
        var pq = (new java.util.PriorityQueue());
        var i = 0;
        var product = 1;
        for (i = 0; i < size; i++) {
            {
                pq.add(arr[i]);
            }
            ;
        }
        while ((i < size && i < k)) {
            {
                product *= pq.remove();
                i += 1;
            }
        }
        ;
        return product;
    };
    HeapEx.main3 = function (args) {
        var arr = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("Kth Smallest product:: " + HeapEx.KSmallestProduct(arr, 8, 3));
        var arr2 = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("Kth Smallest product:: " + HeapEx.KSmallestProduct2(arr2, 8, 3));
        var arr3 = [8, 7, 6, 5, 7, 5, 2, 1];
        console.info("Kth Smallest product:: " + HeapEx.KSmallestProduct3(arr3, 8, 3));
    };
    HeapEx.PrintLargerHalf = function (arr, size) {
        /* sort */ (function (l) { l.sort(); })(arr);
        for (var i = (size / 2 | 0); i < size; i++) {
            console.info(arr[i]);
        }
        console.info();
    };
    HeapEx.PrintLargerHalf2 = function (arr, size) {
        var product = 1;
        var pq = (new java.util.PriorityQueue());
        for (var i = 0; i < size; i++) {
            {
                pq.add(arr[i]);
            }
            ;
        }
        for (var i = 0; i < (size / 2 | 0); i++) {
            pq.remove();
        }
        console.info(pq);
    };
    HeapEx.PrintLargerHalf3 = function (arr, size) {
        HeapEx.QuickSelectUtil(arr, 0, size - 1, (size / 2 | 0));
        for (var i = (size / 2 | 0); i < size; i++) {
            console.info(arr[i]);
        }
        console.info();
    };
    HeapEx.main4 = function (args) {
        var arr = [8, 7, 6, 5, 7, 5, 2, 1];
        HeapEx.PrintLargerHalf(arr, 8);
        var arr2 = [8, 7, 6, 5, 7, 5, 2, 1];
        HeapEx.PrintLargerHalf2(arr2, 8);
        var arr3 = [8, 7, 6, 5, 7, 5, 2, 1];
        HeapEx.PrintLargerHalf3(arr3, 8);
    };
    HeapEx.sortK = function (arr, size, k) {
        var pq = (new java.util.PriorityQueue());
        var i = 0;
        for (i = 0; i < size; i++) {
            {
                pq.add(arr[i]);
            }
            ;
        }
        var output = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        var index = 0;
        for (i = k; i < size; i++) {
            {
                output[index++] = pq.remove();
                pq.add(arr[i]);
            }
            ;
        }
        while ((pq.size() > 0)) {
            output[index++] = pq.remove();
        }
        ;
        for (i = k; i < size; i++) {
            {
                arr[i] = output[i];
            }
            ;
        }
        console.info(output);
    };
    HeapEx.main5 = function (args) {
        var k = 3;
        var arr = [1, 5, 4, 10, 50, 9];
        var size = arr.length;
        HeapEx.sortK(arr, size, k);
    };
    HeapEx.ChotaBhim = function (cups, size) {
        var time = 60;
        /* sort */ (function (l) { l.sort(); })(cups);
        var total = 0;
        var index;
        var temp;
        while ((time > 0)) {
            {
                total += cups[0];
                cups[0] = (Math.ceil(cups[0] / 2.0) | 0);
                index = 0;
                temp = cups[0];
                while ((index < size - 1 && temp < cups[index + 1])) {
                    {
                        cups[index] = cups[index + 1];
                        index += 1;
                    }
                }
                ;
                cups[index] = temp;
                time -= 1;
            }
        }
        ;
        console.info("Total %d " + total);
        return total;
    };
    HeapEx.ChotaBhim2 = function (cups, size) {
        var time = 60;
        /* sort */ (function (l) { l.sort(); })(cups);
        var total = 0;
        var i;
        var temp;
        while ((time > 0)) {
            {
                total += cups[0];
                cups[0] = (Math.ceil(cups[0] / 2.0) | 0);
                i = 0;
                while ((i < size - 1)) {
                    {
                        if (cups[i] > cups[i + 1])
                            break;
                        temp = cups[i];
                        cups[i] = cups[i + 1];
                        cups[i + 1] = temp;
                        i += 1;
                    }
                }
                ;
                time -= 1;
            }
        }
        ;
        console.info("Total : " + total);
        return total;
    };
    HeapEx.ChotaBhim3 = function (cups, size) {
        var time = 60;
        var pq = (new java.util.PriorityQueue());
        var i = 0;
        for (i = 0; i < size; i++) {
            {
                pq.add(cups[i]);
            }
            ;
        }
        var total = 0;
        var value;
        while ((time > 0)) {
            {
                value = pq.remove();
                total += value;
                value = (Math.ceil(value / 2.0) | 0);
                pq.add(value);
                time -= 1;
            }
        }
        ;
        console.info("Total : " + total);
        return total;
    };
    HeapEx.JoinRopes = function (ropes, size) {
        /* sort */ (function (l) { l.sort(); })(ropes);
        console.info(ropes);
        var total = 0;
        var value = 0;
        var temp;
        var index;
        var length = size;
        while ((length >= 2)) {
            {
                value = ropes[length - 1] + ropes[length - 2];
                total += value;
                index = length - 2;
                while ((index > 0 && ropes[index - 1] < value)) {
                    {
                        ropes[index] = ropes[index - 1];
                        index -= 1;
                    }
                }
                ;
                ropes[index] = value;
                length--;
            }
        }
        ;
        console.info("Total : " + total);
        return total;
    };
    HeapEx.JoinRopes2 = function (ropes, size) {
        var pq = (new java.util.PriorityQueue());
        var i = 0;
        for (i = 0; i < size; i++) {
            {
                pq.add(ropes[i]);
            }
            ;
        }
        var total = 0;
        var value = 0;
        while ((pq.size() > 1)) {
            {
                value = pq.remove();
                value += pq.remove();
                pq.add(value);
                total += value;
            }
        }
        ;
        console.info("Total : %d " + total);
        return total;
    };
    HeapEx.main6 = function (args) {
        var cups = [2, 1, 7, 4, 2];
        HeapEx.ChotaBhim(cups, cups.length);
        var cups2 = [2, 1, 7, 4, 2];
        HeapEx.ChotaBhim2(cups2, cups.length);
        var cups3 = [2, 1, 7, 4, 2];
        HeapEx.ChotaBhim3(cups3, cups.length);
        var ropes = [2, 1, 7, 4, 2];
        HeapEx.JoinRopes(ropes, ropes.length);
        var rope2 = [2, 1, 7, 4, 2];
        HeapEx.JoinRopes2(rope2, rope2.length);
    };
    HeapEx.kthLargestStream = function (k) {
        var pq = (new java.util.PriorityQueue());
        var size = 0;
        var data = 0;
        while ((true)) {
            {
                console.info("Enter data: ");
                if (size < k - 1)
                    pq.add(data);
                else {
                    if (size === k - 1)
                        pq.add(data);
                    else if (pq.peek() < data) {
                        pq.add(data);
                        pq.remove();
                    }
                    console.info("Kth larges element is :: " + pq.peek());
                }
                size += 1;
            }
        }
        ;
    };
    HeapEx.main = function (args) {
        HeapEx.kthLargestStream(3);
    };
    return HeapEx;
}());
HeapEx["__class"] = "HeapEx";
HeapEx.main(null);
