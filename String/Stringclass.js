/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var Stringclass = /** @class */ (function () {
    function Stringclass() {
    }
    Stringclass.main = function (args) {
        var str1 = "hello";
        var str2 = "hello";
        var str3 = "Hello";
        console.info("str1 equals str2 :" + /* equals */ (function (o1, o2) { if (o1 && o1.equals) {
            return o1.equals(o2);
        }
        else {
            return o1 === o2;
        } })(str1, str2));
        console.info("str1 equals str3 :" + /* equals */ (function (o1, o2) { if (o1 && o1.equals) {
            return o1.equals(o2);
        }
        else {
            return o1 === o2;
        } })(str1, str3));
    };
    return Stringclass;
}());
Stringclass["__class"] = "Stringclass";
Stringclass.main(null);
