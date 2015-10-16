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
    
    /** Increases by one the number of instances of the given element in this collection. Big Theta of N where N is the size of the array*/
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
    

    /** Adds all of the elements of the given number list to this one. Big theta of n squared*/
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
 

    /** Removes all of the elements from this collection. Big theta of 1*/
    public void clear () {
        this.longArray = new Long[0];
    }
 

    /** Returns true iff this number list contains at least one instance of the specified element. Big theta of n*/
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
        require multiple copies in this number list. Big theta of n squared*/
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

    /** Compares the specified object with this collection for equality. Big theta of n*/
    public boolean equals ( Object obj ) {
        if(!(obj instanceof NumberList) || obj == null ) {
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

    /** Returns true if this collection contains no elements. big theta of 1*/
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
        this collection, if it is present. Big theta of N to the N*/
    public boolean remove ( Object obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        if(!(obj instanceof Long) || obj == null) {
            return false;
        }

        Long l = (Long) obj;
        Long[] shorterArray = new Long[this.longArray.length - 1];
        int indexToBeRemoved = 0;
        boolean needsRemoval = false;
        for(int i = 0; i < this.longArray.length;i++) {
            if(this.longArray[i].equals(l)) {
               indexToBeRemoved = i;
               needsRemoval = true;
            }
        }

        for(int i = 0; i < this.longArray.length;i++) {
            if(i == indexToBeRemoved) {
                break;
            }
            shorterArray[i] = this.longArray[i];
        }

        for(int i = indexToBeRemoved+1; i < this.longArray.length;i++) {
            shorterArray[i-1] = this.longArray[i];
        }

        if(needsRemoval) {
            this.longArray = shorterArray;
        }
        

        return true;
    }



    /** Removes all of this collection's elements that are also contained 
        in the specified collection. Big theta of */
    public boolean removeAll ( java.util.Collection c ) {
        if(!(c instanceof NumberList) || c == null) {
            return false;
        }

        NumberList n = (NumberList)c;

        for(int i = 0; i < this.longArray.length;i++) {
            for(int j = 0; j < n.longArray.length;j++) {
                if(n.longArray[j].equals(this.longArray[i])) {
                    this.remove(this.longArray[i]);
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
            if(n.contains(this.longArray[i])) {
                continue;
            }
            this.remove(this.longArray[i]);
        }
        return true;
    }


    /** Returns the number of elements in this number list, including duplicates. */
    public int sizeIncludingDuplicates () {
        return this.longArray.length;
    }
    
    

    /** Returns a long[] containing all of the elements in this collection, not including duplicates. */
    public Long[] toArray () {
        return this.longArray;
    }



    /** Not supported for this class. */
    public Long[] toArray ( Object[] obj ) {
        throw new UnsupportedOperationException();
    }




    /** Returns the number of elements in this number list, not including duplicates. */
    public int size () {
        return 1;

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
        NumberList n1 = new NumberList(new Long[] {new Long(1), new Long(-1), new Long(0), new Long(99), new Long(40), new Long(-69)});
        NumberList n2 = new NumberList(new Long[] {new Long(2), new Long(-1), new Long(0), new Long(99), new Long(40), new Long(-69)});
        System.out.println("Should all be true if working properly.");

        System.out.println("Testing equals...");
        System.out.println(!n1.equals(n2));
        System.out.println(!n2.equals(n1));
        n2.longArray[0] = new Long(1);
        System.out.println(n1.equals(n2));
        System.out.println(n2.equals(n1));
        n1 = new NumberList(new Long[] {new Long(1), new Long(-1), new Long(0), new Long(99), new Long(40)});
        System.out.println(!n1.equals(n2));
        n2 = null;
        System.out.println(!n1.equals(n2));
        n2 = new NumberList(new Long[] {new Long(10), new Long(-11), new Long(9), new Long(7), new Long(40), new Long(-345879)});
        System.out.println(!n1.equals(n2));
        System.out.println(!n2.equals(n1));
        Object o = (Object)n2;
        System.out.println(!n1.equals(o));

        System.out.println("Testing add...");
        n2 = new NumberList();
        n2.add(new Long(1));
        n2.add(new Long(-1));
        n2.add(new Long(-69));
        n2.add(new Long(-69));
        n2.add(new Long(69));
        n2.add(new Long(0));
        System.out.println(n2.equals(new NumberList(new Long[] {new Long(1), new Long(-1), new Long(-69), new Long(-69), new Long(69), new Long(0)})));
        n2.add(new Long(12345));
        System.out.println(n2.equals(new NumberList(new Long[] {new Long(1), new Long(-1), new Long(-69), new Long(-69), new Long(69), new Long(0), new Long(12345)})));

        System.out.println("Testing addAll...");
        n2 = new NumberList();
        n1 = new NumberList(new Long[] {new Long(0), new Long(0), new Long(8), new Long(53), new Long(7), new Long(-7)});
        n2.addAll(n1);
        System.out.println(n2.equals(new NumberList(new Long[] {new Long(0), new Long(0), new Long(8), new Long(53), new Long(7), new Long(-7)})));
        n1.addAll(n2);
        System.out.println(n1.equals(new NumberList(new Long[] {new Long(0), new Long(0), new Long(8), new Long(53), new Long(7), new Long(-7), new Long(0), new Long(0), new Long(8), new Long(53), new Long(7), new Long(-7)})));

        System.out.println("Testing clear...");
        n1.clear();
        n2.clear();
        System.out.println(n1.equals(new NumberList()));
        System.out.println(n2.equals(new NumberList()));

        System.out.println("Testing contains...");
        n1 = new NumberList(new Long[] {new Long(-1), new Long(0), new Long(1), new Long(123123134)});
        n2 = new NumberList(new Long[] {new Long(-234234), new Long(234234), new Long(234), new Long(123123134)});
        System.out.println(n1.contains(new Long(-1)));
        System.out.println(n1.contains(new Long(0)));
        System.out.println(!n1.contains(new Long(-23847)));
        System.out.println(!n1.contains(new Long(-5)));
        System.out.println(n1.contains(new Long(123123134)));
        System.out.println(!n1.contains(new Long(123123123)));
        System.out.println(!n2.contains(new Long(-1)));
        System.out.println(n2.contains(new Long(234)));
        System.out.println(n2.contains(new Long(234234)));
        System.out.println(n2.contains(new Long(-234234)));
        System.out.println(!n1.contains(new Long(-2342342)));

        System.out.println("Testing containsAll...");
        n1 = new NumberList(new Long[] {new Long(-1), new Long(0), new Long(1), new Long(123123134)});
        n2 = new NumberList(new Long[] {new Long(-99999), new Long(123), new Long(34), new Long(1231134)});
        System.out.println(!n1.containsAll(n2));
        System.out.println(!n2.containsAll(n1));
        n1 = new NumberList(new Long[] {new Long(-99999), new Long(123), new Long(34)});
        System.out.println(n2.containsAll(n1));
        n1 = new NumberList(new Long[] {new Long(-99999), new Long(123), new Long(34), new Long(-99999), new Long(-99999)});
        System.out.println(n2.containsAll(n1));
        
        System.out.println("Testing isEmpty...");
        n1 = new NumberList();
        n2 = new NumberList();
        System.out.println(n1.isEmpty());
        System.out.println(n2.isEmpty());

        System.out.println("Testing remove...");
        n1 = new NumberList(new Long[] {new Long(-1), new Long(00), new Long(1), new Long(909090)});
        n2 = new NumberList(new Long[] {new Long(-99999), new Long(123), new Long(34), new Long(1231134)});
        n1.remove(new Long(-1));
        System.out.println(n1.equals(new NumberList(new Long[] {new Long(00), new Long(1), new Long(909090)})));
        n2.remove(new Long(-99999));
        System.out.println(n2);
        System.out.println(n2.equals(new NumberList(new Long[] {new Long(123), new Long(34), new Long(1231134)})));
        n2.remove(new Long(1231134));
        System.out.println(n2);
        System.out.println(n2.equals(new NumberList(new Long[] {new Long(123), new Long(34)})));
        n1.remove(new Long(1));
        System.out.println(n1.equals(new NumberList(new Long[] {new Long(0), new Long(909090)})));
        n2.remove(new Long(0));  
        System.out.println(n2.equals(new NumberList(new Long[] {new Long(123), new Long(34)})));

        System.out.println("Testing removeAll...");
        n1 = new NumberList(new Long[] {new Long(35), new Long(67), new Long(-9), new Long(123123134)});
        n2 = new NumberList(new Long[] {new Long(0), new Long(123), new Long(34), new Long(1231134)});

        n1.removeAll(n2);

        System.out.println(n1.equals(new NumberList(new Long[] {new Long(35), new Long(67), new Long(-9), new Long(123123134)})));

        n2.add(new Long(35));
        n1.removeAll(n2);
        System.out.println(n1.equals(new NumberList(new Long[] {new Long(67), new Long(-9), new Long(123123134)})));
        n2.add(new Long(-9));
        n1.removeAll(n2);
        System.out.println(n1.equals(new NumberList(new Long[] {new Long(67), new Long(123123134)})));


        System.out.println("Testing retainAll...");
        n1 = new NumberList();
        n2 = new NumberList(new Long[] {new Long(67), new Long(123123134)});


        System.out.println(n2);
        n2.retainAll(n1);
        System.out.println(n2);
        System.out.println(n2.equals(new NumberList()));
        n1 = new NumberList(new Long[] {new Long(67), new Long(123123134)});
        n2 = new NumberList(new Long[] {new Long(67), new Long(123123134)});
        System.out.println();





        System.out.println("Testing sizeIncludingDuplicates...");
        n1 = new NumberList();
        n2 = new NumberList(new Long[] {new Long(67), new Long(123123134)});
        System.out.println(n1.sizeIncludingDuplicates() == 0);
        System.out.println(n2.sizeIncludingDuplicates() == 2);
        n2.add(new Long(67));
        System.out.println(n2.sizeIncludingDuplicates() == 3);

        System.out.println("Testing toArray");
        n1 = new NumberList(new Long[] {new Long(67), new Long(123123134), new Long(45), new Long(1), new Long(-1)});
        Long[] longs1 = n1.toArray();
        Long[] longs2 = new Long[] {new Long(67), new Long(123123134), new Long(45), new Long(1), new Long(-1)};

        for(int i = 0; i < longs1.length;i++) {
                System.out.println(longs1[i].equals(longs2[i]));
        }

        System.out.println("Testing size...");
        n1 = new NumberList(new Long[] {new Long(67), new Long(123123134), new Long(45), new Long(1), new Long(-1)});

        System.out.println(n1.size() == 5);

        n1.add(new Long(67));

        System.out.println(n1.size() == 5);
        n1.add(new Long(67));
        System.out.println(n1.size() == 5);
        n1.add(new Long(34));

        System.out.println("Testing count...");
        n1 = new NumberList(new Long[] {new Long(0)});
        System.out.println(n1.count(new Long(0)) == 1);
        n1.add(new Long(3));
        System.out.println(n1.count(new Long(3)) == 1);
        n1.add(new Long(3));
        System.out.println(n1.count(new Long(3)) == 2);
        n1.add(new Long(3));
        System.out.println(n1.count(new Long(3)) == 3);

        System.out.println("Testing fromArray...");
        
        n1 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3), new Long(4), new Long(5), new Long(6), new Long(7), new Long(8), new Long(9), new Long(10)});
        System.out.println(n1.equals(NumberList.fromArray(new long[] {1,2,3,4,5,6,7,8,9,10})));
        n1 = new NumberList(new Long[] {new Long(0), new Long(2), new Long(3), new Long(1234125145), new Long(5), new Long(6), new Long(7), new Long(8), new Long(9), new Long(10)});
        System.out.println(n1.equals(NumberList.fromArray(new long[] {0,2,3,1234125145,5,6,7,8,9,10})));
    }
}
