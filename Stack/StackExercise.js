/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var StackExercise = /** @class */ (function () {
    function StackExercise() {
    }
    StackExercise.isBalancedParenthesis = function (expn) {
        var stk = ([]);
        {
            var array8370 = /* toCharArray */ (expn).split('');
            for (var index8369 = 0; index8369 < array8370.length; index8369++) {
                var ch = array8370[index8369];
                {
                    switch ((ch).charCodeAt(0)) {
                        case 123 /* '{' */:
                        case 91 /* '[' */:
                        case 40 /* '(' */:
                            /* push */ (stk.push(ch) > 0);
                            break;
                        case 125 /* '}' */:
                            if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(/* pop */ stk.pop()) != '{'.charCodeAt(0)) {
                                return false;
                            }
                            break;
                        case 93 /* ']' */:
                            if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(/* pop */ stk.pop()) != '['.charCodeAt(0)) {
                                return false;
                            }
                            break;
                        case 41 /* ')' */:
                            if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(/* pop */ stk.pop()) != '('.charCodeAt(0)) {
                                return false;
                            }
                            break;
                    }
                }
            }
        }
        return /* isEmpty */ (stk.length == 0);
    };
    StackExercise.main = function (args) {
        var expn = "{()}[]";
        var value = StackExercise.isBalancedParenthesis(expn);
        console.info("Given Expn:" + expn);
        console.info("Result after isParenthesisMatched:" + value);
    };
    StackExercise.insertAtBottom = function (stk, value) {
        if ( /* isEmpty */(stk.length == 0)) {
            /* push */ (stk.push(value) > 0);
        }
        else {
            var out = stk.pop();
            StackExercise.insertAtBottom(stk, value);
            /* push */ (stk.push(out) > 0);
        }
    };
    StackExercise.reverseStack = function (stk) {
        if ( /* isEmpty */(stk.length == 0)) {
            return;
        }
        else {
            var value = stk.pop();
            StackExercise.reverseStack(stk);
            StackExercise.insertAtBottom(stk, value);
        }
    };
    StackExercise.precedence = function (x) {
        if (x == '('.charCodeAt(0)) {
            return (0);
        }
        if (x == '+'.charCodeAt(0) || x == '-'.charCodeAt(0)) {
            return (1);
        }
        if (x == '*'.charCodeAt(0) || x == '/'.charCodeAt(0) || x == '%'.charCodeAt(0))
            return (2);
        if (x == '^'.charCodeAt(0)) {
            return (3);
        }
        return (4);
    };
    StackExercise.infixToPostfix$java_lang_String = function (expn) {
        var output = "";
        var out = StackExercise.infixToPostfix$char_A(/* toCharArray */ (expn).split(''));
        for (var index8371 = 0; index8371 < out.length; index8371++) {
            var ch = out[index8371];
            {
                output = output + ch;
            }
        }
        return output;
    };
    StackExercise.infixToPostfix = function (expn) {
        if (((typeof expn === 'string') || expn === null)) {
            return StackExercise.infixToPostfix$java_lang_String(expn);
        }
        else if (((expn != null && expn instanceof Array && (expn.length == 0 || expn[0] == null || (typeof expn[0] === 'string'))) || expn === null)) {
            return StackExercise.infixToPostfix$char_A(expn);
        }
        else
            throw new Error('invalid overload');
    };
    StackExercise.infixToPostfix$char_A = function (expn) {
        var stk = ([]);
        var output = "";
        var out;
        for (var index8372 = 0; index8372 < expn.length; index8372++) {
            var ch = expn[index8372];
            {
                if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) <= '9'.charCodeAt(0) && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) >= '0'.charCodeAt(0)) {
                    output = output + ch;
                }
                else {
                    switch ((ch).charCodeAt(0)) {
                        case 43 /* '+' */:
                        case 45 /* '-' */:
                        case 42 /* '*' */:
                        case 47 /* '/' */:
                        case 37 /* '%' */:
                        case 94 /* '^' */:
                            while (( /* isEmpty */(stk.length == 0) === false)) {
                                {
                                    output = output + " " + out;
                                }
                            }
                            ;
                            /* push */ (stk.push(ch) > 0);
                            output = output + " ";
                            break;
                        case 40 /* '(' */:
                            /* push */ (stk.push(ch) > 0);
                            break;
                        case 41 /* ')' */:
                            while (( /* isEmpty */(stk.length == 0) === false)) {
                                {
                                    output = output + " " + out + " ";
                                }
                            }
                            ;
                            break;
                    }
                }
            }
        }
        while (( /* isEmpty */(stk.length == 0) === false)) {
            {
                output = output + out + " ";
            }
        }
        ;
        return /* toCharArray */ (output).split('');
    };
    StackExercise.main3 = function (args) {
        var expn = "10+((3))*5/(16-4)";
        var value = StackExercise.infixToPostfix$java_lang_String(expn);
        console.info("Infix Expn: " + expn);
        console.info("Postfix Expn: " + value);
    };
    StackExercise.infixToPrefix = function (expn) {
        var arr = (expn).split('');
        StackExercise.reverseString(arr);
        StackExercise.replaceParanthesis(arr);
        arr = StackExercise.infixToPostfix$char_A(arr);
        StackExercise.reverseString(arr);
        expn = arr.join('');
        return expn;
    };
    StackExercise.replaceParanthesis = function (a) {
        var lower = 0;
        var upper = a.length - 1;
        while ((lower <= upper)) {
            {
                if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(a[lower]) == '('.charCodeAt(0)) {
                    a[lower] = ')';
                }
                else if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(a[lower]) == ')'.charCodeAt(0)) {
                    a[lower] = '(';
                }
                lower++;
            }
        }
        ;
    };
    StackExercise.reverseString = function (expn) {
        var lower = 0;
        var upper = expn.length - 1;
        var tempChar;
        while ((lower < upper)) {
            {
                tempChar = expn[lower];
                expn[lower] = expn[upper];
                expn[upper] = tempChar;
                lower++;
                upper--;
            }
        }
        ;
    };
    StackExercise.main4 = function (args) {
        var expn = "10+((3))*5/(16-4)";
        var value = StackExercise.infixToPrefix(expn);
        console.info("Infix Expn: " + expn);
        console.info("Prefix Expn: " + value);
    };
    StackExercise.StockSpanRange = function (arr) {
        var SR = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(arr.length);
        SR[0] = 1;
        for (var i = 1; i < arr.length; i++) {
            {
                SR[i] = 1;
                for (var j = i - 1; (j >= 0) && (arr[i] >= arr[j]); j--) {
                    {
                        SR[i]++;
                    }
                    ;
                }
            }
            ;
        }
        return SR;
    };
    StackExercise.StockSpanRange2 = function (arr) {
        var stk = ([]);
        var SR = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(arr.length);
        /* push */ (stk.push(0) > 0);
        SR[0] = 1;
        for (var i = 1; i < arr.length; i++) {
            {
                while ((!(stk.length == 0) && arr[ /* peek */(function (s) { return s[s.length - 1]; })(stk)] <= arr[i])) {
                    {
                        /* pop */ stk.pop();
                    }
                }
                ;
                SR[i] = ( /* isEmpty */(stk.length == 0)) ? (i + 1) : (i - /* peek */ (function (s) { return s[s.length - 1]; })(stk));
                /* push */ (stk.push(i) > 0);
            }
            ;
        }
        return SR;
    };
    StackExercise.main5 = function (args) {
        var arr = [6, 5, 4, 3, 2, 4, 5, 7, 9];
        var size = arr.length;
        var value = StackExercise.StockSpanRange(arr);
        console.info("\nStockSpanRange : ");
        for (var index8373 = 0; index8373 < value.length; index8373++) {
            var val = value[index8373];
            console.info(" " + val);
        }
        value = StackExercise.StockSpanRange2(arr);
        console.info("\nStockSpanRange : ");
        for (var index8374 = 0; index8374 < value.length; index8374++) {
            var val = value[index8374];
            console.info(" " + val);
        }
    };
    StackExercise.GetMaxArea = function (arr) {
        var size = arr.length;
        var maxArea = -1;
        var currArea;
        var minHeight = 0;
        for (var i = 1; i < size; i++) {
            {
                minHeight = arr[i];
                for (var j = i - 1; j >= 0; j--) {
                    {
                        if (minHeight > arr[j]) {
                            minHeight = arr[j];
                        }
                        currArea = minHeight * (i - j + 1);
                        if (maxArea < currArea) {
                            maxArea = currArea;
                        }
                    }
                    ;
                }
            }
            ;
        }
        return maxArea;
    };
    StackExercise.GetMaxArea2 = function (arr) {
        var size = arr.length;
        var stk = ([]);
        var maxArea = 0;
        var top;
        var topArea;
        var i = 0;
        while ((i < size)) {
            {
                while (((i < size) && ( /* isEmpty */(stk.length == 0) || arr[ /* peek */(function (s) { return s[s.length - 1]; })(stk)] <= arr[i]))) {
                    {
                        /* push */ (stk.push(i) > 0);
                        i++;
                    }
                }
                ;
                while ((!(stk.length == 0) && (i === size || arr[ /* peek */(function (s) { return s[s.length - 1]; })(stk)] > arr[i]))) {
                    {
                        top = /* peek */ (function (s) { return s[s.length - 1]; })(stk);
                        /* pop */ stk.pop();
                        topArea = arr[top] * ( /* isEmpty */(stk.length == 0) ? i : i - /* peek */ (function (s) { return s[s.length - 1]; })(stk) - 1);
                        if (maxArea < topArea) {
                            maxArea = topArea;
                        }
                    }
                }
                ;
            }
        }
        ;
        return maxArea;
    };
    StackExercise.main6 = function (args) {
        var arr = [7, 6, 5, 4, 4, 1, 6, 3, 1];
        var size = arr.length;
        var value = StackExercise.GetMaxArea(arr);
        console.info("GetMaxArea :: " + value);
        value = StackExercise.GetMaxArea2(arr);
        console.info("GetMaxArea :: " + value);
    };
    StackExercise.sortedInsert = function (stk, element) {
        var temp;
        if ( /* isEmpty */(stk.length == 0) || element > /* peek */ (function (s) { return s[s.length - 1]; })(stk)) /* push */
            (stk.push(element) > 0);
        else {
            temp = /* pop */ stk.pop();
            StackExercise.sortedInsert(stk, element);
            /* push */ (stk.push(temp) > 0);
        }
    };
    StackExercise.sortStack = function (stk) {
        var temp;
        if ( /* isEmpty */(stk.length == 0) === false) {
            temp = /* pop */ stk.pop();
            StackExercise.sortStack(stk);
            /* push */ (stk.push(temp) > 0);
        }
    };
    StackExercise.sortStack2 = function (stk) {
        var temp;
        var stk2 = ([]);
        while (( /* isEmpty */(stk.length == 0) === false)) {
            {
                temp = /* pop */ stk.pop();
                while ((( /* isEmpty */(stk.length == 0) === false) && ( /* peek */(function (s) { return s[s.length - 1]; })(stk2) < temp))) { /* push */
                    (stk.push(/* pop */ stk2.pop()) > 0);
                }
                ;
                /* push */ (stk2.push(temp) > 0);
            }
        }
        ;
        while (( /* isEmpty */(stk2.length == 0) === false)) { /* push */
            (stk.push(/* pop */ stk2.pop()) > 0);
        }
        ;
    };
    StackExercise.bottomInsert = function (stk, element) {
        var temp;
        if ( /* isEmpty */(stk.length == 0)) /* push */
            (stk.push(element) > 0);
        else {
            temp = /* pop */ stk.pop();
            StackExercise.bottomInsert(stk, element);
            /* push */ (stk.push(temp) > 0);
        }
    };
    StackExercise.reverseStack2 = function (stk) {
        var que = ([]);
        while (( /* isEmpty */(stk.length == 0) === false)) { /* add */
            (que.push(/* pop */ stk.pop()) > 0);
        }
        ;
        while (( /* isEmpty */(que.length == 0) === false)) { /* push */
            (stk.push(/* pop */ que.pop()) > 0);
        }
        ;
    };
    StackExercise.reverseKElementInStack = function (stk, k) {
        var que = ([]);
        var i = 0;
        while (( /* isEmpty */(stk.length == 0) === false && i < k)) {
            {
                /* add */ (que.push(/* pop */ stk.pop()) > 0);
                i++;
            }
        }
        ;
        while (( /* isEmpty */(que.length == 0) === false)) { /* push */
            (stk.push(/* pop */ que.pop()) > 0);
        }
        ;
    };
    StackExercise.reverseQueue = function (que) {
        var stk = ([]);
        while (( /* isEmpty */(que.length == 0) === false)) { /* push */
            (stk.push(/* pop */ que.pop()) > 0);
        }
        ;
        while (( /* isEmpty */(stk.length == 0) === false)) { /* add */
            (que.push(/* pop */ stk.pop()) > 0);
        }
        ;
    };
    StackExercise.reverseKElementInQueue = function (que, k) {
        var stk = ([]);
        var i = 0;
        var diff;
        var temp;
        while (( /* isEmpty */(que.length == 0) === false && i < k)) {
            {
                /* push */ (stk.push(/* pop */ que.pop()) > 0);
                i++;
            }
        }
        ;
        while (( /* isEmpty */(stk.length == 0) === false)) {
            {
                /* add */ (que.push(/* pop */ stk.pop()) > 0);
            }
        }
        ;
        diff = /* size */ que.length - k;
        while ((diff > 0)) {
            {
                temp = /* pop */ que.pop();
                /* add */ (que.push(temp) > 0);
                diff -= 1;
            }
        }
        ;
    };
    StackExercise.main7 = function (args) {
        var stk = ([]);
        /* push */ (stk.push(1) > 0);
        /* push */ (stk.push(2) > 0);
        /* push */ (stk.push(3) > 0);
        /* push */ (stk.push(4) > 0);
        /* push */ (stk.push(5) > 0);
        console.info(stk);
    };
    StackExercise.main8 = function (args) {
        var stk = ([]);
        /* push */ (stk.push(-2) > 0);
        /* push */ (stk.push(13) > 0);
        /* push */ (stk.push(16) > 0);
        /* push */ (stk.push(-6) > 0);
        /* push */ (stk.push(40) > 0);
        console.info(stk);
        StackExercise.reverseStack2(stk);
        console.info(stk);
        StackExercise.reverseKElementInStack(stk, 2);
        console.info(stk);
        var que = ([]);
        /* add */ (que.push(1) > 0);
        /* add */ (que.push(2) > 0);
        /* add */ (que.push(3) > 0);
        /* add */ (que.push(4) > 0);
        /* add */ (que.push(5) > 0);
        /* add */ (que.push(6) > 0);
        console.info(que);
        StackExercise.reverseQueue(que);
        console.info(que);
        StackExercise.reverseKElementInQueue(que, 2);
        console.info(que);
    };
    StackExercise.maxDepthParenthesis = function (expn, size) {
        var stk = ([]);
        var maxDepth = 0;
        var depth = 0;
        var ch;
        for (var i = 0; i < size; i++) {
            {
                ch = expn.charAt(i);
                if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) == '('.charCodeAt(0)) {
                    /* push */ (stk.push(ch) > 0);
                    depth += 1;
                }
                else if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) == ')'.charCodeAt(0)) {
                    /* pop */ stk.pop();
                    depth -= 1;
                }
                if (depth > maxDepth)
                    maxDepth = depth;
            }
            ;
        }
        return maxDepth;
    };
    StackExercise.maxDepthParenthesis2 = function (expn, size) {
        var maxDepth = 0;
        var depth = 0;
        var ch;
        for (var i = 0; i < size; i++) {
            {
                ch = expn.charAt(i);
                if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) == '('.charCodeAt(0))
                    depth += 1;
                else if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) == ')'.charCodeAt(0))
                    depth -= 1;
                if (depth > maxDepth)
                    maxDepth = depth;
            }
            ;
        }
        return maxDepth;
    };
    StackExercise.main9 = function (args) {
        var expn = "((((A)))((((BBB()))))()()()())";
        var size = expn.length;
        var value = StackExercise.maxDepthParenthesis(expn, size);
        var value2 = StackExercise.maxDepthParenthesis2(expn, size);
        console.info("Given expn " + expn);
        console.info("Max depth parenthesis is " + value);
        console.info("Max depth parenthesis is " + value2);
    };
    StackExercise.longestContBalParen = function (string, size) {
        var stk = ([]);
        /* push */ (stk.push(-1) > 0);
        var length = 0;
        for (var i = 0; i < size; i++) {
            {
                if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(string.charAt(i)) == '('.charCodeAt(0)) /* push */
                    (stk.push(i) > 0);
                else {
                    /* pop */ stk.pop();
                    if ( /* size */stk.length !== 0)
                        length = Math.max(length, i - /* peek */ (function (s) { return s[s.length - 1]; })(stk));
                    else /* push */
                        (stk.push(i) > 0);
                }
            }
            ;
        }
        return length;
    };
    StackExercise.main10 = function (args) {
        var expn = "())((()))(())()(()";
        var size = expn.length;
        var value = StackExercise.longestContBalParen(expn, size);
        console.info("longestContBalParen " + value);
    };
    StackExercise.reverseParenthesis = function (expn, size) {
        var stk = ([]);
        var openCount = 0;
        var closeCount = 0;
        var ch;
        if (size % 2 === 1) {
            console.info("Invalid odd length " + size);
            return -1;
        }
        for (var i = 0; i < size; i++) {
            {
                ch = expn.charAt(i);
                if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) == '('.charCodeAt(0)) /* push */
                    (stk.push(ch) > 0);
                else if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) == ')'.charCodeAt(0))
                    if ( /* size */stk.length !== 0 && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(/* peek */ (function (s) { return s[s.length - 1]; })(stk)) == '('.charCodeAt(0)) /* pop */
                        stk.pop();
                    else /* push */
                        (stk.push(')') > 0);
            }
            ;
        }
        while (( /* size */stk.length !== 0)) {
            {
                if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(/* pop */ stk.pop()) == '('.charCodeAt(0))
                    openCount += 1;
                else
                    closeCount += 1;
            }
        }
        ;
        var reversal = (Math.ceil(openCount / 2.0) | 0) + (Math.ceil(closeCount / 2.0) | 0);
        return reversal;
    };
    StackExercise.main11 = function (args) {
        var expn = "())((()))(())()(()()()()))";
        var expn2 = ")(())(((";
        var size = expn2.length;
        var value = StackExercise.reverseParenthesis(expn2, size);
        console.info("Given expn : " + expn2);
        console.info("reverse Parenthesis is : " + value);
    };
    StackExercise.findDuplicateParenthesis = function (expn, size) {
        var stk = ([]);
        var ch;
        var count;
        for (var i = 0; i < size; i++) {
            {
                ch = expn.charAt(i);
                if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) == ')'.charCodeAt(0)) {
                    count = 0;
                    while (( /* size */stk.length !== 0 && (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(/* peek */ (function (s) { return s[s.length - 1]; })(stk)) != '('.charCodeAt(0))) {
                        {
                            /* pop */ stk.pop();
                            count += 1;
                        }
                    }
                    ;
                    if (count <= 1)
                        return true;
                }
                else /* push */
                    (stk.push(ch) > 0);
            }
            ;
        }
        return false;
    };
    StackExercise.main12 = function (args) {
        var expn = "(((a+b))+c)";
        console.info("Given expn : " + expn);
        var size = expn.length;
        var value = StackExercise.findDuplicateParenthesis(expn, size);
        console.info("Duplicate Found : " + value);
    };
    StackExercise.printParenthesisNumber = function (expn, size) {
        var ch;
        var stk = ([]);
        var output = "";
        var count = 1;
        for (var i = 0; i < size; i++) {
            {
                ch = expn.charAt(i);
                if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) == '('.charCodeAt(0)) {
                    /* push */ (stk.push(count) > 0);
                    output += count;
                    count += 1;
                }
                else if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(ch) == ')'.charCodeAt(0))
                    output += /* pop */ stk.pop();
            }
            ;
        }
        console.info("Parenthesis Count ");
        console.info(output);
    };
    StackExercise.main13 = function (args) {
        var expn1 = "(((a+(b))+(c+d)))";
        var expn2 = "(((a+b))+c)(((";
        var size = expn1.length;
        console.info("Given expn " + expn1);
        StackExercise.printParenthesisNumber(expn1, size);
        size = expn2.length;
        console.info("\nGiven expn " + expn2);
        StackExercise.printParenthesisNumber(expn2, size);
    };
    StackExercise.nextLargerElement = function (arr, size) {
        var output = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        var outIndex = 0;
        var next;
        for (var i = 0; i < size; i++) {
            {
                next = -1;
                for (var j = i + 1; j < size; j++) {
                    {
                        if (arr[i] < arr[j]) {
                            next = arr[j];
                            break;
                        }
                    }
                    ;
                }
                output[outIndex++] = next;
            }
            ;
        }
        for (var index8375 = 0; index8375 < output.length; index8375++) {
            var val = output[index8375];
            console.info(val + " ");
        }
    };
    StackExercise.nextLargerElement2 = function (arr, size) {
        var stk = ([]);
        var output = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        var index = 0;
        var curr;
        for (var i = 0; i < size; i++) {
            {
                curr = arr[i];
                while (( /* isEmpty */(stk.length == 0) === false && arr[ /* peek */(function (s) { return s[s.length - 1]; })(stk)] <= curr)) {
                    {
                        index = /* pop */ stk.pop();
                        output[index] = curr;
                    }
                }
                ;
                /* push */ (stk.push(i) > 0);
            }
            ;
        }
        while (( /* isEmpty */(stk.length == 0) === false)) {
            {
                index = /* pop */ stk.pop();
                output[index] = -1;
            }
        }
        ;
        for (var index8376 = 0; index8376 < output.length; index8376++) {
            var val = output[index8376];
            console.info(val + " ");
        }
    };
    StackExercise.nextSmallerElement = function (arr, size) {
        var stk = ([]);
        var output = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        var curr;
        var index;
        for (var i = 0; i < size; i++) {
            {
                curr = arr[i];
                while (( /* isEmpty */(stk.length == 0) === false && arr[ /* peek */(function (s) { return s[s.length - 1]; })(stk)] > curr)) {
                    {
                        index = /* pop */ stk.pop();
                        output[index] = curr;
                    }
                }
                ;
                /* push */ (stk.push(i) > 0);
            }
            ;
        }
        while (( /* isEmpty */(stk.length == 0) === false)) {
            {
                index = /* pop */ stk.pop();
                output[index] = -1;
            }
        }
        ;
        for (var index8377 = 0; index8377 < output.length; index8377++) {
            var val = output[index8377];
            console.info(val + " ");
        }
    };
    StackExercise.main14 = function (args) {
        var arr = [13, 21, 3, 6, 20, 3];
        var size = arr.length;
        StackExercise.nextLargerElement(arr, size);
        StackExercise.nextLargerElement2(arr, size);
        StackExercise.nextSmallerElement(arr, size);
    };
    StackExercise.nextLargerElementCircular = function (arr, size) {
        var stk = ([]);
        var curr;
        var index;
        var output = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(size);
        for (var i = 0; i < (2 * size - 1); i++) {
            {
                curr = arr[i % size];
                while (( /* isEmpty */(stk.length == 0) === false && arr[ /* peek */(function (s) { return s[s.length - 1]; })(stk)] <= curr)) {
                    {
                        index = /* pop */ stk.pop();
                        output[index] = curr;
                    }
                }
                ;
                /* push */ (stk.push(i % size) > 0);
            }
            ;
        }
        while (( /* isEmpty */(stk.length == 0) === false)) {
            {
                index = /* pop */ stk.pop();
                output[index] = -1;
            }
        }
        ;
        for (var index8378 = 0; index8378 < output.length; index8378++) {
            var val = output[index8378];
            console.info(val + " ");
        }
    };
    StackExercise.main15 = function (args) {
        var arr = [6, 3, 9, 8, 10, 2, 1, 15, 7];
        var size = arr.length;
        StackExercise.nextLargerElementCircular(arr, size);
    };
    StackExercise.RottenFruitUtil = function (arr, maxCol, maxRow, currCol, currRow, traversed, day) {
        if (currCol < 0 || currCol >= maxCol || currRow < 0 || currRow >= maxRow)
            return;
        if (traversed[currCol][currRow] <= day || arr[currCol][currRow] === 0)
            return;
        traversed[currCol][currRow] = day;
        StackExercise.RottenFruitUtil(arr, maxCol, maxRow, currCol - 1, currRow, traversed, day + 1);
        StackExercise.RottenFruitUtil(arr, maxCol, maxRow, currCol + 1, currRow, traversed, day + 1);
        StackExercise.RottenFruitUtil(arr, maxCol, maxRow, currCol, currRow + 1, traversed, day + 1);
        StackExercise.RottenFruitUtil(arr, maxCol, maxRow, currCol, currRow - 1, traversed, day + 1);
    };
    StackExercise.RottenFruit = function (arr, maxCol, maxRow) {
        var traversed = (function (dims) { var allocate = function (dims) { if (dims.length == 0) {
            return 0;
        }
        else {
            var array = [];
            for (var i = 0; i < dims[0]; i++) {
                array.push(allocate(dims.slice(1)));
            }
            return array;
        } }; return allocate(dims); })([maxCol, maxRow]);
        for (var i = 0; i < maxCol; i++) {
            {
                for (var j = 0; j < maxRow; j++) {
                    {
                        traversed[i][j] = 2147483647;
                    }
                    ;
                }
            }
            ;
        }
        for (var i = 0; i < maxCol - 1; i++) {
            {
                for (var j = 0; j < maxRow - 1; j++) {
                    {
                        if (arr[i][j] === 2)
                            StackExercise.RottenFruitUtil(arr, maxCol, maxRow, i, j, traversed, 0);
                    }
                    ;
                }
            }
            ;
        }
        var maxDay = 0;
        for (var i = 0; i < maxCol - 1; i++) {
            {
                for (var j = 0; j < maxRow - 1; j++) {
                    {
                        if (arr[i][j] === 1) {
                            if (traversed[i][j] === 2147483647)
                                return -1;
                            if (maxDay < traversed[i][j])
                                maxDay = traversed[i][j];
                        }
                    }
                    ;
                }
            }
            ;
        }
        return maxDay;
    };
    StackExercise.main16 = function (args) {
        var arr = [[1, 0, 1, 1, 0], [2, 1, 0, 1, 0], [0, 0, 0, 2, 1], [0, 2, 0, 0, 1], [1, 1, 0, 0, 1]];
        console.info(StackExercise.RottenFruit(arr, 5, 5));
    };
    StackExercise.StepsOfKnightUtil = function (size, currCol, currRow, traversed, dist) {
        if (currCol < 0 || currCol >= size || currRow < 0 || currRow >= size)
            return;
        if (traversed[currCol][currRow] <= dist)
            return;
        traversed[currCol][currRow] = dist;
        StackExercise.StepsOfKnightUtil(size, currCol - 2, currRow - 1, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol - 2, currRow + 1, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol + 2, currRow - 1, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol + 2, currRow + 1, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol - 1, currRow - 2, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol + 1, currRow - 2, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol - 1, currRow + 2, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol + 1, currRow + 2, traversed, dist + 1);
    };
    StackExercise.StepsOfKnight = function (size, srcX, srcY, dstX, dstY) {
        var traversed = (function (dims) { var allocate = function (dims) { if (dims.length == 0) {
            return 0;
        }
        else {
            var array = [];
            for (var i = 0; i < dims[0]; i++) {
                array.push(allocate(dims.slice(1)));
            }
            return array;
        } }; return allocate(dims); })([size, size]);
        for (var i = 0; i < size; i++) {
            {
                for (var j = 0; j < size; j++) {
                    {
                        traversed[i][j] = 2147483647;
                    }
                    ;
                }
            }
            ;
        }
        StackExercise.StepsOfKnightUtil(size, srcX - 1, srcY - 1, traversed, 0);
        var retval = traversed[dstX - 1][dstY - 1];
        return retval;
    };
    StackExercise.main17 = function (args) {
        console.info(StackExercise.StepsOfKnight(20, 10, 10, 20, 20));
    };
    StackExercise.DistNearestFillUtil = function (arr, maxCol, maxRow, currCol, currRow, traversed, dist) {
        if (currCol < 0 || currCol >= maxCol || currRow < 0 || currRow >= maxRow)
            return;
        if (traversed[currCol][currRow] <= dist)
            return;
        traversed[currCol][currRow] = dist;
        StackExercise.DistNearestFillUtil(arr, maxCol, maxRow, currCol - 1, currRow, traversed, dist + 1);
        StackExercise.DistNearestFillUtil(arr, maxCol, maxRow, currCol + 1, currRow, traversed, dist + 1);
        StackExercise.DistNearestFillUtil(arr, maxCol, maxRow, currCol, currRow + 1, traversed, dist + 1);
        StackExercise.DistNearestFillUtil(arr, maxCol, maxRow, currCol, currRow - 1, traversed, dist + 1);
    };
    StackExercise.DistNearestFill = function (arr, maxCol, maxRow) {
        var traversed = (function (dims) { var allocate = function (dims) { if (dims.length == 0) {
            return 0;
        }
        else {
            var array = [];
            for (var i = 0; i < dims[0]; i++) {
                array.push(allocate(dims.slice(1)));
            }
            return array;
        } }; return allocate(dims); })([maxCol, maxRow]);
        for (var i = 0; i < maxCol; i++) {
            {
                for (var j = 0; j < maxRow; j++) {
                    {
                        traversed[i][j] = 2147483647;
                    }
                    ;
                }
            }
            ;
        }
        for (var i = 0; i < maxCol; i++) {
            {
                for (var j = 0; j < maxRow; j++) {
                    {
                        if (arr[i][j] === 1)
                            StackExercise.DistNearestFillUtil(arr, maxCol, maxRow, i, j, traversed, 0);
                    }
                    ;
                }
            }
            ;
        }
        for (var i = 0; i < maxCol; i++) {
            {
                for (var j = 0; j < maxRow; j++) {
                    {
                        console.info("" + traversed[i][j]);
                    }
                    ;
                }
                console.info("\n");
            }
            ;
        }
    };
    StackExercise.main18 = function (args) {
        var arr = [[1, 0, 1, 1, 0], [1, 1, 0, 1, 0], [0, 0, 0, 0, 1], [0, 0, 0, 0, 1], [0, 0, 0, 0, 1]];
        StackExercise.DistNearestFill(arr, 5, 5);
    };
    StackExercise.findLargestIslandUtil = function (arr, maxCol, maxRow, currCol, currRow, value, traversed) {
        if (currCol < 0 || currCol >= maxCol || currRow < 0 || currRow >= maxRow)
            return 0;
        if (traversed[currCol][currRow] === 1 || arr[currCol][currRow] !== value)
            return 0;
        traversed[currCol][currRow] = 1;
        return 1 + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol - 1, currRow - 1, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol - 1, currRow, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol - 1, currRow + 1, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol, currRow - 1, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol, currRow + 1, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol + 1, currRow - 1, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol + 1, currRow, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol + 1, currRow + 1, value, traversed);
    };
    StackExercise.findLargestIsland = function (arr, maxCol, maxRow) {
        var maxVal = 0;
        var currVal = 0;
        var traversed = (function (dims) { var allocate = function (dims) { if (dims.length == 0) {
            return 0;
        }
        else {
            var array = [];
            for (var i = 0; i < dims[0]; i++) {
                array.push(allocate(dims.slice(1)));
            }
            return array;
        } }; return allocate(dims); })([maxCol, maxRow]);
        for (var i = 0; i < maxCol; i++) {
            {
                for (var j = 0; j < maxRow; j++) {
                    {
                        traversed[i][j] = 2147483647;
                    }
                    ;
                }
            }
            ;
        }
        for (var i = 0; i < maxCol; i++) {
            {
                for (var j = 0; j < maxRow; j++) {
                    {
                        {
                            currVal = StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, i, j, arr[i][j], traversed);
                            if (currVal > maxVal)
                                maxVal = currVal;
                        }
                        ;
                    }
                    ;
                }
            }
            ;
        }
        return maxVal;
    };
    StackExercise.main19 = function (args) {
        var arr = [[1, 0, 1, 1, 0], [1, 0, 0, 1, 0], [0, 1, 1, 1, 1], [0, 1, 0, 0, 0], [1, 1, 0, 0, 1]];
        console.info("Largest Island : " + StackExercise.findLargestIsland(arr, 5, 5));
    };
    StackExercise.isKnown = function (relation, a, b) {
        if (relation[a][b] === 1)
            return true;
        return false;
    };
    StackExercise.findCelebrity = function (relation, count) {
        var stk = ([]);
        var first = 0;
        var second = 0;
        for (var i = 0; i < count; i++) {
            {
                /* push */ (stk.push(i) > 0);
            }
            ;
        }
        first = /* pop */ stk.pop();
        while (( /* size */stk.length !== 0)) {
            {
                second = /* pop */ stk.pop();
                if (StackExercise.isKnown(relation, first, second))
                    first = second;
            }
        }
        ;
        for (var i = 0; i < count; i++) {
            {
                if (first !== i && StackExercise.isKnown(relation, first, i))
                    return -1;
                if (first !== i && StackExercise.isKnown(relation, i, first) === false)
                    return -1;
            }
            ;
        }
        return first;
    };
    StackExercise.findCelebrity2 = function (relation, count) {
        var first = 0;
        var second = 1;
        for (var i = 0; i < (count - 1); i++) {
            {
                if (StackExercise.isKnown(relation, first, second))
                    first = second;
                second = second + 1;
            }
            ;
        }
        for (var i = 0; i < count; i++) {
            {
                if (first !== i && StackExercise.isKnown(relation, first, i))
                    return -1;
                if (first !== i && StackExercise.isKnown(relation, i, first) === false)
                    return -1;
            }
            ;
        }
        return first;
    };
    StackExercise.main20 = function (args) {
        var arr = [[1, 0, 1, 1, 0], [1, 0, 0, 1, 0], [0, 0, 1, 1, 1], [0, 0, 0, 0, 0], [1, 1, 0, 1, 1]];
        console.info("Celebrity : " + StackExercise.findCelebrity(arr, 5));
        console.info("Celebrity : " + StackExercise.findCelebrity2(arr, 5));
    };
    StackExercise.IsMinHeap = function (arr, size) {
        for (var i = 0; i <= ((size - 2) / 2 | 0); i++) {
            {
                if (2 * i + 1 < size) {
                    if (arr[i] > arr[2 * i + 1])
                        return 0;
                }
                if (2 * i + 2 < size) {
                    if (arr[i] > arr[2 * i + 2])
                        return 0;
                }
            }
            ;
        }
        return 1;
    };
    StackExercise.IsMaxHeap = function (arr, size) {
        for (var i = 0; i <= ((size - 2) / 2 | 0); i++) {
            {
                if (2 * i + 1 < size) {
                    if (arr[i] < arr[2 * i + 1])
                        return 0;
                }
                if (2 * i + 2 < size) {
                    if (arr[i] < arr[2 * i + 2])
                        return 0;
                }
            }
            ;
        }
        return 1;
    };
    return StackExercise;
}());
StackExercise["__class"] = "StackExercise";
StackExercise.main(null);
