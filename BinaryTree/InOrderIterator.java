/** Traverses through a binary tree in-order. */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class InOrderIterator implements Iterator {
     private BTNode nextNode;
       

    public InOrderIterator (BTNode bn) {
        nextNode = bn;
        if(nextNode == null) {
            return;
        }
        while(nextNode.getLeft() != null) {
            nextNode = bn.getLeft();
        }
    }

    public boolean hasNext () {
        return nextNode != null;
    }

    public Object next() {
        if(nextNode == null) {
          throw new NoSuchElementException();
        }
        BTNode next = nextNode;
        if(nextNode.getRight() != null) {
            nextNode = nextNode.getRight();
            while(nextNode.getLeft() != null) {
                nextNode = nextNode.getLeft();
            }
            return next.getData();
        } else while(true) {
            if(nextNode.getParent() == null) {
                nextNode = null;
                return next.getData();
            }
            if(nextNode.getParent().getLeft() == nextNode) {
                nextNode = nextNode.getParent();
                return next.getData();
            }
            
            // if((nextNode.getRight() == null) && (nextNode.getLeft() == null)) {
            //    if() {

            //    }
            //    while(parent.getRight() = ) {

            //     }
            
        }
    }

    public void remove () {
           // N.B., Since we're concurrently iterating through and
           // tampering with the data structure, all bets are off
           // as to its future behavior, especially the order in which
           // objects are delivered going forward.
         throw new UnsupportedOperationException();
    }

}
