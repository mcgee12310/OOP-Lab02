import java.util.*; 
public class StaffManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int max_sal = scanner.nextInt();
        int default_sal = scanner.nextInt();
        int start = scanner.nextInt();
        int after = scanner.nextInt();

        scanner.nextLine();

        long sum = 0;

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            int birth = scanner.nextInt();
            int year = scanner.nextInt();

            System.out.print(name + " ");
            
            System.out.print(birth + " ");

            System.out.print(year + " ");

            int sal;
            if(year % 5 == 0) sal = default_sal * start + (default_sal * after) * (year / 5 - 1);
            else sal = default_sal * start + (default_sal * after) * (year / 5);
            sal = Math.min(sal, max_sal);
            System.out.print(sal + " ");
            sum += sal;

            scanner.nextLine();
        }

        System.out.print(sum);

        scanner.close();
    }
}
