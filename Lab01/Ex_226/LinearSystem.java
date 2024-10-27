package Ex_226;

import java.util.Scanner;

public class LinearSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a11: ");
        double a11 = scanner.nextDouble();
        
        System.out.print("Enter a12: ");
        double a12 = scanner.nextDouble();
        
        System.out.print("Enter a21: ");
        double a21 = scanner.nextDouble();
        
        System.out.print("Enter a22: ");
        double a22 = scanner.nextDouble();
        
        System.out.print("Enter b1: ");
        double b1 = scanner.nextDouble();
        
        System.out.print("Enter b2: ");
        double b2 = scanner.nextDouble();

        double d = a11 * a22 - a21 * a12;
        double d1 = b1 * a22 - b2 * a12;
        double d2 = a11 * b2 - a21 * b1;

        // Kiểm tra giá trị của D
        if (d != 0) {
            double x1 = d1 / d;
            double x2 = d2 / d;
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else {
            if (d1 == 0 && d2 == 0) {
                System.out.println("vo so nghiem");
            } else {
                System.out.println("vo nghiem");
            }
        }
        scanner.close();
    }
}
