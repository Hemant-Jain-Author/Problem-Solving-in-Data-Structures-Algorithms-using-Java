/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
class Tree {
    /*private*/ root : Tree.Node;

    public constructor() {
        if(this.root===undefined) this.root = null;
        this.root = null;
    }

    public levelOrderBinaryTree$int_A(arr : number[]) {
        this.root = this.levelOrderBinaryTree$int_A$int(arr, 0);
    }

    public levelOrderBinaryTree$int_A$int(arr : number[], start : number) : Tree.Node {
        let size : number = arr.length;
        let curr : Tree.Node = new Tree.Node(arr[start]);
        let left : number = 2 * start + 1;
        let right : number = 2 * start + 2;
        if(left < size) curr.lChild = this.levelOrderBinaryTree$int_A$int(arr, left);
        if(right < size) curr.rChild = this.levelOrderBinaryTree$int_A$int(arr, right);
        return curr;
    }

    public levelOrderBinaryTree(arr? : any, start? : any) : any {
        if(((arr != null && arr instanceof <any>Array && (arr.length==0 || arr[0] == null ||(typeof arr[0] === 'number'))) || arr === null) && ((typeof start === 'number') || start === null)) {
            return <any>this.levelOrderBinaryTree$int_A$int(arr, start);
        } else if(((arr != null && arr instanceof <any>Array && (arr.length==0 || arr[0] == null ||(typeof arr[0] === 'number'))) || arr === null) && start === undefined) {
            return <any>this.levelOrderBinaryTree$int_A(arr);
        } else throw new Error('invalid overload');
    }

    public InsertNode$int(value : number) {
        this.root = this.InsertNode$Tree_Node$int(this.root, value);
    }

    public InsertNode$Tree_Node$int(node : Tree.Node, value : number) : Tree.Node {
        if(node == null) {
            node = new Tree.Node(value, null, null);
        } else {
            if(node.value > value) {
                node.lChild = this.InsertNode$Tree_Node$int(node.lChild, value);
            } else {
                node.rChild = this.InsertNode$Tree_Node$int(node.rChild, value);
            }
        }
        return node;
    }

    public InsertNode(node? : any, value? : any) : any {
        if(((node != null && node instanceof <any>Tree.Node) || node === null) && ((typeof value === 'number') || value === null)) {
            return <any>this.InsertNode$Tree_Node$int(node, value);
        } else if(((typeof node === 'number') || node === null) && value === undefined) {
            return <any>this.InsertNode$int(node);
        } else throw new Error('invalid overload');
    }

    public PrintPreOrder$() {
        this.PrintPreOrder$Tree_Node(this.root);
    }

    public PrintPreOrder$Tree_Node(node : Tree.Node) {
        if(node != null) {
            console.info(" " + node.value);
            this.PrintPreOrder$Tree_Node(node.lChild);
            this.PrintPreOrder$Tree_Node(node.rChild);
        }
    }

    public PrintPreOrder(node? : any) : any {
        if(((node != null && node instanceof <any>Tree.Node) || node === null)) {
            return <any>this.PrintPreOrder$Tree_Node(node);
        } else if(node === undefined) {
            return <any>this.PrintPreOrder$();
        } else throw new Error('invalid overload');
    }

    public NthPreOrder$int(index : number) {
        let counter : number[] = [0];
        this.NthPreOrder$Tree_Node$int$int_A(this.root, index, counter);
    }

    public NthPreOrder$Tree_Node$int$int_A(node : Tree.Node, index : number, counter : number[]) {
        if(node != null) {
            counter[0]++;
            if(counter[0] === index) {
                console.info(node.value);
            }
            this.NthPreOrder$Tree_Node$int$int_A(node.lChild, index, counter);
            this.NthPreOrder$Tree_Node$int$int_A(node.rChild, index, counter);
        }
    }

    public NthPreOrder(node? : any, index? : any, counter? : any) : any {
        if(((node != null && node instanceof <any>Tree.Node) || node === null) && ((typeof index === 'number') || index === null) && ((counter != null && counter instanceof <any>Array && (counter.length==0 || counter[0] == null ||(typeof counter[0] === 'number'))) || counter === null)) {
            return <any>this.NthPreOrder$Tree_Node$int$int_A(node, index, counter);
        } else if(((typeof node === 'number') || node === null) && index === undefined && counter === undefined) {
            return <any>this.NthPreOrder$int(node);
        } else throw new Error('invalid overload');
    }

    public PrintPostOrder$() {
        this.PrintPostOrder$Tree_Node(this.root);
    }

    public PrintPostOrder$Tree_Node(node : Tree.Node) {
        if(node != null) {
            this.PrintPostOrder$Tree_Node(node.lChild);
            this.PrintPostOrder$Tree_Node(node.rChild);
            console.info(" " + node.value);
        }
    }

    public PrintPostOrder(node? : any) : any {
        if(((node != null && node instanceof <any>Tree.Node) || node === null)) {
            return <any>this.PrintPostOrder$Tree_Node(node);
        } else if(node === undefined) {
            return <any>this.PrintPostOrder$();
        } else throw new Error('invalid overload');
    }

    public NthPostOrder$int(index : number) {
        let counter : number[] = [0];
        this.NthPostOrder$Tree_Node$int$int_A(this.root, index, counter);
    }

