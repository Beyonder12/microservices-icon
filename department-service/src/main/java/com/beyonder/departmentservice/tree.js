class Node {
     val;
     left;
     right;g
    constructor(val, left, right) {
        this.val = val;
        this.left = left == null ? null : left;
        this.right = right == null ? null : right;
    }
}

const tree = new Node(1, new Node(2),new Node(3))
tree.left.left = new Node(4);
tree.left.right = new Node(5);
console.log(tree)