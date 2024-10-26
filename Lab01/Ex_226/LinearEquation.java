package Ex_226;
import javax.swing.JOptionPane; 

public class LinearEquation {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null,
            "Please input a: ","Input ax + b = 0", 
            JOptionPane. INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,
            "Please input b: ","Input ax + b = 0", 
            JOptionPane. INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        if (num1 != 0) {
            double x = -num2 / num1;
            System.out.println("x = " + x);
        } else {
            System.out.println("Cannot solve.");
        }
    }
}