    public NthPostOrder$Tree_Node$int$int_A(node : Tree.Node, index : number, counter : number[]) {
        if(node != null) {
            this.NthPostOrder$Tree_Node$int$int_A(node.lChild, index, counter);
            this.NthPostOrder$Tree_Node$int$int_A(node.rChild, index, counter);
            counter[0]++;
            if(counter[0] === index) {
                console.info(" " + node.value);
            }
        }
    }

    public NthPostOrder(node? : any, index? : any, counter? : any) : any {
        if(((node != null && node instanceof <any>Tree.Node) || node === null) && ((typeof index === 'number') || index === null) && ((counter != null && counter instanceof <any>Array && (counter.length==0 || counter[0] == null ||(typeof counter[0] === 'number'))) || counter === null)) {
            return <any>this.NthPostOrder$Tree_Node$int$int_A(node, index, counter);
        } else if(((typeof node === 'number') || node === null) && index === undefined && counter === undefined) {
            return <any>this.NthPostOrder$int(node);
        } else throw new Error('invalid overload');
    }

    public PrintInOrder$() {
        this.PrintInOrder$Tree_Node(this.root);
    }

    public PrintInOrder$Tree_Node(node : Tree.Node) {
        if(node != null) {
            this.PrintInOrder$Tree_Node(node.lChild);
            console.info(" " + node.value);
            this.PrintInOrder$Tree_Node(node.rChild);
        }
    }

    public PrintInOrder(node? : any) : any {
        if(((node != null && node instanceof <any>Tree.Node) || node === null)) {
            return <any>this.PrintInOrder$Tree_Node(node);
        } else if(node === undefined) {
            return <any>this.PrintInOrder$();
        } else throw new Error('invalid overload');
    }

    public NthInOrder$int(index : number) {
        let counter : number[] = [0];
        this.NthInOrder$Tree_Node$int$int_A(this.root, index, counter);
    }

    public NthInOrder$Tree_Node$int$int_A(node : Tree.Node, index : number, counter : number[]) {
        if(node != null) {
            this.NthInOrder$Tree_Node$int$int_A(node.lChild, index, counter);
            counter[0]++;
            if(counter[0] === index) {
                console.info(" " + node.value);
            }
            this.NthInOrder$Tree_Node$int$int_A(node.rChild, index, counter);
        }
    }

    public NthInOrder(node? : any, index? : any, counter? : any) : any {
        if(((node != null && node instanceof <any>Tree.Node) || node === null) && ((typeof index === 'number') || index === null) && ((counter != null && counter instanceof <any>Array && (counter.length==0 || counter[0] == null ||(typeof counter[0] === 'number'))) || counter === null)) {
            return <any>this.NthInOrder$Tree_Node$int$int_A(node, index, counter);
        } else if(((typeof node === 'number') || node === null) && index === undefined && counter === undefined) {
            return <any>this.NthInOrder$int(node);
        } else throw new Error('invalid overload');
    }

    public PrintBredthFirst() {
        let que : Array<Tree.Node> = <any>([]);
        let temp : Tree.Node;
        if(this.root != null) /* add */(que.push(this.root)>0);
        while((/* isEmpty */(que.length == 0) === false)) {{
            temp = /* pop */que.pop();
            console.info(" " + temp.value);
            if(temp.lChild != null) /* add */(que.push(temp.lChild)>0);
            if(temp.rChild != null) /* add */(que.push(temp.rChild)>0);
        }};
    }

    public PrintDepthFirst() {
        let stk : Array<Tree.Node> = <any>([]);
        let temp : Tree.Node;
        if(this.root != null) /* push */(stk.push(this.root)>0);
        while((/* isEmpty */(stk.length == 0) === false)) {{
            temp = /* pop */stk.pop();
            console.info(temp.value);
            if(temp.lChild != null) /* push */(stk.push(temp.lChild)>0);
            if(temp.rChild != null) /* push */(stk.push(temp.rChild)>0);
        }};
    }

    PrintLevelOrderLineByLine() {
        let que1 : Array<Tree.Node> = <any>([]);
        let que2 : Array<Tree.Node> = <any>([]);
        let temp : Tree.Node = null;
        if(this.root != null) /* add */(que1.push(this.root)>0);
        while((/* size */(<number>que1.length) !== 0 || /* size */(<number>que2.length) !== 0)) {{
            while((/* size */(<number>que1.length) !== 0)) {{
                temp = /* pop */que1.pop();
                console.info(" " + temp.value);
                if(temp.lChild != null) /* add */(que2.push(temp.lChild)>0);
                if(temp.rChild != null) /* add */(que2.push(temp.rChild)>0);
            }};
            console.info("");
            while((/* size */(<number>que2.length) !== 0)) {{
                temp = <Tree.Node>/* pop */que2.pop();
                console.info(" " + temp.value);
                if(temp.lChild != null) /* add */(que1.push(temp.lChild)>0);
                if(temp.rChild != null) /* add */(que1.push(temp.rChild)>0);
            }};
            console.info("");
        }};
    }

