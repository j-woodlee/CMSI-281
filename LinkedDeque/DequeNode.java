public class DequeNode {
    private Object info;
    private DequeNode toTheLeft, toTheRight;

    public DequeNode(Object info) {
        this.info = info;
        this.toTheLeft = null;
        this.toTheRight = null;
    }

    public DequeNode getLeft() {
        return this.toTheLeft;
    }

    public DequeNode getRight() {
        return this.toTheRight;
    }

    public void setRight(DequeNode d) {
        this.toTheRight = d;
    }

    public void setLeft(DequeNode d) {
        this.toTheLeft = d;
    }
    public Object getInfo() {
        return this.info;
    }
}
