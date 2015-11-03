public class LinkedDeque {
    private int size;
    private DequeNode lNode, rNode;

    public LinkedDeque() {

    }

    public void insertLeft ( Object o ) {
        if(o instanceof DequeNode) {

        }
    }
    public void insertRight ( Object o ) {
        if(o instanceof DequeNode) {

        }

    }
    public void deleteLeft () {

    }
    public void deleteRight () {

    }


    // returns the left element without modifiying the deque
    public Object left () {
        return this.lNode;
    }

    // returns the right element without modifiying the deque
    public Object right () {
        return this.rNode;
    }
    
    // returns [obj][obj]...[obj]
    public int size () {
        return this.size;
    }
    
    public String toString () {

    }

    // runs a comprehensive set of unit tests
    public static void main ( String[] args ) {

    }
 

}
