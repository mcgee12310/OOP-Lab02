package Ex_225;
import javax.swing.JOptionPane; 
public class CalculateTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null,
            "Please input the first number: ","Input the first number", 
            JOptionPane. INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,
            "Please input the second number: ","Input the second number", 
            JOptionPane. INFORMATION_MESSAGE);
        
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        
        // Calculate and print the sum
        double sum = num1 + num2;
        System.out.println("Sum: " + sum);
        
        // Calculate and print the difference
        double difference = num1 - num2;
        System.out.println("Difference: " + difference);
        
        // Calculate and print the product
        double product = num1 * num2;
        System.out.println("Product: " + product);
        
        // Check if the divisor (num2) is zero before dividing
        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("Quotient: " + quotient);
        } else {
            System.out.println("Cannot divide by zero.");
        }
    }
}