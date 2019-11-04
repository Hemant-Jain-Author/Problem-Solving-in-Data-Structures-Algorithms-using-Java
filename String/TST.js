/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var TST = /** @class */ (function () {
    function TST() {
        if (this.root === undefined)
            this.root = null;
    }
    TST.prototype.add$java_lang_String = function (word) {
        this.root = this.add$TST_Node$java_lang_String$int(this.root, word, 0);
    };
    TST.prototype.add$TST_Node$java_lang_String$int = function (curr, word, wordIndex) {
        if (curr == null)
            curr = new TST.Node(this, word.charAt(wordIndex));
        if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(word.charAt(wordIndex)) < (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(curr.data))
            curr.left = this.add$TST_Node$java_lang_String$int(curr.left, word, wordIndex);
        else if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(word.charAt(wordIndex)) > (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(curr.data))
            curr.right = this.add$TST_Node$java_lang_String$int(curr.right, word, wordIndex);
        else {
            if (wordIndex < word.length - 1)
                curr.equal = this.add$TST_Node$java_lang_String$int(curr.equal, word, wordIndex + 1);
            else
                curr.isLastChar = true;
        }
        return curr;
    };
    TST.prototype.add = function (curr, word, wordIndex) {
        if (((curr != null && curr instanceof TST.Node) || curr === null) && ((typeof word === 'string') || word === null) && ((typeof wordIndex === 'number') || wordIndex === null)) {
            return this.add$TST_Node$java_lang_String$int(curr, word, wordIndex);
        }
        else if (((typeof curr === 'string') || curr === null) && word === undefined && wordIndex === undefined) {
            return this.add$java_lang_String(curr);
        }
        else
            throw new Error('invalid overload');
    };
    TST.prototype.find$TST_Node$java_lang_String$int = function (curr, word, wordIndex) {
        if (curr == null)
            return false;
        if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(word.charAt(wordIndex)) < (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(curr.data))
            return this.find$TST_Node$java_lang_String$int(curr.left, word, wordIndex);
        else if ((function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(word.charAt(wordIndex)) > (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(curr.data))
            return this.find$TST_Node$java_lang_String$int(curr.right, word, wordIndex);
        else {
            if (wordIndex === word.length - 1)
                return curr.isLastChar;
            return this.find$TST_Node$java_lang_String$int(curr.equal, word, wordIndex + 1);
        }
    };
    TST.prototype.find = function (curr, word, wordIndex) {
        if (((curr != null && curr instanceof TST.Node) || curr === null) && ((typeof word === 'string') || word === null) && ((typeof wordIndex === 'number') || wordIndex === null)) {
            return this.find$TST_Node$java_lang_String$int(curr, word, wordIndex);
        }
        else if (((typeof curr === 'string') || curr === null) && word === undefined && wordIndex === undefined) {
            return this.find$java_lang_String(curr);
        }
        else
            throw new Error('invalid overload');
    };
    TST.prototype.find$java_lang_String = function (word) {
        var ret = this.find$TST_Node$java_lang_String$int(this.root, word, 0);
        console.info(word + " :: ");
        if (ret)
            console.info(" Found ");
        else
            console.info("Not Found ");
        return ret;
    };
    TST.main = function (args) {
        var tt = new TST();
        tt.add$java_lang_String("banana");
        tt.add$java_lang_String("apple");
        tt.add$java_lang_String("mango");
        console.info("\nSearch results for apple, banana, grapes and mango :");
        tt.find$java_lang_String("apple");
        tt.find$java_lang_String("banana");
        tt.find$java_lang_String("mango");
        tt.find$java_lang_String("grapes");
    };
    return TST;
}());
TST["__class"] = "TST";
(function (TST) {
    var Node = /** @class */ (function () {
        function Node(__parent, d) {
            this.__parent = __parent;
            if (this.data === undefined)
                this.data = null;
            if (this.isLastChar === undefined)
                this.isLastChar = false;
            if (this.left === undefined)
                this.left = null;
            if (this.equal === undefined)
                this.equal = null;
            if (this.right === undefined)
                this.right = null;
            this.data = d;
            this.isLastChar = false;
            this.left = this.equal = this.right = null;
        }
        return Node;
    }());
    TST.Node = Node;
    Node["__class"] = "TST.Node";
})(TST || (TST = {}));
TST.main(null);
