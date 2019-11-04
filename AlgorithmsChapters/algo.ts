class algo {
    public static fibonacci(n : number) : number {
        if(n <= 1) {
            return n;
        }
        return algo.fibonacci(n - 1) + algo.fibonacci(n - 2);
    }

    public static fibonacci2(n : number) : number {
        let first : number = 0;
        let second : number = 1;
        let temp : number = 0;
        if(n === 0) return first; else if(n === 1) return second;
        let i : number = 2;
        while((i <= n)) {{
            temp = first + second;
            first = second;
            second = temp;
            i += 1;
        }};
        return temp;
    }

    public static print(Q : number[], n : number) {
        for(let i : number = 0; i < n; i++) {{
            console.info(" " + Q[i]);
        };}
        console.info(" ");
    }

    public static Feasible(Q : number[], k : number) : boolean {
        for(let i : number = 0; i < k; i++) {{
            if(Q[k] === Q[i] || Math.abs(Q[i] - Q[k]) === Math.abs(i - k)) {
                return false;
            }
        };}
        return true;
    }

    public static NQueens(Q : number[], k : number, n : number) {
        if(k === n) {
            algo.print(Q, n);
            return;
        }
        for(let i : number = 0; i < n; i++) {{
            Q[k] = i;
            if(algo.Feasible(Q, k)) {
                algo.NQueens(Q, k + 1, n);
            }
        };}
    }

    public static main1() {
        let Q : number[] = [0, 0, 0, 0, 0, 0, 0, 0];
        algo.NQueens(Q, 0, 8);
    }

    public static TOHUtil(num : number, from : string, to : string, temp : string) {
        if(num < 1) {
            return;
        }
        algo.TOHUtil(num - 1, from, temp, to);
        console.info("Move disk " + num + " from peg " + from + " to peg " + to);
        algo.TOHUtil(num - 1, temp, to, from);
    }

    public static TowersOfHanoi(num : number) {
        console.info("The sequence of moves involved in the Tower of Hanoi are :");
        algo.TOHUtil(num, 'A', 'C', 'B');
    }

    public static main2() {
        algo.TowersOfHanoi(3);
    }

    isPrime(n : number) : number {
        let answer : number = (n > 1)?1:0;
        for(let i : number = 2; i * i <= n; ++i) {{
            if(n % i === 0) {
                answer = 1;
                break;
            }
        };}
        return answer;
    }
}

algo["__class"] = "algo";

algo.main1()
algo.main2()