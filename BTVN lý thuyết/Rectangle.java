import java.util.*; 
public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        long perimeter = (a + b) * 2;
        long area = a * b;

        // Output 
        System.out.println(perimeter + " " + area);
        
        scanner.close();
    }
}
