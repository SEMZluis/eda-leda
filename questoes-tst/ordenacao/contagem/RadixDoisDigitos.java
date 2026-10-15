import java.util.Arrays;
import java.util.Scanner;

public class RadixDoisDigitos {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] entrada = sc.nextLine().split(" ");
        int[] A = new int[entrada.length];

        int d = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < entrada.length; i++) {
            A[i] = Integer.parseInt(entrada[i]);
        }

        
        for (int i = 2; i <= d; i += 2) {
            int[] C = new int[100];
            int[] B = new int[A.length];

            int digito;
            for (int j = 0; j < A.length; j++) {
                digito = (int) (A[j] % Math.pow(10, i));
                digito = (int) (digito / Math.pow(10, i-2));

                C[digito] += 1;
            }

            for (int j = 1; j < C.length; j++) {
                C[j] += C[j-1];
            }

            for (int j = A.length-1; j >= 0; j--) {
                digito = (int) (A[j] % Math.pow(10, i));
                digito = (int) (digito / Math.pow(10, i-2));

                B[C[digito] - 1] = A[j];
                C[digito] -= 1;
            }

            for (int j = 0; j < A.length; j++) {
                A[j] = B[j];
            }

            System.out.println(Arrays.toString(A));
        }
    }
}