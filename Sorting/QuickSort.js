/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var QuickSort = /** @class */ (function () {
    function QuickSort() {
    }
    /*private*/ QuickSort.quickSort = function (arr, lower, upper) {
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
                    QuickSort.swap(arr, upper, lower);
                }
            }
        }
        ;
        QuickSort.swap(arr, upper, start);
        QuickSort.quickSort(arr, start, upper - 1);
        QuickSort.quickSort(arr, upper + 1, stop);
    };
    QuickSort.sort = function (arr) {
        var size = arr.length;
        QuickSort.quickSort(arr, 0, size - 1);
    };
    /*private*/ QuickSort.swap = function (arr, first, second) {
        var temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    };
    QuickSort.main = function (args) {
        var array = [3, 4, 2, 1, 6, 5, 7, 8, 1, 1];
        QuickSort.sort(array);
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
