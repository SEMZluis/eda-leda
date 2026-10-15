import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] A = new int[entrada.length];
        int k = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(entrada[i]);
        }

        int[] C = new int[k+1];

        // freq
        for (int i = 0; i < A.length; i++) {
            C[A[i]] += 1;
            System.out.println(Arrays.toString(C).replace(",", "").replace("[", "").replace("]", ""));
        }

        //cumulativa
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }
        System.out.println("Cumulativa do vetor de contagem - "+Arrays.toString(C).replace(",", "").replace("[", "").replace("]", ""));

        int[] B = new int[A.length];

        //itera de trás pra frente
        for (int i = A.length-1; i >= 0; i--) {
            B[C[A[i]]-1] = A[i];
            C[A[i]] -= 1;
        }

        System.out.println(Arrays.toString(C).replace(",", "").replace("[", "").replace("]", ""));
        System.out.println(Arrays.toString(B).replace(",", "").replace("[", "").replace("]", ""));

    }
}