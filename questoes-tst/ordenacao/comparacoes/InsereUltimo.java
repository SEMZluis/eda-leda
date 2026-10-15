import java.util.Arrays;
import java.util.Scanner;

public class InsereUltimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] sequencia = new int[entrada.length];
        
        for(int i = 0; i < entrada.length; i++) {
            sequencia[i] = Integer.parseInt(entrada[i]);
        }
        
        int n = sequencia[sequencia.length-1];

        for (int i = sequencia.length-1; i >= 1; i--) {
            int iAnterior = i - 1;
            if (sequencia[i] < sequencia[iAnterior]) {
                int aux = sequencia[i];
                sequencia[i] = sequencia[iAnterior];
                sequencia[iAnterior] = aux;
            }

        }

        System.out.println(Arrays.toString(sequencia));
    }
}