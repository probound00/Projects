import components.random.Random1L;
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
     * Put a short phrase describing the static method myMethod here.
     */
    private static int numberOfPointsInCircle(int n) {
        int count = 0;
        int ptsScored = 0;

        Random rnd = new Random1L();

        while (count < n) {
            count++;
            if (pointIsInCircle(rnd.nextDouble(), rnd.nextDouble())) {
                ptsScored++;
            }
        }
        return ptsScored;
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
        output.print("Points Scored: ");
        int n = in.nextInteger();

        int ptsScored = numberOfPointsInCircle(n);

        double area = ((double) count / n) * SQUARE_AREA;
        out.println("Area: " + area);
        in.close();
        out.close();
    }

}
