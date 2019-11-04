class HashTableExercise {
    public static main(args : string[]) {
        let first : string[] = /* toCharArray */("hello").split('');
        let second : string[] = /* toCharArray */("elloh").split('');
        let third : string[] = /* toCharArray */("world").split('');
        console.info("isAnagram : " + HashTableExercise.isAnagram(first, second));
        console.info("isAnagram : " + HashTableExercise.isAnagram(first, third));
        HashTableExercise.removeDuplicate(first);
        console.info(first);
        let arr : number[] = [1, 2, 3, 5, 6, 7, 8, 9, 10];
        console.info(HashTableExercise.findMissing(arr, 1, 10));
        let arr1 : number[] = [1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 1];
        HashTableExercise.printRepeating(arr1);
        HashTableExercise.printFirstRepeating(arr1);
    }

    public static isAnagram(str1 : string[], str2 : string[]) : boolean {
        let size1 : number = str1.length;
        let size2 : number = str2.length;
        if(size1 !== size2) return false;
        let hm : any = <any>({});
        for(let index8194=0; index8194 < str1.length; index8194++) {
            let ch = str1[index8194];
            {
                if(/* containsKey */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return true; } return false; })(<any>hm, ch)) /* put */((m,k,v) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { m.entries[i].value=v; return; } m.entries.push({key:k,value:v,getKey: function() { return this.key }, getValue: function() { return this.value }}); })(<any>hm, ch, /* get */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries[i].value; } return null; })(<any>hm, ch) + 1); else /* put */((m,k,v) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { m.entries[i].value=v; return; } m.entries.push({key:k,value:v,getKey: function() { return this.key }, getValue: function() { return this.value }}); })(<any>hm, ch, 1);
            }
        }
        for(let index8195=0; index8195 < str2.length; index8195++) {
            let ch = str2[index8195];
            {
                if(/* containsKey */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return true; } return false; })(<any>hm, ch) === false || /* get */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries[i].value; } return null; })(<any>hm, ch) === 0) return false; else /* put */((m,k,v) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { m.entries[i].value=v; return; } m.entries.push({key:k,value:v,getKey: function() { return this.key }, getValue: function() { return this.value }}); })(<any>hm, ch, /* get */((m,k) => { if(m.entries==null) m.entries=[]; for(let i=0;i<m.entries.length;i++) if(m.entries[i].key.equals!=null && m.entries[i].key.equals(k) || m.entries[i].key===k) { return m.entries[i].value; } return null; })(<any>hm, ch) - 1);
            }
        }
        return true;
    }

    public static removeDuplicate(str : string[]) : string {
        let hs : Array<string> = <any>([]);
        let out : string = "";
        for(let index8196=0; index8196 < str.length; index8196++) {
            let ch = str[index8196];
            {
                if(/* contains */(hs.indexOf(<any>(ch)) >= 0) === false) {
                    out += ch;
                    /* add */((s, e) => { if(s.indexOf(e)==-1) { s.push(e); return true; } else { return false; } })(hs, ch);
                }
            }
        }
        return out;
    }

    public static findMissing(arr : number[], start : number, end : number) : number {
        let hs : Array<number> = <any>([]);
        for(let index8197=0; index8197 < arr.length; index8197++) {
            let i = arr[index8197];
            {
                /* add */((s, e) => { if(s.indexOf(e)==-1) { s.push(e); return true; } else { return false; } })(hs, i);
            }
        }
        for(let curr : number = start; curr <= end; curr++) {{
            if(/* contains */(hs.indexOf(<any>(curr)) >= 0) === false) return curr;
        };}
        return 2147483647;
    }

    public static printRepeating(arr : number[]) {
        let hs : Array<number> = <any>([]);
        console.info("Repeating elements are:");
        for(let index8198=0; index8198 < arr.length; index8198++) {
            let val = arr[index8198];
            {
                if(/* contains */(hs.indexOf(<any>(val)) >= 0)) console.info(" " + val); else /* add */((s, e) => { if(s.indexOf(e)==-1) { s.push(e); return true; } else { return false; } })(hs, val);
            }
        }
    }

    public static printFirstRepeating(arr : number[]) {
        let i : number;
        let size : number = arr.length;
        let hs : Array<number> = <any>([]);
        let firstRepeating : number = 2147483647;
        for(i = size - 1; i >= 0; i--) {{
            if(/* contains */(hs.indexOf(<any>(arr[i])) >= 0)) {
                firstRepeating = arr[i];
            }
            /* add */((s, e) => { if(s.indexOf(e)==-1) { s.push(e); return true; } else { return false; } })(hs, arr[i]);
        };}
        console.info("First Repeating number is : " + firstRepeating);
    }

    public static hornerHash(key : string[], tableSize : number) : number {
        let size : number = key.length;
        let h : number = 0;
        let i : number;
        for(i = 0; i < size; i++) {{
            h = (32 * h + (c => c.charCodeAt==null?<any>c:c.charCodeAt(0))(key[i])) % tableSize;
        };}
        return h;
    }
}
HashTableExercise["__class"] = "HashTableExercise";




HashTableExercise.main(null);
