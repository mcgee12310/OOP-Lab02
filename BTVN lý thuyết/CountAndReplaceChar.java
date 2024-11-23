import java.util.*; 
public class CountAndReplaceChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String a = scanner.nextLine();
        char[] arr = a.toCharArray();

        char char1 = scanner.nextLine().charAt(0);

        char char2 = scanner.nextLine().charAt(0);

        int cnt = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == char1) cnt++;
        }

        String replacedString = a.replace(char1, char2);

        System.out.print(cnt + " " + replacedString);

        scanner.close();
    }
}
