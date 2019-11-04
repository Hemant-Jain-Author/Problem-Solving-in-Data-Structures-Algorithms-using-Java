/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var QueueEx = /** @class */ (function () {
    function QueueEx() {
    }
    QueueEx.CircularTour = function (arr, n) {
        var que = ([]);
        var nextPump = 0;
        var prevPump;
        var count = 0;
        var petrol = 0;
        while (( /* size */que.length !== n)) {
            {
                while ((petrol >= 0 && /* size */ que.length !== n)) {
                    {
                        /* add */ (que.push(nextPump) > 0);
                        petrol += (arr[nextPump][0] - arr[nextPump][1]);
                        nextPump = (nextPump + 1) % n;
                    }
                }
                ;
                while ((petrol < 0 && /* size */ que.length > 0)) {
                    {
                        prevPump = /* pop */ que.pop();
                        petrol -= (arr[prevPump][0] - arr[prevPump][1]);
                    }
                }
                ;
                count += 1;
                if (count === n)
                    return -1;
            }
        }
        ;
        if (petrol >= 0)
            return /* pop */ que.pop();
        else
            return -1;
    };
    QueueEx.main1 = function (args) {
        var tour = [[8, 6], [1, 4], [7, 6]];
        console.info(" Circular Tour : " + QueueEx.CircularTour(tour, 3));
    };
    QueueEx.convertXY = function (src, dst) {
        var que = ([]);
        var arr = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(100);
        var steps = 0;
        var index = 0;
        var value;
        /* add */ (que.push(src) > 0);
        while (( /* size */que.length !== 0)) {
            {
                value = /* pop */ que.pop();
                arr[index++] = value;
                if (value === dst) {
                    for (var i = 0; i < index; i++) {
                        console.info(arr[i]);
                    }
                    console.info("Steps countr :: " + steps);
                    return steps;
                }
                steps++;
                if (value < dst) /* add */
                    (que.push(value * 2) > 0);
                else /* add */
                    (que.push(value - 1) > 0);
            }
        }
        ;
        return -1;
    };
    QueueEx.main3 = function (args) {
        QueueEx.convertXY(2, 7);
    };
    QueueEx.maxSlidingWindows = function (arr, size, k) {
        var que = ([]);
        for (var i = 0; i < size; i++) {
            {
                if ( /* size */que.length > 0 && /* peek */ (function (s) { return s[s.length - 1]; })(que) <= i - k) /* pop */
                    que.pop();
                while (( /* size */que.length > 0 && arr[ /* peek */(function (s) { return s[s.length - 1]; })(que)] <= arr[i])) { /* pop */
                    que.pop();
                }
                ;
                /* add */ (que.push(i) > 0);
                if (i >= (k - 1))
                    console.info(arr[ /* peek */(function (s) { return s[s.length - 1]; })(que)]);
            }
            ;
        }
    };
    QueueEx.main4 = function (args) {
        var arr = [11, 2, 75, 92, 59, 90, 55];
        var k = 3;
        QueueEx.maxSlidingWindows(arr, 7, 3);
    };
    QueueEx.minOfMaxSlidingWindows = function (arr, size, k) {
        var que = ([]);
        var minVal = 999999;
        for (var i = 0; i < size; i++) {
            {
                if ( /* size */que.length > 0 && /* peek */ (function (s) { return s[s.length - 1]; })(que) <= i - k) /* pop */
                    que.pop();
                while (( /* size */que.length > 0 && arr[ /* peek */(function (s) { return s[s.length - 1]; })(que)] <= arr[i])) { /* pop */
                    que.pop();
                }
                ;
                /* add */ (que.push(i) > 0);
                if (i >= (k - 1) && minVal > arr[ /* peek */(function (s) { return s[s.length - 1]; })(que)])
                    minVal = arr[ /* peek */(function (s) { return s[s.length - 1]; })(que)];
            }
            ;
        }
        console.info("Min of max is :: " + minVal);
        return minVal;
    };
    QueueEx.main5 = function (args) {
        var arr = [11, 2, 75, 92, 59, 90, 55];
        var k = 3;
        QueueEx.minOfMaxSlidingWindows(arr, 7, 3);
    };
    QueueEx.maxOfMinSlidingWindows = function (arr, size, k) {
        var que = ([]);
        var maxVal = -999999;
        for (var i = 0; i < size; i++) {
            {
                if ( /* size */que.length > 0 && /* peek */ (function (s) { return s[s.length - 1]; })(que) <= i - k) /* pop */
                    que.pop();
                while (( /* size */que.length > 0 && arr[ /* peek */(function (s) { return s[s.length - 1]; })(que)] >= arr[i])) { /* pop */
                    que.pop();
                }
                ;
                /* add */ (que.push(i) > 0);
                if (i >= (k - 1) && maxVal < arr[ /* peek */(function (s) { return s[s.length - 1]; })(que)])
                    maxVal = arr[ /* peek */(function (s) { return s[s.length - 1]; })(que)];
            }
            ;
        }
        console.info("Max of min is :: " + maxVal);
    };
    QueueEx.main6 = function (args) {
        var arr = [11, 2, 75, 92, 59, 90, 55];
        var k = 3;
        QueueEx.maxOfMinSlidingWindows(arr, 7, 3);
    };
    QueueEx.firstNegSlidingWindows = function (arr, size, k) {
        var que = ([]);
        for (var i = 0; i < size; i++) {
            {
                if ( /* size */que.length > 0 && /* peek */ (function (s) { return s[s.length - 1]; })(que) <= i - k) /* pop */
                    que.pop();
                if (arr[i] < 0) /* add */
                    (que.push(i) > 0);
                if (i >= (k - 1)) {
                    if ( /* size */que.length > 0)
                        console.info(arr[ /* peek */(function (s) { return s[s.length - 1]; })(que)]);
                    else
                        console.info("NAN");
                }
            }
            ;
        }
    };
    QueueEx.main = function (args) {
        var arr = [3, -2, -6, 10, -14, 50, 14, 21];
        var k = 3;
        QueueEx.firstNegSlidingWindows(arr, 8, 3);
    };
    return QueueEx;
}());
QueueEx["__class"] = "QueueEx";
QueueEx.main(null);
