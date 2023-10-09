import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * The following program approximates a given constant using De Jager formula
 * within a relative error.
 *
 * @author Zakaria Hassan
 *
 */
public final class ABCDGuesser1 {
    /**
     * Private Constructor.
     */
    private ABCDGuesser1() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        out.print("Please enter a positive number: ");
        String posNum = in.nextLine();
        // this loop will run until we can parse the string or more than 0
        while (!FormatChecker.canParseDouble(posNum)
                || !(Double.parseDouble(posNum) > 0)) {
            out.print(
                    "That is an negative number, Please enter a positive number: ");
            posNum = in.nextLine();
        }
        return Double.parseDouble(posNum);

    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        out.print("Please enter a positive number not equal to 1.0: ");
        String posNum = in.nextLine();

        while (!FormatChecker.canParseDouble(posNum)
                || !(Double.parseDouble(posNum) > 0)
                || (Double.parseDouble(posNum) == 1.0)) {
            out.print(
                    "That is a negative number or 1.0, Enter another number:");
            posNum = in.nextLine();
        }
        return Double.parseDouble(posNum); // this converts the string to a double
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        // this array includes the 17 numbers provided in the project description
        final double[] arr = { -5.0, -4.0, -3.0, -2.0, -1.0, -1.0 / 2.0,
                -1.0 / 3.0, -1 / 4, 0, 1.0 / 4.0, 1.0 / 3.0, 1.0 / 2.0, 1.0,
                2.0, 3.0, 4.0, 5.0 };
        // w, x ,y, and z are the four personal numbers being used in the formula
        double mu = getPositiveDouble(in, out);
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        double a = 0, b = 0, c = 0, d = 0;
        int i = 0;

        double estimation = 0;
        double finalEstimation = 0;

        final double oneHundred = 100;
        // these while loops help find the best approximation
        while (i < arr.length) {
            int j = 0;

            while (j < arr.length) {
                int k = 0;

                while (k < arr.length) {
                    int l = 0;

                    while (l < arr.length) {
                        estimation = Math.pow(w, arr[i]) * Math.pow(x, arr[j])
                                * Math.pow(y, arr[k]) * Math.pow(z, arr[l]);
                        if (((Math.abs(estimation - mu)) < (Math
                                .abs(finalEstimation - mu)))) {
                            finalEstimation = estimation;

                            a = arr[i];
                            b = arr[j];
                            c = arr[k];
                            d = arr[l];
                        }
                        l++;
                    }
                    k++;
                }
                j++;
            }
            i++;
        }

        out.println("The best values for the exponenets are: ");

        out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d);

        double hypValues = (Math.abs(finalEstimation - mu)) / finalEstimation
                * oneHundred;

        out.println("Best approximation : ");
        out.println(finalEstimation);

        out.print("Relative error: ");
        out.print(hypValues, 2, false);
        out.println("%");

        out.print("mu:");
        out.println(mu);

        // close input and output streams
        in.close();
        out.close();

    }

}
