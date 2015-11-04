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

        String s = "";

         if(this.size > 0) {
             while (next != null) {
                s = s + "[" + next.getInfo().toString() + "]";
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

        deque.insertLeft("test");
        System.out.println(deque);

        deque.deleteLeft();
        System.out.println(deque);

        //deque.deleteRight();

        deque.insertLeft("test1");
        deque.insertRight("test2");
        deque.insertLeft("test0");
        deque.insertLeft("test-1");
        deque.insertLeft("test-2");
        deque.insertRight("test3");
        deque.insertRight("test4");

        System.out.println(deque);

        System.out.println(deque.left());
        System.out.println(deque.right());
        System.out.println(deque.size());



    }
}
