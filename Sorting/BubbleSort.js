/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var BubbleSort = /** @class */ (function () {
    function BubbleSort() {
    }
    /*private*/ BubbleSort.less = function (value1, value2) {
        return value1 < value2;
    };
    /*private*/ BubbleSort.more = function (value1, value2) {
        return value1 > value2;
    };
    BubbleSort.sort = function (arr) {
        var size = arr.length;
        var i;
        var j;
        var temp;
        for (i = 0; i < (size - 1); i++) {
            {
                for (j = 0; j < size - i - 1; j++) {
                    {
                        if (BubbleSort.more(arr[j], arr[j + 1])) {
                            temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    }
                    ;
                }
            }
            ;
        }
    };
    BubbleSort.sort2 = function (arr) {
        var size = arr.length;
        var i;
        var j;
        var temp;
        var swapped = 1;
        for (i = 0; i < (size - 1) && swapped === 1; i++) {
            {
                swapped = 0;
                for (j = 0; j < size - i - 1; j++) {
                    {
                        if (BubbleSort.more(arr[j], arr[j + 1])) {
                            temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                            swapped = 1;
                        }
                    }
                    ;
                }
            }
            ;
        }
    };
    BubbleSort.main = function (args) {
        var array = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        BubbleSort.sort(array);
        for (var i = 0; i < array.length; i++) {
            {
                console.info(array[i] + " ");
            }
            ;
        }
        console.info();
        var array2 = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        BubbleSort.sort2(array2);
        for (var i = 0; i < array2.length; i++) {
            {
                console.info(array2[i] + " ");
            }
            ;
        }
    };
    return BubbleSort;
}());
BubbleSort["__class"] = "BubbleSort";
BubbleSort.main(null);
