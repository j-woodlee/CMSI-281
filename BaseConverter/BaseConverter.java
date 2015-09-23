
public class BaseConverter {


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
                System.out.print(a);
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

    public static void usage() {
        System.out.println("<starting number with digits separated by brackets like this: [0][0][0][0]> <starting base> <target base>");
    }

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

    public static String tenToBase(long baseTenNumber, long targetBase) {
        String targetNumber = "";

        long dividend = baseTenNumber;
        while(dividend > 0) {
            System.out.println(dividend + "/" + targetBase + " = " + dividend/targetBase + "R" + dividend%targetBase);
            
            targetNumber = targetNumber + (dividend % targetBase);
            dividend = dividend / targetBase;
        }

        return new StringBuilder(targetNumber).reverse().toString();
    }

    public static boolean validArgs(String[] args) {
        try {
            if((args.length > 3) || (args[0].charAt(0) != '[') || (args.length <= 1)) {
                return false;
            }
            Long.parseLong(args[1]);
            

            for(int i = 0;i < args[0].length();i++) {
                if(args[0].charAt(i) == ' ' || Character.isLetter(args[0].charAt(i))) {
                    return false;
                }
            }
            for(int i = 0; i < args[1].length();i++) {
                if(args[1].charAt(i) == ' ' || Character.isLetter(args[1].charAt(i))) {
                    return false;
                }
            }

            if(args.length == 3) {
                Long.parseLong(args[2]);
                for(int i = 0; i < args[2].length();i++) {
                    if(args[2].charAt(i) == ' ' || Character.isLetter(args[2].charAt(i))) {
                        return false;
                    }
                }
            }
            return true;

        } catch(NumberFormatException nfe) {
            return false;
        } catch(ArrayIndexOutOfBoundsException aioobe) {
            return false;
        }
    }
}
