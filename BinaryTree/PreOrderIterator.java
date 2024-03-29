/** Traverses through a binary tree in pre-order, the difference is that next() returns a node and not the data in the node. */
import java.lang.Iterable;
import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;


public class PreOrderIterator implements Iterator {
    private BTNode nextNode;
   
       

    public PreOrderIterator (BTNode bn) {
        nextNode = bn;
        
    }

    public boolean hasNext () {
        return nextNode != null;
    }

    public Object next() {
        if(nextNode == null) {
          throw new NoSuchElementException();
        }

        BTNode next = nextNode;

        if(nextNode.getLeft() != null) {
            nextNode = nextNode.getLeft();
            
        } else if(nextNode.getRight() != null) {    
            nextNode = nextNode.getRight();
            
        } else {
            BTNode parent = nextNode.getParent();
            BTNode child = nextNode;
            while(parent != null && (parent.getRight() == child || parent.getRight() == null)) {
              child = parent;
              parent = parent.getParent();
            
            }
            if(parent == null) {
               nextNode = null;
            
            } else {
              nextNode = parent.getRight();
       
            }
        }
        return next;
    }

    public void remove () {
           // N.B., Since we're concurrently iterating through and
           // tampering with the data structure, all bets are off
           // as to its future behavior, especially the order in which
           // objects are delivered going forward.
         throw new UnsupportedOperationException();
    }
}
