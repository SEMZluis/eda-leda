import java.util.Scanner;

public class VetorCircular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] valores = sc.nextLine().split(" ");
        int tam = Integer.parseInt(sc.nextLine());
        String resultado = valores[0];

        int i = 1;
        int c = 1;
        while (c < tam) {
            if (i >= valores.length) i = 0;
            resultado += " "+valores[i];
            i++;
            c++;
        }

        System.out.println(resultado);
    }
}
