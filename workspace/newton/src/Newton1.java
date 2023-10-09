import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * . Program takes an input from the user and calculate the square root within
 * relative error 0.01%
 *
 * @author Zakaria Hassan
 *
 */
public final class Newton1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double r = x;
        final double episilom = 0.0001;
        while (Math.abs(r * r - x) / x > episilom) {
            r = (r + x / r) / 2;

        }
        return r;
    }

    /*
     * this loop above updates r until it meets this condition which will make
     * the relative error less than 0.0001%, then it returns r.
     */
    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Do you wish to calculate a Square root? y or n ?");
        String response = in.nextLine();

        /*
         * this loop asks the user for a number and finds the square root, it
         * will continue this until the user enters 'n' to end the loop and quit
         * the program
         */
        while (response.equals("y")) {
            out.print("Enter a number: ");
            int num = in.nextInteger();

            double answer = sqrt(num); // this is the method being called
            out.println(answer);

            out.print("Do you wish to calculate a Square root? y or n ?");
            response = in.nextLine();
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
