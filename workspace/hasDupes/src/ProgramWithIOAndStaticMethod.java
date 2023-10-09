import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramWithIOAndStaticMethod {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ProgramWithIOAndStaticMethod() {
    }

    /**
     * returns whether the given array has duplicate entries.
     *
     * @ensures hasDuplicates = [true if at least two entries in numbers are
     *          equal, false otherwise]
     *
     */
    private static boolean isDecreasing(int[] numbers) {

        boolean isDec = true;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] <= numbers[i + 1]) {
                isDec = false;

            }

        }

        return isDec;

        /*
         * Put your code for myMethod here
         */
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        int[] myArray = { 3, 2, 1, 0 };

        out.print(isDecreasing(myArray));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
