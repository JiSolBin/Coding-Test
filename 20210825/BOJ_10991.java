import java.util.Scanner;

public class BOJ_10991 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int i=1; i<=N; i++){
            for(int j=0; j<N-i; j++)
                System.out.print(" ");
            for(int k=0; k<i; k++){
                System.out.print("*");
                if(k != i-1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
