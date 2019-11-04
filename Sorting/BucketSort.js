/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var BucketSort = /** @class */ (function () {
    function BucketSort() {
    }
    BucketSort.sort = function (array, lowerRange, upperRange) {
        var i;
        var j;
        var size = array.length;
        var range = upperRange - lowerRange;
        var count = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(range);
        for (i = 0; i < size; i++) {
            {
                count[array[i] - lowerRange]++;
            }
            ;
        }
        j = 0;
        for (i = 0; i < range; i++) {
            {
                for (; count[i] > 0; (count[i])--) {
                    {
                        array[j++] = i + lowerRange;
                    }
                    ;
                }
            }
            ;
        }
    };
    BucketSort.main = function (args) {
        var array = [23, 24, 22, 21, 26, 25, 27, 28, 21, 21];
        BucketSort.sort(array, 20, 30);
        for (var i = 0; i < array.length; i++) {
            {
                console.info(array[i] + " ");
            }
            ;
        }
    };
    return BucketSort;
}());
BucketSort["__class"] = "BucketSort";
BucketSort.main(null);
