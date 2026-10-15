import java.util.Arrays;
import java.util.Scanner;

public class InsertionSorteRecursivo {

    public static void insereOrdenado(int[] sequencia, int iAtual) {
        while (iAtual > 0 && sequencia[iAtual] < sequencia[iAtual-1]) {
            int aux = sequencia[iAtual];
            sequencia[iAtual] = sequencia[iAtual-1];
            sequencia[iAtual-1] = aux;

            iAtual--;
        }
    
        System.out.println(Arrays.toString(sequencia));
    }

    public static void insereRecursivo(int[] sequencia, int iOrdenado) {
        if (iOrdenado >= sequencia.length) return;
        insereOrdenado(sequencia, iOrdenado);
        iOrdenado++;
        insereRecursivo(sequencia, iOrdenado);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] sequencia = new int[entrada.length];

        for(int i = 0; i < sequencia.length; i++) {
            sequencia[i] = Integer.parseInt(entrada[i]);
        }

        insereRecursivo(sequencia, 1);
    }
}
