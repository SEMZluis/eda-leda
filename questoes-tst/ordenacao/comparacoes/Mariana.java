import java.util.Arrays;
import java.util.Scanner;

public class Mariana {

    public static void insereOrdenado(String[] livros, int ini) {
        for (int i = ini; i > 0; i--) {
            if (livros[i].compareTo(livros[i-1]) > 0) return;
            String aux = livros[i];
            livros[i] = livros[i-1];
            livros[i-1] = aux;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] livros = sc.nextLine().split(",");

        for (int i = 0; i < livros.length; i++) {
            insereOrdenado(livros, i);

            String out = livros[0];

            for (int j = 1; j < livros.length; j++) {
                out += ", "+livros[j];
            }

            System.out.println(out);
        }
    }
}
