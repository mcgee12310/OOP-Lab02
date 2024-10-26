import java.util.*;

public class PermutationGeneration {

    public static int n;
    public static int[] numbers;

    static void print(){
        for(int i = 0; i < n; i++) System.out.print(numbers[i] + " ");
        System.out.println("");
    }

    static boolean check(int idx, int k){
        for(int i = 0; i < idx; i++){
            if(numbers[i] == k) return false;
        }
        return true;
    }

    static void Try(int idx){
        if(idx == n){
            print();
            return;
        }

        for(int k = 1; k <= n; k++){
            if(check(idx, k)){
                numbers[idx] = k;
                Try(idx + 1);
                numbers[idx] = 0;
            }
        }
    }    

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        numbers = new int[n];
        Arrays.fill(numbers, 0);

        Try(0);

        scanner.close();
    }
}