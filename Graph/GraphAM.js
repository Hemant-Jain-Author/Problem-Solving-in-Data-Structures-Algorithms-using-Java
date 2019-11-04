var GraphAM = /** @class */ (function () {
    function GraphAM(cnt) {
        if (this.count === undefined)
            this.count = 0;
        if (this.adj === undefined)
            this.adj = null;
        this.count = cnt;
        this.adj = (function (dims) { var allocate = function (dims) { if (dims.length == 0) {
            return 0;
        }
        else {
            var array = [];
            for (var i = 0; i < dims[0]; i++) {
                array.push(allocate(dims.slice(1)));
            }
            return array;
        } }; return allocate(dims); })([this.count, this.count]);
    }
    GraphAM.prototype.addDirectedEdge = function (src, dst, cost) {
        this.adj[src][dst] = cost;
    };
    GraphAM.prototype.addUndirectedEdge = function (src, dst, cost) {
        this.addDirectedEdge(src, dst, cost);
        this.addDirectedEdge(dst, src, cost);
    };
    GraphAM.prototype.print = function () {
        for (var i = 0; i < this.count; i++) {
            {
                console.info("Node index [ " + i + " ] is connected with : ");
                for (var j = 0; j < this.count; j++) {
                    {
                        if (this.adj[i][j] !== 0)
                            console.info(j + " ");
                    }
                    ;
                }
                console.info("");
            }
            ;
        }
    };
    GraphAM.main1 = function () {
        var graph = new GraphAM(4);
        graph.addUndirectedEdge(0, 1, 1);
        graph.addUndirectedEdge(0, 2, 1);
        graph.addUndirectedEdge(1, 2, 1);
        graph.addUndirectedEdge(2, 3, 1);
        graph.print();
    };
    GraphAM.dijkstra = function (gph, source) {
        var previous = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(gph.count);
        var dist = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(gph.count);
        var visited = (function (s) { var a = []; while (s-- > 0)
            a.push(false); return a; })(gph.count);
        for (var i = 0; i < gph.count; i++) {
            {
                previous[i] = -1;
                dist[i] = 2147483647;
                visited[i] = false;
            }
            ;
        }
        dist[source] = 0;
        previous[source] = -1;
        var comp = new GraphAM.EdgeComparator();
        var queue = (new PriorityQueue(100, (comp)));
        var node = new GraphAM.Edge(source, 0);
        queue.add(node);
        while ((queue.isEmpty() !== true)) {
            {
                node = queue.peek();
                queue.remove();
                source = node.dest;
                visited[source] = true;
                for (var dest = 0; dest < gph.count; dest++) {
                    {
                        var cost = gph.adj[source][dest];
                        if (cost !== 0) {
                            var alt = cost + dist[source];
                            if (dist[dest] > alt && visited[dest] === false) {
                                dist[dest] = alt;
                                previous[dest] = source;
                                node = new GraphAM.Edge(dest, alt);
                                queue.add(node);
                            }
                        }
                    }
                    ;
                }
            }
        }
        ;
        var count = gph.count;
        for (var i = 0; i < count; i++) {
            {
                if (dist[i] === 2147483647) {
                    console.info(" \n node id " + i + "  prev " + previous[i] + " distance : Unreachable");
                }
                else {
                    console.info(" node id " + i + "  prev " + previous[i] + " distance : " + dist[i]);
                }
            }
            ;
        }
    };
    GraphAM.prims = function (gph) {
        var previous = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(gph.count);
        var dist = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(gph.count);
        var source = 0;
        var visited = (function (s) { var a = []; while (s-- > 0)
            a.push(false); return a; })(gph.count);
        for (var i = 0; i < gph.count; i++) {
            {
                previous[i] = -1;
                dist[i] = 2147483647;
                visited[i] = false;
            }
            ;
        }
        dist[source] = 0;
        previous[source] = -1;
        var comp = new GraphAM.EdgeComparator();
        var queue = (new PriorityQueue(100, (comp)));
        var node = new GraphAM.Edge(source, 0);
        queue.add(node);
        while ((queue.isEmpty() !== true)) {
            {
                node = queue.peek();
                queue.remove();
                source = node.dest;
                visited[source] = true;
                for (var dest = 0; dest < gph.count; dest++) {
                    {
                        var cost = gph.adj[source][dest];
                        if (cost !== 0) {
                            var alt = cost;
                            if (dist[dest] > alt && visited[dest] === false) {
                                dist[dest] = alt;
                                previous[dest] = source;
                                node = new GraphAM.Edge(dest, alt);
                                queue.add(node);
                            }
                        }
                    }
                    ;
                }
            }
        }
        ;
        var count = gph.count;
        for (var i = 0; i < count; i++) {
            {
                if (dist[i] === 2147483647) {
                    console.info(" \n node id " + i + "  prev " + previous[i] + " distance : Unreachable");
                }
                else {
                    console.info(" node id " + i + "  prev " + previous[i] + " distance : " + dist[i]);
                }
            }
            ;
        }
    };
    GraphAM.main2 = function () {
        var gph = new GraphAM(9);
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
    };
    GraphAM.main3 = function () {
        var gph = new GraphAM(9);
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
    };
    GraphAM.hamiltonianPathUtil = function (graph, path, pSize, added) {
        if (pSize === graph.count) {
            return true;
        }
        for (var vertex = 0; vertex < graph.count; vertex++) {
            {
                if (pSize === 0 || (graph.adj[path[pSize - 1]][vertex] === 1 && added[vertex] === 0)) {
                    path[pSize++] = vertex;
                    added[vertex] = 1;
                    if (GraphAM.hamiltonianPathUtil(graph, path, pSize, added))
                        return true;
                    pSize--;
                    added[vertex] = 0;
                }
            }
            ;
        }
        return false;
    };
    GraphAM.hamiltonianPath = function (graph) {
        var path = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(graph.count);
        var added = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(graph.count);
        if (GraphAM.hamiltonianPathUtil(graph, path, 0, added)) {
            console.info("Hamiltonian Path found :: ");
            for (var i = 0; i < graph.count; i++) {
                console.info(" " + path[i]);
            }
            return true;
        }
        console.info("Hamiltonian Path not found");
        return false;
    };
    GraphAM.hamiltonianCycleUtil = function (graph, path, pSize, added) {
        if (pSize === graph.count) {
            if (graph.adj[path[pSize - 1]][path[0]] === 1) {
                path[pSize] = path[0];
                return true;
            }
            else
                return false;
        }
        for (var vertex = 0; vertex < graph.count; vertex++) {
            {
                if (pSize === 0 || (graph.adj[path[pSize - 1]][vertex] === 1 && added[vertex] === 0)) {
                    path[pSize++] = vertex;
                    added[vertex] = 1;
                    if (GraphAM.hamiltonianCycleUtil(graph, path, pSize, added))
                        return true;
                    pSize--;
                    added[vertex] = 0;
                }
            }
            ;
        }
        return false;
    };
    GraphAM.hamiltonianCycle = function (graph) {
        var path = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(graph.count + 1);
        var added = (function (s) { var a = []; while (s-- > 0)
            a.push(0); return a; })(graph.count);
        if (GraphAM.hamiltonianCycleUtil(graph, path, 0, added)) {
            console.info("Hamiltonian Cycle found :: ");
            for (var i = 0; i <= graph.count; i++) {
                console.info(" " + path[i]);
            }
            return true;
        }
        console.info("Hamiltonian Cycle not found");
        return false;
    };
    GraphAM.main4 = function () {
        var count = 5;
        var graph = new GraphAM(count);
        var adj = [[0, 1, 0, 1, 0], [1, 0, 1, 1, 0], [0, 1, 0, 0, 1], [1, 1, 0, 0, 1], [0, 1, 1, 1, 0]];
        for (var i = 0; i < count; i++) {
            for (var j = 0; j < count; j++) {
                if (adj[i][j] === 1)
                    graph.addDirectedEdge(i, j, 1);
                ;
            }
            ;
        }
        console.info("hamiltonianPath : " + GraphAM.hamiltonianPath(graph));
        console.info("hamiltonianCycle : " + GraphAM.hamiltonianCycle(graph));
        var graph2 = new GraphAM(count);
        var adj2 = [[0, 1, 0, 1, 0], [1, 0, 1, 1, 0], [0, 1, 0, 0, 1], [1, 1, 0, 0, 0], [0, 1, 1, 0, 0]];
        for (var i = 0; i < count; i++) {
            for (var j = 0; j < count; j++) {
                if (adj2[i][j] === 1)
                    graph2.addDirectedEdge(i, j, 1);
                ;
            }
            ;
        }
        console.info("hamiltonianPath :  " + GraphAM.hamiltonianPath(graph2));
        console.info("hamiltonianCycle :  " + GraphAM.hamiltonianCycle(graph2));
    };
    return GraphAM;
}());
GraphAM["__class"] = "GraphAM";
(function (GraphAM) {
    var Edge = /** @class */ (function () {
        function Edge(dst, cst) {
            if (this.dest === undefined)
                this.dest = 0;
            if (this.cost === undefined)
                this.cost = 0;
            this.dest = dst;
            this.cost = cst;
        }
        return Edge;
    }());
    GraphAM.Edge = Edge;
    Edge["__class"] = "GraphAM.Edge";
    var EdgeComparator = /** @class */ (function () {
        function EdgeComparator() {
        }
        EdgeComparator.prototype.compare = function (x, y) {
            if (x.cost < y.cost) {
                return -1;
            }
            if (x.cost > y.cost) {
                return 1;
            }
            return 0;
        };
        return EdgeComparator;
    }());
    GraphAM.EdgeComparator = EdgeComparator;
    EdgeComparator["__class"] = "GraphAM.EdgeComparator";
    EdgeComparator["__interfaces"] = ["Comparator"];
})(GraphAM || (GraphAM = {}));
GraphAM.main1();
GraphAM.main2();
GraphAM.main3();
GraphAM.main4();
