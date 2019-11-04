/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class StackExercise {
    public static isBalancedParenthesis(expn : string) : boolean {
        let stk : Array<string> = <any>([]);
        {
            let array8370 = /* toCharArray */(expn).split('');
            for(let index8369=0; index8369 < array8370.length; index8369++) {
                let ch = array8370[index8369];
                {
                    switch((ch).charCodeAt(0)) {
                    case 123 /* '{' */:
                    case 91 /* '[' */:
                    case 40 /* '(' */:
                        /* push */(stk.push(ch)>0);
                        break;
                    case 125 /* '}' */:
                        if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(/* pop */stk.pop()) != '{'.charCodeAt(0)) {
                            return false;
                        }
                        break;
                    case 93 /* ']' */:
                        if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(/* pop */stk.pop()) != '['.charCodeAt(0)) {
                            return false;
                        }
                        break;
                    case 41 /* ')' */:
                        if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(/* pop */stk.pop()) != '('.charCodeAt(0)) {
                            return false;
                        }
                        break;
                    }
                }
            }
        }
        return /* isEmpty */(stk.length == 0);
    }

    public static main(args : string[]) {
        let expn : string = "{()}[]";
        let value : boolean = StackExercise.isBalancedParenthesis(expn);
        console.info("Given Expn:" + expn);
        console.info("Result after isParenthesisMatched:" + value);
    }

    public static insertAtBottom<T>(stk : Array<T>, value : T) {
        if(/* isEmpty */(stk.length == 0)) {
            /* push */(stk.push(value)>0);
        } else {
            let out : T = /* pop */stk.pop();
            StackExercise.insertAtBottom<any>(stk, value);
            /* push */(stk.push(out)>0);
        }
    }

    public static reverseStack<T>(stk : Array<T>) {
        if(/* isEmpty */(stk.length == 0)) {
            return;
        } else {
            let value : T = /* pop */stk.pop();
            StackExercise.reverseStack<any>(stk);
            StackExercise.insertAtBottom<any>(stk, value);
        }
    }

    public static precedence(x : number) : number {
        if(x == '('.charCodeAt(0)) {
            return (0);
        }
        if(x == '+'.charCodeAt(0) || x == '-'.charCodeAt(0)) {
            return (1);
        }
        if(x == '*'.charCodeAt(0) || x == '/'.charCodeAt(0) || x == '%'.charCodeAt(0)) return (2);
        if(x == '^'.charCodeAt(0)) {
            return (3);
        }
        return (4);
    }

    public static infixToPostfix$java_lang_String(expn : string) : string {
        let output : string = "";
        let out : string[] = StackExercise.infixToPostfix$char_A(/* toCharArray */(expn).split(''));
        for(let index8371=0; index8371 < out.length; index8371++) {
            let ch = out[index8371];
            {
                output = output + ch;
            }
        }
        return output;
    }

    public static infixToPostfix(expn? : any) : any {
        if(((typeof expn === 'string') || expn === null)) {
            return <any>StackExercise.infixToPostfix$java_lang_String(expn);
        } else if(((expn != null && expn instanceof <any>Array && (expn.length==0 || expn[0] == null ||(typeof expn[0] === 'string'))) || expn === null)) {
            return <any>StackExercise.infixToPostfix$char_A(expn);
        } else throw new Error('invalid overload');
    }

    public static infixToPostfix$char_A(expn : string[]) : string[] {
        let stk : Array<string> = <any>([]);
        let output : string = "";
        let out : string;
        for(let index8372=0; index8372 < expn.length; index8372++) {
            let ch = expn[index8372];
            {
                if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) <= '9'.charCodeAt(0) && (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) >= '0'.charCodeAt(0)) {
                    output = output + ch;
                } else {
                    switch((ch).charCodeAt(0)) {
                    case 43 /* '+' */:
                    case 45 /* '-' */:
                    case 42 /* '*' */:
                    case 47 /* '/' */:
                    case 37 /* '%' */:
                    case 94 /* '^' */:
                        while((/* isEmpty */(stk.length == 0) === false)) {{
                            output = output + " " + out;
                        }};
                        /* push */(stk.push(ch)>0);
                        output = output + " ";
                        break;
                    case 40 /* '(' */:
                        /* push */(stk.push(ch)>0);
                        break;
                    case 41 /* ')' */:
                        while((/* isEmpty */(stk.length == 0) === false)) {{
                            output = output + " " + out + " ";
                        }};
                        break;
                    }
                }
            }
        }
        while((/* isEmpty */(stk.length == 0) === false)) {{
            output = output + out + " ";
        }};
        return /* toCharArray */(output).split('');
    }

    public static main3(args : string[]) {
        let expn : string = "10+((3))*5/(16-4)";
        let value : string = StackExercise.infixToPostfix$java_lang_String(expn);
        console.info("Infix Expn: " + expn);
        console.info("Postfix Expn: " + value);
    }

    public static infixToPrefix(expn : string) : string {
        let arr : string[] = /* toCharArray */(expn).split('');
        StackExercise.reverseString(arr);
        StackExercise.replaceParanthesis(arr);
        arr = StackExercise.infixToPostfix$char_A(arr);
        StackExercise.reverseString(arr);
        expn = arr.join('');
        return expn;
    }

    public static replaceParanthesis(a : string[]) {
        let lower : number = 0;
        let upper : number = a.length - 1;
        while((lower <= upper)) {{
            if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(a[lower]) == '('.charCodeAt(0)) {
                a[lower] = ')';
            } else if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(a[lower]) == ')'.charCodeAt(0)) {
                a[lower] = '(';
            }
            lower++;
        }};
    }

    public static reverseString(expn : string[]) {
        let lower : number = 0;
        let upper : number = expn.length - 1;
        let tempChar : string;
        while((lower < upper)) {{
            tempChar = expn[lower];
            expn[lower] = expn[upper];
            expn[upper] = tempChar;
            lower++;
            upper--;
        }};
    }

    public static main4(args : string[]) {
        let expn : string = "10+((3))*5/(16-4)";
        let value : string = StackExercise.infixToPrefix(expn);
        console.info("Infix Expn: " + expn);
        console.info("Prefix Expn: " + value);
    }

    public static StockSpanRange(arr : number[]) : number[] {
        let SR : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(arr.length);
        SR[0] = 1;
        for(let i : number = 1; i < arr.length; i++) {{
            SR[i] = 1;
            for(let j : number = i - 1; (j >= 0) && (arr[i] >= arr[j]); j--) {{
                SR[i]++;
            };}
        };}
        return SR;
    }

    public static StockSpanRange2(arr : number[]) : number[] {
        let stk : Array<number> = <any>([]);
        let SR : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(arr.length);
        /* push */(stk.push(0)>0);
        SR[0] = 1;
        for(let i : number = 1; i < arr.length; i++) {{
            while((!/* isEmpty */(stk.length == 0) && arr[/* peek */((s) => { return s[s.length-1]; })(stk)] <= arr[i])) {{
                /* pop */stk.pop();
            }};
            SR[i] = (/* isEmpty */(stk.length == 0))?(i + 1):(i - /* peek */((s) => { return s[s.length-1]; })(stk));
            /* push */(stk.push(i)>0);
        };}
        return SR;
    }

    public static main5(args : string[]) {
        let arr : number[] = [6, 5, 4, 3, 2, 4, 5, 7, 9];
        let size : number = arr.length;
        let value : number[] = StackExercise.StockSpanRange(arr);
        console.info("\nStockSpanRange : ");
        for(let index8373=0; index8373 < value.length; index8373++) {
            let val = value[index8373];
            console.info(" " + val)
        }
        value = StackExercise.StockSpanRange2(arr);
        console.info("\nStockSpanRange : ");
        for(let index8374=0; index8374 < value.length; index8374++) {
            let val = value[index8374];
            console.info(" " + val)
        }
    }

    public static GetMaxArea(arr : number[]) : number {
        let size : number = arr.length;
        let maxArea : number = -1;
        let currArea : number;
        let minHeight : number = 0;
        for(let i : number = 1; i < size; i++) {{
            minHeight = arr[i];
            for(let j : number = i - 1; j >= 0; j--) {{
                if(minHeight > arr[j]) {
                    minHeight = arr[j];
                }
                currArea = minHeight * (i - j + 1);
                if(maxArea < currArea) {
                    maxArea = currArea;
                }
            };}
        };}
        return maxArea;
    }

    public static GetMaxArea2(arr : number[]) : number {
        let size : number = arr.length;
        let stk : Array<number> = <any>([]);
        let maxArea : number = 0;
        let top : number;
        let topArea : number;
        let i : number = 0;
        while((i < size)) {{
            while(((i < size) && (/* isEmpty */(stk.length == 0) || arr[/* peek */((s) => { return s[s.length-1]; })(stk)] <= arr[i]))) {{
                /* push */(stk.push(i)>0);
                i++;
            }};
            while((!/* isEmpty */(stk.length == 0) && (i === size || arr[/* peek */((s) => { return s[s.length-1]; })(stk)] > arr[i]))) {{
                top = /* peek */((s) => { return s[s.length-1]; })(stk);
                /* pop */stk.pop();
                topArea = arr[top] * (/* isEmpty */(stk.length == 0)?i:i - /* peek */((s) => { return s[s.length-1]; })(stk) - 1);
                if(maxArea < topArea) {
                    maxArea = topArea;
                }
            }};
        }};
        return maxArea;
    }

    public static main6(args : string[]) {
        let arr : number[] = [7, 6, 5, 4, 4, 1, 6, 3, 1];
        let size : number = arr.length;
        let value : number = StackExercise.GetMaxArea(arr);
        console.info("GetMaxArea :: " + value);
        value = StackExercise.GetMaxArea2(arr);
        console.info("GetMaxArea :: " + value);
    }

    public static sortedInsert(stk : Array<number>, element : number) {
        let temp : number;
        if(/* isEmpty */(stk.length == 0) || element > /* peek */((s) => { return s[s.length-1]; })(stk)) /* push */(stk.push(element)>0); else {
            temp = /* pop */stk.pop();
            StackExercise.sortedInsert(stk, element);
            /* push */(stk.push(temp)>0);
        }
    }

    public static sortStack(stk : Array<number>) {
        let temp : number;
        if(/* isEmpty */(stk.length == 0) === false) {
            temp = /* pop */stk.pop();
            StackExercise.sortStack(stk);
            /* push */(stk.push(temp)>0);
        }
    }

    public static sortStack2(stk : Array<number>) {
        let temp : number;
        let stk2 : Array<number> = <any>([]);
        while((/* isEmpty */(stk.length == 0) === false)) {{
            temp = /* pop */stk.pop();
            while(((/* isEmpty */(stk.length == 0) === false) && (/* peek */((s) => { return s[s.length-1]; })(stk2) < temp))) {/* push */(stk.push(/* pop */stk2.pop())>0)};
            /* push */(stk2.push(temp)>0);
        }};
        while((/* isEmpty */(stk2.length == 0) === false)) {/* push */(stk.push(/* pop */stk2.pop())>0)};
    }

    public static bottomInsert(stk : Array<number>, element : number) {
        let temp : number;
        if(/* isEmpty */(stk.length == 0)) /* push */(stk.push(element)>0); else {
            temp = /* pop */stk.pop();
            StackExercise.bottomInsert(stk, element);
            /* push */(stk.push(temp)>0);
        }
    }

    public static reverseStack2(stk : Array<number>) {
        let que : Array<number> = <any>([]);
        while((/* isEmpty */(stk.length == 0) === false)) {/* add */(que.push(/* pop */stk.pop())>0)};
        while((/* isEmpty */(que.length == 0) === false)) {/* push */(stk.push(/* pop */que.pop())>0)};
    }

    public static reverseKElementInStack(stk : Array<number>, k : number) {
        let que : Array<number> = <any>([]);
        let i : number = 0;
        while((/* isEmpty */(stk.length == 0) === false && i < k)) {{
            /* add */(que.push(/* pop */stk.pop())>0);
            i++;
        }};
        while((/* isEmpty */(que.length == 0) === false)) {/* push */(stk.push(/* pop */que.pop())>0)};
    }

    public static reverseQueue(que : Array<number>) {
        let stk : Array<number> = <any>([]);
        while((/* isEmpty */(que.length == 0) === false)) {/* push */(stk.push(/* pop */que.pop())>0)};
        while((/* isEmpty */(stk.length == 0) === false)) {/* add */(que.push(/* pop */stk.pop())>0)};
    }

    public static reverseKElementInQueue(que : Array<number>, k : number) {
        let stk : Array<number> = <any>([]);
        let i : number = 0;
        let diff : number;
        let temp : number;
        while((/* isEmpty */(que.length == 0) === false && i < k)) {{
            /* push */(stk.push(/* pop */que.pop())>0);
            i++;
        }};
        while((/* isEmpty */(stk.length == 0) === false)) {{
            /* add */(que.push(/* pop */stk.pop())>0);
        }};
        diff = /* size */(<number>que.length) - k;
        while((diff > 0)) {{
            temp = /* pop */que.pop();
            /* add */(que.push(temp)>0);
            diff -= 1;
        }};
    }

    public static main7(args : string[]) {
        let stk : Array<number> = <any>([]);
        /* push */(stk.push(1)>0);
        /* push */(stk.push(2)>0);
        /* push */(stk.push(3)>0);
        /* push */(stk.push(4)>0);
        /* push */(stk.push(5)>0);
        console.info(stk);
    }

    public static main8(args : string[]) {
        let stk : Array<number> = <any>([]);
        /* push */(stk.push(-2)>0);
        /* push */(stk.push(13)>0);
        /* push */(stk.push(16)>0);
        /* push */(stk.push(-6)>0);
        /* push */(stk.push(40)>0);
        console.info(stk);
        StackExercise.reverseStack2(stk);
        console.info(stk);
        StackExercise.reverseKElementInStack(stk, 2);
        console.info(stk);
        let que : Array<number> = <any>([]);
        /* add */(que.push(1)>0);
        /* add */(que.push(2)>0);
        /* add */(que.push(3)>0);
        /* add */(que.push(4)>0);
        /* add */(que.push(5)>0);
        /* add */(que.push(6)>0);
        console.info(que);
        StackExercise.reverseQueue(que);
        console.info(que);
        StackExercise.reverseKElementInQueue(que, 2);
        console.info(que);
    }

    public static maxDepthParenthesis(expn : string, size : number) : number {
        let stk : Array<string> = <any>([]);
        let maxDepth : number = 0;
        let depth : number = 0;
        let ch : string;
        for(let i : number = 0; i < size; i++) {{
            ch = expn.charAt(i);
            if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) == '('.charCodeAt(0)) {
                /* push */(stk.push(ch)>0);
                depth += 1;
            } else if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) == ')'.charCodeAt(0)) {
                /* pop */stk.pop();
                depth -= 1;
            }
            if(depth > maxDepth) maxDepth = depth;
        };}
        return maxDepth;
    }

    public static maxDepthParenthesis2(expn : string, size : number) : number {
        let maxDepth : number = 0;
        let depth : number = 0;
        let ch : string;
        for(let i : number = 0; i < size; i++) {{
            ch = expn.charAt(i);
            if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) == '('.charCodeAt(0)) depth += 1; else if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) == ')'.charCodeAt(0)) depth -= 1;
            if(depth > maxDepth) maxDepth = depth;
        };}
        return maxDepth;
    }

    public static main9(args : string[]) {
        let expn : string = "((((A)))((((BBB()))))()()()())";
        let size : number = expn.length;
        let value : number = StackExercise.maxDepthParenthesis(expn, size);
        let value2 : number = StackExercise.maxDepthParenthesis2(expn, size);
        console.info("Given expn " + expn);
        console.info("Max depth parenthesis is " + value);
        console.info("Max depth parenthesis is " + value2);
    }

    public static longestContBalParen(string : string, size : number) : number {
        let stk : Array<number> = <any>([]);
        /* push */(stk.push(-1)>0);
        let length : number = 0;
        for(let i : number = 0; i < size; i++) {{
            if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(string.charAt(i)) == '('.charCodeAt(0)) /* push */(stk.push(i)>0); else {
                /* pop */stk.pop();
                if(/* size */(<number>stk.length) !== 0) length = Math.max(length, i - /* peek */((s) => { return s[s.length-1]; })(stk)); else /* push */(stk.push(i)>0);
            }
        };}
        return length;
    }

    public static main10(args : string[]) {
        let expn : string = "())((()))(())()(()";
        let size : number = expn.length;
        let value : number = StackExercise.longestContBalParen(expn, size);
        console.info("longestContBalParen " + value);
    }

    public static reverseParenthesis(expn : string, size : number) : number {
        let stk : Array<string> = <any>([]);
        let openCount : number = 0;
        let closeCount : number = 0;
        let ch : string;
        if(size % 2 === 1) {
            console.info("Invalid odd length " + size);
            return -1;
        }
        for(let i : number = 0; i < size; i++) {{
            ch = expn.charAt(i);
            if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) == '('.charCodeAt(0)) /* push */(stk.push(ch)>0); else if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) == ')'.charCodeAt(0)) if(/* size */(<number>stk.length) !== 0 && (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(/* peek */((s) => { return s[s.length-1]; })(stk)) == '('.charCodeAt(0)) /* pop */stk.pop(); else /* push */(stk.push(')')>0);
        };}
        while((/* size */(<number>stk.length) !== 0)) {{
            if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(/* pop */stk.pop()) == '('.charCodeAt(0)) openCount += 1; else closeCount += 1;
        }};
        let reversal : number = (<number>Math.ceil(openCount / 2.0)|0) + (<number>Math.ceil(closeCount / 2.0)|0);
        return reversal;
    }

    public static main11(args : string[]) {
        let expn : string = "())((()))(())()(()()()()))";
        let expn2 : string = ")(())(((";
        let size : number = expn2.length;
        let value : number = StackExercise.reverseParenthesis(expn2, size);
        console.info("Given expn : " + expn2);
        console.info("reverse Parenthesis is : " + value);
    }

    public static findDuplicateParenthesis(expn : string, size : number) : boolean {
        let stk : Array<string> = <any>([]);
        let ch : string;
        let count : number;
        for(let i : number = 0; i < size; i++) {{
            ch = expn.charAt(i);
            if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) == ')'.charCodeAt(0)) {
                count = 0;
                while((/* size */(<number>stk.length) !== 0 && (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(/* peek */((s) => { return s[s.length-1]; })(stk)) != '('.charCodeAt(0))) {{
                    /* pop */stk.pop();
                    count += 1;
                }};
                if(count <= 1) return true;
            } else /* push */(stk.push(ch)>0);
        };}
        return false;
    }

    public static main12(args : string[]) {
        let expn : string = "(((a+b))+c)";
        console.info("Given expn : " + expn);
        let size : number = expn.length;
        let value : boolean = StackExercise.findDuplicateParenthesis(expn, size);
        console.info("Duplicate Found : " + value);
    }

    public static printParenthesisNumber(expn : string, size : number) {
        let ch : string;
        let stk : Array<number> = <any>([]);
        let output : string = "";
        let count : number = 1;
        for(let i : number = 0; i < size; i++) {{
            ch = expn.charAt(i);
            if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) == '('.charCodeAt(0)) {
                /* push */(stk.push(count)>0);
                output += count;
                count += 1;
            } else if((c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(ch) == ')'.charCodeAt(0)) output += /* pop */stk.pop();
        };}
        console.info("Parenthesis Count ");
        console.info(output);
    }

    public static main13(args : string[]) {
        let expn1 : string = "(((a+(b))+(c+d)))";
        let expn2 : string = "(((a+b))+c)(((";
        let size : number = expn1.length;
        console.info("Given expn " + expn1);
        StackExercise.printParenthesisNumber(expn1, size);
        size = expn2.length;
        console.info("\nGiven expn " + expn2);
        StackExercise.printParenthesisNumber(expn2, size);
    }

    public static nextLargerElement(arr : number[], size : number) {
        let output : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        let outIndex : number = 0;
        let next : number;
        for(let i : number = 0; i < size; i++) {{
            next = -1;
            for(let j : number = i + 1; j < size; j++) {{
                if(arr[i] < arr[j]) {
                    next = arr[j];
                    break;
                }
            };}
            output[outIndex++] = next;
        };}
        for(let index8375=0; index8375 < output.length; index8375++) {
            let val = output[index8375];
            console.info(val + " ")
        }
    }

    public static nextLargerElement2(arr : number[], size : number) {
        let stk : Array<number> = <any>([]);
        let output : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        let index : number = 0;
        let curr : number;
        for(let i : number = 0; i < size; i++) {{
            curr = arr[i];
            while((/* isEmpty */(stk.length == 0) === false && arr[/* peek */((s) => { return s[s.length-1]; })(stk)] <= curr)) {{
                index = /* pop */stk.pop();
                output[index] = curr;
            }};
            /* push */(stk.push(i)>0);
        };}
        while((/* isEmpty */(stk.length == 0) === false)) {{
            index = /* pop */stk.pop();
            output[index] = -1;
        }};
        for(let index8376=0; index8376 < output.length; index8376++) {
            let val = output[index8376];
            console.info(val + " ")
        }
    }

    public static nextSmallerElement(arr : number[], size : number) {
        let stk : Array<number> = <any>([]);
        let output : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        let curr : number;
        let index : number;
        for(let i : number = 0; i < size; i++) {{
            curr = arr[i];
            while((/* isEmpty */(stk.length == 0) === false && arr[/* peek */((s) => { return s[s.length-1]; })(stk)] > curr)) {{
                index = /* pop */stk.pop();
                output[index] = curr;
            }};
            /* push */(stk.push(i)>0);
        };}
        while((/* isEmpty */(stk.length == 0) === false)) {{
            index = /* pop */stk.pop();
            output[index] = -1;
        }};
        for(let index8377=0; index8377 < output.length; index8377++) {
            let val = output[index8377];
            console.info(val + " ")
        }
    }

    public static main14(args : string[]) {
        let arr : number[] = [13, 21, 3, 6, 20, 3];
        let size : number = arr.length;
        StackExercise.nextLargerElement(arr, size);
        StackExercise.nextLargerElement2(arr, size);
        StackExercise.nextSmallerElement(arr, size);
    }

    public static nextLargerElementCircular(arr : number[], size : number) {
        let stk : Array<number> = <any>([]);
        let curr : number;
        let index : number;
        let output : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(size);
        for(let i : number = 0; i < (2 * size - 1); i++) {{
            curr = arr[i % size];
            while((/* isEmpty */(stk.length == 0) === false && arr[/* peek */((s) => { return s[s.length-1]; })(stk)] <= curr)) {{
                index = /* pop */stk.pop();
                output[index] = curr;
            }};
            /* push */(stk.push(i % size)>0);
        };}
        while((/* isEmpty */(stk.length == 0) === false)) {{
            index = /* pop */stk.pop();
            output[index] = -1;
        }};
        for(let index8378=0; index8378 < output.length; index8378++) {
            let val = output[index8378];
            console.info(val + " ")
        }
    }

    public static main15(args : string[]) {
        let arr : number[] = [6, 3, 9, 8, 10, 2, 1, 15, 7];
        let size : number = arr.length;
        StackExercise.nextLargerElementCircular(arr, size);
    }

    public static RottenFruitUtil(arr : number[][], maxCol : number, maxRow : number, currCol : number, currRow : number, traversed : number[][], day : number) {
        if(currCol < 0 || currCol >= maxCol || currRow < 0 || currRow >= maxRow) return;
        if(traversed[currCol][currRow] <= day || arr[currCol][currRow] === 0) return;
        traversed[currCol][currRow] = day;
        StackExercise.RottenFruitUtil(arr, maxCol, maxRow, currCol - 1, currRow, traversed, day + 1);
        StackExercise.RottenFruitUtil(arr, maxCol, maxRow, currCol + 1, currRow, traversed, day + 1);
        StackExercise.RottenFruitUtil(arr, maxCol, maxRow, currCol, currRow + 1, traversed, day + 1);
        StackExercise.RottenFruitUtil(arr, maxCol, maxRow, currCol, currRow - 1, traversed, day + 1);
    }

    public static RottenFruit(arr : number[][], maxCol : number, maxRow : number) : number {
        let traversed : number[][] = <any> (function(dims) { let allocate = function(dims) { if(dims.length==0) { return 0; } else { let array = []; for(let i = 0; i < dims[0]; i++) { array.push(allocate(dims.slice(1))); } return array; }}; return allocate(dims);})([maxCol, maxRow]);
        for(let i : number = 0; i < maxCol; i++) {{
            for(let j : number = 0; j < maxRow; j++) {{
                traversed[i][j] = 2147483647;
            };}
        };}
        for(let i : number = 0; i < maxCol - 1; i++) {{
            for(let j : number = 0; j < maxRow - 1; j++) {{
                if(arr[i][j] === 2) StackExercise.RottenFruitUtil(arr, maxCol, maxRow, i, j, traversed, 0);
            };}
        };}
        let maxDay : number = 0;
        for(let i : number = 0; i < maxCol - 1; i++) {{
            for(let j : number = 0; j < maxRow - 1; j++) {{
                if(arr[i][j] === 1) {
                    if(traversed[i][j] === 2147483647) return -1;
                    if(maxDay < traversed[i][j]) maxDay = traversed[i][j];
                }
            };}
        };}
        return maxDay;
    }

    public static main16(args : string[]) {
        let arr : number[][] = [[1, 0, 1, 1, 0], [2, 1, 0, 1, 0], [0, 0, 0, 2, 1], [0, 2, 0, 0, 1], [1, 1, 0, 0, 1]];
        console.info(StackExercise.RottenFruit(arr, 5, 5));
    }

    public static StepsOfKnightUtil(size : number, currCol : number, currRow : number, traversed : number[][], dist : number) {
        if(currCol < 0 || currCol >= size || currRow < 0 || currRow >= size) return;
        if(traversed[currCol][currRow] <= dist) return;
        traversed[currCol][currRow] = dist;
        StackExercise.StepsOfKnightUtil(size, currCol - 2, currRow - 1, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol - 2, currRow + 1, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol + 2, currRow - 1, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol + 2, currRow + 1, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol - 1, currRow - 2, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol + 1, currRow - 2, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol - 1, currRow + 2, traversed, dist + 1);
        StackExercise.StepsOfKnightUtil(size, currCol + 1, currRow + 2, traversed, dist + 1);
    }

    public static StepsOfKnight(size : number, srcX : number, srcY : number, dstX : number, dstY : number) : number {
        let traversed : number[][] = <any> (function(dims) { let allocate = function(dims) { if(dims.length==0) { return 0; } else { let array = []; for(let i = 0; i < dims[0]; i++) { array.push(allocate(dims.slice(1))); } return array; }}; return allocate(dims);})([size, size]);
        for(let i : number = 0; i < size; i++) {{
            for(let j : number = 0; j < size; j++) {{
                traversed[i][j] = 2147483647;
            };}
        };}
        StackExercise.StepsOfKnightUtil(size, srcX - 1, srcY - 1, traversed, 0);
        let retval : number = traversed[dstX - 1][dstY - 1];
        return retval;
    }

    public static main17(args : string[]) {
        console.info(StackExercise.StepsOfKnight(20, 10, 10, 20, 20));
    }

    public static DistNearestFillUtil(arr : number[][], maxCol : number, maxRow : number, currCol : number, currRow : number, traversed : number[][], dist : number) {
        if(currCol < 0 || currCol >= maxCol || currRow < 0 || currRow >= maxRow) return;
        if(traversed[currCol][currRow] <= dist) return;
        traversed[currCol][currRow] = dist;
        StackExercise.DistNearestFillUtil(arr, maxCol, maxRow, currCol - 1, currRow, traversed, dist + 1);
        StackExercise.DistNearestFillUtil(arr, maxCol, maxRow, currCol + 1, currRow, traversed, dist + 1);
        StackExercise.DistNearestFillUtil(arr, maxCol, maxRow, currCol, currRow + 1, traversed, dist + 1);
        StackExercise.DistNearestFillUtil(arr, maxCol, maxRow, currCol, currRow - 1, traversed, dist + 1);
    }

    public static DistNearestFill(arr : number[][], maxCol : number, maxRow : number) {
        let traversed : number[][] = <any> (function(dims) { let allocate = function(dims) { if(dims.length==0) { return 0; } else { let array = []; for(let i = 0; i < dims[0]; i++) { array.push(allocate(dims.slice(1))); } return array; }}; return allocate(dims);})([maxCol, maxRow]);
        for(let i : number = 0; i < maxCol; i++) {{
            for(let j : number = 0; j < maxRow; j++) {{
                traversed[i][j] = 2147483647;
            };}
        };}
        for(let i : number = 0; i < maxCol; i++) {{
            for(let j : number = 0; j < maxRow; j++) {{
                if(arr[i][j] === 1) StackExercise.DistNearestFillUtil(arr, maxCol, maxRow, i, j, traversed, 0);
            };}
        };}
        for(let i : number = 0; i < maxCol; i++) {{
            for(let j : number = 0; j < maxRow; j++) {{
                console.info("" + traversed[i][j]);
            };}
            console.info("\n");
        };}
    }

    public static main18(args : string[]) {
        let arr : number[][] = [[1, 0, 1, 1, 0], [1, 1, 0, 1, 0], [0, 0, 0, 0, 1], [0, 0, 0, 0, 1], [0, 0, 0, 0, 1]];
        StackExercise.DistNearestFill(arr, 5, 5);
    }

    public static findLargestIslandUtil(arr : number[][], maxCol : number, maxRow : number, currCol : number, currRow : number, value : number, traversed : number[][]) : number {
        if(currCol < 0 || currCol >= maxCol || currRow < 0 || currRow >= maxRow) return 0;
        if(traversed[currCol][currRow] === 1 || arr[currCol][currRow] !== value) return 0;
        traversed[currCol][currRow] = 1;
        return 1 + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol - 1, currRow - 1, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol - 1, currRow, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol - 1, currRow + 1, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol, currRow - 1, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol, currRow + 1, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol + 1, currRow - 1, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol + 1, currRow, value, traversed) + StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, currCol + 1, currRow + 1, value, traversed);
    }

    public static findLargestIsland(arr : number[][], maxCol : number, maxRow : number) : number {
        let maxVal : number = 0;
        let currVal : number = 0;
        let traversed : number[][] = <any> (function(dims) { let allocate = function(dims) { if(dims.length==0) { return 0; } else { let array = []; for(let i = 0; i < dims[0]; i++) { array.push(allocate(dims.slice(1))); } return array; }}; return allocate(dims);})([maxCol, maxRow]);
        for(let i : number = 0; i < maxCol; i++) {{
            for(let j : number = 0; j < maxRow; j++) {{
                traversed[i][j] = 2147483647;
            };}
        };}
        for(let i : number = 0; i < maxCol; i++) {{
            for(let j : number = 0; j < maxRow; j++) {{
                {
                    currVal = StackExercise.findLargestIslandUtil(arr, maxCol, maxRow, i, j, arr[i][j], traversed);
                    if(currVal > maxVal) maxVal = currVal;
                };
            };}
        };}
        return maxVal;
    }

    public static main19(args : string[]) {
        let arr : number[][] = [[1, 0, 1, 1, 0], [1, 0, 0, 1, 0], [0, 1, 1, 1, 1], [0, 1, 0, 0, 0], [1, 1, 0, 0, 1]];
        console.info("Largest Island : " + StackExercise.findLargestIsland(arr, 5, 5));
    }

    public static isKnown(relation : number[][], a : number, b : number) : boolean {
        if(relation[a][b] === 1) return true;
        return false;
    }

    public static findCelebrity(relation : number[][], count : number) : number {
        let stk : Array<number> = <any>([]);
        let first : number = 0;
        let second : number = 0;
        for(let i : number = 0; i < count; i++) {{
            /* push */(stk.push(i)>0);
        };}
        first = /* pop */stk.pop();
        while((/* size */(<number>stk.length) !== 0)) {{
            second = /* pop */stk.pop();
            if(StackExercise.isKnown(relation, first, second)) first = second;
        }};
        for(let i : number = 0; i < count; i++) {{
            if(first !== i && StackExercise.isKnown(relation, first, i)) return -1;
            if(first !== i && StackExercise.isKnown(relation, i, first) === false) return -1;
        };}
        return first;
    }

    public static findCelebrity2(relation : number[][], count : number) : number {
        let first : number = 0;
        let second : number = 1;
        for(let i : number = 0; i < (count - 1); i++) {{
            if(StackExercise.isKnown(relation, first, second)) first = second;
            second = second + 1;
        };}
        for(let i : number = 0; i < count; i++) {{
            if(first !== i && StackExercise.isKnown(relation, first, i)) return -1;
            if(first !== i && StackExercise.isKnown(relation, i, first) === false) return -1;
        };}
        return first;
    }

    public static main20(args : string[]) {
        let arr : number[][] = [[1, 0, 1, 1, 0], [1, 0, 0, 1, 0], [0, 0, 1, 1, 1], [0, 0, 0, 0, 0], [1, 1, 0, 1, 1]];
        console.info("Celebrity : " + StackExercise.findCelebrity(arr, 5));
        console.info("Celebrity : " + StackExercise.findCelebrity2(arr, 5));
    }

    public static IsMinHeap(arr : number[], size : number) : number {
        for(let i : number = 0; i <= ((size - 2) / 2|0); i++) {{
            if(2 * i + 1 < size) {
                if(arr[i] > arr[2 * i + 1]) return 0;
            }
            if(2 * i + 2 < size) {
                if(arr[i] > arr[2 * i + 2]) return 0;
            }
        };}
        return 1;
    }

    public static IsMaxHeap(arr : number[], size : number) : number {
        for(let i : number = 0; i <= ((size - 2) / 2|0); i++) {{
            if(2 * i + 1 < size) {
                if(arr[i] < arr[2 * i + 1]) return 0;
            }
            if(2 * i + 2 < size) {
                if(arr[i] < arr[2 * i + 2]) return 0;
            }
        };}
        return 1;
    }
}
StackExercise["__class"] = "StackExercise";




StackExercise.main(null);