    PrintLevelOrderLineByLine2() {
        let que : Array<Tree.Node> = <any>([]);
        let temp : Tree.Node = null;
        let count : number = 0;
        if(this.root != null) /* add */(que.push(this.root)>0);
        while((/* size */(<number>que.length) !== 0)) {{
            count = /* size */(<number>que.length);
            while((count > 0)) {{
                temp = /* pop */que.pop();
                console.info(" " + temp.value);
                if(temp.lChild != null) /* add */(que.push(temp.lChild)>0);
                if(temp.rChild != null) /* add */(que.push(temp.rChild)>0);
                count -= 1;
            }};
            console.info("");
        }};
    }

    PrintSpiralTree() {
        let stk1 : Array<Tree.Node> = <any>([]);
        let stk2 : Array<Tree.Node> = <any>([]);
        let temp : Tree.Node;
        if(this.root != null) /* push */(stk1.push(this.root)>0);
        while((/* size */(<number>stk1.length) !== 0 || /* size */(<number>stk2.length) !== 0)) {{
            while((/* size */(<number>stk1.length) !== 0)) {{
                temp = /* pop */stk1.pop();
                console.info(" " + temp.value);
                if(temp.rChild != null) /* push */(stk2.push(temp.rChild)>0);
                if(temp.lChild != null) /* push */(stk2.push(temp.lChild)>0);
            }};
            while((/* size */(<number>stk2.length) !== 0)) {{
                temp = /* pop */stk2.pop();
                console.info(" " + temp.value);
                if(temp.lChild != null) /* push */(stk1.push(temp.lChild)>0);
                if(temp.rChild != null) /* push */(stk1.push(temp.rChild)>0);
            }};
        }};
    }

    public Find(value : number) : boolean {
        let curr : Tree.Node = this.root;
        while((curr != null)) {{
            if(curr.value === value) {
                return true;
            } else if(curr.value > value) {
                curr = curr.lChild;
            } else {
                curr = curr.rChild;
            }
        }};
        return false;
    }

    public Find2(value : number) : boolean {
        let curr : Tree.Node = this.root;
        while((curr != null && curr.value !== value)) {curr = (curr.value > value)?curr.lChild:curr.rChild};
        return curr != null;
    }

    public FindMin() : number {
        let node : Tree.Node = this.root;
        if(node == null) {
            return 2147483647;
        }
        while((node.lChild != null)) {{
            node = node.lChild;
        }};
        return node.value;
    }

    public FindMax() : number {
        let node : Tree.Node = this.root;
        if(node == null) {
            return -2147483648;
        }
        while((node.rChild != null)) {{
            node = node.rChild;
        }};
        return node.value;
    }

    public FindMaxNode(curr : Tree.Node) : Tree.Node {
        let node : Tree.Node = curr;
        if(node == null) {
            return null;
        }
        while((node.rChild != null)) {{
            node = node.rChild;
        }};
        return node;
    }

    public FindMinNode(curr : Tree.Node) : Tree.Node {
        let node : Tree.Node = curr;
        if(node == null) {
            return null;
        }
        while((node.lChild != null)) {{
            node = node.lChild;
        }};
        return node;
    }

    public Free() {
        this.root = null;
    }

    public DeleteNode$int(value : number) {
        this.root = this.DeleteNode$Tree_Node$int(this.root, value);
    }

    public DeleteNode$Tree_Node$int(node : Tree.Node, value : number) : Tree.Node {
        let temp : Tree.Node = null;
        if(node != null) {
            if(node.value === value) {
                if(node.lChild == null && node.rChild == null) {
                    return null;
                } else {
                    if(node.lChild == null) {
                        temp = node.rChild;
                        return temp;
                    }
                    if(node.rChild == null) {
                        temp = node.lChild;
                        return temp;
                    }
                    let minNode : Tree.Node = this.FindMinNode(node.rChild);
                    let minValue : number = minNode.value;
                    node.value = minValue;
                    node.rChild = this.DeleteNode$Tree_Node$int(node.rChild, minValue);
                }
            } else {
                if(node.value > value) {
                    node.lChild = this.DeleteNode$Tree_Node$int(node.lChild, value);
                } else {
                    node.rChild = this.DeleteNode$Tree_Node$int(node.rChild, value);
                }
            }
        }
        return node;
    }

    public DeleteNode(node? : any, value? : any) : any {
        if(((node != null && node instanceof <any>Tree.Node) || node === null) && ((typeof value === 'number') || value === null)) {
            return <any>this.DeleteNode$Tree_Node$int(node, value);
        } else if(((typeof node === 'number') || node === null) && value === undefined) {
            return <any>this.DeleteNode$int(node);
        } else throw new Error('invalid overload');
    }

    public TreeDepth$() : number {
        return this.TreeDepth$Tree_Node(this.root);
    }

    public TreeDepth$Tree_Node(curr : Tree.Node) : number {
        if(curr == null) return 0; else {
            let lDepth : number = this.TreeDepth$Tree_Node(curr.lChild);
            let rDepth : number = this.TreeDepth$Tree_Node(curr.rChild);
            if(lDepth > rDepth) return lDepth + 1; else return rDepth + 1;
        }
    }

