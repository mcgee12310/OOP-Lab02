package Lab01;

import java.util.Arrays;
import java.util.Scanner;

public class AddMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input your matrices (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        
        if (choice.equals("yes")) {
        	
        	System.out.print("rows = ");
            int rows = scanner.nextInt();
            System.out.print("columns = ");
            int cols = scanner.nextInt();
            
            double[][] A = new double[rows][cols];
            double[][] B = new double[rows][cols];
            double[][] sum = new double[rows][cols];

            System.out.println("Nhap ma tran A: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("A["+ i +"]["+ j +"]= ");
                    A[i][j] = scanner.nextDouble();
                }
            }

            System.out.println("Enter elements for Matrix B:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("B["+ i +"]["+ j +"]= ");
                    B[i][j] = scanner.nextDouble();
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sum[i][j] = A[i][j] + B[i][j];
                }
            }
            
            System.out.println("A + B = ");
            for (double[] row : sum) {
                for (double element : row) {
                    System.out.printf("%.2f ", element);
                }
                System.out.println();
            }
            
        }
        else {
            
            System.out.println("A = ");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                	System.out.printf("1 ");
                }
                System.out.println();
            }
            
            System.out.println("B = ");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                	System.out.printf("3 ");
                }
                System.out.println();
            }

            System.out.println("A + B = ");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                	System.out.printf("4 ");
                }
                System.out.println();
            }
    }

        scanner.close();
    }
}
