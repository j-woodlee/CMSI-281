/** An object of this class represents a number list, i.e., an ordered collection
    of integers, each of Java class <a href="http://docs.oracle.com/javase/7/docs/api/java/lang/Long.html">Long</a>, 
    with duplicates permitted. Be sure to read the Java documentation on
    <a href="http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html">interface java.util.Collection</a>.
*/

public class NumberList implements java.util.Collection {

    private Long[] longArray;


    /** Constructs an empty number list. */
    public NumberList(){
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        this.longArray = new Long[0];
    }

    /** Constructs a number list from an array of Longs. */
    public NumberList( Long[] l ){
        this.longArray = l;
    }
    
    /** Increases by one the number of instances of the given element in this collection. */
    public boolean add ( Object obj ) {//add null checks
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        if (!(obj instanceof Long) || obj == null) {
            return false;
        }

        Long[] newLongArray = new Long[this.longArray.length + 1];

        for(int i = 0; i < longArray.length; i++) {
            newLongArray[i] = longArray[i];
        }
        
        newLongArray[longArray.length] = (Long) obj;
        this.longArray = newLongArray;
        return true;
    }
    

    /** Adds all of the elements of the given number list to this one. */
    public boolean addAll ( java.util.Collection c  ) {

        if(!(c instanceof NumberList) || c == null) {
            return false;
        }
        
        NumberList n = (NumberList)c;
        
        for(Long l : n.longArray) {
            this.add(l);
        }

        return true;
    }
 

    /** Removes all of the elements from this collection. */
    public void clear () {
        this.longArray = new Long[0];
    }
 

    /** Returns true iff this number list contains at least one instance of the specified element. */
    public boolean contains ( Object obj ) {
        if (!(obj instanceof Long) || obj == null) {
            return false;
        }

        Long l = (Long)obj;

        for (int i = 0; i < this.longArray.length; i++) {
            if (this.longArray[i].equals(l)) {
                return true;
            }
        }
        return false;
    }
 
    /** Returns true iff this number list contains at least one instance of each element 
        in the specified list. Multiple copies of some element in the argument do not
        require multiple copies in this number list. */
    public boolean containsAll ( java.util.Collection c ) {
        if(!(c instanceof NumberList) || c == null) {
            return false;
        }

        NumberList n = (NumberList)c;

        int counter = 0;
        for(int i = 0; i < n.longArray.length;i++) {
                if(this.contains(n.longArray[i])) {
                    counter++;
                }
        }

        return counter == n.longArray.length;
    }

    /** Compares the specified object with this collection for equality. */
    public boolean equals ( Object obj ) {
        if(!(obj instanceof NumberList) || obj == null) {
            return false;
        }

        NumberList n = (NumberList)obj;

        if(n.longArray.length != this.longArray.length) {
            return false;
        }

        long instancesEqual = 0;

        for(int i = 0; i < this.longArray.length;i++) {
            if(this.longArray[i].equals(n.longArray[i])) {
                instancesEqual++;
            }
        }

        return instancesEqual == this.longArray.length;
    }
 
    /** Returns the hashcode value for this collection. */
    public int hashCode () {
        return super.hashCode();
    }

    /** Returns true if this collection contains no elements. */
    public boolean isEmpty () {
        if(this == null || this.longArray.length > 0) {
            return false;
        }

        return true;
    }



