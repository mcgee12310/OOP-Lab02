import java.util.Scanner;

public class C_k_n {

    // The array to store the binomial coefficients
    public static int[][] numbers = new int[1000][1000];

    // Modulo value as 10^9 + 7
    public static final int MOD = 1000000007;

    // Function to initialize the binomial coefficients
    static void init() {
        // Initialize Pascal's Triangle for binomial coefficients
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j <= i; j++) {
                // Base cases for Pascal's triangle
                if (j == 0 || j == i) {
                    numbers[i][j] = 1;
                } else {
                    // Recursive formula to calculate binomial coefficients
                    numbers[i][j] = (numbers[i - 1][j - 1] + numbers[i - 1][j]) % MOD;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the values of n and k
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        // Initialize binomial coefficients
        init();

        // Output the binomial coefficient C(n, k)
        System.out.println(numbers[n][k]);

        scanner.close();
    }
}
