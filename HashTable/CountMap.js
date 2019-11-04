/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var CountMap = /** @class */ (function () {
    function CountMap() {
        this.hm = ({});
    }
    CountMap.prototype.add = function (key) {
        if ( /* containsKey */(function (m, k) { if (m.entries == null)
            m.entries = []; for (var i = 0; i < m.entries.length; i++)
            if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                return true;
            } return false; })(this.hm, key)) {
            /* put */ (function (m, k, v) { if (m.entries == null)
                m.entries = []; for (var i = 0; i < m.entries.length; i++)
                if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                    m.entries[i].value = v;
                    return;
                } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(this.hm, key, /* get */ (function (m, k) { if (m.entries == null)
                m.entries = []; for (var i = 0; i < m.entries.length; i++)
                if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                    return m.entries[i].value;
                } return null; })(this.hm, key) + 1);
        }
        else {
            /* put */ (function (m, k, v) { if (m.entries == null)
                m.entries = []; for (var i = 0; i < m.entries.length; i++)
                if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                    m.entries[i].value = v;
                    return;
                } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(this.hm, key, 1);
        }
    };
    CountMap.prototype.remove = function (key) {
        if ( /* containsKey */(function (m, k) { if (m.entries == null)
            m.entries = []; for (var i = 0; i < m.entries.length; i++)
            if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                return true;
            } return false; })(this.hm, key)) {
            if ( /* get */(function (m, k) { if (m.entries == null)
                m.entries = []; for (var i = 0; i < m.entries.length; i++)
                if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                    return m.entries[i].value;
                } return null; })(this.hm, key) === 1) /* remove */
                (function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i = 0; i < m.entries.length; i++)
                    if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                        return m.entries.splice(i, 1)[0];
                    } })(this.hm, key);
            else {
                /* put */ (function (m, k, v) { if (m.entries == null)
                    m.entries = []; for (var i = 0; i < m.entries.length; i++)
                    if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                        m.entries[i].value = v;
                        return;
                    } m.entries.push({ key: k, value: v, getKey: function () { return this.key; }, getValue: function () { return this.value; } }); })(this.hm, key, /* get */ (function (m, k) { if (m.entries == null)
                    m.entries = []; for (var i = 0; i < m.entries.length; i++)
                    if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                        return m.entries[i].value;
                    } return null; })(this.hm, key) - 1);
            }
        }
    };
    CountMap.prototype.get = function (key) {
        if ( /* containsKey */(function (m, k) { if (m.entries == null)
            m.entries = []; for (var i = 0; i < m.entries.length; i++)
            if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                return true;
            } return false; })(this.hm, key))
            return /* get */ (function (m, k) { if (m.entries == null)
                m.entries = []; for (var i = 0; i < m.entries.length; i++)
                if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                    return m.entries[i].value;
                } return null; })(this.hm, key);
        return 0;
    };
    CountMap.prototype.containsKey = function (key) {
        return /* containsKey */ (function (m, k) { if (m.entries == null)
            m.entries = []; for (var i = 0; i < m.entries.length; i++)
            if (m.entries[i].key.equals != null && m.entries[i].key.equals(k) || m.entries[i].key === k) {
                return true;
            } return false; })(this.hm, key);
    };
    CountMap.prototype.size = function () {
        return /* size */ (function (m) { if (m.entries == null)
            m.entries = []; return m.entries.length; })(this.hm);
    };
    CountMap.main = function (args) {
        var cm = (new CountMap());
        cm.add(2);
        cm.add(2);
        console.info("count is : " + cm.get(2));
        cm.remove(2);
        console.info("count is : " + cm.get(2));
        cm.remove(2);
        console.info("count is : " + cm.get(2));
    };
    return CountMap;
}());
CountMap["__class"] = "CountMap";
CountMap.main(null);
