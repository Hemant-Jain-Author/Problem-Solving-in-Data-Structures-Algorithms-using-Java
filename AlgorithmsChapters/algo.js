var algo = /** @class */ (function () {
    function algo() {
    }
    algo.fibonacci = function (n) {
        if (n <= 1) {
            return n;
        }
        return algo.fibonacci(n - 1) + algo.fibonacci(n - 2);
    };
    algo.fibonacci2 = function (n) {
        var first = 0;
        var second = 1;
        var temp = 0;
        if (n === 0)
            return first;
        else if (n === 1)
            return second;
        var i = 2;
        while ((i <= n)) {
            {
                temp = first + second;
                first = second;
                second = temp;
                i += 1;
            }
        }
        ;
        return temp;
    };
    algo.print = function (Q, n) {
        for (var i = 0; i < n; i++) {
            {
                console.info(" " + Q[i]);
            }
            ;
        }
        console.info(" ");
    };
    algo.Feasible = function (Q, k) {
        for (var i = 0; i < k; i++) {
            {
                if (Q[k] === Q[i] || Math.abs(Q[i] - Q[k]) === Math.abs(i - k)) {
                    return false;
                }
            }
            ;
        }
        return true;
    };
    algo.NQueens = function (Q, k, n) {
        if (k === n) {
            algo.print(Q, n);
            return;
        }
        for (var i = 0; i < n; i++) {
            {
                Q[k] = i;
                if (algo.Feasible(Q, k)) {
                    algo.NQueens(Q, k + 1, n);
                }
            }
            ;
        }
    };
    algo.main1 = function () {
        var Q = [0, 0, 0, 0, 0, 0, 0, 0];
        algo.NQueens(Q, 0, 8);
    };
    algo.TOHUtil = function (num, from, to, temp) {
        if (num < 1) {
            return;
        }
        algo.TOHUtil(num - 1, from, temp, to);
        console.info("Move disk " + num + " from peg " + from + " to peg " + to);
        algo.TOHUtil(num - 1, temp, to, from);
    };
    algo.TowersOfHanoi = function (num) {
        console.info("The sequence of moves involved in the Tower of Hanoi are :");
        algo.TOHUtil(num, 'A', 'C', 'B');
    };
    algo.main2 = function () {
        algo.TowersOfHanoi(3);
    };
    algo.prototype.isPrime = function (n) {
        var answer = (n > 1) ? 1 : 0;
        for (var i = 2; i * i <= n; ++i) {
            {
                if (n % i === 0) {
                    answer = 1;
                    break;
                }
            }
            ;
        }
        return answer;
    };
    return algo;
}());
algo["__class"] = "algo";
algo.main1();
algo.main2();
