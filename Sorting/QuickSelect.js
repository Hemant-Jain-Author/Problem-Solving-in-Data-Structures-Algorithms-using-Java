/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var QuickSelect = /** @class */ (function () {
    function QuickSelect() {
    }
    QuickSelect.quickSelect = function (arr, lower, upper, k) {
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
                    QuickSelect.swap(arr, upper, lower);
                }
            }
        }
        ;
        QuickSelect.swap(arr, upper, start);
        if (k < upper)
            QuickSelect.quickSelect(arr, start, upper - 1, k);
        if (k > upper)
            QuickSelect.quickSelect(arr, upper + 1, stop, k);
    };
    QuickSelect.swap = function (arr, first, second) {
        var temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    };
    QuickSelect.get = function (arr, k) {
        QuickSelect.quickSelect(arr, 0, arr.length - 1, k);
        return arr[4];
    };
    QuickSelect.main = function (args) {
        var array = [3, 4, 2, 1, 6, 5, 7, 8, 10, 9];
        console.info("value at index 5 is : " + QuickSelect.get(array, 5));
    };
    return QuickSelect;
}());
QuickSelect["__class"] = "QuickSelect";
QuickSelect.main(null);
