import java.util.*; 
public class ConcatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String a = scanner.nextLine();

        n = scanner.nextInt();
        scanner.nextLine();

        String b = scanner.nextLine();

        n = scanner.nextInt(); 
        for(int i=0; i<n; i++){
            System.out.print(a);
        }

        n = scanner.nextInt(); 
        for(int i=0; i<n; i++){
            System.out.print(b);
        }

        scanner.close();
    }
}
