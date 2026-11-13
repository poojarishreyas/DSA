import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // code here
        for(int i=n;i>0;i--){
            for(int j=1;j<=n-i;j++ ) System.out.print(" ");
            for(int j=1;j<=2*i-1;j++) System.out.print("*");
            System.out.println();
        }
    }
}