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
public final class Newton3 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton3() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     * @param epsilon
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {
        double r = x;
        while (x != 0 && Math.abs(r * r - x) / x > epsilon) {
            r = (r + x / r) / 2;

        }
        return r;
    }

    /*
     * the loop is now a little different because i had to create a new
     * parameter and also the condition changed because now the user gets to
     * decide the value of epsilon
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
            out.print("Enter the value of epsilon: ");
            double episilon = in.nextDouble();

            out.print("Enter a number: ");
            int num = in.nextInteger();

            double answer = sqrt(num, episilon);
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
