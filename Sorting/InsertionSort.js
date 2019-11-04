/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var InsertionSort = /** @class */ (function () {
    function InsertionSort() {
    }
    /*private*/ InsertionSort.more = function (value1, value2) {
        return value1 > value2;
    };
    InsertionSort.sort = function (arr) {
        var size = arr.length;
        var temp;
        var j;
        for (var i = 1; i < size; i++) {
            {
                temp = arr[i];
                for (j = i; j > 0 && InsertionSort.more(arr[j - 1], temp); j--) {
                    {
                        arr[j] = arr[j - 1];
                    }
                    ;
                }
                arr[j] = temp;
            }
            ;
        }
    };
    InsertionSort.main = function (args) {
        var array = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        InsertionSort.sort(array);
        for (var i = 0; i < array.length; i++) {
            {
                console.info(array[i] + " ");
            }
            ;
        }
    };
    return InsertionSort;
}());
InsertionSort["__class"] = "InsertionSort";
InsertionSort.main(null);
