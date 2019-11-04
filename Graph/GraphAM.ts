class GraphAM {
    count : number;
    adj : number[][];

    constructor(cnt : number) {
        if(this.count===undefined) this.count = 0;
        if(this.adj===undefined) this.adj = null;
        this.count = cnt;
        this.adj = <any> (function(dims) { let allocate = function(dims) { if(dims.length==0) { return 0; } else { let array = []; for(let i = 0; i < dims[0]; i++) { array.push(allocate(dims.slice(1))); } return array; }}; return allocate(dims);})([this.count, this.count]);
    }

    public addDirectedEdge(src : number, dst : number, cost : number) {
        this.adj[src][dst] = cost;
    }

    public addUndirectedEdge(src : number, dst : number, cost : number) {
        this.addDirectedEdge(src, dst, cost);
        this.addDirectedEdge(dst, src, cost);
    }

    public print() {
        for(let i : number = 0; i < this.count; i++) {{
            console.info("Node index [ " + i + " ] is connected with : ");
            for(let j : number = 0; j < this.count; j++) {{
                if(this.adj[i][j] !== 0) console.info(j + " ");
            };}
            console.info("");
        };}
    }

    public static main1() {
        let graph : GraphAM = new GraphAM(4);
        graph.addUndirectedEdge(0, 1, 1);
        graph.addUndirectedEdge(0, 2, 1);
        graph.addUndirectedEdge(1, 2, 1);
        graph.addUndirectedEdge(2, 3, 1);
        graph.print();
    }

    public static dijkstra(gph : GraphAM, source : number) {
        let previous : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(gph.count);
        let dist : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(gph.count);
        let visited : boolean[] = (s => { let a=[]; while(s-->0) a.push(false); return a; })(gph.count);
        for(let i : number = 0; i < gph.count; i++) {{
            previous[i] = -1;
            dist[i] = 2147483647;
            visited[i] = false;
        };}
        dist[source] = 0;
        previous[source] = -1;
        let comp : GraphAM.EdgeComparator = new GraphAM.EdgeComparator();
        let queue : PriorityQueue<GraphAM.Edge> = <any>(new PriorityQueue<GraphAM.Edge>(100, <any>(comp)));
        let node : GraphAM.Edge = new GraphAM.Edge(source, 0);
        queue.add(node);
        while((queue.isEmpty() !== true)) {{
            node = queue.peek();
            queue.remove();
            source = node.dest;
            visited[source] = true;
            for(let dest : number = 0; dest < gph.count; dest++) {{
                let cost : number = gph.adj[source][dest];
                if(cost !== 0) {
                    let alt : number = cost + dist[source];
                    if(dist[dest] > alt && visited[dest] === false) {
                        dist[dest] = alt;
                        previous[dest] = source;
                        node = new GraphAM.Edge(dest, alt);
                        queue.add(node);
                    }
                }
            };}
        }};
        let count : number = gph.count;
        for(let i : number = 0; i < count; i++) {{
            if(dist[i] === 2147483647) {
                console.info(" \n node id " + i + "  prev " + previous[i] + " distance : Unreachable");
            } else {
                console.info(" node id " + i + "  prev " + previous[i] + " distance : " + dist[i]);
            }
        };}
    }

    public static prims(gph : GraphAM) {
        let previous : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(gph.count);
        let dist : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(gph.count);
        let source : number = 0;
        let visited : boolean[] = (s => { let a=[]; while(s-->0) a.push(false); return a; })(gph.count);
        for(let i : number = 0; i < gph.count; i++) {{
            previous[i] = -1;
            dist[i] = 2147483647;
            visited[i] = false;
        };}
        dist[source] = 0;
        previous[source] = -1;
        let comp : GraphAM.EdgeComparator = new GraphAM.EdgeComparator();
        let queue : PriorityQueue<GraphAM.Edge> = <any>(new PriorityQueue<GraphAM.Edge>(100, <any>(comp)));
        let node : GraphAM.Edge = new GraphAM.Edge(source, 0);
        queue.add(node);
        while((queue.isEmpty() !== true)) {{
            node = queue.peek();
            queue.remove();
            source = node.dest;
            visited[source] = true;
            for(let dest : number = 0; dest < gph.count; dest++) {{
                let cost : number = gph.adj[source][dest];
                if(cost !== 0) {
                    let alt : number = cost;
                    if(dist[dest] > alt && visited[dest] === false) {
                        dist[dest] = alt;
                        previous[dest] = source;
                        node = new GraphAM.Edge(dest, alt);
                        queue.add(node);
                    }
                }
            };}
        }};
        let count : number = gph.count;
        for(let i : number = 0; i < count; i++) {{
            if(dist[i] === 2147483647) {
                console.info(" \n node id " + i + "  prev " + previous[i] + " distance : Unreachable");
            } else {
                console.info(" node id " + i + "  prev " + previous[i] + " distance : " + dist[i]);
            }
        };}
    }

    public static main2() {
        let gph : GraphAM = new GraphAM(9);
        gph.addUndirectedEdge(0, 1, 4);
        gph.addUndirectedEdge(0, 7, 8);
        gph.addUndirectedEdge(1, 2, 8);
        gph.addUndirectedEdge(1, 7, 11);
        gph.addUndirectedEdge(2, 3, 7);
        gph.addUndirectedEdge(2, 8, 2);
        gph.addUndirectedEdge(2, 5, 4);
        gph.addUndirectedEdge(3, 4, 9);
        gph.addUndirectedEdge(3, 5, 14);
        gph.addUndirectedEdge(4, 5, 10);
        gph.addUndirectedEdge(5, 6, 2);
        gph.addUndirectedEdge(6, 7, 1);
        gph.addUndirectedEdge(6, 8, 6);
        gph.addUndirectedEdge(7, 8, 7);
        gph.print();
        GraphAM.prims(gph);
        GraphAM.dijkstra(gph, 0);
    }

    public static main3() {
        let gph : GraphAM = new GraphAM(9);
        gph.addUndirectedEdge(0, 2, 1);
        gph.addUndirectedEdge(1, 2, 5);
        gph.addUndirectedEdge(1, 3, 7);
        gph.addUndirectedEdge(1, 4, 9);
        gph.addUndirectedEdge(3, 2, 2);
        gph.addUndirectedEdge(3, 5, 4);
        gph.addUndirectedEdge(4, 5, 6);
        gph.addUndirectedEdge(4, 6, 3);
        gph.addUndirectedEdge(5, 7, 1);
        gph.addUndirectedEdge(6, 7, 7);
        gph.addUndirectedEdge(7, 8, 17);
        gph.print();
        GraphAM.prims(gph);
        GraphAM.dijkstra(gph, 1);
    }

    public static hamiltonianPathUtil(graph : GraphAM, path : number[], pSize : number, added : number[]) : boolean {
        if(pSize === graph.count) {
            return true;
        }
        for(let vertex : number = 0; vertex < graph.count; vertex++) {{
            if(pSize === 0 || (graph.adj[path[pSize - 1]][vertex] === 1 && added[vertex] === 0)) {
                path[pSize++] = vertex;
                added[vertex] = 1;
                if(GraphAM.hamiltonianPathUtil(graph, path, pSize, added)) return true;
                pSize--;
                added[vertex] = 0;
            }
        };}
        return false;
    }

    public static hamiltonianPath(graph : GraphAM) : boolean {
        let path : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(graph.count);
        let added : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(graph.count);
        if(GraphAM.hamiltonianPathUtil(graph, path, 0, added)) {
            console.info("Hamiltonian Path found :: ");
            for(let i : number = 0; i < graph.count; i++) {console.info(" " + path[i]);}
            return true;
        }
        console.info("Hamiltonian Path not found");
        return false;
    }

    public static hamiltonianCycleUtil(graph : GraphAM, path : number[], pSize : number, added : number[]) : boolean {
        if(pSize === graph.count) {
            if(graph.adj[path[pSize - 1]][path[0]] === 1) {
                path[pSize] = path[0];
                return true;
            } else return false;
        }
        for(let vertex : number = 0; vertex < graph.count; vertex++) {{
            if(pSize === 0 || (graph.adj[path[pSize - 1]][vertex] === 1 && added[vertex] === 0)) {
                path[pSize++] = vertex;
                added[vertex] = 1;
                if(GraphAM.hamiltonianCycleUtil(graph, path, pSize, added)) return true;
                pSize--;
                added[vertex] = 0;
            }
        };}
        return false;
    }

    public static hamiltonianCycle(graph : GraphAM) : boolean {
        let path : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(graph.count + 1);
        let added : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(graph.count);
        if(GraphAM.hamiltonianCycleUtil(graph, path, 0, added)) {
            console.info("Hamiltonian Cycle found :: ");
            for(let i : number = 0; i <= graph.count; i++) {console.info(" " + path[i]);}
            return true;
        }
        console.info("Hamiltonian Cycle not found");
        return false;
    }

    public static main4() {
        let count : number = 5;
        let graph : GraphAM = new GraphAM(count);
        let adj : number[][] = [[0, 1, 0, 1, 0], [1, 0, 1, 1, 0], [0, 1, 0, 0, 1], [1, 1, 0, 0, 1], [0, 1, 1, 1, 0]];
        for(let i : number = 0; i < count; i++) {for(let j : number = 0; j < count; j++) {if(adj[i][j] === 1) graph.addDirectedEdge(i, j, 1);;};}
        console.info("hamiltonianPath : " + GraphAM.hamiltonianPath(graph));
        console.info("hamiltonianCycle : " + GraphAM.hamiltonianCycle(graph));
        let graph2 : GraphAM = new GraphAM(count);
        let adj2 : number[][] = [[0, 1, 0, 1, 0], [1, 0, 1, 1, 0], [0, 1, 0, 0, 1], [1, 1, 0, 0, 0], [0, 1, 1, 0, 0]];
        for(let i : number = 0; i < count; i++) {for(let j : number = 0; j < count; j++) {if(adj2[i][j] === 1) graph2.addDirectedEdge(i, j, 1);;};}
        console.info("hamiltonianPath :  " + GraphAM.hamiltonianPath(graph2));
        console.info("hamiltonianCycle :  " + GraphAM.hamiltonianCycle(graph2));
    }
}
GraphAM["__class"] = "GraphAM";


namespace GraphAM {

    export class Edge {
        dest : number;
        cost : number;

        public constructor(dst : number, cst : number) {
            if(this.dest===undefined) this.dest = 0;
            if(this.cost===undefined) this.cost = 0;
            this.dest = dst;
            this.cost = cst;
        }
    }
    Edge["__class"] = "GraphAM.Edge";

    export class EdgeComparator {
        public compare(x : GraphAM.Edge, y : GraphAM.Edge) : number {
            if(x.cost < y.cost) {
                return -1;
            }
            if(x.cost > y.cost) {
                return 1;
            }
            return 0;
        }

        constructor() {
        }
    }
    EdgeComparator["__class"] = "GraphAM.EdgeComparator";
    EdgeComparator["__interfaces"] = ["Comparator"];
}

GraphAM.main1();
GraphAM.main2();
GraphAM.main3();
GraphAM.main4();