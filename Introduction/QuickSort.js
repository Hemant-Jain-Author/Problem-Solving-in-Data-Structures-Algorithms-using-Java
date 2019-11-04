var QuickSort = /** @class */ (function () {
    function QuickSort(array) {
        if (this.arr === undefined)
            this.arr = null;
        this.arr = array;
    }
    /*private*/ QuickSort.prototype.swap = function (arr, first, second) {
        var temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    };
    /*private*/ QuickSort.prototype.quickSortUtil = function (arr, lower, upper) {
        if (upper <= lower)
            return;
        var pivot = arr[lower];
        var start = lower;
        var stop = upper;
        while ((lower < upper)) {
            {
                while ((arr[lower] <= pivot && lower < upper)) {
                    {
                        lower++;
                    }
                }
                ;
                while ((arr[upper] > pivot && lower <= upper)) {
                    {
                        upper--;
                    }
                }
                ;
                if (lower < upper) {
                    this.swap(arr, upper, lower);
                }
            }
        }
        ;
        this.swap(arr, upper, start);
        this.quickSortUtil(arr, start, upper - 1);
        this.quickSortUtil(arr, upper + 1, stop);
    };
    QuickSort.prototype.sort = function () {
        var size = this.arr.length;
        this.quickSortUtil(this.arr, 0, size - 1);
    };
    QuickSort.main = function (args) {
        var array = [3, 4, 2, 1, 6, 5, 7, 8, 1, 1];
        var m = new QuickSort(array);
        m.sort();
        for (var i = 0; i < array.length; i++) {
            {
                console.info(array[i] + " ");
            }
            ;
        }
    };
    return QuickSort;
}());
QuickSort["__class"] = "QuickSort";
QuickSort.main(null);