    public TreeDepth(curr? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null)) {
            return <any>this.TreeDepth$Tree_Node(curr);
        } else if(curr === undefined) {
            return <any>this.TreeDepth$();
        } else throw new Error('invalid overload');
    }

    public isEqual(T2 : Tree) : boolean {
        return this.isEqualUtil(this.root, T2.root);
    }

    isEqualUtil(node1 : Tree.Node, node2 : Tree.Node) : boolean {
        if(node1 == null && node2 == null) return true; else if(node1 == null || node2 == null) return false; else return (this.isEqualUtil(node1.lChild, node2.lChild) && this.isEqualUtil(node1.rChild, node2.rChild) && (node1.value === node2.value));
    }

    public Ancestor$int$int(first : number, second : number) : Tree.Node {
        if(first > second) {
            let temp : number = first;
            first = second;
            second = temp;
        }
        return this.Ancestor$Tree_Node$int$int(this.root, first, second);
    }

    public Ancestor$Tree_Node$int$int(curr : Tree.Node, first : number, second : number) : Tree.Node {
        if(curr == null) {
            return null;
        }
        if(curr.value > first && curr.value > second) {
            return this.Ancestor$Tree_Node$int$int(curr.lChild, first, second);
        }
        if(curr.value < first && curr.value < second) {
            return this.Ancestor$Tree_Node$int$int(curr.rChild, first, second);
        }
        return curr;
    }

    public Ancestor(curr? : any, first? : any, second? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null) && ((typeof first === 'number') || first === null) && ((typeof second === 'number') || second === null)) {
            return <any>this.Ancestor$Tree_Node$int$int(curr, first, second);
        } else if(((typeof curr === 'number') || curr === null) && ((typeof first === 'number') || first === null) && second === undefined) {
            return <any>this.Ancestor$int$int(curr, first);
        } else throw new Error('invalid overload');
    }

    public CopyTree$() : Tree {
        let tree2 : Tree = new Tree();
        tree2.root = this.CopyTree$Tree_Node(this.root);
        return tree2;
    }

    public CopyTree$Tree_Node(curr : Tree.Node) : Tree.Node {
        let temp : Tree.Node;
        if(curr != null) {
            temp = new Tree.Node(curr.value);
            temp.lChild = this.CopyTree$Tree_Node(curr.lChild);
            temp.rChild = this.CopyTree$Tree_Node(curr.rChild);
            return temp;
        } else return null;
    }

    public CopyTree(curr? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null)) {
            return <any>this.CopyTree$Tree_Node(curr);
        } else if(curr === undefined) {
            return <any>this.CopyTree$();
        } else throw new Error('invalid overload');
    }

    public CopyMirrorTree$() : Tree {
        let tree2 : Tree = new Tree();
        tree2.root = this.CopyMirrorTree$Tree_Node(this.root);
        return tree2;
    }

    public CopyMirrorTree$Tree_Node(curr : Tree.Node) : Tree.Node {
        let temp : Tree.Node;
        if(curr != null) {
            temp = new Tree.Node(curr.value);
            temp.rChild = this.CopyMirrorTree$Tree_Node(curr.lChild);
            temp.lChild = this.CopyMirrorTree$Tree_Node(curr.rChild);
            return temp;
        } else return null;
    }

    public CopyMirrorTree(curr? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null)) {
            return <any>this.CopyMirrorTree$Tree_Node(curr);
        } else if(curr === undefined) {
            return <any>this.CopyMirrorTree$();
        } else throw new Error('invalid overload');
    }

    public numNodes$() : number {
        return this.numNodes$Tree_Node(this.root);
    }

    public numNodes$Tree_Node(curr : Tree.Node) : number {
        if(curr == null) return 0; else return (1 + this.numNodes$Tree_Node(curr.rChild) + this.numNodes$Tree_Node(curr.lChild));
    }

    public numNodes(curr? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null)) {
            return <any>this.numNodes$Tree_Node(curr);
        } else if(curr === undefined) {
            return <any>this.numNodes$();
        } else throw new Error('invalid overload');
    }

    public numFullNodesBT$() : number {
        return this.numNodes$Tree_Node(this.root);
    }

    public numFullNodesBT$Tree_Node(curr : Tree.Node) : number {
        let count : number;
        if(curr == null) return 0;
        count = this.numFullNodesBT$Tree_Node(curr.rChild) + this.numFullNodesBT$Tree_Node(curr.lChild);
        if(curr.rChild != null && curr.lChild != null) count++;
        return count;
    }

    public numFullNodesBT(curr? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null)) {
            return <any>this.numFullNodesBT$Tree_Node(curr);
        } else if(curr === undefined) {
            return <any>this.numFullNodesBT$();
        } else throw new Error('invalid overload');
    }

    public maxLengthPathBT$() : number {
        return this.maxLengthPathBT$Tree_Node(this.root);
    }

    public maxLengthPathBT$Tree_Node(curr : Tree.Node) : number {
        let max : number;
        let leftPath : number;
        let rightPath : number;
        let leftMax : number;
        let rightMax : number;
        if(curr == null) return 0;
        leftPath = this.TreeDepth$Tree_Node(curr.lChild);
        rightPath = this.TreeDepth$Tree_Node(curr.rChild);
        max = leftPath + rightPath + 1;
        leftMax = this.maxLengthPathBT$Tree_Node(curr.lChild);
        rightMax = this.maxLengthPathBT$Tree_Node(curr.rChild);
        if(leftMax > max) max = leftMax;
        if(rightMax > max) max = rightMax;
        return max;
    }

    public maxLengthPathBT(curr? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null)) {
            return <any>this.maxLengthPathBT$Tree_Node(curr);
        } else if(curr === undefined) {
            return <any>this.maxLengthPathBT$();
        } else throw new Error('invalid overload');
    }

    public numLeafNodes$() : number {
        return this.numLeafNodes$Tree_Node(this.root);
    }

    public numLeafNodes$Tree_Node(curr : Tree.Node) : number {
        if(curr == null) return 0;
        if(curr.lChild == null && curr.rChild == null) return 1; else return (this.numLeafNodes$Tree_Node(curr.rChild) + this.numLeafNodes$Tree_Node(curr.lChild));
    }

    public numLeafNodes(curr? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null)) {
            return <any>this.numLeafNodes$Tree_Node(curr);
        } else if(curr === undefined) {
            return <any>this.numLeafNodes$();
        } else throw new Error('invalid overload');
    }

    public sumAllBT$() : number {
        return this.sumAllBT$Tree_Node(this.root);
    }

    public sumAllBT$Tree_Node(curr : Tree.Node) : number {
        if(curr == null) return 0;
        return (curr.value + this.sumAllBT$Tree_Node(curr.lChild) + this.sumAllBT$Tree_Node(curr.lChild));
    }

    public sumAllBT(curr? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null)) {
            return <any>this.sumAllBT$Tree_Node(curr);
        } else if(curr === undefined) {
            return <any>this.sumAllBT$();
        } else throw new Error('invalid overload');
    }

    public iterativePreOrder() {
        let stk : Array<Tree.Node> = <any>([]);
        let curr : Tree.Node;
        if(this.root != null) /* add */(stk.push(this.root)>0);
        while((/* isEmpty */(stk.length == 0) === false)) {{
            curr = /* pop */stk.pop();
            console.info(curr.value + " ");
            if(curr.rChild != null) /* push */(stk.push(curr.rChild)>0);
            if(curr.lChild != null) /* push */(stk.push(curr.lChild)>0);
        }};
    }

    public iterativePostOrder() {
        let stk : Array<Tree.Node> = <any>([]);
        let visited : Array<number> = <any>([]);
        let curr : Tree.Node;
        let vtd : number;
        if(this.root != null) {
            /* add */(stk.push(this.root)>0);
            /* add */(visited.push(0)>0);
        }
        while((/* isEmpty */(stk.length == 0) === false)) {{
            curr = /* pop */stk.pop();
            vtd = /* pop */visited.pop();
            if(vtd === 1) {
                console.info(curr.value + " ");
            } else {
                /* push */(stk.push(curr)>0);
                /* push */(visited.push(1)>0);
                if(curr.rChild != null) {
                    /* push */(stk.push(curr.rChild)>0);
                    /* push */(visited.push(0)>0);
                }
                if(curr.lChild != null) {
                    /* push */(stk.push(curr.lChild)>0);
                    /* push */(visited.push(0)>0);
                }
            }
        }};
    }

    public iterativeInOrder() {
        let stk : Array<Tree.Node> = <any>([]);
        let visited : Array<number> = <any>([]);
        let curr : Tree.Node;
        let vtd : number;
        if(this.root != null) {
            /* add */(stk.push(this.root)>0);
            /* add */(visited.push(0)>0);
        }
        while((/* isEmpty */(stk.length == 0) === false)) {{
            curr = /* pop */stk.pop();
            vtd = /* pop */visited.pop();
            if(vtd === 1) {
                console.info(curr.value + " ");
            } else {
                if(curr.rChild != null) {
                    /* push */(stk.push(curr.rChild)>0);
                    /* push */(visited.push(0)>0);
                }
                /* push */(stk.push(curr)>0);
                /* push */(visited.push(1)>0);
                if(curr.lChild != null) {
                    /* push */(stk.push(curr.lChild)>0);
                    /* push */(visited.push(0)>0);
                }
            }
        }};
    }

    public isBST3(root : Tree.Node) : boolean {
        if(root == null) return true;
        if(root.lChild != null && this.FindMaxNode(root.lChild).value > root.value) return false;
        if(root.rChild != null && this.FindMinNode(root.rChild).value <= root.value) return false;
        return (this.isBST3(root.lChild) && this.isBST3(root.rChild));
    }

    public isBST$() : boolean {
        return this.isBST$Tree_Node$int$int(this.root, -2147483648, 2147483647);
    }

    public isBST$Tree_Node$int$int(curr : Tree.Node, min : number, max : number) : boolean {
        if(curr == null) return true;
        if(curr.value < min || curr.value > max) return false;
        return this.isBST$Tree_Node$int$int(curr.lChild, min, curr.value) && this.isBST$Tree_Node$int$int(curr.rChild, curr.value, max);
    }

    public isBST(curr? : any, min? : any, max? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null) && ((typeof min === 'number') || min === null) && ((typeof max === 'number') || max === null)) {
            return <any>this.isBST$Tree_Node$int$int(curr, min, max);
        } else if(curr === undefined && min === undefined && max === undefined) {
            return <any>this.isBST$();
        } else throw new Error('invalid overload');
    }

    public isBST2$() : boolean {
        let count : number[] = [0];
        return this.isBST2$Tree_Node$int_A(this.root, count);
    }

    public isBST2$Tree_Node$int_A(root : Tree.Node, count : number[]) : boolean {
        let ret : boolean;
        if(root != null) {
            ret = this.isBST2$Tree_Node$int_A(root.lChild, count);
            if(!ret) return false;
            if(count[0] > root.value) return false;
            count[0] = root.value;
            ret = this.isBST2$Tree_Node$int_A(root.rChild, count);
            if(!ret) return false;
        }
        return true;
    }

    public isBST2(root? : any, count? : any) : any {
        if(((root != null && root instanceof <any>Tree.Node) || root === null) && ((count != null && count instanceof <any>Array && (count.length==0 || count[0] == null ||(typeof count[0] === 'number'))) || count === null)) {
            return <any>this.isBST2$Tree_Node$int_A(root, count);
        } else if(root === undefined && count === undefined) {
            return <any>this.isBST2$();
        } else throw new Error('invalid overload');
    }

    isCompleteTree() : boolean {
        let que : Array<Tree.Node> = <any>([]);
        let temp : Tree.Node = null;
        let noChild : number = 0;
        if(this.root != null) /* add */(que.push(this.root)>0);
        while((/* size */(<number>que.length) !== 0)) {{
            temp = /* pop */que.pop();
            if(temp.lChild != null) {
                if(noChild === 1) return false;
                /* add */(que.push(temp.lChild)>0);
            } else noChild = 1;
            if(temp.rChild != null) {
                if(noChild === 1) return false;
                /* add */(que.push(temp.rChild)>0);
            } else noChild = 1;
        }};
        return true;
    }

    isCompleteTreeUtil(curr : Tree.Node, index : number, count : number) : boolean {
        if(curr == null) return true;
        if(index > count) return false;
        return this.isCompleteTreeUtil(curr.lChild, index * 2 + 1, count) && this.isCompleteTreeUtil(curr.rChild, index * 2 + 2, count);
    }

    isCompleteTree2() : boolean {
        let count : number = this.numNodes();
        return this.isCompleteTreeUtil(this.root, 0, count);
    }

    isHeapUtil(curr : Tree.Node, parentValue : number) : boolean {
        if(curr == null) return true;
        if(curr.value < parentValue) return false;
        return (this.isHeapUtil(curr.lChild, curr.value) && this.isHeapUtil(curr.rChild, curr.value));
    }

    isHeap() : boolean {
        let infi : number = -9999999;
        return (this.isCompleteTree() && this.isHeapUtil(this.root, infi));
    }

    isHeapUtil2(curr : Tree.Node, index : number, count : number, parentValue : number) : boolean {
        if(curr == null) return true;
        if(index > count) return false;
        if(curr.value < parentValue) return false;
        return this.isHeapUtil2(curr.lChild, index * 2 + 1, count, curr.value) && this.isHeapUtil2(curr.rChild, index * 2 + 2, count, curr.value);
    }

    isHeap2() : boolean {
        let count : number = this.numNodes();
        let parentValue : number = -9999999;
        return this.isHeapUtil2(this.root, 0, count, parentValue);
    }

    public treeToListRec$() : Tree.Node {
        let head : Tree.Node = this.treeToListRec$Tree_Node(this.root);
        let temp : Tree.Node = head;
        return temp;
    }

    public treeToListRec$Tree_Node(curr : Tree.Node) : Tree.Node {
        let Head : Tree.Node = null;
        let Tail : Tree.Node = null;
        if(curr == null) return null;
        if(curr.lChild == null && curr.rChild == null) {
            curr.lChild = curr;
            curr.rChild = curr;
            return curr;
        }
        if(curr.lChild != null) {
            Head = this.treeToListRec$Tree_Node(curr.lChild);
            Tail = Head.lChild;
            curr.lChild = Tail;
            Tail.rChild = curr;
        } else Head = curr;
        if(curr.rChild != null) {
            let tempHead : Tree.Node = this.treeToListRec$Tree_Node(curr.rChild);
            Tail = tempHead.lChild;
            curr.rChild = tempHead;
            tempHead.lChild = curr;
        } else Tail = curr;
        Head.lChild = Tail;
        Tail.rChild = Head;
        return Head;
    }

    public treeToListRec(curr? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null)) {
            return <any>this.treeToListRec$Tree_Node(curr);
        } else if(curr === undefined) {
            return <any>this.treeToListRec$();
        } else throw new Error('invalid overload');
    }

    public printAllPath() {
        let stk : Array<number> = <any>([]);
        this.printAllPathUtil(this.root, stk);
    }

    printAllPathUtil(curr : Tree.Node, stk : Array<number>) {
        if(curr == null) return;
        /* push */(stk.push(curr.value)>0);
        if(curr.lChild == null && curr.rChild == null) {
            console.info(stk);
            /* pop */stk.pop();
            return;
        }
        this.printAllPathUtil(curr.rChild, stk);
        this.printAllPathUtil(curr.lChild, stk);
        /* pop */stk.pop();
    }

    public LCA$int$int(first : number, second : number) : number {
        let ans : Tree.Node = this.LCA$Tree_Node$int$int(this.root, first, second);
        if(ans != null) return ans.value; else return -2147483648;
    }

    public LCA$Tree_Node$int$int(curr : Tree.Node, first : number, second : number) : Tree.Node {
        let left : Tree.Node;
        let right : Tree.Node;
        if(curr == null) return null;
        if(curr.value === first || curr.value === second) return curr;
        left = this.LCA$Tree_Node$int$int(curr.lChild, first, second);
        right = this.LCA$Tree_Node$int$int(curr.rChild, first, second);
        if(left != null && right != null) return curr; else if(left != null) return left; else return right;
    }

    public LCA(curr? : any, first? : any, second? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null) && ((typeof first === 'number') || first === null) && ((typeof second === 'number') || second === null)) {
            return <any>this.LCA$Tree_Node$int$int(curr, first, second);
        } else if(((typeof curr === 'number') || curr === null) && ((typeof first === 'number') || first === null) && second === undefined) {
            return <any>this.LCA$int$int(curr, first);
        } else throw new Error('invalid overload');
    }

    public LcaBST$int$int(first : number, second : number) : number {
        return this.LcaBST$Tree_Node$int$int(this.root, first, second);
    }

    public LcaBST$Tree_Node$int$int(curr : Tree.Node, first : number, second : number) : number {
        if(curr == null) {
            return 2147483647;
        }
        if(curr.value > first && curr.value > second) {
            return this.LcaBST$Tree_Node$int$int(curr.lChild, first, second);
        }
        if(curr.value < first && curr.value < second) {
            return this.LcaBST$Tree_Node$int$int(curr.rChild, first, second);
        }
        return curr.value;
    }

    public LcaBST(curr? : any, first? : any, second? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null) && ((typeof first === 'number') || first === null) && ((typeof second === 'number') || second === null)) {
            return <any>this.LcaBST$Tree_Node$int$int(curr, first, second);
        } else if(((typeof curr === 'number') || curr === null) && ((typeof first === 'number') || first === null) && second === undefined) {
            return <any>this.LcaBST$int$int(curr, first);
        } else throw new Error('invalid overload');
    }

    public trimOutsideRange$int$int(min : number, max : number) {
        this.trimOutsideRange$Tree_Node$int$int(this.root, min, max);
    }

    public trimOutsideRange$Tree_Node$int$int(curr : Tree.Node, min : number, max : number) : Tree.Node {
        if(curr == null) return null;
        curr.lChild = this.trimOutsideRange$Tree_Node$int$int(curr.lChild, min, max);
        curr.rChild = this.trimOutsideRange$Tree_Node$int$int(curr.rChild, min, max);
        if(curr.value < min) {
            return curr.rChild;
        }
        if(curr.value > max) {
            return curr.lChild;
        }
        return curr;
    }

    public trimOutsideRange(curr? : any, min? : any, max? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null) && ((typeof min === 'number') || min === null) && ((typeof max === 'number') || max === null)) {
            return <any>this.trimOutsideRange$Tree_Node$int$int(curr, min, max);
        } else if(((typeof curr === 'number') || curr === null) && ((typeof min === 'number') || min === null) && max === undefined) {
            return <any>this.trimOutsideRange$int$int(curr, min);
        } else throw new Error('invalid overload');
    }

    public printInRange$int$int(min : number, max : number) {
        this.printInRange$Tree_Node$int$int(this.root, min, max);
    }

    public printInRange$Tree_Node$int$int(root : Tree.Node, min : number, max : number) {
        if(root == null) return;
        this.printInRange$Tree_Node$int$int(root.lChild, min, max);
        if(root.value >= min && root.value <= max) console.info(root.value + " ");
        this.printInRange$Tree_Node$int$int(root.rChild, min, max);
    }

    public printInRange(root? : any, min? : any, max? : any) : any {
        if(((root != null && root instanceof <any>Tree.Node) || root === null) && ((typeof min === 'number') || min === null) && ((typeof max === 'number') || max === null)) {
            return <any>this.printInRange$Tree_Node$int$int(root, min, max);
        } else if(((typeof root === 'number') || root === null) && ((typeof min === 'number') || min === null) && max === undefined) {
            return <any>this.printInRange$int$int(root, min);
        } else throw new Error('invalid overload');
    }

    public FloorBST(val : number) : number {
        let curr : Tree.Node = this.root;
        let floor : number = 2147483647;
        while((curr != null)) {{
            if(curr.value === val) {
                floor = curr.value;
                break;
            } else if(curr.value > val) {
                curr = curr.lChild;
            } else {
                floor = curr.value;
                curr = curr.rChild;
            }
        }};
        return floor;
    }

    public CeilBST(val : number) : number {
        let curr : Tree.Node = this.root;
        let ceil : number = -2147483648;
        while((curr != null)) {{
            if(curr.value === val) {
                ceil = curr.value;
                break;
            } else if(curr.value > val) {
                ceil = curr.value;
                curr = curr.lChild;
            } else {
                curr = curr.rChild;
            }
        }};
        return ceil;
    }

    public findMaxBT$() : number {
        let ans : number = this.findMaxBT$Tree_Node(this.root);
        return ans;
    }

    public findMaxBT$Tree_Node(curr : Tree.Node) : number {
        let left : number;
        let right : number;
        if(curr == null) return -2147483648;
        let max : number = curr.value;
        left = this.findMaxBT$Tree_Node(curr.lChild);
        right = this.findMaxBT$Tree_Node(curr.rChild);
        if(left > max) max = left;
        if(right > max) max = right;
        return max;
    }

    public findMaxBT(curr? : any) : any {
        if(((curr != null && curr instanceof <any>Tree.Node) || curr === null)) {
            return <any>this.findMaxBT$Tree_Node(curr);
        } else if(curr === undefined) {
            return <any>this.findMaxBT$();
        } else throw new Error('invalid overload');
    }

    public searchBT(value : number) : boolean {
        return this.searchBTUtil(this.root, value);
    }

    public searchBTUtil(curr : Tree.Node, value : number) : boolean {
        let left : boolean;
        let right : boolean;
        if(curr == null) return false;
        if(curr.value === value) return true;
        left = this.searchBTUtil(curr.lChild, value);
        if(left) return true;
        right = this.searchBTUtil(curr.rChild, value);
        if(right) return true;
        return false;
    }

    public CreateBinaryTree$int_A(arr : number[]) {
        this.root = this.CreateBinaryTree$int_A$int$int(arr, 0, arr.length - 1);
    }

    public CreateBinaryTree$int_A$int$int(arr : number[], start : number, end : number) : Tree.Node {
        let curr : Tree.Node = null;
        if(start > end) return null;
        let mid : number = ((start + end) / 2|0);
        curr = new Tree.Node(arr[mid]);
        curr.lChild = this.CreateBinaryTree$int_A$int$int(arr, start, mid - 1);
        curr.rChild = this.CreateBinaryTree$int_A$int$int(arr, mid + 1, end);
        return curr;
    }

    public CreateBinaryTree(arr? : any, start? : any, end? : any) : any {
        if(((arr != null && arr instanceof <any>Array && (arr.length==0 || arr[0] == null ||(typeof arr[0] === 'number'))) || arr === null) && ((typeof start === 'number') || start === null) && ((typeof end === 'number') || end === null)) {
            return <any>this.CreateBinaryTree$int_A$int$int(arr, start, end);
        } else if(((arr != null && arr instanceof <any>Array && (arr.length==0 || arr[0] == null ||(typeof arr[0] === 'number'))) || arr === null) && start === undefined && end === undefined) {
            return <any>this.CreateBinaryTree$int_A(arr);
        } else throw new Error('invalid overload');
    }

    isBSTArray(preorder : number[], size : number) : boolean {
        let stk : Array<number> = <any>([]);
        let value : number;
        let root : number = -999999;
        for(let i : number = 0; i < size; i++) {{
            value = preorder[i];
            if(value < root) return false;
            while((/* size */(<number>stk.length) > 0 && /* peek */((s) => { return s[s.length-1]; })(stk) < value)) {root = /* pop */stk.pop()};
            /* push */(stk.push(value)>0);
        };}
        return true;
    }

    public static main(args : string[]) {
        let t : Tree = new Tree();
        let arr : number[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
        t.levelOrderBinaryTree$int_A(arr);
        console.info("");
        console.info(t.isHeap());
        console.info(t.isHeap2());
        console.info(t.isCompleteTree());
        console.info("");
        t.PrintBredthFirst();
        console.info("");
        t.PrintPreOrder();
        console.info("");
        t.PrintLevelOrderLineByLine();
        console.info("");
        t.PrintLevelOrderLineByLine2();
        console.info("");
        t.PrintSpiralTree();
        console.info("");
        t.printAllPath();
        console.info("");
        t.NthInOrder$int(4);
        console.info("");
        t.NthPostOrder$int(4);
        console.info("");
        t.NthPreOrder$int(4);
        console.info("");
    }
}
Tree["__class"] = "Tree";


