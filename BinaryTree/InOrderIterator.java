/** Traverses through a binary tree in-order. */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class InOrderIterator implements Iterator {

    private Stack<BTNode> stack = new Stack<BTNode>();

    public InOrderIterator (BTNode root) {
        if(root != null) {
            BTNode currentNode = root;
            stack.push(currentNode);
            while(currentNode.getLeft() != null) {
                stack.push(currentNode.getLeft());
                currentNode = currentNode.getLeft();
            }
        }
    }

    public boolean hasNext () {
        return !stack.isEmpty();
    }

    public Object next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        BTNode currentNode = stack.pop();
        if(currentNode.getRight() != null) {
            BTNode nextNode = currentNode.getRight();
            stack.push(nextNode);
            while(nextNode.getLeft() != null) {
                stack.push(nextNode.getLeft());
                nextNode = nextNode.getLeft();
            }
        }
        return currentNode.getData();
    }

    public void remove () {
           // N.B., Since we're concurrently iterating through and
           // tampering with the data structure, all bets are off
           // as to its future behavior, especially the order in which
           // objects are delivered going forward.
         throw new UnsupportedOperationException();
    }

}
