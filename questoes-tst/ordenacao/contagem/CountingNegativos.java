import java.util.Arrays;
import java.util.Scanner;

public class CountingNegativos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int maior = Integer.parseInt(sc.nextLine());
        int menor = Integer.parseInt(sc.nextLine());
        
        int[] A = new int[entrada.length];

        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(entrada[i]);
        }

        int[] C = new int[(maior - menor)+1];

        // Cálculo da frequência
        for (int i = 0; i < A.length; i++) {
            C[A[i] - menor] += 1;
            System.out.println(Arrays.toString(C));
        }

        // Soma cumulativa
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }

        System.out.println("Cumulativa do vetor de contagem - "+Arrays.toString(C));

        int[] B = new int[A.length];

        // Saída ordenada
        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i] - menor] - 1] = A[i];
            C[A[i] - menor] -= 1;
        }

        System.out.println(Arrays.toString(C));
        System.out.println(Arrays.toString(B));
    }
}
