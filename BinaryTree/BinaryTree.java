import java.util.*;


public class BinaryTree implements Iterable {
    private BTNode root;
    private BTNode cursor;
    private int size;

    /** Constructs an empty tree.*/
    public BinaryTree() {
        this.size = 0;
        this.root = null;
        this.cursor = null;
    }

    /**Constructs a tree with just a root node decorated with (i.e., referring to) obj*/
    public BinaryTree(Object o) {
        this.root = new BTNode(o);
        this.size = 1;
        this.cursor = root;
    }

    /** returns true iff the tree contains an object equivalent to obj */
    public boolean contains(Object obj) {
        for(Object bn : this) {
            if(bn.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /** returns true iff obj is a similar binary tree- i.e., obj must have identical structure (only) */
    public boolean similar(Object obj) {
        BinaryTree bt = (BinaryTree) obj;
        if(this.size != bt.getSize() || !(obj instanceof BinaryTree)) {
            return false;
        }

        PreOrderIterator objIt = new PreOrderIterator(bt.getRoot());
        PreOrderIterator thisIt = new PreOrderIterator(this.root);

        BTNode objNode;
        BTNode thisNode; 
        while(thisIt.hasNext()) {
            objNode = (BTNode) (objIt.next());
            thisNode = (BTNode) (thisIt.next()); 

            if((objNode.getLeft() != null && thisNode.getLeft() == null) || (objNode.getLeft() != null && thisNode.getLeft() == null)) {
                return false;
            }

            if((objNode.getRight() != null && thisNode.getRight() == null) || (objNode.getRight() != null && thisNode.getRight() == null)) {
                return false;
            }
        }
        return true;
    } 

    /** returns true iff obj is an equivalent binary tree- i.e., obj must have identical structure and equivalent objects */
    public boolean equals(Object obj) {
        if(!this.similar(obj)) {
            return false;  
        }

        if(this.getSize() == 0) {
            return true;
        }

        BTIterator objIt = new BTIterator(((BinaryTree)obj).getRoot());
        BTIterator thisIt = new BTIterator(this.root);

        while(objIt.hasNext()) {
            if(!objIt.next().equals(thisIt.next())) {
                return false;
            }
        }
        return true;
    }

    /** should do the obvious thing- and the same for public int size() and public int hashCode() */
    public boolean isEmpty() {
        return size == 0;
    }

    /** should return a preorder iterator over the tree, whereas public Iterator inOrder() should return an inorder iterator over the tree */
    public Iterator iterator() {
        return new BTIterator(this.getRoot());
    }

    public InOrderIterator inOrder() {
        return new InOrderIterator(this.getRoot());
    }

    /** returns false if this is an empty tree */
    public boolean putCursorAtRoot() {
        if (this.size == 0) {
            return false;
        }
        this.cursor = this.root;
        return true;
    }

    public boolean putCursorAtLeftSon() {
        if (this.size == 0 || this.cursor.getLeft() == null) {
            return false;
        }

        this.cursor = this.cursor.getLeft();
        return true;
    }

    public boolean putCursorAtRightSon() {
        if (this.size == 0 || this.cursor.getRight() == null) {
            return false;
        }
        this.cursor = this.cursor.getRight();
        return true;
    }
    public boolean putCursorAtFather() {
        if (this.size == 0 || this.cursor.getParent() == null) {
            return false;
        }
        this.cursor = this.cursor.getParent();
        return true;
    }

    /** returns false if a left son already exists */
    public boolean attachLeftSonAtCursor(Object obj) {
        if(this.cursor != null && this.cursor.getLeft() != null) {
            return false;
        }

        if (this.size == 0) {//In case you want to add to an empty tree
            this.root = new BTNode(obj);
            this.cursor = root;
            this.size = 1;
            return true;
        }


        cursor.setLeft(new BTNode(obj));
        cursor.getLeft().setParent(this.cursor);
        this.size++;

        return true;
    }

    /** returns false if a right son already exists */
    public boolean attachRightSonAtCursor(Object obj) {
        if(this.cursor != null && this.cursor.getRight() != null) {
            return false;
        }
        if (this.size == 0) {//In case you want to add to an empty tree
            this.root = new BTNode(obj);
            this.cursor = root;
            this.size = 1;
            return true;
        }

        cursor.setRight(new BTNode(obj));
        cursor.getRight().setParent(this.cursor);
        this.size++;

        return true;
    }

    /** removes everything that descends from the cursor, including the node to which the cursor refers, then relocates the cursor to the root node, returning true iff something (including the cursor) changed */
    public boolean pruneFromCursor() {
        if(size == 0) {
            return false;
        } 

        if(this.cursor.getParent() == null) {
            this.root = null;
            this.cursor = root;
            size = 0;
            return true;
        }

        BTNode p = this.cursor.getParent();

        if(p.getLeft() == this.cursor) {
            p.setLeft(null);
        } else {
            p.setRight(null);
        }

        this.cursor = root;

        int count = 0;

        for(Object bn : this) {
            count++;
        }
        size = count;
        return true;
    }

    public BTNode getRoot() {
        return this.root;
    }

    public int getSize() {
        return this.size;
    }

    public BTNode getCursor() {
        return this.cursor;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(new String("0"));
        bt.attachRightSonAtCursor(new String("2"));
        bt.attachLeftSonAtCursor(new String("1"));

        BTIterator bti = new BTIterator(bt.getRoot());

        for(Object bn : bt) {

           System.out.println(bn);
        }
        System.out.println("------");

        //bt.pruneFromCursor();
        bt.putCursorAtLeftSon();
        bt.attachLeftSonAtCursor("3");
        bt.attachRightSonAtCursor("4");
        bt.putCursorAtFather();
        bt.putCursorAtRightSon();
        bt.attachLeftSonAtCursor("5");
        bt.attachRightSonAtCursor("6");

        for(Object bn : bt) {
            System.out.println(bn);
        }

        System.out.println("----------");

        BinaryTree bt1 = new BinaryTree(new String("test"));
        bt.similar(bt1);

    }
}
