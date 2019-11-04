/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var SelectionSort = /** @class */ (function () {
    function SelectionSort() {
    }
    /*private*/ SelectionSort.prototype.more = function (value1, value2) {
        return value1 > value2;
    };
    SelectionSort.sort = function (arr) {
        var size = arr.length;
        var i;
        var j;
        var max;
        var temp;
        for (i = 0; i < size - 1; i++) {
            {
                max = 0;
                for (j = 1; j < size - i; j++) {
                    {
                        if (arr[j] > arr[max]) {
                            max = j;
                        }
                    }
                    ;
                }
                temp = arr[size - 1 - i];
                arr[size - 1 - i] = arr[max];
                arr[max] = temp;
            }
            ;
        }
    };
    SelectionSort.sort2 = function (arr) {
        var size = arr.length;
        var i;
        var j;
        var min;
        var temp;
        for (i = 0; i < size - 1; i++) {
            {
                min = i;
                for (j = i + 1; j < size; j++) {
                    {
                        if (arr[j] < arr[min]) {
                            min = j;
                        }
                    }
                    ;
                }
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            ;
        }
    };
    SelectionSort.main = function (args) {
        var array = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        SelectionSort.sort(array);
        for (var i = 0; i < array.length; i++) {
            {
                console.info(array[i] + " ");
            }
            ;
        }
        console.info();
        var array2 = [9, 1, 8, 2, 7, 3, 6, 4, 5];
        SelectionSort.sort2(array2);
        for (var i = 0; i < array2.length; i++) {
            {
                console.info(array2[i] + " ");
            }
            ;
        }
    };
    return SelectionSort;
}());
SelectionSort["__class"] = "SelectionSort";
SelectionSort.main(null);
