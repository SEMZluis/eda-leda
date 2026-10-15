import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] sequencia = new int[entrada.length];

        for(int i = 0; i < entrada.length; i++) {
            sequencia[i] = Integer.parseInt(entrada[i]);
        }

        for (int i = 0; i < sequencia.length-1; i++) {
            int iMenor = encontrarMenor(sequencia, i);

            if (iMenor != i) {
                int aux = sequencia[i];
                sequencia[i] = sequencia[iMenor];
                sequencia[iMenor] = aux;

                System.out.println(Arrays.toString(sequencia));
            }
        }

        
    }

    private static int encontrarMenor(int[] sequencia, int i) {
        int menor = sequencia[i];
        int iMenor = i;
        for (int j = i; j < sequencia.length; j++) {
            if (sequencia[j] < menor) {
                menor = sequencia[j];
                iMenor = j;
            }
        }

        return iMenor;
    }
}