namespace Tree {

    export class Node {
        value : number;

        lChild : Tree.Node;

        rChild : Tree.Node;

        public constructor(v? : any, l? : any, r? : any) {
            if(((typeof v === 'number') || v === null) && ((l != null && l instanceof <any>Tree.Node) || l === null) && ((r != null && r instanceof <any>Tree.Node) || r === null)) {
                let __args = arguments;
                if(this.value===undefined) this.value = 0;
                if(this.lChild===undefined) this.lChild = null;
                if(this.rChild===undefined) this.rChild = null;
                if(this.value===undefined) this.value = 0;
                if(this.lChild===undefined) this.lChild = null;
                if(this.rChild===undefined) this.rChild = null;
                (() => {
                    this.value = v;
                    this.lChild = l;
                    this.rChild = r;
                })();
            } else if(((typeof v === 'number') || v === null) && l === undefined && r === undefined) {
                let __args = arguments;
                if(this.value===undefined) this.value = 0;
                if(this.lChild===undefined) this.lChild = null;
                if(this.rChild===undefined) this.rChild = null;
                if(this.value===undefined) this.value = 0;
                if(this.lChild===undefined) this.lChild = null;
                if(this.rChild===undefined) this.rChild = null;
                (() => {
                    this.value = v;
                    this.lChild = null;
                    this.rChild = null;
                })();
            } else throw new Error('invalid overload');
        }
    }
    Node["__class"] = "Tree.Node";

}




Tree.main(null);
