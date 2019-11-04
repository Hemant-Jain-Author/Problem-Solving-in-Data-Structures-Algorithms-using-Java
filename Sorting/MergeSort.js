/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var MergeSort = /** @class */ (function () {
    function MergeSort(array) {
        if (this.arr === undefined)
            this.arr = null;
        this.arr = array;
    }
    /*private*/ MergeSort.prototype.merge = function (arr, tempArray, lowerIndex, middleIndex, upperIndex) {
        var lowerStart = lowerIndex;
        var lowerStop = middleIndex;
        var upperStart = middleIndex + 1;
        var upperStop = upperIndex;
        var count = lowerIndex;
        while ((lowerStart <= lowerStop && upperStart <= upperStop)) {
            {
                if (arr[lowerStart] < arr[upperStart]) {
                    tempArray[count++] = arr[lowerStart++];
                }
                else {
                    tempArray[count++] = arr[upperStart++];
                }
            }
        }
        ;
        while ((lowerStart <= lowerStop)) {
            {
                tempArray[count++] = arr[lowerStart++];
            }
        }
        ;
        while ((upperStart <= upperStop)) {
            {
                tempArray[count++] = arr[upperStart++];
            }
        }
        ;
        for (var i = lowerIndex; i <= upperIndex; i++) {
            {
                arr[i] = tempArray[i];
            }
            ;
        }
    };
    /*private*/ MergeSort.prototype.mergeSrt = function (arr, tempArray, lowerIndex, upperIndex) {
        if (lowerIndex >= upperIndex) {
            return;
        }
        var middleIndex = ((lowerIndex + upperIndex) / 2 | 0);
        this.mergeSrt(arr, tempArray, lowerIndex, middleIndex);
        this.mergeSrt(arr, tempArray, middleIndex + 1, upperIndex);
        this.merge(arr, tempArray, lowerIndex, middleIndex, upperIndex);
    };
    MergeSort.prototype.sort = function () {
        var size = this.arr.length;
        var tempArray = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        this.mergeSrt(this.arr, tempArray, 0, size - 1);
    };
    MergeSort.main = function (args) {
        var array = [3, 4, 2, 1, 6, 5, 7, 8, 1, 1];
        var m = new MergeSort(array);
        m.sort();
        for (var i = 0; i < array.length; i++) {
            {
                console.info(array[i] + " ");
            }
            ;
        }
    };
    return MergeSort;
}());
MergeSort["__class"] = "MergeSort";
MergeSort.main(null);
