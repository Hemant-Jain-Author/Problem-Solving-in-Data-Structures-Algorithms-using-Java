/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var Trie = /** @class */ (function () {
    function Trie() {
        this.root = null;
        this.root = new Trie.Node(this, ' ');
    }
    Trie.prototype.add$java_lang_String = function (str) {
        if (str == null) {
            return this.root;
        }
        return this.add$Trie_Node$java_lang_String$int(this.root, str.toLowerCase(), 0);
    };
    Trie.prototype.add$Trie_Node$java_lang_String$int = function (curr, str, index) {
        if (curr == null) {
            curr = new Trie.Node(this, str.charAt(index - 1));
        }
        if (str.length === index) {
            curr.isLastChar = true;
        }
        else {
            curr.child[(function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(str.charAt(index)) - 'a'.charCodeAt(0)] = this.add$Trie_Node$java_lang_String$int(curr.child[(function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(str.charAt(index)) - 'a'.charCodeAt(0)], str, index + 1);
        }
        return curr;
    };
    Trie.prototype.add = function (curr, str, index) {
        if (((curr != null && curr instanceof Trie.Node) || curr === null) && ((typeof str === 'string') || str === null) && ((typeof index === 'number') || index === null)) {
            return this.add$Trie_Node$java_lang_String$int(curr, str, index);
        }
        else if (((typeof curr === 'string') || curr === null) && str === undefined && index === undefined) {
            return this.add$java_lang_String(curr);
        }
        else
            throw new Error('invalid overload');
    };
    Trie.prototype.remove$java_lang_String = function (str) {
        if (str == null) {
            return;
        }
        str = str.toLowerCase();
        this.remove$Trie_Node$java_lang_String$int(this.root, str, 0);
    };
    Trie.prototype.remove$Trie_Node$java_lang_String$int = function (curr, str, index) {
        if (curr == null) {
            return;
        }
        if (str.length === index) {
            if (curr.isLastChar) {
                curr.isLastChar = false;
            }
            return;
        }
        this.remove$Trie_Node$java_lang_String$int(curr.child[(function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(str.charAt(index)) - 'a'.charCodeAt(0)], str, index + 1);
    };
    Trie.prototype.remove = function (curr, str, index) {
        if (((curr != null && curr instanceof Trie.Node) || curr === null) && ((typeof str === 'string') || str === null) && ((typeof index === 'number') || index === null)) {
            return this.remove$Trie_Node$java_lang_String$int(curr, str, index);
        }
        else if (((typeof curr === 'string') || curr === null) && str === undefined && index === undefined) {
            return this.remove$java_lang_String(curr);
        }
        else
            throw new Error('invalid overload');
    };
    Trie.prototype.find$java_lang_String = function (str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        return this.find$Trie_Node$java_lang_String$int(this.root, str, 0);
    };
    Trie.prototype.find$Trie_Node$java_lang_String$int = function (curr, str, index) {
        if (curr == null) {
            return false;
        }
        if (str.length === index) {
            return curr.isLastChar;
        }
        return this.find$Trie_Node$java_lang_String$int(curr.child[(function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(str.charAt(index)) - 'a'.charCodeAt(0)], str, index + 1);
    };
    Trie.prototype.find = function (curr, str, index) {
        if (((curr != null && curr instanceof Trie.Node) || curr === null) && ((typeof str === 'string') || str === null) && ((typeof index === 'number') || index === null)) {
            return this.find$Trie_Node$java_lang_String$int(curr, str, index);
        }
        else if (((typeof curr === 'string') || curr === null) && str === undefined && index === undefined) {
            return this.find$java_lang_String(curr);
        }
        else
            throw new Error('invalid overload');
    };
    Trie.main = function (args) {
        var t = new Trie();
        var a = "hemant";
        var b = "heman";
        var c = "hemantjain";
        var d = "jain";
        t.add$java_lang_String(a);
        t.add$java_lang_String(d);
        console.info(t.find$java_lang_String(a));
        t.remove$java_lang_String(a);
        t.remove$java_lang_String(d);
        console.info(t.find$java_lang_String(a));
        console.info(t.find$java_lang_String(c));
        console.info(t.find$java_lang_String(d));
    };
    Trie.CharCount = 26;
    return Trie;
}());
Trie["__class"] = "Trie";
(function (Trie) {
    var Node = /** @class */ (function () {
        function Node(__parent, c) {
            this.__parent = __parent;
            if (this.isLastChar === undefined)
                this.isLastChar = false;
            if (this.child === undefined)
                this.child = null;
            this.child = (function (s) { var a = []; while (s-- > 0)
                a.push(null); return a; })(Trie.CharCount);
            for (var i = 0; i < Trie.CharCount; i++) {
                {
                    this.child[i] = null;
                }
                ;
            }
            this.isLastChar = false;
        }
        return Node;
    }());
    Trie.Node = Node;
    Node["__class"] = "Trie.Node";
})(Trie || (Trie = {}));
Trie.main(null);
