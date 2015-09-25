/**
  *Converts a starting number in a starting base to a target base.
  *@author Jake Woodlee
  *@version 1.0
**/



public class BaseConverter {

    
    
    /** Takes a String array and using other static methods within the class, 
    *goes from a starting number in a starting base to a target base.
    *@param args    String array that holds the digits of the starting number, the starting number base, and the target base 
    *
    **/
    public static void main(String[] args) {
        
        if(!validArgs(args)) {
            usage();
            throw new IllegalArgumentException();
        } else {

            long[] startingNumber = deduceDigits(args[0]);
            long startingBase = Long.parseLong(args[1]);
            long targetBase;
            if(args.length == 3) {
                targetBase = Long.parseLong(args[2]);
            } else {
                targetBase = 10;
            }

            System.out.print("Starting Number: ");

            for(long a:startingNumber) {
                System.out.print("[" + a + "]");
            }


            System.out.println("\n" + "Starting Base: " + startingBase);
            System.out.println("Target Base: " + targetBase);

            long numberInBaseTen = baseToTen(startingNumber, startingBase);
            System.out.println("Number in base ten: " + numberInBaseTen);

            String numberInTargetBase = tenToBase(numberInBaseTen, targetBase);
            if(numberInTargetBase.equals("")) {
                System.out.println("Number in target base: " + 0);
            } else {
                System.out.println("Number in target base: " + numberInTargetBase);
            }
        }
    }


    /** Prints out the proper way to input the starting number, starting base, and target base. **/
    public static void usage() {
        System.out.println("<starting number with digits separated by brackets like this: [digitOne][digitTwo][digitThree][digitFour] etc.> <starting base> <target base>");
    }


    /**
     *Deduces the startingNumber digits from within a String and returns a long[] filled with the digits.
     *
     * @param argument    String representing the digits of a number like this: "[digitOne][digitTwo][digitThree][digitFour]".
     * @return long[] holding the digits from argument
     **/

    public static long[] deduceDigits(String argument) {
        int numberOfDigits = 0;

        for(int i = 0; i < argument.length();i++) {
            if(argument.charAt(i) == '[') {
                numberOfDigits++;
            }
        }

        System.out.println("startingNumber digit number: " + numberOfDigits);
        long[] digits = new long[numberOfDigits];

        int digitIndex = 0;
        for(int i = 0; i < argument.length(); i++) {
            if(argument.charAt(i) == '[') {
                int x = i + 1;//index of first number after bracket
                String digit = "";
                while(!argument.substring(x,x+1).equals("]")) {
                    digit += argument.substring(x,x+1);
                    x++;
                }
                digits[digitIndex] = Long.parseLong(digit);
                digitIndex++;
            }
        }

        return digits;
    }

    /**
    *
    *Takes a starting number and a starting base and converts the starting number to base ten.
    *
    *@param startingNumber  long[] holding the digits of the starting number
    *@param startingBase    long representing the current base startingNumber is in
    *@return  long holding the value of the startingNumber in base ten
    **/

    public static long baseToTen(long[] startingNumber, long startingBase) {
        long sum = 0;
        long toBeAdded;
        int i2 = 0;
        for(int i = startingNumber.length - 1;i >=0;i--) {
            toBeAdded = ((long)Math.pow(startingBase,i))*startingNumber[i2];
            i2++;
            sum += toBeAdded;
        }

        return sum;
    }

    /**
    *
    *Takes a number in base ten, and a target base, and returns the number in the target base.
    *
    *@param baseTenNumber  long holding a number in base ten
    *@param targetBase   long holding the target base
    *@return  String that holds the base ten number that has been converted to the targetBase
    **/

    public static String tenToBase(long baseTenNumber, long targetBase) {
        String targetNumber = "";

        long dividend = baseTenNumber;
        if(baseTenNumber == 0) {
            return "[0]";
        }
        
        while(dividend > 0) {
            System.out.println(dividend + "/" + targetBase + " = " + dividend/targetBase + "R" + dividend%targetBase);

            targetNumber = "[" + dividend%targetBase + "]" + targetNumber;;
            dividend = dividend / targetBase;
        }

        return targetNumber;
    }

    /**
    *
    * Tests if the arguments passed through it are valid.
    *
    *@param args  String[] holding the value of arguments to be tested.
    *
    *@return  boolean, true if the arguments passed are valid, false otherwise
    **/

    public static boolean validArgs(String[] args) {
        
            if((args.length > 3) || (args.length <= 1)) {//test args.length is proper size
                System.out.println("here0");
                return false;
            }

            if(args[0].charAt(args[0].length() - 1) != ']') {
                return false;
            }

            if(args[0].charAt(0) != '[') {
                return false;
            }

            for(int i = 0; i < args[0].length() - 1;i++) {//test args[0]

                if(args[0].charAt(i) == '[' && Character.isDigit(args[0].charAt(i+1))) {
                    continue;
                } else if (args[0].charAt(i) == ']' && args[0].charAt(i+1) == '[') {
                    continue;
                } else if(Character.isDigit(args[0].charAt(i)) && Character.isDigit(args[0].charAt(i+1))) {
                    continue;
                } else if (Character.isDigit(args[0].charAt(i)) && args[0].charAt(i+1) == ']') {
                    continue;
                } else {
                    return false;
                }
            }

            for(int i = 0; i < args[1].length();i++) {//test args[1]
                if(!Character.isDigit(args[1].charAt(i))) {
                    System.out.println("here3");
                    return false;
                }
            }

            if(Long.parseLong(args[1]) <= 1) {//test that args[1] is a valid base
                System.out.println("here1");
                return false;
            }

            if(args.length == 3) {

                for(int i = 0; i < args[2].length();i++) {//test args[2]
                    if(!Character.isDigit(args[2].charAt(i))) {
                        return false;
                    }
                }

                if(Long.parseLong(args[2]) <= 1) {//test args[2] is a valid base
                    return false;
                }
            }

            long[] testArgs = deduceDigits(args[0]);

            for(int i = 0; i < testArgs.length;i++) {
                if(testArgs[i] >= Long.parseLong(args[1])) {
                    return false;
                }
            }

            return true;
    }
}
