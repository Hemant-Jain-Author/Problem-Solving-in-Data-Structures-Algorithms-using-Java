/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class QueueEx {
    public static CircularTour(arr : number[][], n : number) : number {
        let que : Array<number> = <any>([]);
        let nextPump : number = 0;
        let prevPump : number;
        let count : number = 0;
        let petrol : number = 0;
        while((/* size */(<number>que.length) !== n)) {{
            while((petrol >= 0 && /* size */(<number>que.length) !== n)) {{
                /* add */(que.push(nextPump)>0);
                petrol += (arr[nextPump][0] - arr[nextPump][1]);
                nextPump = (nextPump + 1) % n;
            }};
            while((petrol < 0 && /* size */(<number>que.length) > 0)) {{
                prevPump = /* pop */que.pop();
                petrol -= (arr[prevPump][0] - arr[prevPump][1]);
            }};
            count += 1;
            if(count === n) return -1;
        }};
        if(petrol >= 0) return /* pop */que.pop(); else return -1;
    }

    public static main1(args : string[]) {
        let tour : number[][] = [[8, 6], [1, 4], [7, 6]];
        console.info(" Circular Tour : " + QueueEx.CircularTour(tour, 3));
    }

    public static convertXY(src : number, dst : number) : number {
        let que : Array<number> = <any>([]);
        let arr : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(100);
        let steps : number = 0;
        let index : number = 0;
        let value : number;
        /* add */(que.push(src)>0);
        while((/* size */(<number>que.length) !== 0)) {{
            value = /* pop */que.pop();
            arr[index++] = value;
            if(value === dst) {
                for(let i : number = 0; i < index; i++) {console.info(arr[i]);}
                console.info("Steps countr :: " + steps);
                return steps;
            }
            steps++;
            if(value < dst) /* add */(que.push(value * 2)>0); else /* add */(que.push(value - 1)>0);
        }};
        return -1;
    }

    public static main3(args : string[]) {
        QueueEx.convertXY(2, 7);
    }

    public static maxSlidingWindows(arr : number[], size : number, k : number) {
        let que : Array<number> = <any>([]);
        for(let i : number = 0; i < size; i++) {{
            if(/* size */(<number>que.length) > 0 && /* peek */((s) => { return s[s.length-1]; })(que) <= i - k) /* pop */que.pop();
            while((/* size */(<number>que.length) > 0 && arr[/* peek */((s) => { return s[s.length-1]; })(que)] <= arr[i])) {/* pop */que.pop()};
            /* add */(que.push(i)>0);
            if(i >= (k - 1)) console.info(arr[/* peek */((s) => { return s[s.length-1]; })(que)]);
        };}
    }

    public static main4(args : string[]) {
        let arr : number[] = [11, 2, 75, 92, 59, 90, 55];
        let k : number = 3;
        QueueEx.maxSlidingWindows(arr, 7, 3);
    }

    public static minOfMaxSlidingWindows(arr : number[], size : number, k : number) : number {
        let que : Array<number> = <any>([]);
        let minVal : number = 999999;
        for(let i : number = 0; i < size; i++) {{
            if(/* size */(<number>que.length) > 0 && /* peek */((s) => { return s[s.length-1]; })(que) <= i - k) /* pop */que.pop();
            while((/* size */(<number>que.length) > 0 && arr[/* peek */((s) => { return s[s.length-1]; })(que)] <= arr[i])) {/* pop */que.pop()};
            /* add */(que.push(i)>0);
            if(i >= (k - 1) && minVal > arr[/* peek */((s) => { return s[s.length-1]; })(que)]) minVal = arr[/* peek */((s) => { return s[s.length-1]; })(que)];
        };}
        console.info("Min of max is :: " + minVal);
        return minVal;
    }

    public static main5(args : string[]) {
        let arr : number[] = [11, 2, 75, 92, 59, 90, 55];
        let k : number = 3;
        QueueEx.minOfMaxSlidingWindows(arr, 7, 3);
    }

    public static maxOfMinSlidingWindows(arr : number[], size : number, k : number) {
        let que : Array<number> = <any>([]);
        let maxVal : number = -999999;
        for(let i : number = 0; i < size; i++) {{
            if(/* size */(<number>que.length) > 0 && /* peek */((s) => { return s[s.length-1]; })(que) <= i - k) /* pop */que.pop();
            while((/* size */(<number>que.length) > 0 && arr[/* peek */((s) => { return s[s.length-1]; })(que)] >= arr[i])) {/* pop */que.pop()};
            /* add */(que.push(i)>0);
            if(i >= (k - 1) && maxVal < arr[/* peek */((s) => { return s[s.length-1]; })(que)]) maxVal = arr[/* peek */((s) => { return s[s.length-1]; })(que)];
        };}
        console.info("Max of min is :: " + maxVal);
    }

    public static main6(args : string[]) {
        let arr : number[] = [11, 2, 75, 92, 59, 90, 55];
        let k : number = 3;
        QueueEx.maxOfMinSlidingWindows(arr, 7, 3);
    }

    public static firstNegSlidingWindows(arr : number[], size : number, k : number) {
        let que : Array<number> = <any>([]);
        for(let i : number = 0; i < size; i++) {{
            if(/* size */(<number>que.length) > 0 && /* peek */((s) => { return s[s.length-1]; })(que) <= i - k) /* pop */que.pop();
            if(arr[i] < 0) /* add */(que.push(i)>0);
            if(i >= (k - 1)) {
                if(/* size */(<number>que.length) > 0) console.info(arr[/* peek */((s) => { return s[s.length-1]; })(que)]); else console.info("NAN");
            }
        };}
    }

    public static main(args : string[]) {
        let arr : number[] = [3, -2, -6, 10, -14, 50, 14, 21];
        let k : number = 3;
        QueueEx.firstNegSlidingWindows(arr, 8, 3);
    }
}
QueueEx["__class"] = "QueueEx";




QueueEx.main(null);
