package Ex_226;

import java.util.Scanner;

public class SecondDegreeEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();
        
        if (a == 0) {
            if (b != 0) {
                double x = -b / c;
                System.out.println("x = " + x);
            } else {
                System.out.println("vo nghiem");
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("x = " + x);
            } else {
                System.out.println("vo nghiem");
            }
        }

        scanner.close();
    }
}