    /** Returns an iterator over the elements in this collection. Replicated elements should
        be "iterated over" just once. */
    public java.util.Iterator iterator () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE *///optional activity.
        throw new UnsupportedOperationException();
    }



    /** Removes a single instance of the specified element from 
        this collection, if it is present. */
    public boolean remove ( Object obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        if(!(obj instanceof Long)) {
            return false;
        }

        for(int i = 0; i < this.longArray.length;i++) {
            if(obj == longArray[i]) {//if it points to the same location in memory
                Long[] shorterArray = new Long[longArray.length - 1];
                for(int j = 0;j < longArray.length;j++) {
                    if(j == i) {
                        continue;
                    }
                    shorterArray[j] = this.longArray[j];
                }
                this.longArray = shorterArray;
                return true;
            }
        }
        return false;
    }



    /** Removes all of this collection's elements that are also contained 
        in the specified collection. */
    public boolean removeAll ( java.util.Collection c ) {
        if(!(c instanceof NumberList)) {
            return false;
        }

        NumberList n = (NumberList)c;

        for(int i = 0; i < this.longArray.length;i++) {
            for(int j = 0; j < n.longArray.length;j++) {
                if(n.longArray[j] == this.longArray[i]) {
                    this.remove(n.longArray[i]);
                }
            }
        }
        return true;
    }

    /** Retains only the elements in this collection that are contained in the specified collection. 
         In other words, removes from this collection all of its elements that are not contained in the 
         specified collection. */
    public boolean retainAll ( java.util.Collection c ) {
        if (!(c instanceof NumberList) || c == null) {
            return false;
        }

        NumberList n = (NumberList) c;
        for(int i = 0; i < this.longArray.length;i++) {
            if(!n.contains(this.longArray[i])) {//if n does not contain the element in this.longArray, remove element
                this.remove(this.longArray[i]);
            }
        }
        return true;
    }


    /** Returns the number of elements in this number list, including duplicates. */
    public int sizeIncludingDuplicates () {
        return this.longArray.length;
    }
    
    

    /** Returns a NumberList[] containing all of the elements in this collection, not including duplicates. */
    public Long[] toArray () {
        return longArray;
    }



    /** Not supported for this class. */
    public Long[] toArray ( Object[] obj ) {
        throw new UnsupportedOperationException();
    }




    /** Returns the number of elements in this number list, not including duplicates. */
    public int size () {
        int numberOfDupes = 0;

        for(int i = 0; i < this.longArray.length;i++) {
            for(int j = 0; j < this.longArray.length; j++) {
                if(this.longArray[i].equals(this.longArray[j]) && (i != j)) {
                    numberOfDupes++;
                }
            }
        }

        return this.longArray.length - numberOfDupes;
    }


    /** Returns the number of instances of the given element in this number list. */
    public int count ( Object obj ) {
        if(!(obj instanceof Long) || obj == null) {
            return 0;
        }
        int numberOfInstances = 0;
        Long l = (Long) obj;
        for(int i = 0; i < this.longArray.length;i++) {
            if(this.longArray[i].equals(l)) {
                numberOfInstances++;
            }
        }
        return numberOfInstances;
    }
    

    
    /** This returns a stringy version of this number list. */
    public String toString () { // overrides Object.toString()
        if(this.longArray.length == 0) {
            return "[]";
        }
        String s = "[";
        for(Long l : longArray) {
            s += (l + ",");
        }
        s += "]";
        s = s.substring(0,s.length() - 2) + s.substring(s.length() - 1);
        return s;
    }


    
    /** This so-called "static factory" returns a new number list comprised of the numbers in the specified array.
        Note that the given array is long[], not Long[]. */
    public static NumberList fromArray ( long[] l ) {

        Long[] lo = new Long[l.length];
        for(int i = 0; i < l.length;i++) {
            lo[i] = new Long(l[i]);
        }

        return new NumberList(lo);
    }
    
    /** This main method is just a comprehensive test program for the class. */
    public static void main ( String[] args ) {
        System.out.println("Testing add...");
        
        System.out.println("Testing addAll...");
        System.out.println("Testing clear...");
        System.out.println("Testing contains...");
        System.out.println("Testing containsAll...");
        System.out.println("Testing equals...");
        System.out.println("Testing isEmpty...");
        System.out.println("Testing remove...");
        System.out.println("Testing removeAll...");
        System.out.println("Testing retainAll");
        System.out.println("Testing sizeIncludingDuplicates...");
        System.out.println("Testing toArray");
        System.out.println("Testing size...");
        System.out.println("Testing count...");
        System.out.println("Testing toString...");
        System.out.println("Testing fromArray...");
        

    }
}
