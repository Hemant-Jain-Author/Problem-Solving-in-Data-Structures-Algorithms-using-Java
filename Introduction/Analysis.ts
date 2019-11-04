class Analysis {
    fun1(n : number) : number {
        let m : number = 0;
        for(let i : number = 0; i < n; i++) {{
            m += 1;
        };}
        return m;
    }

    fun2(n : number) : number {
        let i : number;
        let j : number;
        let m : number = 0;
        for(i = 0; i < n; i++) {{
            for(j = 0; j < n; j++) {{
                m += 1;
            };}
        };}
        return m;
    }

    fun3(n : number) : number {
        let i : number;
        let j : number;
        let m : number = 0;
        for(i = 0; i < n; i++) {{
            for(j = 0; j < i; j++) {{
                m += 1;
            };}
        };}
        return m;
    }

    fun4(n : number) : number {
        let i : number;
        let m : number = 0;
        i = 1;
        while((i < n)) {{
            m += 1;
            i = i * 2;
        }};
        return m;
    }

    fun5(n : number) : number {
        let i : number;
        let m : number = 0;
        i = n;
        while((i > 0)) {{
            m += 1;
            i = (i / 2|0);
        }};
        return m;
    }

    fun6(n : number) : number {
        let i : number;
        let j : number;
        let k : number;
        let m : number = 0;
        for(i = 0; i < n; i++) {{
            for(j = 0; j < n; j++) {{
                for(k = 0; k < n; k++) {{
                    m += 1;
                };}
            };}
        };}
        return m;
    }

    fun7(n : number) : number {
        let i : number;
        let j : number;
        let k : number;
        let m : number = 0;
        for(i = 0; i < n; i++) {{
            for(j = 0; j < n; j++) {{
                m += 1;
            };}
        };}
        for(i = 0; i < n; i++) {{
            for(k = 0; k < n; k++) {{
                m += 1;
            };}
        };}
        return m;
    }

    fun8(n : number) : number {
        let i : number;
        let j : number;
        let m : number = 0;
        for(i = 0; i < n; i++) {{
            for(j = 0; j < Math.sqrt(n); j++) {{
                m += 1;
            };}
        };}
        return m;
    }

    fun9(n : number) : number {
        let i : number;
        let j : number;
        let m : number = 0;
        for(i = n; i > 0; i = (n => n<0?Math.ceil(n):Math.floor(n))(i / 2)) {{
            for(j = 0; j < i; j++) {{
                m += 1;
            };}
        };}
        return m;
    }

    fun10(n : number) : number {
        let i : number;
        let j : number;
        let m : number = 0;
        for(i = 0; i < n; i++) {{
            for(j = i; j > 0; j--) {{
                m += 1;
            };}
        };}
        return m;
    }

    fun11(n : number) : number {
        let i : number;
        let j : number;
        let k : number;
        let m : number = 0;
        for(i = 0; i < n; i++) {{
            for(j = i; j < n; j++) {{
                for(k = j + 1; k < n; k++) {{
                    m += 1;
                };}
            };}
        };}
        return m;
    }

    fun12(n : number) : number {
        let i : number;
        let j : number = 0;
        let m : number = 0;
        for(i = 0; i < n; i++) {{
            for(; j < n; j++) {{
                m += 1;
            };}
        };}
        return m;
    }

    fun13(n : number) : number {
        let i : number;
        let j : number = 0;
        let m : number = 0;
        for(i = 1; i <= n; i *= 2) {{
            for(j = 0; j <= i; j++) {{
                m += 1;
            };}
        };}
        return m;
    }

    public static main(args : string[]) {
        let a : Analysis = new Analysis();
        console.info(a.fun1(100));
        console.info(a.fun2(100));
        console.info(a.fun3(100));
        console.info(a.fun4(100));
        console.info(a.fun5(100));
        console.info(a.fun6(100));
        console.info(a.fun7(100));
        console.info(a.fun8(100));
        console.info(a.fun9(100));
        console.info(a.fun10(100));
        console.info(a.fun11(100));
        console.info(a.fun12(100));
        console.info(a.fun13(100));
    }
}
Analysis["__class"] = "Analysis";

Analysis.main(null);