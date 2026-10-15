import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {

    public static void countingSort(int A[], int casa) {
        int[] C = new int[10];

        // Frequência
        for (int i = 0; i < A.length; i++) {
            int index = (A[i]/casa) % 10;
            C[index] += 1;
        }

        // Cumulativa
        for (int i = 1; i < 10; i++) {
            C[i] += C[i-1];
        }

        int[] B = new int[A.length];

        // Saída ordenada
        for (int i = A.length - 1; i >= 0; i--) {
            int index = (A[i]/casa)  % 10;
            B[C[index] - 1] = A[i];
            C[index] -= 1;
        }

        for (int i = 0; i < B.length; i++) {
            A[i] = B[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] sequencia = new int[entrada.length];
        int d = Integer.parseInt(sc.nextLine());
        int casa = Math.powExact(10, d-1);

        for (int i = 0; i < entrada.length; i++) {
            sequencia[i] = Integer.parseInt(entrada[i]);
        }       

        for (int i = 0; i < d; i++) {
            countingSort(sequencia, casa);
            casa *= 10;
            System.out.println(Arrays.toString(sequencia));
        }
    }
}
