public class BTNode {
    private BTNode left, right, parent;
    private Object data;
    
    public BTNode(Object obj) {
        left = null;
        right = null;
        parent = null;
        this.data = obj;
    }

    public BTNode getRight() {
        return this.right;
    }

    public BTNode getLeft() {
        return this.left;
    }

    public void setRight(BTNode n) {
        this.right = n;
    }

    public void setLeft(BTNode n) {
        this.left = n;
    }

    public void setParent(BTNode n) {
        this.parent = n;
    }

    public BTNode getParent() {
        return this.parent;
    }

    public Object getData() {
        return data;
    }
}
