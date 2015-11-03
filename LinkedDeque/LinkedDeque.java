public class LinkedDeque {
    private int size;
    private DequeNode beginning, end;

    public LinkedDeque() {
        this.size = 0;
        this.beginning = null;
        this.end = null;
    }

    public void insertLeft ( Object o ) {
        DequeNode d = new DequeNode(o);
        if(size == 0) {
            this.beginning = d;
            this.end = d;
            size++;
            return;
        }

        d.setRight(this.beginning);

        this.beginning.setLeft(d);
        


        this.beginning = d;

    }
    public void insertRight ( Object o ) {

    }
    public void deleteLeft () {
        this.beginning = this.beginning.getRight();
        this.beginning.setLeft(null);
    }
    public void deleteRight () {

    }

    // returns the left element without modifiying the deque
    public Object left () {
        return new UnsupportedOperationException();
    }

    // returns the right element without modifiying the deque
    public Object right () {
        return new UnsupportedOperationException();
        
    }
    
    
    public int size () {
        return this.size;
    }
    
    // returns [obj][obj]...[obj]
    public String toString () {
        return "";

    }

    // runs a comprehensive set of unit tests
    public static void main ( String[] args ) {

    }
 

}
