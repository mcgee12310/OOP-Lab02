package Lab01;

import java.util.Arrays;
import java.util.Scanner;

public class SortArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input your arrays (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        
        double[] array;
        
        if (choice.equals("yes")) {
 
            System.out.print("n = ");
            int n = scanner.nextInt();
            array = new double[n];
            
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextDouble();
            }
        } else {
            array = new double[]{1789, 2035, 1899, 1456, 2013};
        }

        Arrays.sort(array);
        System.out.println("Sorted arrays: " + Arrays.toString(array));
        
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        
        double average = sum / array.length;
        
        System.out.printf("Sum: %.2f\n", sum);
        System.out.printf("Average: %.2f\n", average);
        
        scanner.close();
    }
}
