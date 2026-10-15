import java.util.Arrays;
import java.util.Scanner;

public class MergeSortPassoAPasso {

    public static void merge(int[] v, int ini, int fim) {
        int janela = fim - ini;
        int[] auxiliar = retornaAuxiliar(v, ini, fim);

        int meio = janela/2;

        int i = 0;
        int j = meio+1;
        int k = ini;

        while (i <= meio && j <= janela) {

            if (auxiliar[i] <= auxiliar[j]) {
                v[k] = auxiliar[i];
                i++;
            } else {
                v[k] = auxiliar[j];
                j++;
            }

            k++;
        }

        while (i <= meio) {
            v[k] = auxiliar[i];
            i++;
            k++;
        }

        // System.out.println(Arrays.toString(auxiliar));
    }

    public static void mergeSort(int[] v, int ini, int fim) {
        System.out.println(Arrays.toString(retornaAuxiliar(v, ini, fim)));

        if (fim <= ini) {
            return;
        }

        int meio = (ini+fim)/2;

        mergeSort(v, ini, meio);
        mergeSort(v, meio+1, fim);
        merge(v, ini, fim);
        System.out.println(Arrays.toString(retornaAuxiliar(v, ini, fim)));
    }

    private static int[] retornaAuxiliar(int[] v, int ini, int fim) {
        int janela = fim - ini;
        int[] auxiliar = new int[janela+1];
        for (int i = 0; i <= janela; i++) {
            auxiliar[i] = v[i+ini];
        }
        return auxiliar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] sequencia = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++) {
            sequencia[i] = Integer.parseInt(entrada[i]);
        }

        mergeSort(sequencia, 0, sequencia.length-1);
        // System.out.println(Arrays.toString(sequencia));


    }

}