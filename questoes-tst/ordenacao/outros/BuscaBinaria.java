import java.util.Arrays;
import java.util.Scanner;

public class BuscaBinaria {

    // public static int buscaNum(int[] arr, int ini, int fim, int n) {
    //     if (fim <= ini) return -1;
        
    //     int meio = (ini+fim)/2;

    //     if (arr[meio] == n) return meio;

    //     if (arr[meio] < n) return buscaNum(arr, meio+1, fim, n);
    //     else return buscaNum(arr, ini, meio, n);
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] sequencia = new int[entrada.length];
        int n = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < entrada.length; i++) {
            sequencia[i] = Integer.parseInt(entrada[i]);
        }

        int ini = 0;
        int fim = sequencia.length-1;
        int meio = fim/2;

        while (fim >= ini) {
            System.out.println(meio);
            
            if (sequencia[meio] == n) {
                break;
            }

            if (sequencia[meio] > n) fim = meio-1;
            else ini = meio+1;
            
            meio = (fim+ini)/2;
        }

        if (fim < ini) System.out.println(-1);
    
        // System.out.println(buscaNum(sequencia, 0, sequencia.length, n));

    }
}
