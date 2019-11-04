/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var Algo = /** @class */ (function () {
    function Algo() {
    }
    Algo.prototype.bruteForceSearch$java_lang_String$java_lang_String = function (text, pattern) {
        return this.bruteForceSearch$char_A$char_A(/* toCharArray */ (text).split(''), /* toCharArray */ (pattern).split(''));
    };
    Algo.prototype.bruteForceSearch = function (text, pattern) {
        if (((typeof text === 'string') || text === null) && ((typeof pattern === 'string') || pattern === null)) {
            return this.bruteForceSearch$java_lang_String$java_lang_String(text, pattern);
        }
        else if (((text != null && text instanceof Array && (text.length == 0 || text[0] == null || (typeof text[0] === 'string'))) || text === null) && ((pattern != null && pattern instanceof Array && (pattern.length == 0 || pattern[0] == null || (typeof pattern[0] === 'string'))) || pattern === null)) {
            return this.bruteForceSearch$char_A$char_A(text, pattern);
        }
        else
            throw new Error('invalid overload');
    };
    Algo.prototype.bruteForceSearch$char_A$char_A = function (text, pattern) {
        var i = 0;
        var j = 0;
        var n = text.length;
        var m = pattern.length;
        while ((i <= n - m)) {
            {
                j = 0;
                while ((j < m && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(pattern[j]) == (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(text[i + j]))) {
                    {
                        j++;
                    }
                }
                ;
                if (j === m) {
                    return (i);
                }
                i++;
            }
        }
        ;
        return -1;
    };
    Algo.prototype.robinKarp$java_lang_String$java_lang_String = function (text, pattern) {
        return this.robinKarp$char_A$char_A(/* toCharArray */ (text).split(''), /* toCharArray */ (pattern).split(''));
    };
    Algo.prototype.robinKarp = function (text, pattern) {
        if (((typeof text === 'string') || text === null) && ((typeof pattern === 'string') || pattern === null)) {
            return this.robinKarp$java_lang_String$java_lang_String(text, pattern);
        }
        else if (((text != null && text instanceof Array && (text.length == 0 || text[0] == null || (typeof text[0] === 'string'))) || text === null) && ((pattern != null && pattern instanceof Array && (pattern.length == 0 || pattern[0] == null || (typeof pattern[0] === 'string'))) || pattern === null)) {
            return this.robinKarp$char_A$char_A(text, pattern);
        }
        else
            throw new Error('invalid overload');
    };
    Algo.prototype.robinKarp$char_A$char_A = function (text, pattern) {
        var n = text.length;
        var m = pattern.length;
        var i;
        var j;
        var prime = 101;
        var powm = 1;
        var TextHash = 0;
        var PatternHash = 0;
        if (m === 0 || m > n) {
            return -1;
        }
        for (i = 0; i < m - 1; i++) {
            {
                powm = (powm << 1) % prime;
            }
            ;
        }
        for (i = 0; i < m; i++) {
            {
                PatternHash = ((PatternHash << 1) + (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(pattern[i])) % prime;
                TextHash = ((TextHash << 1) + (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(text[i])) % prime;
            }
            ;
        }
        for (i = 0; i <= (n - m); i++) {
            {
                if (TextHash === PatternHash) {
                    for (j = 0; j < m; j++) {
                        {
                            if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(text[i + j]) != (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(pattern[j])) {
                                break;
                            }
                        }
                        ;
                    }
                    if (j === m)
                        return i;
                }
                TextHash = (((TextHash - (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(text[i]) * powm) << 1) + (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(text[i + m])) % prime;
                if (TextHash < 0) {
                    TextHash = (TextHash + prime);
                }
            }
            ;
        }
        return -1;
    };
    Algo.prototype.KMPPreprocess = function (pattern, ShiftArr) {
        var m = pattern.length;
        var i = 0;
        var j = -1;
        ShiftArr[i] = -1;
        while ((i < m)) {
            {
                while ((j >= 0 && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(pattern[i]) != (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(pattern[j]))) {
                    {
                        j = ShiftArr[j];
                    }
                }
                ;
                i++;
                j++;
                ShiftArr[i] = j;
            }
        }
        ;
    };
    Algo.prototype.KMP$java_lang_String$java_lang_String = function (text, pattern) {
        return this.KMP$char_A$char_A(/* toCharArray */ (text).split(''), /* toCharArray */ (pattern).split(''));
    };
    Algo.prototype.KMP = function (text, pattern) {
        if (((typeof text === 'string') || text === null) && ((typeof pattern === 'string') || pattern === null)) {
            return this.KMP$java_lang_String$java_lang_String(text, pattern);
        }
        else if (((text != null && text instanceof Array && (text.length == 0 || text[0] == null || (typeof text[0] === 'string'))) || text === null) && ((pattern != null && pattern instanceof Array && (pattern.length == 0 || pattern[0] == null || (typeof pattern[0] === 'string'))) || pattern === null)) {
            return this.KMP$char_A$char_A(text, pattern);
        }
        else
            throw new Error('invalid overload');
    };
    Algo.prototype.KMP$char_A$char_A = function (text, pattern) {
        var i = 0;
        var j = 0;
        var n = text.length;
        var m = pattern.length;
        var ShiftArr = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(m + 1);
        this.KMPPreprocess(pattern, ShiftArr);
        while ((i < n)) {
            {
                while ((j >= 0 && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(text[i]) != (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(pattern[j]))) {
                    j = ShiftArr[j];
                }
                ;
                i++;
                j++;
                if (j === m) {
                    return (i - m);
                }
            }
        }
        ;
        return -1;
    };
    Algo.prototype.KMPFindCount = function (text, pattern) {
        var i = 0;
        var j = 0;
        var count = 0;
        var n = text.length;
        var m = pattern.length;
        var ShiftArr = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(m + 1);
        this.KMPPreprocess(pattern, ShiftArr);
        while ((i < n)) {
            {
                while ((j >= 0 && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(text[i]) != (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(pattern[j]))) {
                    {
                        j = ShiftArr[j];
                    }
                }
                ;
                i++;
                j++;
                if (j === m) {
                    count++;
                    j = ShiftArr[j];
                }
            }
        }
        ;
        return count;
    };
    Algo.main = function (args) {
        var st1 = "hello, world!";
        var st2 = "world";
        var algo = new Algo();
        console.info("BruteForceSearch return : " + algo.bruteForceSearch$java_lang_String$java_lang_String(st1, st2));
        console.info("RobinKarp return : " + algo.robinKarp$java_lang_String$java_lang_String(st1, st2));
        console.info("KMP return : " + algo.KMP$java_lang_String$java_lang_String(st1, st2));
    };
    return Algo;
}());
Algo["__class"] = "Algo";
Algo.main(null);
