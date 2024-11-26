import java.util.*; 
public class StringMatching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a_length = scanner.nextInt();
        scanner.nextLine();

        String a = scanner.nextLine();
        char[] arr = a.toCharArray();

        int b_length = scanner.nextInt();
        scanner.nextLine();

        String b = scanner.nextLine();
        char[] brr = b.toCharArray();

        for(int i=0; i <= a_length - b_length; i++){
            if(arr[i] == brr[0]){
                for(int j = 0, k = i; j < b_length; j++, k++){
                    if(arr[k] == brr[j]);
                    else break;
                    if(j == b_length-1) System.out.print(i + " ");
                }
            }
        }

        scanner.close();
    }
}
