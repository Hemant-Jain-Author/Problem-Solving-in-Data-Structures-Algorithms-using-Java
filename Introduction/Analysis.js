var Analysis = /** @class */ (function () {
    function Analysis() {
    }
    Analysis.prototype.fun1 = function (n) {
        var m = 0;
        for (var i = 0; i < n; i++) {
            {
                m += 1;
            }
            ;
        }
        return m;
    };
    Analysis.prototype.fun2 = function (n) {
        var i;
        var j;
        var m = 0;
        for (i = 0; i < n; i++) {
            {
                for (j = 0; j < n; j++) {
                    {
                        m += 1;
                    }
                    ;
                }
            }
            ;
        }
        return m;
    };
    Analysis.prototype.fun3 = function (n) {
        var i;
        var j;
        var m = 0;
        for (i = 0; i < n; i++) {
            {
                for (j = 0; j < i; j++) {
                    {
                        m += 1;
                    }
                    ;
                }
            }
            ;
        }
        return m;
    };
    Analysis.prototype.fun4 = function (n) {
        var i;
        var m = 0;
        i = 1;
        while ((i < n)) {
            {
                m += 1;
                i = i * 2;
            }
        }
        ;
        return m;
    };
    Analysis.prototype.fun5 = function (n) {
        var i;
        var m = 0;
        i = n;
        while ((i > 0)) {
            {
                m += 1;
                i = (i / 2 | 0);
            }
        }
        ;
        return m;
    };
    Analysis.prototype.fun6 = function (n) {
        var i;
        var j;
        var k;
        var m = 0;
        for (i = 0; i < n; i++) {
            {
                for (j = 0; j < n; j++) {
                    {
                        for (k = 0; k < n; k++) {
                            {
                                m += 1;
                            }
                            ;
                        }
                    }
                    ;
                }
            }
            ;
        }
        return m;
    };
    Analysis.prototype.fun7 = function (n) {
        var i;
        var j;
        var k;
        var m = 0;
        for (i = 0; i < n; i++) {
            {
                for (j = 0; j < n; j++) {
                    {
                        m += 1;
                    }
                    ;
                }
            }
            ;
        }
        for (i = 0; i < n; i++) {
            {
                for (k = 0; k < n; k++) {
                    {
                        m += 1;
                    }
                    ;
                }
            }
            ;
        }
        return m;
    };
    Analysis.prototype.fun8 = function (n) {
        var i;
        var j;
        var m = 0;
        for (i = 0; i < n; i++) {
            {
                for (j = 0; j < Math.sqrt(n); j++) {
                    {
                        m += 1;
                    }
                    ;
                }
            }
            ;
        }
        return m;
    };
    Analysis.prototype.fun9 = function (n) {
        var i;
        var j;
        var m = 0;
        for (i = n; i > 0; i = (function (n) { return n < 0 ? Math.ceil(n) : Math.floor(n); })(i / 2)) {
            {
                for (j = 0; j < i; j++) {
                    {
                        m += 1;
                    }
                    ;
                }
            }
            ;
        }
        return m;
    };
    Analysis.prototype.fun10 = function (n) {
        var i;
        var j;
        var m = 0;
        for (i = 0; i < n; i++) {
            {
                for (j = i; j > 0; j--) {
                    {
                        m += 1;
                    }
                    ;
                }
            }
            ;
        }
        return m;
    };
    Analysis.prototype.fun11 = function (n) {
        var i;
        var j;
        var k;
        var m = 0;
        for (i = 0; i < n; i++) {
            {
                for (j = i; j < n; j++) {
                    {
                        for (k = j + 1; k < n; k++) {
                            {
                                m += 1;
                            }
                            ;
                        }
                    }
                    ;
                }
            }
            ;
        }
        return m;
    };
    Analysis.prototype.fun12 = function (n) {
        var i;
        var j = 0;
        var m = 0;
        for (i = 0; i < n; i++) {
            {
                for (; j < n; j++) {
                    {
                        m += 1;
                    }
                    ;
                }
            }
            ;
        }
        return m;
    };
    Analysis.prototype.fun13 = function (n) {
        var i;
        var j = 0;
        var m = 0;
        for (i = 1; i <= n; i *= 2) {
            {
                for (j = 0; j <= i; j++) {
                    {
                        m += 1;
                    }
                    ;
                }
            }
            ;
        }
        return m;
    };
    Analysis.main = function (args) {
        var a = new Analysis();
        console.info(a.fun1(100));
        console.info(a.fun2(100));
        console.info(a.fun3(100));
        console.info(a.fun4(100));
        console.info(a.fun5(100));
        console.info(a.fun6(100));
        console.info(a.fun7(100));
        console.info(a.fun8(100));
        console.info(a.fun9(100));
        console.info(a.fun10(100));
        console.info(a.fun11(100));
        console.info(a.fun12(100));
        console.info(a.fun13(100));
    };
    return Analysis;
}());
Analysis["__class"] = "Analysis";
Analysis.main(null);
