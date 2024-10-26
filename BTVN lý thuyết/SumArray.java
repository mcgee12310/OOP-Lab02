import java.util.*; 
public class SumArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the sequence
        int n = scanner.nextInt();

        // Initialize sum variable
        long sum = 0;

        // Read the sequence and compute the sum
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            sum += num;
        }

        // Output the sum
        System.out.println(sum);

        // Close the scanner
        scanner.close();
    }
}
