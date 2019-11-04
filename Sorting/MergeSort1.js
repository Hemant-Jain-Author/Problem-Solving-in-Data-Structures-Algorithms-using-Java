/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var MergeSort1 = /** @class */ (function () {
    function MergeSort1() {
    }
    /*private*/ MergeSort1.mergeSrt = function (arr, tempArray, lowerIndex, upperIndex) {
        if (lowerIndex >= upperIndex) {
            return;
        }
        var middleIndex = ((lowerIndex + upperIndex) / 2 | 0);
        MergeSort1.mergeSrt(arr, tempArray, lowerIndex, middleIndex);
        MergeSort1.mergeSrt(arr, tempArray, middleIndex + 1, upperIndex);
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
    MergeSort1.sort = function (arr) {
        var size = arr.length;
        var tempArray = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        MergeSort1.mergeSrt(arr, tempArray, 0, size - 1);
    };
    MergeSort1.main = function (args) {
        var array = [3, 4, 2, 1, 6, 5, 7, 8, 1, 1];
        MergeSort1.sort(array);
        for (var i = 0; i < array.length; i++) {
            {
                console.info(array[i] + " ");
            }
            ;
        }
    };
    return MergeSort1;
}());
MergeSort1["__class"] = "MergeSort1";
MergeSort1.main(null);
