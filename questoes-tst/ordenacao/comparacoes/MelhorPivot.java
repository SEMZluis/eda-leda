import java.util.Scanner;

public class MelhorPivot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] sequencia = new int[entrada.length];
        String[] posicoes = sc.nextLine().split(" ");
        int posI = Integer.parseInt(posicoes[0]);
        int posJ = Integer.parseInt(posicoes[1]);
        int antesDeI = 0;
        int antesDeJ = 0;

        for (int i = 0; i < entrada.length; i++) {
            sequencia[i] = Integer.parseInt(entrada[i]);
            if (sequencia[i] < sequencia[posI]) {
                antesDeI++;
            }
            if (sequencia[i] < sequencia[posJ]) {
                antesDeJ++;
            }
        }

        int meio = entrada.length/2;

        if (Math.abs(antesDeJ - meio) < Math.abs(antesDeI - meio)) {
            System.out.println(posJ);
        } else {
            System.out.println(posI);
        }

    }
}