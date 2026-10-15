import java.util.Arrays;
import java.util.Scanner;

public class InserePrimeiro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] sequencia = new int[entrada.length];

        for(int i = 0; i < sequencia.length; i++) {
            sequencia[i] = Integer.parseInt(entrada[i]);
        }

        for (int i = 0; i < sequencia.length - 1; i++) {
            if (sequencia[i] > sequencia[i+1]) {
                int aux = sequencia[i];
                sequencia[i] = sequencia[i+1];
                sequencia[i+1] = aux;
            } else {
                break;
            }
        }

        System.out.println(Arrays.toString(sequencia));

    }
}