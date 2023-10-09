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
public final class Newton2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton2() {
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
        while (x != 0 || Math.abs(r * r - x) / x > episilom) {
            r = (r + x / r) / 2;

        }
        return r;
    }

    /*
     * the loop above is the same as the one from newton1 except the condition
     * is changed so that it works when x = 0
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

        while (response.equals("y")) {
            out.print("Enter a number: ");
            int num = in.nextInteger();

            double answer = sqrt(num);
            out.println(answer);
            // i added this last question again so it doesn't loop infinitely
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
