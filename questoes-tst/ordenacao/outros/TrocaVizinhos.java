import java.util.Arrays;
import java.util.Scanner;

public class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split(" ");

        for (int i = 0; i < tokens.length - 1; i += 2) {
            String aux = tokens[i];
            tokens[i] = tokens[i+1];
            tokens[i+1] = aux;
        }

        System.out.println(Arrays.toString(tokens));
    }
}
