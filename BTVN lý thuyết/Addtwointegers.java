import java.util.*; 
import java.math.BigInteger;

public class Addtwointegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read two large integers a and b
        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();

        // Compute the sum
        BigInteger sum = a.add(b);

        // Output the sum
        System.out.println(sum);

        // Close the scanner
        scanner.close();
    }
}
