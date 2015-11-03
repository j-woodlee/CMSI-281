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
        size++;
    }
    public void insertRight ( Object o ) {
        DequeNode d = new DequeNode(o);
        if(size == 0) {
            this.beginning = d;
            this.end = d;
            size++;
            return;
        }
        d.setLeft(this.end);
        this.end.setRight(d);
        this.end = d;
        size++;
    }

    public void deleteLeft () {
        if(this.size == 0) {
            throw new UnsupportedOperationException();
        } else if(size == 1) {
            this.beginning = null;
            this.end = null;
            size--;
            return;
        }
        this.beginning = this.beginning.getRight();
        this.beginning.setLeft(null);
        size--;
    }
    public void deleteRight () {
        if(this.size == 0) {
            throw new UnsupportedOperationException();
        } else if(size == 1) {
            this.beginning = null;
            this.end = null;
            size--;
            return;
        }
        this.end = this.end.getLeft();
        this.end.setRight(null);
        size--;
    }

    // returns the left element without modifiying the deque
    public Object left () {
        return this.beginning.getInfo();
    }

    // returns the right element without modifiying the deque
    public Object right () {
        return this.end.getInfo();
    }
    
    
    public int size () {
        return this.size;
    }
    
    // returns [obj][obj]...[obj]
    public String toString () {

        DequeNode next = this.beginning;
        //System.out.println(this.beginning.getInfo());
        //System.out.println(next.getInfo());


        String s = "";

         if(this.size > 0) {
             while (next != null) {
                //System.out.println(next);
                s = s + "[" + next.getInfo().toString() + "]";
                //System.out.println(next.getRight());
                next = next.getRight();
             }
         }
        return s;
    }

    // runs a comprehensive set of unit tests
    public static void main ( String[] args ) {
        LinkedDeque deque = new LinkedDeque();

        //System.out.println(deque);

        deque.insertLeft("Test0");
        System.out.println(deque);

        deque.insertLeft("Test-1");
        System.out.println(deque);

        deque.insertRight("Test1");
        System.out.println(deque);

        deque.insertRight("Test2");
        System.out.println(deque);

        deque.deleteRight();
        System.out.println(deque);

        deque.deleteRight();
        System.out.println(deque);

        deque.deleteRight();
        System.out.println(deque);

        deque.deleteRight();
        System.out.println(deque);


    }
}
