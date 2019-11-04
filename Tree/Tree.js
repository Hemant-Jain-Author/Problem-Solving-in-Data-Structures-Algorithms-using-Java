/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
var Tree = /** @class */ (function () {
    function Tree() {
        if (this.root === undefined)
            this.root = null;
        this.root = null;
    }
    Tree.prototype.levelOrderBinaryTree$int_A = function (arr) {
        this.root = this.levelOrderBinaryTree$int_A$int(arr, 0);
    };
    Tree.prototype.levelOrderBinaryTree$int_A$int = function (arr, start) {
        var size = arr.length;
        var curr = new Tree.Node(arr[start]);
        var left = 2 * start + 1;
        var right = 2 * start + 2;
        if (left < size)
            curr.lChild = this.levelOrderBinaryTree$int_A$int(arr, left);
        if (right < size)
            curr.rChild = this.levelOrderBinaryTree$int_A$int(arr, right);
        return curr;
    };
    Tree.prototype.levelOrderBinaryTree = function (arr, start) {
        if (((arr != null && arr instanceof Array && (arr.length == 0 || arr[0] == null || (typeof arr[0] === 'number'))) || arr === null) && ((typeof start === 'number') || start === null)) {
            return this.levelOrderBinaryTree$int_A$int(arr, start);
        }
        else if (((arr != null && arr instanceof Array && (arr.length == 0 || arr[0] == null || (typeof arr[0] === 'number'))) || arr === null) && start === undefined) {
            return this.levelOrderBinaryTree$int_A(arr);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.InsertNode$int = function (value) {
        this.root = this.InsertNode$Tree_Node$int(this.root, value);
    };
    Tree.prototype.InsertNode$Tree_Node$int = function (node, value) {
        if (node == null) {
            node = new Tree.Node(value, null, null);
        }
        else {
            if (node.value > value) {
                node.lChild = this.InsertNode$Tree_Node$int(node.lChild, value);
            }
            else {
                node.rChild = this.InsertNode$Tree_Node$int(node.rChild, value);
            }
        }
        return node;
    };
    Tree.prototype.InsertNode = function (node, value) {
        if (((node != null && node instanceof Tree.Node) || node === null) && ((typeof value === 'number') || value === null)) {
            return this.InsertNode$Tree_Node$int(node, value);
        }
        else if (((typeof node === 'number') || node === null) && value === undefined) {
            return this.InsertNode$int(node);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.PrintPreOrder$ = function () {
        this.PrintPreOrder$Tree_Node(this.root);
    };
    Tree.prototype.PrintPreOrder$Tree_Node = function (node) {
        if (node != null) {
            console.info(" " + node.value);
            this.PrintPreOrder$Tree_Node(node.lChild);
            this.PrintPreOrder$Tree_Node(node.rChild);
        }
    };
    Tree.prototype.PrintPreOrder = function (node) {
        if (((node != null && node instanceof Tree.Node) || node === null)) {
            return this.PrintPreOrder$Tree_Node(node);
        }
        else if (node === undefined) {
            return this.PrintPreOrder$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.NthPreOrder$int = function (index) {
        var counter = [0];
        this.NthPreOrder$Tree_Node$int$int_A(this.root, index, counter);
    };
    Tree.prototype.NthPreOrder$Tree_Node$int$int_A = function (node, index, counter) {
        if (node != null) {
            counter[0]++;
            if (counter[0] === index) {
                console.info(node.value);
            }
            this.NthPreOrder$Tree_Node$int$int_A(node.lChild, index, counter);
            this.NthPreOrder$Tree_Node$int$int_A(node.rChild, index, counter);
        }
    };
    Tree.prototype.NthPreOrder = function (node, index, counter) {
        if (((node != null && node instanceof Tree.Node) || node === null) && ((typeof index === 'number') || index === null) && ((counter != null && counter instanceof Array && (counter.length == 0 || counter[0] == null || (typeof counter[0] === 'number'))) || counter === null)) {
            return this.NthPreOrder$Tree_Node$int$int_A(node, index, counter);
        }
        else if (((typeof node === 'number') || node === null) && index === undefined && counter === undefined) {
            return this.NthPreOrder$int(node);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.PrintPostOrder$ = function () {
        this.PrintPostOrder$Tree_Node(this.root);
    };
    Tree.prototype.PrintPostOrder$Tree_Node = function (node) {
        if (node != null) {
            this.PrintPostOrder$Tree_Node(node.lChild);
            this.PrintPostOrder$Tree_Node(node.rChild);
            console.info(" " + node.value);
        }
    };
    Tree.prototype.PrintPostOrder = function (node) {
        if (((node != null && node instanceof Tree.Node) || node === null)) {
            return this.PrintPostOrder$Tree_Node(node);
        }
        else if (node === undefined) {
            return this.PrintPostOrder$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.NthPostOrder$int = function (index) {
        var counter = [0];
        this.NthPostOrder$Tree_Node$int$int_A(this.root, index, counter);
    };
    Tree.prototype.NthPostOrder$Tree_Node$int$int_A = function (node, index, counter) {
        if (node != null) {
            this.NthPostOrder$Tree_Node$int$int_A(node.lChild, index, counter);
            this.NthPostOrder$Tree_Node$int$int_A(node.rChild, index, counter);
            counter[0]++;
            if (counter[0] === index) {
                console.info(" " + node.value);
            }
        }
    };
    Tree.prototype.NthPostOrder = function (node, index, counter) {
        if (((node != null && node instanceof Tree.Node) || node === null) && ((typeof index === 'number') || index === null) && ((counter != null && counter instanceof Array && (counter.length == 0 || counter[0] == null || (typeof counter[0] === 'number'))) || counter === null)) {
            return this.NthPostOrder$Tree_Node$int$int_A(node, index, counter);
        }
        else if (((typeof node === 'number') || node === null) && index === undefined && counter === undefined) {
            return this.NthPostOrder$int(node);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.PrintInOrder$ = function () {
        this.PrintInOrder$Tree_Node(this.root);
    };
    Tree.prototype.PrintInOrder$Tree_Node = function (node) {
        if (node != null) {
            this.PrintInOrder$Tree_Node(node.lChild);
            console.info(" " + node.value);
            this.PrintInOrder$Tree_Node(node.rChild);
        }
    };
    Tree.prototype.PrintInOrder = function (node) {
        if (((node != null && node instanceof Tree.Node) || node === null)) {
            return this.PrintInOrder$Tree_Node(node);
        }
        else if (node === undefined) {
            return this.PrintInOrder$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.NthInOrder$int = function (index) {
        var counter = [0];
        this.NthInOrder$Tree_Node$int$int_A(this.root, index, counter);
    };
    Tree.prototype.NthInOrder$Tree_Node$int$int_A = function (node, index, counter) {
        if (node != null) {
            this.NthInOrder$Tree_Node$int$int_A(node.lChild, index, counter);
            counter[0]++;
            if (counter[0] === index) {
                console.info(" " + node.value);
            }
            this.NthInOrder$Tree_Node$int$int_A(node.rChild, index, counter);
        }
    };
    Tree.prototype.NthInOrder = function (node, index, counter) {
        if (((node != null && node instanceof Tree.Node) || node === null) && ((typeof index === 'number') || index === null) && ((counter != null && counter instanceof Array && (counter.length == 0 || counter[0] == null || (typeof counter[0] === 'number'))) || counter === null)) {
            return this.NthInOrder$Tree_Node$int$int_A(node, index, counter);
        }
        else if (((typeof node === 'number') || node === null) && index === undefined && counter === undefined) {
            return this.NthInOrder$int(node);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.PrintBredthFirst = function () {
        var que = ([]);
        var temp;
        if (this.root != null) /* add */
            (que.push(this.root) > 0);
        while (( /* isEmpty */(que.length == 0) === false)) {
            {
                temp = /* pop */ que.pop();
                console.info(" " + temp.value);
                if (temp.lChild != null) /* add */
                    (que.push(temp.lChild) > 0);
                if (temp.rChild != null) /* add */
                    (que.push(temp.rChild) > 0);
            }
        }
        ;
    };
    Tree.prototype.PrintDepthFirst = function () {
        var stk = ([]);
        var temp;
        if (this.root != null) /* push */
            (stk.push(this.root) > 0);
        while (( /* isEmpty */(stk.length == 0) === false)) {
            {
                temp = /* pop */ stk.pop();
                console.info(temp.value);
                if (temp.lChild != null) /* push */
                    (stk.push(temp.lChild) > 0);
                if (temp.rChild != null) /* push */
                    (stk.push(temp.rChild) > 0);
            }
        }
        ;
    };
    Tree.prototype.PrintLevelOrderLineByLine = function () {
        var que1 = ([]);
        var que2 = ([]);
        var temp = null;
        if (this.root != null) /* add */
            (que1.push(this.root) > 0);
        while (( /* size */que1.length !== 0 || /* size */ que2.length !== 0)) {
            {
                while (( /* size */que1.length !== 0)) {
                    {
                        temp = /* pop */ que1.pop();
                        console.info(" " + temp.value);
                        if (temp.lChild != null) /* add */
                            (que2.push(temp.lChild) > 0);
                        if (temp.rChild != null) /* add */
                            (que2.push(temp.rChild) > 0);
                    }
                }
                ;
                console.info("");
                while (( /* size */que2.length !== 0)) {
                    {
                        temp = que2.pop();
                        console.info(" " + temp.value);
                        if (temp.lChild != null) /* add */
                            (que1.push(temp.lChild) > 0);
                        if (temp.rChild != null) /* add */
                            (que1.push(temp.rChild) > 0);
                    }
                }
                ;
                console.info("");
            }
        }
        ;
    };
    Tree.prototype.PrintLevelOrderLineByLine2 = function () {
        var que = ([]);
        var temp = null;
        var count = 0;
        if (this.root != null) /* add */
            (que.push(this.root) > 0);
        while (( /* size */que.length !== 0)) {
            {
                count = /* size */ que.length;
                while ((count > 0)) {
                    {
                        temp = /* pop */ que.pop();
                        console.info(" " + temp.value);
                        if (temp.lChild != null) /* add */
                            (que.push(temp.lChild) > 0);
                        if (temp.rChild != null) /* add */
                            (que.push(temp.rChild) > 0);
                        count -= 1;
                    }
                }
                ;
                console.info("");
            }
        }
        ;
    };
    Tree.prototype.PrintSpiralTree = function () {
        var stk1 = ([]);
        var stk2 = ([]);
        var temp;
        if (this.root != null) /* push */
            (stk1.push(this.root) > 0);
        while (( /* size */stk1.length !== 0 || /* size */ stk2.length !== 0)) {
            {
                while (( /* size */stk1.length !== 0)) {
                    {
                        temp = /* pop */ stk1.pop();
                        console.info(" " + temp.value);
                        if (temp.rChild != null) /* push */
                            (stk2.push(temp.rChild) > 0);
                        if (temp.lChild != null) /* push */
                            (stk2.push(temp.lChild) > 0);
                    }
                }
                ;
                while (( /* size */stk2.length !== 0)) {
                    {
                        temp = /* pop */ stk2.pop();
                        console.info(" " + temp.value);
                        if (temp.lChild != null) /* push */
                            (stk1.push(temp.lChild) > 0);
                        if (temp.rChild != null) /* push */
                            (stk1.push(temp.rChild) > 0);
                    }
                }
                ;
            }
        }
        ;
    };
    Tree.prototype.Find = function (value) {
        var curr = this.root;
        while ((curr != null)) {
            {
                if (curr.value === value) {
                    return true;
                }
                else if (curr.value > value) {
                    curr = curr.lChild;
                }
                else {
                    curr = curr.rChild;
                }
            }
        }
        ;
        return false;
    };
    Tree.prototype.Find2 = function (value) {
        var curr = this.root;
        while ((curr != null && curr.value !== value)) {
            curr = (curr.value > value) ? curr.lChild : curr.rChild;
        }
        ;
        return curr != null;
    };
    Tree.prototype.FindMin = function () {
        var node = this.root;
        if (node == null) {
            return 2147483647;
        }
        while ((node.lChild != null)) {
            {
                node = node.lChild;
            }
        }
        ;
        return node.value;
    };
    Tree.prototype.FindMax = function () {
        var node = this.root;
        if (node == null) {
            return -2147483648;
        }
        while ((node.rChild != null)) {
            {
                node = node.rChild;
            }
        }
        ;
        return node.value;
    };
    Tree.prototype.FindMaxNode = function (curr) {
        var node = curr;
        if (node == null) {
            return null;
        }
        while ((node.rChild != null)) {
            {
                node = node.rChild;
            }
        }
        ;
        return node;
    };
    Tree.prototype.FindMinNode = function (curr) {
        var node = curr;
        if (node == null) {
            return null;
        }
        while ((node.lChild != null)) {
            {
                node = node.lChild;
            }
        }
        ;
        return node;
    };
    Tree.prototype.Free = function () {
        this.root = null;
    };
    Tree.prototype.DeleteNode$int = function (value) {
        this.root = this.DeleteNode$Tree_Node$int(this.root, value);
    };
    Tree.prototype.DeleteNode$Tree_Node$int = function (node, value) {
        var temp = null;
        if (node != null) {
            if (node.value === value) {
                if (node.lChild == null && node.rChild == null) {
                    return null;
                }
                else {
                    if (node.lChild == null) {
                        temp = node.rChild;
                        return temp;
                    }
                    if (node.rChild == null) {
                        temp = node.lChild;
                        return temp;
                    }
                    var minNode = this.FindMinNode(node.rChild);
                    var minValue = minNode.value;
                    node.value = minValue;
                    node.rChild = this.DeleteNode$Tree_Node$int(node.rChild, minValue);
                }
            }
            else {
                if (node.value > value) {
                    node.lChild = this.DeleteNode$Tree_Node$int(node.lChild, value);
                }
                else {
                    node.rChild = this.DeleteNode$Tree_Node$int(node.rChild, value);
                }
            }
        }
        return node;
    };
    Tree.prototype.DeleteNode = function (node, value) {
        if (((node != null && node instanceof Tree.Node) || node === null) && ((typeof value === 'number') || value === null)) {
            return this.DeleteNode$Tree_Node$int(node, value);
        }
        else if (((typeof node === 'number') || node === null) && value === undefined) {
            return this.DeleteNode$int(node);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.TreeDepth$ = function () {
        return this.TreeDepth$Tree_Node(this.root);
    };
    Tree.prototype.TreeDepth$Tree_Node = function (curr) {
        if (curr == null)
            return 0;
        else {
            var lDepth = this.TreeDepth$Tree_Node(curr.lChild);
            var rDepth = this.TreeDepth$Tree_Node(curr.rChild);
            if (lDepth > rDepth)
                return lDepth + 1;
            else
                return rDepth + 1;
        }
    };
    Tree.prototype.TreeDepth = function (curr) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null)) {
            return this.TreeDepth$Tree_Node(curr);
        }
        else if (curr === undefined) {
            return this.TreeDepth$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.isEqual = function (T2) {
        return this.isEqualUtil(this.root, T2.root);
    };
    Tree.prototype.isEqualUtil = function (node1, node2) {
        if (node1 == null && node2 == null)
            return true;
        else if (node1 == null || node2 == null)
            return false;
        else
            return (this.isEqualUtil(node1.lChild, node2.lChild) && this.isEqualUtil(node1.rChild, node2.rChild) && (node1.value === node2.value));
    };
    Tree.prototype.Ancestor$int$int = function (first, second) {
        if (first > second) {
            var temp = first;
            first = second;
            second = temp;
        }
        return this.Ancestor$Tree_Node$int$int(this.root, first, second);
    };
    Tree.prototype.Ancestor$Tree_Node$int$int = function (curr, first, second) {
        if (curr == null) {
            return null;
        }
        if (curr.value > first && curr.value > second) {
            return this.Ancestor$Tree_Node$int$int(curr.lChild, first, second);
        }
        if (curr.value < first && curr.value < second) {
            return this.Ancestor$Tree_Node$int$int(curr.rChild, first, second);
        }
        return curr;
    };
    Tree.prototype.Ancestor = function (curr, first, second) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null) && ((typeof first === 'number') || first === null) && ((typeof second === 'number') || second === null)) {
            return this.Ancestor$Tree_Node$int$int(curr, first, second);
        }
        else if (((typeof curr === 'number') || curr === null) && ((typeof first === 'number') || first === null) && second === undefined) {
            return this.Ancestor$int$int(curr, first);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.CopyTree$ = function () {
        var tree2 = new Tree();
        tree2.root = this.CopyTree$Tree_Node(this.root);
        return tree2;
    };
    Tree.prototype.CopyTree$Tree_Node = function (curr) {
        var temp;
        if (curr != null) {
            temp = new Tree.Node(curr.value);
            temp.lChild = this.CopyTree$Tree_Node(curr.lChild);
            temp.rChild = this.CopyTree$Tree_Node(curr.rChild);
            return temp;
        }
        else
            return null;
    };
    Tree.prototype.CopyTree = function (curr) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null)) {
            return this.CopyTree$Tree_Node(curr);
        }
        else if (curr === undefined) {
            return this.CopyTree$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.CopyMirrorTree$ = function () {
        var tree2 = new Tree();
        tree2.root = this.CopyMirrorTree$Tree_Node(this.root);
        return tree2;
    };
    Tree.prototype.CopyMirrorTree$Tree_Node = function (curr) {
        var temp;
        if (curr != null) {
            temp = new Tree.Node(curr.value);
            temp.rChild = this.CopyMirrorTree$Tree_Node(curr.lChild);
            temp.lChild = this.CopyMirrorTree$Tree_Node(curr.rChild);
            return temp;
        }
        else
            return null;
    };
    Tree.prototype.CopyMirrorTree = function (curr) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null)) {
            return this.CopyMirrorTree$Tree_Node(curr);
        }
        else if (curr === undefined) {
            return this.CopyMirrorTree$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.numNodes$ = function () {
        return this.numNodes$Tree_Node(this.root);
    };
    Tree.prototype.numNodes$Tree_Node = function (curr) {
        if (curr == null)
            return 0;
        else
            return (1 + this.numNodes$Tree_Node(curr.rChild) + this.numNodes$Tree_Node(curr.lChild));
    };
    Tree.prototype.numNodes = function (curr) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null)) {
            return this.numNodes$Tree_Node(curr);
        }
        else if (curr === undefined) {
            return this.numNodes$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.numFullNodesBT$ = function () {
        return this.numNodes$Tree_Node(this.root);
    };
    Tree.prototype.numFullNodesBT$Tree_Node = function (curr) {
        var count;
        if (curr == null)
            return 0;
        count = this.numFullNodesBT$Tree_Node(curr.rChild) + this.numFullNodesBT$Tree_Node(curr.lChild);
        if (curr.rChild != null && curr.lChild != null)
            count++;
        return count;
    };
    Tree.prototype.numFullNodesBT = function (curr) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null)) {
            return this.numFullNodesBT$Tree_Node(curr);
        }
        else if (curr === undefined) {
            return this.numFullNodesBT$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.maxLengthPathBT$ = function () {
        return this.maxLengthPathBT$Tree_Node(this.root);
    };
    Tree.prototype.maxLengthPathBT$Tree_Node = function (curr) {
        var max;
        var leftPath;
        var rightPath;
        var leftMax;
        var rightMax;
        if (curr == null)
            return 0;
        leftPath = this.TreeDepth$Tree_Node(curr.lChild);
        rightPath = this.TreeDepth$Tree_Node(curr.rChild);
        max = leftPath + rightPath + 1;
        leftMax = this.maxLengthPathBT$Tree_Node(curr.lChild);
        rightMax = this.maxLengthPathBT$Tree_Node(curr.rChild);
        if (leftMax > max)
            max = leftMax;
        if (rightMax > max)
            max = rightMax;
        return max;
    };
    Tree.prototype.maxLengthPathBT = function (curr) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null)) {
            return this.maxLengthPathBT$Tree_Node(curr);
        }
        else if (curr === undefined) {
            return this.maxLengthPathBT$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.numLeafNodes$ = function () {
        return this.numLeafNodes$Tree_Node(this.root);
    };
    Tree.prototype.numLeafNodes$Tree_Node = function (curr) {
        if (curr == null)
            return 0;
        if (curr.lChild == null && curr.rChild == null)
            return 1;
        else
            return (this.numLeafNodes$Tree_Node(curr.rChild) + this.numLeafNodes$Tree_Node(curr.lChild));
    };
    Tree.prototype.numLeafNodes = function (curr) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null)) {
            return this.numLeafNodes$Tree_Node(curr);
        }
        else if (curr === undefined) {
            return this.numLeafNodes$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.sumAllBT$ = function () {
        return this.sumAllBT$Tree_Node(this.root);
    };
    Tree.prototype.sumAllBT$Tree_Node = function (curr) {
        if (curr == null)
            return 0;
        return (curr.value + this.sumAllBT$Tree_Node(curr.lChild) + this.sumAllBT$Tree_Node(curr.lChild));
    };
    Tree.prototype.sumAllBT = function (curr) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null)) {
            return this.sumAllBT$Tree_Node(curr);
        }
        else if (curr === undefined) {
            return this.sumAllBT$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.iterativePreOrder = function () {
        var stk = ([]);
        var curr;
        if (this.root != null) /* add */
            (stk.push(this.root) > 0);
        while (( /* isEmpty */(stk.length == 0) === false)) {
            {
                curr = /* pop */ stk.pop();
                console.info(curr.value + " ");
                if (curr.rChild != null) /* push */
                    (stk.push(curr.rChild) > 0);
                if (curr.lChild != null) /* push */
                    (stk.push(curr.lChild) > 0);
            }
        }
        ;
    };
    Tree.prototype.iterativePostOrder = function () {
        var stk = ([]);
        var visited = ([]);
        var curr;
        var vtd;
        if (this.root != null) {
            /* add */ (stk.push(this.root) > 0);
            /* add */ (visited.push(0) > 0);
        }
        while (( /* isEmpty */(stk.length == 0) === false)) {
            {
                curr = /* pop */ stk.pop();
                vtd = /* pop */ visited.pop();
                if (vtd === 1) {
                    console.info(curr.value + " ");
                }
                else {
                    /* push */ (stk.push(curr) > 0);
                    /* push */ (visited.push(1) > 0);
                    if (curr.rChild != null) {
                        /* push */ (stk.push(curr.rChild) > 0);
                        /* push */ (visited.push(0) > 0);
                    }
                    if (curr.lChild != null) {
                        /* push */ (stk.push(curr.lChild) > 0);
                        /* push */ (visited.push(0) > 0);
                    }
                }
            }
        }
        ;
    };
    Tree.prototype.iterativeInOrder = function () {
        var stk = ([]);
        var visited = ([]);
        var curr;
        var vtd;
        if (this.root != null) {
            /* add */ (stk.push(this.root) > 0);
            /* add */ (visited.push(0) > 0);
        }
        while (( /* isEmpty */(stk.length == 0) === false)) {
            {
                curr = /* pop */ stk.pop();
                vtd = /* pop */ visited.pop();
                if (vtd === 1) {
                    console.info(curr.value + " ");
                }
                else {
                    if (curr.rChild != null) {
                        /* push */ (stk.push(curr.rChild) > 0);
                        /* push */ (visited.push(0) > 0);
                    }
                    /* push */ (stk.push(curr) > 0);
                    /* push */ (visited.push(1) > 0);
                    if (curr.lChild != null) {
                        /* push */ (stk.push(curr.lChild) > 0);
                        /* push */ (visited.push(0) > 0);
                    }
                }
            }
        }
        ;
    };
    Tree.prototype.isBST3 = function (root) {
        if (root == null)
            return true;
        if (root.lChild != null && this.FindMaxNode(root.lChild).value > root.value)
            return false;
        if (root.rChild != null && this.FindMinNode(root.rChild).value <= root.value)
            return false;
        return (this.isBST3(root.lChild) && this.isBST3(root.rChild));
    };
    Tree.prototype.isBST$ = function () {
        return this.isBST$Tree_Node$int$int(this.root, -2147483648, 2147483647);
    };
    Tree.prototype.isBST$Tree_Node$int$int = function (curr, min, max) {
        if (curr == null)
            return true;
        if (curr.value < min || curr.value > max)
            return false;
        return this.isBST$Tree_Node$int$int(curr.lChild, min, curr.value) && this.isBST$Tree_Node$int$int(curr.rChild, curr.value, max);
    };
    Tree.prototype.isBST = function (curr, min, max) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null) && ((typeof min === 'number') || min === null) && ((typeof max === 'number') || max === null)) {
            return this.isBST$Tree_Node$int$int(curr, min, max);
        }
        else if (curr === undefined && min === undefined && max === undefined) {
            return this.isBST$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.isBST2$ = function () {
        var count = [0];
        return this.isBST2$Tree_Node$int_A(this.root, count);
    };
    Tree.prototype.isBST2$Tree_Node$int_A = function (root, count) {
        var ret;
        if (root != null) {
            ret = this.isBST2$Tree_Node$int_A(root.lChild, count);
            if (!ret)
                return false;
            if (count[0] > root.value)
                return false;
            count[0] = root.value;
            ret = this.isBST2$Tree_Node$int_A(root.rChild, count);
            if (!ret)
                return false;
        }
        return true;
    };
    Tree.prototype.isBST2 = function (root, count) {
        if (((root != null && root instanceof Tree.Node) || root === null) && ((count != null && count instanceof Array && (count.length == 0 || count[0] == null || (typeof count[0] === 'number'))) || count === null)) {
            return this.isBST2$Tree_Node$int_A(root, count);
        }
        else if (root === undefined && count === undefined) {
            return this.isBST2$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.isCompleteTree = function () {
        var que = ([]);
        var temp = null;
        var noChild = 0;
        if (this.root != null) /* add */
            (que.push(this.root) > 0);
        while (( /* size */que.length !== 0)) {
            {
                temp = /* pop */ que.pop();
                if (temp.lChild != null) {
                    if (noChild === 1)
                        return false;
                    /* add */ (que.push(temp.lChild) > 0);
                }
                else
                    noChild = 1;
                if (temp.rChild != null) {
                    if (noChild === 1)
                        return false;
                    /* add */ (que.push(temp.rChild) > 0);
                }
                else
                    noChild = 1;
            }
        }
        ;
        return true;
    };
    Tree.prototype.isCompleteTreeUtil = function (curr, index, count) {
        if (curr == null)
            return true;
        if (index > count)
            return false;
        return this.isCompleteTreeUtil(curr.lChild, index * 2 + 1, count) && this.isCompleteTreeUtil(curr.rChild, index * 2 + 2, count);
    };
    Tree.prototype.isCompleteTree2 = function () {
        var count = this.numNodes();
        return this.isCompleteTreeUtil(this.root, 0, count);
    };
    Tree.prototype.isHeapUtil = function (curr, parentValue) {
        if (curr == null)
            return true;
        if (curr.value < parentValue)
            return false;
        return (this.isHeapUtil(curr.lChild, curr.value) && this.isHeapUtil(curr.rChild, curr.value));
    };
    Tree.prototype.isHeap = function () {
        var infi = -9999999;
        return (this.isCompleteTree() && this.isHeapUtil(this.root, infi));
    };
    Tree.prototype.isHeapUtil2 = function (curr, index, count, parentValue) {
        if (curr == null)
            return true;
        if (index > count)
            return false;
        if (curr.value < parentValue)
            return false;
        return this.isHeapUtil2(curr.lChild, index * 2 + 1, count, curr.value) && this.isHeapUtil2(curr.rChild, index * 2 + 2, count, curr.value);
    };
    Tree.prototype.isHeap2 = function () {
        var count = this.numNodes();
        var parentValue = -9999999;
        return this.isHeapUtil2(this.root, 0, count, parentValue);
    };
    Tree.prototype.treeToListRec$ = function () {
        var head = this.treeToListRec$Tree_Node(this.root);
        var temp = head;
        return temp;
    };
    Tree.prototype.treeToListRec$Tree_Node = function (curr) {
        var Head = null;
        var Tail = null;
        if (curr == null)
            return null;
        if (curr.lChild == null && curr.rChild == null) {
            curr.lChild = curr;
            curr.rChild = curr;
            return curr;
        }
        if (curr.lChild != null) {
            Head = this.treeToListRec$Tree_Node(curr.lChild);
            Tail = Head.lChild;
            curr.lChild = Tail;
            Tail.rChild = curr;
        }
        else
            Head = curr;
        if (curr.rChild != null) {
            var tempHead = this.treeToListRec$Tree_Node(curr.rChild);
            Tail = tempHead.lChild;
            curr.rChild = tempHead;
            tempHead.lChild = curr;
        }
        else
            Tail = curr;
        Head.lChild = Tail;
        Tail.rChild = Head;
        return Head;
    };
    Tree.prototype.treeToListRec = function (curr) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null)) {
            return this.treeToListRec$Tree_Node(curr);
        }
        else if (curr === undefined) {
            return this.treeToListRec$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.printAllPath = function () {
        var stk = ([]);
        this.printAllPathUtil(this.root, stk);
    };
    Tree.prototype.printAllPathUtil = function (curr, stk) {
        if (curr == null)
            return;
        /* push */ (stk.push(curr.value) > 0);
        if (curr.lChild == null && curr.rChild == null) {
            console.info(stk);
            /* pop */ stk.pop();
            return;
        }
        this.printAllPathUtil(curr.rChild, stk);
        this.printAllPathUtil(curr.lChild, stk);
        /* pop */ stk.pop();
    };
    Tree.prototype.LCA$int$int = function (first, second) {
        var ans = this.LCA$Tree_Node$int$int(this.root, first, second);
        if (ans != null)
            return ans.value;
        else
            return -2147483648;
    };
    Tree.prototype.LCA$Tree_Node$int$int = function (curr, first, second) {
        var left;
        var right;
        if (curr == null)
            return null;
        if (curr.value === first || curr.value === second)
            return curr;
        left = this.LCA$Tree_Node$int$int(curr.lChild, first, second);
        right = this.LCA$Tree_Node$int$int(curr.rChild, first, second);
        if (left != null && right != null)
            return curr;
        else if (left != null)
            return left;
        else
            return right;
    };
    Tree.prototype.LCA = function (curr, first, second) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null) && ((typeof first === 'number') || first === null) && ((typeof second === 'number') || second === null)) {
            return this.LCA$Tree_Node$int$int(curr, first, second);
        }
        else if (((typeof curr === 'number') || curr === null) && ((typeof first === 'number') || first === null) && second === undefined) {
            return this.LCA$int$int(curr, first);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.LcaBST$int$int = function (first, second) {
        return this.LcaBST$Tree_Node$int$int(this.root, first, second);
    };
    Tree.prototype.LcaBST$Tree_Node$int$int = function (curr, first, second) {
        if (curr == null) {
            return 2147483647;
        }
        if (curr.value > first && curr.value > second) {
            return this.LcaBST$Tree_Node$int$int(curr.lChild, first, second);
        }
        if (curr.value < first && curr.value < second) {
            return this.LcaBST$Tree_Node$int$int(curr.rChild, first, second);
        }
        return curr.value;
    };
    Tree.prototype.LcaBST = function (curr, first, second) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null) && ((typeof first === 'number') || first === null) && ((typeof second === 'number') || second === null)) {
            return this.LcaBST$Tree_Node$int$int(curr, first, second);
        }
        else if (((typeof curr === 'number') || curr === null) && ((typeof first === 'number') || first === null) && second === undefined) {
            return this.LcaBST$int$int(curr, first);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.trimOutsideRange$int$int = function (min, max) {
        this.trimOutsideRange$Tree_Node$int$int(this.root, min, max);
    };
    Tree.prototype.trimOutsideRange$Tree_Node$int$int = function (curr, min, max) {
        if (curr == null)
            return null;
        curr.lChild = this.trimOutsideRange$Tree_Node$int$int(curr.lChild, min, max);
        curr.rChild = this.trimOutsideRange$Tree_Node$int$int(curr.rChild, min, max);
        if (curr.value < min) {
            return curr.rChild;
        }
        if (curr.value > max) {
            return curr.lChild;
        }
        return curr;
    };
    Tree.prototype.trimOutsideRange = function (curr, min, max) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null) && ((typeof min === 'number') || min === null) && ((typeof max === 'number') || max === null)) {
            return this.trimOutsideRange$Tree_Node$int$int(curr, min, max);
        }
        else if (((typeof curr === 'number') || curr === null) && ((typeof min === 'number') || min === null) && max === undefined) {
            return this.trimOutsideRange$int$int(curr, min);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.printInRange$int$int = function (min, max) {
        this.printInRange$Tree_Node$int$int(this.root, min, max);
    };
    Tree.prototype.printInRange$Tree_Node$int$int = function (root, min, max) {
        if (root == null)
            return;
        this.printInRange$Tree_Node$int$int(root.lChild, min, max);
        if (root.value >= min && root.value <= max)
            console.info(root.value + " ");
        this.printInRange$Tree_Node$int$int(root.rChild, min, max);
    };
    Tree.prototype.printInRange = function (root, min, max) {
        if (((root != null && root instanceof Tree.Node) || root === null) && ((typeof min === 'number') || min === null) && ((typeof max === 'number') || max === null)) {
            return this.printInRange$Tree_Node$int$int(root, min, max);
        }
        else if (((typeof root === 'number') || root === null) && ((typeof min === 'number') || min === null) && max === undefined) {
            return this.printInRange$int$int(root, min);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.FloorBST = function (val) {
        var curr = this.root;
        var floor = 2147483647;
        while ((curr != null)) {
            {
                if (curr.value === val) {
                    floor = curr.value;
                    break;
                }
                else if (curr.value > val) {
                    curr = curr.lChild;
                }
                else {
                    floor = curr.value;
                    curr = curr.rChild;
                }
            }
        }
        ;
        return floor;
    };
    Tree.prototype.CeilBST = function (val) {
        var curr = this.root;
        var ceil = -2147483648;
        while ((curr != null)) {
            {
                if (curr.value === val) {
                    ceil = curr.value;
                    break;
                }
                else if (curr.value > val) {
                    ceil = curr.value;
                    curr = curr.lChild;
                }
                else {
                    curr = curr.rChild;
                }
            }
        }
        ;
        return ceil;
    };
    Tree.prototype.findMaxBT$ = function () {
        var ans = this.findMaxBT$Tree_Node(this.root);
        return ans;
    };
    Tree.prototype.findMaxBT$Tree_Node = function (curr) {
        var left;
        var right;
        if (curr == null)
            return -2147483648;
        var max = curr.value;
        left = this.findMaxBT$Tree_Node(curr.lChild);
        right = this.findMaxBT$Tree_Node(curr.rChild);
        if (left > max)
            max = left;
        if (right > max)
            max = right;
        return max;
    };
    Tree.prototype.findMaxBT = function (curr) {
        if (((curr != null && curr instanceof Tree.Node) || curr === null)) {
            return this.findMaxBT$Tree_Node(curr);
        }
        else if (curr === undefined) {
            return this.findMaxBT$();
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.searchBT = function (value) {
        return this.searchBTUtil(this.root, value);
    };
    Tree.prototype.searchBTUtil = function (curr, value) {
        var left;
        var right;
        if (curr == null)
            return false;
        if (curr.value === value)
            return true;
        left = this.searchBTUtil(curr.lChild, value);
        if (left)
            return true;
        right = this.searchBTUtil(curr.rChild, value);
        if (right)
            return true;
        return false;
    };
    Tree.prototype.CreateBinaryTree$int_A = function (arr) {
        this.root = this.CreateBinaryTree$int_A$int$int(arr, 0, arr.length - 1);
    };
    Tree.prototype.CreateBinaryTree$int_A$int$int = function (arr, start, end) {
        var curr = null;
        if (start > end)
            return null;
        var mid = ((start + end) / 2 | 0);
        curr = new Tree.Node(arr[mid]);
        curr.lChild = this.CreateBinaryTree$int_A$int$int(arr, start, mid - 1);
        curr.rChild = this.CreateBinaryTree$int_A$int$int(arr, mid + 1, end);
        return curr;
    };
    Tree.prototype.CreateBinaryTree = function (arr, start, end) {
        if (((arr != null && arr instanceof Array && (arr.length == 0 || arr[0] == null || (typeof arr[0] === 'number'))) || arr === null) && ((typeof start === 'number') || start === null) && ((typeof end === 'number') || end === null)) {
            return this.CreateBinaryTree$int_A$int$int(arr, start, end);
        }
        else if (((arr != null && arr instanceof Array && (arr.length == 0 || arr[0] == null || (typeof arr[0] === 'number'))) || arr === null) && start === undefined && end === undefined) {
            return this.CreateBinaryTree$int_A(arr);
        }
        else
            throw new Error('invalid overload');
    };
    Tree.prototype.isBSTArray = function (preorder, size) {
        var stk = ([]);
        var value;
        var root = -999999;
        for (var i = 0; i < size; i++) {
            {
                value = preorder[i];
                if (value < root)
                    return false;
                while (( /* size */stk.length > 0 && /* peek */ (function (s) { return s[s.length - 1]; })(stk) < value)) {
                    root = /* pop */ stk.pop();
                }
                ;
                /* push */ (stk.push(value) > 0);
            }
            ;
        }
        return true;
    };
    Tree.main = function (args) {
        var t = new Tree();
        var arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
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
    };
    return Tree;
}());
Tree["__class"] = "Tree";
(function (Tree) {
    var Node = /** @class */ (function () {
        function Node(v, l, r) {
            var _this = this;
            if (((typeof v === 'number') || v === null) && ((l != null && l instanceof Tree.Node) || l === null) && ((r != null && r instanceof Tree.Node) || r === null)) {
                var __args = arguments;
                if (this.value === undefined)
                    this.value = 0;
                if (this.lChild === undefined)
                    this.lChild = null;
                if (this.rChild === undefined)
                    this.rChild = null;
                if (this.value === undefined)
                    this.value = 0;
                if (this.lChild === undefined)
                    this.lChild = null;
                if (this.rChild === undefined)
                    this.rChild = null;
                (function () {
                    _this.value = v;
                    _this.lChild = l;
                    _this.rChild = r;
                })();
            }
            else if (((typeof v === 'number') || v === null) && l === undefined && r === undefined) {
                var __args = arguments;
                if (this.value === undefined)
                    this.value = 0;
                if (this.lChild === undefined)
                    this.lChild = null;
                if (this.rChild === undefined)
                    this.rChild = null;
                if (this.value === undefined)
                    this.value = 0;
                if (this.lChild === undefined)
                    this.lChild = null;
                if (this.rChild === undefined)
                    this.rChild = null;
                (function () {
                    _this.value = v;
                    _this.lChild = null;
                    _this.rChild = null;
                })();
            }
            else
                throw new Error('invalid overload');
        }
        return Node;
    }());
    Tree.Node = Node;
    Node["__class"] = "Tree.Node";
})(Tree || (Tree = {}));
Tree.main(null);
