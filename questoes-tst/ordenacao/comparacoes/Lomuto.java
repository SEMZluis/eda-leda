import java.util.Arrays;
import java.util.Scanner;

public class Lomuto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] sequencia = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++) {
            sequencia[i] = Integer.parseInt(entrada[i]);
        }

        int pivo = sequencia.length - 1;
        int i = sequencia.length - 1;
        int j = sequencia.length - 2;

        while (j >= 0) {
            if (sequencia[j] > sequencia[pivo]) {
                i--;
                int aux = sequencia[i];
                sequencia[i] = sequencia[j];
                sequencia[j] = aux;
                System.out.println(Arrays.toString(sequencia));
            }
            j--;
        }

        int aux = sequencia[i];
        sequencia[i] = sequencia[sequencia.length-1];
        sequencia[sequencia.length-1] = aux;
        System.out.println(Arrays.toString(sequencia));

        System.out.println(Arrays.toString(sequencia));
    }
}
