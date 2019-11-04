var HashTableExercise = /** @class */ (function () {
    function HashTableExercise() {
    }
    HashTableExercise.main = function (args) {
        var first = ("hello").split('');
        var second = ("elloh").split('');
        var third = ("world").split('');
        console.info("isAnagram : " + HashTableExercise.isAnagram(first, second));
        console.info("isAnagram : " + HashTableExercise.isAnagram(first, third));
        HashTableExercise.removeDuplicate(first);
        console.info(first);
        var arr = [1, 2, 3, 5, 6, 7, 8, 9, 10];
        console.info(HashTableExercise.findMissing(arr, 1, 10));
        var arr1 = [1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 1];
        HashTableExercise.printRepeating(arr1);
        HashTableExercise.printFirstRepeating(arr1);
    };
    HashTableExercise.isAnagram = function (str1, str2) {
        var size1 = str1.length;
        var size2 = str2.length;
        if (size1 !== size2)
            return false;
        var hm = ({});
        for (var index8194 = 0; index8194 < str1.length; index8194++) {
            var ch = str1[index8194];
            {
                if ( /* containsKey */(function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i = 0; i < m.entries.length; i++)
                    if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                        return true;
                    } return false; })(hm, ch)) /* put */
                    (function (m, k, v) { if (m.entries == null)
                        m.entries = []; for (var i = 0; i < m.entries.length; i++)
                        if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                            m.entries[i].value = v;
                            return;
                        } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(hm, ch, /* get */ (function (m, k) { if (m.entries == null)
                        m.entries = []; for (var i = 0; i < m.entries.length; i++)
                        if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                            return m.entries[i].value;
                        } return null; })(hm, ch) + 1);
                else /* put */
                    (function (m, k, v) { if (m.entries == null)
                        m.entries = []; for (var i = 0; i < m.entries.length; i++)
                        if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                            m.entries[i].value = v;
                            return;
                        } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(hm, ch, 1);
            }
        }
        for (var index8195 = 0; index8195 < str2.length; index8195++) {
            var ch = str2[index8195];
            {
                if ( /* containsKey */(function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i = 0; i < m.entries.length; i++)
                    if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                        return true;
                    } return false; })(hm, ch) === false || /* get */ (function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i = 0; i < m.entries.length; i++)
                    if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                        return m.entries[i].value;
                    } return null; })(hm, ch) === 0)
                    return false;
                else /* put */
                    (function (m, k, v) { if (m.entries == null)
                        m.entries = []; for (var i = 0; i < m.entries.length; i++)
                        if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                            m.entries[i].value = v;
                            return;
                        } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(hm, ch, /* get */ (function (m, k) { if (m.entries == null)
                        m.entries = []; for (var i = 0; i < m.entries.length; i++)
                        if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                            return m.entries[i].value;
                        } return null; })(hm, ch) - 1);
            }
        }
        return true;
    };
    HashTableExercise.removeDuplicate = function (str) {
        var hs = ([]);
        var out = "";
        for (var index8196 = 0; index8196 < str.length; index8196++) {
            var ch = str[index8196];
            {
                if ( /* contains */(hs.indexOf((ch)) >= 0) === false) {
                    out += ch;
                    /* add */ (function (s, e) { if (s.indexOf(e) == -1) {
                        s.push(e);
                        return true;
                    }
                    else {
                        return false;
                    } })(hs, ch);
                }
            }
        }
        return out;
    };
    HashTableExercise.findMissing = function (arr, start, end) {
        var hs = ([]);
        for (var index8197 = 0; index8197 < arr.length; index8197++) {
            var i = arr[index8197];
            {
                /* add */ (function (s, e) { if (s.indexOf(e) == -1) {
                    s.push(e);
                    return true;
                }
                else {
                    return false;
                } })(hs, i);
            }
        }
        for (var curr = start; curr <= end; curr++) {
            {
                if ( /* contains */(hs.indexOf((curr)) >= 0) === false)
                    return curr;
            }
            ;
        }
        return 2147483647;
    };
    HashTableExercise.printRepeating = function (arr) {
        var hs = ([]);
        console.info("Repeating elements are:");
        for (var index8198 = 0; index8198 < arr.length; index8198++) {
            var val = arr[index8198];
            {
                if ( /* contains */(hs.indexOf((val)) >= 0))
                    console.info(" " + val);
                else /* add */
                    (function (s, e) { if (s.indexOf(e) == -1) {
                        s.push(e);
                        return true;
                    }
                    else {
                        return false;
                    } })(hs, val);
            }
        }
    };
    HashTableExercise.printFirstRepeating = function (arr) {
        var i;
        var size = arr.length;
        var hs = ([]);
        var firstRepeating = 2147483647;
        for (i = size - 1; i >= 0; i--) {
            {
                if ( /* contains */(hs.indexOf((arr[i])) >= 0)) {
                    firstRepeating = arr[i];
                }
                /* add */ (function (s, e) { if (s.indexOf(e) == -1) {
                    s.push(e);
                    return true;
                }
                else {
                    return false;
                } })(hs, arr[i]);
            }
            ;
        }
        console.info("First Repeating number is : " + firstRepeating);
    };
    HashTableExercise.hornerHash = function (key, tableSize) {
        var size = key.length;
        var h = 0;
        var i;
        for (i = 0; i < size; i++) {
            {
                h = (32 * h + (function (c) { return c.charCodeAt == null ? c : c.charCodeAt(0); })(key[i])) % tableSize;
            }
            ;
        }
        return h;
    };
    return HashTableExercise;
}());
HashTableExercise["__class"] = "HashTableExercise";
HashTableExercise.main(null);
