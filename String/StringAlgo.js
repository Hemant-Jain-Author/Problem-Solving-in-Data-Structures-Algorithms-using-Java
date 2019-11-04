/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var StringAlgo = /** @class */ (function () {
    function StringAlgo() {
    }
    StringAlgo.matchExpUtil = function (exp, str, i, j) {
        if (i === exp.length && j === str.length) {
            return true;
        }
        if ((i === exp.length && j !== str.length) || (i !== exp.length && j === str.length)) {
            return false;
        }
        if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(exp[i]) == '?'.charCodeAt(0) || (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(exp[i]) == (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(str[j])) {
            return StringAlgo.matchExpUtil(exp, str, i + 1, j + 1);
        }
        if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(exp[i]) == '*'.charCodeAt(0)) {
            return StringAlgo.matchExpUtil(exp, str, i + 1, j) || StringAlgo.matchExpUtil(exp, str, i, j + 1) || StringAlgo.matchExpUtil(exp, str, i + 1, j + 1);
        }
        return false;
    };
    StringAlgo.matchExp = function (exp, str) {
        return StringAlgo.matchExpUtil(/* toCharArray */ (exp).split(''), /* toCharArray */ (str).split(''), 0, 0);
    };
    StringAlgo.main1 = function () {
        console.info(StringAlgo.matchExp("*llo,?World?", "Hello, World!"));
    };
    StringAlgo.match = function (src, ptn) {
        var source = (src).split('');
        var pattern = (ptn).split('');
        var iSource = 0;
        var iPattern = 0;
        var sourceLen = source.length;
        var patternLen = pattern.length;
        for (iSource = 0; iSource < sourceLen; iSource++) {
            {
                if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(source[iSource]) == (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(pattern[iPattern])) {
                    iPattern++;
                }
                if (iPattern === patternLen) {
                    return true;
                }
            }
            ;
        }
        return false;
    };
    StringAlgo.main2 = function () {
        console.info(StringAlgo.match("harrypottermustnotgotoschool", "pottergo"));
    };
    StringAlgo.myStrdup = function (src) {
        var index = 0;
        var dst = (function (s) { var a = []; while (s-- > 0)
            a.push(null); return a; })(src.length);
        for (var index8379 = 0; index8379 < src.length; index8379++) {
            var ch = src[index8379];
            {
                dst[index] = ch;
            }
        }
        return dst;
    };
    StringAlgo.isPrime = function (n) {
        var answer = (n > 1) ? true : false;
        for (var i = 2; i * i < n; ++i) {
            {
                if (n % i === 0) {
                    answer = false;
                    break;
                }
            }
            ;
        }
        return answer;
    };
    StringAlgo.main3 = function () {
        console.info("Prime numbers under 100 :: ");
        for (var i = 0; i < 100; i++) {
            if (StringAlgo.isPrime(i))
                console.info(i + " ");
            ;
        }
        console.info();
    };
    StringAlgo.myAtoi = function (str) {
        var value = 0;
        var size = str.length;
        for (var i = 0; i < size; i++) {
            {
                var ch = str.charAt(i);
                value = (value << 3) + (value << 1) + ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) - '0'.charCodeAt(0));
            }
            ;
        }
        return value;
    };
    StringAlgo.main4 = function () {
        console.info(StringAlgo.myAtoi("1000"));
    };
    StringAlgo.isUniqueChar = function (str) {
        var bitarr = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(26);
        var index;
        for (var i = 0; i < 26; i++) {
            {
                bitarr[i] = 0;
            }
            ;
        }
        var size = str.length;
        for (var i = 0; i < size; i++) {
            {
                var c = str.charAt(i);
                if ('A'.charCodeAt(0) <= (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(c) && 'Z'.charCodeAt(0) >= (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(c)) {
                    index = ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(c) - 'A'.charCodeAt(0));
                }
                else if ('a'.charCodeAt(0) <= (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(c) && 'z'.charCodeAt(0) >= (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(c)) {
                    index = ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(c) - 'a'.charCodeAt(0));
                }
                else {
                    console.info("Unknown Char!\n");
                    return false;
                }
                if (bitarr[index] !== 0) {
                    console.info("Duplicate detected!");
                    return false;
                }
                bitarr[index] += 1;
            }
            ;
        }
        console.info("No duplicate detected!");
        return true;
    };
    StringAlgo.main5 = function () {
        console.info(StringAlgo.isUniqueChar("aple"));
        console.info(StringAlgo.isUniqueChar("apple"));
    };
    StringAlgo.ToUpper = function (s) {
        if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) >= 97 && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) <= (97 + 25)) {
            s = String.fromCharCode(((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) - 32));
        }
        return s;
    };
    StringAlgo.ToLower = function (s) {
        if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) >= 65 && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) <= (65 + 25)) {
            s = String.fromCharCode(((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) + 32));
        }
        return s;
    };
    StringAlgo.LowerUpper = function (s) {
        if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) >= 97 && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) <= (97 + 25)) {
            s = String.fromCharCode(((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) - 32));
        }
        else if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) >= 65 && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) <= (65 + 25)) {
            s = String.fromCharCode(((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(s) + 32));
        }
        return s;
    };
    StringAlgo.main6 = function () {
        console.info(StringAlgo.ToLower('A'));
        console.info(StringAlgo.ToUpper('a'));
        console.info(StringAlgo.LowerUpper('s'));
        console.info(StringAlgo.LowerUpper('S'));
    };
    StringAlgo.isPermutation = function (s1, s2) {
        var count = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(256);
        var length = s1.length;
        if (s2.length !== length) {
            console.info("is permutation return false\n");
            return false;
        }
        for (var i = 0; i < 256; i++) {
            {
                count[i] = 0;
            }
            ;
        }
        for (var i = 0; i < length; i++) {
            {
                var ch = s1.charAt(i);
                count[(ch).charCodeAt(0)]++;
                ch = s2.charAt(i);
                count[(ch).charCodeAt(0)]--;
            }
            ;
        }
        for (var i = 0; i < length; i++) {
            {
                if (count[i] !== 0) {
                    console.info("is permutation return false\n");
                    return false;
                }
            }
            ;
        }
        console.info("is permutation return true\n");
        return true;
    };
    StringAlgo.main7 = function () {
        console.info(StringAlgo.isPermutation("apple", "plepa"));
    };
    StringAlgo.isPalindrome = function (str) {
        var i = 0;
        var j = str.length - 1;
        while ((i < j && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(str.charAt(i)) == (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(str.charAt(j)))) {
            {
                i++;
                j--;
            }
        }
        ;
        if (i < j) {
            console.info("String is not a Palindrome");
            return false;
        }
        else {
            console.info("String is a Palindrome");
            return true;
        }
    };
    StringAlgo.main8 = function () {
        console.info(StringAlgo.isPalindrome("hello"));
        console.info(StringAlgo.isPalindrome("eoloe"));
    };
    StringAlgo.pow = function (x, n) {
        var value;
        if (n === 0) {
            return (1);
        }
        else if (n % 2 === 0) {
            value = StringAlgo.pow(x, (n / 2 | 0));
            return (value * value);
        }
        else {
            value = StringAlgo.pow(x, (n / 2 | 0));
            return (x * value * value);
        }
    };
    StringAlgo.main9 = function () {
        console.info(StringAlgo.pow(5, 2));
    };
    StringAlgo.myStrcmp = function (a, b) {
        var index = 0;
        var len1 = a.length;
        var len2 = b.length;
        var minlen = len1;
        if (len1 > len2) {
            minlen = len2;
        }
        while ((index < minlen && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(a.charAt(index)) == (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(b.charAt(index)))) {
            {
                index++;
            }
        }
        ;
        if (index === len1 && index === len2) {
            return 0;
        }
        else if (len1 === index) {
            return -1;
        }
        else if (len2 === index) {
            return 1;
        }
        else {
            return (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(a.charAt(index)) - (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(b.charAt(index));
        }
    };
    StringAlgo.main10 = function () {
        console.info(StringAlgo.myStrcmp("abs", "abs"));
    };
    StringAlgo.reverseString = function (str) {
        var a = (str).split('');
        StringAlgo.reverseStringUtil$char_A(a);
        var expn = a.join('');
        return expn;
    };
    StringAlgo.reverseStringUtil$char_A = function (a) {
        var lower = 0;
        var upper = a.length - 1;
        var tempChar;
        while ((lower < upper)) {
            {
                tempChar = a[lower];
                a[lower] = a[upper];
                a[upper] = tempChar;
                lower++;
                upper--;
            }
        }
        ;
    };
    StringAlgo.reverseStringUtil$char_A$int$int = function (a, lower, upper) {
        var tempChar;
        while ((lower < upper)) {
            {
                tempChar = a[lower];
                a[lower] = a[upper];
                a[upper] = tempChar;
                lower++;
                upper--;
            }
        }
        ;
    };
    StringAlgo.reverseStringUtil = function (a, lower, upper) {
        if (((a != null && a instanceof Array && (a.length == 0 || a[0] == null || (typeof a[0] === 'string'))) || a === null) && ((typeof lower === 'number') || lower === null) && ((typeof upper === 'number') || upper === null)) {
            return StringAlgo.reverseStringUtil$char_A$int$int(a, lower, upper);
        }
        else if (((a != null && a instanceof Array && (a.length == 0 || a[0] == null || (typeof a[0] === 'string'))) || a === null) && lower === undefined && upper === undefined) {
            return StringAlgo.reverseStringUtil$char_A(a);
        }
        else
            throw new Error('invalid overload');
    };
    StringAlgo.reverseWords = function (str) {
        var a = (str).split('');
        var length = a.length;
        var lower = 0;
        var upper = -1;
        for (var i = 0; i <= length; i++) {
            {
                if (i === length || (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(a[i]) == ' '.charCodeAt(0)) {
                    StringAlgo.reverseStringUtil$char_A$int$int(a, lower, upper);
                    lower = i + 1;
                    upper = i;
                }
                else {
                    upper++;
                }
            }
            ;
        }
        StringAlgo.reverseStringUtil$char_A$int$int(a, 0, length - 1);
        var expn = a.join('');
        return expn;
    };
    StringAlgo.main11 = function () {
        console.info(StringAlgo.reverseString("apple"));
        console.info(StringAlgo.reverseWords("hello world"));
    };
    StringAlgo.printAnagram$java_lang_String = function (str) {
        var a = (str).split('');
        var n = a.length;
        StringAlgo.printAnagram$char_A$int$int(a, n, n);
    };
    StringAlgo.printAnagram$char_A$int$int = function (a, max, n) {
        if (max === 1) {
            console.info(a);
        }
        var temp;
        for (var i = -1; i < max - 1; i++) {
            {
                if (i !== -1) {
                    temp = a[i];
                    a[i] = a[max - 1];
                    a[max - 1] = temp;
                }
                StringAlgo.printAnagram$char_A$int$int(a, max - 1, n);
                if (i !== -1) {
                    temp = a[i];
                    a[i] = a[max - 1];
                    a[max - 1] = temp;
                }
            }
            ;
        }
    };
    StringAlgo.printAnagram = function (a, max, n) {
        if (((a != null && a instanceof Array && (a.length == 0 || a[0] == null || (typeof a[0] === 'string'))) || a === null) && ((typeof max === 'number') || max === null) && ((typeof n === 'number') || n === null)) {
            return StringAlgo.printAnagram$char_A$int$int(a, max, n);
        }
        else if (((typeof a === 'string') || a === null) && max === undefined && n === undefined) {
            return StringAlgo.printAnagram$java_lang_String(a);
        }
        else
            throw new Error('invalid overload');
    };
    StringAlgo.main12 = function () {
        StringAlgo.printAnagram$java_lang_String("123");
    };
    StringAlgo.shuffle = function (str) {
        var ar = (str).split('');
        var n = (ar.length / 2 | 0);
        var count = 0;
        var k = 1;
        var temp = '\u0000';
        for (var i = 1; i < n; i = i + 2) {
            {
                temp = ar[i];
                k = i;
                do {
                    {
                        k = (2 * k) % (2 * n - 1);
                        temp = String.fromCharCode((temp).charCodeAt(0) ^ (ar[k] = String.fromCharCode((ar[k]).charCodeAt(0) ^ (temp = String.fromCharCode((temp).charCodeAt(0) ^ (ar[k]).charCodeAt(0))).charCodeAt(0))).charCodeAt(0));
                        count++;
                    }
                } while ((i !== k));
                if (count === (2 * n - 2)) {
                    break;
                }
            }
            ;
        }
    };
    StringAlgo.main13 = function () {
        StringAlgo.shuffle("ABCDE12345");
    };
    StringAlgo.addBinary = function (firstStr, secondStr) {
        var first = (firstStr).split('');
        var second = (secondStr).split('');
        var size1 = first.length;
        var size2 = second.length;
        var totalIndex;
        var total;
        if (size1 > size2) {
            total = (function (s) { var a = []; while (s-- > 0)
                a.push(null); return a; })(size1 + 2);
            totalIndex = size1;
        }
        else {
            total = (function (s) { var a = []; while (s-- > 0)
                a.push(null); return a; })(size2 + 2);
            totalIndex = size2;
        }
        total[totalIndex + 1] = '\u0000';
        var carry = 0;
        size1--;
        size2--;
        while ((size1 >= 0 || size2 >= 0)) {
            {
                var firstValue = (size1 < 0) ? 0 : (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(first[size1]) - '0'.charCodeAt(0);
                var secondValue = (size2 < 0) ? 0 : (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(second[size2]) - '0'.charCodeAt(0);
                var sum = firstValue + secondValue + carry;
                carry = sum >> 1;
                sum = sum & 1;
                total[totalIndex] = (sum === 0) ? '0' : '1';
                totalIndex--;
                size1--;
                size2--;
            }
        }
        ;
        total[totalIndex] = (carry === 0) ? '0' : '1';
        return total;
    };
    StringAlgo.main14 = function () {
        console.info(StringAlgo.addBinary("1000", "11111111"));
    };
    StringAlgo.main = function (args) {
        StringAlgo.main1();
        StringAlgo.main2();
        StringAlgo.main3();
        StringAlgo.main4();
        StringAlgo.main5();
        StringAlgo.main6();
        StringAlgo.main7();
        StringAlgo.main8();
        StringAlgo.main9();
        StringAlgo.main10();
        StringAlgo.main11();
        StringAlgo.main12();
        StringAlgo.main13();
        StringAlgo.main14();
    };
    return StringAlgo;
}());
StringAlgo["__class"] = "StringAlgo";
StringAlgo.main(null);
