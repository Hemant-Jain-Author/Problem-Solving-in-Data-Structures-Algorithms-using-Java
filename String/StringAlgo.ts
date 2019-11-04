/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class StringAlgo {
    public static matchExpUtil(exp : string[], str : string[], i : number, j : number) : boolean {
        if(i === exp.length && j === str.length) {
            return true;
        }
        if((i === exp.length && j !== str.length) || (i !== exp.length && j === str.length)) {
            return false;
        }
        if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(exp[i]) == '?'.charCodeAt(0) || (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(exp[i]) == (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(str[j])) {
            return StringAlgo.matchExpUtil(exp, str, i + 1, j + 1);
        }
        if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(exp[i]) == '*'.charCodeAt(0)) {
            return StringAlgo.matchExpUtil(exp, str, i + 1, j) || StringAlgo.matchExpUtil(exp, str, i, j + 1) || StringAlgo.matchExpUtil(exp, str, i + 1, j + 1);
        }
        return false;
    }

    public static matchExp(exp : string, str : string) : boolean {
        return StringAlgo.matchExpUtil(/* toCharArray */(exp).split(''), /* toCharArray */(str).split(''), 0, 0);
    }

    public static main1() {
        console.info(StringAlgo.matchExp("*llo,?World?", "Hello, World!"));
    }

    public static match(src : string, ptn : string) : boolean {
        let source : string[] = /* toCharArray */(src).split('');
        let pattern : string[] = /* toCharArray */(ptn).split('');
        let iSource : number = 0;
        let iPattern : number = 0;
        let sourceLen : number = source.length;
        let patternLen : number = pattern.length;
        for(iSource = 0; iSource < sourceLen; iSource++) {{
            if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(source[iSource]) == (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(pattern[iPattern])) {
                iPattern++;
            }
            if(iPattern === patternLen) {
                return true;
            }
        };}
        return false;
    }

    public static main2() {
        console.info(StringAlgo.match("harrypottermustnotgotoschool", "pottergo"));
    }

    public static myStrdup(src : string[]) : string[] {
        let index : number = 0;
        let dst : string[] = (s => { let a=[]; while(s-->0) a.push(null); return a; })(src.length);
        for(let index8379=0; index8379 < src.length; index8379++) {
            let ch = src[index8379];
            {
                dst[index] = ch;
            }
        }
        return dst;
    }

    public static isPrime(n : number) : boolean {
        let answer : boolean = (n > 1)?true:false;
        for(let i : number = 2; i * i < n; ++i) {{
            if(n % i === 0) {
                answer = false;
                break;
            }
        };}
        return answer;
    }

    public static main3() {
        console.info("Prime numbers under 100 :: ");
        for(let i : number = 0; i < 100; i++) {if(StringAlgo.isPrime(i)) console.info(i + " ");;}
        console.info();
    }

    public static myAtoi(str : string) : number {
        let value : number = 0;
        let size : number = str.length;
        for(let i : number = 0; i < size; i++) {{
            let ch : string = str.charAt(i);
            value = (value << 3) + (value << 1) + ((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) - '0'.charCodeAt(0));
        };}
        return value;
    }

    public static main4() {
        console.info(StringAlgo.myAtoi("1000"));
    }

    public static isUniqueChar(str : string) : boolean {
        let bitarr : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(26);
        let index : number;
        for(let i : number = 0; i < 26; i++) {{
            bitarr[i] = 0;
        };}
        let size : number = str.length;
        for(let i : number = 0; i < size; i++) {{
            let c : string = str.charAt(i);
            if('A'.charCodeAt(0) <= (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(c) && 'Z'.charCodeAt(0) >= (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(c)) {
                index = ((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(c) - 'A'.charCodeAt(0));
            } else if('a'.charCodeAt(0) <= (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(c) && 'z'.charCodeAt(0) >= (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(c)) {
                index = ((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(c) - 'a'.charCodeAt(0));
            } else {
                console.info("Unknown Char!\n");
                return false;
            }
            if(bitarr[index] !== 0) {
                console.info("Duplicate detected!");
                return false;
            }
            bitarr[index] += 1;
        };}
        console.info("No duplicate detected!");
        return true;
    }

    public static main5() {
        console.info(StringAlgo.isUniqueChar("aple"));
        console.info(StringAlgo.isUniqueChar("apple"));
    }

    public static ToUpper(s : string) : string {
        if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) >= 97 && (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) <= (97 + 25)) {
            s = String.fromCharCode(((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) - 32));
        }
        return s;
    }

    public static ToLower(s : string) : string {
        if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) >= 65 && (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) <= (65 + 25)) {
            s = String.fromCharCode(((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) + 32));
        }
        return s;
    }

    public static LowerUpper(s : string) : string {
        if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) >= 97 && (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) <= (97 + 25)) {
            s = String.fromCharCode(((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) - 32));
        } else if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) >= 65 && (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) <= (65 + 25)) {
            s = String.fromCharCode(((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(s) + 32));
        }
        return s;
    }

    public static main6() {
        console.info(StringAlgo.ToLower('A'));
        console.info(StringAlgo.ToUpper('a'));
        console.info(StringAlgo.LowerUpper('s'));
        console.info(StringAlgo.LowerUpper('S'));
    }

    public static isPermutation(s1 : string, s2 : string) : boolean {
        let count : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(256);
        let length : number = s1.length;
        if(s2.length !== length) {
            console.info("is permutation return false\n");
            return false;
        }
        for(let i : number = 0; i < 256; i++) {{
            count[i] = 0;
        };}
        for(let i : number = 0; i < length; i++) {{
            let ch : string = s1.charAt(i);
            count[(ch).charCodeAt(0)]++;
            ch = s2.charAt(i);
            count[(ch).charCodeAt(0)]--;
        };}
        for(let i : number = 0; i < length; i++) {{
            if(count[i] !== 0) {
                console.info("is permutation return false\n");
                return false;
            }
        };}
        console.info("is permutation return true\n");
        return true;
    }

    public static main7() {
        console.info(StringAlgo.isPermutation("apple", "plepa"));
    }

    public static isPalindrome(str : string) : boolean {
        let i : number = 0;
        let j : number = str.length - 1;
        while((i < j && (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(str.charAt(i)) == (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(str.charAt(j)))) {{
            i++;
            j--;
        }};
        if(i < j) {
            console.info("String is not a Palindrome");
            return false;
        } else {
            console.info("String is a Palindrome");
            return true;
        }
    }

    public static main8() {
        console.info(StringAlgo.isPalindrome("hello"));
        console.info(StringAlgo.isPalindrome("eoloe"));
    }

    public static pow(x : number, n : number) : number {
        let value : number;
        if(n === 0) {
            return (1);
        } else if(n % 2 === 0) {
            value = StringAlgo.pow(x, (n / 2|0));
            return (value * value);
        } else {
            value = StringAlgo.pow(x, (n / 2|0));
            return (x * value * value);
        }
    }

    public static main9() {
        console.info(StringAlgo.pow(5, 2));
    }

    public static myStrcmp(a : string, b : string) : number {
        let index : number = 0;
        let len1 : number = a.length;
        let len2 : number = b.length;
        let minlen : number = len1;
        if(len1 > len2) {
            minlen = len2;
        }
        while((index < minlen && (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(a.charAt(index)) == (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(b.charAt(index)))) {{
            index++;
        }};
        if(index === len1 && index === len2) {
            return 0;
        } else if(len1 === index) {
            return -1;
        } else if(len2 === index) {
            return 1;
        } else {
            return (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(a.charAt(index)) - (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(b.charAt(index));
        }
    }

    public static main10() {
        console.info(StringAlgo.myStrcmp("abs", "abs"));
    }

    public static reverseString(str : string) : string {
        let a : string[] = /* toCharArray */(str).split('');
        StringAlgo.reverseStringUtil$char_A(a);
        let expn : string = a.join('');
        return expn;
    }

    public static reverseStringUtil$char_A(a : string[]) {
        let lower : number = 0;
        let upper : number = a.length - 1;
        let tempChar : string;
        while((lower < upper)) {{
            tempChar = a[lower];
            a[lower] = a[upper];
            a[upper] = tempChar;
            lower++;
            upper--;
        }};
    }

    public static reverseStringUtil$char_A$int$int(a : string[], lower : number, upper : number) {
        let tempChar : string;
        while((lower < upper)) {{
            tempChar = a[lower];
            a[lower] = a[upper];
            a[upper] = tempChar;
            lower++;
            upper--;
        }};
    }

    public static reverseStringUtil(a? : any, lower? : any, upper? : any) : any {
        if(((a != null && a instanceof <any>Array && (a.length==0 || a[0] == null ||(typeof a[0] === 'string'))) || a === null) && ((typeof lower === 'number') || lower === null) && ((typeof upper === 'number') || upper === null)) {
            return <any>StringAlgo.reverseStringUtil$char_A$int$int(a, lower, upper);
        } else if(((a != null && a instanceof <any>Array && (a.length==0 || a[0] == null ||(typeof a[0] === 'string'))) || a === null) && lower === undefined && upper === undefined) {
            return <any>StringAlgo.reverseStringUtil$char_A(a);
        } else throw new Error('invalid overload');
    }

    public static reverseWords(str : string) : string {
        let a : string[] = /* toCharArray */(str).split('');
        let length : number = a.length;
        let lower : number = 0;
        let upper : number = -1;
        for(let i : number = 0; i <= length; i++) {{
            if(i === length || (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(a[i]) == ' '.charCodeAt(0)) {
                StringAlgo.reverseStringUtil$char_A$int$int(a, lower, upper);
                lower = i + 1;
                upper = i;
            } else {
                upper++;
            }
        };}
        StringAlgo.reverseStringUtil$char_A$int$int(a, 0, length - 1);
        let expn : string = a.join('');
        return expn;
    }

    public static main11() {
        console.info(StringAlgo.reverseString("apple"));
        console.info(StringAlgo.reverseWords("hello world"));
    }

    public static printAnagram$java_lang_String(str : string) {
        let a : string[] = /* toCharArray */(str).split('');
        let n : number = a.length;
        StringAlgo.printAnagram$char_A$int$int(a, n, n);
    }

    public static printAnagram$char_A$int$int(a : string[], max : number, n : number) {
        if(max === 1) {
            console.info(a);
        }
        let temp : string;
        for(let i : number = -1; i < max - 1; i++) {{
            if(i !== -1) {
                temp = a[i];
                a[i] = a[max - 1];
                a[max - 1] = temp;
            }
            StringAlgo.printAnagram$char_A$int$int(a, max - 1, n);
            if(i !== -1) {
                temp = a[i];
                a[i] = a[max - 1];
                a[max - 1] = temp;
            }
        };}
    }

    public static printAnagram(a? : any, max? : any, n? : any) : any {
        if(((a != null && a instanceof <any>Array && (a.length==0 || a[0] == null ||(typeof a[0] === 'string'))) || a === null) && ((typeof max === 'number') || max === null) && ((typeof n === 'number') || n === null)) {
            return <any>StringAlgo.printAnagram$char_A$int$int(a, max, n);
        } else if(((typeof a === 'string') || a === null) && max === undefined && n === undefined) {
            return <any>StringAlgo.printAnagram$java_lang_String(a);
        } else throw new Error('invalid overload');
    }

    public static main12() {
        StringAlgo.printAnagram$java_lang_String("123");
    }

    public static shuffle(str : string) {
        let ar : string[] = /* toCharArray */(str).split('');
        let n : number = (ar.length / 2|0);
        let count : number = 0;
        let k : number = 1;
        let temp : string = '\u0000';
        for(let i : number = 1; i < n; i = i + 2) {{
            temp = ar[i];
            k = i;
            do {{
                k = (2 * k) % (2 * n - 1);
                temp = String.fromCharCode((temp).charCodeAt(0) ^ (ar[k] = String.fromCharCode((ar[k]).charCodeAt(0) ^ (temp = String.fromCharCode((temp).charCodeAt(0) ^ (ar[k]).charCodeAt(0))).charCodeAt(0))).charCodeAt(0));
                count++;
            }} while((i !== k));
            if(count === (2 * n - 2)) {
                break;
            }
        };}
    }

    public static main13() {
        StringAlgo.shuffle("ABCDE12345");
    }

    public static addBinary(firstStr : string, secondStr : string) : string[] {
        let first : string[] = /* toCharArray */(firstStr).split('');
        let second : string[] = /* toCharArray */(secondStr).split('');
        let size1 : number = first.length;
        let size2 : number = second.length;
        let totalIndex : number;
        let total : string[];
        if(size1 > size2) {
            total = (s => { let a=[]; while(s-->0) a.push(null); return a; })(size1 + 2);
            totalIndex = size1;
        } else {
            total = (s => { let a=[]; while(s-->0) a.push(null); return a; })(size2 + 2);
            totalIndex = size2;
        }
        total[totalIndex + 1] = '\u0000';
        let carry : number = 0;
        size1--;
        size2--;
        while((size1 >= 0 || size2 >= 0)) {{
            let firstValue : number = (size1 < 0)?0:(c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(first[size1]) - '0'.charCodeAt(0);
            let secondValue : number = (size2 < 0)?0:(c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(second[size2]) - '0'.charCodeAt(0);
            let sum : number = firstValue + secondValue + carry;
            carry = sum >> 1;
            sum = sum & 1;
            total[totalIndex] = (sum === 0)?'0':'1';
            totalIndex--;
            size1--;
            size2--;
        }};
        total[totalIndex] = (carry === 0)?'0':'1';
        return total;
    }

    public static main14() {
        console.info(StringAlgo.addBinary("1000", "11111111"));
    }

    public static main(args : string[]) {
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
    }
}
StringAlgo["__class"] = "StringAlgo";




StringAlgo.main(null);
